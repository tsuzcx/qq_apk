package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.j.a.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public final class j
  extends Thread
{
  private static int eez;
  private static HashMap<String, j.b> vyv;
  private static Object vyw;
  private static az vyx;
  private Context context;
  private Intent intent;
  private boolean isStop;
  private String talker;
  private int vKm;
  private j.a vKn;
  private List<String> vyl;
  private List<Integer> vym;
  private List<String> vyn;
  private List<String> vyo;
  private List<Integer> vyp;
  
  static
  {
    AppMethodBeat.i(50997);
    vyv = new HashMap();
    vyw = new byte[0];
    AppMethodBeat.o(50997);
  }
  
  public j(Context paramContext, List<String> paramList, Intent paramIntent, String paramString, int paramInt, j.a parama)
  {
    AppMethodBeat.i(50974);
    this.context = paramContext;
    this.vyl = paramList;
    this.intent = paramIntent;
    this.vym = new ArrayList();
    this.vyn = new ArrayList();
    this.vyo = new ArrayList();
    this.vyp = new ArrayList();
    this.vKn = parama;
    this.talker = paramString;
    this.vKm = paramInt;
    AppMethodBeat.o(50974);
  }
  
  private void E(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(50976);
    String str1 = t.ve((String)com.tencent.mm.kernel.g.RL().Ru().get(2, ""));
    o.alE();
    String str2 = t.vg(str1);
    o.alE();
    String str3 = t.vf(str1);
    boolean bool1 = at.is2G(ah.getContext());
    String str4 = com.tencent.mm.compatible.j.a.i(paramContext, paramIntent);
    if (bo.isNullOrNil(str4))
    {
      ab.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
      a(-50005, str1, str4, 0, null, paramIntent);
      AppMethodBeat.o(50976);
      return;
    }
    boolean bool2 = c.wE(str4);
    int j = (int)com.tencent.mm.vfs.e.avI(str4);
    VideoTransPara localVideoTransPara;
    int i;
    if (bool2)
    {
      ab.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", new Object[] { Boolean.valueOf(bool2) });
      PInt localPInt = new PInt();
      localVideoTransPara = a(str4, localPInt);
      i = localPInt.value;
    }
    for (;;)
    {
      ab.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(j) });
      switch (i)
      {
      default: 
        ab.e("MicroMsg.ImportMultiVideo", "unknown check type");
        a(-50001, str1, str4, 0, null, paramIntent);
        AppMethodBeat.o(50976);
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
        ab.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", new Object[] { Boolean.valueOf(bool2) });
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
        paramContext = com.tencent.mm.compatible.j.a.j(paramContext, paramIntent);
        if (paramContext != null) {
          break;
        }
        ab.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
        a(-50005, str1, str4, 0, null, paramIntent);
        AppMethodBeat.o(50976);
        return;
        j = 0;
        i = 0;
        continue;
        j = 1;
        i = 0;
      }
      a(-50007, str1, str4, 0, null, paramIntent);
      AppMethodBeat.o(50976);
      return;
      a(-50002, str1, str4, 0, null, paramIntent);
      AppMethodBeat.o(50976);
      return;
      a(-50008, str1, str4, 0, null, paramIntent);
      AppMethodBeat.o(50976);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    if (j == 0)
    {
      com.tencent.mm.vfs.e.C(str4, str3);
      ei(str3, this.vKm);
      e(false, str4, str3);
    }
    for (;;)
    {
      int n = bo.nX(paramContext.duration);
      int m = 1;
      int k = 1;
      if (paramContext.bitmap != null) {
        k = m;
      }
      try
      {
        com.tencent.mm.sdk.platformtools.d.a(paramContext.bitmap, 60, Bitmap.CompressFormat.JPEG, str2, true);
        k = 0;
        m = 0;
        oX(true);
        k = m;
        if (k == 0) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          oX(false);
          com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.au(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, str2, true);
          k = i;
          if (j == 0)
          {
            k = i;
            if (!com.tencent.mm.vfs.e.cN(str3)) {
              k = -50003;
            }
          }
          if (!com.tencent.mm.vfs.e.cN(str2)) {
            k = -50004;
          }
          a(k, str1, str4, n, localVideoTransPara, paramIntent);
          AppMethodBeat.o(50976);
          return;
          i = -50006;
          continue;
          paramContext = paramContext;
          ab.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
          }
        }
      }
    }
  }
  
  private static VideoTransPara a(String paramString, PInt paramPInt)
  {
    AppMethodBeat.i(50985);
    if (com.tencent.mm.modelcontrol.d.afW().sO(paramString))
    {
      ab.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[] { paramString });
      paramPInt.value = 1;
      dlg();
      AppMethodBeat.o(50985);
      return null;
    }
    VideoTransPara localVideoTransPara1 = com.tencent.mm.bj.e.vC(paramString);
    Boolean localBoolean = Boolean.valueOf(com.tencent.mm.bj.e.vB(paramString));
    ab.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", new Object[] { localVideoTransPara1 });
    VideoTransPara localVideoTransPara2 = com.tencent.mm.modelcontrol.d.afW().c(localVideoTransPara1);
    if (localVideoTransPara2 == null)
    {
      ab.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", new Object[] { localVideoTransPara1 });
      paramPInt.value = -5;
      AppMethodBeat.o(50985);
      return null;
    }
    ab.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", new Object[] { localVideoTransPara2 });
    if ((localVideoTransPara1.videoBitrate <= 640000) || (localVideoTransPara2.videoBitrate > localVideoTransPara1.videoBitrate))
    {
      ab.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", new Object[] { localVideoTransPara2, localVideoTransPara1 });
      if (localBoolean.booleanValue())
      {
        paramPInt.value = 0;
        AppMethodBeat.o(50985);
        return localVideoTransPara1;
      }
      paramPInt.value = 1;
      AppMethodBeat.o(50985);
      return null;
    }
    if ((localVideoTransPara1.fps >= 45) && (localVideoTransPara1.duration * 1000 >= 180000))
    {
      paramPInt.value = -6;
      AppMethodBeat.o(50985);
      return null;
    }
    if (localBoolean.booleanValue())
    {
      paramPInt.value = 0;
      AppMethodBeat.o(50985);
      return localVideoTransPara2;
    }
    boolean bool = at.is2G(ah.getContext());
    int j = localVideoTransPara2.width;
    int k = localVideoTransPara2.height;
    int i;
    if (bool)
    {
      i = 10485760;
      label316:
      if (!bool) {
        break label353;
      }
    }
    label353:
    for (double d = 60000.0D;; d = 300000.0D)
    {
      paramPInt.value = SightVideoJNI.shouldRemuxing(paramString, j, k, i, d, 1000000);
      break;
      i = 26214400;
      break label316;
    }
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2, VideoTransPara paramVideoTransPara, Intent arg6)
  {
    AppMethodBeat.i(50978);
    ab.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    f(paramInt1, paramString1, paramString2, paramInt2);
    if (paramInt1 == -50002)
    {
      dld();
      a(this.talker, paramString1, paramString2, ???, paramInt2, 141);
      AppMethodBeat.o(50978);
      return;
    }
    if (paramInt1 == -50008)
    {
      dlf();
      a(this.talker, paramString1, paramString2, ???, paramInt2, 140);
      AppMethodBeat.o(50978);
      return;
    }
    if (paramInt1 == -50006)
    {
      if (u.t(paramString1, this.talker, paramString2) < 0L)
      {
        a(this.talker, paramString1, paramString2, ???, paramInt2, 142);
        ab.e("MicroMsg.ImportMultiVideo", "prepare");
        AppMethodBeat.o(50978);
        return;
      }
      if (vyx == null) {
        vyx = new az(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
      }
      j.b localb = new j.b((byte)0);
      synchronized (vyw)
      {
        vyv.put(paramString1, localb);
        localb.fileName = paramString1;
        localb.fVa = paramString2;
        o.alE();
        localb.hAo = t.vf(paramString1);
        localb.vKm = this.vKm;
        localb.toUser = this.talker;
        localb.fXm = paramVideoTransPara;
        localb.oMo = com.tencent.mm.bj.e.vB(paramString2);
        localb.vKp = new com.tencent.mm.bj.g();
        vyx.e(localb);
        AppMethodBeat.o(50978);
        return;
      }
    }
    if (paramInt1 < 0)
    {
      dle();
      a(this.talker, paramString1, paramString2, ???, paramInt2, 142);
      AppMethodBeat.o(50978);
      return;
    }
    u.c(paramString1, paramInt2, this.talker, paramString2);
    u.vm(paramString1);
    if (this.vKm == 1) {}
    for (paramInt1 = 8;; paramInt1 = 1)
    {
      o.alE();
      paramString1 = t.vf(paramString1);
      n.alC().a(paramString2, paramString1, this.talker, "", "", paramInt1, 2);
      AppMethodBeat.o(50978);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50979);
    Object localObject = new bi();
    ((bi)localObject).setStatus(5);
    ((bi)localObject).kj(paramString1);
    ((bi)localObject).fQ(bf.py(paramString1));
    ((bi)localObject).hL(1);
    ((bi)localObject).kk(paramString2);
    ((bi)localObject).setType(43);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Z((bi)localObject);
    ab.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((dd)localObject).field_msgId), Long.valueOf(((dd)localObject).field_msgSvrId), ((dd)localObject).field_talker, Integer.valueOf(((bi)localObject).getType()), Integer.valueOf(((dd)localObject).field_isSend), ((dd)localObject).field_imgPath, Integer.valueOf(((dd)localObject).field_status), Long.valueOf(((dd)localObject).field_createTime) });
    if (-1L == l)
    {
      ab.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", new Object[] { paramString1 });
      AppMethodBeat.o(50979);
      return;
    }
    if (u.vr(paramString2) == null)
    {
      o.alE();
      localObject = t.vg(paramString2);
      i = paramInt1;
    }
    for (;;)
    {
      try
      {
        paramIntent = com.tencent.mm.compatible.j.a.j(this.context, paramIntent);
        if (paramIntent == null) {
          continue;
        }
        i = paramInt1;
        if (paramIntent.bitmap == null) {
          continue;
        }
        i = paramInt1;
        paramInt1 = bo.nX(paramIntent.duration);
        i = paramInt1;
        com.tencent.mm.sdk.platformtools.d.a(paramIntent.bitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
      }
      catch (Exception paramIntent)
      {
        int j;
        ab.printErrStackTrace("MicroMsg.ImportMultiVideo", paramIntent, "", new Object[0]);
        paramInt1 = i;
        continue;
        i = 0;
        continue;
      }
      j = t.vh((String)localObject);
      o.alE();
      i = t.vh(t.vf(paramString2));
      paramIntent = new s();
      paramIntent.fileName = paramString2;
      if (i <= 0) {
        continue;
      }
      paramIntent.fsd = i;
      paramIntent.fXu = j;
      paramIntent.fXx = paramInt1;
      paramIntent.cDt = paramString1;
      paramIntent.fXq = ((String)com.tencent.mm.kernel.g.RL().Ru().get(2, ""));
      paramIntent.createTime = bo.aox();
      paramIntent.fXv = bo.aox();
      paramIntent.fXD = null;
      paramIntent.fVa = paramString3;
      if (!bo.isNullOrNil(paramString3)) {
        paramIntent.fXB = 1;
      }
      paramIntent.fXE = -1;
      paramIntent.status = paramInt2;
      paramIntent.fXy = ((int)l);
      if (!o.alE().b(paramIntent)) {
        ab.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", new Object[] { Long.valueOf(l) });
      }
      AppMethodBeat.o(50979);
      return;
      i = paramInt1;
      com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.au(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
    }
  }
  
  public static boolean alk(String paramString)
  {
    AppMethodBeat.i(50983);
    synchronized (vyw)
    {
      boolean bool = vyv.containsKey(paramString);
      ab.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(50983);
      return bool;
    }
  }
  
  public static void all(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(50984);
    synchronized (vyw)
    {
      if (vyv.remove(paramString) != null)
      {
        ab.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(50984);
        return;
      }
      bool = false;
    }
  }
  
  /* Error */
  public static void c(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: ldc_w 645
    //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 647	android/media/MediaMetadataRetriever
    //   9: dup
    //   10: invokespecial 648	android/media/MediaMetadataRetriever:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: aload_0
    //   18: invokevirtual 651	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   21: aload 5
    //   23: bipush 18
    //   25: invokevirtual 655	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   28: iconst_0
    //   29: invokestatic 659	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   32: istore 4
    //   34: aload 5
    //   36: bipush 19
    //   38: invokevirtual 655	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   41: iconst_0
    //   42: invokestatic 659	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   45: istore_3
    //   46: aload_1
    //   47: iconst_0
    //   48: iload 4
    //   50: iastore
    //   51: aload_1
    //   52: iconst_1
    //   53: iload_3
    //   54: iastore
    //   55: iconst_0
    //   56: istore_2
    //   57: iload_2
    //   58: iconst_3
    //   59: if_icmpge +102 -> 161
    //   62: iload 4
    //   64: iconst_2
    //   65: irem
    //   66: ifne +9 -> 75
    //   69: iload_3
    //   70: iconst_2
    //   71: irem
    //   72: ifeq +47 -> 119
    //   75: aload 5
    //   77: invokevirtual 662	android/media/MediaMetadataRetriever:release	()V
    //   80: aload_1
    //   81: iconst_0
    //   82: iaload
    //   83: iconst_2
    //   84: irem
    //   85: ifeq +11 -> 96
    //   88: aload_1
    //   89: iconst_0
    //   90: aload_1
    //   91: iconst_0
    //   92: iaload
    //   93: iconst_1
    //   94: iadd
    //   95: iastore
    //   96: aload_1
    //   97: iconst_1
    //   98: iaload
    //   99: iconst_2
    //   100: irem
    //   101: ifeq +11 -> 112
    //   104: aload_1
    //   105: iconst_1
    //   106: aload_1
    //   107: iconst_1
    //   108: iaload
    //   109: iconst_1
    //   110: iadd
    //   111: iastore
    //   112: ldc_w 645
    //   115: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: return
    //   119: iload 4
    //   121: iload_3
    //   122: if_icmplt +18 -> 140
    //   125: iload 4
    //   127: sipush 640
    //   130: if_icmple +31 -> 161
    //   133: iload_3
    //   134: sipush 480
    //   137: if_icmple +24 -> 161
    //   140: iload 4
    //   142: iload_3
    //   143: if_icmpgt +71 -> 214
    //   146: iload 4
    //   148: sipush 480
    //   151: if_icmple +10 -> 161
    //   154: iload_3
    //   155: sipush 640
    //   158: if_icmpgt +56 -> 214
    //   161: aload_1
    //   162: iconst_0
    //   163: iload 4
    //   165: iastore
    //   166: aload_1
    //   167: iconst_1
    //   168: iload_3
    //   169: iastore
    //   170: aload 5
    //   172: invokevirtual 662	android/media/MediaMetadataRetriever:release	()V
    //   175: aload_1
    //   176: iconst_0
    //   177: iaload
    //   178: iconst_2
    //   179: irem
    //   180: ifeq +11 -> 191
    //   183: aload_1
    //   184: iconst_0
    //   185: aload_1
    //   186: iconst_0
    //   187: iaload
    //   188: iconst_1
    //   189: iadd
    //   190: iastore
    //   191: aload_1
    //   192: iconst_1
    //   193: iaload
    //   194: iconst_2
    //   195: irem
    //   196: ifeq +89 -> 285
    //   199: aload_1
    //   200: iconst_1
    //   201: aload_1
    //   202: iconst_1
    //   203: iaload
    //   204: iconst_1
    //   205: iadd
    //   206: iastore
    //   207: ldc_w 645
    //   210: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: return
    //   214: iload 4
    //   216: iconst_2
    //   217: idiv
    //   218: istore 4
    //   220: iload_3
    //   221: iconst_2
    //   222: idiv
    //   223: istore_3
    //   224: iload_2
    //   225: iconst_1
    //   226: iadd
    //   227: istore_2
    //   228: goto -171 -> 57
    //   231: astore_0
    //   232: aconst_null
    //   233: astore 5
    //   235: aload 5
    //   237: ifnull +8 -> 245
    //   240: aload 5
    //   242: invokevirtual 662	android/media/MediaMetadataRetriever:release	()V
    //   245: aload_1
    //   246: iconst_0
    //   247: iaload
    //   248: iconst_2
    //   249: irem
    //   250: ifeq +11 -> 261
    //   253: aload_1
    //   254: iconst_0
    //   255: aload_1
    //   256: iconst_0
    //   257: iaload
    //   258: iconst_1
    //   259: iadd
    //   260: iastore
    //   261: aload_1
    //   262: iconst_1
    //   263: iaload
    //   264: iconst_2
    //   265: irem
    //   266: ifeq +11 -> 277
    //   269: aload_1
    //   270: iconst_1
    //   271: aload_1
    //   272: iconst_1
    //   273: iaload
    //   274: iconst_1
    //   275: iadd
    //   276: iastore
    //   277: ldc_w 645
    //   280: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: aload_0
    //   284: athrow
    //   285: ldc_w 645
    //   288: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: return
    //   292: astore_0
    //   293: goto -58 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramString	String
    //   0	296	1	paramArrayOfInt	int[]
    //   56	172	2	i	int
    //   45	179	3	j	int
    //   32	187	4	k	int
    //   13	228	5	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   6	15	231	finally
    //   15	46	292	finally
    //   214	224	292	finally
  }
  
  public static void dlc()
  {
    AppMethodBeat.i(50982);
    int i;
    synchronized (vyw)
    {
      i = vyv.size();
      vyv.clear();
      if (vyx == null)
      {
        ab.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(50982);
        return;
      }
    }
    ab.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", new Object[] { Integer.valueOf(i), Integer.valueOf(vyx.ypC.size()) });
    vyx.ypC.clear();
    vyx = null;
    AppMethodBeat.o(50982);
  }
  
  private void dld()
  {
    AppMethodBeat.i(50987);
    if (this.vKm == 1) {}
    for (int i = 230;; i = 245)
    {
      ab.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i + " importType : " + this.vKm);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(50987);
      return;
    }
  }
  
  private void dle()
  {
    AppMethodBeat.i(50988);
    if (this.vKm == 1) {}
    for (int i = 229;; i = 244)
    {
      ab.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i + " importType : " + this.vKm);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(50988);
      return;
    }
  }
  
  private static void dlf()
  {
    AppMethodBeat.i(50990);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, 210L, 1L, false);
    AppMethodBeat.o(50990);
  }
  
  private static void dlg()
  {
    AppMethodBeat.i(50991);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(422L, 51L, 1L, false);
    AppMethodBeat.o(50991);
  }
  
  private static void e(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(50992);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.modelvideo.a.j(i, paramString1, paramString2);
      AppMethodBeat.o(50992);
      return;
    }
  }
  
  private static void ei(String paramString, int paramInt)
  {
    AppMethodBeat.i(50989);
    int j;
    int i;
    if (paramInt == 1)
    {
      j = 220;
      i = 228;
    }
    for (paramInt = 219;; paramInt = 233)
    {
      long l = com.tencent.mm.vfs.e.avI(paramString);
      i = bo.g((Integer)com.tencent.mm.plugin.report.service.h.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, j, i));
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, i, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, paramInt, 1L, false);
      ab.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + i + " file len : " + l / 1024L + "K");
      AppMethodBeat.o(50989);
      return;
      j = 234;
      i = 242;
    }
  }
  
  private void f(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(50981);
      this.vym.add(Integer.valueOf(paramInt1));
      this.vyn.add(paramString1);
      this.vyo.add(paramString2);
      this.vyp.add(Integer.valueOf(paramInt2));
      AppMethodBeat.o(50981);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private void oX(boolean paramBoolean)
  {
    AppMethodBeat.i(50986);
    int i;
    if (this.vKm == 1) {
      if (paramBoolean) {
        i = 217;
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + paramBoolean + " importType : " + this.vKm);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(50986);
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
  
  public final void dlb()
  {
    AppMethodBeat.i(50977);
    this.isStop = true;
    interrupt();
    AppMethodBeat.o(50977);
  }
  
  public final void run()
  {
    AppMethodBeat.i(50975);
    int i;
    if ((this.vyl != null) && (this.vyl.size() > 0)) {
      i = 0;
    }
    while ((i < this.vyl.size()) && (!this.isStop))
    {
      ab.i("MicroMsg.ImportMultiVideo", "start to import %s", new Object[] { this.vyl.get(i) });
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse("file://" + (String)this.vyl.get(i)));
      E(this.context, localIntent);
      i += 1;
      continue;
      E(this.context, this.intent);
    }
    if ((this.vKn != null) && (!this.isStop)) {
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(50971);
          j.a locala = j.e(j.this);
          j.a(j.this);
          j.b(j.this);
          j.c(j.this);
          j.d(j.this);
          locala.dlh();
          AppMethodBeat.o(50971);
        }
      });
    }
    AppMethodBeat.o(50975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.j
 * JD-Core Version:    0.7.0.1
 */