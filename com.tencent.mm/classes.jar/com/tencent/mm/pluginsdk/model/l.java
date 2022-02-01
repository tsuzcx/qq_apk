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
import com.tencent.mm.model.bl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public final class l
  extends Thread
{
  private static int fMX;
  private static HashMap<String, b> pBr;
  private static Object pBs;
  private static bf pBt;
  private int Fem;
  private l.a Fen;
  private Context context;
  private Intent intent;
  private boolean isStop;
  private List<String> pBh;
  private List<Integer> pBi;
  private List<String> pBj;
  private List<String> pBk;
  private List<Integer> pBl;
  private int[] sTT;
  private String talker;
  
  static
  {
    AppMethodBeat.i(127169);
    pBr = new HashMap();
    pBs = new byte[0];
    AppMethodBeat.o(127169);
  }
  
  public l(Context paramContext, List<String> paramList, Intent paramIntent, String paramString, int paramInt, l.a parama)
  {
    AppMethodBeat.i(127144);
    this.sTT = new int[29];
    this.context = paramContext;
    this.pBh = paramList;
    this.intent = paramIntent;
    this.pBi = new ArrayList();
    this.pBj = new ArrayList();
    this.pBk = new ArrayList();
    this.pBl = new ArrayList();
    this.Fen = parama;
    this.talker = paramString;
    this.Fem = paramInt;
    AppMethodBeat.o(127144);
  }
  
  private VideoTransPara a(String paramString, PInt paramPInt)
  {
    AppMethodBeat.i(127157);
    if (com.tencent.mm.modelcontrol.d.aHh().Fx(paramString))
    {
      ae.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[] { paramString });
      paramPInt.value = 1;
      fdp();
      AppMethodBeat.o(127157);
      return null;
    }
    VideoTransPara localVideoTransPara1 = com.tencent.mm.bk.e.Il(paramString);
    Boolean localBoolean = Boolean.valueOf(com.tencent.mm.bk.e.Ik(paramString));
    ae.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", new Object[] { localVideoTransPara1 });
    VideoTransPara localVideoTransPara2 = com.tencent.mm.modelcontrol.d.aHh().c(localVideoTransPara1);
    if (localVideoTransPara2 == null)
    {
      ae.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", new Object[] { localVideoTransPara1 });
      paramPInt.value = -5;
      AppMethodBeat.o(127157);
      return null;
    }
    ae.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", new Object[] { localVideoTransPara2 });
    int[] arrayOfInt = c(paramString, localVideoTransPara2);
    localVideoTransPara2.videoBitrate = arrayOfInt[0];
    localVideoTransPara2.width = arrayOfInt[1];
    localVideoTransPara2.height = arrayOfInt[2];
    if ((localVideoTransPara1.videoBitrate <= 640000) || (localVideoTransPara2.videoBitrate > localVideoTransPara1.videoBitrate))
    {
      ae.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", new Object[] { localVideoTransPara2, localVideoTransPara1 });
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
    boolean bool = az.is2G(ak.getContext());
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
    ae.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", new Object[] { ???, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    d(paramInt1, paramString1, ???, paramInt2);
    if (paramInt1 == -50002)
    {
      fdm();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 141);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 == -50008)
    {
      fdo();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 140);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 == -50006)
    {
      b localb = new b((byte)0);
      synchronized (pBs)
      {
        pBr.put(paramString1, localb);
        if (u.r(paramString1, this.talker, ???) >= 0L) {
          break label231;
        }
        a(this.talker, paramString1, ???, paramIntent, paramInt2, 142);
        ae.e("MicroMsg.ImportMultiVideo", "prepare");
      }
      synchronized (pBs)
      {
        pBr.remove(paramString1);
        AppMethodBeat.o(127148);
        return;
        paramString1 = finally;
        AppMethodBeat.o(127148);
        throw paramString1;
      }
      label231:
      if (pBt == null) {
        pBt = new bf(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
      }
      localb.fileName = paramString1;
      localb.iuC = ???;
      com.tencent.mm.modelvideo.o.aNh();
      localb.jRg = t.HJ(paramString1);
      localb.Fem = this.Fem;
      localb.toUser = this.talker;
      localb.iwO = paramVideoTransPara;
      localb.sTT = this.sTT;
      localb.wfj = com.tencent.mm.bk.e.Ik(???);
      localb.Fep = new com.tencent.mm.bk.g();
      pBt.c(localb);
      AppMethodBeat.o(127148);
      return;
    }
    if (paramInt1 < 0)
    {
      fdn();
      a(this.talker, paramString1, ???, paramIntent, paramInt2, 142);
      AppMethodBeat.o(127148);
      return;
    }
    u.c(paramString1, paramInt2, this.talker, ???);
    u.HT(paramString1);
    if (this.Fem == 1) {}
    for (paramInt1 = 8;; paramInt1 = 1)
    {
      com.tencent.mm.modelvideo.o.aNh();
      paramString1 = t.HJ(paramString1);
      n.aNf().a(???, paramString1, this.talker, "", "", paramInt1, 2);
      AppMethodBeat.o(127148);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127149);
    Object localObject = new bv();
    ((bv)localObject).setStatus(5);
    ((bv)localObject).ui(paramString1);
    ((bv)localObject).qN(bl.BQ(paramString1));
    ((bv)localObject).kt(1);
    ((bv)localObject).uj(paramString2);
    ((bv)localObject).setType(43);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ar((bv)localObject);
    ae.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(((ei)localObject).field_msgSvrId), ((ei)localObject).field_talker, Integer.valueOf(((bv)localObject).getType()), Integer.valueOf(((ei)localObject).field_isSend), ((ei)localObject).field_imgPath, Integer.valueOf(((ei)localObject).field_status), Long.valueOf(((ei)localObject).field_createTime) });
    if (-1L == l)
    {
      ae.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", new Object[] { paramString1 });
      AppMethodBeat.o(127149);
      return;
    }
    if (u.Ia(paramString2) == null)
    {
      com.tencent.mm.modelvideo.o.aNh();
      localObject = t.HK(paramString2);
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
        paramInt1 = com.tencent.mm.sdk.platformtools.bu.DE(paramIntent.duration);
        i = paramInt1;
        h.a(paramIntent.bitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
      }
      catch (Exception paramIntent)
      {
        int j;
        ae.printErrStackTrace("MicroMsg.ImportMultiVideo", paramIntent, "", new Object[0]);
        paramInt1 = i;
        continue;
        i = 0;
        continue;
      }
      j = t.HL((String)localObject);
      com.tencent.mm.modelvideo.o.aNh();
      i = t.HL(t.HJ(paramString2));
      paramIntent = new s();
      paramIntent.fileName = paramString2;
      if (i <= 0) {
        continue;
      }
      paramIntent.hPI = i;
      paramIntent.iwW = j;
      paramIntent.hKI = paramInt1;
      paramIntent.dED = paramString1;
      paramIntent.iwS = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, ""));
      paramIntent.createTime = com.tencent.mm.sdk.platformtools.bu.aRi();
      paramIntent.iwX = com.tencent.mm.sdk.platformtools.bu.aRi();
      paramIntent.ixe = null;
      paramIntent.iuC = paramString3;
      if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString3)) {
        paramIntent.ixc = 1;
      }
      paramIntent.ixf = -1;
      paramIntent.status = paramInt2;
      paramIntent.iwZ = ((int)l);
      if (!com.tencent.mm.modelvideo.o.aNh().b(paramIntent)) {
        ae.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", new Object[] { Long.valueOf(l) });
      }
      AppMethodBeat.o(127149);
      return;
      i = paramInt1;
      h.a(h.aK(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
    }
  }
  
  public static boolean aMV(String paramString)
  {
    AppMethodBeat.i(127155);
    synchronized (pBs)
    {
      boolean bool = pBr.containsKey(paramString);
      ae.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(127155);
      return bool;
    }
  }
  
  public static void aMW(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127156);
    synchronized (pBs)
    {
      if (pBr.remove(paramString) != null)
      {
        ae.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(127156);
        return;
      }
      bool = false;
    }
  }
  
  private void ag(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(127146);
    String str1 = t.HI(this.talker);
    com.tencent.mm.modelvideo.o.aNh();
    String str2 = t.HK(str1);
    com.tencent.mm.modelvideo.o.aNh();
    String str3 = t.HJ(str1);
    boolean bool1 = az.is2G(ak.getContext());
    String str4 = com.tencent.mm.compatible.h.a.i(paramContext, paramIntent);
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str4))
    {
      ae.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
      a(-50005, str1, str4, 0, null, paramIntent);
      AppMethodBeat.o(127146);
      return;
    }
    boolean bool2 = com.tencent.mm.plugin.a.c.Jz(str4);
    int j = (int)com.tencent.mm.vfs.o.aZR(str4);
    VideoTransPara localVideoTransPara;
    int i;
    if (bool2)
    {
      ae.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", new Object[] { Boolean.valueOf(bool2) });
      PInt localPInt = new PInt();
      localVideoTransPara = a(str4, localPInt);
      i = localPInt.value;
    }
    for (;;)
    {
      ae.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(j) });
      switch (i)
      {
      default: 
        ae.e("MicroMsg.ImportMultiVideo", "unknown check type");
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
        ae.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", new Object[] { Boolean.valueOf(bool2) });
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
        ae.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
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
        ae.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    if (j == 0)
    {
      com.tencent.mm.vfs.o.mF(str4, str3);
      gc(str3, this.Fem);
      f(false, str4, str3);
    }
    for (;;)
    {
      int n = com.tencent.mm.sdk.platformtools.bu.DE(paramContext.duration);
      int m = 1;
      int k = 1;
      if (paramContext.bitmap != null) {
        k = m;
      }
      try
      {
        h.a(paramContext.bitmap, 60, Bitmap.CompressFormat.JPEG, str2, true);
        k = 0;
        m = 0;
        vL(true);
        k = m;
        if (k == 0) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          vL(false);
          h.a(h.aK(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, str2, true);
          k = i;
          if (j == 0)
          {
            k = i;
            if (!com.tencent.mm.vfs.o.fB(str3)) {
              k = -50003;
            }
          }
          if (!com.tencent.mm.vfs.o.fB(str2)) {
            k = -50004;
          }
          a(k, str1, str4, n, localVideoTransPara, paramIntent);
          AppMethodBeat.o(127146);
          return;
          i = -50006;
          continue;
          paramContext = paramContext;
          ae.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
          }
        }
      }
    }
  }
  
  /* Error */
  public static void b(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 655
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 657	com/tencent/mm/compatible/h/d
    //   9: dup
    //   10: invokespecial 658	com/tencent/mm/compatible/h/d:<init>	()V
    //   13: astore 7
    //   15: aload 7
    //   17: aload_0
    //   18: invokevirtual 663	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   21: aload 7
    //   23: bipush 18
    //   25: invokevirtual 667	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   28: iconst_0
    //   29: invokestatic 671	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   32: istore 6
    //   34: aload 7
    //   36: bipush 19
    //   38: invokevirtual 667	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   41: iconst_0
    //   42: invokestatic 671	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
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
    //   82: invokevirtual 674	android/media/MediaMetadataRetriever:release	()V
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
    //   117: ldc_w 655
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
    //   174: invokevirtual 674	android/media/MediaMetadataRetriever:release	()V
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
    //   209: ldc_w 655
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
    //   248: invokevirtual 674	android/media/MediaMetadataRetriever:release	()V
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
    //   283: ldc_w 655
    //   286: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_0
    //   290: athrow
    //   291: ldc_w 655
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
  
  private int[] c(String paramString, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(217498);
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
    if (((paramVideoTransPara.hYi == 1) || (paramVideoTransPara.hYi == 2)) && ((paramVideoTransPara.hYs == 2) || (paramVideoTransPara.hYs == 4) || (paramVideoTransPara.hYs == 1)))
    {
      this.sTT = AdaptiveAdjustBitrate.a(paramString, paramVideoTransPara.height, paramVideoTransPara.width, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, 10.0F, 0.0F, paramVideoTransPara.hYs, paramVideoTransPara.hYk, paramVideoTransPara.hYl, paramVideoTransPara.hYm, paramVideoTransPara.hYn, paramVideoTransPara.hYo, paramVideoTransPara.hYp, paramVideoTransPara.hYq, false);
      if (this.sTT != null) {
        arrayOfInt[0] = (this.sTT[0] * 1000);
      }
      if (this.sTT[5] > 0)
      {
        arrayOfInt[1] = this.sTT[1];
        arrayOfInt[2] = this.sTT[2];
      }
      ae.i("MicroMsg.ImportMultiVideo", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(arrayOfInt[2]) });
      com.tencent.mm.modelvideo.o.aNi();
      com.tencent.mm.an.e.q(this.sTT);
      AppMethodBeat.o(217498);
      return arrayOfInt;
    }
    ae.i("MicroMsg.ImportMultiVideo", "c2c ABA: No use ABA algorithm");
    AppMethodBeat.o(217498);
    return arrayOfInt;
  }
  
  private void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(127153);
      this.pBi.add(Integer.valueOf(paramInt1));
      this.pBj.add(paramString1);
      this.pBk.add(paramString2);
      this.pBl.add(Integer.valueOf(paramInt2));
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
  
  public static void fdl()
  {
    AppMethodBeat.i(127154);
    int i;
    synchronized (pBs)
    {
      i = pBr.size();
      pBr.clear();
      if (pBt == null)
      {
        ae.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(127154);
        return;
      }
    }
    ae.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", new Object[] { Integer.valueOf(i), Integer.valueOf(pBt.IzC.size()) });
    pBt.IzC.clear();
    pBt = null;
    AppMethodBeat.o(127154);
  }
  
  private void fdm()
  {
    AppMethodBeat.i(127159);
    if (this.Fem == 1) {}
    for (int i = 230;; i = 245)
    {
      ae.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i + " importType : " + this.Fem);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127159);
      return;
    }
  }
  
  private void fdn()
  {
    AppMethodBeat.i(127160);
    if (this.Fem == 1) {}
    for (int i = 229;; i = 244)
    {
      ae.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i + " importType : " + this.Fem);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, i, 1L, false);
      AppMethodBeat.o(127160);
      return;
    }
  }
  
  private static void fdo()
  {
    AppMethodBeat.i(127162);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, 210L, 1L, false);
    AppMethodBeat.o(127162);
  }
  
  private static void fdp()
  {
    AppMethodBeat.i(127163);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 51L, 1L, false);
    AppMethodBeat.o(127163);
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
        int i = com.tencent.mm.sdk.platformtools.bu.getInt(locald.extractMetadata(18), 0);
        int j = com.tencent.mm.sdk.platformtools.bu.getInt(locald.extractMetadata(19), 0);
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
          ae.i("MicroMsg.ImportMultiVideo", "getImportProperRemuxingResolutionForC2C Width:%d Height:%d", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]) });
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
    ae.i("MicroMsg.ImportMultiVideo", "getImportProperRemuxingResolutionForC2C Width:%d Height:%d", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]) });
    AppMethodBeat.o(127151);
    throw paramString;
  }
  
  private static void gc(String paramString, int paramInt)
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
      long l = com.tencent.mm.vfs.o.aZR(paramString);
      i = com.tencent.mm.sdk.platformtools.bu.o((Integer)com.tencent.mm.plugin.report.service.g.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, j, i));
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, i, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, paramInt, 1L, false);
      ae.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + i + " file len : " + l / 1024L + "K");
      AppMethodBeat.o(127161);
      return;
      j = 234;
      i = 242;
    }
  }
  
  private void vL(boolean paramBoolean)
  {
    AppMethodBeat.i(127158);
    int i;
    if (this.Fem == 1) {
      if (paramBoolean) {
        i = 217;
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + paramBoolean + " importType : " + this.Fem);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, i, 1L, false);
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
  
  public final void fdk()
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
    if ((this.pBh != null) && (this.pBh.size() > 0)) {
      i = 0;
    }
    while ((i < this.pBh.size()) && (!this.isStop))
    {
      ae.i("MicroMsg.ImportMultiVideo", "start to import %s", new Object[] { this.pBh.get(i) });
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse("file://" + (String)this.pBh.get(i)));
      ag(this.context, localIntent);
      i += 1;
      continue;
      ag(this.context, this.intent);
    }
    if ((this.Fen != null) && (!this.isStop)) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127141);
          l.a locala = l.e(l.this);
          l.a(l.this);
          l.b(l.this);
          l.c(l.this);
          l.d(l.this);
          locala.fdq();
          AppMethodBeat.o(127141);
        }
      });
    }
    AppMethodBeat.o(127145);
  }
  
  static final class b
    implements bf.a
  {
    int Fem;
    com.tencent.mm.bk.g Fep;
    String fileName;
    String iuC;
    VideoTransPara iwO;
    String jRg;
    private int outputHeight;
    private int outputWidth;
    int pBx;
    private boolean pBy;
    private int pBz = 0;
    int[] sTT;
    String toUser;
    boolean wfj = false;
    
    public final boolean aEC()
    {
      AppMethodBeat.i(127142);
      int i;
      for (;;)
      {
        synchronized (l.pBs)
        {
          if (!l.dvy().containsKey(this.fileName))
          {
            i = 1;
            j = i;
            if (i == 0)
            {
              if (u.Ia(this.fileName) == null) {
                j = 1;
              }
            }
            else
            {
              if (j == 0) {
                break;
              }
              ae.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", new Object[] { this.fileName });
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
        l.LD(WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEncodeVideoTimeout, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo"));
        ae.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(l.aNR()) });
        if ((this.iwO == null) || (this.iwO.isDefault)) {
          break label308;
        }
        this.outputWidth = this.iwO.width;
      }
      Object localObject3;
      for (this.outputHeight = this.iwO.height;; this.outputHeight = ???[1])
      {
        ??? = new PString();
        localObject3 = new PInt();
        if ((!((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azN().a(this.iuC, (PString)???, (PInt)localObject3)) || (com.tencent.mm.vfs.o.mF(((PString)???).value, this.jRg) < 0L)) {
          break label341;
        }
        ae.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
        this.pBx = ((PInt)localObject3).value;
        this.pBy = true;
        AppMethodBeat.o(127142);
        return true;
        i = 0;
        break;
        label308:
        ??? = new int[2];
        l.g(this.iuC, (int[])???);
        this.outputWidth = ???[0];
      }
      label341:
      long l = com.tencent.mm.sdk.platformtools.bu.HQ();
      try
      {
        ??? = new com.tencent.mm.compatible.h.d();
        ((com.tencent.mm.compatible.h.d)???).setDataSource(this.iuC);
        j = com.tencent.mm.sdk.platformtools.bu.getInt(((com.tencent.mm.compatible.h.d)???).extractMetadata(18), 0);
        k = com.tencent.mm.sdk.platformtools.bu.getInt(((com.tencent.mm.compatible.h.d)???).extractMetadata(19), 0);
        this.pBx = Math.round(com.tencent.mm.sdk.platformtools.bu.getInt(((com.tencent.mm.compatible.h.d)???).extractMetadata(9), 0) / 1000.0F);
        i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qFS, 3000);
        ae.i("MicroMsg.ImportMultiVideo", "rawWidth %d rawHeight:%d limit:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
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
          ae.printErrStackTrace("MicroMsg.ImportMultiVideo", localException1, "", new Object[0]);
          i = 0;
          continue;
          this.pBx = SightVideoJNI.remuxingVFS(this.iuC, this.jRg, this.outputWidth, this.outputHeight, this.iwO.videoBitrate, this.iwO.hXX, 8, this.iwO.hXW, 25.0F, this.iwO.fps, null, 0, com.tencent.mm.plugin.sight.base.c.zhk, 0, 51);
          continue;
          ae.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", new Object[] { this.fileName });
          if (com.tencent.mm.plugin.sight.base.c.zhk) {
            com.tencent.mm.plugin.sight.base.c.zhm = (int)(com.tencent.mm.plugin.sight.base.c.zhm * 0.915D);
          }
          if ((this.wfj) || (i != 0))
          {
            this.iwO = new VideoTransPara();
            this.iwO.width = this.outputWidth;
            this.iwO.height = this.outputHeight;
            this.iwO.videoBitrate = com.tencent.mm.plugin.sight.base.c.zhm;
            this.iwO.hXX = com.tencent.mm.plugin.sight.base.c.zhl;
            this.iwO.hXW = 2;
            this.iwO.fps = ((int)com.tencent.mm.plugin.sight.base.c.zhn);
            this.iwO.duration = com.tencent.mm.bk.e.gu(this.iuC);
            com.tencent.mm.bk.e.a(this.iuC, this.jRg, this.iwO);
          }
          else
          {
            this.pBx = SightVideoJNI.remuxingVFS(this.iuC, this.jRg, this.outputWidth, this.outputHeight, com.tencent.mm.plugin.sight.base.c.zhm, com.tencent.mm.plugin.sight.base.c.zhl, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.c.zhn, null, 0, com.tencent.mm.plugin.sight.base.c.zhk, 0, 51);
            continue;
            bool = false;
          }
        }
        ae.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
      }
      if (this.iwO != null)
      {
        ae.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", new Object[] { this.iwO });
        if (com.tencent.mm.plugin.sight.base.c.zhk) {
          this.iwO.videoBitrate = ((int)(this.iwO.videoBitrate * 0.915D));
        }
        if ((this.wfj) || (i != 0))
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 245L, 1L, false);
          if (com.tencent.mm.bk.e.a(this.iuC, this.jRg, this.iwO) < 0) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 246L, 1L, false);
          }
          this.pBz = ((int)com.tencent.mm.sdk.platformtools.bu.aO(l));
          ae.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.iuC, this.jRg, Integer.valueOf(this.pBx), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight) });
          if (this.pBx < 0) {
            break label1190;
          }
          bool = true;
          this.pBy = bool;
          ??? = new PInt();
          localObject3 = new PInt();
          if ((this.pBx <= 0) && (u.a(this.jRg, (PInt)???, (PInt)localObject3))) {
            this.pBx = ((PInt)???).value;
          }
          if ((this.pBy) && ((((this.iwO.hYj & 0x1) != 0) && (!this.wfj)) || (((this.iwO.hYj & 0x2) != 0) && (this.wfj)) || (this.iwO.hYi == 1)))
          {
            ae.i("MicroMsg.ImportMultiVideo", "hseasun:[hardcoder] hwenc qp add metadata flag", new Object[] { Integer.valueOf(l.aNR()) });
            SightVideoJNI.addReportMetadata(this.jRg, this.sTT, this.iwO.hYi, this.iwO.hYj);
          }
          if (this.pBy) {
            break label1196;
          }
          ae.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
          com.tencent.mm.vfs.o.deleteFile(this.jRg);
          com.tencent.mm.vfs.o.mF(this.iuC, this.jRg);
        }
      }
      label915:
      label1190:
      label1196:
      PInt localPInt;
      for (;;)
      {
        if (l.aNR() != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, l.aNR());
          ae.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformance %s", new Object[] { Integer.valueOf(l.aNR()) });
          l.LD(0);
        }
        AppMethodBeat.o(127142);
        return true;
        try
        {
          String str = new k(this.jRg).getName();
          localObject3 = this.jRg + ".tmp";
          localPInt = new PInt(0);
          if (!com.tencent.mm.plugin.a.e.b(this.jRg, (String)localObject3, localPInt)) {
            break;
          }
          bool = com.tencent.mm.vfs.o.deleteFile(this.jRg);
          localObject3 = new k((String)localObject3);
          ae.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(com.tencent.mm.vfs.o.bc(((k)localObject3).getParent() + "/", ((k)localObject3).getName(), str)), w.B(((k)localObject3).fTh()), this.jRg });
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 30L, 1L, false);
          ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azN().an(this.iuC, this.jRg, this.pBx);
        }
        catch (Exception localException2)
        {
          ae.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", new Object[] { localException2.toString() });
        }
      }
      if (localPInt.value != 1) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 31L, 1L, false);
      }
      for (;;)
      {
        ae.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.iuC, this.jRg });
        break;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 32L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.f(13836, new Object[] { Integer.valueOf(600), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.aRi()), this.jRg });
      }
    }
    
    public final boolean aED()
    {
      AppMethodBeat.i(127143);
      ae.i("MicroMsg.ImportMultiVideo", "onPostExecute");
      for (;;)
      {
        synchronized (l.pBs)
        {
          l.dvy().remove(this.fileName);
          if (this.pBy)
          {
            l.gd(this.jRg, this.Fem);
            l.g(this.pBy, this.iuC, this.jRg);
            if (!com.tencent.mm.plugin.sight.base.c.zhk) {
              break label204;
            }
            i = 1;
            l.b(i, this.pBz, this.iuC, this.jRg, this.pBx);
            if (this.Fem != 1) {
              break label209;
            }
            i = 8;
            if (!this.pBy) {
              break label214;
            }
            j = 1;
            n.aNf().a(this.iuC, this.jRg, this.toUser, "", "", i, j);
            ae.i("MicroMsg.ImportMultiVideo", "updateVideo");
            u.u(this.fileName, this.pBx, 43);
            u.HT(this.fileName);
            AppMethodBeat.o(127143);
            return false;
          }
        }
        l.ge(this.jRg, this.Fem);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.l
 * JD-Core Version:    0.7.0.1
 */