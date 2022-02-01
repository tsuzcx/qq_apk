package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.ag.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.HashMap;

public final class v
{
  HashMap<String, Integer> RhF;
  com.tencent.mm.plugin.a.j RhG;
  int RhI;
  int RhJ;
  long RhK;
  long RhL;
  private long RhM;
  private int RhN;
  p aeGj;
  a aeGk;
  String filename;
  long lxf;
  String mediaId;
  private int oYA;
  boolean oYB;
  boolean oYC;
  int oYs;
  int oYt;
  int oYv;
  int oYw;
  boolean oYy;
  int oYz;
  int qEw;
  
  public v(p paramp)
  {
    AppMethodBeat.i(36394);
    this.oYs = 0;
    this.oYt = 0;
    this.oYz = 0;
    this.RhF = new HashMap();
    this.RhJ = 0;
    this.oYB = false;
    this.oYC = false;
    this.aeGj = paramp;
    reset();
    this.RhG = new com.tencent.mm.plugin.a.j();
    this.aeGk = new a((byte)0);
    paramp = i.aRC().getValue("AndroidOnlineVideoArgs");
    if (!Util.isNullOrNil(paramp))
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "online video config : ".concat(String.valueOf(paramp)));
      paramp = paramp.split(";");
      if ((paramp != null) && (paramp.length >= 4))
      {
        this.aeGk.oYJ = Util.getInt(paramp[0], 5);
        this.aeGk.oYK = Util.getInt(paramp[1], 1);
        this.aeGk.RhR = Util.getInt(paramp[2], 75);
        this.aeGk.aeAo = (Util.getInt(paramp[3], 1) * 1048576);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.aeGk.oYJ = 5;
        this.aeGk.oYK = 1;
        this.aeGk.RhR = 75;
        this.aeGk.aeAo = 1048576;
      }
      Log.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.aeGk.oYJ), Integer.valueOf(this.aeGk.oYK), Integer.valueOf(this.aeGk.RhR), Integer.valueOf(this.aeGk.aeAo) });
      this.oYA = this.aeGk.oYJ;
      AppMethodBeat.o(36394);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(36405);
    paramPInt1.value = Math.max(paramInt, this.oYz);
    if (this.oYt == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.oYA;
    }
    if (this.oYt == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.oYA + 8);
    }
    if ((this.oYt == 3) || (this.oYt == 4))
    {
      paramPInt1.value = this.oYz;
      paramPInt2.value = (this.oYA + paramInt + 2 + this.aeGk.oYK);
    }
    if (paramPInt2.value >= this.oYv + 1) {
      paramPInt2.value = (this.oYv + 1);
    }
    if (paramPInt2.value <= paramPInt1.value)
    {
      paramPInt1.value += this.aeGk.oYK;
      AppMethodBeat.o(36405);
      return false;
    }
    Log.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.oYt), Integer.valueOf(this.oYz), Integer.valueOf(this.oYA) });
    AppMethodBeat.o(36405);
    return true;
  }
  
  private static void jwu()
  {
    AppMethodBeat.i(36411);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 1L, 1L, false);
    AppMethodBeat.o(36411);
  }
  
  private static void jwv()
  {
    AppMethodBeat.i(36412);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 2L, 1L, false);
    AppMethodBeat.o(36412);
  }
  
  private static void jww()
  {
    AppMethodBeat.i(36413);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 10L, 1L, false);
    AppMethodBeat.o(36413);
  }
  
  private static void jwx()
  {
    AppMethodBeat.i(36414);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 17L, 1L, false);
    AppMethodBeat.o(36414);
  }
  
  private void jwy()
  {
    AppMethodBeat.i(36415);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 24L, 1L, false);
    Log.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", new Object[] { Integer.valueOf(hashCode()), this.filename });
    com.tencent.mm.plugin.report.service.h.OAn.b(13836, new Object[] { Integer.valueOf(303), Long.valueOf(Util.nowSecond()), "" });
    AppMethodBeat.o(36415);
  }
  
  private static void jwz()
  {
    AppMethodBeat.i(36416);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 134L, 1L, false);
    AppMethodBeat.o(36416);
  }
  
  private boolean p(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(36406);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.RhG.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        bool = com.tencent.mm.modelvideo.v.bOi().isVideoDataAvailable(this.mediaId, localPInt1.value, localPInt2.value);
        if (bool) {
          break label333;
        }
        if (!this.RhF.containsKey(this.mediaId + 0 + "_-1"))
        {
          String str = this.mediaId + localPInt1.value + "_" + localPInt2.value;
          Log.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.oYC), Boolean.valueOf(paramBoolean) });
          if ((this.RhF.containsKey(str)) || ((this.oYC) && (!paramBoolean))) {
            break label314;
          }
          this.oYC = true;
          com.tencent.mm.modelvideo.v.bOi();
          com.tencent.mm.modelcdntran.j.v(this.mediaId, localPInt1.value, localPInt2.value);
          this.RhF.put(str, Integer.valueOf(paramInt2));
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
  
  public final boolean bBq(String paramString)
  {
    AppMethodBeat.i(36397);
    e.bIg();
    if (!e.bIt())
    {
      AppMethodBeat.o(36397);
      return false;
    }
    reset();
    Object localObject = ab.Qo(paramString);
    if (localObject != null)
    {
      int i = ((z)localObject).osy;
      if (i < this.aeGk.aeAo)
      {
        Log.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", new Object[] { Integer.valueOf(i), Integer.valueOf(this.aeGk.aeAo) });
        ab.b((z)localObject, 9);
        jwx();
        AppMethodBeat.o(36397);
        return false;
      }
    }
    ab.bh(paramString, 1);
    u.bOf();
    com.tencent.mm.modelvideo.v.bOi();
    localObject = com.tencent.mm.modelcdntran.j.NA(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(36397);
      return false;
    }
    this.mediaId = ((com.tencent.mm.g.h)localObject).field_mediaId;
    this.qEw = ((com.tencent.mm.g.h)localObject).lxh;
    this.filename = paramString;
    this.oYs = 1;
    this.oYv = 0;
    boolean bool = com.tencent.mm.modelvideo.v.bOm().bOJ();
    com.tencent.mm.modelvideo.v.bOi().a((com.tencent.mm.g.h)localObject, bool);
    this.lxf = Util.nowMilliSecond();
    jwu();
    Log.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, paramString, Long.valueOf(this.lxf) });
    AppMethodBeat.o(36397);
    return true;
  }
  
  public final boolean bay(String paramString)
  {
    AppMethodBeat.i(36400);
    boolean bool = Util.isEqual(paramString, this.mediaId);
    AppMethodBeat.o(36400);
    return bool;
  }
  
  public final boolean cL(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36402);
    switch (this.oYs)
    {
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.oYs), Integer.valueOf(this.oYt) });
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 4L, 1L, false);
      AppMethodBeat.o(36402);
      return paramBoolean;
      this.oYt = 2;
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      a(paramInt, localPInt1, localPInt2);
      if (p(localPInt1.value, localPInt2.value, true))
      {
        this.oYw = -1;
        this.oYy = false;
        this.oYz = localPInt2.value;
        this.oYt = 3;
        this.aeGj.bJ(paramInt, paramBoolean);
        break;
      }
      this.oYw = paramInt;
      this.oYy = true;
      this.aeGj.bNT();
    }
  }
  
  public final boolean e(cc paramcc, z paramz)
  {
    AppMethodBeat.i(36396);
    if (paramcc.dSI())
    {
      paramcc = new com.tencent.mm.g.h();
      paramcc.taskName = "task_OnlineVideoUIHelper";
      paramcc.field_mediaId = com.tencent.mm.modelcdntran.h.a("downvideo", paramz.createTime, paramz.bOs(), paramz.getFileName());
      paramcc.url = paramz.pbk.nTu;
      paramcc.lxi = 1;
      paramcc.lxc = 7;
      paramcc.concurrentCount = 4;
      paramcc.filename = paramz.getFileName();
      com.tencent.mm.modelvideo.v.bOh();
      paramcc.field_fullpath = aa.PX(paramz.getFileName());
      paramcc.lxh = paramz.osy;
      this.mediaId = paramcc.field_mediaId;
      this.qEw = paramcc.lxh;
      this.filename = paramz.getFileName();
      this.oYs = 1;
      this.oYv = 0;
      boolean bool = com.tencent.mm.modelvideo.v.bOm().bOJ();
      com.tencent.mm.modelvideo.v.bOi().a(paramcc, bool);
      this.lxf = Util.nowMilliSecond();
      Log.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { this.mediaId, this.filename, Long.valueOf(this.lxf) });
      AppMethodBeat.o(36396);
      return true;
    }
    AppMethodBeat.o(36396);
    return false;
  }
  
  final void hKF()
  {
    AppMethodBeat.i(36408);
    com.tencent.mm.modelvideo.v.bOh();
    if (y.isH265Video(aa.PX(this.filename)))
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", new Object[] { this.filename });
      if (ab.Qs(this.filename)) {
        jwz();
      }
    }
    AppMethodBeat.o(36408);
  }
  
  final void hmV()
  {
    AppMethodBeat.i(36401);
    Log.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", new Object[] { this.filename });
    hmY();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36393);
        if (v.this.aeGj != null) {
          v.this.aeGj.di(v.this.filename, false);
        }
        AppMethodBeat.o(36393);
      }
    });
    AppMethodBeat.o(36401);
  }
  
  final void hmY()
  {
    AppMethodBeat.i(36409);
    if (this.RhL == 0L) {
      this.RhL = Util.nowMilliSecond();
    }
    AppMethodBeat.o(36409);
  }
  
  final Object[] hmZ()
  {
    AppMethodBeat.i(36410);
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.aeGj.getPlayVideoDuration());
    if (this.RhL <= 0L) {
      this.RhL = Util.nowMilliSecond();
    }
    int j = (int)(this.RhL - this.lxf);
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[1] = Integer.valueOf(i);
    if (this.RhK <= 0L) {
      this.RhK = Util.nowMilliSecond();
    }
    j = (int)(this.RhK - this.lxf);
    i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(this.RhJ);
    if (this.RhJ > 0)
    {
      if (this.RhN == 0) {
        this.RhN = ((int)(this.RhN + Util.milliSecondsToNow(this.RhM)));
      }
      arrayOfObject[4] = Integer.valueOf(this.RhN / this.RhJ);
    }
    for (;;)
    {
      arrayOfObject[5] = Integer.valueOf(this.aeGj.getUiStayTime());
      arrayOfObject[6] = Integer.valueOf(this.aeGj.Aqc);
      AppMethodBeat.o(36410);
      return arrayOfObject;
      arrayOfObject[4] = Integer.valueOf(0);
    }
  }
  
  public final boolean isStreaming()
  {
    AppMethodBeat.i(36399);
    if ((!Util.isNullOrNil(this.mediaId)) && ((this.oYs == 1) || (this.oYs == 3)))
    {
      AppMethodBeat.o(36399);
      return true;
    }
    AppMethodBeat.o(36399);
    return false;
  }
  
  public final void jws()
  {
    AppMethodBeat.i(36398);
    Log.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
    int i;
    if (this.oYs == 3)
    {
      i = 1;
      this.oYs = 0;
      if (!Util.isNullOrNil(this.mediaId))
      {
        if (i == 0) {
          break label77;
        }
        hKF();
      }
    }
    for (;;)
    {
      com.tencent.mm.modelvideo.v.bOi().l(this.mediaId, hmZ());
      jwv();
      AppMethodBeat.o(36398);
      return;
      i = 0;
      break;
      label77:
      if (this.RhI >= this.aeGk.RhR)
      {
        Log.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", new Object[] { Integer.valueOf(this.RhI), Integer.valueOf(this.aeGk.RhR) });
        ab.bf(this.filename, 2);
        jww();
      }
    }
  }
  
  public final void jwt()
  {
    AppMethodBeat.i(36407);
    String str = this.mediaId + 0 + "_-1";
    if (!this.RhF.containsKey(str))
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", new Object[] { this.mediaId });
      com.tencent.mm.modelvideo.v.bOi();
      com.tencent.mm.modelcdntran.j.v(this.mediaId, 0, -1);
      this.RhF.put(str, Integer.valueOf(0));
      jwy();
    }
    this.oYt = 5;
    AppMethodBeat.o(36407);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(36395);
    this.mediaId = "";
    this.filename = "";
    this.oYw = -1;
    this.RhI = 0;
    this.qEw = 0;
    this.oYz = 0;
    this.oYv = 0;
    this.RhJ = 0;
    this.oYt = 0;
    this.oYs = 0;
    this.oYy = false;
    this.oYB = false;
    this.oYC = false;
    this.RhF.clear();
    if (this.aeGk != null) {
      this.oYA = this.aeGk.oYJ;
    }
    this.RhK = 0L;
    this.lxf = 0L;
    this.RhN = 0;
    this.RhM = 0L;
    this.RhL = 0L;
    AppMethodBeat.o(36395);
  }
  
  public final boolean xa(int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    AppMethodBeat.i(36403);
    if (this.oYw != -1) {}
    for (int i = this.oYw;; i = paramInt)
    {
      Log.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.oYz), Integer.valueOf(this.oYv), Integer.valueOf(this.oYs), Long.valueOf(this.RhL - this.lxf), Boolean.valueOf(this.oYB) });
      boolean bool1 = bool2;
      switch (this.oYs)
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
          this.oYy = true;
          if (this.oYz <= 0) {
            if (this.oYw == -1)
            {
              this.oYt = 1;
              label184:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          this.aeGj.aCX(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label672;
          }
          if (!p(localPInt1.value, localPInt2.value, false)) {
            break label680;
          }
          this.oYz = Math.max(this.oYz, localPInt2.value);
          bool1 = bool2;
          break;
          this.oYt = 2;
          break label184;
          Log.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.RhJ + " playStatus : " + this.oYt);
          this.RhM = Util.nowMilliSecond();
          if ((this.oYt != 2) && (this.oYt != 4))
          {
            this.oYA += this.aeGk.oYJ;
            this.oYA = Math.min(this.oYA, 60);
            this.RhJ += 1;
            this.oYt = 4;
          }
          this.aeGj.bNT();
          break label184;
          if ((this.RhJ == 0) && (this.RhL == 0L)) {
            hmY();
          }
          if (this.oYB)
          {
            this.aeGj.bBo(this.filename);
            if (this.oYy) {
              if ((this.RhJ == 0) && (this.RhL == 0L))
              {
                hmY();
                label452:
                Log.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", new Object[] { Integer.valueOf(this.RhJ), Integer.valueOf(this.RhN) });
                if (this.oYw == -1) {
                  break label558;
                }
                this.aeGj.bJ(this.oYw, true);
                this.oYw = -1;
                bool1 = false;
                label511:
                this.oYy = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.oYt = paramInt;
              label558:
              do
              {
                bool1 = true;
                break;
                if (this.RhM <= 0L) {
                  break label452;
                }
                this.RhN = ((int)(this.RhN + Util.milliSecondsToNow(this.RhM)));
                break label452;
                if (this.aeGj.hmF())
                {
                  bool1 = false;
                  break label511;
                }
                bool1 = true;
                break label511;
              } while (this.oYt == 3);
              Log.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.oYt) });
              if (this.aeGj.hmF()) {
                paramInt = 3;
              } else {
                paramInt = this.oYt;
              }
            }
          }
          Log.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", new Object[] { this.filename });
          this.aeGj.di(this.filename, true);
          this.oYB = true;
          bool1 = true;
        }
        label672:
        Log.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
        label680:
        continue;
        hmY();
        if (this.oYB)
        {
          if (this.oYy)
          {
            if (this.oYw == -1) {
              break label748;
            }
            this.aeGj.bJ(this.oYw, true);
            this.oYw = -1;
            bool1 = bool3;
          }
          for (;;)
          {
            this.oYy = bool1;
            this.aeGj.aCX(i);
            bool1 = bool2;
            break;
            label748:
            if (this.aeGj.hmF()) {
              bool1 = bool3;
            } else {
              bool1 = true;
            }
          }
        }
        this.aeGj.di(this.filename, false);
        this.oYB = true;
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
    //   7: getfield 57	com/tencent/mm/ui/chatting/gallery/v:oYs	I
    //   10: iconst_3
    //   11: if_icmpne +11 -> 22
    //   14: ldc_w 617
    //   17: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_1
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 61	com/tencent/mm/ui/chatting/gallery/v:oYz	I
    //   26: iload_1
    //   27: isub
    //   28: iconst_2
    //   29: if_icmpgt +22 -> 51
    //   32: aload_0
    //   33: getfield 61	com/tencent/mm/ui/chatting/gallery/v:oYz	I
    //   36: aload_0
    //   37: getfield 179	com/tencent/mm/ui/chatting/gallery/v:oYv	I
    //   40: if_icmpge +11 -> 51
    //   43: ldc_w 617
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
    //   70: getfield 82	com/tencent/mm/ui/chatting/gallery/v:RhG	Lcom/tencent/mm/plugin/a/j;
    //   73: iload_1
    //   74: iload_1
    //   75: iconst_2
    //   76: iadd
    //   77: aload 4
    //   79: aload 5
    //   81: invokevirtual 250	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   84: ifeq +98 -> 182
    //   87: invokestatic 256	com/tencent/mm/modelvideo/v:bOi	()Lcom/tencent/mm/modelcdntran/j;
    //   90: aload_0
    //   91: getfield 258	com/tencent/mm/ui/chatting/gallery/v:mediaId	Ljava/lang/String;
    //   94: aload 4
    //   96: getfield 177	com/tencent/mm/pointers/PInt:value	I
    //   99: aload 5
    //   101: getfield 177	com/tencent/mm/pointers/PInt:value	I
    //   104: invokevirtual 264	com/tencent/mm/modelcdntran/j:isVideoDataAvailable	(Ljava/lang/String;II)Z
    //   107: istore_2
    //   108: iload_2
    //   109: istore_3
    //   110: iload_2
    //   111: ifne +10 -> 121
    //   114: aload_0
    //   115: iload_1
    //   116: putfield 61	com/tencent/mm/ui/chatting/gallery/v:oYz	I
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
    //   143: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc 109
    //   148: new 266	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 307
    //   155: invokespecial 310	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokevirtual 311	java/lang/Exception:toString	()Ljava/lang/String;
    //   163: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	187	0	this	v
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
    int RhR;
    int aeAo;
    int oYJ;
    int oYK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.v
 * JD-Core Version:    0.7.0.1
 */