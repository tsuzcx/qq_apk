package com.tencent.mm.plugin.thumbplayer.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/PlayerReporter;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/DownloadReporter;", "enterTime", "", "(J)V", "bufferingCount", "", "downloadStartTime", "exitTime", "firstStartTime", "lastBufferingTime", "lastStartTime", "moovReadyTime", "playErrorCode", "totalBufferingDuration", "totalPlayDuration", "bufferDuration", "buildMeasurement", "Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter$Measurement;", "errorCode", "getDownloadStartTime", "getMoovReadyTime", "onBufferingStarted", "", "onBufferingStopped", "onCompleted", "onDownloadError", "ret", "onDownloadStarted", "timestamp", "onDownloadSucceed", "onDuplicateFileFound", "onError", "onFirstVideoFrame", "onInfo", "what", "arg1", "arg2", "onMoovLack", "onMoovParseFailed", "onMoovParseSucceed", "onMoovReady", "offset", "length", "onNeedCompletion", "onPause", "onPrepared", "isOnline", "", "path", "", "onRequestAllData", "onRequestH264", "onSeek", "time", "", "onSeekCompleted", "onStart", "onStartDownload", "onStop", "onStopDownload", "pageDuration", "playDuration", "Companion", "Measurement", "plugin-thumbplayer_release"})
public final class b
  implements a, c
{
  public static final b.a MTB;
  private long ARP;
  private long MFX;
  private int MTA;
  private long MTw;
  private long MTx;
  private long MTy;
  private long MTz;
  private final long enterTime;
  private long pSS;
  private long pZO;
  private int wTz;
  
  static
  {
    AppMethodBeat.i(193175);
    MTB = new b.a((byte)0);
    AppMethodBeat.o(193175);
  }
  
  public b(long paramLong)
  {
    this.enterTime = paramLong;
  }
  
  private final long goM()
  {
    AppMethodBeat.i(193139);
    if (this.MTw <= 0L) {
      this.MTw = Util.nowMilliSecond();
    }
    long l = this.MTw;
    AppMethodBeat.o(193139);
    return l;
  }
  
  private final long goN()
  {
    AppMethodBeat.i(193144);
    if (this.MTz == 0L) {
      this.MTz += (int)Util.milliSecondsToNow(this.MTy);
    }
    long l = this.MTz;
    AppMethodBeat.o(193144);
    return l;
  }
  
  private final long goO()
  {
    AppMethodBeat.i(193151);
    if (this.MFX <= 0L) {
      this.MFX = Util.nowMilliSecond();
    }
    if ((this.MFX > 0L) && (this.enterTime >= 0L) && (this.MFX > this.enterTime))
    {
      long l1 = this.MFX;
      long l2 = this.enterTime;
      AppMethodBeat.o(193151);
      return l1 - l2;
    }
    AppMethodBeat.o(193151);
    return 0L;
  }
  
  private final long goQ()
  {
    AppMethodBeat.i(193170);
    if (this.ARP <= 0L)
    {
      l = Util.nowMilliSecond();
      AppMethodBeat.o(193170);
      return l;
    }
    long l = this.ARP;
    AppMethodBeat.o(193170);
    return l;
  }
  
  private final long goR()
  {
    if (this.pSS <= 0L) {
      return 0L;
    }
    return this.ARP;
  }
  
  public final void B(double paramDouble)
  {
    AppMethodBeat.i(193103);
    Log.i("MicroMsg.CdnPlayerReporter", "seek to ".concat(String.valueOf(paramDouble)));
    h.IzE.idkeyStat(354L, 4L, 1L, false);
    AppMethodBeat.o(193103);
  }
  
  public final void Hi(long paramLong) {}
  
  public final void N(boolean paramBoolean, String paramString) {}
  
  public final void aI(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(193164);
    this.ARP = Util.nowMilliSecond();
    AppMethodBeat.o(193164);
  }
  
  public final void aW(int paramInt, long paramLong) {}
  
  public final void ajr(int paramInt) {}
  
  public final void fJU()
  {
    AppMethodBeat.i(193156);
    this.pSS = Util.nowMilliSecond();
    AppMethodBeat.o(193156);
  }
  
  public final void fUB()
  {
    AppMethodBeat.i(193129);
    if (this.pZO > 0L)
    {
      this.MTx += Util.milliSecondsToNow(this.pZO);
      this.pZO = 0L;
    }
    AppMethodBeat.o(193129);
  }
  
  public final void goA() {}
  
  public final void goB() {}
  
  public final void goC() {}
  
  public final void goD() {}
  
  public final void goE() {}
  
  public final void goF() {}
  
  public final void goG() {}
  
  public final void goH() {}
  
  public final void goI() {}
  
  public final void goJ() {}
  
  public final void goK()
  {
    AppMethodBeat.i(193133);
    this.MTA += 1;
    this.MTy = Util.nowMilliSecond();
    AppMethodBeat.o(193133);
  }
  
  public final void goL()
  {
    AppMethodBeat.i(193136);
    if (this.MTy > 0L)
    {
      this.MTy = 0L;
      this.MTz = Util.milliSecondsToNow(this.MTy);
    }
    AppMethodBeat.o(193136);
  }
  
  public final b goP()
  {
    AppMethodBeat.i(193155);
    long l3 = this.MTx / 1000L;
    long l2 = goM() - goR();
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 0L;
    }
    l2 = goQ() - goR();
    if (l2 <= 0L) {
      l2 = 0L;
    }
    for (;;)
    {
      int j = this.MTA;
      if (j > 0) {}
      for (int i = (int)(goN() / j);; i = 0)
      {
        long l4 = goO();
        int k = this.wTz;
        b localb = new b((int)l3, (int)l1, (int)l2, j, i, (int)l4, k);
        AppMethodBeat.o(193155);
        return localb;
      }
    }
  }
  
  public final void goz() {}
  
  public final void kv(int paramInt)
  {
    AppMethodBeat.i(193125);
    this.wTz = paramInt;
    if (this.pZO > 0L)
    {
      this.MTx += Util.milliSecondsToNow(this.pZO);
      this.pZO = 0L;
    }
    AppMethodBeat.o(193125);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(193121);
    if (this.pZO > 0L)
    {
      this.MTx += Util.milliSecondsToNow(this.pZO);
      this.pZO = 0L;
    }
    AppMethodBeat.o(193121);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(193108);
    this.pZO = Util.nowMilliSecond();
    if (this.MTw == 0L) {
      this.MTw = this.pZO;
    }
    AppMethodBeat.o(193108);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(193131);
    if (this.pZO > 0L)
    {
      this.MTx += Util.milliSecondsToNow(this.pZO);
      this.pZO = 0L;
    }
    this.MFX = Util.nowMilliSecond();
    AppMethodBeat.o(193131);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter$Measurement;", "", "playDuration", "", "startWaitTime", "moovWaitTime", "bufferingCount", "avgBufferingDuration", "pageTime", "errorCode", "(IIIIIII)V", "getAvgBufferingDuration", "()I", "getBufferingCount", "getErrorCode", "getMoovWaitTime", "getPageTime", "getPlayDuration", "getStartWaitTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-thumbplayer_release"})
  public static final class b
  {
    public final int EFk;
    public final int MTA;
    public final int MTC;
    public final int MTD;
    public final int MTE;
    public final int MTF;
    public final int errorCode;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    {
      this.EFk = paramInt1;
      this.MTC = paramInt2;
      this.MTD = paramInt3;
      this.MTA = paramInt4;
      this.MTE = paramInt5;
      this.MTF = paramInt6;
      this.errorCode = paramInt7;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.EFk != paramObject.EFk) || (this.MTC != paramObject.MTC) || (this.MTD != paramObject.MTD) || (this.MTA != paramObject.MTA) || (this.MTE != paramObject.MTE) || (this.MTF != paramObject.MTF) || (this.errorCode != paramObject.errorCode)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return (((((this.EFk * 31 + this.MTC) * 31 + this.MTD) * 31 + this.MTA) * 31 + this.MTE) * 31 + this.MTF) * 31 + this.errorCode;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189940);
      String str = "Measurement(playDuration=" + this.EFk + ", startWaitTime=" + this.MTC + ", moovWaitTime=" + this.MTD + ", bufferingCount=" + this.MTA + ", avgBufferingDuration=" + this.MTE + ", pageTime=" + this.MTF + ", errorCode=" + this.errorCode + ")";
      AppMethodBeat.o(189940);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.g.b
 * JD-Core Version:    0.7.0.1
 */