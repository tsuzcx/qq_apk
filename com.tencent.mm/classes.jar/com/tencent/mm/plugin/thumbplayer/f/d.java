package com.tencent.mm.plugin.thumbplayer.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.pm;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/reporter/TPPlayerReporter;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/PlayerReporter;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/DownloadReporter;", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/TPVideoPlayReportStruct;", "enterTime", "", "scene", "", "(Lcom/tencent/mm/autogen/mmdata/rpt/TPVideoPlayReportStruct;JI)V", "audioDecoderType", "bufferingCount", "downloadStartTime", "firstStartTime", "isOnline", "", "isSeekBuffering", "lastBufferingTime", "lastSeekTime", "lastStartTime", "playErrorCode", "prepareTime", "seekCount", "totalBufferingCost", "totalPlayDuration", "totalSeekCost", "videoDecoderType", "videoPath", "", "onBufferingStarted", "", "onBufferingStopped", "onCompleted", "onDownloadError", "ret", "onDownloadStarted", "timestamp", "onDownloadSucceed", "onDuplicateFileFound", "onError", "errorCode", "onFirstVideoFrame", "onInfo", "what", "arg1", "arg2", "onMoovLack", "onMoovParseFailed", "onMoovParseSucceed", "onMoovReady", "offset", "length", "onNeedCompletion", "onPause", "onPrepared", "path", "onProgress", "time", "onRequestAllData", "onRequestH264", "onSeek", "current", "onSeekCompleted", "onStart", "onStartDownload", "onStop", "onStopDownload", "report", "safeCost", "cost", "Companion", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements a, c
{
  public static final d.a TGm;
  private int Aqc;
  private int Gpp;
  private long RhE;
  private long TGa;
  private long TGb;
  private long TGc;
  private final pm TGn;
  private long TGo;
  private int TGp;
  private long TGq;
  private boolean TGr;
  private int TGs;
  private int TGt;
  private final long enterTime;
  private boolean isOnline;
  private long sSJ;
  private long sXR;
  private final int scene;
  private long teM;
  private String videoPath;
  
  static
  {
    AppMethodBeat.i(272102);
    TGm = new d.a((byte)0);
    AppMethodBeat.o(272102);
  }
  
  public d(pm parampm, long paramLong, int paramInt)
  {
    AppMethodBeat.i(272075);
    this.TGn = parampm;
    this.enterTime = paramLong;
    this.scene = paramInt;
    AppMethodBeat.o(272075);
  }
  
  private final void report()
  {
    AppMethodBeat.i(272085);
    Log.i("MicroMsg.TPPlayerReporter", s.X("report: enter=", Long.valueOf(this.enterTime)));
    this.TGn.iZq = Util.milliSecondsToNow(this.enterTime);
    if (this.Gpp > 0)
    {
      this.TGn.jmr = (this.TGo / this.Gpp);
      this.TGn.jmq = this.Gpp;
    }
    this.TGn.iXC = this.TGb;
    if (this.TGp > 0)
    {
      this.TGn.jmI = this.TGp;
      this.TGn.jmJ = (this.TGq / this.TGp);
    }
    this.TGn.jmp = Math.max(this.TGa - this.sSJ, 0L);
    this.TGn.iqr = this.scene;
    this.TGn.jmE = this.TGt;
    this.TGn.jmG = this.TGs;
    j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCg(), null, (m)new b(this, null), 2);
    AppMethodBeat.o(272085);
  }
  
  public final void aD(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(272113);
    Log.d("MicroMsg.TPPlayerReporter", "onPrepare: isOnline=" + paramBoolean + ", path=" + paramString);
    this.videoPath = paramString;
    this.isOnline = paramBoolean;
    this.sSJ = Util.nowMilliSecond();
    AppMethodBeat.o(272113);
  }
  
  public final void aga(int paramInt) {}
  
  public final void aoF(int paramInt)
  {
    AppMethodBeat.i(272242);
    Log.d("MicroMsg.TPPlayerReporter", s.X("onDownloadError: ", Integer.valueOf(paramInt)));
    this.TGn.jmu = paramInt;
    this.TGn.jmt = Util.milliSecondsToNow(this.sXR);
    AppMethodBeat.o(272242);
  }
  
  public final void be(int paramInt, long paramLong)
  {
    int i = 2;
    switch (paramInt)
    {
    default: 
      return;
    case 203: 
      paramInt = i;
      switch ((int)paramLong)
      {
      }
      for (paramInt = 0;; paramInt = 1)
      {
        this.TGs = paramInt;
        return;
      }
    }
    paramInt = i;
    switch ((int)paramLong)
    {
    }
    for (paramInt = 0;; paramInt = 1)
    {
      this.TGt = paramInt;
      return;
    }
  }
  
  public final void bq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272224);
    Log.d("MicroMsg.TPPlayerReporter", "onMoovReady, offset=" + paramLong1 + ", length=" + paramLong2);
    this.TGn.jmx = Math.max(Util.nowMilliSecond() - this.sXR, 0L);
    this.TGn.jmy = paramLong1;
    this.TGn.jmz = paramLong2;
    this.TGn.jmB = 1L;
    AppMethodBeat.o(272224);
  }
  
  public final void fvq()
  {
    AppMethodBeat.i(272157);
    Log.d("MicroMsg.TPPlayerReporter", "onCompleted");
    if (this.teM > 0L)
    {
      this.TGb += Util.milliSecondsToNow(this.teM);
      this.teM = 0L;
    }
    report();
    AppMethodBeat.o(272157);
  }
  
  public final void gZM()
  {
    AppMethodBeat.i(272200);
    Log.d("MicroMsg.TPPlayerReporter", "onStartDownload");
    this.sXR = Util.nowMilliSecond();
    AppMethodBeat.o(272200);
  }
  
  public final void hLA()
  {
    AppMethodBeat.i(272270);
    Log.d("MicroMsg.TPPlayerReporter", "onRequestH264");
    AppMethodBeat.o(272270);
  }
  
  public final void hLB()
  {
    AppMethodBeat.i(272121);
    if ((this.TGn.iJw <= 0L) && (this.sSJ > 0L))
    {
      Log.d("MicroMsg.TPPlayerReporter", "onFirstVideoFrame");
      this.TGn.iJw = Util.milliSecondsToNow(this.sSJ);
    }
    AppMethodBeat.o(272121);
  }
  
  public final void hLC()
  {
    AppMethodBeat.i(272130);
    Log.d("MicroMsg.TPPlayerReporter", "onSeekCompleted");
    if (this.RhE >= 0L) {
      this.TGq += Util.milliSecondsToNow(this.RhE);
    }
    AppMethodBeat.o(272130);
  }
  
  public final void hLD()
  {
    AppMethodBeat.i(272173);
    Log.d("MicroMsg.TPPlayerReporter", "onBufferingStarted");
    this.TGc = Util.nowMilliSecond();
    if (this.TGc - this.RhE < 300L) {}
    for (boolean bool = true;; bool = false)
    {
      this.TGr = bool;
      if (!this.TGr) {
        this.Gpp += 1;
      }
      AppMethodBeat.o(272173);
      return;
    }
  }
  
  public final void hLE()
  {
    AppMethodBeat.i(272182);
    Log.d("MicroMsg.TPPlayerReporter", "onBufferingStopped");
    if (this.TGc > 0L)
    {
      if (!this.TGr) {
        this.TGo += Util.milliSecondsToNow(this.TGc);
      }
      this.TGc = 0L;
    }
    this.TGr = false;
    AppMethodBeat.o(272182);
  }
  
  public final void hLs()
  {
    AppMethodBeat.i(272208);
    Log.d("MicroMsg.TPPlayerReporter", "onStopDownload");
    AppMethodBeat.o(272208);
  }
  
  public final void hLt()
  {
    AppMethodBeat.i(272230);
    Log.d("MicroMsg.TPPlayerReporter", "onDownloadSucceed");
    this.TGn.jmu = 0L;
    this.TGn.jmt = Util.milliSecondsToNow(this.sXR);
    AppMethodBeat.o(272230);
  }
  
  public final void hLu()
  {
    AppMethodBeat.i(272247);
    Log.d("MicroMsg.TPPlayerReporter", "onNeedCompletion");
    AppMethodBeat.o(272247);
  }
  
  public final void hLv()
  {
    AppMethodBeat.i(272252);
    Log.d("MicroMsg.TPPlayerReporter", "onDuplicateFileFound");
    this.TGn.jmo = 5L;
    AppMethodBeat.o(272252);
  }
  
  public final void hLw()
  {
    AppMethodBeat.i(272259);
    Log.d("MicroMsg.TPPlayerReporter", "onMoovParseFailed");
    this.TGn.jmA = 2;
    AppMethodBeat.o(272259);
  }
  
  public final void hLx()
  {
    AppMethodBeat.i(272264);
    Log.d("MicroMsg.TPPlayerReporter", "onMoovParseSucceed");
    this.TGn.jmA = 0;
    AppMethodBeat.o(272264);
  }
  
  public final void hLy()
  {
    AppMethodBeat.i(272237);
    Log.d("MicroMsg.TPPlayerReporter", "onMoovLack");
    AppMethodBeat.o(272237);
  }
  
  public final void hLz()
  {
    AppMethodBeat.i(272278);
    Log.w("MicroMsg.TPPlayerReporter", "onRequestAllData");
    AppMethodBeat.o(272278);
  }
  
  public final void jy(long paramLong)
  {
    AppMethodBeat.i(272217);
    Log.d("MicroMsg.TPPlayerReporter", s.X("onDownloadStarted, timestamp=", Long.valueOf(paramLong)));
    this.TGn.iVU = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
    this.TGn.jms = (paramLong - this.sXR);
    AppMethodBeat.o(272217);
  }
  
  public final void ml(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272126);
    Log.d("MicroMsg.TPPlayerReporter", s.X("onSeek: ", Integer.valueOf(paramInt2)));
    this.TGp += 1;
    this.TGr = false;
    this.RhE = Util.nowMilliSecond();
    AppMethodBeat.o(272126);
  }
  
  public final void oc(int paramInt)
  {
    AppMethodBeat.i(272151);
    Log.d("MicroMsg.TPPlayerReporter", s.X("onError: ", Integer.valueOf(paramInt)));
    this.Aqc = paramInt;
    this.TGn.iZr = paramInt;
    if (this.teM > 0L)
    {
      this.TGb += Util.milliSecondsToNow(this.teM);
      this.teM = 0L;
    }
    report();
    AppMethodBeat.o(272151);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(272146);
    Log.d("MicroMsg.TPPlayerReporter", "onPause");
    if (this.teM > 0L)
    {
      this.TGb += Util.milliSecondsToNow(this.teM);
      this.teM = 0L;
    }
    AppMethodBeat.o(272146);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(272140);
    Log.d("MicroMsg.TPPlayerReporter", "onStart");
    this.teM = Util.nowMilliSecond();
    if (this.TGa == 0L) {
      this.TGa = this.teM;
    }
    AppMethodBeat.o(272140);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(272164);
    Log.d("MicroMsg.TPPlayerReporter", "onStop");
    if (this.teM > 0L)
    {
      this.TGb += Util.milliSecondsToNow(this.teM);
      this.teM = 0L;
    }
    if (this.TGn.jmo != 5L)
    {
      if (this.sXR <= 0L) {
        break label106;
      }
      if (!this.isOnline) {
        break label93;
      }
      this.TGn.jmo = 1L;
    }
    for (;;)
    {
      report();
      AppMethodBeat.o(272164);
      return;
      label93:
      this.TGn.jmo = 2L;
      continue;
      label106:
      this.TGn.jmo = 3L;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(d paramd, kotlin.d.d<? super b> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272091);
      paramObject = (kotlin.d.d)new b(this.TGu, paramd);
      AppMethodBeat.o(272091);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272083);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272083);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (com.tencent.mm.vfs.y.ZC(d.a(this.TGu)))
      {
        paramObject = com.tencent.mm.plugin.sight.base.f.aVX(d.a(this.TGu));
        d.b(this.TGu).irx = paramObject.audioBitrate;
        d.b(this.TGu).jmH = paramObject.audioChannel;
        d.b(this.TGu).jmF = paramObject.audioSampleRate;
        d.b(this.TGu).irw = paramObject.videoBitrate;
        d.b(this.TGu).irv = paramObject.videoDuration;
        d.b(this.TGu).irz = paramObject.width;
        d.b(this.TGu).irA = paramObject.height;
        d.b(this.TGu).jmD = paramObject.frameRate;
        if (!paramObject.PFe) {
          break label272;
        }
        d.b(this.TGu).jmC = 1L;
      }
      for (;;)
      {
        if (d.b(this.TGu).iYT <= 0L) {
          d.b(this.TGu).iYT = com.tencent.mm.vfs.y.bEl(d.a(this.TGu));
        }
        d.b(this.TGu).bMH();
        paramObject = ah.aiuX;
        AppMethodBeat.o(272083);
        return paramObject;
        label272:
        if (com.tencent.mm.modelvideo.y.isH265Video(d.a(this.TGu))) {
          d.b(this.TGu).jmC = 2L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.f.d
 * JD-Core Version:    0.7.0.1
 */