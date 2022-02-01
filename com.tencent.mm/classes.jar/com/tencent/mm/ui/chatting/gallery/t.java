package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.c;
import com.tencent.mm.modelvideo.ac.a;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;

public final class t
{
  HashMap<String, Integer> KIf;
  j KIg;
  int KIi;
  int KIj;
  long KIk;
  long KIl;
  private long KIm;
  private int KIn;
  n WWF;
  a WWG;
  String filename;
  long iVa;
  String mediaId;
  int mfA;
  boolean mfC;
  int mfD;
  private int mfE;
  boolean mfF;
  boolean mfG;
  int mfw;
  int mfx;
  int mfz;
  int nEz;
  
  public t(n paramn)
  {
    AppMethodBeat.i(36394);
    this.mfw = 0;
    this.mfx = 0;
    this.mfD = 0;
    this.KIf = new HashMap();
    this.KIj = 0;
    this.mfF = false;
    this.mfG = false;
    this.WWF = paramn;
    reset();
    this.KIg = new j();
    this.WWG = new a((byte)0);
    paramn = com.tencent.mm.n.h.axc().getValue("AndroidOnlineVideoArgs");
    if (!Util.isNullOrNil(paramn))
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "online video config : ".concat(String.valueOf(paramn)));
      paramn = paramn.split(";");
      if ((paramn != null) && (paramn.length >= 4))
      {
        this.WWG.mfN = Util.getInt(paramn[0], 5);
        this.WWG.mfO = Util.getInt(paramn[1], 1);
        this.WWG.KIr = Util.getInt(paramn[2], 75);
        this.WWG.WQO = (Util.getInt(paramn[3], 1) * 1048576);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.WWG.mfN = 5;
        this.WWG.mfO = 1;
        this.WWG.KIr = 75;
        this.WWG.WQO = 1048576;
      }
      Log.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.WWG.mfN), Integer.valueOf(this.WWG.mfO), Integer.valueOf(this.WWG.KIr), Integer.valueOf(this.WWG.WQO) });
      this.mfE = this.WWG.mfN;
      AppMethodBeat.o(36394);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(36405);
    paramPInt1.value = Math.max(paramInt, this.mfD);
    if (this.mfx == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.mfE;
    }
    if (this.mfx == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.mfE + 8);
    }
    if ((this.mfx == 3) || (this.mfx == 4))
    {
      paramPInt1.value = this.mfD;
      paramPInt2.value = (this.mfE + paramInt + 2 + this.WWG.mfO);
    }
    if (paramPInt2.value >= this.mfz + 1) {
      paramPInt2.value = (this.mfz + 1);
    }
    if (paramPInt2.value <= paramPInt1.value)
    {
      paramPInt1.value += this.WWG.mfO;
      AppMethodBeat.o(36405);
      return false;
    }
    Log.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.mfx), Integer.valueOf(this.mfD), Integer.valueOf(this.mfE) });
    AppMethodBeat.o(36405);
    return true;
  }
  
  private static void hSR()
  {
    AppMethodBeat.i(36411);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 1L, 1L, false);
    AppMethodBeat.o(36411);
  }
  
  private static void hSS()
  {
    AppMethodBeat.i(36412);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 2L, 1L, false);
    AppMethodBeat.o(36412);
  }
  
  private static void hST()
  {
    AppMethodBeat.i(36413);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 10L, 1L, false);
    AppMethodBeat.o(36413);
  }
  
  private static void hSU()
  {
    AppMethodBeat.i(36414);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 17L, 1L, false);
    AppMethodBeat.o(36414);
  }
  
  private void hSV()
  {
    AppMethodBeat.i(36415);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 24L, 1L, false);
    Log.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", new Object[] { Integer.valueOf(hashCode()), this.filename });
    com.tencent.mm.plugin.report.service.h.IzE.a(13836, new Object[] { Integer.valueOf(303), Long.valueOf(Util.nowSecond()), "" });
    AppMethodBeat.o(36415);
  }
  
  private static void hSW()
  {
    AppMethodBeat.i(36416);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 134L, 1L, false);
    AppMethodBeat.o(36416);
  }
  
  private boolean p(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(36406);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.KIg.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        bool = s.bqC().isVideoDataAvailable(this.mediaId, localPInt1.value, localPInt2.value);
        if (bool) {
          break label333;
        }
        if (!this.KIf.containsKey(this.mediaId + 0 + "_-1"))
        {
          String str = this.mediaId + localPInt1.value + "_" + localPInt2.value;
          Log.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.mfG), Boolean.valueOf(paramBoolean) });
          if ((this.KIf.containsKey(str)) || ((this.mfG) && (!paramBoolean))) {
            break label314;
          }
          this.mfG = true;
          s.bqC();
          com.tencent.mm.aq.e.s(this.mediaId, localPInt1.value, localPInt2.value);
          this.KIf.put(str, Integer.valueOf(paramInt2));
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
  
  public final boolean bY(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36402);
    switch (this.mfw)
    {
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mfw), Integer.valueOf(this.mfx) });
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 4L, 1L, false);
      AppMethodBeat.o(36402);
      return paramBoolean;
      this.mfx = 2;
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      a(paramInt, localPInt1, localPInt2);
      if (p(localPInt1.value, localPInt2.value, true))
      {
        this.mfA = -1;
        this.mfC = false;
        this.mfD = localPInt2.value;
        this.mfx = 3;
        this.WWF.bc(paramInt, paramBoolean);
        break;
      }
      this.mfA = paramInt;
      this.mfC = true;
      this.WWF.bqn();
    }
  }
  
  public final boolean bbW(String paramString)
  {
    AppMethodBeat.i(36400);
    boolean bool = Util.isEqual(paramString, this.mediaId);
    AppMethodBeat.o(36400);
    return bool;
  }
  
  public final boolean bzC(String paramString)
  {
    AppMethodBeat.i(36397);
    com.tencent.mm.modelcontrol.e.bkp();
    if (!com.tencent.mm.modelcontrol.e.bkz())
    {
      AppMethodBeat.o(36397);
      return false;
    }
    reset();
    Object localObject = y.Yk(paramString);
    if (localObject != null)
    {
      int i = ((w)localObject).lAW;
      if (i < this.WWG.WQO)
      {
        Log.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", new Object[] { Integer.valueOf(i), Integer.valueOf(this.WWG.WQO) });
        y.b((w)localObject, 9);
        hSU();
        AppMethodBeat.o(36397);
        return false;
      }
    }
    y.aT(paramString, 1);
    r.bqz();
    s.bqC();
    localObject = com.tencent.mm.aq.e.VB(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(36397);
      return false;
    }
    this.mediaId = ((com.tencent.mm.i.h)localObject).field_mediaId;
    this.nEz = ((com.tencent.mm.i.h)localObject).iVc;
    this.filename = paramString;
    this.mfw = 1;
    this.mfz = 0;
    boolean bool = s.bqG().brd();
    s.bqC().a((com.tencent.mm.i.h)localObject, bool);
    this.iVa = Util.nowMilliSecond();
    hSR();
    Log.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, paramString, Long.valueOf(this.iVa) });
    AppMethodBeat.o(36397);
    return true;
  }
  
  public final boolean d(ca paramca, w paramw)
  {
    AppMethodBeat.i(36396);
    if (paramca.dlS())
    {
      paramca = new com.tencent.mm.i.h();
      paramca.taskName = "task_OnlineVideoUIHelper";
      paramca.field_mediaId = c.a("downvideo", paramw.createTime, paramw.bqM(), paramw.getFileName());
      paramca.url = paramw.mhZ.lor;
      paramca.iVd = 1;
      paramca.iUX = 7;
      paramca.concurrentCount = 4;
      paramca.filename = paramw.getFileName();
      s.bqB();
      paramca.field_fullpath = x.XT(paramw.getFileName());
      paramca.iVc = paramw.lAW;
      this.mediaId = paramca.field_mediaId;
      this.nEz = paramca.iVc;
      this.filename = paramw.getFileName();
      this.mfw = 1;
      this.mfz = 0;
      boolean bool = s.bqG().brd();
      s.bqC().a(paramca, bool);
      this.iVa = Util.nowMilliSecond();
      Log.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, this.filename, Long.valueOf(this.iVa) });
      AppMethodBeat.o(36396);
      return true;
    }
    AppMethodBeat.o(36396);
    return false;
  }
  
  final void fUE()
  {
    AppMethodBeat.i(36401);
    Log.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", new Object[] { this.filename });
    fUH();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36393);
        if (t.this.WWF != null) {
          t.this.WWF.cD(t.this.filename, false);
        }
        AppMethodBeat.o(36393);
      }
    });
    AppMethodBeat.o(36401);
  }
  
  final void fUH()
  {
    AppMethodBeat.i(36409);
    if (this.KIl == 0L) {
      this.KIl = Util.nowMilliSecond();
    }
    AppMethodBeat.o(36409);
  }
  
  final Object[] fUI()
  {
    AppMethodBeat.i(36410);
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.WWF.getPlayVideoDuration());
    if (this.KIl <= 0L) {
      this.KIl = Util.nowMilliSecond();
    }
    int j = (int)(this.KIl - this.iVa);
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[1] = Integer.valueOf(i);
    if (this.KIk <= 0L) {
      this.KIk = Util.nowMilliSecond();
    }
    j = (int)(this.KIk - this.iVa);
    i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(this.KIj);
    if (this.KIj > 0)
    {
      if (this.KIn == 0) {
        this.KIn = ((int)(this.KIn + Util.milliSecondsToNow(this.KIm)));
      }
      arrayOfObject[4] = Integer.valueOf(this.KIn / this.KIj);
    }
    for (;;)
    {
      arrayOfObject[5] = Integer.valueOf(this.WWF.getUiStayTime());
      arrayOfObject[6] = Integer.valueOf(this.WWF.wTz);
      AppMethodBeat.o(36410);
      return arrayOfObject;
      arrayOfObject[4] = Integer.valueOf(0);
    }
  }
  
  final void gnS()
  {
    AppMethodBeat.i(36408);
    s.bqB();
    if (v.isH265Video(x.XT(this.filename)))
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", new Object[] { this.filename });
      if (y.Yo(this.filename)) {
        hSW();
      }
    }
    AppMethodBeat.o(36408);
  }
  
  public final void hSP()
  {
    AppMethodBeat.i(36398);
    Log.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
    int i;
    if (this.mfw == 3)
    {
      i = 1;
      this.mfw = 0;
      if (!Util.isNullOrNil(this.mediaId))
      {
        if (i == 0) {
          break label77;
        }
        gnS();
      }
    }
    for (;;)
    {
      s.bqC().l(this.mediaId, fUI());
      hSS();
      AppMethodBeat.o(36398);
      return;
      i = 0;
      break;
      label77:
      if (this.KIi >= this.WWG.KIr)
      {
        Log.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", new Object[] { Integer.valueOf(this.KIi), Integer.valueOf(this.WWG.KIr) });
        y.aR(this.filename, 2);
        hST();
      }
    }
  }
  
  public final void hSQ()
  {
    AppMethodBeat.i(36407);
    String str = this.mediaId + 0 + "_-1";
    if (!this.KIf.containsKey(str))
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", new Object[] { this.mediaId });
      s.bqC();
      com.tencent.mm.aq.e.s(this.mediaId, 0, -1);
      this.KIf.put(str, Integer.valueOf(0));
      hSV();
    }
    this.mfx = 5;
    AppMethodBeat.o(36407);
  }
  
  public final boolean isStreaming()
  {
    AppMethodBeat.i(36399);
    if ((!Util.isNullOrNil(this.mediaId)) && ((this.mfw == 1) || (this.mfw == 3)))
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
    this.mfA = -1;
    this.KIi = 0;
    this.nEz = 0;
    this.mfD = 0;
    this.mfz = 0;
    this.KIj = 0;
    this.mfx = 0;
    this.mfw = 0;
    this.mfC = false;
    this.mfF = false;
    this.mfG = false;
    this.KIf.clear();
    if (this.WWG != null) {
      this.mfE = this.WWG.mfN;
    }
    this.KIk = 0L;
    this.iVa = 0L;
    this.KIn = 0;
    this.KIm = 0L;
    this.KIl = 0L;
    AppMethodBeat.o(36395);
  }
  
  public final boolean xa(int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    AppMethodBeat.i(36403);
    if (this.mfA != -1) {}
    for (int i = this.mfA;; i = paramInt)
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.mfD), Integer.valueOf(this.mfz), Integer.valueOf(this.mfw), Long.valueOf(this.KIl - this.iVa), Boolean.valueOf(this.mfF) });
      boolean bool1 = bool2;
      switch (this.mfw)
      {
      default: 
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(36403);
        return bool1;
        if (!xb(i))
        {
          this.mfC = true;
          if (this.mfD <= 0) {
            if (this.mfA == -1)
            {
              this.mfx = 1;
              label184:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          this.WWF.awn(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label672;
          }
          if (!p(localPInt1.value, localPInt2.value, false)) {
            break label680;
          }
          this.mfD = Math.max(this.mfD, localPInt2.value);
          bool1 = bool2;
          break;
          this.mfx = 2;
          break label184;
          Log.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.KIj + " playStatus : " + this.mfx);
          this.KIm = Util.nowMilliSecond();
          if ((this.mfx != 2) && (this.mfx != 4))
          {
            this.mfE += this.WWG.mfN;
            this.mfE = Math.min(this.mfE, 60);
            this.KIj += 1;
            this.mfx = 4;
          }
          this.WWF.bqn();
          break label184;
          if ((this.KIj == 0) && (this.KIl == 0L)) {
            fUH();
          }
          if (this.mfF)
          {
            this.WWF.bzA(this.filename);
            if (this.mfC) {
              if ((this.KIj == 0) && (this.KIl == 0L))
              {
                fUH();
                label452:
                Log.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", new Object[] { Integer.valueOf(this.KIj), Integer.valueOf(this.KIn) });
                if (this.mfA == -1) {
                  break label558;
                }
                this.WWF.bc(this.mfA, true);
                this.mfA = -1;
                bool1 = false;
                label511:
                this.mfC = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.mfx = paramInt;
              label558:
              do
              {
                bool1 = true;
                break;
                if (this.KIm <= 0L) {
                  break label452;
                }
                this.KIn = ((int)(this.KIn + Util.milliSecondsToNow(this.KIm)));
                break label452;
                if (this.WWF.fUl())
                {
                  bool1 = false;
                  break label511;
                }
                bool1 = true;
                break label511;
              } while (this.mfx == 3);
              Log.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.mfx) });
              if (this.WWF.fUl()) {
                paramInt = 3;
              } else {
                paramInt = this.mfx;
              }
            }
          }
          Log.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", new Object[] { this.filename });
          this.WWF.cD(this.filename, true);
          this.mfF = true;
          bool1 = true;
        }
        label672:
        Log.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
        label680:
        continue;
        fUH();
        if (this.mfF)
        {
          if (this.mfC)
          {
            if (this.mfA == -1) {
              break label748;
            }
            this.WWF.bc(this.mfA, true);
            this.mfA = -1;
            bool1 = bool3;
          }
          for (;;)
          {
            this.mfC = bool1;
            this.WWF.awn(i);
            bool1 = bool2;
            break;
            label748:
            if (this.WWF.fUl()) {
              bool1 = bool3;
            } else {
              bool1 = true;
            }
          }
        }
        this.WWF.cD(this.filename, false);
        this.mfF = true;
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  public final boolean xb(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 617
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 57	com/tencent/mm/ui/chatting/gallery/t:mfw	I
    //   10: iconst_3
    //   11: if_icmpne +11 -> 22
    //   14: ldc_w 617
    //   17: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_1
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 61	com/tencent/mm/ui/chatting/gallery/t:mfD	I
    //   26: iload_1
    //   27: isub
    //   28: iconst_2
    //   29: if_icmpgt +22 -> 51
    //   32: aload_0
    //   33: getfield 61	com/tencent/mm/ui/chatting/gallery/t:mfD	I
    //   36: aload_0
    //   37: getfield 179	com/tencent/mm/ui/chatting/gallery/t:mfz	I
    //   40: if_icmpge +11 -> 51
    //   43: ldc_w 617
    //   46: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_0
    //   50: ireturn
    //   51: new 174	com/tencent/mm/pointers/PInt
    //   54: dup
    //   55: invokespecial 246	com/tencent/mm/pointers/PInt:<init>	()V
    //   58: astore 4
    //   60: new 174	com/tencent/mm/pointers/PInt
    //   63: dup
    //   64: invokespecial 246	com/tencent/mm/pointers/PInt:<init>	()V
    //   67: astore 5
    //   69: aload_0
    //   70: getfield 82	com/tencent/mm/ui/chatting/gallery/t:KIg	Lcom/tencent/mm/plugin/a/j;
    //   73: iload_1
    //   74: iload_1
    //   75: iconst_2
    //   76: iadd
    //   77: aload 4
    //   79: aload 5
    //   81: invokevirtual 249	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   84: ifeq +98 -> 182
    //   87: invokestatic 255	com/tencent/mm/modelvideo/s:bqC	()Lcom/tencent/mm/aq/e;
    //   90: aload_0
    //   91: getfield 257	com/tencent/mm/ui/chatting/gallery/t:mediaId	Ljava/lang/String;
    //   94: aload 4
    //   96: getfield 177	com/tencent/mm/pointers/PInt:value	I
    //   99: aload 5
    //   101: getfield 177	com/tencent/mm/pointers/PInt:value	I
    //   104: invokevirtual 263	com/tencent/mm/aq/e:isVideoDataAvailable	(Ljava/lang/String;II)Z
    //   107: istore_2
    //   108: iload_2
    //   109: istore_3
    //   110: iload_2
    //   111: ifne +10 -> 121
    //   114: aload_0
    //   115: iload_1
    //   116: putfield 61	com/tencent/mm/ui/chatting/gallery/t:mfD	I
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
    //   143: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc 109
    //   148: new 265	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 306
    //   155: invokespecial 309	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokevirtual 310	java/lang/Exception:toString	()Ljava/lang/String;
    //   163: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	187	0	this	t
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
    int KIr;
    int WQO;
    int mfN;
    int mfO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.t
 * JD-Core Version:    0.7.0.1
 */