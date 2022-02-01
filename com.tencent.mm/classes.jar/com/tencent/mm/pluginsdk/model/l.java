package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.a.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public final class l
  extends Thread
{
  private static int foV;
  private static HashMap<String, b> onD;
  private static Object onE;
  private static be onF;
  private int BOQ;
  private a BOR;
  private Context context;
  private Intent intent;
  private boolean isStop;
  private List<String> ont;
  private List<Integer> onu;
  private List<String> onv;
  private List<String> onw;
  private List<Integer> onx;
  private int[] qQH;
  private String talker;
  
  static
  {
    AppMethodBeat.i(127169);
    onD = new HashMap();
    onE = new byte[0];
    AppMethodBeat.o(127169);
  }
  
  public l(Context paramContext, List<String> paramList, Intent paramIntent, String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(127144);
    this.qQH = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    this.context = paramContext;
    this.ont = paramList;
    this.intent = paramIntent;
    this.onu = new ArrayList();
    this.onv = new ArrayList();
    this.onw = new ArrayList();
    this.onx = new ArrayList();
    this.BOR = parama;
    this.talker = paramString;
    this.BOQ = paramInt;
    AppMethodBeat.o(127144);
  }
  
  private void Q(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(127146);
    String str1 = t.zP((String)com.tencent.mm.kernel.g.afB().afk().get(2, ""));
    o.aCI();
    String str2 = t.zR(str1);
    o.aCI();
    String str3 = t.zQ(str1);
    boolean bool1 = ay.is2G(aj.getContext());
    String str4 = com.tencent.mm.compatible.h.a.i(paramContext, paramIntent);
    if (bt.isNullOrNil(str4))
    {
      ad.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
      a(-50005, str1, str4, 0, null, paramIntent);
      AppMethodBeat.o(127146);
      return;
    }
    boolean bool2 = com.tencent.mm.plugin.a.c.BH(str4);
    int j = (int)i.aMN(str4);
    VideoTransPara localVideoTransPara;
    int i;
    if (bool2)
    {
      ad.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", new Object[] { Boolean.valueOf(bool2) });
      PInt localPInt = new PInt();
      localVideoTransPara = a(str4, localPInt);
      i = localPInt.value;
    }
    for (;;)
    {
      ad.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(j) });
      switch (i)
      {
      default: 
        ad.e("MicroMsg.ImportMultiVideo", "unknown check type");
        a(-50001, str1, str4, 0, null, paramIntent);
        AppMethodBeat.o(127146);
        return;
        if (bool1) {}
        for (i = 10485760;; i = 26214400)
        {
          if (j <= i) {
            break label311;
          }
          i = -5;
          localVideoTransPara = null;
          break;
        }
        label311:
        ad.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", new Object[] { Boolean.valueOf(bool2) });
        i = 1;
        localVideoTransPara = null;
      }
    }
    if (j > 26214400)
    {
      a(-50002, str1, str4, 0, null, paramIntent);
      j = 0;
      i = -50002;
    }
    try
    {
      for (;;)
      {
        paramContext = com.tencent.mm.compatible.h.a.j(paramContext, paramIntent);
        if (paramContext != null) {
          break;
        }
        ad.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
        a(-50005, str1, str4, 0, null, paramIntent);
        AppMethodBeat.o(127146);
        return;
        j = 0;
        i = 0;
        continue;
        j = 1;
        i = 0;
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
        ad.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    if (j == 0)
    {
      i.lC(str4, str3);
      fr(str3, this.BOQ);
      e(false, str4, str3);
    }
    for (;;)
    {
      int n = bt.vN(paramContext.duration);
      int m = 1;
      int k = 1;
      if (paramContext.bitmap != null) {
        k = m;
      }
      try
      {
        f.a(paramContext.bitmap, 60, Bitmap.CompressFormat.JPEG, str2, true);
        k = 0;
        m = 0;
        tR(true);
        k = m;
        if (k == 0) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          tR(false);
          f.a(f.aG(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, str2, true);
          k = i;
          if (j == 0)
          {
            k = i;
            if (!i.eK(str3)) {
              k = -50003;
            }
          }
          if (!i.eK(str2)) {
            k = -50004;
          }
          a(k, str1, str4, n, localVideoTransPara, paramIntent);
          AppMethodBeat.o(127146);
          return;
          i = -50006;
          continue;
          paramContext = paramContext;
          ad.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
          }
        }
      }
    }
  }
  
  private VideoTransPara a(String paramString, PInt paramPInt)
  {
    AppMethodBeat.i(127157);
    if (com.tencent.mm.modelcontrol.d.awT().xQ(paramString))
    {
      ad.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[] { paramString });
      paramPInt.value = 1;
      evn();
      AppMethodBeat.o(127157);
      return null;
    }
    VideoTransPara localVideoTransPara1 = com.tencent.mm.bl.e.Ap(paramString);
    Boolean localBoolean = Boolean.valueOf(com.tencent.mm.bl.e.Ao(paramString));
    ad.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", new Object[] { localVideoTransPara1 });
    VideoTransPara localVideoTransPara2 = com.tencent.mm.modelcontrol.d.awT().c(localVideoTransPara1);
    if (localVideoTransPara2 == null)
    {
      ad.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", new Object[] { localVideoTransPara1 });
      paramPInt.value = -5;
      AppMethodBeat.o(127157);
      return null;
    }
    ad.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", new Object[] { localVideoTransPara2 });
    int[] arrayOfInt = a(paramString, localVideoTransPara2);
    localVideoTransPara2.videoBitrate = arrayOfInt[0];
    localVideoTransPara2.width = arrayOfInt[1];
    localVideoTransPara2.height = arrayOfInt[2];
    if ((localVideoTransPara1.videoBitrate <= 640000) || (localVideoTransPara2.videoBitrate > localVideoTransPara1.videoBitrate))
    {
      ad.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", new Object[] { localVideoTransPara2, localVideoTransPara1 });
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
    boolean bool = ay.is2G(aj.getContext());
    int j = localVideoTransPara2.width;
    int k = localVideoTransPara2.height;
    int i;
    if (bool)
    {
      i = 10485760;
      label352:
      if (!bool) {
        break label389;
      }
    }
    label389:
    for (double d = 60000.0D;; d = 300000.0D)
    {
      paramPInt.value = SightVideoJNI.shouldRemuxingVFS(paramString, j, k, i, d, 1000000);
      break;
      i = 26214400;
      break label352;
    }
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2, VideoTransPara paramVideoTransPara, Intent arg6)
  {
    AppMethodBeat.i(127148);
    ad.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    d(paramInt1, paramString1, paramString2, paramInt2);
    if (paramInt1 == -50002)
    {
      evk();
      a(this.talker, paramString1, paramString2, ???, paramInt2, 141);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 == -50008)
    {
      evm();
      a(this.talker, paramString1, paramString2, ???, paramInt2, 140);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 == -50006)
    {
      if (u.s(paramString1, this.talker, paramString2) < 0L)
      {
        a(this.talker, paramString1, paramString2, ???, paramInt2, 142);
        ad.e("MicroMsg.ImportMultiVideo", "prepare");
        AppMethodBeat.o(127148);
        return;
      }
      if (onF == null) {
        onF = new be(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
      }
      b localb = new b((byte)0);
      synchronized (onE)
      {
        onD.put(paramString1, localb);
        localb.fileName = paramString1;
        localb.hxL = paramString2;
        o.aCI();
        localb.iTJ = t.zQ(paramString1);
        localb.BOQ = this.BOQ;
        localb.toUser = this.talker;
        localb.hzX = paramVideoTransPara;
        localb.qQH = this.qQH;
        localb.tHz = com.tencent.mm.bl.e.Ao(paramString2);
        localb.BOT = new com.tencent.mm.bl.g();
        onF.c(localb);
        AppMethodBeat.o(127148);
        return;
      }
    }
    if (paramInt1 < 0)
    {
      evl();
      a(this.talker, paramString1, paramString2, ???, paramInt2, 142);
      AppMethodBeat.o(127148);
      return;
    }
    u.c(paramString1, paramInt2, this.talker, paramString2);
    u.zX(paramString1);
    if (this.BOQ == 1) {}
    for (paramInt1 = 8;; paramInt1 = 1)
    {
      o.aCI();
      paramString1 = t.zQ(paramString1);
      n.aCG().a(paramString2, paramString1, this.talker, "", "", paramInt1, 2);
      AppMethodBeat.o(127148);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127149);
    Object localObject = new bl();
    ((bl)localObject).setStatus(5);
    ((bl)localObject).nY(paramString1);
    ((bl)localObject).kY(bi.uj(paramString1));
    ((bl)localObject).jV(1);
    ((bl)localObject).nZ(paramString2);
    ((bl)localObject).setType(43);
    long l = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().an((bl)localObject);
    ad.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((du)localObject).field_msgId), Long.valueOf(((du)localObject).field_msgSvrId), ((du)localObject).field_talker, Integer.valueOf(((bl)localObject).getType()), Integer.valueOf(((du)localObject).field_isSend), ((du)localObject).field_imgPath, Integer.valueOf(((du)localObject).field_status), Long.valueOf(((du)localObject).field_createTime) });
    if (-1L == l)
    {
      ad.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", new Object[] { paramString1 });
      AppMethodBeat.o(127149);
      return;
    }
    if (u.Ae(paramString2) == null)
    {
      o.aCI();
      localObject = t.zR(paramString2);
      i = paramInt1;
    }
    for (;;)
    {
      try
      {
        paramIntent = com.tencent.mm.compatible.h.a.j(this.context, paramIntent);
        if (paramIntent == null) {
          continue;
        }
        i = paramInt1;
        if (paramIntent.bitmap == null) {
          continue;
        }
        i = paramInt1;
        paramInt1 = bt.vN(paramIntent.duration);
        i = paramInt1;
        f.a(paramIntent.bitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
      }
      catch (Exception paramIntent)
      {
        int j;
        ad.printErrStackTrace("MicroMsg.ImportMultiVideo", paramIntent, "", new Object[0]);
        paramInt1 = i;
        continue;
        i = 0;
        continue;
      }
      j = t.zS((String)localObject);
      o.aCI();
      i = t.zS(t.zQ(paramString2));
      paramIntent = new s();
      paramIntent.fileName = paramString2;
      if (i <= 0) {
        continue;
      }
      paramIntent.gTY = i;
      paramIntent.hAf = j;
      paramIntent.gOY = paramInt1;
      paramIntent.dtV = paramString1;
      paramIntent.hAb = ((String)com.tencent.mm.kernel.g.afB().afk().get(2, ""));
      paramIntent.createTime = bt.aGK();
      paramIntent.hAg = bt.aGK();
      paramIntent.hAn = null;
      paramIntent.hxL = paramString3;
      if (!bt.isNullOrNil(paramString3)) {
        paramIntent.hAl = 1;
      }
      paramIntent.hAo = -1;
      paramIntent.status = paramInt2;
      paramIntent.hAi = ((int)l);
      if (!o.aCI().b(paramIntent)) {
        ad.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", new Object[] { Long.valueOf(l) });
      }
      AppMethodBeat.o(127149);
      return;
      i = paramInt1;
      f.a(f.aG(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
    }
  }
  
  private int[] a(String paramString, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(195143);
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
    if (((paramVideoTransPara.hcj == 1) || (paramVideoTransPara.hcj == 2)) && ((paramVideoTransPara.hcs == 2) || (paramVideoTransPara.hcs == 4) || (paramVideoTransPara.hcs == 1)))
    {
      this.qQH = AdaptiveAdjustBitrate.a(paramString, paramVideoTransPara.height, paramVideoTransPara.width, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, 10.0F, 0.0F, paramVideoTransPara.hcs, paramVideoTransPara.hcl, paramVideoTransPara.hcm, paramVideoTransPara.hcn, paramVideoTransPara.hco, paramVideoTransPara.hcp, paramVideoTransPara.hcq);
      if ((this.qQH[3] > 0) || (this.qQH[4] > 0)) {
        arrayOfInt[0] = (this.qQH[0] * 1000);
      }
      if (this.qQH[5] > 0)
      {
        arrayOfInt[1] = this.qQH[1];
        arrayOfInt[2] = this.qQH[2];
      }
      ad.i("MicroMsg.ImportMultiVideo", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(arrayOfInt[2]) });
      o.aCJ();
      com.tencent.mm.ao.e.p(this.qQH);
      AppMethodBeat.o(195143);
      return arrayOfInt;
    }
    ad.i("MicroMsg.ImportMultiVideo", "c2c ABA: No use ABA algorithm");
    AppMethodBeat.o(195143);
    return arrayOfInt;
  }
  
  public static boolean aAH(String paramString)
  {
    AppMethodBeat.i(127155);
    synchronized (onE)
    {
      boolean bool = onD.containsKey(paramString);
      ad.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(127155);
      return bool;
    }
  }
  
  public static void aAI(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127156);
    synchronized (onE)
    {
      if (onD.remove(paramString) != null)
      {
        ad.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(127156);
        return;
      }
      bool = false;
    }
  }
  
  /* Error */
  public static void b(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 702
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 704	com/tencent/mm/compatible/h/d
    //   9: dup
    //   10: invokespecial 705	com/tencent/mm/compatible/h/d:<init>	()V
    //   13: astore 7
    //   15: aload 7
    //   17: aload_0
    //   18: invokevirtual 710	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   21: aload 7
    //   23: bipush 18
    //   25: invokevirtual 714	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   28: iconst_0
    //   29: invokestatic 718	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   32: istore 6
    //   34: aload 7
    //   36: bipush 19
    //   38: invokevirtual 714	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   41: iconst_0
    //   42: invokestatic 718	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
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
    //   82: invokevirtual 721	android/media/MediaMetadataRetriever:release	()V
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
    //   117: ldc_w 702
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
    //   174: invokevirtual 721	android/media/MediaMetadataRetriever:release	()V
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
    //   209: ldc_w 702
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
    //   248: invokevirtual 721	android/media/MediaMetadataRetriever:release	()V
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
    //   283: ldc_w 702
    //   286: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_0
    //   290: athrow
    //   291: ldc_w 702
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
    //   13	234	7	locald	com.tencent.mm.compatible.h.d
    // Exception table:
    //   from	to	target	type
    //   6	15	237	finally
    //   15	47	298	finally
    //   216	228	298	finally
  }
  
  private void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(127153);
      this.onu.add(Integer.valueOf(paramInt1));
      this.onv.add(paramString1);
      this.onw.add(paramString2);
      this.onx.add(Integer.valueOf(paramInt2));
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
  
  private static void e(boolean paramBoolean, String paramString1, String paramString2)
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
  
  public static void evj()
  {
    AppMethodBeat.i(127154);
    int i;
    synchronized (onE)
    {
      i = onD.size();
      onD.clear();
      if (onF == null)
      {
        ad.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(127154);
        return;
      }
    }
    ad.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", new Object[] { Integer.valueOf(i), Integer.valueOf(onF.EWq.size()) });
    onF.EWq.clear();
    onF = null;
    AppMethodBeat.o(127154);
  }
  
  private void evk()
  {
    AppMethodBeat.i(127159);
    if (this.BOQ == 1) {}
    for (int i = 230;; i = 245)
    {
      ad.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i + " importType : " + this.BOQ);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127159);
      return;
    }
  }
  
  private void evl()
  {
    AppMethodBeat.i(127160);
    if (this.BOQ == 1) {}
    for (int i = 229;; i = 244)
    {
      ad.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i + " importType : " + this.BOQ);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127160);
      return;
    }
  }
  
  private static void evm()
  {
    AppMethodBeat.i(127162);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, 210L, 1L, false);
    AppMethodBeat.o(127162);
  }
  
  private static void evn()
  {
    AppMethodBeat.i(127163);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(422L, 51L, 1L, false);
    AppMethodBeat.o(127163);
  }
  
  public static void f(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(127151);
    try
    {
      locald = new com.tencent.mm.compatible.h.d();
      try
      {
        locald.setDataSource(paramString);
        int i = bt.getInt(locald.extractMetadata(18), 0);
        int j = bt.getInt(locald.extractMetadata(19), 0);
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
          ad.i("MicroMsg.ImportMultiVideo", "getImportProperRemuxingResolutionForC2C Width:%d Height:%d", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]) });
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
      com.tencent.mm.compatible.h.d locald = null;
    }
    locald.release();
    label184:
    if (paramArrayOfInt[0] % 2 != 0) {
      paramArrayOfInt[0] += 1;
    }
    if (paramArrayOfInt[1] % 2 != 0) {
      paramArrayOfInt[1] += 1;
    }
    ad.i("MicroMsg.ImportMultiVideo", "getImportProperRemuxingResolutionForC2C Width:%d Height:%d", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]) });
    AppMethodBeat.o(127151);
    throw paramString;
  }
  
  private static void fr(String paramString, int paramInt)
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
      long l = i.aMN(paramString);
      i = bt.l((Integer)com.tencent.mm.plugin.report.service.h.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, j, i));
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, i, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, paramInt, 1L, false);
      ad.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + i + " file len : " + l / 1024L + "K");
      AppMethodBeat.o(127161);
      return;
      j = 234;
      i = 242;
    }
  }
  
  private void tR(boolean paramBoolean)
  {
    AppMethodBeat.i(127158);
    int i;
    if (this.BOQ == 1) {
      if (paramBoolean) {
        i = 217;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + paramBoolean + " importType : " + this.BOQ);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, i, 1L, false);
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
  
  public final void evi()
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
    if ((this.ont != null) && (this.ont.size() > 0)) {
      i = 0;
    }
    while ((i < this.ont.size()) && (!this.isStop))
    {
      ad.i("MicroMsg.ImportMultiVideo", "start to import %s", new Object[] { this.ont.get(i) });
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse("file://" + (String)this.ont.get(i)));
      Q(this.context, localIntent);
      i += 1;
      continue;
      Q(this.context, this.intent);
    }
    if ((this.BOR != null) && (!this.isStop)) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127141);
          l.a locala = l.e(l.this);
          l.a(l.this);
          l.b(l.this);
          l.c(l.this);
          l.d(l.this);
          locala.evo();
          AppMethodBeat.o(127141);
        }
      });
    }
    AppMethodBeat.o(127145);
  }
  
  public static abstract interface a
  {
    public abstract void evo();
  }
  
  static final class b
    implements be.a
  {
    int BOQ;
    com.tencent.mm.bl.g BOT;
    String fileName;
    private int gtF;
    private int gtG;
    String hxL;
    VideoTransPara hzX;
    String iTJ;
    int onJ;
    private boolean onK;
    private int onL = 0;
    int[] qQH;
    boolean tHz = false;
    String toUser;
    
    public final boolean aus()
    {
      AppMethodBeat.i(127142);
      int i;
      for (;;)
      {
        synchronized (l.onE)
        {
          if (!l.cUq().containsKey(this.fileName))
          {
            i = 1;
            j = i;
            if (i == 0)
            {
              if (u.Ae(this.fileName) == null) {
                j = 1;
              }
            }
            else
            {
              if (j == 0) {
                break;
              }
              ad.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", new Object[] { this.fileName });
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
      boolean bool = WXHardCoderJNI.hcEncodeVideoEnable;
      int j = WXHardCoderJNI.hcEncodeVideoDelay;
      int k = WXHardCoderJNI.hcEncodeVideoCPU;
      int m = WXHardCoderJNI.hcEncodeVideoIO;
      if (WXHardCoderJNI.hcEncodeVideoThr)
      {
        i = Process.myTid();
        l.Hx(WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEncodeVideoTimeout, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo"));
        ad.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(l.aDt()) });
        if ((this.hzX == null) || (this.hzX.isDefault)) {
          break label308;
        }
        this.gtF = this.hzX.width;
      }
      Object localObject3;
      for (this.gtG = this.hzX.height;; this.gtG = ???[1])
      {
        ??? = new PString();
        localObject3 = new PInt();
        if ((!((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).apT().a(this.hxL, (PString)???, (PInt)localObject3)) || (i.lC(((PString)???).value, this.iTJ) < 0L)) {
          break label341;
        }
        ad.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
        this.onJ = ((PInt)localObject3).value;
        this.onK = true;
        AppMethodBeat.o(127142);
        return true;
        i = 0;
        break;
        label308:
        ??? = new int[2];
        l.f(this.hxL, (int[])???);
        this.gtF = ???[0];
      }
      label341:
      long l = bt.GC();
      try
      {
        ??? = new com.tencent.mm.compatible.h.d();
        ((com.tencent.mm.compatible.h.d)???).setDataSource(this.hxL);
        j = bt.getInt(((com.tencent.mm.compatible.h.d)???).extractMetadata(18), 0);
        k = bt.getInt(((com.tencent.mm.compatible.h.d)???).extractMetadata(19), 0);
        this.onJ = Math.round(bt.getInt(((com.tencent.mm.compatible.h.d)???).extractMetadata(9), 0) / 1000.0F);
        i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pqt, 3000);
        ad.i("MicroMsg.ImportMultiVideo", "rawWidth %d rawHeight:%d limit:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
        j = Math.max(k, j);
        if (j < i) {
          break label915;
        }
        i = 1;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ImportMultiVideo", localException1, "", new Object[0]);
          i = 0;
          continue;
          this.onJ = SightVideoJNI.remuxingVFS(this.hxL, this.iTJ, this.gtF, this.gtG, this.hzX.videoBitrate, this.hzX.hbY, 8, this.hzX.hbX, 25.0F, this.hzX.fps, null, 0, com.tencent.mm.plugin.sight.base.c.wqZ, 0, 51);
          continue;
          ad.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", new Object[] { this.fileName });
          if (com.tencent.mm.plugin.sight.base.c.wqZ) {
            com.tencent.mm.plugin.sight.base.c.wrb = (int)(com.tencent.mm.plugin.sight.base.c.wrb * 0.915D);
          }
          if ((this.tHz) || (i != 0))
          {
            this.hzX = new VideoTransPara();
            this.hzX.width = this.gtF;
            this.hzX.height = this.gtG;
            this.hzX.videoBitrate = com.tencent.mm.plugin.sight.base.c.wrb;
            this.hzX.hbY = com.tencent.mm.plugin.sight.base.c.wra;
            this.hzX.hbX = 2;
            this.hzX.fps = ((int)com.tencent.mm.plugin.sight.base.c.wrc);
            this.hzX.duration = com.tencent.mm.bl.e.fD(this.hxL);
            com.tencent.mm.bl.e.a(this.hxL, this.iTJ, this.hzX);
          }
          else
          {
            this.onJ = SightVideoJNI.remuxingVFS(this.hxL, this.iTJ, this.gtF, this.gtG, com.tencent.mm.plugin.sight.base.c.wrb, com.tencent.mm.plugin.sight.base.c.wra, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.c.wrc, null, 0, com.tencent.mm.plugin.sight.base.c.wqZ, 0, 51);
            continue;
            bool = false;
          }
        }
        ad.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
      }
      if (this.hzX != null)
      {
        ad.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", new Object[] { this.hzX });
        if (com.tencent.mm.plugin.sight.base.c.wqZ) {
          this.hzX.videoBitrate = ((int)(this.hzX.videoBitrate * 0.915D));
        }
        if ((this.tHz) || (i != 0))
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 245L, 1L, false);
          if (com.tencent.mm.bl.e.a(this.hxL, this.iTJ, this.hzX) < 0) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 246L, 1L, false);
          }
          this.onL = ((int)bt.aS(l));
          ad.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.hxL, this.iTJ, Integer.valueOf(this.onJ), Integer.valueOf(this.gtF), Integer.valueOf(this.gtG) });
          if (this.onJ < 0) {
            break label1190;
          }
          bool = true;
          this.onK = bool;
          ??? = new PInt();
          localObject3 = new PInt();
          if ((this.onJ <= 0) && (u.a(this.iTJ, (PInt)???, (PInt)localObject3))) {
            this.onJ = ((PInt)???).value;
          }
          if ((this.onK) && ((((this.hzX.hck & 0x1) != 0) && (!this.tHz)) || (((this.hzX.hck & 0x2) != 0) && (this.tHz)) || (this.hzX.hcj == 1)))
          {
            ad.i("MicroMsg.ImportMultiVideo", "hseasun:[hardcoder] hwenc qp add metadata flag", new Object[] { Integer.valueOf(l.aDt()) });
            SightVideoJNI.addReportMetadata(this.iTJ, this.qQH, this.hzX.hcj, this.hzX.hck);
          }
          if (this.onK) {
            break label1196;
          }
          ad.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
          i.deleteFile(this.iTJ);
          i.lC(this.hxL, this.iTJ);
        }
      }
      label915:
      label1190:
      label1196:
      PInt localPInt;
      for (;;)
      {
        if (l.aDt() != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, l.aDt());
          ad.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformance %s", new Object[] { Integer.valueOf(l.aDt()) });
          l.Hx(0);
        }
        AppMethodBeat.o(127142);
        return true;
        try
        {
          String str = new com.tencent.mm.vfs.e(this.iTJ).getName();
          localObject3 = this.iTJ + ".tmp";
          localPInt = new PInt(0);
          if (!com.tencent.mm.plugin.a.e.b(this.iTJ, (String)localObject3, localPInt)) {
            break;
          }
          bool = i.deleteFile(this.iTJ);
          localObject3 = new com.tencent.mm.vfs.e((String)localObject3);
          ad.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(i.aQ(((com.tencent.mm.vfs.e)localObject3).getParent() + "/", ((com.tencent.mm.vfs.e)localObject3).getName(), str)), q.B(((com.tencent.mm.vfs.e)localObject3).fhU()), this.iTJ });
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 30L, 1L, false);
          ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).apT().ag(this.hxL, this.iTJ, this.onJ);
        }
        catch (Exception localException2)
        {
          ad.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", new Object[] { localException2.toString() });
        }
      }
      if (localPInt.value != 1) {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 31L, 1L, false);
      }
      for (;;)
      {
        ad.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.hxL, this.iTJ });
        break;
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 32L, 1L, false);
        com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(600), Long.valueOf(bt.aGK()), this.iTJ });
      }
    }
    
    public final boolean aut()
    {
      AppMethodBeat.i(127143);
      ad.i("MicroMsg.ImportMultiVideo", "onPostExecute");
      for (;;)
      {
        synchronized (l.onE)
        {
          l.cUq().remove(this.fileName);
          if (this.onK)
          {
            l.fs(this.iTJ, this.BOQ);
            l.f(this.onK, this.hxL, this.iTJ);
            if (!com.tencent.mm.plugin.sight.base.c.wqZ) {
              break label204;
            }
            i = 1;
            l.a(i, this.onL, this.hxL, this.iTJ, this.onJ);
            if (this.BOQ != 1) {
              break label209;
            }
            i = 8;
            if (!this.onK) {
              break label214;
            }
            j = 1;
            n.aCG().a(this.hxL, this.iTJ, this.toUser, "", "", i, j);
            ad.i("MicroMsg.ImportMultiVideo", "updateVideo");
            u.t(this.fileName, this.onJ, 43);
            u.zX(this.fileName);
            AppMethodBeat.o(127143);
            return false;
          }
        }
        l.ft(this.iTJ, this.BOQ);
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
 * Qualified Name:     com.tencent.mm.pluginsdk.model.l
 * JD-Core Version:    0.7.0.1
 */