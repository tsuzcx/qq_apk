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
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.bj;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public final class l
  extends Thread
{
  private static int fKU;
  private static HashMap<String, b> puN;
  private static Object puO;
  private static be puP;
  private int ELO;
  private l.a ELP;
  private Context context;
  private Intent intent;
  private boolean isStop;
  private List<String> puD;
  private List<Integer> puE;
  private List<String> puF;
  private List<String> puG;
  private List<Integer> puH;
  private int[] sIH;
  private String talker;
  
  static
  {
    AppMethodBeat.i(127169);
    puN = new HashMap();
    puO = new byte[0];
    AppMethodBeat.o(127169);
  }
  
  public l(Context paramContext, List<String> paramList, Intent paramIntent, String paramString, int paramInt, l.a parama)
  {
    AppMethodBeat.i(127144);
    this.sIH = new int[29];
    this.context = paramContext;
    this.puD = paramList;
    this.intent = paramIntent;
    this.puE = new ArrayList();
    this.puF = new ArrayList();
    this.puG = new ArrayList();
    this.puH = new ArrayList();
    this.ELP = parama;
    this.talker = paramString;
    this.ELO = paramInt;
    AppMethodBeat.o(127144);
  }
  
  private VideoTransPara a(String paramString, PInt paramPInt)
  {
    AppMethodBeat.i(127157);
    if (com.tencent.mm.modelcontrol.d.aGQ().EV(paramString))
    {
      ad.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[] { paramString });
      paramPInt.value = 1;
      eZB();
      AppMethodBeat.o(127157);
      return null;
    }
    VideoTransPara localVideoTransPara1 = com.tencent.mm.bl.e.HJ(paramString);
    Boolean localBoolean = Boolean.valueOf(com.tencent.mm.bl.e.HI(paramString));
    ad.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", new Object[] { localVideoTransPara1 });
    VideoTransPara localVideoTransPara2 = com.tencent.mm.modelcontrol.d.aGQ().c(localVideoTransPara1);
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
      label338:
      if (!bool) {
        break label374;
      }
    }
    label374:
    for (double d = 60000.0D;; d = 300000.0D)
    {
      paramPInt.value = SightVideoJNI.shouldRemuxingVFS(paramString, j, k, i, d, 1000000);
      break;
      i = 26214400;
      break label338;
    }
  }
  
  private void a(int paramInt1, String paramString1, String arg3, int paramInt2, VideoTransPara paramVideoTransPara, Intent paramIntent)
  {
    AppMethodBeat.i(127148);
    ad.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", new Object[] { ???, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    d(paramInt1, paramString1, ???, paramInt2);
    if (paramInt1 == -50002)
    {
      eZy();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 141);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 == -50008)
    {
      eZA();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 140);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 == -50006)
    {
      b localb = new b((byte)0);
      synchronized (puO)
      {
        puN.put(paramString1, localb);
        if (u.r(paramString1, this.talker, ???) >= 0L) {
          break label231;
        }
        a(this.talker, paramString1, ???, paramIntent, paramInt2, 142);
        ad.e("MicroMsg.ImportMultiVideo", "prepare");
      }
      synchronized (puO)
      {
        puN.remove(paramString1);
        AppMethodBeat.o(127148);
        return;
        paramString1 = finally;
        AppMethodBeat.o(127148);
        throw paramString1;
      }
      label231:
      if (puP == null) {
        puP = new be(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
      }
      localb.fileName = paramString1;
      localb.irI = ???;
      o.aMJ();
      localb.jNP = t.Hh(paramString1);
      localb.ELO = this.ELO;
      localb.toUser = this.talker;
      localb.itU = paramVideoTransPara;
      localb.sIH = this.sIH;
      localb.vTf = com.tencent.mm.bl.e.HI(???);
      localb.ELR = new com.tencent.mm.bl.g();
      puP.c(localb);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 < 0)
    {
      eZz();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 142);
      AppMethodBeat.o(127148);
      return;
    }
    u.c(paramString1, paramInt2, this.talker, ???);
    u.Hr(paramString1);
    if (this.ELO == 1) {}
    for (paramInt1 = 8;; paramInt1 = 1)
    {
      o.aMJ();
      paramString1 = t.Hh(paramString1);
      n.aMH().a(???, paramString1, this.talker, "", "", paramInt1, 2);
      AppMethodBeat.o(127148);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127149);
    Object localObject = new bu();
    ((bu)localObject).setStatus(5);
    ((bu)localObject).tN(paramString1);
    ((bu)localObject).qA(bj.Bo(paramString1));
    ((bu)localObject).kr(1);
    ((bu)localObject).tO(paramString2);
    ((bu)localObject).setType(43);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().as((bu)localObject);
    ad.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(((ei)localObject).field_msgSvrId), ((ei)localObject).field_talker, Integer.valueOf(((bu)localObject).getType()), Integer.valueOf(((ei)localObject).field_isSend), ((ei)localObject).field_imgPath, Integer.valueOf(((ei)localObject).field_status), Long.valueOf(((ei)localObject).field_createTime) });
    if (-1L == l)
    {
      ad.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", new Object[] { paramString1 });
      AppMethodBeat.o(127149);
      return;
    }
    if (u.Hy(paramString2) == null)
    {
      o.aMJ();
      localObject = t.Hi(paramString2);
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
        paramInt1 = com.tencent.mm.sdk.platformtools.bt.Dg(paramIntent.duration);
        i = paramInt1;
        com.tencent.mm.sdk.platformtools.g.a(paramIntent.bitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
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
      j = t.Hj((String)localObject);
      o.aMJ();
      i = t.Hj(t.Hh(paramString2));
      paramIntent = new s();
      paramIntent.fileName = paramString2;
      if (i <= 0) {
        continue;
      }
      paramIntent.hMP = i;
      paramIntent.iuc = j;
      paramIntent.hHQ = paramInt1;
      paramIntent.dDy = paramString1;
      paramIntent.itY = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, ""));
      paramIntent.createTime = com.tencent.mm.sdk.platformtools.bt.aQJ();
      paramIntent.iud = com.tencent.mm.sdk.platformtools.bt.aQJ();
      paramIntent.iuk = null;
      paramIntent.irI = paramString3;
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString3)) {
        paramIntent.iui = 1;
      }
      paramIntent.iul = -1;
      paramIntent.status = paramInt2;
      paramIntent.iuf = ((int)l);
      if (!o.aMJ().b(paramIntent)) {
        ad.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", new Object[] { Long.valueOf(l) });
      }
      AppMethodBeat.o(127149);
      return;
      i = paramInt1;
      com.tencent.mm.sdk.platformtools.g.a(com.tencent.mm.sdk.platformtools.g.aJ(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
    }
  }
  
  private int[] a(String paramString, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(218878);
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
    if (((paramVideoTransPara.hVq == 1) || (paramVideoTransPara.hVq == 2)) && ((paramVideoTransPara.hVA == 2) || (paramVideoTransPara.hVA == 4) || (paramVideoTransPara.hVA == 1)))
    {
      this.sIH = AdaptiveAdjustBitrate.a(paramString, paramVideoTransPara.height, paramVideoTransPara.width, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, 10.0F, 0.0F, paramVideoTransPara.hVA, paramVideoTransPara.hVs, paramVideoTransPara.hVt, paramVideoTransPara.hVu, paramVideoTransPara.hVv, paramVideoTransPara.hVw, paramVideoTransPara.hVx, paramVideoTransPara.hVy);
      if (this.sIH != null) {
        arrayOfInt[0] = (this.sIH[0] * 1000);
      }
      if (this.sIH[5] > 0)
      {
        arrayOfInt[1] = this.sIH[1];
        arrayOfInt[2] = this.sIH[2];
      }
      ad.i("MicroMsg.ImportMultiVideo", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(arrayOfInt[2]) });
      o.aMK();
      com.tencent.mm.ao.e.q(this.sIH);
      AppMethodBeat.o(218878);
      return arrayOfInt;
    }
    ad.i("MicroMsg.ImportMultiVideo", "c2c ABA: No use ABA algorithm");
    AppMethodBeat.o(218878);
    return arrayOfInt;
  }
  
  public static void aLA(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127156);
    synchronized (puO)
    {
      if (puN.remove(paramString) != null)
      {
        ad.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(127156);
        return;
      }
      bool = false;
    }
  }
  
  public static boolean aLz(String paramString)
  {
    AppMethodBeat.i(127155);
    synchronized (puO)
    {
      boolean bool = puN.containsKey(paramString);
      ad.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(127155);
      return bool;
    }
  }
  
  private void ag(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(127146);
    String str1 = t.Hg(this.talker);
    o.aMJ();
    String str2 = t.Hi(str1);
    o.aMJ();
    String str3 = t.Hh(str1);
    boolean bool1 = ay.is2G(aj.getContext());
    String str4 = com.tencent.mm.compatible.h.a.i(paramContext, paramIntent);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str4))
    {
      ad.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
      a(-50005, str1, str4, 0, null, paramIntent);
      AppMethodBeat.o(127146);
      return;
    }
    boolean bool2 = com.tencent.mm.plugin.a.c.Ja(str4);
    int j = (int)com.tencent.mm.vfs.i.aYo(str4);
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
            break label310;
          }
          i = -5;
          localVideoTransPara = null;
          break;
        }
        label310:
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
      com.tencent.mm.vfs.i.mz(str4, str3);
      fT(str3, this.ELO);
      f(false, str4, str3);
    }
    for (;;)
    {
      int n = com.tencent.mm.sdk.platformtools.bt.Dg(paramContext.duration);
      int m = 1;
      int k = 1;
      if (paramContext.bitmap != null) {
        k = m;
      }
      try
      {
        com.tencent.mm.sdk.platformtools.g.a(paramContext.bitmap, 60, Bitmap.CompressFormat.JPEG, str2, true);
        k = 0;
        m = 0;
        vD(true);
        k = m;
        if (k == 0) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          vD(false);
          com.tencent.mm.sdk.platformtools.g.a(com.tencent.mm.sdk.platformtools.g.aJ(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, str2, true);
          k = i;
          if (j == 0)
          {
            k = i;
            if (!com.tencent.mm.vfs.i.fv(str3)) {
              k = -50003;
            }
          }
          if (!com.tencent.mm.vfs.i.fv(str2)) {
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
  
  /* Error */
  public static void b(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 705
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 707	com/tencent/mm/compatible/h/d
    //   9: dup
    //   10: invokespecial 708	com/tencent/mm/compatible/h/d:<init>	()V
    //   13: astore 7
    //   15: aload 7
    //   17: aload_0
    //   18: invokevirtual 713	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   21: aload 7
    //   23: bipush 18
    //   25: invokevirtual 717	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   28: iconst_0
    //   29: invokestatic 721	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   32: istore 6
    //   34: aload 7
    //   36: bipush 19
    //   38: invokevirtual 717	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   41: iconst_0
    //   42: invokestatic 721	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
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
    //   82: invokevirtual 724	android/media/MediaMetadataRetriever:release	()V
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
    //   117: ldc_w 705
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
    //   174: invokevirtual 724	android/media/MediaMetadataRetriever:release	()V
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
    //   209: ldc_w 705
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
    //   248: invokevirtual 724	android/media/MediaMetadataRetriever:release	()V
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
    //   283: ldc_w 705
    //   286: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_0
    //   290: athrow
    //   291: ldc_w 705
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
      this.puE.add(Integer.valueOf(paramInt1));
      this.puF.add(paramString1);
      this.puG.add(paramString2);
      this.puH.add(Integer.valueOf(paramInt2));
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
  
  private static void eZA()
  {
    AppMethodBeat.i(127162);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(106L, 210L, 1L, false);
    AppMethodBeat.o(127162);
  }
  
  private static void eZB()
  {
    AppMethodBeat.i(127163);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 51L, 1L, false);
    AppMethodBeat.o(127163);
  }
  
  public static void eZx()
  {
    AppMethodBeat.i(127154);
    int i;
    synchronized (puO)
    {
      i = puN.size();
      puN.clear();
      if (puP == null)
      {
        ad.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(127154);
        return;
      }
    }
    ad.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", new Object[] { Integer.valueOf(i), Integer.valueOf(puP.Ifr.size()) });
    puP.Ifr.clear();
    puP = null;
    AppMethodBeat.o(127154);
  }
  
  private void eZy()
  {
    AppMethodBeat.i(127159);
    if (this.ELO == 1) {}
    for (int i = 230;; i = 245)
    {
      ad.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i + " importType : " + this.ELO);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127159);
      return;
    }
  }
  
  private void eZz()
  {
    AppMethodBeat.i(127160);
    if (this.ELO == 1) {}
    for (int i = 229;; i = 244)
    {
      ad.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i + " importType : " + this.ELO);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127160);
      return;
    }
  }
  
  private static void f(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127164);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.modelvideo.a.j(i, paramString1, paramString2);
      AppMethodBeat.o(127164);
      return;
    }
  }
  
  private static void fT(String paramString, int paramInt)
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
      long l = com.tencent.mm.vfs.i.aYo(paramString);
      i = com.tencent.mm.sdk.platformtools.bt.n((Integer)com.tencent.mm.plugin.report.service.g.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, j, i));
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(106L, i, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(106L, paramInt, 1L, false);
      ad.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + i + " file len : " + l / 1024L + "K");
      AppMethodBeat.o(127161);
      return;
      j = 234;
      i = 242;
    }
  }
  
  public static void g(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(127151);
    try
    {
      locald = new com.tencent.mm.compatible.h.d();
      try
      {
        locald.setDataSource(paramString);
        int i = com.tencent.mm.sdk.platformtools.bt.getInt(locald.extractMetadata(18), 0);
        int j = com.tencent.mm.sdk.platformtools.bt.getInt(locald.extractMetadata(19), 0);
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
  
  private void vD(boolean paramBoolean)
  {
    AppMethodBeat.i(127158);
    int i;
    if (this.ELO == 1) {
      if (paramBoolean) {
        i = 217;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + paramBoolean + " importType : " + this.ELO);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(106L, i, 1L, false);
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
  
  public final void eZw()
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
    if ((this.puD != null) && (this.puD.size() > 0)) {
      i = 0;
    }
    while ((i < this.puD.size()) && (!this.isStop))
    {
      ad.i("MicroMsg.ImportMultiVideo", "start to import %s", new Object[] { this.puD.get(i) });
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse("file://" + (String)this.puD.get(i)));
      ag(this.context, localIntent);
      i += 1;
      continue;
      ag(this.context, this.intent);
    }
    if ((this.ELP != null) && (!this.isStop)) {
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
          locala.eZC();
          AppMethodBeat.o(127141);
        }
      });
    }
    AppMethodBeat.o(127145);
  }
  
  static final class b
    implements be.a
  {
    int ELO;
    com.tencent.mm.bl.g ELR;
    String fileName;
    String irI;
    VideoTransPara itU;
    String jNP;
    private int outputHeight;
    private int outputWidth;
    int puT;
    private boolean puU;
    private int puV = 0;
    int[] sIH;
    String toUser;
    boolean vTf = false;
    
    public final boolean aEm()
    {
      AppMethodBeat.i(127142);
      int i;
      for (;;)
      {
        synchronized (l.puO)
        {
          if (!l.dsj().containsKey(this.fileName))
          {
            i = 1;
            j = i;
            if (i == 0)
            {
              if (u.Hy(this.fileName) == null) {
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
        l.KY(WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEncodeVideoTimeout, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo"));
        ad.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(l.aNt()) });
        if ((this.itU == null) || (this.itU.isDefault)) {
          break label308;
        }
        this.outputWidth = this.itU.width;
      }
      Object localObject3;
      for (this.outputHeight = this.itU.height;; this.outputHeight = ???[1])
      {
        ??? = new PString();
        localObject3 = new PInt();
        if ((!((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azx().a(this.irI, (PString)???, (PInt)localObject3)) || (com.tencent.mm.vfs.i.mz(((PString)???).value, this.jNP) < 0L)) {
          break label341;
        }
        ad.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
        this.puT = ((PInt)localObject3).value;
        this.puU = true;
        AppMethodBeat.o(127142);
        return true;
        i = 0;
        break;
        label308:
        ??? = new int[2];
        l.g(this.irI, (int[])???);
        this.outputWidth = ???[0];
      }
      label341:
      long l = com.tencent.mm.sdk.platformtools.bt.HI();
      try
      {
        ??? = new com.tencent.mm.compatible.h.d();
        ((com.tencent.mm.compatible.h.d)???).setDataSource(this.irI);
        j = com.tencent.mm.sdk.platformtools.bt.getInt(((com.tencent.mm.compatible.h.d)???).extractMetadata(18), 0);
        k = com.tencent.mm.sdk.platformtools.bt.getInt(((com.tencent.mm.compatible.h.d)???).extractMetadata(19), 0);
        this.puT = Math.round(com.tencent.mm.sdk.platformtools.bt.getInt(((com.tencent.mm.compatible.h.d)???).extractMetadata(9), 0) / 1000.0F);
        i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qyM, 3000);
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
          this.puT = SightVideoJNI.remuxingVFS(this.irI, this.jNP, this.outputWidth, this.outputHeight, this.itU.videoBitrate, this.itU.hVf, 8, this.itU.hVe, 25.0F, this.itU.fps, null, 0, com.tencent.mm.plugin.sight.base.c.yRa, 0, 51);
          continue;
          ad.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", new Object[] { this.fileName });
          if (com.tencent.mm.plugin.sight.base.c.yRa) {
            com.tencent.mm.plugin.sight.base.c.yRc = (int)(com.tencent.mm.plugin.sight.base.c.yRc * 0.915D);
          }
          if ((this.vTf) || (i != 0))
          {
            this.itU = new VideoTransPara();
            this.itU.width = this.outputWidth;
            this.itU.height = this.outputHeight;
            this.itU.videoBitrate = com.tencent.mm.plugin.sight.base.c.yRc;
            this.itU.hVf = com.tencent.mm.plugin.sight.base.c.yRb;
            this.itU.hVe = 2;
            this.itU.fps = ((int)com.tencent.mm.plugin.sight.base.c.yRd);
            this.itU.duration = com.tencent.mm.bl.e.go(this.irI);
            com.tencent.mm.bl.e.a(this.irI, this.jNP, this.itU);
          }
          else
          {
            this.puT = SightVideoJNI.remuxingVFS(this.irI, this.jNP, this.outputWidth, this.outputHeight, com.tencent.mm.plugin.sight.base.c.yRc, com.tencent.mm.plugin.sight.base.c.yRb, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.c.yRd, null, 0, com.tencent.mm.plugin.sight.base.c.yRa, 0, 51);
            continue;
            bool = false;
          }
        }
        ad.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
      }
      if (this.itU != null)
      {
        ad.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", new Object[] { this.itU });
        if (com.tencent.mm.plugin.sight.base.c.yRa) {
          this.itU.videoBitrate = ((int)(this.itU.videoBitrate * 0.915D));
        }
        if ((this.vTf) || (i != 0))
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 245L, 1L, false);
          if (com.tencent.mm.bl.e.a(this.irI, this.jNP, this.itU) < 0) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 246L, 1L, false);
          }
          this.puV = ((int)com.tencent.mm.sdk.platformtools.bt.aO(l));
          ad.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.irI, this.jNP, Integer.valueOf(this.puT), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight) });
          if (this.puT < 0) {
            break label1190;
          }
          bool = true;
          this.puU = bool;
          ??? = new PInt();
          localObject3 = new PInt();
          if ((this.puT <= 0) && (u.a(this.jNP, (PInt)???, (PInt)localObject3))) {
            this.puT = ((PInt)???).value;
          }
          if ((this.puU) && ((((this.itU.hVr & 0x1) != 0) && (!this.vTf)) || (((this.itU.hVr & 0x2) != 0) && (this.vTf)) || (this.itU.hVq == 1)))
          {
            ad.i("MicroMsg.ImportMultiVideo", "hseasun:[hardcoder] hwenc qp add metadata flag", new Object[] { Integer.valueOf(l.aNt()) });
            SightVideoJNI.addReportMetadata(this.jNP, this.sIH, this.itU.hVq, this.itU.hVr);
          }
          if (this.puU) {
            break label1196;
          }
          ad.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
          com.tencent.mm.vfs.i.deleteFile(this.jNP);
          com.tencent.mm.vfs.i.mz(this.irI, this.jNP);
        }
      }
      label915:
      label1190:
      label1196:
      PInt localPInt;
      for (;;)
      {
        if (l.aNt() != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, l.aNt());
          ad.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformance %s", new Object[] { Integer.valueOf(l.aNt()) });
          l.KY(0);
        }
        AppMethodBeat.o(127142);
        return true;
        try
        {
          String str = new com.tencent.mm.vfs.e(this.jNP).getName();
          localObject3 = this.jNP + ".tmp";
          localPInt = new PInt(0);
          if (!com.tencent.mm.plugin.a.e.b(this.jNP, (String)localObject3, localPInt)) {
            break;
          }
          bool = com.tencent.mm.vfs.i.deleteFile(this.jNP);
          localObject3 = new com.tencent.mm.vfs.e((String)localObject3);
          ad.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(com.tencent.mm.vfs.i.bb(((com.tencent.mm.vfs.e)localObject3).getParent() + "/", ((com.tencent.mm.vfs.e)localObject3).getName(), str)), q.B(((com.tencent.mm.vfs.e)localObject3).fOK()), this.jNP });
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 30L, 1L, false);
          ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azx().al(this.irI, this.jNP, this.puT);
        }
        catch (Exception localException2)
        {
          ad.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", new Object[] { localException2.toString() });
        }
      }
      if (localPInt.value != 1) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 31L, 1L, false);
      }
      for (;;)
      {
        ad.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.irI, this.jNP });
        break;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 32L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.f(13836, new Object[] { Integer.valueOf(600), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.aQJ()), this.jNP });
      }
    }
    
    public final boolean aEn()
    {
      AppMethodBeat.i(127143);
      ad.i("MicroMsg.ImportMultiVideo", "onPostExecute");
      for (;;)
      {
        synchronized (l.puO)
        {
          l.dsj().remove(this.fileName);
          if (this.puU)
          {
            l.fU(this.jNP, this.ELO);
            l.g(this.puU, this.irI, this.jNP);
            if (!com.tencent.mm.plugin.sight.base.c.yRa) {
              break label204;
            }
            i = 1;
            l.b(i, this.puV, this.irI, this.jNP, this.puT);
            if (this.ELO != 1) {
              break label209;
            }
            i = 8;
            if (!this.puU) {
              break label214;
            }
            j = 1;
            n.aMH().a(this.irI, this.jNP, this.toUser, "", "", i, j);
            ad.i("MicroMsg.ImportMultiVideo", "updateVideo");
            u.u(this.fileName, this.puT, 43);
            u.Hr(this.fileName);
            AppMethodBeat.o(127143);
            return false;
          }
        }
        l.fV(this.jNP, this.ELO);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.l
 * JD-Core Version:    0.7.0.1
 */