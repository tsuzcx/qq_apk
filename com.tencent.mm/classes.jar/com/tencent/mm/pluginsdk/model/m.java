package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.a.a;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
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
import com.tencent.mm.vfs.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class m
  extends Thread
{
  private static int gsi;
  private static HashMap<String, b> qQI;
  private static Object qQJ;
  private static QueueWorkerThread qQK;
  private int JVd;
  private a JVe;
  private Context context;
  private Intent intent;
  private boolean isStop;
  private List<String> qQA;
  private List<String> qQB;
  private List<Integer> qQC;
  private List<String> qQy;
  private List<Integer> qQz;
  private String talker;
  private int[] vRR;
  
  static
  {
    AppMethodBeat.i(127169);
    qQI = new HashMap();
    qQJ = new byte[0];
    AppMethodBeat.o(127169);
  }
  
  public m(Context paramContext, List<String> paramList, Intent paramIntent, String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(127144);
    this.vRR = new int[29];
    this.context = paramContext;
    this.qQy = paramList;
    this.intent = paramIntent;
    this.qQz = new ArrayList();
    this.qQA = new ArrayList();
    this.qQB = new ArrayList();
    this.qQC = new ArrayList();
    this.JVe = parama;
    this.talker = paramString;
    this.JVd = paramInt;
    AppMethodBeat.o(127144);
  }
  
  private VideoTransPara a(String paramString, PInt paramPInt)
  {
    AppMethodBeat.i(127157);
    if (com.tencent.mm.modelcontrol.e.baZ().Oh(paramString))
    {
      Log.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[] { paramString });
      paramPInt.value = 1;
      gmz();
      AppMethodBeat.o(127157);
      return null;
    }
    VideoTransPara localVideoTransPara1 = com.tencent.mm.bk.e.QX(paramString);
    Boolean localBoolean = Boolean.valueOf(com.tencent.mm.bk.e.QW(paramString));
    Log.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", new Object[] { localVideoTransPara1 });
    VideoTransPara localVideoTransPara2 = com.tencent.mm.modelcontrol.e.baZ().c(localVideoTransPara1);
    if (localVideoTransPara2 == null)
    {
      Log.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", new Object[] { localVideoTransPara1 });
      paramPInt.value = -5;
      AppMethodBeat.o(127157);
      return null;
    }
    Log.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", new Object[] { localVideoTransPara2 });
    int[] arrayOfInt = a(paramString, localVideoTransPara2);
    localVideoTransPara2.videoBitrate = arrayOfInt[0];
    localVideoTransPara2.width = arrayOfInt[1];
    localVideoTransPara2.height = arrayOfInt[2];
    if ((localVideoTransPara1.videoBitrate <= 640000) || (localVideoTransPara2.videoBitrate > localVideoTransPara1.videoBitrate))
    {
      Log.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", new Object[] { localVideoTransPara2, localVideoTransPara1 });
      if (localBoolean.booleanValue())
      {
        paramPInt.value = 0;
        AppMethodBeat.o(127157);
        return localVideoTransPara1;
      }
      paramPInt.value = 1;
      AppMethodBeat.o(127157);
      return null;
    }
    if ((localVideoTransPara1.fps >= 45) && (localVideoTransPara1.duration * 1000 >= 180000))
    {
      paramPInt.value = -6;
      AppMethodBeat.o(127157);
      return null;
    }
    if (localBoolean.booleanValue())
    {
      paramPInt.value = 0;
      AppMethodBeat.o(127157);
      return localVideoTransPara2;
    }
    boolean bool = NetStatusUtil.is2G(MMApplicationContext.getContext());
    int j = localVideoTransPara2.width;
    int k = localVideoTransPara2.height;
    int i;
    if (bool)
    {
      i = 10485760;
      label338:
      if (!bool) {
        break label375;
      }
    }
    label375:
    for (double d = 60000.0D;; d = 300000.0D)
    {
      paramPInt.value = SightVideoJNI.shouldRemuxingVFS(paramString, j, k, i, d, 1000000);
      break;
      i = z.gmL();
      break label338;
    }
  }
  
  private void a(int paramInt1, String paramString1, String arg3, int paramInt2, VideoTransPara paramVideoTransPara, Intent paramIntent)
  {
    AppMethodBeat.i(127148);
    Log.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", new Object[] { ???, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    d(paramInt1, paramString1, ???, paramInt2);
    if (paramInt1 == -50002)
    {
      gmw();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 141);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 == -50008)
    {
      gmy();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 140);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 == -50006)
    {
      b localb = new b((byte)0);
      synchronized (qQJ)
      {
        qQI.put(paramString1, localb);
        if (u.r(paramString1, this.talker, ???) >= 0L) {
          break label231;
        }
        a(this.talker, paramString1, ???, paramIntent, paramInt2, 142);
        Log.e("MicroMsg.ImportMultiVideo", "prepare");
      }
      synchronized (qQJ)
      {
        qQI.remove(paramString1);
        AppMethodBeat.o(127148);
        return;
        paramString1 = finally;
        AppMethodBeat.o(127148);
        throw paramString1;
      }
      label231:
      if (qQK == null) {
        qQK = new QueueWorkerThread(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
      }
      localb.fileName = paramString1;
      localb.jpP = ???;
      com.tencent.mm.modelvideo.o.bhj();
      localb.kTQ = t.Qw(paramString1);
      localb.JVd = this.JVd;
      localb.toUser = this.talker;
      localb.jsd = paramVideoTransPara;
      localb.vRR = this.vRR;
      b.a(localb, com.tencent.mm.bk.e.QW(???));
      localb.JVg = new com.tencent.mm.bk.g();
      qQK.add(localb);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 < 0)
    {
      gmx();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 142);
      AppMethodBeat.o(127148);
      return;
    }
    u.c(paramString1, paramInt2, this.talker, ???);
    u.QG(paramString1);
    if (this.JVd == 1) {}
    for (paramInt1 = 8;; paramInt1 = 1)
    {
      com.tencent.mm.modelvideo.o.bhj();
      paramString1 = t.Qw(paramString1);
      n.bhh().a(???, paramString1, this.talker, "", "", paramInt1, 2);
      AppMethodBeat.o(127148);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127149);
    Object localObject = new ca();
    ((ca)localObject).setStatus(5);
    ((ca)localObject).Cy(paramString1);
    ((ca)localObject).setCreateTime(bp.Kw(paramString1));
    ((ca)localObject).nv(1);
    ((ca)localObject).Cz(paramString2);
    ((ca)localObject).setType(43);
    long l = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aC((ca)localObject);
    Log.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((eo)localObject).field_msgId), Long.valueOf(((eo)localObject).field_msgSvrId), ((eo)localObject).field_talker, Integer.valueOf(((ca)localObject).getType()), Integer.valueOf(((eo)localObject).field_isSend), ((eo)localObject).field_imgPath, Integer.valueOf(((eo)localObject).field_status), Long.valueOf(((eo)localObject).field_createTime) });
    if (-1L == l)
    {
      Log.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", new Object[] { paramString1 });
      AppMethodBeat.o(127149);
      return;
    }
    if (u.QN(paramString2) == null)
    {
      com.tencent.mm.modelvideo.o.bhj();
      localObject = t.Qx(paramString2);
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
      j = t.Qy((String)localObject);
      com.tencent.mm.modelvideo.o.bhj();
      i = t.Qy(t.Qw(paramString2));
      paramIntent = new com.tencent.mm.modelvideo.s();
      paramIntent.fileName = paramString2;
      if (i <= 0) {
        continue;
      }
      paramIntent.iKP = i;
      paramIntent.jsl = j;
      paramIntent.iFw = paramInt1;
      paramIntent.dWq = paramString1;
      paramIntent.jsh = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, ""));
      paramIntent.createTime = Util.nowSecond();
      paramIntent.jsm = Util.nowSecond();
      paramIntent.jst = null;
      paramIntent.jpP = paramString3;
      if (!Util.isNullOrNil(paramString3)) {
        paramIntent.jsr = 1;
      }
      paramIntent.jsu = -1;
      paramIntent.status = paramInt2;
      paramIntent.jso = ((int)l);
      if (!com.tencent.mm.modelvideo.o.bhj().b(paramIntent)) {
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
    AppMethodBeat.i(240891);
    int[] arrayOfInt = new int[3];
    int[] tmp11_10 = arrayOfInt;
    tmp11_10[0] = 0;
    int[] tmp15_11 = tmp11_10;
    tmp15_11[1] = 0;
    int[] tmp19_15 = tmp15_11;
    tmp19_15[2] = 0;
    tmp19_15;
    arrayOfInt[0] = paramVideoTransPara.videoBitrate;
    arrayOfInt[1] = paramVideoTransPara.width;
    arrayOfInt[2] = paramVideoTransPara.height;
    if (((paramVideoTransPara.iTg == 1) || (paramVideoTransPara.iTg == 2)) && ((paramVideoTransPara.iTq == 2) || (paramVideoTransPara.iTq == 4) || (paramVideoTransPara.iTq == 1)))
    {
      this.vRR = AdaptiveAdjustBitrate.a(paramString, paramVideoTransPara.height, paramVideoTransPara.width, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, 10.0F, 0.0F, paramVideoTransPara.iTq, paramVideoTransPara.iTi, paramVideoTransPara.iTj, paramVideoTransPara.iTk, paramVideoTransPara.iTl, paramVideoTransPara.iTm, paramVideoTransPara.iTn, paramVideoTransPara.iTo, false);
      if (this.vRR != null) {
        arrayOfInt[0] = (this.vRR[0] * 1000);
      }
      if (this.vRR[5] > 0)
      {
        arrayOfInt[1] = this.vRR[1];
        arrayOfInt[2] = this.vRR[2];
      }
      Log.i("MicroMsg.ImportMultiVideo", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(arrayOfInt[2]) });
      com.tencent.mm.modelvideo.o.bhk();
      com.tencent.mm.an.e.s(this.vRR);
      AppMethodBeat.o(240891);
      return arrayOfInt;
    }
    Log.i("MicroMsg.ImportMultiVideo", "c2c ABA: No use ABA algorithm");
    AppMethodBeat.o(240891);
    return arrayOfInt;
  }
  
  private void av(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(127146);
    String str1 = t.Qv(this.talker);
    com.tencent.mm.modelvideo.o.bhj();
    String str2 = t.Qx(str1);
    com.tencent.mm.modelvideo.o.bhj();
    String str3 = t.Qw(str1);
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
    boolean bool2 = com.tencent.mm.plugin.a.c.Sx(str4);
    int k = (int)com.tencent.mm.vfs.s.boW(str4);
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
      Log.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d config:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(z.gmL()) });
      switch (i)
      {
      default: 
        Log.e("MicroMsg.ImportMultiVideo", "unknown check type");
        a(-50001, str1, str4, 0, null, paramIntent);
        AppMethodBeat.o(127146);
        return;
        if (bool1) {}
        for (i = 10485760;; i = z.gmL())
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
    if (k > z.gmL())
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
      com.tencent.mm.vfs.s.nw(str4, str3);
      gA(str3, this.JVd);
      g(false, str4, str3);
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
        zI(true);
        j = m;
        if (j == 0) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          zI(false);
          BitmapUtil.saveBitmapToImage(BitmapUtil.createColorBitmap(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, str2, true);
          j = i;
          if (k == 0)
          {
            j = i;
            if (!com.tencent.mm.vfs.s.YS(str3)) {
              j = -50003;
            }
          }
          if (!com.tencent.mm.vfs.s.YS(str2)) {
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
    //   0: ldc_w 698
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 700	com/tencent/mm/compatible/i/d
    //   9: dup
    //   10: invokespecial 701	com/tencent/mm/compatible/i/d:<init>	()V
    //   13: astore 7
    //   15: aload 7
    //   17: aload_0
    //   18: invokevirtual 706	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   21: aload 7
    //   23: bipush 18
    //   25: invokevirtual 710	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   28: iconst_0
    //   29: invokestatic 714	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   32: istore 6
    //   34: aload 7
    //   36: bipush 19
    //   38: invokevirtual 710	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   41: iconst_0
    //   42: invokestatic 714	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
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
    //   82: invokevirtual 717	android/media/MediaMetadataRetriever:release	()V
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
    //   117: ldc_w 698
    //   120: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   174: invokevirtual 717	android/media/MediaMetadataRetriever:release	()V
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
    //   209: ldc_w 698
    //   212: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   248: invokevirtual 717	android/media/MediaMetadataRetriever:release	()V
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
    //   283: ldc_w 698
    //   286: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_0
    //   290: athrow
    //   291: ldc_w 698
    //   294: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   13	234	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   6	15	237	finally
    //   15	47	298	finally
    //   216	228	298	finally
  }
  
  public static boolean bdr(String paramString)
  {
    AppMethodBeat.i(127155);
    synchronized (qQJ)
    {
      boolean bool = qQI.containsKey(paramString);
      Log.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(127155);
      return bool;
    }
  }
  
  public static void bds(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127156);
    synchronized (qQJ)
    {
      if (qQI.remove(paramString) != null)
      {
        Log.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(127156);
        return;
      }
      bool = false;
    }
  }
  
  private void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(127153);
      this.qQz.add(Integer.valueOf(paramInt1));
      this.qQA.add(paramString1);
      this.qQB.add(paramString2);
      this.qQC.add(Integer.valueOf(paramInt2));
      AppMethodBeat.o(127153);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void d(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(127150);
    b(paramString, paramArrayOfInt, 640, 480);
    AppMethodBeat.o(127150);
  }
  
  public static void g(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(127151);
    try
    {
      locald = new d();
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
      d locald = null;
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
  
  private static void g(boolean paramBoolean, String paramString1, String paramString2)
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
  
  private static void gA(String paramString, int paramInt)
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
      long l = com.tencent.mm.vfs.s.boW(paramString);
      i = Util.nullAsNil((Integer)h.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, j, i));
      h.CyF.idkeyStat(106L, i, 1L, false);
      h.CyF.idkeyStat(106L, paramInt, 1L, false);
      Log.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + i + " file len : " + l / 1024L + "K");
      AppMethodBeat.o(127161);
      return;
      j = 234;
      i = 242;
    }
  }
  
  public static void gmv()
  {
    AppMethodBeat.i(127154);
    int i;
    synchronized (qQJ)
    {
      i = qQI.size();
      qQI.clear();
      if (qQK == null)
      {
        Log.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(127154);
        return;
      }
    }
    Log.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", new Object[] { Integer.valueOf(i), Integer.valueOf(qQK.getQueueSize()) });
    qQK.clear();
    qQK = null;
    AppMethodBeat.o(127154);
  }
  
  private void gmw()
  {
    AppMethodBeat.i(127159);
    if (this.JVd == 1) {}
    for (int i = 230;; i = 245)
    {
      Log.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i + " importType : " + this.JVd);
      h.CyF.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127159);
      return;
    }
  }
  
  private void gmx()
  {
    AppMethodBeat.i(127160);
    if (this.JVd == 1) {}
    for (int i = 229;; i = 244)
    {
      Log.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i + " importType : " + this.JVd);
      h.CyF.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127160);
      return;
    }
  }
  
  private static void gmy()
  {
    AppMethodBeat.i(127162);
    h.CyF.idkeyStat(106L, 210L, 1L, false);
    AppMethodBeat.o(127162);
  }
  
  private static void gmz()
  {
    AppMethodBeat.i(127163);
    h.CyF.idkeyStat(422L, 51L, 1L, false);
    AppMethodBeat.o(127163);
  }
  
  private void zI(boolean paramBoolean)
  {
    AppMethodBeat.i(127158);
    int i;
    if (this.JVd == 1) {
      if (paramBoolean) {
        i = 217;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + paramBoolean + " importType : " + this.JVd);
      h.CyF.idkeyStat(106L, i, 1L, false);
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
  
  public final void gmu()
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
    if ((this.qQy != null) && (this.qQy.size() > 0)) {
      i = 0;
    }
    while ((i < this.qQy.size()) && (!this.isStop))
    {
      Log.i("MicroMsg.ImportMultiVideo", "start to import %s", new Object[] { this.qQy.get(i) });
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse("file://" + (String)this.qQy.get(i)));
      av(this.context, localIntent);
      i += 1;
      continue;
      av(this.context, this.intent);
    }
    if ((this.JVe != null) && (!this.isStop)) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127141);
          m.a locala = m.e(m.this);
          m.a(m.this);
          m.b(m.this);
          m.c(m.this);
          m.d(m.this);
          locala.gmA();
          AppMethodBeat.o(127141);
        }
      });
    }
    AppMethodBeat.o(127145);
  }
  
  public static abstract interface a
  {
    public abstract void gmA();
  }
  
  static final class b
    implements QueueWorkerThread.ThreadObject
  {
    int JVd;
    com.tencent.mm.bk.g JVg;
    String fileName;
    String jpP;
    VideoTransPara jsd;
    String kTQ;
    private int outputHeight;
    private int outputWidth;
    int qQP;
    private boolean qQQ;
    private int qQR = 0;
    String toUser;
    int[] vRR;
    private boolean zzJ = false;
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(127142);
      int i;
      for (;;)
      {
        synchronized (m.qQJ)
        {
          if (!m.ett().containsKey(this.fileName))
          {
            i = 1;
            j = i;
            if (i == 0)
            {
              if (u.QN(this.fileName) == null) {
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
        m.Dh(WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcEncodeVideoTimeout, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo"));
        Log.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(m.bhW()) });
        if ((this.jsd == null) || (this.jsd.isDefault)) {
          break label308;
        }
        this.outputWidth = this.jsd.width;
      }
      Object localObject3;
      for (this.outputHeight = this.jsd.height;; this.outputHeight = ???[1])
      {
        ??? = new PString();
        localObject3 = new PInt();
        if ((!((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().a(this.jpP, (PString)???, (PInt)localObject3)) || (com.tencent.mm.vfs.s.nw(((PString)???).value, this.kTQ) < 0L)) {
          break label341;
        }
        Log.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
        this.qQP = ((PInt)localObject3).value;
        this.qQQ = true;
        AppMethodBeat.o(127142);
        return true;
        i = 0;
        break;
        label308:
        ??? = new int[2];
        m.g(this.jpP, (int[])???);
        this.outputWidth = ???[0];
      }
      label341:
      long l = Util.currentTicks();
      bool1 = false;
      try
      {
        ??? = new d();
        ((d)???).setDataSource(this.jpP);
        i = Util.getInt(((d)???).extractMetadata(18), 0);
        j = Util.getInt(((d)???).extractMetadata(19), 0);
        this.qQP = Math.round(Util.getInt(((d)???).extractMetadata(9), 0) / 1000.0F);
        boolean bool2 = c.kz(i, j);
        bool1 = bool2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ImportMultiVideo", localException1, "", new Object[0]);
          continue;
          this.qQP = SightVideoJNI.remuxingVFS(this.jpP, this.kTQ, this.outputWidth, this.outputHeight, this.jsd.videoBitrate, this.jsd.iSV, 8, this.jsd.iSU, 25.0F, this.jsd.fps, null, 0, com.tencent.mm.plugin.sight.base.c.Dmb, 0, 51);
          continue;
          Log.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", new Object[] { this.fileName });
          if (com.tencent.mm.plugin.sight.base.c.Dmb) {
            com.tencent.mm.plugin.sight.base.c.Dmd = (int)(com.tencent.mm.plugin.sight.base.c.Dmd * 0.915D);
          }
          if ((this.zzJ) || (bool1))
          {
            this.jsd = new VideoTransPara();
            this.jsd.width = this.outputWidth;
            this.jsd.height = this.outputHeight;
            this.jsd.videoBitrate = com.tencent.mm.plugin.sight.base.c.Dmd;
            this.jsd.iSV = com.tencent.mm.plugin.sight.base.c.Dmc;
            this.jsd.iSU = 2;
            this.jsd.fps = ((int)com.tencent.mm.plugin.sight.base.c.Dme);
            this.jsd.duration = com.tencent.mm.bk.e.hj(this.jpP);
            com.tencent.mm.bk.e.a(this.jpP, this.kTQ, this.jsd);
          }
          else
          {
            this.qQP = SightVideoJNI.remuxingVFS(this.jpP, this.kTQ, this.outputWidth, this.outputHeight, com.tencent.mm.plugin.sight.base.c.Dmd, com.tencent.mm.plugin.sight.base.c.Dmc, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.c.Dme, null, 0, com.tencent.mm.plugin.sight.base.c.Dmb, 0, 51);
            continue;
            bool1 = false;
          }
        }
        Log.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
      }
      Log.i("MicroMsg.ImportMultiVideo", "forceMediaCodec :%s", new Object[] { Boolean.valueOf(bool1) });
      if (this.jsd != null)
      {
        Log.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", new Object[] { this.jsd });
        if (com.tencent.mm.plugin.sight.base.c.Dmb) {
          this.jsd.videoBitrate = ((int)(this.jsd.videoBitrate * 0.915D));
        }
        if ((this.zzJ) || (bool1))
        {
          h.CyF.idkeyStat(354L, 245L, 1L, false);
          if (com.tencent.mm.bk.e.a(this.jpP, this.kTQ, this.jsd) < 0) {
            h.CyF.idkeyStat(354L, 246L, 1L, false);
          }
          this.qQR = ((int)Util.ticksToNow(l));
          Log.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.jpP, this.kTQ, Integer.valueOf(this.qQP), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight) });
          if (this.qQP < 0) {
            break label1158;
          }
          bool1 = true;
          this.qQQ = bool1;
          ??? = new PInt();
          localObject3 = new PInt();
          if ((this.qQP <= 0) && (u.a(this.kTQ, (PInt)???, (PInt)localObject3))) {
            this.qQP = ((PInt)???).value;
          }
          if ((this.qQQ) && ((((this.jsd.iTh & 0x1) != 0) && (!this.zzJ)) || (((this.jsd.iTh & 0x2) != 0) && (this.zzJ)) || (this.jsd.iTg == 1)))
          {
            Log.i("MicroMsg.ImportMultiVideo", "hseasun:[hardcoder] hwenc qp add metadata flag", new Object[] { Integer.valueOf(m.bhW()) });
            SightVideoJNI.addReportMetadata(this.kTQ, this.vRR, this.jsd.iTg, this.jsd.iTh);
          }
          if (this.qQQ) {
            break label1164;
          }
          Log.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
          com.tencent.mm.vfs.s.deleteFile(this.kTQ);
          com.tencent.mm.vfs.s.nw(this.jpP, this.kTQ);
        }
      }
      label1158:
      label1164:
      PInt localPInt;
      for (;;)
      {
        if (m.bhW() != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, m.bhW());
          Log.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformance %s", new Object[] { Integer.valueOf(m.bhW()) });
          m.Dh(0);
        }
        AppMethodBeat.o(127142);
        return true;
        try
        {
          String str = new com.tencent.mm.vfs.o(this.kTQ).getName();
          localObject3 = this.kTQ + ".tmp";
          localPInt = new PInt(0);
          if (!com.tencent.mm.plugin.a.e.b(this.kTQ, (String)localObject3, localPInt)) {
            break;
          }
          bool1 = com.tencent.mm.vfs.s.deleteFile(this.kTQ);
          localObject3 = new com.tencent.mm.vfs.o((String)localObject3);
          Log.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.vfs.s.bo(((com.tencent.mm.vfs.o)localObject3).getParent() + "/", ((com.tencent.mm.vfs.o)localObject3).getName(), str)), aa.z(((com.tencent.mm.vfs.o)localObject3).her()), this.kTQ });
          h.CyF.idkeyStat(354L, 30L, 1L, false);
          ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().ar(this.jpP, this.kTQ, this.qQP);
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", new Object[] { localException2.toString() });
        }
      }
      if (localPInt.value != 1) {
        h.CyF.idkeyStat(354L, 31L, 1L, false);
      }
      for (;;)
      {
        Log.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.jpP, this.kTQ });
        break;
        h.CyF.idkeyStat(354L, 32L, 1L, false);
        h.CyF.a(13836, new Object[] { Integer.valueOf(600), Long.valueOf(Util.nowSecond()), this.kTQ });
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(127143);
      Log.i("MicroMsg.ImportMultiVideo", "onPostExecute");
      for (;;)
      {
        synchronized (m.qQJ)
        {
          m.ett().remove(this.fileName);
          if (this.qQQ)
          {
            m.gB(this.kTQ, this.JVd);
            m.h(this.qQQ, this.jpP, this.kTQ);
            if (!com.tencent.mm.plugin.sight.base.c.Dmb) {
              break label204;
            }
            i = 1;
            m.b(i, this.qQR, this.jpP, this.kTQ, this.qQP);
            if (this.JVd != 1) {
              break label209;
            }
            i = 8;
            if (!this.qQQ) {
              break label214;
            }
            j = 1;
            n.bhh().a(this.jpP, this.kTQ, this.toUser, "", "", i, j);
            Log.i("MicroMsg.ImportMultiVideo", "updateVideo");
            u.u(this.fileName, this.qQP, 43);
            u.QG(this.fileName);
            AppMethodBeat.o(127143);
            return false;
          }
        }
        m.gC(this.kTQ, this.JVd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.m
 * JD-Core Version:    0.7.0.1
 */