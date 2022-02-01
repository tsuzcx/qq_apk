package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bm.g;
import com.tencent.mm.compatible.i.a.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bq;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class o
  extends Thread
{
  private static int iWt;
  private static HashMap<String, b> usO;
  private static Object usP;
  private static QueueWorkerThread usQ;
  private int[] Azu;
  private int QVl;
  private o.a QVm;
  private Context context;
  private Intent intent;
  private boolean isStop;
  private String talker;
  private List<String> usE;
  private List<Integer> usF;
  private List<String> usG;
  private List<String> usH;
  private List<Integer> usI;
  
  static
  {
    AppMethodBeat.i(127169);
    usO = new HashMap();
    usP = new byte[0];
    AppMethodBeat.o(127169);
  }
  
  public o(Context paramContext, List<String> paramList, Intent paramIntent, String paramString, int paramInt, o.a parama)
  {
    AppMethodBeat.i(127144);
    this.Azu = new int[29];
    this.context = paramContext;
    this.usE = paramList;
    this.intent = paramIntent;
    this.usF = new ArrayList();
    this.usG = new ArrayList();
    this.usH = new ArrayList();
    this.usI = new ArrayList();
    this.QVm = parama;
    this.talker = paramString;
    this.QVl = paramInt;
    AppMethodBeat.o(127144);
  }
  
  private void DN(boolean paramBoolean)
  {
    AppMethodBeat.i(127158);
    int i;
    if (this.QVl == 1) {
      if (paramBoolean) {
        i = 217;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + paramBoolean + " importType : " + this.QVl);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127158);
      return;
      i = 218;
      continue;
      if (paramBoolean) {
        i = 231;
      } else {
        i = 232;
      }
    }
  }
  
  private VideoTransPara a(String paramString, PInt paramPInt)
  {
    AppMethodBeat.i(127157);
    if (com.tencent.mm.modelcontrol.e.bkp().VE(paramString))
    {
      Log.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[] { paramString });
      paramPInt.value = 1;
      hgX();
      AppMethodBeat.o(127157);
      return null;
    }
    Object localObject2 = com.tencent.mm.bm.e.Yu(paramString);
    Object localObject1 = Boolean.valueOf(com.tencent.mm.bm.e.Yt(paramString));
    Log.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", new Object[] { localObject2 });
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.bkp().c((VideoTransPara)localObject2);
    if (localVideoTransPara == null)
    {
      Log.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", new Object[] { localObject2 });
      paramPInt.value = -5;
      AppMethodBeat.o(127157);
      return null;
    }
    Log.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", new Object[] { localVideoTransPara });
    int[] arrayOfInt = a(paramString, localVideoTransPara);
    localVideoTransPara.videoBitrate = arrayOfInt[0];
    localVideoTransPara.width = arrayOfInt[1];
    localVideoTransPara.height = arrayOfInt[2];
    if ((((VideoTransPara)localObject2).videoBitrate <= 640000) || (localVideoTransPara.videoBitrate > ((VideoTransPara)localObject2).videoBitrate))
    {
      Log.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", new Object[] { localVideoTransPara, localObject2 });
      if (((Boolean)localObject1).booleanValue())
      {
        paramPInt.value = 0;
        AppMethodBeat.o(127157);
        return localObject2;
      }
      paramPInt.value = 1;
      AppMethodBeat.o(127157);
      return null;
    }
    int i = ((VideoTransPara)localObject2).duration;
    localObject2 = com.tencent.mm.n.a.jwk;
    if (i * 1000 >= com.tencent.mm.n.a.awa() * 1000)
    {
      paramPInt.value = -6;
      AppMethodBeat.o(127157);
      return null;
    }
    if (((Boolean)localObject1).booleanValue())
    {
      paramPInt.value = 0;
      AppMethodBeat.o(127157);
      return localVideoTransPara;
    }
    boolean bool = NetStatusUtil.is2G(MMApplicationContext.getContext());
    int j = localVideoTransPara.width;
    int k = localVideoTransPara.height;
    if (bool)
    {
      i = 10485760;
      label342:
      if (!bool) {
        break label379;
      }
    }
    for (double d = 60000.0D;; d = com.tencent.mm.n.a.awa() * 1000)
    {
      paramPInt.value = SightVideoJNI.shouldRemuxingVFS(paramString, j, k, i, d, 1000000);
      break;
      i = ad.hhm();
      break label342;
      label379:
      localObject1 = com.tencent.mm.n.a.jwk;
    }
  }
  
  private void a(int paramInt1, String paramString1, String arg3, int paramInt2, VideoTransPara paramVideoTransPara, Intent paramIntent)
  {
    AppMethodBeat.i(127148);
    Log.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", new Object[] { ???, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    d(paramInt1, paramString1, ???, paramInt2);
    if (paramInt1 == -50002)
    {
      hgU();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 141);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 == -50008)
    {
      hgW();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 140);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 == -50006)
    {
      b localb = new b((byte)0);
      synchronized (usP)
      {
        usO.put(paramString1, localb);
        if (y.u(paramString1, this.talker, ???) >= 0L) {
          break label242;
        }
        a(this.talker, paramString1, ???, paramIntent, paramInt2, 142);
        Log.e("MicroMsg.ImportMultiVideo", "prepare");
      }
      synchronized (usP)
      {
        usO.remove(paramString1);
        AppMethodBeat.o(127148);
        return;
        paramString1 = finally;
        AppMethodBeat.o(127148);
        throw paramString1;
      }
      label242:
      if (usQ == null) {
        usQ = new QueueWorkerThread(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
      }
      localb.fileName = paramString1;
      localb.mfq = ???;
      s.bqB();
      localb.oxH = x.XT(paramString1);
      localb.QVl = this.QVl;
      localb.toUser = this.talker;
      localb.mhG = paramVideoTransPara;
      localb.Azu = this.Azu;
      b.a(localb, com.tencent.mm.bm.e.Yt(???));
      localb.QVo = new g();
      usQ.add(localb);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 < 0)
    {
      hgV();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 142);
      AppMethodBeat.o(127148);
      return;
    }
    y.c(paramString1, paramInt2, this.talker, ???);
    y.Yd(paramString1);
    if (this.QVl == 1) {}
    for (paramInt1 = 8;; paramInt1 = 1)
    {
      s.bqB();
      paramString1 = x.XT(paramString1);
      r.bqz().a(???, paramString1, this.talker, "", "", paramInt1, 2);
      AppMethodBeat.o(127148);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127149);
    Object localObject = new ca();
    ((ca)localObject).setStatus(5);
    ((ca)localObject).Jm(paramString1);
    ((ca)localObject).setCreateTime(bq.RP(paramString1));
    ((ca)localObject).pJ(1);
    ((ca)localObject).Jn(paramString2);
    ((ca)localObject).setType(43);
    long l = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM((ca)localObject);
    Log.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((et)localObject).field_msgId), Long.valueOf(((et)localObject).field_msgSvrId), ((et)localObject).field_talker, Integer.valueOf(((ca)localObject).getType()), Integer.valueOf(((et)localObject).field_isSend), ((et)localObject).field_imgPath, Integer.valueOf(((et)localObject).field_status), Long.valueOf(((et)localObject).field_createTime) });
    if (-1L == l)
    {
      Log.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", new Object[] { paramString1 });
      AppMethodBeat.o(127149);
      return;
    }
    if (y.Yk(paramString2) == null)
    {
      s.bqB();
      localObject = x.XU(paramString2);
      i = paramInt1;
    }
    for (;;)
    {
      try
      {
        paramIntent = com.tencent.mm.compatible.i.a.j(this.context, paramIntent);
        if (paramIntent == null) {
          continue;
        }
        i = paramInt1;
        if (paramIntent.bitmap == null) {
          continue;
        }
        i = paramInt1;
        paramInt1 = Util.videoMsToSec(paramIntent.duration);
        i = paramInt1;
        BitmapUtil.saveBitmapToImage(paramIntent.bitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
      }
      catch (Exception paramIntent)
      {
        int j;
        Log.printErrStackTrace("MicroMsg.ImportMultiVideo", paramIntent, "", new Object[0]);
        paramInt1 = i;
        continue;
        i = 0;
        continue;
      }
      j = x.XV((String)localObject);
      s.bqB();
      i = x.XV(x.XT(paramString2));
      paramIntent = new w();
      paramIntent.fileName = paramString2;
      if (i <= 0) {
        continue;
      }
      paramIntent.lAW = i;
      paramIntent.mhO = j;
      paramIntent.lvw = paramInt1;
      paramIntent.fPV = paramString1;
      paramIntent.mhK = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, ""));
      paramIntent.createTime = Util.nowSecond();
      paramIntent.mhP = Util.nowSecond();
      paramIntent.mhW = null;
      paramIntent.mfq = paramString3;
      if (!Util.isNullOrNil(paramString3)) {
        paramIntent.mhU = 1;
      }
      paramIntent.mhX = -1;
      paramIntent.status = paramInt2;
      paramIntent.mhR = ((int)l);
      if (!s.bqB().b(paramIntent)) {
        Log.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", new Object[] { Long.valueOf(l) });
      }
      AppMethodBeat.o(127149);
      return;
      i = paramInt1;
      BitmapUtil.saveBitmapToImage(BitmapUtil.createColorBitmap(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
    }
  }
  
  private int[] a(String paramString, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(215984);
    Object localObject = p.QVp;
    if (p.hgZ()) {
      paramVideoTransPara.lJF = 1;
    }
    localObject = new int[3];
    Object tmp26_25 = localObject;
    tmp26_25[0] = 0;
    Object tmp30_26 = tmp26_25;
    tmp30_26[1] = 0;
    Object tmp34_30 = tmp30_26;
    tmp34_30[2] = 0;
    tmp34_30;
    localObject[0] = paramVideoTransPara.videoBitrate;
    localObject[1] = paramVideoTransPara.width;
    localObject[2] = paramVideoTransPara.height;
    if (((paramVideoTransPara.lJz == 1) || (paramVideoTransPara.lJz == 2)) && ((paramVideoTransPara.lJJ == 2) || (paramVideoTransPara.lJJ == 4) || (paramVideoTransPara.lJJ == 1)))
    {
      this.Azu = AdaptiveAdjustBitrate.a(paramString, paramVideoTransPara.height, paramVideoTransPara.width, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, 10.0F, 0.0F, paramVideoTransPara.lJJ, paramVideoTransPara.lJB, paramVideoTransPara.lJC, paramVideoTransPara.lJD, paramVideoTransPara.lJE, paramVideoTransPara.lJF, paramVideoTransPara.lJG, paramVideoTransPara.lJH, false);
      if (this.Azu != null) {
        localObject[0] = (this.Azu[0] * 1000);
      }
      if (this.Azu[5] > 0)
      {
        localObject[1] = this.Azu[1];
        localObject[2] = this.Azu[2];
      }
      Log.i("MicroMsg.ImportMultiVideo", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(localObject[2]) });
      s.bqC();
      com.tencent.mm.aq.e.s(this.Azu);
      AppMethodBeat.o(215984);
      return localObject;
    }
    Log.i("MicroMsg.ImportMultiVideo", "c2c ABA: No use ABA algorithm");
    AppMethodBeat.o(215984);
    return localObject;
  }
  
  private void aE(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(127146);
    String str1 = x.XS(this.talker);
    s.bqB();
    String str2 = x.XU(str1);
    s.bqB();
    String str3 = x.XT(str1);
    int j = 0;
    VideoTransPara localVideoTransPara = null;
    boolean bool1 = NetStatusUtil.is2G(MMApplicationContext.getContext());
    String str4 = com.tencent.mm.compatible.i.a.i(paramContext, paramIntent);
    if (Util.isNullOrNil(str4))
    {
      Log.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
      a(-50005, str1, str4, 0, null, paramIntent);
      AppMethodBeat.o(127146);
      return;
    }
    boolean bool2 = c.ZZ(str4);
    int k = (int)u.bBQ(str4);
    int i;
    if (bool2)
    {
      Log.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", new Object[] { Boolean.valueOf(bool2) });
      PInt localPInt = new PInt();
      localVideoTransPara = a(str4, localPInt);
      i = localPInt.value;
    }
    for (;;)
    {
      Log.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d config:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(ad.hhm()) });
      switch (i)
      {
      default: 
        Log.e("MicroMsg.ImportMultiVideo", "unknown check type");
        a(-50001, str1, str4, 0, null, paramIntent);
        AppMethodBeat.o(127146);
        return;
        if (bool1) {}
        for (i = 10485760;; i = ad.hhm())
        {
          if (k <= i) {
            break label324;
          }
          i = -5;
          break;
        }
        label324:
        Log.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", new Object[] { Boolean.valueOf(bool2) });
        i = 1;
      }
    }
    if (k > ad.hhm())
    {
      a(-50002, str1, str4, 0, null, paramIntent);
      AppMethodBeat.o(127146);
      return;
    }
    k = 0;
    try
    {
      for (;;)
      {
        paramContext = com.tencent.mm.compatible.i.a.j(paramContext, paramIntent);
        if (paramContext != null) {
          break;
        }
        Log.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
        a(-50005, str1, str4, 0, null, paramIntent);
        AppMethodBeat.o(127146);
        return;
        k = 1;
      }
      a(-50007, str1, str4, 0, null, paramIntent);
      AppMethodBeat.o(127146);
      return;
      a(-50002, str1, str4, 0, null, paramIntent);
      AppMethodBeat.o(127146);
      return;
      a(-50008, str1, str4, 0, null, paramIntent);
      AppMethodBeat.o(127146);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    if (k == 0)
    {
      u.on(str4, str3);
      hj(str3, this.QVl);
      k(false, str4, str3);
      i = j;
    }
    for (;;)
    {
      int n = Util.videoMsToSec(paramContext.duration);
      int m = 1;
      j = 1;
      if (paramContext.bitmap != null) {
        j = m;
      }
      try
      {
        BitmapUtil.saveBitmapToImage(paramContext.bitmap, 60, Bitmap.CompressFormat.JPEG, str2, true);
        j = 0;
        m = 0;
        DN(true);
        j = m;
        if (j == 0) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          DN(false);
          BitmapUtil.saveBitmapToImage(BitmapUtil.createColorBitmap(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, str2, true);
          j = i;
          if (k == 0)
          {
            j = i;
            if (!u.agG(str3)) {
              j = -50003;
            }
          }
          if (!u.agG(str2)) {
            j = -50004;
          }
          a(j, str1, str4, n, localVideoTransPara, paramIntent);
          AppMethodBeat.o(127146);
          return;
          i = -50006;
          continue;
          paramContext = paramContext;
          Log.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
          }
        }
      }
    }
  }
  
  /* Error */
  public static void b(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 736
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 738	com/tencent/mm/compatible/i/d
    //   9: dup
    //   10: invokespecial 739	com/tencent/mm/compatible/i/d:<init>	()V
    //   13: astore 7
    //   15: aload 7
    //   17: aload_0
    //   18: invokevirtual 744	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   21: aload 7
    //   23: bipush 18
    //   25: invokevirtual 748	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   28: iconst_0
    //   29: invokestatic 752	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   32: istore 6
    //   34: aload 7
    //   36: bipush 19
    //   38: invokevirtual 748	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   41: iconst_0
    //   42: invokestatic 752	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   45: istore 5
    //   47: aload_1
    //   48: iconst_0
    //   49: iload 6
    //   51: iastore
    //   52: aload_1
    //   53: iconst_1
    //   54: iload 5
    //   56: iastore
    //   57: iconst_0
    //   58: istore 4
    //   60: iload 4
    //   62: iconst_3
    //   63: if_icmpge +99 -> 162
    //   66: iload 6
    //   68: iconst_2
    //   69: irem
    //   70: ifne +10 -> 80
    //   73: iload 5
    //   75: iconst_2
    //   76: irem
    //   77: ifeq +47 -> 124
    //   80: aload 7
    //   82: invokevirtual 755	android/media/MediaMetadataRetriever:release	()V
    //   85: aload_1
    //   86: iconst_0
    //   87: iaload
    //   88: iconst_2
    //   89: irem
    //   90: ifeq +11 -> 101
    //   93: aload_1
    //   94: iconst_0
    //   95: aload_1
    //   96: iconst_0
    //   97: iaload
    //   98: iconst_1
    //   99: iadd
    //   100: iastore
    //   101: aload_1
    //   102: iconst_1
    //   103: iaload
    //   104: iconst_2
    //   105: irem
    //   106: ifeq +11 -> 117
    //   109: aload_1
    //   110: iconst_1
    //   111: aload_1
    //   112: iconst_1
    //   113: iaload
    //   114: iconst_1
    //   115: iadd
    //   116: iastore
    //   117: ldc_w 736
    //   120: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: return
    //   124: iload 6
    //   126: iload 5
    //   128: if_icmplt +15 -> 143
    //   131: iload 6
    //   133: iload_2
    //   134: if_icmple +28 -> 162
    //   137: iload 5
    //   139: iload_3
    //   140: if_icmple +22 -> 162
    //   143: iload 6
    //   145: iload 5
    //   147: if_icmpgt +69 -> 216
    //   150: iload 6
    //   152: iload_3
    //   153: if_icmple +9 -> 162
    //   156: iload 5
    //   158: iload_2
    //   159: if_icmpgt +57 -> 216
    //   162: aload_1
    //   163: iconst_0
    //   164: iload 6
    //   166: iastore
    //   167: aload_1
    //   168: iconst_1
    //   169: iload 5
    //   171: iastore
    //   172: aload 7
    //   174: invokevirtual 755	android/media/MediaMetadataRetriever:release	()V
    //   177: aload_1
    //   178: iconst_0
    //   179: iaload
    //   180: iconst_2
    //   181: irem
    //   182: ifeq +11 -> 193
    //   185: aload_1
    //   186: iconst_0
    //   187: aload_1
    //   188: iconst_0
    //   189: iaload
    //   190: iconst_1
    //   191: iadd
    //   192: iastore
    //   193: aload_1
    //   194: iconst_1
    //   195: iaload
    //   196: iconst_2
    //   197: irem
    //   198: ifeq +93 -> 291
    //   201: aload_1
    //   202: iconst_1
    //   203: aload_1
    //   204: iconst_1
    //   205: iaload
    //   206: iconst_1
    //   207: iadd
    //   208: iastore
    //   209: ldc_w 736
    //   212: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: return
    //   216: iload 6
    //   218: iconst_2
    //   219: idiv
    //   220: istore 6
    //   222: iload 5
    //   224: iconst_2
    //   225: idiv
    //   226: istore 5
    //   228: iload 4
    //   230: iconst_1
    //   231: iadd
    //   232: istore 4
    //   234: goto -174 -> 60
    //   237: astore_0
    //   238: aconst_null
    //   239: astore 7
    //   241: aload 7
    //   243: ifnull +8 -> 251
    //   246: aload 7
    //   248: invokevirtual 755	android/media/MediaMetadataRetriever:release	()V
    //   251: aload_1
    //   252: iconst_0
    //   253: iaload
    //   254: iconst_2
    //   255: irem
    //   256: ifeq +11 -> 267
    //   259: aload_1
    //   260: iconst_0
    //   261: aload_1
    //   262: iconst_0
    //   263: iaload
    //   264: iconst_1
    //   265: iadd
    //   266: iastore
    //   267: aload_1
    //   268: iconst_1
    //   269: iaload
    //   270: iconst_2
    //   271: irem
    //   272: ifeq +11 -> 283
    //   275: aload_1
    //   276: iconst_1
    //   277: aload_1
    //   278: iconst_1
    //   279: iaload
    //   280: iconst_1
    //   281: iadd
    //   282: iastore
    //   283: ldc_w 736
    //   286: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_0
    //   290: athrow
    //   291: ldc_w 736
    //   294: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: return
    //   298: astore_0
    //   299: goto -58 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramString	String
    //   0	302	1	paramArrayOfInt	int[]
    //   0	302	2	paramInt1	int
    //   0	302	3	paramInt2	int
    //   58	175	4	i	int
    //   45	182	5	j	int
    //   32	189	6	k	int
    //   13	234	7	locald	com.tencent.mm.compatible.i.d
    // Exception table:
    //   from	to	target	type
    //   6	15	237	finally
    //   15	47	298	finally
    //   216	228	298	finally
  }
  
  public static boolean bpH(String paramString)
  {
    AppMethodBeat.i(127155);
    synchronized (usP)
    {
      boolean bool = usO.containsKey(paramString);
      Log.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(127155);
      return bool;
    }
  }
  
  public static void bpI(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127156);
    synchronized (usP)
    {
      if (usO.remove(paramString) != null)
      {
        Log.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(127156);
        return;
      }
      bool = false;
    }
  }
  
  public static void c(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(127150);
    b(paramString, paramArrayOfInt, 640, 480);
    AppMethodBeat.o(127150);
  }
  
  private void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(127153);
      this.usF.add(Integer.valueOf(paramInt1));
      this.usG.add(paramString1);
      this.usH.add(paramString2);
      this.usI.add(Integer.valueOf(paramInt2));
      AppMethodBeat.o(127153);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void f(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(127151);
    try
    {
      locald = new com.tencent.mm.compatible.i.d();
      try
      {
        locald.setDataSource(paramString);
        int i = Util.getInt(locald.extractMetadata(18), 0);
        int j = Util.getInt(locald.extractMetadata(19), 0);
        if (i > j) {
          if (i > 720)
          {
            paramArrayOfInt[0] = 720;
            paramArrayOfInt[1] = (j * 720 / i);
          }
        }
        for (;;)
        {
          locald.release();
          if (paramArrayOfInt[0] % 2 != 0) {
            paramArrayOfInt[0] += 1;
          }
          if (paramArrayOfInt[1] % 2 != 0) {
            paramArrayOfInt[1] += 1;
          }
          Log.i("MicroMsg.ImportMultiVideo", "getImportProperRemuxingResolutionForC2C Width:%d Height:%d", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]) });
          AppMethodBeat.o(127151);
          return;
          if (j > 720)
          {
            paramArrayOfInt[0] = (i * 720 / j);
            paramArrayOfInt[1] = 720;
          }
        }
        if (locald == null) {
          break label184;
        }
      }
      finally {}
    }
    finally
    {
      com.tencent.mm.compatible.i.d locald = null;
    }
    locald.release();
    label184:
    if (paramArrayOfInt[0] % 2 != 0) {
      paramArrayOfInt[0] += 1;
    }
    if (paramArrayOfInt[1] % 2 != 0) {
      paramArrayOfInt[1] += 1;
    }
    Log.i("MicroMsg.ImportMultiVideo", "getImportProperRemuxingResolutionForC2C Width:%d Height:%d", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]) });
    AppMethodBeat.o(127151);
    throw paramString;
  }
  
  public static void hgT()
  {
    AppMethodBeat.i(127154);
    int i;
    synchronized (usP)
    {
      i = usO.size();
      usO.clear();
      if (usQ == null)
      {
        Log.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(127154);
        return;
      }
    }
    Log.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", new Object[] { Integer.valueOf(i), Integer.valueOf(usQ.getQueueSize()) });
    usQ.clear();
    usQ = null;
    AppMethodBeat.o(127154);
  }
  
  private void hgU()
  {
    AppMethodBeat.i(127159);
    if (this.QVl == 1) {}
    for (int i = 230;; i = 245)
    {
      Log.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i + " importType : " + this.QVl);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127159);
      return;
    }
  }
  
  private void hgV()
  {
    AppMethodBeat.i(127160);
    if (this.QVl == 1) {}
    for (int i = 229;; i = 244)
    {
      Log.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i + " importType : " + this.QVl);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127160);
      return;
    }
  }
  
  private static void hgW()
  {
    AppMethodBeat.i(127162);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, 210L, 1L, false);
    AppMethodBeat.o(127162);
  }
  
  private static void hgX()
  {
    AppMethodBeat.i(127163);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 51L, 1L, false);
    AppMethodBeat.o(127163);
  }
  
  private static void hj(String paramString, int paramInt)
  {
    AppMethodBeat.i(127161);
    int j;
    int i;
    if (paramInt == 1)
    {
      j = 220;
      i = 228;
    }
    for (paramInt = 219;; paramInt = 233)
    {
      long l = u.bBQ(paramString);
      i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, j, i));
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, i, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, paramInt, 1L, false);
      Log.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + i + " file len : " + l / 1024L + "K");
      AppMethodBeat.o(127161);
      return;
      j = 234;
      i = 242;
    }
  }
  
  private static void k(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127164);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.modelvideo.a.k(i, paramString1, paramString2);
      AppMethodBeat.o(127164);
      return;
    }
  }
  
  public final void hgS()
  {
    AppMethodBeat.i(127147);
    this.isStop = true;
    interrupt();
    AppMethodBeat.o(127147);
  }
  
  public final void run()
  {
    AppMethodBeat.i(127145);
    int i;
    if ((this.usE != null) && (this.usE.size() > 0)) {
      i = 0;
    }
    while ((i < this.usE.size()) && (!this.isStop))
    {
      Log.i("MicroMsg.ImportMultiVideo", "start to import %s", new Object[] { this.usE.get(i) });
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse("file://" + (String)this.usE.get(i)));
      aE(this.context, localIntent);
      i += 1;
      continue;
      aE(this.context, this.intent);
    }
    if ((this.QVm != null) && (!this.isStop)) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127141);
          o.a locala = o.e(o.this);
          o.a(o.this);
          o.b(o.this);
          o.c(o.this);
          o.d(o.this);
          locala.hgY();
          AppMethodBeat.o(127141);
        }
      });
    }
    AppMethodBeat.o(127145);
  }
  
  static final class b
    implements QueueWorkerThread.ThreadObject
  {
    int[] Azu;
    private boolean FeD = false;
    int QVl;
    g QVo;
    String fileName;
    String mfq;
    VideoTransPara mhG;
    private int outputHeight;
    private int outputWidth;
    String oxH;
    String toUser;
    int usV;
    private boolean usW;
    private int usX = 0;
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(127142);
      int i;
      for (;;)
      {
        synchronized (o.usP)
        {
          if (!o.fdE().containsKey(this.fileName))
          {
            i = 1;
            j = i;
            if (i == 0)
            {
              if (y.Yk(this.fileName) == null) {
                j = 1;
              }
            }
            else
            {
              if (j == 0) {
                break;
              }
              Log.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", new Object[] { this.fileName });
              AppMethodBeat.o(127142);
              return true;
            }
          }
          else
          {
            i = 0;
          }
        }
        j = 0;
      }
      boolean bool1 = WXHardCoderJNI.hcEncodeVideoEnable;
      int j = WXHardCoderJNI.hcEncodeVideoDelay;
      int k = WXHardCoderJNI.hcEncodeVideoCPU;
      int m = WXHardCoderJNI.hcEncodeVideoIO;
      if (WXHardCoderJNI.hcEncodeVideoThr)
      {
        i = Process.myTid();
        o.YX(WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcEncodeVideoTimeout, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo"));
        Log.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(o.fdJ()) });
        if ((this.mhG == null) || (this.mhG.lJx)) {
          break label308;
        }
        this.outputWidth = this.mhG.width;
      }
      Object localObject3;
      for (this.outputHeight = this.mhG.height;; this.outputHeight = ???[1])
      {
        ??? = new PString();
        localObject3 = new PInt();
        if ((!((com.tencent.mm.plugin.s.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.s.a.a.class)).bbT().a(this.mfq, (PString)???, (PInt)localObject3)) || (u.on(((PString)???).value, this.oxH) < 0L)) {
          break label341;
        }
        Log.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
        this.usV = ((PInt)localObject3).value;
        this.usW = true;
        AppMethodBeat.o(127142);
        return true;
        i = 0;
        break;
        label308:
        ??? = new int[2];
        o.f(this.mfq, (int[])???);
        this.outputWidth = ???[0];
      }
      label341:
      long l = Util.currentTicks();
      boolean bool2;
      if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wcz, 0) == 1)
      {
        bool1 = true;
        Log.i("MicroMsg.ImportMultiVideo", "expt enableUseCompositionTranscoder:%s", new Object[] { Boolean.valueOf(bool1) });
        ??? = com.tencent.mm.util.i.YyX;
        bool2 = bool1;
        if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.Yym, 0) == 1)
        {
          Log.i("MicroMsg.ImportMultiVideo", "debug open composition transcoder");
          bool2 = true;
        }
        Log.i("MicroMsg.ImportMultiVideo", "final enableUseCompositionTranscoder:%s", new Object[] { Boolean.valueOf(bool2) });
        bool1 = false;
      }
      try
      {
        ??? = new com.tencent.mm.compatible.i.d();
        ((com.tencent.mm.compatible.i.d)???).setDataSource(this.mfq);
        i = Util.getInt(((com.tencent.mm.compatible.i.d)???).extractMetadata(18), 0);
        j = Util.getInt(((com.tencent.mm.compatible.i.d)???).extractMetadata(19), 0);
        this.usV = Math.round(Util.getInt(((com.tencent.mm.compatible.i.d)???).extractMetadata(9), 0) / 1000.0F);
        bool3 = e.lS(i, j);
        bool1 = bool3;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          boolean bool3;
          Log.printErrStackTrace("MicroMsg.ImportMultiVideo", localException1, "", new Object[0]);
          continue;
          this.usV = SightVideoJNI.remuxingVFS(this.mfq, this.oxH, this.outputWidth, this.outputHeight, this.mhG.videoBitrate, this.mhG.lJn, 8, this.mhG.lJm, 25.0F, this.mhG.fps, null, 0, com.tencent.mm.plugin.sight.base.d.JrG, 0, 51);
          continue;
          Log.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", new Object[] { this.fileName });
          if (com.tencent.mm.plugin.sight.base.d.JrG) {
            com.tencent.mm.plugin.sight.base.d.JrI = (int)(com.tencent.mm.plugin.sight.base.d.JrI * 0.915D);
          }
          if ((this.FeD) || (bool1))
          {
            this.mhG = new VideoTransPara();
            this.mhG.width = this.outputWidth;
            this.mhG.height = this.outputHeight;
            this.mhG.videoBitrate = com.tencent.mm.plugin.sight.base.d.JrI;
            this.mhG.lJn = com.tencent.mm.plugin.sight.base.d.JrH;
            this.mhG.lJm = 2;
            this.mhG.fps = ((int)com.tencent.mm.plugin.sight.base.d.JrJ);
            this.mhG.duration = com.tencent.mm.bm.e.hW(this.mfq);
            com.tencent.mm.bm.e.a(this.mfq, this.oxH, this.mhG);
          }
          else
          {
            this.usV = SightVideoJNI.remuxingVFS(this.mfq, this.oxH, this.outputWidth, this.outputHeight, com.tencent.mm.plugin.sight.base.d.JrI, com.tencent.mm.plugin.sight.base.d.JrH, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.d.JrJ, null, 0, com.tencent.mm.plugin.sight.base.d.JrG, 0, 51);
            continue;
            if (this.mhG == null)
            {
              this.mhG = new VideoTransPara();
              this.mhG.width = this.outputWidth;
              this.mhG.height = this.outputHeight;
              this.mhG.videoBitrate = com.tencent.mm.plugin.sight.base.d.JrI;
              this.mhG.lJn = com.tencent.mm.plugin.sight.base.d.JrH;
              this.mhG.lJm = 2;
              this.mhG.fps = ((int)com.tencent.mm.plugin.sight.base.d.JrJ);
              this.mhG.duration = com.tencent.mm.bm.e.hW(this.mfq);
            }
            for (;;)
            {
              Log.i("MicroMsg.ImportMultiVideo", "use composition transcoder, newPara:%s", new Object[] { this.mhG });
              this.usV = q.d(this.mfq, this.oxH, this.mhG);
              Log.i("MicroMsg.ImportMultiVideo", "transferVideo finished retDuration:%s", new Object[] { Integer.valueOf(this.usV) });
              if (this.usV > 0) {
                break;
              }
              Log.i("MicroMsg.ImportMultiVideo", "composition transcoder failed, fallback to use origin, isH265:%s", new Object[] { Boolean.valueOf(this.FeD) });
              if ((!this.FeD) && (!bool1)) {
                break label1635;
              }
              com.tencent.mm.bm.e.a(this.mfq, this.oxH, this.mhG);
              break;
              this.mhG.width = this.outputWidth;
              this.mhG.height = this.outputHeight;
            }
            this.usV = SightVideoJNI.remuxingVFS(this.mfq, this.oxH, this.outputWidth, this.outputHeight, com.tencent.mm.plugin.sight.base.d.JrI, com.tencent.mm.plugin.sight.base.d.JrH, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.d.JrJ, null, 0, com.tencent.mm.plugin.sight.base.d.JrG, 0, 51);
            continue;
            bool1 = false;
          }
        }
        Log.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
      }
      ??? = p.QVp;
      bool3 = p.hgZ();
      Log.i("MicroMsg.ImportMultiVideo", "remuxing exportHevc:%s", new Object[] { Boolean.valueOf(bool3) });
      if ((!bool3) && (com.tencent.mm.plugin.sight.base.d.JrG)) {
        this.mhG.videoBitrate = ((int)(this.mhG.videoBitrate * 0.915D));
      }
      if (bool3)
      {
        Log.i("MicroMsg.ImportMultiVideo", "exportHevc set forceMediaCodec");
        this.mhG.lJF = 1;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, 101L, 1L, false);
        bool1 = true;
      }
      Log.i("MicroMsg.ImportMultiVideo", "forceMediaCodec :%s", new Object[] { Boolean.valueOf(bool1) });
      if (!bool2) {
        if (this.mhG != null)
        {
          Log.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", new Object[] { this.mhG });
          if (com.tencent.mm.plugin.sight.base.d.JrG) {
            this.mhG.videoBitrate = ((int)(this.mhG.videoBitrate * 0.915D));
          }
          if ((this.FeD) || (bool1))
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 245L, 1L, false);
            this.mhG.width = this.outputWidth;
            this.mhG.height = this.outputHeight;
            if (com.tencent.mm.bm.e.a(this.mfq, this.oxH, this.mhG) < 0) {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 246L, 1L, false);
            }
            this.usX = ((int)Util.ticksToNow(l));
            Log.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d], cost:%s", new Object[] { this.mfq, this.oxH, Integer.valueOf(this.usV), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight), Long.valueOf(Util.ticksToNow(l)) });
            if (this.usV < 0) {
              break label1684;
            }
            bool1 = true;
            this.usW = bool1;
            ??? = new PInt();
            localObject3 = new PInt();
            if ((this.usV <= 0) && (y.a(this.oxH, (PInt)???, (PInt)localObject3))) {
              this.usV = ((PInt)???).value;
            }
            if ((this.usW) && ((((this.mhG.lJA & 0x1) != 0) && (!this.FeD)) || (((this.mhG.lJA & 0x2) != 0) && (this.FeD)) || (this.mhG.lJz == 1)))
            {
              Log.i("MicroMsg.ImportMultiVideo", "hseasun:[hardcoder] hwenc qp add metadata flag", new Object[] { Integer.valueOf(o.fdJ()) });
              SightVideoJNI.addReportMetadata(this.oxH, this.Azu, this.mhG.lJz, this.mhG.lJA);
            }
            if (this.usW) {
              break label1690;
            }
            Log.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
            u.deleteFile(this.oxH);
            u.on(this.mfq, this.oxH);
          }
        }
      }
      label1635:
      PInt localPInt;
      for (;;)
      {
        if (o.fdJ() != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, o.fdJ());
          Log.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformance %s", new Object[] { Integer.valueOf(o.fdJ()) });
          o.YX(0);
        }
        AppMethodBeat.o(127142);
        return true;
        bool1 = false;
        break;
        try
        {
          label1684:
          label1690:
          String str = new com.tencent.mm.vfs.q(this.oxH).getName();
          localObject3 = this.oxH + ".tmp";
          localPInt = new PInt(0);
          if (!com.tencent.mm.plugin.a.e.b(this.oxH, (String)localObject3, localPInt)) {
            break label1929;
          }
          bool1 = u.deleteFile(this.oxH);
          localObject3 = new com.tencent.mm.vfs.q((String)localObject3);
          Log.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(u.bj(((com.tencent.mm.vfs.q)localObject3).ifA() + "/", ((com.tencent.mm.vfs.q)localObject3).getName(), str)), ((com.tencent.mm.vfs.q)localObject3).bOF(), this.oxH });
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 30L, 1L, false);
          ((com.tencent.mm.plugin.s.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.s.a.a.class)).bbT().aB(this.mfq, this.oxH, this.usV);
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", new Object[] { localException2.toString() });
        }
      }
      label1929:
      if (localPInt.value != 1) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 31L, 1L, false);
      }
      for (;;)
      {
        Log.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.mfq, this.oxH });
        break;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 32L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.a(13836, new Object[] { Integer.valueOf(600), Long.valueOf(Util.nowSecond()), this.oxH });
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(127143);
      Log.i("MicroMsg.ImportMultiVideo", "onPostExecute");
      for (;;)
      {
        synchronized (o.usP)
        {
          o.fdE().remove(this.fileName);
          if (this.usW)
          {
            o.hk(this.oxH, this.QVl);
            o.l(this.usW, this.mfq, this.oxH);
            if (!com.tencent.mm.plugin.sight.base.d.JrG) {
              break label204;
            }
            i = 1;
            o.b(i, this.usX, this.mfq, this.oxH, this.usV);
            if (this.QVl != 1) {
              break label209;
            }
            i = 8;
            if (!this.usW) {
              break label214;
            }
            j = 1;
            r.bqz().a(this.mfq, this.oxH, this.toUser, "", "", i, j);
            Log.i("MicroMsg.ImportMultiVideo", "updateVideo");
            y.v(this.fileName, this.usV, 43);
            y.Yd(this.fileName);
            AppMethodBeat.o(127143);
            return false;
          }
        }
        o.hl(this.oxH, this.QVl);
        continue;
        label204:
        int i = 0;
        continue;
        label209:
        i = 1;
        continue;
        label214:
        int j = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.o
 * JD-Core Version:    0.7.0.1
 */