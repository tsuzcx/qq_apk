package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class m
{
  String cBO;
  long edG;
  int fVi;
  int fVj;
  f fVk;
  int fVl;
  int fVm;
  boolean fVo;
  int fVp;
  private int fVq;
  boolean fVr;
  boolean fVs;
  String filename;
  int gVW;
  HashMap<String, Integer> rJI;
  int rJK;
  int rJL;
  long rJM;
  long rJN;
  private long rJO;
  private int rJP;
  j zOb;
  m.a zOc;
  
  public m(j paramj)
  {
    AppMethodBeat.i(32454);
    this.fVi = 0;
    this.fVj = 0;
    this.fVp = 0;
    this.rJI = new HashMap();
    this.rJL = 0;
    this.fVr = false;
    this.fVs = false;
    this.zOb = paramj;
    reset();
    this.fVk = new f();
    this.zOc = new m.a((byte)0);
    paramj = g.Nq().getValue("AndroidOnlineVideoArgs");
    if (!bo.isNullOrNil(paramj))
    {
      ab.i("MicroMsg.OnlineVideoUIHelper", "online video config : ".concat(String.valueOf(paramj)));
      paramj = paramj.split(";");
      if ((paramj != null) && (paramj.length >= 4))
      {
        this.zOc.fVz = bo.getInt(paramj[0], 5);
        this.zOc.fVA = bo.getInt(paramj[1], 1);
        this.zOc.rJT = bo.getInt(paramj[2], 75);
        this.zOc.zOe = (bo.getInt(paramj[3], 1) * 1048576);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.zOc.fVz = 5;
        this.zOc.fVA = 1;
        this.zOc.rJT = 75;
        this.zOc.zOe = 1048576;
      }
      ab.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.zOc.fVz), Integer.valueOf(this.zOc.fVA), Integer.valueOf(this.zOc.rJT), Integer.valueOf(this.zOc.zOe) });
      this.fVq = this.zOc.fVz;
      AppMethodBeat.o(32454);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(32464);
    paramPInt1.value = Math.max(paramInt, this.fVp);
    if (this.fVj == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.fVq;
    }
    if (this.fVj == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.fVq + 8);
    }
    if ((this.fVj == 3) || (this.fVj == 4))
    {
      paramPInt1.value = this.fVp;
      paramPInt2.value = (this.fVq + paramInt + 2 + this.zOc.fVA);
    }
    if (paramPInt2.value >= this.fVl + 1) {
      paramPInt2.value = (this.fVl + 1);
    }
    if (paramPInt2.value <= paramPInt1.value)
    {
      paramPInt1.value += this.zOc.fVA;
      AppMethodBeat.o(32464);
      return false;
    }
    ab.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.fVj), Integer.valueOf(this.fVp), Integer.valueOf(this.fVq) });
    AppMethodBeat.o(32464);
    return true;
  }
  
  private static void dKU()
  {
    AppMethodBeat.i(32470);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 1L, 1L, false);
    AppMethodBeat.o(32470);
  }
  
  private static void dKV()
  {
    AppMethodBeat.i(32471);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 2L, 1L, false);
    AppMethodBeat.o(32471);
  }
  
  private static void dKW()
  {
    AppMethodBeat.i(32472);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 10L, 1L, false);
    AppMethodBeat.o(32472);
  }
  
  private static void dKX()
  {
    AppMethodBeat.i(32473);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 17L, 1L, false);
    AppMethodBeat.o(32473);
  }
  
  private void dKY()
  {
    AppMethodBeat.i(32474);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 24L, 1L, false);
    ab.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", new Object[] { Integer.valueOf(hashCode()), this.filename });
    com.tencent.mm.plugin.report.service.h.qsU.e(13836, new Object[] { Integer.valueOf(303), Long.valueOf(bo.aox()), "" });
    AppMethodBeat.o(32474);
  }
  
  private static void dKZ()
  {
    AppMethodBeat.i(32475);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 134L, 1L, false);
    AppMethodBeat.o(32475);
  }
  
  private boolean i(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(32465);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.fVk.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        bool = o.alF().isVideoDataAvailable(this.cBO, localPInt1.value, localPInt2.value);
        if (bool) {
          break label335;
        }
        if (!this.rJI.containsKey(this.cBO + 0 + "_-1"))
        {
          String str = this.cBO + localPInt1.value + "_" + localPInt2.value;
          ab.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.fVs), Boolean.valueOf(paramBoolean) });
          if ((this.rJI.containsKey(str)) || ((this.fVs) && (!paramBoolean))) {
            break label316;
          }
          this.fVs = true;
          o.alF();
          com.tencent.mm.al.e.r(this.cBO, localPInt1.value, localPInt2.value);
          this.rJI.put(str, Integer.valueOf(paramInt2));
        }
        AppMethodBeat.o(32465);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
        ab.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + localException.toString());
        boolean bool = false;
        continue;
        label316:
        ab.i("MicroMsg.OnlineVideoUIHelper", "already request video : ".concat(String.valueOf(localException)));
        continue;
        label335:
        ab.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
      }
    }
  }
  
  public final boolean aJ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32461);
    switch (this.fVi)
    {
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      ab.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.fVi), Integer.valueOf(this.fVj) });
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 4L, 1L, false);
      AppMethodBeat.o(32461);
      return paramBoolean;
      this.fVj = 2;
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      a(paramInt, localPInt1, localPInt2);
      if (i(localPInt1.value, localPInt2.value, true))
      {
        this.fVm = -1;
        this.fVo = false;
        this.fVp = localPInt2.value;
        this.fVj = 3;
        this.zOb.ag(paramInt, paramBoolean);
        break;
      }
      this.fVm = paramInt;
      this.fVo = true;
      this.zOb.alq();
    }
  }
  
  public final boolean acc(String paramString)
  {
    AppMethodBeat.i(32459);
    boolean bool = bo.isEqual(paramString, this.cBO);
    AppMethodBeat.o(32459);
    return bool;
  }
  
  public final boolean auj(String paramString)
  {
    AppMethodBeat.i(32456);
    d.afW();
    if (!d.agd())
    {
      AppMethodBeat.o(32456);
      return false;
    }
    reset();
    Object localObject = u.vr(paramString);
    if (localObject != null)
    {
      int i = ((s)localObject).fsd;
      if (i < this.zOc.zOe)
      {
        ab.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", new Object[] { Integer.valueOf(i), Integer.valueOf(this.zOc.zOe) });
        u.b((s)localObject, 9);
        dKX();
        AppMethodBeat.o(32456);
        return false;
      }
    }
    u.ag(paramString, 1);
    n.alC();
    o.alF();
    localObject = com.tencent.mm.al.e.sL(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(32456);
      return false;
    }
    this.cBO = ((com.tencent.mm.i.h)localObject).field_mediaId;
    this.gVW = ((com.tencent.mm.i.h)localObject).edI;
    this.filename = paramString;
    this.fVi = 1;
    this.fVl = 0;
    boolean bool = o.alJ().alZ();
    o.alF().a((com.tencent.mm.i.h)localObject, bool);
    this.edG = bo.aoy();
    dKU();
    ab.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.cBO, paramString, Long.valueOf(this.edG) });
    AppMethodBeat.o(32456);
    return true;
  }
  
  final void cuh()
  {
    AppMethodBeat.i(32460);
    ab.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", new Object[] { this.filename });
    cuk();
    al.d(new m.2(this));
    AppMethodBeat.o(32460);
  }
  
  final void cuk()
  {
    AppMethodBeat.i(32468);
    if (this.rJN == 0L) {
      this.rJN = bo.aoy();
    }
    AppMethodBeat.o(32468);
  }
  
  final Object[] cul()
  {
    AppMethodBeat.i(32469);
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.zOb.getPlayVideoDuration());
    if (this.rJN <= 0L) {
      this.rJN = bo.aoy();
    }
    int j = (int)(this.rJN - this.edG);
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[1] = Integer.valueOf(i);
    if (this.rJM <= 0L) {
      this.rJM = bo.aoy();
    }
    j = (int)(this.rJM - this.edG);
    i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(this.rJL);
    if (this.rJL > 0)
    {
      if (this.rJP == 0) {
        this.rJP = ((int)(this.rJP + bo.hl(this.rJO)));
      }
      arrayOfObject[4] = Integer.valueOf(this.rJP / this.rJL);
    }
    for (;;)
    {
      arrayOfObject[5] = Integer.valueOf(this.zOb.getUiStayTime());
      arrayOfObject[6] = Integer.valueOf(this.zOb.mEx);
      AppMethodBeat.o(32469);
      return arrayOfObject;
      arrayOfObject[4] = Integer.valueOf(0);
    }
  }
  
  public final void dKR()
  {
    AppMethodBeat.i(32457);
    ab.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
    int i;
    if (this.fVi == 3)
    {
      i = 1;
      this.fVi = 0;
      if (!bo.isNullOrNil(this.cBO))
      {
        if (i == 0) {
          break label77;
        }
        dKT();
      }
    }
    for (;;)
    {
      o.alF().j(this.cBO, cul());
      dKV();
      AppMethodBeat.o(32457);
      return;
      i = 0;
      break;
      label77:
      if (this.rJK >= this.zOc.rJT)
      {
        ab.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", new Object[] { Integer.valueOf(this.rJK), Integer.valueOf(this.zOc.rJT) });
        u.af(this.filename, 2);
        dKW();
      }
    }
  }
  
  public final void dKS()
  {
    AppMethodBeat.i(32466);
    String str = this.cBO + 0 + "_-1";
    if (!this.rJI.containsKey(str))
    {
      ab.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", new Object[] { this.cBO });
      o.alF();
      com.tencent.mm.al.e.r(this.cBO, 0, -1);
      this.rJI.put(str, Integer.valueOf(0));
      dKY();
    }
    this.fVj = 5;
    AppMethodBeat.o(32466);
  }
  
  final void dKT()
  {
    AppMethodBeat.i(32467);
    o.alE();
    if (r.va(t.vf(this.filename)))
    {
      ab.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", new Object[] { this.filename });
      if (u.vw(this.filename)) {
        dKZ();
      }
    }
    AppMethodBeat.o(32467);
  }
  
  public final boolean isStreaming()
  {
    AppMethodBeat.i(32458);
    if ((!bo.isNullOrNil(this.cBO)) && ((this.fVi == 1) || (this.fVi == 3)))
    {
      AppMethodBeat.o(32458);
      return true;
    }
    AppMethodBeat.o(32458);
    return false;
  }
  
  public final boolean mj(int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    AppMethodBeat.i(32462);
    if (this.fVm != -1) {}
    for (int i = this.fVm;; i = paramInt)
    {
      ab.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.fVp), Integer.valueOf(this.fVl), Integer.valueOf(this.fVi), Long.valueOf(this.rJN - this.edG), Boolean.valueOf(this.fVr) });
      boolean bool1 = bool2;
      switch (this.fVi)
      {
      default: 
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(32462);
        return bool1;
        if (!mk(i))
        {
          this.fVo = true;
          if (this.fVp <= 0) {
            if (this.fVm == -1)
            {
              this.fVj = 1;
              label184:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          this.zOb.Qm(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label672;
          }
          if (!i(localPInt1.value, localPInt2.value, false)) {
            break label680;
          }
          this.fVp = Math.max(this.fVp, localPInt2.value);
          bool1 = bool2;
          break;
          this.fVj = 2;
          break label184;
          ab.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.rJL + " playStatus : " + this.fVj);
          this.rJO = bo.aoy();
          if ((this.fVj != 2) && (this.fVj != 4))
          {
            this.fVq += this.zOc.fVz;
            this.fVq = Math.min(this.fVq, 60);
            this.rJL += 1;
            this.fVj = 4;
          }
          this.zOb.alq();
          break label184;
          if ((this.rJL == 0) && (this.rJN == 0L)) {
            cuk();
          }
          if (this.fVr)
          {
            this.zOb.aui(this.filename);
            if (this.fVo) {
              if ((this.rJL == 0) && (this.rJN == 0L))
              {
                cuk();
                label452:
                ab.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", new Object[] { Integer.valueOf(this.rJL), Integer.valueOf(this.rJP) });
                if (this.fVm == -1) {
                  break label558;
                }
                this.zOb.ag(this.fVm, true);
                this.fVm = -1;
                bool1 = false;
                label511:
                this.fVo = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.fVj = paramInt;
              label558:
              do
              {
                bool1 = true;
                break;
                if (this.rJO <= 0L) {
                  break label452;
                }
                this.rJP = ((int)(this.rJP + bo.hl(this.rJO)));
                break label452;
                if (this.zOb.ctX())
                {
                  bool1 = false;
                  break label511;
                }
                bool1 = true;
                break label511;
              } while (this.fVj == 3);
              ab.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.fVj) });
              if (this.zOb.ctX()) {
                paramInt = 3;
              } else {
                paramInt = this.fVj;
              }
            }
          }
          ab.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", new Object[] { this.filename });
          this.zOb.bw(this.filename, true);
          this.fVr = true;
          bool1 = true;
        }
        label672:
        ab.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
        label680:
        continue;
        cuk();
        if (this.fVr)
        {
          if (this.fVo)
          {
            if (this.fVm == -1) {
              break label748;
            }
            this.zOb.ag(this.fVm, true);
            this.fVm = -1;
            bool1 = bool3;
          }
          for (;;)
          {
            this.fVo = bool1;
            this.zOb.Qm(i);
            bool1 = bool2;
            break;
            label748:
            if (this.zOb.ctX()) {
              bool1 = bool3;
            } else {
              bool1 = true;
            }
          }
        }
        this.zOb.bw(this.filename, false);
        this.fVr = true;
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  public final boolean mk(int paramInt)
  {
    // Byte code:
    //   0: sipush 32463
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 51	com/tencent/mm/ui/chatting/gallery/m:fVi	I
    //   10: iconst_3
    //   11: if_icmpne +11 -> 22
    //   14: sipush 32463
    //   17: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_1
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 55	com/tencent/mm/ui/chatting/gallery/m:fVp	I
    //   26: iload_1
    //   27: isub
    //   28: iconst_2
    //   29: if_icmpgt +22 -> 51
    //   32: aload_0
    //   33: getfield 55	com/tencent/mm/ui/chatting/gallery/m:fVp	I
    //   36: aload_0
    //   37: getfield 173	com/tencent/mm/ui/chatting/gallery/m:fVl	I
    //   40: if_icmpge +11 -> 51
    //   43: sipush 32463
    //   46: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_0
    //   50: ireturn
    //   51: new 168	com/tencent/mm/pointers/PInt
    //   54: dup
    //   55: invokespecial 233	com/tencent/mm/pointers/PInt:<init>	()V
    //   58: astore 4
    //   60: new 168	com/tencent/mm/pointers/PInt
    //   63: dup
    //   64: invokespecial 233	com/tencent/mm/pointers/PInt:<init>	()V
    //   67: astore 5
    //   69: aload_0
    //   70: getfield 76	com/tencent/mm/ui/chatting/gallery/m:fVk	Lcom/tencent/mm/plugin/a/f;
    //   73: iload_1
    //   74: iload_1
    //   75: iconst_2
    //   76: iadd
    //   77: aload 4
    //   79: aload 5
    //   81: invokevirtual 236	com/tencent/mm/plugin/a/f:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   84: ifeq +98 -> 182
    //   87: invokestatic 242	com/tencent/mm/modelvideo/o:alF	()Lcom/tencent/mm/al/e;
    //   90: aload_0
    //   91: getfield 244	com/tencent/mm/ui/chatting/gallery/m:cBO	Ljava/lang/String;
    //   94: aload 4
    //   96: getfield 171	com/tencent/mm/pointers/PInt:value	I
    //   99: aload 5
    //   101: getfield 171	com/tencent/mm/pointers/PInt:value	I
    //   104: invokevirtual 250	com/tencent/mm/al/e:isVideoDataAvailable	(Ljava/lang/String;II)Z
    //   107: istore_2
    //   108: iload_2
    //   109: istore_3
    //   110: iload_2
    //   111: ifne +10 -> 121
    //   114: aload_0
    //   115: iload_1
    //   116: putfield 55	com/tencent/mm/ui/chatting/gallery/m:fVp	I
    //   119: iload_2
    //   120: istore_3
    //   121: sipush 32463
    //   124: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iload_3
    //   128: ireturn
    //   129: astore 4
    //   131: iconst_0
    //   132: istore_2
    //   133: ldc 103
    //   135: aload 4
    //   137: ldc 222
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 291	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc 103
    //   148: new 252	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 293
    //   155: invokespecial 296	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokevirtual 297	java/lang/Exception:toString	()Ljava/lang/String;
    //   163: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 266	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 299	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: iload_2
    //   173: istore_3
    //   174: goto -53 -> 121
    //   177: astore 4
    //   179: goto -46 -> 133
    //   182: iconst_0
    //   183: istore_3
    //   184: goto -63 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	m
    //   0	187	1	paramInt	int
    //   107	66	2	bool1	boolean
    //   109	75	3	bool2	boolean
    //   58	37	4	localPInt1	PInt
    //   129	30	4	localException1	Exception
    //   177	1	4	localException2	Exception
    //   67	33	5	localPInt2	PInt
    // Exception table:
    //   from	to	target	type
    //   69	108	129	java/lang/Exception
    //   114	119	177	java/lang/Exception
  }
  
  public final void reset()
  {
    AppMethodBeat.i(32455);
    this.cBO = "";
    this.filename = "";
    this.fVm = -1;
    this.rJK = 0;
    this.gVW = 0;
    this.fVp = 0;
    this.fVl = 0;
    this.rJL = 0;
    this.fVj = 0;
    this.fVi = 0;
    this.fVo = false;
    this.fVr = false;
    this.fVs = false;
    this.rJI.clear();
    if (this.zOc != null) {
      this.fVq = this.zOc.fVz;
    }
    this.rJM = 0L;
    this.edG = 0L;
    this.rJP = 0;
    this.rJO = 0L;
    this.rJN = 0L;
    AppMethodBeat.o(32455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.m
 * JD-Core Version:    0.7.0.1
 */