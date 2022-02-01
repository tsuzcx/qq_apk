package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.n.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;

public final class o
{
  HashMap<String, Integer> Euo;
  com.tencent.mm.plugin.a.j Eup;
  int Eur;
  int Eus;
  long Eut;
  long Euu;
  private long Euv;
  private int Euw;
  j PBI;
  a PBJ;
  String filename;
  long gqR;
  int jpV;
  int jpW;
  int jpY;
  int jpZ;
  boolean jqb;
  int jqc;
  private int jqd;
  boolean jqe;
  boolean jqf;
  int kKK;
  String mediaId;
  
  public o(j paramj)
  {
    AppMethodBeat.i(36394);
    this.jpV = 0;
    this.jpW = 0;
    this.jqc = 0;
    this.Euo = new HashMap();
    this.Eus = 0;
    this.jqe = false;
    this.jqf = false;
    this.PBI = paramj;
    reset();
    this.Eup = new com.tencent.mm.plugin.a.j();
    this.PBJ = new a((byte)0);
    paramj = com.tencent.mm.n.h.aqJ().getValue("AndroidOnlineVideoArgs");
    if (!Util.isNullOrNil(paramj))
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "online video config : ".concat(String.valueOf(paramj)));
      paramj = paramj.split(";");
      if ((paramj != null) && (paramj.length >= 4))
      {
        this.PBJ.jqm = Util.getInt(paramj[0], 5);
        this.PBJ.jqn = Util.getInt(paramj[1], 1);
        this.PBJ.EuA = Util.getInt(paramj[2], 75);
        this.PBJ.PBL = (Util.getInt(paramj[3], 1) * 1048576);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.PBJ.jqm = 5;
        this.PBJ.jqn = 1;
        this.PBJ.EuA = 75;
        this.PBJ.PBL = 1048576;
      }
      Log.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.PBJ.jqm), Integer.valueOf(this.PBJ.jqn), Integer.valueOf(this.PBJ.EuA), Integer.valueOf(this.PBJ.PBL) });
      this.jqd = this.PBJ.jqm;
      AppMethodBeat.o(36394);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(36405);
    paramPInt1.value = Math.max(paramInt, this.jqc);
    if (this.jpW == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.jqd;
    }
    if (this.jpW == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.jqd + 8);
    }
    if ((this.jpW == 3) || (this.jpW == 4))
    {
      paramPInt1.value = this.jqc;
      paramPInt2.value = (this.jqd + paramInt + 2 + this.PBJ.jqn);
    }
    if (paramPInt2.value >= this.jpY + 1) {
      paramPInt2.value = (this.jpY + 1);
    }
    if (paramPInt2.value <= paramPInt1.value)
    {
      paramPInt1.value += this.PBJ.jqn;
      AppMethodBeat.o(36405);
      return false;
    }
    Log.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.jpW), Integer.valueOf(this.jqc), Integer.valueOf(this.jqd) });
    AppMethodBeat.o(36405);
    return true;
  }
  
  private static void gTl()
  {
    AppMethodBeat.i(36411);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 1L, 1L, false);
    AppMethodBeat.o(36411);
  }
  
  private static void gTm()
  {
    AppMethodBeat.i(36412);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 2L, 1L, false);
    AppMethodBeat.o(36412);
  }
  
  private static void gTn()
  {
    AppMethodBeat.i(36413);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 10L, 1L, false);
    AppMethodBeat.o(36413);
  }
  
  private static void gTo()
  {
    AppMethodBeat.i(36414);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 17L, 1L, false);
    AppMethodBeat.o(36414);
  }
  
  private void gTp()
  {
    AppMethodBeat.i(36415);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 24L, 1L, false);
    Log.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", new Object[] { Integer.valueOf(hashCode()), this.filename });
    com.tencent.mm.plugin.report.service.h.CyF.a(13836, new Object[] { Integer.valueOf(303), Long.valueOf(Util.nowSecond()), "" });
    AppMethodBeat.o(36415);
  }
  
  private static void gTq()
  {
    AppMethodBeat.i(36416);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 134L, 1L, false);
    AppMethodBeat.o(36416);
  }
  
  private boolean o(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(36406);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.Eup.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        bool = com.tencent.mm.modelvideo.o.bhk().isVideoDataAvailable(this.mediaId, localPInt1.value, localPInt2.value);
        if (bool) {
          break label333;
        }
        if (!this.Euo.containsKey(this.mediaId + 0 + "_-1"))
        {
          String str = this.mediaId + localPInt1.value + "_" + localPInt2.value;
          Log.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.jqf), Boolean.valueOf(paramBoolean) });
          if ((this.Euo.containsKey(str)) || ((this.jqf) && (!paramBoolean))) {
            break label314;
          }
          this.jqf = true;
          com.tencent.mm.modelvideo.o.bhk();
          com.tencent.mm.an.e.r(this.mediaId, localPInt1.value, localPInt2.value);
          this.Euo.put(str, Integer.valueOf(paramInt2));
        }
        AppMethodBeat.o(36406);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
        Log.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + localException.toString());
        boolean bool = false;
        continue;
        label314:
        Log.i("MicroMsg.OnlineVideoUIHelper", "already request video : ".concat(String.valueOf(localException)));
        continue;
        label333:
        Log.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
      }
    }
  }
  
  public final boolean aQW(String paramString)
  {
    AppMethodBeat.i(36400);
    boolean bool = Util.isEqual(paramString, this.mediaId);
    AppMethodBeat.o(36400);
    return bool;
  }
  
  public final boolean bL(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36402);
    switch (this.jpV)
    {
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jpV), Integer.valueOf(this.jpW) });
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 4L, 1L, false);
      AppMethodBeat.o(36402);
      return paramBoolean;
      this.jpW = 2;
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      a(paramInt, localPInt1, localPInt2);
      if (o(localPInt1.value, localPInt2.value, true))
      {
        this.jpZ = -1;
        this.jqb = false;
        this.jqc = localPInt2.value;
        this.jpW = 3;
        this.PBI.aT(paramInt, paramBoolean);
        break;
      }
      this.jpZ = paramInt;
      this.jqb = true;
      this.PBI.bgW();
    }
  }
  
  public final boolean bnc(String paramString)
  {
    AppMethodBeat.i(36397);
    com.tencent.mm.modelcontrol.e.baZ();
    if (!com.tencent.mm.modelcontrol.e.bbk())
    {
      AppMethodBeat.o(36397);
      return false;
    }
    reset();
    Object localObject = u.QN(paramString);
    if (localObject != null)
    {
      int i = ((s)localObject).iKP;
      if (i < this.PBJ.PBL)
      {
        Log.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", new Object[] { Integer.valueOf(i), Integer.valueOf(this.PBJ.PBL) });
        u.b((s)localObject, 9);
        gTo();
        AppMethodBeat.o(36397);
        return false;
      }
    }
    u.aA(paramString, 1);
    n.bhh();
    com.tencent.mm.modelvideo.o.bhk();
    localObject = com.tencent.mm.an.e.Oe(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(36397);
      return false;
    }
    this.mediaId = ((com.tencent.mm.i.h)localObject).field_mediaId;
    this.kKK = ((com.tencent.mm.i.h)localObject).gqT;
    this.filename = paramString;
    this.jpV = 1;
    this.jpY = 0;
    boolean bool = com.tencent.mm.modelvideo.o.bho().bhG();
    com.tencent.mm.modelvideo.o.bhk().a((com.tencent.mm.i.h)localObject, bool);
    this.gqR = Util.nowMilliSecond();
    gTl();
    Log.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, paramString, Long.valueOf(this.gqR) });
    AppMethodBeat.o(36397);
    return true;
  }
  
  public final boolean c(ca paramca, s params)
  {
    AppMethodBeat.i(36396);
    if (paramca.cWK())
    {
      paramca = new com.tencent.mm.i.h();
      paramca.taskName = "task_OnlineVideoUIHelper";
      paramca.field_mediaId = c.a("downvideo", params.createTime, params.getUser(), params.getFileName());
      paramca.url = params.jsw.iyZ;
      paramca.gqU = 1;
      paramca.gqP = 7;
      paramca.concurrentCount = 4;
      paramca.filename = params.getFileName();
      com.tencent.mm.modelvideo.o.bhj();
      paramca.field_fullpath = t.Qw(params.getFileName());
      paramca.gqT = params.iKP;
      this.mediaId = paramca.field_mediaId;
      this.kKK = paramca.gqT;
      this.filename = params.getFileName();
      this.jpV = 1;
      this.jpY = 0;
      boolean bool = com.tencent.mm.modelvideo.o.bho().bhG();
      com.tencent.mm.modelvideo.o.bhk().a(paramca, bool);
      this.gqR = Util.nowMilliSecond();
      Log.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, this.filename, Long.valueOf(this.gqR) });
      AppMethodBeat.o(36396);
      return true;
    }
    AppMethodBeat.o(36396);
    return false;
  }
  
  final void fgB()
  {
    AppMethodBeat.i(36409);
    if (this.Euu == 0L) {
      this.Euu = Util.nowMilliSecond();
    }
    AppMethodBeat.o(36409);
  }
  
  final Object[] fgC()
  {
    AppMethodBeat.i(36410);
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.PBI.getPlayVideoDuration());
    if (this.Euu <= 0L) {
      this.Euu = Util.nowMilliSecond();
    }
    int j = (int)(this.Euu - this.gqR);
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[1] = Integer.valueOf(i);
    if (this.Eut <= 0L) {
      this.Eut = Util.nowMilliSecond();
    }
    j = (int)(this.Eut - this.gqR);
    i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(this.Eus);
    if (this.Eus > 0)
    {
      if (this.Euw == 0) {
        this.Euw = ((int)(this.Euw + Util.milliSecondsToNow(this.Euv)));
      }
      arrayOfObject[4] = Integer.valueOf(this.Euw / this.Eus);
    }
    for (;;)
    {
      arrayOfObject[5] = Integer.valueOf(this.PBI.getUiStayTime());
      arrayOfObject[6] = Integer.valueOf(this.PBI.tnb);
      AppMethodBeat.o(36410);
      return arrayOfObject;
      arrayOfObject[4] = Integer.valueOf(0);
    }
  }
  
  final void fgy()
  {
    AppMethodBeat.i(36401);
    Log.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", new Object[] { this.filename });
    fgB();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36393);
        if (o.this.PBI != null) {
          o.this.PBI.cq(o.this.filename, false);
        }
        AppMethodBeat.o(36393);
      }
    });
    AppMethodBeat.o(36401);
  }
  
  public final void gTi()
  {
    AppMethodBeat.i(36398);
    Log.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
    int i;
    if (this.jpV == 3)
    {
      i = 1;
      this.jpV = 0;
      if (!Util.isNullOrNil(this.mediaId))
      {
        if (i == 0) {
          break label77;
        }
        gTk();
      }
    }
    for (;;)
    {
      com.tencent.mm.modelvideo.o.bhk().m(this.mediaId, fgC());
      gTm();
      AppMethodBeat.o(36398);
      return;
      i = 0;
      break;
      label77:
      if (this.Eur >= this.PBJ.EuA)
      {
        Log.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", new Object[] { Integer.valueOf(this.Eur), Integer.valueOf(this.PBJ.EuA) });
        u.az(this.filename, 2);
        gTn();
      }
    }
  }
  
  public final void gTj()
  {
    AppMethodBeat.i(36407);
    String str = this.mediaId + 0 + "_-1";
    if (!this.Euo.containsKey(str))
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", new Object[] { this.mediaId });
      com.tencent.mm.modelvideo.o.bhk();
      com.tencent.mm.an.e.r(this.mediaId, 0, -1);
      this.Euo.put(str, Integer.valueOf(0));
      gTp();
    }
    this.jpW = 5;
    AppMethodBeat.o(36407);
  }
  
  final void gTk()
  {
    AppMethodBeat.i(36408);
    com.tencent.mm.modelvideo.o.bhj();
    if (r.isH265Video(t.Qw(this.filename)))
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", new Object[] { this.filename });
      if (u.QR(this.filename)) {
        gTq();
      }
    }
    AppMethodBeat.o(36408);
  }
  
  public final boolean isStreaming()
  {
    AppMethodBeat.i(36399);
    if ((!Util.isNullOrNil(this.mediaId)) && ((this.jpV == 1) || (this.jpV == 3)))
    {
      AppMethodBeat.o(36399);
      return true;
    }
    AppMethodBeat.o(36399);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(36395);
    this.mediaId = "";
    this.filename = "";
    this.jpZ = -1;
    this.Eur = 0;
    this.kKK = 0;
    this.jqc = 0;
    this.jpY = 0;
    this.Eus = 0;
    this.jpW = 0;
    this.jpV = 0;
    this.jqb = false;
    this.jqe = false;
    this.jqf = false;
    this.Euo.clear();
    if (this.PBJ != null) {
      this.jqd = this.PBJ.jqm;
    }
    this.Eut = 0L;
    this.gqR = 0L;
    this.Euw = 0;
    this.Euv = 0L;
    this.Euu = 0L;
    AppMethodBeat.o(36395);
  }
  
  public final boolean ub(int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    AppMethodBeat.i(36403);
    if (this.jpZ != -1) {}
    for (int i = this.jpZ;; i = paramInt)
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.jqc), Integer.valueOf(this.jpY), Integer.valueOf(this.jpV), Long.valueOf(this.Euu - this.gqR), Boolean.valueOf(this.jqe) });
      boolean bool1 = bool2;
      switch (this.jpV)
      {
      default: 
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(36403);
        return bool1;
        if (!uc(i))
        {
          this.jqb = true;
          if (this.jqc <= 0) {
            if (this.jpZ == -1)
            {
              this.jpW = 1;
              label184:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          this.PBI.anl(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label672;
          }
          if (!o(localPInt1.value, localPInt2.value, false)) {
            break label680;
          }
          this.jqc = Math.max(this.jqc, localPInt2.value);
          bool1 = bool2;
          break;
          this.jpW = 2;
          break label184;
          Log.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.Eus + " playStatus : " + this.jpW);
          this.Euv = Util.nowMilliSecond();
          if ((this.jpW != 2) && (this.jpW != 4))
          {
            this.jqd += this.PBJ.jqm;
            this.jqd = Math.min(this.jqd, 60);
            this.Eus += 1;
            this.jpW = 4;
          }
          this.PBI.bgW();
          break label184;
          if ((this.Eus == 0) && (this.Euu == 0L)) {
            fgB();
          }
          if (this.jqe)
          {
            this.PBI.bna(this.filename);
            if (this.jqb) {
              if ((this.Eus == 0) && (this.Euu == 0L))
              {
                fgB();
                label452:
                Log.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", new Object[] { Integer.valueOf(this.Eus), Integer.valueOf(this.Euw) });
                if (this.jpZ == -1) {
                  break label558;
                }
                this.PBI.aT(this.jpZ, true);
                this.jpZ = -1;
                bool1 = false;
                label511:
                this.jqb = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.jpW = paramInt;
              label558:
              do
              {
                bool1 = true;
                break;
                if (this.Euv <= 0L) {
                  break label452;
                }
                this.Euw = ((int)(this.Euw + Util.milliSecondsToNow(this.Euv)));
                break label452;
                if (this.PBI.fgn())
                {
                  bool1 = false;
                  break label511;
                }
                bool1 = true;
                break label511;
              } while (this.jpW == 3);
              Log.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.jpW) });
              if (this.PBI.fgn()) {
                paramInt = 3;
              } else {
                paramInt = this.jpW;
              }
            }
          }
          Log.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", new Object[] { this.filename });
          this.PBI.cq(this.filename, true);
          this.jqe = true;
          bool1 = true;
        }
        label672:
        Log.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
        label680:
        continue;
        fgB();
        if (this.jqe)
        {
          if (this.jqb)
          {
            if (this.jpZ == -1) {
              break label748;
            }
            this.PBI.aT(this.jpZ, true);
            this.jpZ = -1;
            bool1 = bool3;
          }
          for (;;)
          {
            this.jqb = bool1;
            this.PBI.anl(i);
            bool1 = bool2;
            break;
            label748:
            if (this.PBI.fgn()) {
              bool1 = bool3;
            } else {
              bool1 = true;
            }
          }
        }
        this.PBI.cq(this.filename, false);
        this.jqe = true;
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  public final boolean uc(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 617
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 57	com/tencent/mm/ui/chatting/gallery/o:jpV	I
    //   10: iconst_3
    //   11: if_icmpne +11 -> 22
    //   14: ldc_w 617
    //   17: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_1
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 61	com/tencent/mm/ui/chatting/gallery/o:jqc	I
    //   26: iload_1
    //   27: isub
    //   28: iconst_2
    //   29: if_icmpgt +22 -> 51
    //   32: aload_0
    //   33: getfield 61	com/tencent/mm/ui/chatting/gallery/o:jqc	I
    //   36: aload_0
    //   37: getfield 179	com/tencent/mm/ui/chatting/gallery/o:jpY	I
    //   40: if_icmpge +11 -> 51
    //   43: ldc_w 617
    //   46: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_0
    //   50: ireturn
    //   51: new 174	com/tencent/mm/pointers/PInt
    //   54: dup
    //   55: invokespecial 245	com/tencent/mm/pointers/PInt:<init>	()V
    //   58: astore 4
    //   60: new 174	com/tencent/mm/pointers/PInt
    //   63: dup
    //   64: invokespecial 245	com/tencent/mm/pointers/PInt:<init>	()V
    //   67: astore 5
    //   69: aload_0
    //   70: getfield 82	com/tencent/mm/ui/chatting/gallery/o:Eup	Lcom/tencent/mm/plugin/a/j;
    //   73: iload_1
    //   74: iload_1
    //   75: iconst_2
    //   76: iadd
    //   77: aload 4
    //   79: aload 5
    //   81: invokevirtual 248	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   84: ifeq +98 -> 182
    //   87: invokestatic 254	com/tencent/mm/modelvideo/o:bhk	()Lcom/tencent/mm/an/e;
    //   90: aload_0
    //   91: getfield 256	com/tencent/mm/ui/chatting/gallery/o:mediaId	Ljava/lang/String;
    //   94: aload 4
    //   96: getfield 177	com/tencent/mm/pointers/PInt:value	I
    //   99: aload 5
    //   101: getfield 177	com/tencent/mm/pointers/PInt:value	I
    //   104: invokevirtual 262	com/tencent/mm/an/e:isVideoDataAvailable	(Ljava/lang/String;II)Z
    //   107: istore_2
    //   108: iload_2
    //   109: istore_3
    //   110: iload_2
    //   111: ifne +10 -> 121
    //   114: aload_0
    //   115: iload_1
    //   116: putfield 61	com/tencent/mm/ui/chatting/gallery/o:jqc	I
    //   119: iload_2
    //   120: istore_3
    //   121: ldc_w 617
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
    //   143: invokestatic 303	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc 109
    //   148: new 264	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 305
    //   155: invokespecial 308	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokevirtual 309	java/lang/Exception:toString	()Ljava/lang/String;
    //   163: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  static final class a
  {
    int EuA;
    int PBL;
    int jqm;
    int jqn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.o
 * JD-Core Version:    0.7.0.1
 */