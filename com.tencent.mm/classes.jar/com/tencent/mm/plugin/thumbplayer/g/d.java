package com.tencent.mm.plugin.thumbplayer.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.mj;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/reporter/TPPlayerReporter;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/PlayerReporter;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/DownloadReporter;", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/TPVideoPlayReportStruct;", "enterTime", "", "scene", "", "(Lcom/tencent/mm/autogen/mmdata/rpt/TPVideoPlayReportStruct;JI)V", "audioDecoderType", "bufferingCount", "downloadStartTime", "firstStartTime", "isOnline", "", "isSeekBuffering", "lastBufferingTime", "lastSeekTime", "lastStartTime", "playErrorCode", "prepareTime", "seekCount", "totalBufferingCost", "totalPlayDuration", "totalSeekCost", "videoDecoderType", "videoPath", "", "onBufferingStarted", "", "onBufferingStopped", "onCompleted", "onDownloadError", "ret", "onDownloadStarted", "timestamp", "onDownloadSucceed", "onDuplicateFileFound", "onError", "errorCode", "onFirstVideoFrame", "onInfo", "what", "arg1", "arg2", "onMoovLack", "onMoovParseFailed", "onMoovParseSucceed", "onMoovReady", "offset", "length", "onNeedCompletion", "onPause", "onPrepared", "path", "onRequestAllData", "onRequestH264", "onSeek", "time", "", "onSeekCompleted", "onStart", "onStartDownload", "onStop", "onStopDownload", "report", "safeCost", "cost", "Companion", "plugin-thumbplayer_release"})
public final class d
  implements a, c
{
  public static final d.a MTN;
  private long KIe;
  private int MTA;
  private long MTG;
  private int MTH;
  private long MTI;
  private boolean MTJ;
  private int MTK;
  private int MTL;
  private final mj MTM;
  private long MTw;
  private long MTx;
  private long MTy;
  private final long enterTime;
  private boolean isOnline;
  private long pOl;
  private long pSS;
  private long pZO;
  private final int scene;
  private String videoPath;
  private int wTz;
  
  static
  {
    AppMethodBeat.i(192886);
    MTN = new d.a((byte)0);
    AppMethodBeat.o(192886);
  }
  
  public d(mj parammj, long paramLong, int paramInt)
  {
    AppMethodBeat.i(192884);
    this.MTM = parammj;
    this.enterTime = paramLong;
    this.scene = paramInt;
    AppMethodBeat.o(192884);
  }
  
  private final void report()
  {
    AppMethodBeat.i(192882);
    Log.i("MicroMsg.TPPlayerReporter", "report: enter=" + this.enterTime);
    this.MTM.xi(Util.milliSecondsToNow(this.enterTime));
    if (this.MTA > 0)
    {
      this.MTM.xr(this.MTG / this.MTA);
      this.MTM.xq(this.MTA);
    }
    this.MTM.xn(this.MTx);
    if (this.MTH > 0)
    {
      this.MTM.xN(this.MTH);
      this.MTM.xO(this.MTI / this.MTH);
    }
    this.MTM.xo(Math.max(this.MTw - this.pOl, 0L));
    this.MTM.xj(this.scene);
    this.MTM.xI(this.MTL);
    this.MTM.xK(this.MTK);
    g.b((ak)br.abxo, (kotlin.d.f)bc.iRq(), (m)new b(this, null), 2);
    AppMethodBeat.o(192882);
  }
  
  public final void B(double paramDouble)
  {
    AppMethodBeat.i(192792);
    Log.d("MicroMsg.TPPlayerReporter", "onSeek: ".concat(String.valueOf(paramDouble)));
    this.MTH += 1;
    this.MTJ = false;
    this.KIe = Util.nowMilliSecond();
    AppMethodBeat.o(192792);
  }
  
  public final void Hi(long paramLong)
  {
    AppMethodBeat.i(192850);
    Log.d("MicroMsg.TPPlayerReporter", "onDownloadStarted, timestamp=".concat(String.valueOf(paramLong)));
    this.MTM.xs(NetStatusUtil.getIOSNetType(MMApplicationContext.getContext()));
    this.MTM.xt(paramLong - this.pSS);
    AppMethodBeat.o(192850);
  }
  
  public final void N(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(192785);
    Log.d("MicroMsg.TPPlayerReporter", "onPrepare: isOnline=" + paramBoolean + ", path=" + paramString);
    this.videoPath = paramString;
    this.isOnline = paramBoolean;
    this.pOl = Util.nowMilliSecond();
    AppMethodBeat.o(192785);
  }
  
  public final void aI(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192856);
    Log.d("MicroMsg.TPPlayerReporter", "onMoovReady, offset=" + paramLong1 + ", length=" + paramLong2);
    this.MTM.xz(Math.max(Util.nowMilliSecond() - this.pSS, 0L));
    this.MTM.xA(paramLong1);
    this.MTM.xB(paramLong2);
    this.MTM.anO();
    AppMethodBeat.o(192856);
  }
  
  public final void aW(int paramInt, long paramLong)
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
        this.MTK = paramInt;
        return;
      }
    }
    paramInt = i;
    switch ((int)paramLong)
    {
    }
    for (paramInt = 0;; paramInt = 1)
    {
      this.MTL = paramInt;
      return;
    }
  }
  
  public final void ajr(int paramInt)
  {
    AppMethodBeat.i(192867);
    Log.d("MicroMsg.TPPlayerReporter", "onDownloadError: ".concat(String.valueOf(paramInt)));
    this.MTM.xv(paramInt);
    this.MTM.xu(Util.milliSecondsToNow(this.pSS));
    AppMethodBeat.o(192867);
  }
  
  public final void fJU()
  {
    AppMethodBeat.i(192843);
    Log.d("MicroMsg.TPPlayerReporter", "onStartDownload");
    this.pSS = Util.nowMilliSecond();
    AppMethodBeat.o(192843);
  }
  
  public final void fUB()
  {
    AppMethodBeat.i(192815);
    Log.d("MicroMsg.TPPlayerReporter", "onCompleted");
    if (this.pZO > 0L)
    {
      this.MTx += Util.milliSecondsToNow(this.pZO);
      this.pZO = 0L;
    }
    report();
    AppMethodBeat.o(192815);
  }
  
  public final void goA()
  {
    AppMethodBeat.i(192861);
    Log.d("MicroMsg.TPPlayerReporter", "onDownloadSucceed");
    this.MTM.xv(0L);
    this.MTM.xu(Util.milliSecondsToNow(this.pSS));
    AppMethodBeat.o(192861);
  }
  
  public final void goB()
  {
    AppMethodBeat.i(192869);
    Log.d("MicroMsg.TPPlayerReporter", "onNeedCompletion");
    AppMethodBeat.o(192869);
  }
  
  public final void goC()
  {
    AppMethodBeat.i(192870);
    Log.d("MicroMsg.TPPlayerReporter", "onDuplicateFileFound");
    this.MTM.xm(5L);
    AppMethodBeat.o(192870);
  }
  
  public final void goD()
  {
    AppMethodBeat.i(192872);
    Log.d("MicroMsg.TPPlayerReporter", "onMoovParseFailed");
    this.MTM.nO(2);
    AppMethodBeat.o(192872);
  }
  
  public final void goE()
  {
    AppMethodBeat.i(192876);
    Log.d("MicroMsg.TPPlayerReporter", "onMoovParseSucceed");
    this.MTM.nO(0);
    AppMethodBeat.o(192876);
  }
  
  public final void goF()
  {
    AppMethodBeat.i(192863);
    Log.d("MicroMsg.TPPlayerReporter", "onMoovLack");
    AppMethodBeat.o(192863);
  }
  
  public final void goG()
  {
    AppMethodBeat.i(192879);
    Log.w("MicroMsg.TPPlayerReporter", "onRequestAllData");
    AppMethodBeat.o(192879);
  }
  
  public final void goH()
  {
    AppMethodBeat.i(192878);
    Log.d("MicroMsg.TPPlayerReporter", "onRequestH264");
    AppMethodBeat.o(192878);
  }
  
  public final void goI()
  {
    AppMethodBeat.i(192789);
    if ((this.MTM.anN() <= 0L) && (this.pOl > 0L))
    {
      Log.d("MicroMsg.TPPlayerReporter", "onFirstVideoFrame");
      this.MTM.xp(Util.milliSecondsToNow(this.pOl));
    }
    AppMethodBeat.o(192789);
  }
  
  public final void goJ()
  {
    AppMethodBeat.i(192796);
    Log.d("MicroMsg.TPPlayerReporter", "onSeekCompleted");
    if (this.KIe >= 0L) {
      this.MTI += Util.milliSecondsToNow(this.KIe);
    }
    AppMethodBeat.o(192796);
  }
  
  public final void goK()
  {
    AppMethodBeat.i(192833);
    Log.d("MicroMsg.TPPlayerReporter", "onBufferingStarted");
    this.MTy = Util.nowMilliSecond();
    if (this.MTy - this.KIe < 300L) {}
    for (boolean bool = true;; bool = false)
    {
      this.MTJ = bool;
      if (!this.MTJ) {
        this.MTA += 1;
      }
      AppMethodBeat.o(192833);
      return;
    }
  }
  
  public final void goL()
  {
    AppMethodBeat.i(192835);
    Log.d("MicroMsg.TPPlayerReporter", "onBufferingStopped");
    if (this.MTy > 0L)
    {
      if (!this.MTJ) {
        this.MTG += Util.milliSecondsToNow(this.MTy);
      }
      this.MTy = 0L;
    }
    this.MTJ = false;
    AppMethodBeat.o(192835);
  }
  
  public final void goz()
  {
    AppMethodBeat.i(192846);
    Log.d("MicroMsg.TPPlayerReporter", "onStopDownload");
    AppMethodBeat.o(192846);
  }
  
  public final void kv(int paramInt)
  {
    AppMethodBeat.i(192809);
    Log.d("MicroMsg.TPPlayerReporter", "onError: ".concat(String.valueOf(paramInt)));
    this.wTz = paramInt;
    this.MTM.nN(paramInt);
    if (this.pZO > 0L)
    {
      this.MTx += Util.milliSecondsToNow(this.pZO);
      this.pZO = 0L;
    }
    report();
    AppMethodBeat.o(192809);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(192803);
    Log.d("MicroMsg.TPPlayerReporter", "onPause");
    if (this.pZO > 0L)
    {
      this.MTx += Util.milliSecondsToNow(this.pZO);
      this.pZO = 0L;
    }
    AppMethodBeat.o(192803);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(192799);
    Log.d("MicroMsg.TPPlayerReporter", "onStart");
    this.pZO = Util.nowMilliSecond();
    if (this.MTw == 0L) {
      this.MTw = this.pZO;
    }
    AppMethodBeat.o(192799);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(192822);
    Log.d("MicroMsg.TPPlayerReporter", "onStop");
    if (this.pZO > 0L)
    {
      this.MTx += Util.milliSecondsToNow(this.pZO);
      this.pZO = 0L;
    }
    if (this.MTM.anM() != 5L)
    {
      if (this.pSS <= 0L) {
        break label108;
      }
      if (!this.isOnline) {
        break label94;
      }
      this.MTM.xm(1L);
    }
    for (;;)
    {
      report();
      AppMethodBeat.o(192822);
      return;
      label94:
      this.MTM.xm(2L);
      continue;
      label108:
      this.MTM.xm(3L);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    b(d paramd, kotlin.d.d paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(191776);
      p.k(paramd, "completion");
      paramd = new b(this.MTO, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(191776);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(191777);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(191777);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(191774);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(191774);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (u.agG(d.a(this.MTO)))
      {
        paramObject = com.tencent.mm.plugin.sight.base.f.aYg(d.a(this.MTO));
        d.b(this.MTO).xL(paramObject.audioBitrate);
        d.b(this.MTO).xM(paramObject.audioChannel);
        d.b(this.MTO).xJ(paramObject.audioSampleRate);
        d.b(this.MTO).xC(paramObject.videoBitrate);
        d.b(this.MTO).xG(paramObject.videoDuration);
        d.b(this.MTO).xE(paramObject.width);
        d.b(this.MTO).xF(paramObject.height);
        d.b(this.MTO).xH(paramObject.frameRate);
        if (!paramObject.JrE) {
          break label282;
        }
        d.b(this.MTO).xD(1L);
      }
      for (;;)
      {
        if (d.b(this.MTO).anL() <= 0L) {
          d.b(this.MTO).xk(u.bBQ(d.a(this.MTO)));
        }
        d.b(this.MTO).bpa();
        paramObject = x.aazN;
        AppMethodBeat.o(191774);
        return paramObject;
        label282:
        if (v.isH265Video(d.a(this.MTO))) {
          d.b(this.MTO).xD(2L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.g.d
 * JD-Core Version:    0.7.0.1
 */