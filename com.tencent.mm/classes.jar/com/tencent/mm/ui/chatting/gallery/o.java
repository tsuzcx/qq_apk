package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.i.h;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.HashMap;

public final class o
{
  HashMap<String, Integer> AlC;
  com.tencent.mm.plugin.a.j AlD;
  int AlF;
  int AlG;
  long AlH;
  long AlI;
  private long AlJ;
  private int AlK;
  j KpE;
  a KpF;
  long fLF;
  String filename;
  int iuJ;
  int iuK;
  int iuM;
  int iuN;
  boolean iuP;
  int iuQ;
  private int iuR;
  boolean iuS;
  boolean iuT;
  int jIO;
  String mediaId;
  
  public o(j paramj)
  {
    AppMethodBeat.i(36394);
    this.iuJ = 0;
    this.iuK = 0;
    this.iuQ = 0;
    this.AlC = new HashMap();
    this.AlG = 0;
    this.iuS = false;
    this.iuT = false;
    this.KpE = paramj;
    reset();
    this.AlD = new com.tencent.mm.plugin.a.j();
    this.KpF = new a((byte)0);
    paramj = com.tencent.mm.n.g.acL().getValue("AndroidOnlineVideoArgs");
    if (!bu.isNullOrNil(paramj))
    {
      ae.i("MicroMsg.OnlineVideoUIHelper", "online video config : ".concat(String.valueOf(paramj)));
      paramj = paramj.split(";");
      if ((paramj != null) && (paramj.length >= 4))
      {
        this.KpF.iva = bu.getInt(paramj[0], 5);
        this.KpF.ivb = bu.getInt(paramj[1], 1);
        this.KpF.AlO = bu.getInt(paramj[2], 75);
        this.KpF.KpH = (bu.getInt(paramj[3], 1) * 1048576);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.KpF.iva = 5;
        this.KpF.ivb = 1;
        this.KpF.AlO = 75;
        this.KpF.KpH = 1048576;
      }
      ae.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.KpF.iva), Integer.valueOf(this.KpF.ivb), Integer.valueOf(this.KpF.AlO), Integer.valueOf(this.KpF.KpH) });
      this.iuR = this.KpF.iva;
      AppMethodBeat.o(36394);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(36405);
    paramPInt1.value = Math.max(paramInt, this.iuQ);
    if (this.iuK == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.iuR;
    }
    if (this.iuK == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.iuR + 8);
    }
    if ((this.iuK == 3) || (this.iuK == 4))
    {
      paramPInt1.value = this.iuQ;
      paramPInt2.value = (this.iuR + paramInt + 2 + this.KpF.ivb);
    }
    if (paramPInt2.value >= this.iuM + 1) {
      paramPInt2.value = (this.iuM + 1);
    }
    if (paramPInt2.value <= paramPInt1.value)
    {
      paramPInt1.value += this.KpF.ivb;
      AppMethodBeat.o(36405);
      return false;
    }
    ae.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.iuK), Integer.valueOf(this.iuQ), Integer.valueOf(this.iuR) });
    AppMethodBeat.o(36405);
    return true;
  }
  
  private static void fKT()
  {
    AppMethodBeat.i(36411);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 1L, 1L, false);
    AppMethodBeat.o(36411);
  }
  
  private static void fKU()
  {
    AppMethodBeat.i(36412);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 2L, 1L, false);
    AppMethodBeat.o(36412);
  }
  
  private static void fKV()
  {
    AppMethodBeat.i(36413);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 10L, 1L, false);
    AppMethodBeat.o(36413);
  }
  
  private static void fKW()
  {
    AppMethodBeat.i(36414);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 17L, 1L, false);
    AppMethodBeat.o(36414);
  }
  
  private void fKX()
  {
    AppMethodBeat.i(36415);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 24L, 1L, false);
    ae.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", new Object[] { Integer.valueOf(hashCode()), this.filename });
    com.tencent.mm.plugin.report.service.g.yxI.f(13836, new Object[] { Integer.valueOf(303), Long.valueOf(bu.aRi()), "" });
    AppMethodBeat.o(36415);
  }
  
  private static void fKY()
  {
    AppMethodBeat.i(36416);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 134L, 1L, false);
    AppMethodBeat.o(36416);
  }
  
  private boolean n(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(36406);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.AlD.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        bool = com.tencent.mm.modelvideo.o.aNi().isVideoDataAvailable(this.mediaId, localPInt1.value, localPInt2.value);
        if (bool) {
          break label333;
        }
        if (!this.AlC.containsKey(this.mediaId + 0 + "_-1"))
        {
          String str = this.mediaId + localPInt1.value + "_" + localPInt2.value;
          ae.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.iuT), Boolean.valueOf(paramBoolean) });
          if ((this.AlC.containsKey(str)) || ((this.iuT) && (!paramBoolean))) {
            break label314;
          }
          this.iuT = true;
          com.tencent.mm.modelvideo.o.aNi();
          com.tencent.mm.an.e.r(this.mediaId, localPInt1.value, localPInt2.value);
          this.AlC.put(str, Integer.valueOf(paramInt2));
        }
        AppMethodBeat.o(36406);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
        ae.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + localException.toString());
        boolean bool = false;
        continue;
        label314:
        ae.i("MicroMsg.OnlineVideoUIHelper", "already request video : ".concat(String.valueOf(localException)));
        continue;
        label333:
        ae.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
      }
    }
  }
  
  public final boolean aCb(String paramString)
  {
    AppMethodBeat.i(36400);
    boolean bool = bu.lX(paramString, this.mediaId);
    AppMethodBeat.o(36400);
    return bool;
  }
  
  public final boolean aXX(String paramString)
  {
    AppMethodBeat.i(36397);
    d.aHh();
    if (!d.aHr())
    {
      AppMethodBeat.o(36397);
      return false;
    }
    reset();
    Object localObject = u.Ia(paramString);
    if (localObject != null)
    {
      int i = ((s)localObject).hPI;
      if (i < this.KpF.KpH)
      {
        ae.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", new Object[] { Integer.valueOf(i), Integer.valueOf(this.KpF.KpH) });
        u.b((s)localObject, 9);
        fKW();
        AppMethodBeat.o(36397);
        return false;
      }
    }
    u.aw(paramString, 1);
    n.aNf();
    com.tencent.mm.modelvideo.o.aNi();
    localObject = com.tencent.mm.an.e.Fu(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(36397);
      return false;
    }
    this.mediaId = ((h)localObject).field_mediaId;
    this.jIO = ((h)localObject).fLH;
    this.filename = paramString;
    this.iuJ = 1;
    this.iuM = 0;
    boolean bool = com.tencent.mm.modelvideo.o.aNm().aND();
    com.tencent.mm.modelvideo.o.aNi().a((h)localObject, bool);
    this.fLF = bu.fpO();
    fKT();
    ae.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, paramString, Long.valueOf(this.fLF) });
    AppMethodBeat.o(36397);
    return true;
  }
  
  public final boolean bq(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36402);
    switch (this.iuJ)
    {
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      ae.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.iuJ), Integer.valueOf(this.iuK) });
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 4L, 1L, false);
      AppMethodBeat.o(36402);
      return paramBoolean;
      this.iuK = 2;
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      a(paramInt, localPInt1, localPInt2);
      if (n(localPInt1.value, localPInt2.value, true))
      {
        this.iuN = -1;
        this.iuP = false;
        this.iuQ = localPInt2.value;
        this.iuK = 3;
        this.KpE.aE(paramInt, paramBoolean);
        break;
      }
      this.iuN = paramInt;
      this.iuP = true;
      this.KpE.aMU();
    }
  }
  
  public final boolean c(bv parambv, s params)
  {
    AppMethodBeat.i(36396);
    if (parambv.cyH())
    {
      parambv = new h();
      parambv.fLl = "task_OnlineVideoUIHelper";
      parambv.field_mediaId = c.a("downvideo", params.createTime, params.getUser(), params.getFileName());
      parambv.url = params.ixh.hET;
      parambv.fLI = 1;
      parambv.fLD = 7;
      parambv.concurrentCount = 4;
      parambv.filename = params.getFileName();
      com.tencent.mm.modelvideo.o.aNh();
      parambv.field_fullpath = t.HJ(params.getFileName());
      parambv.fLH = params.hPI;
      this.mediaId = parambv.field_mediaId;
      this.jIO = parambv.fLH;
      this.filename = params.getFileName();
      this.iuJ = 1;
      this.iuM = 0;
      boolean bool = com.tencent.mm.modelvideo.o.aNm().aND();
      com.tencent.mm.modelvideo.o.aNi().a(parambv, bool);
      this.fLF = bu.fpO();
      ae.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, this.filename, Long.valueOf(this.fLF) });
      AppMethodBeat.o(36396);
      return true;
    }
    AppMethodBeat.o(36396);
    return false;
  }
  
  final void eeh()
  {
    AppMethodBeat.i(36401);
    ae.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", new Object[] { this.filename });
    eek();
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36393);
        if (o.this.KpE != null) {
          o.this.KpE.bY(o.this.filename, false);
        }
        AppMethodBeat.o(36393);
      }
    });
    AppMethodBeat.o(36401);
  }
  
  final void eek()
  {
    AppMethodBeat.i(36409);
    if (this.AlI == 0L) {
      this.AlI = bu.fpO();
    }
    AppMethodBeat.o(36409);
  }
  
  final Object[] eel()
  {
    AppMethodBeat.i(36410);
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.KpE.getPlayVideoDuration());
    if (this.AlI <= 0L) {
      this.AlI = bu.fpO();
    }
    int j = (int)(this.AlI - this.fLF);
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[1] = Integer.valueOf(i);
    if (this.AlH <= 0L) {
      this.AlH = bu.fpO();
    }
    j = (int)(this.AlH - this.fLF);
    i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(this.AlG);
    if (this.AlG > 0)
    {
      if (this.AlK == 0) {
        this.AlK = ((int)(this.AlK + bu.DD(this.AlJ)));
      }
      arrayOfObject[4] = Integer.valueOf(this.AlK / this.AlG);
    }
    for (;;)
    {
      arrayOfObject[5] = Integer.valueOf(this.KpE.getUiStayTime());
      arrayOfObject[6] = Integer.valueOf(this.KpE.rNq);
      AppMethodBeat.o(36410);
      return arrayOfObject;
      arrayOfObject[4] = Integer.valueOf(0);
    }
  }
  
  public final void fKQ()
  {
    AppMethodBeat.i(36398);
    ae.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
    int i;
    if (this.iuJ == 3)
    {
      i = 1;
      this.iuJ = 0;
      if (!bu.isNullOrNil(this.mediaId))
      {
        if (i == 0) {
          break label77;
        }
        fKS();
      }
    }
    for (;;)
    {
      com.tencent.mm.modelvideo.o.aNi().m(this.mediaId, eel());
      fKU();
      AppMethodBeat.o(36398);
      return;
      i = 0;
      break;
      label77:
      if (this.AlF >= this.KpF.AlO)
      {
        ae.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", new Object[] { Integer.valueOf(this.AlF), Integer.valueOf(this.KpF.AlO) });
        u.av(this.filename, 2);
        fKV();
      }
    }
  }
  
  public final void fKR()
  {
    AppMethodBeat.i(36407);
    String str = this.mediaId + 0 + "_-1";
    if (!this.AlC.containsKey(str))
    {
      ae.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", new Object[] { this.mediaId });
      com.tencent.mm.modelvideo.o.aNi();
      com.tencent.mm.an.e.r(this.mediaId, 0, -1);
      this.AlC.put(str, Integer.valueOf(0));
      fKX();
    }
    this.iuK = 5;
    AppMethodBeat.o(36407);
  }
  
  final void fKS()
  {
    AppMethodBeat.i(36408);
    com.tencent.mm.modelvideo.o.aNh();
    if (r.isH265Video(t.HJ(this.filename)))
    {
      ae.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", new Object[] { this.filename });
      if (u.If(this.filename)) {
        fKY();
      }
    }
    AppMethodBeat.o(36408);
  }
  
  public final boolean isStreaming()
  {
    AppMethodBeat.i(36399);
    if ((!bu.isNullOrNil(this.mediaId)) && ((this.iuJ == 1) || (this.iuJ == 3)))
    {
      AppMethodBeat.o(36399);
      return true;
    }
    AppMethodBeat.o(36399);
    return false;
  }
  
  public final boolean ql(int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    AppMethodBeat.i(36403);
    if (this.iuN != -1) {}
    for (int i = this.iuN;; i = paramInt)
    {
      ae.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.iuQ), Integer.valueOf(this.iuM), Integer.valueOf(this.iuJ), Long.valueOf(this.AlI - this.fLF), Boolean.valueOf(this.iuS) });
      boolean bool1 = bool2;
      switch (this.iuJ)
      {
      default: 
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(36403);
        return bool1;
        if (!qm(i))
        {
          this.iuP = true;
          if (this.iuQ <= 0) {
            if (this.iuN == -1)
            {
              this.iuK = 1;
              label184:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          this.KpE.aeB(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label672;
          }
          if (!n(localPInt1.value, localPInt2.value, false)) {
            break label680;
          }
          this.iuQ = Math.max(this.iuQ, localPInt2.value);
          bool1 = bool2;
          break;
          this.iuK = 2;
          break label184;
          ae.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.AlG + " playStatus : " + this.iuK);
          this.AlJ = bu.fpO();
          if ((this.iuK != 2) && (this.iuK != 4))
          {
            this.iuR += this.KpF.iva;
            this.iuR = Math.min(this.iuR, 60);
            this.AlG += 1;
            this.iuK = 4;
          }
          this.KpE.aMU();
          break label184;
          if ((this.AlG == 0) && (this.AlI == 0L)) {
            eek();
          }
          if (this.iuS)
          {
            this.KpE.aXV(this.filename);
            if (this.iuP) {
              if ((this.AlG == 0) && (this.AlI == 0L))
              {
                eek();
                label452:
                ae.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", new Object[] { Integer.valueOf(this.AlG), Integer.valueOf(this.AlK) });
                if (this.iuN == -1) {
                  break label558;
                }
                this.KpE.aE(this.iuN, true);
                this.iuN = -1;
                bool1 = false;
                label511:
                this.iuP = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.iuK = paramInt;
              label558:
              do
              {
                bool1 = true;
                break;
                if (this.AlJ <= 0L) {
                  break label452;
                }
                this.AlK = ((int)(this.AlK + bu.DD(this.AlJ)));
                break label452;
                if (this.KpE.edV())
                {
                  bool1 = false;
                  break label511;
                }
                bool1 = true;
                break label511;
              } while (this.iuK == 3);
              ae.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.iuK) });
              if (this.KpE.edV()) {
                paramInt = 3;
              } else {
                paramInt = this.iuK;
              }
            }
          }
          ae.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", new Object[] { this.filename });
          this.KpE.bY(this.filename, true);
          this.iuS = true;
          bool1 = true;
        }
        label672:
        ae.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
        label680:
        continue;
        eek();
        if (this.iuS)
        {
          if (this.iuP)
          {
            if (this.iuN == -1) {
              break label748;
            }
            this.KpE.aE(this.iuN, true);
            this.iuN = -1;
            bool1 = bool3;
          }
          for (;;)
          {
            this.iuP = bool1;
            this.KpE.aeB(i);
            bool1 = bool2;
            break;
            label748:
            if (this.KpE.edV()) {
              bool1 = bool3;
            } else {
              bool1 = true;
            }
          }
        }
        this.KpE.bY(this.filename, false);
        this.iuS = true;
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  public final boolean qm(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 614
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 57	com/tencent/mm/ui/chatting/gallery/o:iuJ	I
    //   10: iconst_3
    //   11: if_icmpne +11 -> 22
    //   14: ldc_w 614
    //   17: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_1
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 61	com/tencent/mm/ui/chatting/gallery/o:iuQ	I
    //   26: iload_1
    //   27: isub
    //   28: iconst_2
    //   29: if_icmpgt +22 -> 51
    //   32: aload_0
    //   33: getfield 61	com/tencent/mm/ui/chatting/gallery/o:iuQ	I
    //   36: aload_0
    //   37: getfield 179	com/tencent/mm/ui/chatting/gallery/o:iuM	I
    //   40: if_icmpge +11 -> 51
    //   43: ldc_w 614
    //   46: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_0
    //   50: ireturn
    //   51: new 174	com/tencent/mm/pointers/PInt
    //   54: dup
    //   55: invokespecial 247	com/tencent/mm/pointers/PInt:<init>	()V
    //   58: astore 4
    //   60: new 174	com/tencent/mm/pointers/PInt
    //   63: dup
    //   64: invokespecial 247	com/tencent/mm/pointers/PInt:<init>	()V
    //   67: astore 5
    //   69: aload_0
    //   70: getfield 82	com/tencent/mm/ui/chatting/gallery/o:AlD	Lcom/tencent/mm/plugin/a/j;
    //   73: iload_1
    //   74: iload_1
    //   75: iconst_2
    //   76: iadd
    //   77: aload 4
    //   79: aload 5
    //   81: invokevirtual 250	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   84: ifeq +98 -> 182
    //   87: invokestatic 256	com/tencent/mm/modelvideo/o:aNi	()Lcom/tencent/mm/an/e;
    //   90: aload_0
    //   91: getfield 258	com/tencent/mm/ui/chatting/gallery/o:mediaId	Ljava/lang/String;
    //   94: aload 4
    //   96: getfield 177	com/tencent/mm/pointers/PInt:value	I
    //   99: aload 5
    //   101: getfield 177	com/tencent/mm/pointers/PInt:value	I
    //   104: invokevirtual 264	com/tencent/mm/an/e:isVideoDataAvailable	(Ljava/lang/String;II)Z
    //   107: istore_2
    //   108: iload_2
    //   109: istore_3
    //   110: iload_2
    //   111: ifne +10 -> 121
    //   114: aload_0
    //   115: iload_1
    //   116: putfield 61	com/tencent/mm/ui/chatting/gallery/o:iuQ	I
    //   119: iload_2
    //   120: istore_3
    //   121: ldc_w 614
    //   124: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iload_3
    //   128: ireturn
    //   129: astore 4
    //   131: iconst_0
    //   132: istore_2
    //   133: ldc 109
    //   135: aload 4
    //   137: ldc 233
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 305	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc 109
    //   148: new 266	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 307
    //   155: invokespecial 310	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokevirtual 311	java/lang/Exception:toString	()Ljava/lang/String;
    //   163: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 314	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	187	0	this	o
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
    AppMethodBeat.i(36395);
    this.mediaId = "";
    this.filename = "";
    this.iuN = -1;
    this.AlF = 0;
    this.jIO = 0;
    this.iuQ = 0;
    this.iuM = 0;
    this.AlG = 0;
    this.iuK = 0;
    this.iuJ = 0;
    this.iuP = false;
    this.iuS = false;
    this.iuT = false;
    this.AlC.clear();
    if (this.KpF != null) {
      this.iuR = this.KpF.iva;
    }
    this.AlH = 0L;
    this.fLF = 0L;
    this.AlK = 0;
    this.AlJ = 0L;
    this.AlI = 0L;
    AppMethodBeat.o(36395);
  }
  
  static final class a
  {
    int AlO;
    int KpH;
    int iva;
    int ivb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.o
 * JD-Core Version:    0.7.0.1
 */