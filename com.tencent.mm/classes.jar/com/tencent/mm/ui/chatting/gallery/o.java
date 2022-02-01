package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.c;
import com.tencent.mm.i.h;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.HashMap;

public final class o
{
  j JUe;
  a JUf;
  long fJC;
  String filename;
  int irP;
  int irQ;
  int irS;
  int irT;
  boolean irV;
  int irW;
  private int irX;
  boolean irY;
  boolean irZ;
  int jFP;
  String mediaId;
  long zUA;
  private long zUB;
  private int zUC;
  HashMap<String, Integer> zUu;
  com.tencent.mm.plugin.a.j zUv;
  int zUx;
  int zUy;
  long zUz;
  
  public o(j paramj)
  {
    AppMethodBeat.i(36394);
    this.irP = 0;
    this.irQ = 0;
    this.irW = 0;
    this.zUu = new HashMap();
    this.zUy = 0;
    this.irY = false;
    this.irZ = false;
    this.JUe = paramj;
    reset();
    this.zUv = new com.tencent.mm.plugin.a.j();
    this.JUf = new a((byte)0);
    paramj = com.tencent.mm.n.g.acA().getValue("AndroidOnlineVideoArgs");
    if (!bt.isNullOrNil(paramj))
    {
      ad.i("MicroMsg.OnlineVideoUIHelper", "online video config : ".concat(String.valueOf(paramj)));
      paramj = paramj.split(";");
      if ((paramj != null) && (paramj.length >= 4))
      {
        this.JUf.isg = bt.getInt(paramj[0], 5);
        this.JUf.ish = bt.getInt(paramj[1], 1);
        this.JUf.zUG = bt.getInt(paramj[2], 75);
        this.JUf.JUh = (bt.getInt(paramj[3], 1) * 1048576);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.JUf.isg = 5;
        this.JUf.ish = 1;
        this.JUf.zUG = 75;
        this.JUf.JUh = 1048576;
      }
      ad.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.JUf.isg), Integer.valueOf(this.JUf.ish), Integer.valueOf(this.JUf.zUG), Integer.valueOf(this.JUf.JUh) });
      this.irX = this.JUf.isg;
      AppMethodBeat.o(36394);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(36405);
    paramPInt1.value = Math.max(paramInt, this.irW);
    if (this.irQ == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.irX;
    }
    if (this.irQ == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.irX + 8);
    }
    if ((this.irQ == 3) || (this.irQ == 4))
    {
      paramPInt1.value = this.irW;
      paramPInt2.value = (this.irX + paramInt + 2 + this.JUf.ish);
    }
    if (paramPInt2.value >= this.irS + 1) {
      paramPInt2.value = (this.irS + 1);
    }
    if (paramPInt2.value <= paramPInt1.value)
    {
      paramPInt1.value += this.JUf.ish;
      AppMethodBeat.o(36405);
      return false;
    }
    ad.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.irQ), Integer.valueOf(this.irW), Integer.valueOf(this.irX) });
    AppMethodBeat.o(36405);
    return true;
  }
  
  private static void fGI()
  {
    AppMethodBeat.i(36411);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 1L, 1L, false);
    AppMethodBeat.o(36411);
  }
  
  private static void fGJ()
  {
    AppMethodBeat.i(36412);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 2L, 1L, false);
    AppMethodBeat.o(36412);
  }
  
  private static void fGK()
  {
    AppMethodBeat.i(36413);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 10L, 1L, false);
    AppMethodBeat.o(36413);
  }
  
  private static void fGL()
  {
    AppMethodBeat.i(36414);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 17L, 1L, false);
    AppMethodBeat.o(36414);
  }
  
  private void fGM()
  {
    AppMethodBeat.i(36415);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 24L, 1L, false);
    ad.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", new Object[] { Integer.valueOf(hashCode()), this.filename });
    com.tencent.mm.plugin.report.service.g.yhR.f(13836, new Object[] { Integer.valueOf(303), Long.valueOf(bt.aQJ()), "" });
    AppMethodBeat.o(36415);
  }
  
  private static void fGN()
  {
    AppMethodBeat.i(36416);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 134L, 1L, false);
    AppMethodBeat.o(36416);
  }
  
  private boolean n(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(36406);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.zUv.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        bool = com.tencent.mm.modelvideo.o.aMK().isVideoDataAvailable(this.mediaId, localPInt1.value, localPInt2.value);
        if (bool) {
          break label333;
        }
        if (!this.zUu.containsKey(this.mediaId + 0 + "_-1"))
        {
          String str = this.mediaId + localPInt1.value + "_" + localPInt2.value;
          ad.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.irZ), Boolean.valueOf(paramBoolean) });
          if ((this.zUu.containsKey(str)) || ((this.irZ) && (!paramBoolean))) {
            break label314;
          }
          this.irZ = true;
          com.tencent.mm.modelvideo.o.aMK();
          com.tencent.mm.ao.e.r(this.mediaId, localPInt1.value, localPInt2.value);
          this.zUu.put(str, Integer.valueOf(paramInt2));
        }
        AppMethodBeat.o(36406);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
        ad.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + localException.toString());
        boolean bool = false;
        continue;
        label314:
        ad.i("MicroMsg.OnlineVideoUIHelper", "already request video : ".concat(String.valueOf(localException)));
        continue;
        label333:
        ad.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
      }
    }
  }
  
  public final boolean aAK(String paramString)
  {
    AppMethodBeat.i(36400);
    boolean bool = bt.lQ(paramString, this.mediaId);
    AppMethodBeat.o(36400);
    return bool;
  }
  
  public final boolean aWv(String paramString)
  {
    AppMethodBeat.i(36397);
    d.aGQ();
    if (!d.aHa())
    {
      AppMethodBeat.o(36397);
      return false;
    }
    reset();
    Object localObject = u.Hy(paramString);
    if (localObject != null)
    {
      int i = ((s)localObject).hMP;
      if (i < this.JUf.JUh)
      {
        ad.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", new Object[] { Integer.valueOf(i), Integer.valueOf(this.JUf.JUh) });
        u.b((s)localObject, 9);
        fGL();
        AppMethodBeat.o(36397);
        return false;
      }
    }
    u.av(paramString, 1);
    n.aMH();
    com.tencent.mm.modelvideo.o.aMK();
    localObject = com.tencent.mm.ao.e.ES(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(36397);
      return false;
    }
    this.mediaId = ((h)localObject).field_mediaId;
    this.jFP = ((h)localObject).fJE;
    this.filename = paramString;
    this.irP = 1;
    this.irS = 0;
    boolean bool = com.tencent.mm.modelvideo.o.aMO().aNf();
    com.tencent.mm.modelvideo.o.aMK().a((h)localObject, bool);
    this.fJC = bt.flT();
    fGI();
    ad.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, paramString, Long.valueOf(this.fJC) });
    AppMethodBeat.o(36397);
    return true;
  }
  
  public final boolean bh(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36402);
    switch (this.irP)
    {
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      ad.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.irP), Integer.valueOf(this.irQ) });
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 4L, 1L, false);
      AppMethodBeat.o(36402);
      return paramBoolean;
      this.irQ = 2;
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      a(paramInt, localPInt1, localPInt2);
      if (n(localPInt1.value, localPInt2.value, true))
      {
        this.irT = -1;
        this.irV = false;
        this.irW = localPInt2.value;
        this.irQ = 3;
        this.JUe.aB(paramInt, paramBoolean);
        break;
      }
      this.irT = paramInt;
      this.irV = true;
      this.JUe.aMw();
    }
  }
  
  public final boolean c(bu parambu, s params)
  {
    AppMethodBeat.i(36396);
    if (parambu.cxg())
    {
      parambu = new h();
      parambu.fJi = "task_OnlineVideoUIHelper";
      parambu.field_mediaId = c.a("downvideo", params.createTime, params.getUser(), params.getFileName());
      parambu.url = params.iun.hCe;
      parambu.fJF = 1;
      parambu.fJA = 7;
      parambu.concurrentCount = 4;
      parambu.filename = params.getFileName();
      com.tencent.mm.modelvideo.o.aMJ();
      parambu.field_fullpath = t.Hh(params.getFileName());
      parambu.fJE = params.hMP;
      this.mediaId = parambu.field_mediaId;
      this.jFP = parambu.fJE;
      this.filename = params.getFileName();
      this.irP = 1;
      this.irS = 0;
      boolean bool = com.tencent.mm.modelvideo.o.aMO().aNf();
      com.tencent.mm.modelvideo.o.aMK().a(parambu, bool);
      this.fJC = bt.flT();
      ad.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, this.filename, Long.valueOf(this.fJC) });
      AppMethodBeat.o(36396);
      return true;
    }
    AppMethodBeat.o(36396);
    return false;
  }
  
  final void eaB()
  {
    AppMethodBeat.i(36401);
    ad.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", new Object[] { this.filename });
    eaE();
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36393);
        if (o.this.JUe != null) {
          o.this.JUe.bU(o.this.filename, false);
        }
        AppMethodBeat.o(36393);
      }
    });
    AppMethodBeat.o(36401);
  }
  
  final void eaE()
  {
    AppMethodBeat.i(36409);
    if (this.zUA == 0L) {
      this.zUA = bt.flT();
    }
    AppMethodBeat.o(36409);
  }
  
  final Object[] eaF()
  {
    AppMethodBeat.i(36410);
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.JUe.getPlayVideoDuration());
    if (this.zUA <= 0L) {
      this.zUA = bt.flT();
    }
    int j = (int)(this.zUA - this.fJC);
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[1] = Integer.valueOf(i);
    if (this.zUz <= 0L) {
      this.zUz = bt.flT();
    }
    j = (int)(this.zUz - this.fJC);
    i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(this.zUy);
    if (this.zUy > 0)
    {
      if (this.zUC == 0) {
        this.zUC = ((int)(this.zUC + bt.Df(this.zUB)));
      }
      arrayOfObject[4] = Integer.valueOf(this.zUC / this.zUy);
    }
    for (;;)
    {
      arrayOfObject[5] = Integer.valueOf(this.JUe.getUiStayTime());
      arrayOfObject[6] = Integer.valueOf(this.JUe.rFf);
      AppMethodBeat.o(36410);
      return arrayOfObject;
      arrayOfObject[4] = Integer.valueOf(0);
    }
  }
  
  public final void fGF()
  {
    AppMethodBeat.i(36398);
    ad.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
    int i;
    if (this.irP == 3)
    {
      i = 1;
      this.irP = 0;
      if (!bt.isNullOrNil(this.mediaId))
      {
        if (i == 0) {
          break label77;
        }
        fGH();
      }
    }
    for (;;)
    {
      com.tencent.mm.modelvideo.o.aMK().m(this.mediaId, eaF());
      fGJ();
      AppMethodBeat.o(36398);
      return;
      i = 0;
      break;
      label77:
      if (this.zUx >= this.JUf.zUG)
      {
        ad.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", new Object[] { Integer.valueOf(this.zUx), Integer.valueOf(this.JUf.zUG) });
        u.au(this.filename, 2);
        fGK();
      }
    }
  }
  
  public final void fGG()
  {
    AppMethodBeat.i(36407);
    String str = this.mediaId + 0 + "_-1";
    if (!this.zUu.containsKey(str))
    {
      ad.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", new Object[] { this.mediaId });
      com.tencent.mm.modelvideo.o.aMK();
      com.tencent.mm.ao.e.r(this.mediaId, 0, -1);
      this.zUu.put(str, Integer.valueOf(0));
      fGM();
    }
    this.irQ = 5;
    AppMethodBeat.o(36407);
  }
  
  final void fGH()
  {
    AppMethodBeat.i(36408);
    com.tencent.mm.modelvideo.o.aMJ();
    if (r.isH265Video(t.Hh(this.filename)))
    {
      ad.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", new Object[] { this.filename });
      if (u.HD(this.filename)) {
        fGN();
      }
    }
    AppMethodBeat.o(36408);
  }
  
  public final boolean isStreaming()
  {
    AppMethodBeat.i(36399);
    if ((!bt.isNullOrNil(this.mediaId)) && ((this.irP == 1) || (this.irP == 3)))
    {
      AppMethodBeat.o(36399);
      return true;
    }
    AppMethodBeat.o(36399);
    return false;
  }
  
  public final boolean qi(int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    AppMethodBeat.i(36403);
    if (this.irT != -1) {}
    for (int i = this.irT;; i = paramInt)
    {
      ad.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.irW), Integer.valueOf(this.irS), Integer.valueOf(this.irP), Long.valueOf(this.zUA - this.fJC), Boolean.valueOf(this.irY) });
      boolean bool1 = bool2;
      switch (this.irP)
      {
      default: 
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(36403);
        return bool1;
        if (!qj(i))
        {
          this.irV = true;
          if (this.irW <= 0) {
            if (this.irT == -1)
            {
              this.irQ = 1;
              label184:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          this.JUe.adT(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label672;
          }
          if (!n(localPInt1.value, localPInt2.value, false)) {
            break label680;
          }
          this.irW = Math.max(this.irW, localPInt2.value);
          bool1 = bool2;
          break;
          this.irQ = 2;
          break label184;
          ad.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.zUy + " playStatus : " + this.irQ);
          this.zUB = bt.flT();
          if ((this.irQ != 2) && (this.irQ != 4))
          {
            this.irX += this.JUf.isg;
            this.irX = Math.min(this.irX, 60);
            this.zUy += 1;
            this.irQ = 4;
          }
          this.JUe.aMw();
          break label184;
          if ((this.zUy == 0) && (this.zUA == 0L)) {
            eaE();
          }
          if (this.irY)
          {
            this.JUe.aWt(this.filename);
            if (this.irV) {
              if ((this.zUy == 0) && (this.zUA == 0L))
              {
                eaE();
                label452:
                ad.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", new Object[] { Integer.valueOf(this.zUy), Integer.valueOf(this.zUC) });
                if (this.irT == -1) {
                  break label558;
                }
                this.JUe.aB(this.irT, true);
                this.irT = -1;
                bool1 = false;
                label511:
                this.irV = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.irQ = paramInt;
              label558:
              do
              {
                bool1 = true;
                break;
                if (this.zUB <= 0L) {
                  break label452;
                }
                this.zUC = ((int)(this.zUC + bt.Df(this.zUB)));
                break label452;
                if (this.JUe.eap())
                {
                  bool1 = false;
                  break label511;
                }
                bool1 = true;
                break label511;
              } while (this.irQ == 3);
              ad.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.irQ) });
              if (this.JUe.eap()) {
                paramInt = 3;
              } else {
                paramInt = this.irQ;
              }
            }
          }
          ad.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", new Object[] { this.filename });
          this.JUe.bU(this.filename, true);
          this.irY = true;
          bool1 = true;
        }
        label672:
        ad.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
        label680:
        continue;
        eaE();
        if (this.irY)
        {
          if (this.irV)
          {
            if (this.irT == -1) {
              break label748;
            }
            this.JUe.aB(this.irT, true);
            this.irT = -1;
            bool1 = bool3;
          }
          for (;;)
          {
            this.irV = bool1;
            this.JUe.adT(i);
            bool1 = bool2;
            break;
            label748:
            if (this.JUe.eap()) {
              bool1 = bool3;
            } else {
              bool1 = true;
            }
          }
        }
        this.JUe.bU(this.filename, false);
        this.irY = true;
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  public final boolean qj(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 614
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 57	com/tencent/mm/ui/chatting/gallery/o:irP	I
    //   10: iconst_3
    //   11: if_icmpne +11 -> 22
    //   14: ldc_w 614
    //   17: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_1
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 61	com/tencent/mm/ui/chatting/gallery/o:irW	I
    //   26: iload_1
    //   27: isub
    //   28: iconst_2
    //   29: if_icmpgt +22 -> 51
    //   32: aload_0
    //   33: getfield 61	com/tencent/mm/ui/chatting/gallery/o:irW	I
    //   36: aload_0
    //   37: getfield 179	com/tencent/mm/ui/chatting/gallery/o:irS	I
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
    //   70: getfield 82	com/tencent/mm/ui/chatting/gallery/o:zUv	Lcom/tencent/mm/plugin/a/j;
    //   73: iload_1
    //   74: iload_1
    //   75: iconst_2
    //   76: iadd
    //   77: aload 4
    //   79: aload 5
    //   81: invokevirtual 250	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   84: ifeq +98 -> 182
    //   87: invokestatic 256	com/tencent/mm/modelvideo/o:aMK	()Lcom/tencent/mm/ao/e;
    //   90: aload_0
    //   91: getfield 258	com/tencent/mm/ui/chatting/gallery/o:mediaId	Ljava/lang/String;
    //   94: aload 4
    //   96: getfield 177	com/tencent/mm/pointers/PInt:value	I
    //   99: aload 5
    //   101: getfield 177	com/tencent/mm/pointers/PInt:value	I
    //   104: invokevirtual 264	com/tencent/mm/ao/e:isVideoDataAvailable	(Ljava/lang/String;II)Z
    //   107: istore_2
    //   108: iload_2
    //   109: istore_3
    //   110: iload_2
    //   111: ifne +10 -> 121
    //   114: aload_0
    //   115: iload_1
    //   116: putfield 61	com/tencent/mm/ui/chatting/gallery/o:irW	I
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
    //   143: invokestatic 305	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc 109
    //   148: new 266	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 307
    //   155: invokespecial 310	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokevirtual 311	java/lang/Exception:toString	()Ljava/lang/String;
    //   163: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 314	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    this.irT = -1;
    this.zUx = 0;
    this.jFP = 0;
    this.irW = 0;
    this.irS = 0;
    this.zUy = 0;
    this.irQ = 0;
    this.irP = 0;
    this.irV = false;
    this.irY = false;
    this.irZ = false;
    this.zUu.clear();
    if (this.JUf != null) {
      this.irX = this.JUf.isg;
    }
    this.zUz = 0L;
    this.fJC = 0L;
    this.zUC = 0;
    this.zUB = 0L;
    this.zUA = 0L;
    AppMethodBeat.o(36395);
  }
  
  static final class a
  {
    int JUh;
    int isg;
    int ish;
    int zUG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.o
 * JD-Core Version:    0.7.0.1
 */