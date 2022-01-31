package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.compatible.j.a;
import com.tencent.mm.compatible.j.a.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public final class j
  extends Thread
{
  private static int dmY;
  private static HashMap<String, j.b> rHO = new HashMap();
  private static Object rHP = new byte[0];
  private static av rHQ;
  private Context context;
  private Intent intent;
  private boolean isStop;
  private List<String> rHE;
  private List<Integer> rHF;
  private List<String> rHG;
  private List<String> rHH;
  private List<Integer> rHI;
  private int rTo;
  private j.a rTp;
  private String talker;
  
  public j(Context paramContext, List<String> paramList, Intent paramIntent, String paramString, int paramInt, j.a parama)
  {
    this.context = paramContext;
    this.rHE = paramList;
    this.intent = paramIntent;
    this.rHF = new ArrayList();
    this.rHG = new ArrayList();
    this.rHH = new ArrayList();
    this.rHI = new ArrayList();
    this.rTp = parama;
    this.talker = paramString;
    this.rTo = paramInt;
  }
  
  public static boolean VM(String paramString)
  {
    synchronized (rHP)
    {
      boolean bool = rHO.containsKey(paramString);
      y.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public static void VN(String paramString)
  {
    for (boolean bool = true;; bool = false) {
      synchronized (rHP)
      {
        if (rHO.remove(paramString) != null)
        {
          y.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", new Object[] { paramString, Boolean.valueOf(bool) });
          return;
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2, VideoTransPara paramVideoTransPara, Intent arg6)
  {
    y.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    e(paramInt1, paramString1, paramString2, paramInt2);
    if (paramInt1 == -50002)
    {
      if (this.rTo == 1) {}
      for (paramInt1 = 230;; paramInt1 = 245)
      {
        y.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + paramInt1 + " importType : " + this.rTo);
        h.nFQ.a(106L, paramInt1, 1L, false);
        a(this.talker, paramString1, paramString2, ???, paramInt2, 141);
        return;
      }
    }
    if (paramInt1 == -50008)
    {
      h.nFQ.a(106L, 210L, 1L, false);
      a(this.talker, paramString1, paramString2, ???, paramInt2, 140);
      return;
    }
    if (paramInt1 == -50006)
    {
      if (u.a(paramString1, this.talker, paramString2, 43) < 0L)
      {
        a(this.talker, paramString1, paramString2, ???, paramInt2, 142);
        y.e("MicroMsg.ImportMultiVideo", "prepare");
        return;
      }
      if (rHQ == null) {
        rHQ = new av(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
      }
      j.b localb = new j.b((byte)0);
      synchronized (rHP)
      {
        rHO.put(paramString1, localb);
        localb.fileName = paramString1;
        localb.eFj = paramString2;
        o.Sr();
        localb.rHT = t.nS(paramString1);
        localb.rTo = this.rTo;
        localb.toUser = this.talker;
        localb.eHv = paramVideoTransPara;
        localb.mng = com.tencent.mm.bi.e.om(paramString2);
        localb.rTr = new com.tencent.mm.bi.g();
        rHQ.c(localb);
        return;
      }
    }
    if (paramInt1 < 0)
    {
      if (this.rTo == 1) {}
      for (paramInt1 = 229;; paramInt1 = 244)
      {
        y.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + paramInt1 + " importType : " + this.rTo);
        h.nFQ.a(106L, paramInt1, 1L, false);
        a(this.talker, paramString1, paramString2, ???, paramInt2, 142);
        return;
      }
    }
    u.c(paramString1, paramInt2, this.talker, paramString2);
    u.nZ(paramString1);
    if (this.rTo == 1) {}
    for (paramInt1 = 8;; paramInt1 = 1)
    {
      o.Sr();
      paramString1 = t.nS(paramString1);
      n.Sp().a(paramString2, paramString1, this.talker, "", "", paramInt1, 2);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject = new bi();
    ((bi)localObject).setStatus(5);
    ((bi)localObject).ec(paramString1);
    ((bi)localObject).bg(bd.iK(paramString1));
    ((bi)localObject).fA(1);
    ((bi)localObject).ed(paramString2);
    ((bi)localObject).setType(43);
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().T((bi)localObject);
    y.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((cs)localObject).field_msgId), Long.valueOf(((cs)localObject).field_msgSvrId), ((cs)localObject).field_talker, Integer.valueOf(((bi)localObject).getType()), Integer.valueOf(((cs)localObject).field_isSend), ((cs)localObject).field_imgPath, Integer.valueOf(((cs)localObject).field_status), Long.valueOf(((cs)localObject).field_createTime) });
    if (-1L == l) {
      y.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", new Object[] { paramString1 });
    }
    while (u.oe(paramString2) != null) {
      return;
    }
    o.Sr();
    localObject = t.nT(paramString2);
    i = paramInt1;
    for (;;)
    {
      try
      {
        paramIntent = a.h(this.context, paramIntent);
        if (paramIntent == null) {
          continue;
        }
        i = paramInt1;
        if (paramIntent.bitmap == null) {
          continue;
        }
        i = paramInt1;
        paramInt1 = bk.hv(paramIntent.duration);
        i = paramInt1;
        com.tencent.mm.sdk.platformtools.c.a(paramIntent.bitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
      }
      catch (Exception paramIntent)
      {
        int j;
        y.printErrStackTrace("MicroMsg.ImportMultiVideo", paramIntent, "", new Object[0]);
        paramInt1 = i;
        continue;
        i = 0;
        continue;
      }
      j = t.nU((String)localObject);
      o.Sr();
      i = t.nU(t.nS(paramString2));
      paramIntent = new s();
      paramIntent.fileName = paramString2;
      if (i <= 0) {
        continue;
      }
      paramIntent.ebK = i;
      paramIntent.eHE = j;
      paramIntent.eHH = paramInt1;
      paramIntent.bVI = paramString1;
      paramIntent.eHA = ((String)com.tencent.mm.kernel.g.DP().Dz().get(2, ""));
      paramIntent.createTime = bk.UX();
      paramIntent.eHF = bk.UX();
      paramIntent.eHN = null;
      paramIntent.eFj = paramString3;
      if (!bk.bl(paramString3)) {
        paramIntent.eHL = 1;
      }
      paramIntent.eHO = -1;
      paramIntent.status = paramInt2;
      paramIntent.eHI = ((int)l);
      if (o.Sr().b(paramIntent)) {
        break;
      }
      y.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", new Object[] { Long.valueOf(l) });
      return;
      i = paramInt1;
      com.tencent.mm.sdk.platformtools.c.a(com.tencent.mm.sdk.platformtools.c.ah(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, (String)localObject, true);
    }
  }
  
  /* Error */
  public static void c(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 509	android/media/MediaMetadataRetriever
    //   5: dup
    //   6: invokespecial 510	android/media/MediaMetadataRetriever:<init>	()V
    //   9: astore 5
    //   11: aload 5
    //   13: aload_0
    //   14: invokevirtual 513	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   17: aload 5
    //   19: bipush 18
    //   21: invokevirtual 517	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   24: iconst_0
    //   25: invokestatic 521	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   28: istore 4
    //   30: aload 5
    //   32: bipush 19
    //   34: invokevirtual 517	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   37: iconst_0
    //   38: invokestatic 521	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   41: istore_3
    //   42: aload_1
    //   43: iconst_0
    //   44: iload 4
    //   46: iastore
    //   47: aload_1
    //   48: iconst_1
    //   49: iload_3
    //   50: iastore
    //   51: iload_2
    //   52: iconst_3
    //   53: if_icmpge +64 -> 117
    //   56: iload 4
    //   58: iconst_2
    //   59: irem
    //   60: ifne +9 -> 69
    //   63: iload_3
    //   64: iconst_2
    //   65: irem
    //   66: ifeq +9 -> 75
    //   69: aload 5
    //   71: invokevirtual 524	android/media/MediaMetadataRetriever:release	()V
    //   74: return
    //   75: iload 4
    //   77: iload_3
    //   78: if_icmplt +18 -> 96
    //   81: iload 4
    //   83: sipush 640
    //   86: if_icmple +31 -> 117
    //   89: iload_3
    //   90: sipush 480
    //   93: if_icmple +24 -> 117
    //   96: iload 4
    //   98: iload_3
    //   99: if_icmpgt +33 -> 132
    //   102: iload 4
    //   104: sipush 480
    //   107: if_icmple +10 -> 117
    //   110: iload_3
    //   111: sipush 640
    //   114: if_icmpgt +18 -> 132
    //   117: aload_1
    //   118: iconst_0
    //   119: iload 4
    //   121: iastore
    //   122: aload_1
    //   123: iconst_1
    //   124: iload_3
    //   125: iastore
    //   126: aload 5
    //   128: invokevirtual 524	android/media/MediaMetadataRetriever:release	()V
    //   131: return
    //   132: iload 4
    //   134: iconst_2
    //   135: idiv
    //   136: istore 4
    //   138: iload_3
    //   139: iconst_2
    //   140: idiv
    //   141: istore_3
    //   142: iload_2
    //   143: iconst_1
    //   144: iadd
    //   145: istore_2
    //   146: goto -95 -> 51
    //   149: astore_0
    //   150: aconst_null
    //   151: astore_1
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 524	android/media/MediaMetadataRetriever:release	()V
    //   160: aload_0
    //   161: athrow
    //   162: astore_0
    //   163: aload 5
    //   165: astore_1
    //   166: goto -14 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramString	String
    //   0	169	1	paramArrayOfInt	int[]
    //   1	145	2	i	int
    //   41	101	3	j	int
    //   28	109	4	k	int
    //   9	155	5	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   2	11	149	finally
    //   11	42	162	finally
    //   132	142	162	finally
  }
  
  public static void ckx()
  {
    int i;
    synchronized (rHP)
    {
      i = rHO.size();
      rHO.clear();
      if (rHQ == null)
      {
        y.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", new Object[] { Integer.valueOf(i) });
        return;
      }
    }
    y.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", new Object[] { Integer.valueOf(i), Integer.valueOf(rHQ.uhx.size()) });
    rHQ.uhx.clear();
    rHQ = null;
  }
  
  private static void d(boolean paramBoolean, String paramString1, String paramString2)
  {
    int i = 1;
    if (paramBoolean) {}
    while ((bk.bl(paramString1)) || (bk.bl(paramString2)))
    {
      y.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
      return;
      i = 0;
    }
    try
    {
      long l1 = com.tencent.mm.vfs.e.aeQ(paramString1);
      long l2 = com.tencent.mm.vfs.e.aeQ(paramString2);
      int j = (int)(100L * l2 / l1);
      paramString1 = new StringBuilder();
      paramString1.append(i).append(";").append(l1).append(";");
      paramString1.append(l2).append(";").append(j);
      paramString1 = paramString1.toString();
      y.d("MicroMsg.AtomStatUtil", "report video remuxing : " + paramString1);
      h.nFQ.f(11098, new Object[] { Integer.valueOf(8001), paramString1 });
      return;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.AtomStatUtil", paramString1, "", new Object[0]);
      y.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + paramString1.toString());
    }
  }
  
  private static void dd(String paramString, int paramInt)
  {
    int j;
    int i;
    if (paramInt == 1)
    {
      j = 220;
      i = 228;
    }
    for (paramInt = 219;; paramInt = 233)
    {
      long l = com.tencent.mm.vfs.e.aeQ(paramString);
      i = bk.g((Integer)h.a((int)(l / 1024L), new int[] { 512, 1024, 2048, 5120, 8192, 10240, 15360, 20480 }, j, i));
      h.nFQ.a(106L, i, 1L, false);
      h.nFQ.a(106L, paramInt, 1L, false);
      y.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + i + " file len : " + l / 1024L + "K");
      return;
      j = 234;
      i = 242;
    }
  }
  
  private void e(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      this.rHF.add(Integer.valueOf(paramInt1));
      this.rHG.add(paramString1);
      this.rHH.add(paramString2);
      this.rHI.add(Integer.valueOf(paramInt2));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private void lM(boolean paramBoolean)
  {
    int i;
    if (this.rTo == 1) {
      if (paramBoolean) {
        i = 217;
      }
    }
    for (;;)
    {
      y.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + paramBoolean + " importType : " + this.rTo);
      h.nFQ.a(106L, i, 1L, false);
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
  
  private void x(Context paramContext, Intent paramIntent)
  {
    String str1 = t.nR((String)com.tencent.mm.kernel.g.DP().Dz().get(2, ""));
    o.Sr();
    String str2 = t.nT(str1);
    o.Sr();
    String str3 = t.nS(str1);
    boolean bool2 = aq.is2G(ae.getContext());
    String str4 = a.g(paramContext, paramIntent);
    if (bk.bl(str4))
    {
      y.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
      a(-50005, str1, str4, 0, null, paramIntent);
      return;
    }
    boolean bool1 = com.tencent.mm.plugin.a.c.pp(str4);
    int j = (int)com.tencent.mm.vfs.e.aeQ(str4);
    PInt localPInt;
    Object localObject;
    label189:
    int i;
    if (bool1)
    {
      y.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", new Object[] { Boolean.valueOf(bool1) });
      localPInt = new PInt();
      if (d.Nl().lQ(str4))
      {
        y.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[] { str4 });
        localPInt.value = 1;
        h.nFQ.a(422L, 51L, 1L, false);
        localObject = null;
        i = localPInt.value;
      }
    }
    int k;
    int m;
    for (;;)
    {
      y.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j) });
      switch (i)
      {
      default: 
        y.e("MicroMsg.ImportMultiVideo", "unknown check type");
        a(-50001, str1, str4, 0, null, paramIntent);
        return;
        localObject = com.tencent.mm.bi.e.on(str4);
        Boolean localBoolean = Boolean.valueOf(com.tencent.mm.bi.e.om(str4));
        y.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", new Object[] { localObject });
        VideoTransPara localVideoTransPara = d.Nl().b((VideoTransPara)localObject);
        if (localVideoTransPara == null)
        {
          y.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", new Object[] { localObject });
          localPInt.value = -5;
          localObject = null;
          break label189;
        }
        y.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", new Object[] { localVideoTransPara });
        if ((((VideoTransPara)localObject).videoBitrate <= 640000) || (localVideoTransPara.videoBitrate > ((VideoTransPara)localObject).videoBitrate))
        {
          y.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", new Object[] { localVideoTransPara, localObject });
          if (localBoolean.booleanValue())
          {
            localPInt.value = 0;
            break label189;
          }
          localPInt.value = 1;
          localObject = null;
          break label189;
        }
        if ((((VideoTransPara)localObject).fps >= 45) && (((VideoTransPara)localObject).duration * 1000 >= 180000))
        {
          localPInt.value = -6;
          localObject = null;
          break label189;
        }
        if (localBoolean.booleanValue())
        {
          localPInt.value = 0;
          localObject = localVideoTransPara;
          break label189;
        }
        bool2 = aq.is2G(ae.getContext());
        k = localVideoTransPara.width;
        m = localVideoTransPara.height;
        if (bool2)
        {
          i = 10485760;
          label581:
          if (!bool2) {
            break label625;
          }
        }
        label625:
        for (double d = 60000.0D;; d = 300000.0D)
        {
          localPInt.value = SightVideoJNI.shouldRemuxing(str4, k, m, i, d, 1000000);
          localObject = localVideoTransPara;
          break;
          i = 26214400;
          break label581;
        }
        if (bool2) {}
        for (i = 10485760;; i = 26214400)
        {
          if (j <= i) {
            break label667;
          }
          i = -5;
          localObject = null;
          break;
        }
        label667:
        y.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", new Object[] { Boolean.valueOf(bool1) });
        i = 1;
        localObject = null;
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
        paramContext = a.h(paramContext, paramIntent);
        if (paramContext != null) {
          break;
        }
        y.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
        a(-50005, str1, str4, 0, null, paramIntent);
        return;
        j = 0;
        i = 0;
        continue;
        j = 1;
        i = 0;
      }
      a(-50007, str1, str4, 0, null, paramIntent);
      return;
      a(-50002, str1, str4, 0, null, paramIntent);
      return;
      a(-50008, str1, str4, 0, null, paramIntent);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    if (j == 0)
    {
      com.tencent.mm.vfs.e.r(str4, str3);
      dd(str3, this.rTo);
      d(false, str4, str3);
    }
    for (;;)
    {
      int n = bk.hv(paramContext.duration);
      m = 1;
      k = 1;
      if (paramContext.bitmap != null) {
        k = m;
      }
      try
      {
        com.tencent.mm.sdk.platformtools.c.a(paramContext.bitmap, 60, Bitmap.CompressFormat.JPEG, str2, true);
        k = 0;
        m = 0;
        lM(true);
        k = m;
        if (k == 0) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          lM(false);
          com.tencent.mm.sdk.platformtools.c.a(com.tencent.mm.sdk.platformtools.c.ah(-16777216, 320, 480), 60, Bitmap.CompressFormat.JPEG, str2, true);
          k = i;
          if (j == 0)
          {
            k = i;
            if (!com.tencent.mm.vfs.e.bK(str3)) {
              k = -50003;
            }
          }
          if (!com.tencent.mm.vfs.e.bK(str2)) {
            k = -50004;
          }
          a(k, str1, str4, n, (VideoTransPara)localObject, paramIntent);
          return;
          i = -50006;
          continue;
          paramContext = paramContext;
          y.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.ImportMultiVideo", paramContext, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public final void ckw()
  {
    this.isStop = true;
    interrupt();
  }
  
  public final void run()
  {
    int i;
    if ((this.rHE != null) && (this.rHE.size() > 0)) {
      i = 0;
    }
    while ((i < this.rHE.size()) && (!this.isStop))
    {
      y.i("MicroMsg.ImportMultiVideo", "start to import %s", new Object[] { this.rHE.get(i) });
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse("file://" + (String)this.rHE.get(i)));
      x(this.context, localIntent);
      i += 1;
      continue;
      x(this.context, this.intent);
    }
    if ((this.rTp != null) && (!this.isStop)) {
      ai.d(new Runnable()
      {
        public final void run()
        {
          j.a locala = j.e(j.this);
          j.a(j.this);
          j.b(j.this);
          j.c(j.this);
          j.d(j.this);
          locala.ckA();
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.j
 * JD-Core Version:    0.7.0.1
 */