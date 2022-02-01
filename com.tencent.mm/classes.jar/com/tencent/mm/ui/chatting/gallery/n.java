package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.c;
import com.tencent.mm.m.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.a.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.HashMap;

public final class n
{
  j GEH;
  a GEI;
  String filename;
  long fnZ;
  int hxS;
  int hxT;
  int hxV;
  int hxW;
  boolean hxY;
  int hxZ;
  private int hya;
  boolean hyb;
  boolean hyc;
  int iLS;
  String mediaId;
  HashMap<String, Integer> xqj;
  i xqk;
  int xqm;
  int xqn;
  long xqo;
  long xqp;
  private long xqq;
  private int xqr;
  
  public n(j paramj)
  {
    AppMethodBeat.i(36394);
    this.hxS = 0;
    this.hxT = 0;
    this.hxZ = 0;
    this.xqj = new HashMap();
    this.xqn = 0;
    this.hyb = false;
    this.hyc = false;
    this.GEH = paramj;
    reset();
    this.xqk = new i();
    this.GEI = new a((byte)0);
    paramj = g.Zd().getValue("AndroidOnlineVideoArgs");
    if (!bt.isNullOrNil(paramj))
    {
      ad.i("MicroMsg.OnlineVideoUIHelper", "online video config : ".concat(String.valueOf(paramj)));
      paramj = paramj.split(";");
      if ((paramj != null) && (paramj.length >= 4))
      {
        this.GEI.hyj = bt.getInt(paramj[0], 5);
        this.GEI.hyk = bt.getInt(paramj[1], 1);
        this.GEI.xqv = bt.getInt(paramj[2], 75);
        this.GEI.GEK = (bt.getInt(paramj[3], 1) * 1048576);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.GEI.hyj = 5;
        this.GEI.hyk = 1;
        this.GEI.xqv = 75;
        this.GEI.GEK = 1048576;
      }
      ad.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.GEI.hyj), Integer.valueOf(this.GEI.hyk), Integer.valueOf(this.GEI.xqv), Integer.valueOf(this.GEI.GEK) });
      this.hya = this.GEI.hyj;
      AppMethodBeat.o(36394);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(36405);
    paramPInt1.value = Math.max(paramInt, this.hxZ);
    if (this.hxT == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.hya;
    }
    if (this.hxT == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.hya + 8);
    }
    if ((this.hxT == 3) || (this.hxT == 4))
    {
      paramPInt1.value = this.hxZ;
      paramPInt2.value = (this.hya + paramInt + 2 + this.GEI.hyk);
    }
    if (paramPInt2.value >= this.hxV + 1) {
      paramPInt2.value = (this.hxV + 1);
    }
    if (paramPInt2.value <= paramPInt1.value)
    {
      paramPInt1.value += this.GEI.hyk;
      AppMethodBeat.o(36405);
      return false;
    }
    ad.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hxT), Integer.valueOf(this.hxZ), Integer.valueOf(this.hya) });
    AppMethodBeat.o(36405);
    return true;
  }
  
  private static void faj()
  {
    AppMethodBeat.i(36411);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 1L, 1L, false);
    AppMethodBeat.o(36411);
  }
  
  private static void fak()
  {
    AppMethodBeat.i(36412);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 2L, 1L, false);
    AppMethodBeat.o(36412);
  }
  
  private static void fal()
  {
    AppMethodBeat.i(36413);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 10L, 1L, false);
    AppMethodBeat.o(36413);
  }
  
  private static void fam()
  {
    AppMethodBeat.i(36414);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 17L, 1L, false);
    AppMethodBeat.o(36414);
  }
  
  private void fan()
  {
    AppMethodBeat.i(36415);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 24L, 1L, false);
    ad.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", new Object[] { Integer.valueOf(hashCode()), this.filename });
    com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(303), Long.valueOf(bt.aGK()), "" });
    AppMethodBeat.o(36415);
  }
  
  private static void fao()
  {
    AppMethodBeat.i(36416);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 134L, 1L, false);
    AppMethodBeat.o(36416);
  }
  
  private boolean n(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(36406);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.xqk.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        bool = o.aCJ().isVideoDataAvailable(this.mediaId, localPInt1.value, localPInt2.value);
        if (bool) {
          break label333;
        }
        if (!this.xqj.containsKey(this.mediaId + 0 + "_-1"))
        {
          String str = this.mediaId + localPInt1.value + "_" + localPInt2.value;
          ad.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.hyc), Boolean.valueOf(paramBoolean) });
          if ((this.xqj.containsKey(str)) || ((this.hyc) && (!paramBoolean))) {
            break label314;
          }
          this.hyc = true;
          o.aCJ();
          com.tencent.mm.ao.e.q(this.mediaId, localPInt1.value, localPInt2.value);
          this.xqj.put(str, Integer.valueOf(paramInt2));
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
  
  public final boolean aKY(String paramString)
  {
    AppMethodBeat.i(36397);
    d.awT();
    if (!d.axd())
    {
      AppMethodBeat.o(36397);
      return false;
    }
    reset();
    Object localObject = u.Ae(paramString);
    if (localObject != null)
    {
      int i = ((s)localObject).gTY;
      if (i < this.GEI.GEK)
      {
        ad.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", new Object[] { Integer.valueOf(i), Integer.valueOf(this.GEI.GEK) });
        u.b((s)localObject, 9);
        fam();
        AppMethodBeat.o(36397);
        return false;
      }
    }
    u.ap(paramString, 1);
    com.tencent.mm.modelvideo.n.aCG();
    o.aCJ();
    localObject = com.tencent.mm.ao.e.xN(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(36397);
      return false;
    }
    this.mediaId = ((com.tencent.mm.i.h)localObject).field_mediaId;
    this.iLS = ((com.tencent.mm.i.h)localObject).fob;
    this.filename = paramString;
    this.hxS = 1;
    this.hxV = 0;
    boolean bool = o.aCN().aDe();
    o.aCJ().a((com.tencent.mm.i.h)localObject, bool);
    this.fnZ = bt.eGO();
    faj();
    ad.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, paramString, Long.valueOf(this.fnZ) });
    AppMethodBeat.o(36397);
    return true;
  }
  
  public final boolean aW(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36402);
    switch (this.hxS)
    {
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      ad.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hxS), Integer.valueOf(this.hxT) });
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 4L, 1L, false);
      AppMethodBeat.o(36402);
      return paramBoolean;
      this.hxT = 2;
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      a(paramInt, localPInt1, localPInt2);
      if (n(localPInt1.value, localPInt2.value, true))
      {
        this.hxW = -1;
        this.hxY = false;
        this.hxZ = localPInt2.value;
        this.hxT = 3;
        this.GEH.at(paramInt, paramBoolean);
        break;
      }
      this.hxW = paramInt;
      this.hxY = true;
      this.GEH.aCv();
    }
  }
  
  public final boolean aqu(String paramString)
  {
    AppMethodBeat.i(36400);
    boolean bool = bt.kU(paramString, this.mediaId);
    AppMethodBeat.o(36400);
    return bool;
  }
  
  public final boolean c(bl parambl, s params)
  {
    AppMethodBeat.i(36396);
    if (parambl.cjN())
    {
      parambl = new com.tencent.mm.i.h();
      parambl.field_mediaId = c.a("downvideo", params.createTime, params.getUser(), params.getFileName());
      parambl.url = params.hAq.gJv;
      parambl.foc = 1;
      parambl.fnX = 7;
      parambl.concurrentCount = 4;
      parambl.filename = params.getFileName();
      o.aCI();
      parambl.field_fullpath = t.zQ(params.getFileName());
      parambl.fob = params.gTY;
      this.mediaId = parambl.field_mediaId;
      this.iLS = parambl.fob;
      this.filename = params.getFileName();
      this.hxS = 1;
      this.hxV = 0;
      boolean bool = o.aCN().aDe();
      o.aCJ().a(parambl, bool);
      this.fnZ = bt.eGO();
      ad.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, this.filename, Long.valueOf(this.fnZ) });
      AppMethodBeat.o(36396);
      return true;
    }
    AppMethodBeat.o(36396);
    return false;
  }
  
  final void dzQ()
  {
    AppMethodBeat.i(36401);
    ad.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", new Object[] { this.filename });
    dzT();
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36393);
        if (n.this.GEH != null) {
          n.this.GEH.bG(n.this.filename, false);
        }
        AppMethodBeat.o(36393);
      }
    });
    AppMethodBeat.o(36401);
  }
  
  final void dzT()
  {
    AppMethodBeat.i(36409);
    if (this.xqp == 0L) {
      this.xqp = bt.eGO();
    }
    AppMethodBeat.o(36409);
  }
  
  final Object[] dzU()
  {
    AppMethodBeat.i(36410);
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.GEH.getPlayVideoDuration());
    if (this.xqp <= 0L) {
      this.xqp = bt.eGO();
    }
    int j = (int)(this.xqp - this.fnZ);
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[1] = Integer.valueOf(i);
    if (this.xqo <= 0L) {
      this.xqo = bt.eGO();
    }
    j = (int)(this.xqo - this.fnZ);
    i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(this.xqn);
    if (this.xqn > 0)
    {
      if (this.xqr == 0) {
        this.xqr = ((int)(this.xqr + bt.vM(this.xqq)));
      }
      arrayOfObject[4] = Integer.valueOf(this.xqr / this.xqn);
    }
    for (;;)
    {
      arrayOfObject[5] = Integer.valueOf(this.GEH.getUiStayTime());
      arrayOfObject[6] = Integer.valueOf(this.GEH.qmp);
      AppMethodBeat.o(36410);
      return arrayOfObject;
      arrayOfObject[4] = Integer.valueOf(0);
    }
  }
  
  public final void fag()
  {
    AppMethodBeat.i(36398);
    ad.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
    int i;
    if (this.hxS == 3)
    {
      i = 1;
      this.hxS = 0;
      if (!bt.isNullOrNil(this.mediaId))
      {
        if (i == 0) {
          break label77;
        }
        fai();
      }
    }
    for (;;)
    {
      o.aCJ().k(this.mediaId, dzU());
      fak();
      AppMethodBeat.o(36398);
      return;
      i = 0;
      break;
      label77:
      if (this.xqm >= this.GEI.xqv)
      {
        ad.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", new Object[] { Integer.valueOf(this.xqm), Integer.valueOf(this.GEI.xqv) });
        u.ao(this.filename, 2);
        fal();
      }
    }
  }
  
  public final void fah()
  {
    AppMethodBeat.i(36407);
    String str = this.mediaId + 0 + "_-1";
    if (!this.xqj.containsKey(str))
    {
      ad.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", new Object[] { this.mediaId });
      o.aCJ();
      com.tencent.mm.ao.e.q(this.mediaId, 0, -1);
      this.xqj.put(str, Integer.valueOf(0));
      fan();
    }
    this.hxT = 5;
    AppMethodBeat.o(36407);
  }
  
  final void fai()
  {
    AppMethodBeat.i(36408);
    o.aCI();
    if (r.isH265Video(t.zQ(this.filename)))
    {
      ad.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", new Object[] { this.filename });
      if (u.Aj(this.filename)) {
        fao();
      }
    }
    AppMethodBeat.o(36408);
  }
  
  public final boolean isStreaming()
  {
    AppMethodBeat.i(36399);
    if ((!bt.isNullOrNil(this.mediaId)) && ((this.hxS == 1) || (this.hxS == 3)))
    {
      AppMethodBeat.o(36399);
      return true;
    }
    AppMethodBeat.o(36399);
    return false;
  }
  
  public final boolean oR(int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    AppMethodBeat.i(36403);
    if (this.hxW != -1) {}
    for (int i = this.hxW;; i = paramInt)
    {
      ad.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.hxZ), Integer.valueOf(this.hxV), Integer.valueOf(this.hxS), Long.valueOf(this.xqp - this.fnZ), Boolean.valueOf(this.hyb) });
      boolean bool1 = bool2;
      switch (this.hxS)
      {
      default: 
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(36403);
        return bool1;
        if (!oS(i))
        {
          this.hxY = true;
          if (this.hxZ <= 0) {
            if (this.hxW == -1)
            {
              this.hxT = 1;
              label184:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          this.GEH.Zv(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label672;
          }
          if (!n(localPInt1.value, localPInt2.value, false)) {
            break label680;
          }
          this.hxZ = Math.max(this.hxZ, localPInt2.value);
          bool1 = bool2;
          break;
          this.hxT = 2;
          break label184;
          ad.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.xqn + " playStatus : " + this.hxT);
          this.xqq = bt.eGO();
          if ((this.hxT != 2) && (this.hxT != 4))
          {
            this.hya += this.GEI.hyj;
            this.hya = Math.min(this.hya, 60);
            this.xqn += 1;
            this.hxT = 4;
          }
          this.GEH.aCv();
          break label184;
          if ((this.xqn == 0) && (this.xqp == 0L)) {
            dzT();
          }
          if (this.hyb)
          {
            this.GEH.aKW(this.filename);
            if (this.hxY) {
              if ((this.xqn == 0) && (this.xqp == 0L))
              {
                dzT();
                label452:
                ad.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", new Object[] { Integer.valueOf(this.xqn), Integer.valueOf(this.xqr) });
                if (this.hxW == -1) {
                  break label558;
                }
                this.GEH.at(this.hxW, true);
                this.hxW = -1;
                bool1 = false;
                label511:
                this.hxY = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.hxT = paramInt;
              label558:
              do
              {
                bool1 = true;
                break;
                if (this.xqq <= 0L) {
                  break label452;
                }
                this.xqr = ((int)(this.xqr + bt.vM(this.xqq)));
                break label452;
                if (this.GEH.dzE())
                {
                  bool1 = false;
                  break label511;
                }
                bool1 = true;
                break label511;
              } while (this.hxT == 3);
              ad.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.hxT) });
              if (this.GEH.dzE()) {
                paramInt = 3;
              } else {
                paramInt = this.hxT;
              }
            }
          }
          ad.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", new Object[] { this.filename });
          this.GEH.bG(this.filename, true);
          this.hyb = true;
          bool1 = true;
        }
        label672:
        ad.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
        label680:
        continue;
        dzT();
        if (this.hyb)
        {
          if (this.hxY)
          {
            if (this.hxW == -1) {
              break label748;
            }
            this.GEH.at(this.hxW, true);
            this.hxW = -1;
            bool1 = bool3;
          }
          for (;;)
          {
            this.hxY = bool1;
            this.GEH.Zv(i);
            bool1 = bool2;
            break;
            label748:
            if (this.GEH.dzE()) {
              bool1 = bool3;
            } else {
              bool1 = true;
            }
          }
        }
        this.GEH.bG(this.filename, false);
        this.hyb = true;
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  public final boolean oS(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 609
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 57	com/tencent/mm/ui/chatting/gallery/n:hxS	I
    //   10: iconst_3
    //   11: if_icmpne +11 -> 22
    //   14: ldc_w 609
    //   17: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_1
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 61	com/tencent/mm/ui/chatting/gallery/n:hxZ	I
    //   26: iload_1
    //   27: isub
    //   28: iconst_2
    //   29: if_icmpgt +22 -> 51
    //   32: aload_0
    //   33: getfield 61	com/tencent/mm/ui/chatting/gallery/n:hxZ	I
    //   36: aload_0
    //   37: getfield 179	com/tencent/mm/ui/chatting/gallery/n:hxV	I
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
    //   70: getfield 82	com/tencent/mm/ui/chatting/gallery/n:xqk	Lcom/tencent/mm/plugin/a/i;
    //   73: iload_1
    //   74: iload_1
    //   75: iconst_2
    //   76: iadd
    //   77: aload 4
    //   79: aload 5
    //   81: invokevirtual 250	com/tencent/mm/plugin/a/i:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   84: ifeq +98 -> 182
    //   87: invokestatic 256	com/tencent/mm/modelvideo/o:aCJ	()Lcom/tencent/mm/ao/e;
    //   90: aload_0
    //   91: getfield 258	com/tencent/mm/ui/chatting/gallery/n:mediaId	Ljava/lang/String;
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
    //   116: putfield 61	com/tencent/mm/ui/chatting/gallery/n:hxZ	I
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
    this.hxW = -1;
    this.xqm = 0;
    this.iLS = 0;
    this.hxZ = 0;
    this.hxV = 0;
    this.xqn = 0;
    this.hxT = 0;
    this.hxS = 0;
    this.hxY = false;
    this.hyb = false;
    this.hyc = false;
    this.xqj.clear();
    if (this.GEI != null) {
      this.hya = this.GEI.hyj;
    }
    this.xqo = 0L;
    this.fnZ = 0L;
    this.xqr = 0;
    this.xqq = 0L;
    this.xqp = 0L;
    AppMethodBeat.o(36395);
  }
  
  static final class a
  {
    int GEK;
    int hyj;
    int hyk;
    int xqv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.n
 * JD-Core Version:    0.7.0.1
 */