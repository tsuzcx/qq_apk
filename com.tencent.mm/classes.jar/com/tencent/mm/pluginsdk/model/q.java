package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.i.a.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.br;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sight.base.ABAPrams;
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
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.cc;
import com.tencent.mm.util.b.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class q
  extends Thread
{
  private static int lyw;
  private static HashMap<String, b> xzl;
  private static Object xzm;
  private static QueueWorkerThread xzn;
  private ABAPrams Gbz;
  private int XRg;
  private boolean XRh;
  public com.tencent.mm.modelimage.a XRi;
  public String XRj;
  private a XRk;
  private Context context;
  private Intent intent;
  private boolean isStop;
  private String talker;
  private List<String> xzb;
  private List<Integer> xzc;
  private List<String> xzd;
  private List<String> xze;
  private List<Integer> xzf;
  
  static
  {
    AppMethodBeat.i(127169);
    xzl = new HashMap();
    xzm = new byte[0];
    AppMethodBeat.o(127169);
  }
  
  public q(Context paramContext, List<String> paramList, Intent paramIntent, String paramString, int paramInt, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(244747);
    this.context = paramContext;
    this.xzb = paramList;
    this.intent = paramIntent;
    this.xzc = new ArrayList();
    this.xzd = new ArrayList();
    this.xze = new ArrayList();
    this.xzf = new ArrayList();
    this.XRk = parama;
    this.talker = paramString;
    this.XRg = paramInt;
    this.XRh = paramBoolean;
    AppMethodBeat.o(244747);
  }
  
  private void Ju(boolean paramBoolean)
  {
    AppMethodBeat.i(127158);
    int i;
    if (this.XRg == 1) {
      if (paramBoolean) {
        i = 217;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + paramBoolean + " importType : " + this.XRg);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, i, 1L, false);
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
    if (com.tencent.mm.modelcontrol.e.bIg().NE(paramString))
    {
      Log.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[] { paramString });
      paramPInt.value = 1;
      iHW();
      AppMethodBeat.o(127157);
      return null;
    }
    Object localObject2 = com.tencent.mm.be.e.Qz(paramString);
    Object localObject1 = Boolean.valueOf(com.tencent.mm.be.e.Qy(paramString));
    Log.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s, customVideoTransPara: %s", new Object[] { localObject2, this.XRj });
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.bIg().a((VideoTransPara)localObject2, this.XRj);
    if (localVideoTransPara == null)
    {
      Log.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", new Object[] { localObject2 });
      paramPInt.value = -5;
      AppMethodBeat.o(127157);
      return null;
    }
    Log.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", new Object[] { localVideoTransPara });
    int[] arrayOfInt = a(paramString, localVideoTransPara);
    if (arrayOfInt != null)
    {
      localVideoTransPara.videoBitrate = arrayOfInt[0];
      localVideoTransPara.width = arrayOfInt[1];
      localVideoTransPara.height = arrayOfInt[2];
    }
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
    localObject2 = com.tencent.mm.k.a.lZC;
    if (i * 1000 >= com.tencent.mm.k.a.aQy() * 1000)
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
      label358:
      if (!bool) {
        break label395;
      }
    }
    for (double d = 60000.0D;; d = com.tencent.mm.k.a.aQy() * 1000)
    {
      paramPInt.value = SightVideoJNI.shouldRemuxingVFS(paramString, j, k, i, d, 1000000);
      break;
      i = af.iIm();
      break label358;
      label395:
      localObject1 = com.tencent.mm.k.a.lZC;
    }
  }
  
  private void a(int paramInt1, String paramString1, String arg3, int paramInt2, VideoTransPara paramVideoTransPara, Intent paramIntent)
  {
    AppMethodBeat.i(127148);
    Log.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", new Object[] { ???, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    c(paramInt1, paramString1, ???, paramInt2);
    long l = y.bEl(???);
    if (paramInt1 == -50002)
    {
      iHT();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 141);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 == -50008)
    {
      iHV();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 140);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 == -50006)
    {
      b localb = new b((byte)0);
      for (;;)
      {
        synchronized (xzm)
        {
          xzl.put(paramString1, localb);
          if (paramInt2 <= 0)
          {
            paramInt1 = 1;
            if (ab.a(paramString1, paramInt1, this.talker, ???, com.tencent.mm.modelimage.a.a(this.XRi), this.XRh) >= 0L) {
              break label309;
            }
            a(this.talker, paramString1, ???, paramIntent, paramInt2, 142);
            ??? = com.tencent.mm.cb.d.acls;
            com.tencent.mm.cb.d.a(this.talker, paramString1, 2, paramInt2 * 1000L, l, l, avG(this.XRg), this.XRh, -1);
            Log.e("MicroMsg.ImportMultiVideo", "prepare");
          }
        }
        label309:
        synchronized (xzm)
        {
          xzl.remove(paramString1);
          AppMethodBeat.o(127148);
          return;
          paramString1 = finally;
          AppMethodBeat.o(127148);
          throw paramString1;
          paramInt1 = paramInt2;
        }
      }
      localb.fileName = paramString1;
      localb.oYj = ???;
      v.bOh();
      localb.rBg = aa.PX(paramString1);
      localb.XRg = this.XRg;
      localb.toUser = this.talker;
      localb.paR = paramVideoTransPara;
      localb.Gbz = this.Gbz;
      b.a(localb, com.tencent.mm.be.e.Qy(???));
      localb.XRm = new com.tencent.mm.be.g();
      localb.XRh = this.XRh;
      xzn.add(localb);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 < 0)
    {
      iHU();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 142);
      switch (paramInt1)
      {
      default: 
        paramInt1 = 2;
      }
      for (;;)
      {
        ??? = com.tencent.mm.cb.d.acls;
        com.tencent.mm.cb.d.a(this.talker, paramString1, paramInt1, paramInt2 * 1000L, l, l, avG(this.XRg), this.XRh, -1);
        AppMethodBeat.o(127148);
        return;
        paramInt1 = 11;
        continue;
        paramInt1 = 5;
      }
    }
    if (paramInt2 <= 0) {
      paramInt2 = Util.videoMsToSec(bpx(???));
    }
    for (;;)
    {
      paramVideoTransPara = null;
      if (this.XRh)
      {
        Log.d("MicroMsg.ImportMultiVideo", "import origin video");
        paramVideoTransPara = paramString1 + "origin";
        v.bOh();
        paramIntent = aa.PY(paramVideoTransPara);
        v.bOh();
        y.O(aa.PY(paramString1), paramIntent, false);
        v.bOh();
        paramIntent = aa.PX(paramVideoTransPara);
        y.O(???, paramIntent, false);
        if (y.ZC(paramIntent))
        {
          l = y.bEl(paramIntent);
          boolean bool = SightVideoJNI.optimizeMP4VFS(paramIntent);
          l = Math.abs(y.bEl(paramIntent) - l);
          if ((!bool) || (l > 1048576L))
          {
            y.deleteFile(paramIntent);
            y.O(???, paramIntent, false);
            Log.w("MicroMsg.ImportMultiVideo", "import origin video, modify moov fail, copy origin video again, optimize ret = " + paramInt1 + " file length diff = " + l);
          }
        }
        ab.a(paramVideoTransPara, null, paramInt2, this.talker, ???, 0, "", 43, null, "", 0, null, com.tencent.mm.modelimage.a.a(this.XRi), true);
      }
      ab.a(paramString1, paramVideoTransPara, paramInt2, this.talker, ???, 0, "", 43, null, "", 0, null, com.tencent.mm.modelimage.a.a(this.XRi));
      ab.Qh(paramString1);
      if (this.XRg == 1) {}
      for (paramInt1 = 8;; paramInt1 = 1)
      {
        v.bOh();
        paramVideoTransPara = aa.PX(paramString1);
        com.tencent.mm.modelvideo.u.bOf().a(???, paramVideoTransPara, this.talker, "", "", paramInt1, 2);
        paramIntent = com.tencent.mm.cb.d.acls;
        com.tencent.mm.cb.d.a(this.talker, paramString1, paramInt2 * 1000L, y.bEl(paramVideoTransPara), y.bEl(???), avG(this.XRg), this.XRh);
        AppMethodBeat.o(127148);
        return;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127149);
    Object localObject = new cc();
    ((cc)localObject).setStatus(5);
    ((cc)localObject).BS(paramString1);
    ((cc)localObject).setCreateTime(br.JN(paramString1));
    ((cc)localObject).pI(1);
    ((cc)localObject).BT(paramString2);
    ((cc)localObject).setType(43);
    long l = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba((cc)localObject);
    Log.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((fi)localObject).field_msgId), Long.valueOf(((fi)localObject).field_msgSvrId), ((fi)localObject).field_talker, Integer.valueOf(((cc)localObject).getType()), Integer.valueOf(((fi)localObject).field_isSend), ((fi)localObject).field_imgPath, Integer.valueOf(((fi)localObject).field_status), Long.valueOf(((cc)localObject).getCreateTime()) });
    if (-1L == l)
    {
      Log.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", new Object[] { paramString1 });
      AppMethodBeat.o(127149);
      return;
    }
    if (ab.Qo(paramString2) == null)
    {
      v.bOh();
      localObject = aa.PY(paramString2);
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
      j = aa.PZ((String)localObject);
      v.bOh();
      i = aa.PZ(aa.PX(paramString2));
      paramIntent = new z();
      paramIntent.fileName = paramString2;
      if (i <= 0) {
        continue;
      }
      paramIntent.osy = i;
      paramIntent.paZ = j;
      paramIntent.omT = paramInt1;
      paramIntent.hVQ = paramString1;
      paramIntent.paV = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, ""));
      paramIntent.createTime = Util.nowSecond();
      paramIntent.pba = Util.nowSecond();
      paramIntent.pbh = null;
      paramIntent.oYj = paramString3;
      if (!Util.isNullOrNil(paramString3)) {
        paramIntent.pbf = 1;
      }
      paramIntent.pbi = -1;
      paramIntent.status = paramInt2;
      paramIntent.pbc = ((int)l);
      if (!v.bOh().b(paramIntent)) {
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
    AppMethodBeat.i(244806);
    Object localObject = r.XRn;
    if (r.iHY()) {
      paramVideoTransPara.oCh = 1;
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
    if (((paramVideoTransPara.oCb == 1) || (paramVideoTransPara.oCb == 2)) && ((paramVideoTransPara.oCl == 2) || (paramVideoTransPara.oCl == 4) || (paramVideoTransPara.oCl == 1)))
    {
      this.Gbz = AdaptiveAdjustBitrate.a(paramString, paramVideoTransPara.height, paramVideoTransPara.width, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, 10.0F, 0.0F, paramVideoTransPara.oCl, paramVideoTransPara.oCd, paramVideoTransPara.oCf, paramVideoTransPara.oCg, paramVideoTransPara.oCh, paramVideoTransPara.oCi, paramVideoTransPara.oCj, false);
      if (this.Gbz != null) {
        localObject[0] = (this.Gbz.outputKbps * 1000);
      }
      if ((this.Gbz != null) && (this.Gbz.resolutionAdjust > 0))
      {
        localObject[1] = this.Gbz.outputWidth;
        localObject[2] = this.Gbz.outputHeight;
      }
      Log.i("MicroMsg.ImportMultiVideo", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(localObject[2]) });
      v.bOi();
      j.a(this.Gbz);
      AppMethodBeat.o(244806);
      return localObject;
    }
    Log.i("MicroMsg.ImportMultiVideo", "c2c ABA: No use ABA algorithm");
    AppMethodBeat.o(244806);
    return localObject;
  }
  
  private void aN(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(127146);
    String str1 = aa.PW(this.talker);
    v.bOh();
    String str2 = aa.PY(str1);
    v.bOh();
    String str3 = aa.PX(str1);
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
    boolean bool2 = com.tencent.mm.plugin.a.c.Sm(str4);
    int k = (int)y.bEl(str4);
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
      Log.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d config:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(af.iIm()) });
      switch (i)
      {
      default: 
        Log.e("MicroMsg.ImportMultiVideo", "unknown check type");
        a(-50001, str1, str4, 0, null, paramIntent);
        AppMethodBeat.o(127146);
        return;
        if (bool1) {}
        for (i = 10485760;; i = af.iIm())
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
    if (k > af.iIm())
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
      y.O(str4, str3, false);
      io(str3, this.XRg);
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
        Ju(true);
        j = m;
        if (j == 0) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          Ju(false);
          BitmapUtil.saveBitmapToImage(BitmapUtil.createColorBitmap(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, str2, true);
          j = i;
          if (k == 0)
          {
            j = i;
            if (!y.ZC(str3)) {
              j = -50003;
            }
          }
          if (!y.ZC(str2)) {
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
  
  private static long avG(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 2L;
    }
    return 5L;
  }
  
  /* Error */
  public static void b(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 818
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 820	com/tencent/mm/compatible/i/d
    //   9: dup
    //   10: invokespecial 821	com/tencent/mm/compatible/i/d:<init>	()V
    //   13: astore 7
    //   15: aload 7
    //   17: aload_0
    //   18: invokevirtual 826	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   21: aload 7
    //   23: bipush 18
    //   25: invokevirtual 830	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   28: iconst_0
    //   29: invokestatic 834	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   32: istore 6
    //   34: aload 7
    //   36: bipush 19
    //   38: invokevirtual 830	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   41: iconst_0
    //   42: invokestatic 834	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
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
    //   82: invokevirtual 837	android/media/MediaMetadataRetriever:release	()V
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
    //   117: ldc_w 818
    //   120: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   174: invokevirtual 837	android/media/MediaMetadataRetriever:release	()V
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
    //   209: ldc_w 818
    //   212: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   248: invokevirtual 837	android/media/MediaMetadataRetriever:release	()V
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
    //   283: ldc_w 818
    //   286: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_0
    //   290: athrow
    //   291: ldc_w 818
    //   294: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static int bpx(String paramString)
  {
    AppMethodBeat.i(244769);
    com.tencent.mm.compatible.i.d locald = new com.tencent.mm.compatible.i.d();
    locald.setDataSource(paramString);
    int i = Util.getInt(locald.extractMetadata(9), 0);
    AppMethodBeat.o(244769);
    return i;
  }
  
  public static boolean bpy(String paramString)
  {
    AppMethodBeat.i(127155);
    synchronized (xzm)
    {
      boolean bool = xzl.containsKey(paramString);
      Log.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(127155);
      return bool;
    }
  }
  
  public static void bpz(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127156);
    synchronized (xzm)
    {
      if (xzl.remove(paramString) != null)
      {
        Log.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(127156);
        return;
      }
      bool = false;
    }
  }
  
  private void c(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(127153);
      this.xzc.add(Integer.valueOf(paramInt1));
      this.xzd.add(paramString1);
      this.xze.add(paramString2);
      this.xzf.add(Integer.valueOf(paramInt2));
      AppMethodBeat.o(127153);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void c(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(127150);
    b(paramString, paramArrayOfInt, 640, 480);
    AppMethodBeat.o(127150);
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
  
  public static void iHS()
  {
    AppMethodBeat.i(127154);
    int i;
    synchronized (xzm)
    {
      i = xzl.size();
      xzl.clear();
      if (xzn == null)
      {
        Log.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(127154);
        return;
      }
    }
    Log.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", new Object[] { Integer.valueOf(i), Integer.valueOf(xzn.getQueueSize()) });
    xzn.clear();
    xzn = null;
    AppMethodBeat.o(127154);
  }
  
  private void iHT()
  {
    AppMethodBeat.i(127159);
    if (this.XRg == 1) {}
    for (int i = 230;; i = 245)
    {
      Log.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i + " importType : " + this.XRg);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127159);
      return;
    }
  }
  
  private void iHU()
  {
    AppMethodBeat.i(127160);
    if (this.XRg == 1) {}
    for (int i = 229;; i = 244)
    {
      Log.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i + " importType : " + this.XRg);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127160);
      return;
    }
  }
  
  private static void iHV()
  {
    AppMethodBeat.i(127162);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 210L, 1L, false);
    AppMethodBeat.o(127162);
  }
  
  private static void iHW()
  {
    AppMethodBeat.i(127163);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 51L, 1L, false);
    AppMethodBeat.o(127163);
  }
  
  private static void io(String paramString, int paramInt)
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
      long l = y.bEl(paramString);
      i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, j, i));
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, i, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, paramInt, 1L, false);
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
      com.tencent.mm.modelvideo.a.n(i, paramString1, paramString2);
      AppMethodBeat.o(127164);
      return;
    }
  }
  
  public final void iHR()
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
    if ((this.xzb != null) && (this.xzb.size() > 0)) {
      i = 0;
    }
    while ((i < this.xzb.size()) && (!this.isStop))
    {
      Log.i("MicroMsg.ImportMultiVideo", "start to import %s", new Object[] { this.xzb.get(i) });
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse("file://" + (String)this.xzb.get(i)));
      aN(this.context, localIntent);
      i += 1;
      continue;
      aN(this.context, this.intent);
    }
    if ((this.XRk != null) && (!this.isStop)) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127141);
          q.a locala = q.e(q.this);
          q.a(q.this);
          q.b(q.this);
          q.c(q.this);
          q.d(q.this);
          locala.iHX();
          AppMethodBeat.o(127141);
        }
      });
    }
    AppMethodBeat.o(127145);
  }
  
  public static abstract interface a
  {
    public abstract void iHX();
  }
  
  static final class b
    implements QueueWorkerThread.ThreadObject
  {
    ABAPrams Gbz;
    private boolean Lam = false;
    int XRg;
    boolean XRh;
    com.tencent.mm.be.g XRm;
    String fileName;
    String oYj;
    private int outputHeight;
    private int outputWidth;
    VideoTransPara paR;
    String rBg;
    String toUser;
    int xzs;
    private boolean xzt;
    private int xzu = 0;
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(127142);
      int i;
      for (;;)
      {
        synchronized (q.xzm)
        {
          if (!q.gmH().containsKey(this.fileName))
          {
            i = 1;
            j = i;
            if (i == 0)
            {
              if (ab.Qo(this.fileName) == null) {
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
        q.Hn(WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcEncodeVideoTimeout, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo"));
        Log.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(q.ddn()) });
        if ((this.paR == null) || (this.paR.oBZ)) {
          break label309;
        }
        this.outputWidth = this.paR.width;
      }
      Object localObject3;
      for (this.outputHeight = this.paR.height;; this.outputHeight = ???[1])
      {
        ??? = new PString();
        localObject3 = new PInt();
        if ((!((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.r.a.a.class)).bzI().a(this.oYj, (PString)???, (PInt)localObject3)) || (y.O(((PString)???).value, this.rBg, false) < 0L)) {
          break label342;
        }
        Log.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
        this.xzs = ((PInt)localObject3).value;
        this.xzt = true;
        AppMethodBeat.o(127142);
        return true;
        i = 0;
        break;
        label309:
        ??? = new int[2];
        q.f(this.oYj, (int[])???);
        this.outputWidth = ???[0];
      }
      label342:
      long l = Util.currentTicks();
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwz, 1) == 1)
      {
        bool1 = true;
        Log.i("MicroMsg.ImportMultiVideo", "expt enableUseCompositionTranscoder:%s", new Object[] { Boolean.valueOf(bool1) });
        ??? = com.tencent.mm.util.i.agtt;
        i = com.tencent.mm.util.i.a(b.a.agry, 0);
        if (i == 0) {
          break label2289;
        }
        Log.i("MicroMsg.ImportMultiVideo", "debug repairerConfig:%d", new Object[] { Integer.valueOf(i) });
        if (i != 1) {
          break label1327;
        }
        bool1 = true;
      }
      label433:
      label1866:
      label2289:
      for (boolean bool2 = bool1;; bool2 = bool1)
      {
        Log.i("MicroMsg.ImportMultiVideo", "final enableUseCompositionTranscoder:%s", new Object[] { Boolean.valueOf(bool2) });
        bool1 = false;
        try
        {
          ??? = new com.tencent.mm.compatible.i.d();
          ((com.tencent.mm.compatible.i.d)???).setDataSource(this.oYj);
          i = Util.getInt(((com.tencent.mm.compatible.i.d)???).extractMetadata(18), 0);
          j = Util.getInt(((com.tencent.mm.compatible.i.d)???).extractMetadata(19), 0);
          this.xzs = Math.round(Util.getInt(((com.tencent.mm.compatible.i.d)???).extractMetadata(9), 0) / 1000.0F);
          bool3 = g.nG(i, j);
          bool1 = bool3;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            boolean bool3;
            Log.printErrStackTrace("MicroMsg.ImportMultiVideo", localException1, "", new Object[0]);
            continue;
            i = 0;
            continue;
            this.xzs = SightVideoJNI.remuxingVFS(this.oYj, this.rBg, this.outputWidth, this.outputHeight, this.paR.videoBitrate, this.paR.oBP, 8, this.paR.oBO, 25.0F, this.paR.fps, null, 0, com.tencent.mm.plugin.sight.base.d.PFi, 0, 51);
            continue;
            Log.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", new Object[] { this.fileName });
            if (com.tencent.mm.plugin.sight.base.d.PFi) {
              com.tencent.mm.plugin.sight.base.d.PFk = (int)(com.tencent.mm.plugin.sight.base.d.PFk * 0.915D);
            }
            if ((this.Lam) || (bool1))
            {
              this.paR = new VideoTransPara();
              this.paR.width = this.outputWidth;
              this.paR.height = this.outputHeight;
              this.paR.videoBitrate = com.tencent.mm.plugin.sight.base.d.PFk;
              this.paR.oBP = com.tencent.mm.plugin.sight.base.d.PFj;
              this.paR.oBO = 2;
              this.paR.fps = ((int)com.tencent.mm.plugin.sight.base.d.PFl);
              this.paR.duration = com.tencent.mm.be.e.jx(this.oYj);
              com.tencent.mm.be.e.a(this.oYj, this.rBg, this.paR);
            }
            else
            {
              this.xzs = SightVideoJNI.remuxingVFS(this.oYj, this.rBg, this.outputWidth, this.outputHeight, com.tencent.mm.plugin.sight.base.d.PFk, com.tencent.mm.plugin.sight.base.d.PFj, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.d.PFl, null, 0, com.tencent.mm.plugin.sight.base.d.PFi, 0, 51);
              continue;
              if (this.paR == null)
              {
                this.paR = new VideoTransPara();
                this.paR.width = this.outputWidth;
                this.paR.height = this.outputHeight;
                this.paR.videoBitrate = com.tencent.mm.plugin.sight.base.d.PFk;
                this.paR.oBP = com.tencent.mm.plugin.sight.base.d.PFj;
                this.paR.oBO = 2;
                this.paR.fps = ((int)com.tencent.mm.plugin.sight.base.d.PFl);
                this.paR.duration = com.tencent.mm.be.e.jx(this.oYj);
              }
              for (;;)
              {
                Log.i("MicroMsg.ImportMultiVideo", "use composition transcoder, newPara:%s", new Object[] { this.paR });
                this.xzs = s.d(this.oYj, this.rBg, this.paR);
                Log.i("MicroMsg.ImportMultiVideo", "transferVideo finished retDuration:%s", new Object[] { Integer.valueOf(this.xzs) });
                if (this.xzs > 0) {
                  break;
                }
                Log.i("MicroMsg.ImportMultiVideo", "composition transcoder failed, fallback to use origin, isH265:%s", new Object[] { Boolean.valueOf(this.Lam) });
                if ((!this.Lam) && (!bool1)) {
                  break label1866;
                }
                com.tencent.mm.be.e.a(this.oYj, this.rBg, this.paR);
                break;
                this.paR.width = this.outputWidth;
                this.paR.height = this.outputHeight;
              }
              this.xzs = SightVideoJNI.remuxingVFS(this.oYj, this.rBg, this.outputWidth, this.outputHeight, com.tencent.mm.plugin.sight.base.d.PFk, com.tencent.mm.plugin.sight.base.d.PFj, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.d.PFl, null, 0, com.tencent.mm.plugin.sight.base.d.PFi, 0, 51);
              continue;
              bool3 = false;
              continue;
              str = "";
            }
          }
          Log.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
        }
        ??? = r.XRn;
        bool3 = r.iHY();
        Log.i("MicroMsg.ImportMultiVideo", "remuxing exportHevc:%s", new Object[] { Boolean.valueOf(bool3) });
        if ((!bool3) && (com.tencent.mm.plugin.sight.base.d.PFi)) {
          this.paR.videoBitrate = ((int)(this.paR.videoBitrate * 0.915D));
        }
        if (bool3)
        {
          Log.i("MicroMsg.ImportMultiVideo", "exportHevc set forceMediaCodec");
          bool1 = true;
          this.paR.oCh = 1;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 101L, 1L, false);
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 53L, 1L, false);
        Log.i("MicroMsg.ImportMultiVideo", "forceMediaCodec :%s", new Object[] { Boolean.valueOf(bool1) });
        Object localObject4;
        if (!bool2) {
          if (this.paR != null)
          {
            Log.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", new Object[] { this.paR });
            if (com.tencent.mm.plugin.sight.base.d.PFi) {
              this.paR.videoBitrate = ((int)(this.paR.videoBitrate * 0.915D));
            }
            ??? = s.XRo;
            bool3 = s.iHZ();
            if ((this.Lam) || (bool1) || (bool3))
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 245L, 1L, false);
              this.paR.width = this.outputWidth;
              this.paR.height = this.outputHeight;
              if (this.paR.oCh == 1)
              {
                i = 1;
                if (i != 0) {
                  bool3 = false;
                }
                if (bool3)
                {
                  Log.i("MicroMsg.ImportMultiVideo", "report avc hard encode");
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 52L, 1L, false);
                }
                if (com.tencent.mm.be.e.a(this.oYj, this.rBg, this.paR, bool3) < 0) {
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 246L, 1L, false);
                }
                this.xzu = ((int)Util.ticksToNow(l));
                Log.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d], cost:%s", new Object[] { this.oYj, this.rBg, Integer.valueOf(this.xzs), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight), Long.valueOf(Util.ticksToNow(l)) });
                if (this.xzs < 0) {
                  break label1915;
                }
                bool3 = true;
                this.xzt = bool3;
                ??? = new PInt();
                localObject3 = new PInt();
                if ((this.xzs <= 0) && (ab.a(this.rBg, (PInt)???, (PInt)localObject3))) {
                  this.xzs = ((PInt)???).value;
                }
                if ((this.xzt) && ((((this.paR.oCc & 0x1) != 0) && (!this.Lam)) || (((this.paR.oCc & 0x2) != 0) && (this.Lam)) || (this.paR.oCb == 1)))
                {
                  Log.i("MicroMsg.ImportMultiVideo", "hseasun:[hardcoder] hwenc qp add metadata flag", new Object[] { Integer.valueOf(q.ddn()) });
                  SightVideoJNI.addReportMetadata(this.rBg, this.Gbz, this.paR.oCb, this.paR.oCc);
                }
                ??? = com.tencent.mm.cb.d.acls;
                i = com.tencent.mm.cb.d.q(this.Lam, bool1, bool2);
                ??? = com.tencent.mm.cb.d.acls;
                bool1 = this.xzt;
                localObject3 = this.oYj;
                localObject4 = this.rBg;
                if (this.paR == null) {
                  break label1921;
                }
                ??? = this.paR.toString();
                com.tencent.mm.cb.d.a(bool1, i, (String)localObject3, (String)localObject4, (String)???, this.xzu);
                if (this.xzt) {
                  break label1929;
                }
                Log.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
                y.deleteFile(this.rBg);
                y.O(this.oYj, this.rBg, false);
                l = y.bEl(this.oYj);
                ??? = com.tencent.mm.cb.d.acls;
                com.tencent.mm.cb.d.a(this.toUser, this.fileName, 1, this.xzs * 1000L, l, l, q.avH(this.XRg), this.XRh, -1);
              }
            }
          }
        }
        for (;;)
        {
          if (q.ddn() != 0)
          {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, q.ddn());
            Log.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformance %s", new Object[] { Integer.valueOf(q.ddn()) });
            q.Hn(0);
          }
          AppMethodBeat.o(127142);
          return true;
          bool1 = false;
          break;
          bool1 = false;
          break label433;
          try
          {
            label1915:
            String str = new com.tencent.mm.vfs.u(this.rBg).getName();
            localObject3 = this.rBg + ".tmp";
            localObject4 = new PInt(0);
            if (!com.tencent.mm.plugin.a.e.b(this.rBg, (String)localObject3, (PInt)localObject4)) {
              break label2171;
            }
            bool1 = y.deleteFile(this.rBg);
            localObject3 = new com.tencent.mm.vfs.u((String)localObject3);
            Log.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(y.bF(((com.tencent.mm.vfs.u)localObject3).jKO() + "/", ((com.tencent.mm.vfs.u)localObject3).getName(), str)), ah.v(((com.tencent.mm.vfs.u)localObject3).jKT()), this.rBg });
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 30L, 1L, false);
            ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.r.a.a.class)).bzI().aO(this.oYj, this.rBg, this.xzs);
          }
          catch (Exception localException2)
          {
            Log.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", new Object[] { localException2.toString() });
          }
        }
        label2171:
        if (((PInt)localObject4).value != 1) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 31L, 1L, false);
        }
        for (;;)
        {
          Log.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(((PInt)localObject4).value), this.oYj, this.rBg });
          break;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 32L, 1L, false);
          com.tencent.mm.plugin.report.service.h.OAn.b(13836, new Object[] { Integer.valueOf(600), Long.valueOf(Util.nowSecond()), this.rBg });
        }
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(127143);
      Log.i("MicroMsg.ImportMultiVideo", "onPostExecute");
      for (;;)
      {
        synchronized (q.xzm)
        {
          q.gmH().remove(this.fileName);
          if (this.xzt)
          {
            q.ip(this.rBg, this.XRg);
            q.l(this.xzt, this.oYj, this.rBg);
            if (!com.tencent.mm.plugin.sight.base.d.PFi) {
              break label253;
            }
            i = 1;
            q.b(i, this.xzu, this.oYj, this.rBg, this.xzs);
            if (this.XRg != 1) {
              break label258;
            }
            i = 8;
            if (!this.xzt) {
              break label263;
            }
            j = 1;
            com.tencent.mm.modelvideo.u.bOf().a(this.oYj, this.rBg, this.toUser, "", "", i, j);
            ??? = com.tencent.mm.cb.d.acls;
            com.tencent.mm.cb.d.a(this.toUser, this.fileName, this.xzs * 1000L, y.bEl(this.rBg), y.bEl(this.oYj), q.avH(this.XRg), this.XRh);
            Log.i("MicroMsg.ImportMultiVideo", "updateVideo");
            ab.y(this.fileName, this.xzs, 43);
            ab.Qh(this.fileName);
            AppMethodBeat.o(127143);
            return false;
          }
        }
        q.iq(this.rBg, this.XRg);
        continue;
        label253:
        int i = 0;
        continue;
        label258:
        i = 1;
        continue;
        label263:
        int j = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.q
 * JD-Core Version:    0.7.0.1
 */