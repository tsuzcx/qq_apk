package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.m.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.HashMap;

public final class n
{
  j IeE;
  a IeF;
  String filename;
  long frt;
  int hYA;
  private int hYB;
  boolean hYC;
  boolean hYD;
  int hYt;
  int hYu;
  int hYw;
  int hYx;
  boolean hYz;
  int jlZ;
  String mediaId;
  HashMap<String, Integer> yCZ;
  com.tencent.mm.plugin.a.j yDa;
  int yDc;
  int yDd;
  long yDe;
  long yDf;
  private long yDg;
  private int yDh;
  
  public n(j paramj)
  {
    AppMethodBeat.i(36394);
    this.hYt = 0;
    this.hYu = 0;
    this.hYA = 0;
    this.yCZ = new HashMap();
    this.yDd = 0;
    this.hYC = false;
    this.hYD = false;
    this.IeE = paramj;
    reset();
    this.yDa = new com.tencent.mm.plugin.a.j();
    this.IeF = new a((byte)0);
    paramj = g.ZY().getValue("AndroidOnlineVideoArgs");
    if (!bs.isNullOrNil(paramj))
    {
      ac.i("MicroMsg.OnlineVideoUIHelper", "online video config : ".concat(String.valueOf(paramj)));
      paramj = paramj.split(";");
      if ((paramj != null) && (paramj.length >= 4))
      {
        this.IeF.hYK = bs.getInt(paramj[0], 5);
        this.IeF.hYL = bs.getInt(paramj[1], 1);
        this.IeF.yDl = bs.getInt(paramj[2], 75);
        this.IeF.IeH = (bs.getInt(paramj[3], 1) * 1048576);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.IeF.hYK = 5;
        this.IeF.hYL = 1;
        this.IeF.yDl = 75;
        this.IeF.IeH = 1048576;
      }
      ac.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.IeF.hYK), Integer.valueOf(this.IeF.hYL), Integer.valueOf(this.IeF.yDl), Integer.valueOf(this.IeF.IeH) });
      this.hYB = this.IeF.hYK;
      AppMethodBeat.o(36394);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(36405);
    paramPInt1.value = Math.max(paramInt, this.hYA);
    if (this.hYu == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.hYB;
    }
    if (this.hYu == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.hYB + 8);
    }
    if ((this.hYu == 3) || (this.hYu == 4))
    {
      paramPInt1.value = this.hYA;
      paramPInt2.value = (this.hYB + paramInt + 2 + this.IeF.hYL);
    }
    if (paramPInt2.value >= this.hYw + 1) {
      paramPInt2.value = (this.hYw + 1);
    }
    if (paramPInt2.value <= paramPInt1.value)
    {
      paramPInt1.value += this.IeF.hYL;
      AppMethodBeat.o(36405);
      return false;
    }
    ac.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hYu), Integer.valueOf(this.hYA), Integer.valueOf(this.hYB) });
    AppMethodBeat.o(36405);
    return true;
  }
  
  private static void fpZ()
  {
    AppMethodBeat.i(36411);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 1L, 1L, false);
    AppMethodBeat.o(36411);
  }
  
  private static void fqa()
  {
    AppMethodBeat.i(36412);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 2L, 1L, false);
    AppMethodBeat.o(36412);
  }
  
  private static void fqb()
  {
    AppMethodBeat.i(36413);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 10L, 1L, false);
    AppMethodBeat.o(36413);
  }
  
  private static void fqc()
  {
    AppMethodBeat.i(36414);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 17L, 1L, false);
    AppMethodBeat.o(36414);
  }
  
  private void fqd()
  {
    AppMethodBeat.i(36415);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 24L, 1L, false);
    ac.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", new Object[] { Integer.valueOf(hashCode()), this.filename });
    com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(303), Long.valueOf(bs.aNx()), "" });
    AppMethodBeat.o(36415);
  }
  
  private static void fqe()
  {
    AppMethodBeat.i(36416);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 134L, 1L, false);
    AppMethodBeat.o(36416);
  }
  
  private boolean n(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(36406);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.yDa.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        bool = o.aJz().isVideoDataAvailable(this.mediaId, localPInt1.value, localPInt2.value);
        if (bool) {
          break label333;
        }
        if (!this.yCZ.containsKey(this.mediaId + 0 + "_-1"))
        {
          String str = this.mediaId + localPInt1.value + "_" + localPInt2.value;
          ac.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.hYD), Boolean.valueOf(paramBoolean) });
          if ((this.yCZ.containsKey(str)) || ((this.hYD) && (!paramBoolean))) {
            break label314;
          }
          this.hYD = true;
          o.aJz();
          com.tencent.mm.an.e.p(this.mediaId, localPInt1.value, localPInt2.value);
          this.yCZ.put(str, Integer.valueOf(paramInt2));
        }
        AppMethodBeat.o(36406);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
        ac.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + localException.toString());
        boolean bool = false;
        continue;
        label314:
        ac.i("MicroMsg.OnlineVideoUIHelper", "already request video : ".concat(String.valueOf(localException)));
        continue;
        label333:
        ac.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
      }
    }
  }
  
  public final boolean aQD(String paramString)
  {
    AppMethodBeat.i(36397);
    d.aDL();
    if (!d.aDV())
    {
      AppMethodBeat.o(36397);
      return false;
    }
    reset();
    Object localObject = u.Ej(paramString);
    if (localObject != null)
    {
      int i = ((s)localObject).hux;
      if (i < this.IeF.IeH)
      {
        ac.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", new Object[] { Integer.valueOf(i), Integer.valueOf(this.IeF.IeH) });
        u.b((s)localObject, 9);
        fqc();
        AppMethodBeat.o(36397);
        return false;
      }
    }
    u.at(paramString, 1);
    com.tencent.mm.modelvideo.n.aJw();
    o.aJz();
    localObject = com.tencent.mm.an.e.BT(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(36397);
      return false;
    }
    this.mediaId = ((com.tencent.mm.i.h)localObject).field_mediaId;
    this.jlZ = ((com.tencent.mm.i.h)localObject).frv;
    this.filename = paramString;
    this.hYt = 1;
    this.hYw = 0;
    boolean bool = o.aJD().aJV();
    o.aJz().a((com.tencent.mm.i.h)localObject, bool);
    this.frt = bs.eWj();
    fpZ();
    ac.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, paramString, Long.valueOf(this.frt) });
    AppMethodBeat.o(36397);
    return true;
  }
  
  public final boolean avD(String paramString)
  {
    AppMethodBeat.i(36400);
    boolean bool = bs.lr(paramString, this.mediaId);
    AppMethodBeat.o(36400);
    return bool;
  }
  
  public final boolean ba(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36402);
    switch (this.hYt)
    {
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      ac.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hYt), Integer.valueOf(this.hYu) });
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 4L, 1L, false);
      AppMethodBeat.o(36402);
      return paramBoolean;
      this.hYu = 2;
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      a(paramInt, localPInt1, localPInt2);
      if (n(localPInt1.value, localPInt2.value, true))
      {
        this.hYx = -1;
        this.hYz = false;
        this.hYA = localPInt2.value;
        this.hYu = 3;
        this.IeE.aw(paramInt, paramBoolean);
        break;
      }
      this.hYx = paramInt;
      this.hYz = true;
      this.IeE.aJm();
    }
  }
  
  public final boolean c(bo parambo, s params)
  {
    AppMethodBeat.i(36396);
    if (parambo.cru())
    {
      parambo = new com.tencent.mm.i.h();
      parambo.field_mediaId = c.a("downvideo", params.createTime, params.getUser(), params.getFileName());
      parambo.url = params.iaR.hjV;
      parambo.frw = 1;
      parambo.frr = 7;
      parambo.concurrentCount = 4;
      parambo.filename = params.getFileName();
      o.aJy();
      parambo.field_fullpath = t.DV(params.getFileName());
      parambo.frv = params.hux;
      this.mediaId = parambo.field_mediaId;
      this.jlZ = parambo.frv;
      this.filename = params.getFileName();
      this.hYt = 1;
      this.hYw = 0;
      boolean bool = o.aJD().aJV();
      o.aJz().a(parambo, bool);
      this.frt = bs.eWj();
      ac.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, this.filename, Long.valueOf(this.frt) });
      AppMethodBeat.o(36396);
      return true;
    }
    AppMethodBeat.o(36396);
    return false;
  }
  
  final void dOn()
  {
    AppMethodBeat.i(36401);
    ac.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", new Object[] { this.filename });
    dOq();
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36393);
        if (n.this.IeE != null) {
          n.this.IeE.bN(n.this.filename, false);
        }
        AppMethodBeat.o(36393);
      }
    });
    AppMethodBeat.o(36401);
  }
  
  final void dOq()
  {
    AppMethodBeat.i(36409);
    if (this.yDf == 0L) {
      this.yDf = bs.eWj();
    }
    AppMethodBeat.o(36409);
  }
  
  final Object[] dOr()
  {
    AppMethodBeat.i(36410);
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.IeE.getPlayVideoDuration());
    if (this.yDf <= 0L) {
      this.yDf = bs.eWj();
    }
    int j = (int)(this.yDf - this.frt);
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[1] = Integer.valueOf(i);
    if (this.yDe <= 0L) {
      this.yDe = bs.eWj();
    }
    j = (int)(this.yDe - this.frt);
    i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(this.yDd);
    if (this.yDd > 0)
    {
      if (this.yDh == 0) {
        this.yDh = ((int)(this.yDh + bs.Ap(this.yDg)));
      }
      arrayOfObject[4] = Integer.valueOf(this.yDh / this.yDd);
    }
    for (;;)
    {
      arrayOfObject[5] = Integer.valueOf(this.IeE.getUiStayTime());
      arrayOfObject[6] = Integer.valueOf(this.IeE.qUR);
      AppMethodBeat.o(36410);
      return arrayOfObject;
      arrayOfObject[4] = Integer.valueOf(0);
    }
  }
  
  public final void fpW()
  {
    AppMethodBeat.i(36398);
    ac.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
    int i;
    if (this.hYt == 3)
    {
      i = 1;
      this.hYt = 0;
      if (!bs.isNullOrNil(this.mediaId))
      {
        if (i == 0) {
          break label77;
        }
        fpY();
      }
    }
    for (;;)
    {
      o.aJz().k(this.mediaId, dOr());
      fqa();
      AppMethodBeat.o(36398);
      return;
      i = 0;
      break;
      label77:
      if (this.yDc >= this.IeF.yDl)
      {
        ac.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", new Object[] { Integer.valueOf(this.yDc), Integer.valueOf(this.IeF.yDl) });
        u.as(this.filename, 2);
        fqb();
      }
    }
  }
  
  public final void fpX()
  {
    AppMethodBeat.i(36407);
    String str = this.mediaId + 0 + "_-1";
    if (!this.yCZ.containsKey(str))
    {
      ac.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", new Object[] { this.mediaId });
      o.aJz();
      com.tencent.mm.an.e.p(this.mediaId, 0, -1);
      this.yCZ.put(str, Integer.valueOf(0));
      fqd();
    }
    this.hYu = 5;
    AppMethodBeat.o(36407);
  }
  
  final void fpY()
  {
    AppMethodBeat.i(36408);
    o.aJy();
    if (r.isH265Video(t.DV(this.filename)))
    {
      ac.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", new Object[] { this.filename });
      if (u.Eo(this.filename)) {
        fqe();
      }
    }
    AppMethodBeat.o(36408);
  }
  
  public final boolean isStreaming()
  {
    AppMethodBeat.i(36399);
    if ((!bs.isNullOrNil(this.mediaId)) && ((this.hYt == 1) || (this.hYt == 3)))
    {
      AppMethodBeat.o(36399);
      return true;
    }
    AppMethodBeat.o(36399);
    return false;
  }
  
  public final boolean pG(int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    AppMethodBeat.i(36403);
    if (this.hYx != -1) {}
    for (int i = this.hYx;; i = paramInt)
    {
      ac.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.hYA), Integer.valueOf(this.hYw), Integer.valueOf(this.hYt), Long.valueOf(this.yDf - this.frt), Boolean.valueOf(this.hYC) });
      boolean bool1 = bool2;
      switch (this.hYt)
      {
      default: 
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(36403);
        return bool1;
        if (!pH(i))
        {
          this.hYz = true;
          if (this.hYA <= 0) {
            if (this.hYx == -1)
            {
              this.hYu = 1;
              label184:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          this.IeE.abH(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label672;
          }
          if (!n(localPInt1.value, localPInt2.value, false)) {
            break label680;
          }
          this.hYA = Math.max(this.hYA, localPInt2.value);
          bool1 = bool2;
          break;
          this.hYu = 2;
          break label184;
          ac.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.yDd + " playStatus : " + this.hYu);
          this.yDg = bs.eWj();
          if ((this.hYu != 2) && (this.hYu != 4))
          {
            this.hYB += this.IeF.hYK;
            this.hYB = Math.min(this.hYB, 60);
            this.yDd += 1;
            this.hYu = 4;
          }
          this.IeE.aJm();
          break label184;
          if ((this.yDd == 0) && (this.yDf == 0L)) {
            dOq();
          }
          if (this.hYC)
          {
            this.IeE.aQB(this.filename);
            if (this.hYz) {
              if ((this.yDd == 0) && (this.yDf == 0L))
              {
                dOq();
                label452:
                ac.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", new Object[] { Integer.valueOf(this.yDd), Integer.valueOf(this.yDh) });
                if (this.hYx == -1) {
                  break label558;
                }
                this.IeE.aw(this.hYx, true);
                this.hYx = -1;
                bool1 = false;
                label511:
                this.hYz = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.hYu = paramInt;
              label558:
              do
              {
                bool1 = true;
                break;
                if (this.yDg <= 0L) {
                  break label452;
                }
                this.yDh = ((int)(this.yDh + bs.Ap(this.yDg)));
                break label452;
                if (this.IeE.dOb())
                {
                  bool1 = false;
                  break label511;
                }
                bool1 = true;
                break label511;
              } while (this.hYu == 3);
              ac.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.hYu) });
              if (this.IeE.dOb()) {
                paramInt = 3;
              } else {
                paramInt = this.hYu;
              }
            }
          }
          ac.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", new Object[] { this.filename });
          this.IeE.bN(this.filename, true);
          this.hYC = true;
          bool1 = true;
        }
        label672:
        ac.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
        label680:
        continue;
        dOq();
        if (this.hYC)
        {
          if (this.hYz)
          {
            if (this.hYx == -1) {
              break label748;
            }
            this.IeE.aw(this.hYx, true);
            this.hYx = -1;
            bool1 = bool3;
          }
          for (;;)
          {
            this.hYz = bool1;
            this.IeE.abH(i);
            bool1 = bool2;
            break;
            label748:
            if (this.IeE.dOb()) {
              bool1 = bool3;
            } else {
              bool1 = true;
            }
          }
        }
        this.IeE.bN(this.filename, false);
        this.hYC = true;
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  public final boolean pH(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 609
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 57	com/tencent/mm/ui/chatting/gallery/n:hYt	I
    //   10: iconst_3
    //   11: if_icmpne +11 -> 22
    //   14: ldc_w 609
    //   17: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_1
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 61	com/tencent/mm/ui/chatting/gallery/n:hYA	I
    //   26: iload_1
    //   27: isub
    //   28: iconst_2
    //   29: if_icmpgt +22 -> 51
    //   32: aload_0
    //   33: getfield 61	com/tencent/mm/ui/chatting/gallery/n:hYA	I
    //   36: aload_0
    //   37: getfield 179	com/tencent/mm/ui/chatting/gallery/n:hYw	I
    //   40: if_icmpge +11 -> 51
    //   43: ldc_w 609
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
    //   70: getfield 82	com/tencent/mm/ui/chatting/gallery/n:yDa	Lcom/tencent/mm/plugin/a/j;
    //   73: iload_1
    //   74: iload_1
    //   75: iconst_2
    //   76: iadd
    //   77: aload 4
    //   79: aload 5
    //   81: invokevirtual 250	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   84: ifeq +98 -> 182
    //   87: invokestatic 256	com/tencent/mm/modelvideo/o:aJz	()Lcom/tencent/mm/an/e;
    //   90: aload_0
    //   91: getfield 258	com/tencent/mm/ui/chatting/gallery/n:mediaId	Ljava/lang/String;
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
    //   116: putfield 61	com/tencent/mm/ui/chatting/gallery/n:hYA	I
    //   119: iload_2
    //   120: istore_3
    //   121: ldc_w 609
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
    //   143: invokestatic 305	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc 109
    //   148: new 266	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 307
    //   155: invokespecial 310	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokevirtual 311	java/lang/Exception:toString	()Ljava/lang/String;
    //   163: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 314	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	187	0	this	n
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
    this.hYx = -1;
    this.yDc = 0;
    this.jlZ = 0;
    this.hYA = 0;
    this.hYw = 0;
    this.yDd = 0;
    this.hYu = 0;
    this.hYt = 0;
    this.hYz = false;
    this.hYC = false;
    this.hYD = false;
    this.yCZ.clear();
    if (this.IeF != null) {
      this.hYB = this.IeF.hYK;
    }
    this.yDe = 0L;
    this.frt = 0L;
    this.yDh = 0;
    this.yDg = 0L;
    this.yDf = 0L;
    AppMethodBeat.o(36395);
  }
  
  static final class a
  {
    int IeH;
    int hYK;
    int hYL;
    int yDl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.n
 * JD-Core Version:    0.7.0.1
 */