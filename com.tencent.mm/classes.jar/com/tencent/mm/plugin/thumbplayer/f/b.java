package com.tencent.mm.plugin.thumbplayer.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/PlayerReporter;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/DownloadReporter;", "enterTime", "", "(J)V", "bufferingCount", "", "downloadStartTime", "exitTime", "firstFrameTime", "firstStartTime", "isCompleted", "", "lastBufferingTime", "lastStartTime", "maxProgressMilliseconds", "moovReadyTime", "playErrorCode", "seekFlags", "totalBufferingDuration", "totalPlayDuration", "bufferDuration", "buildMeasurement", "Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter$Measurement;", "errorCode", "getDownloadStartTime", "getMoovReadyTime", "onBufferingStarted", "", "onBufferingStopped", "onCompleted", "onDownloadError", "ret", "onDownloadStarted", "timestamp", "onDownloadSucceed", "onDuplicateFileFound", "onError", "onFirstVideoFrame", "onInfo", "what", "arg1", "arg2", "onMoovLack", "onMoovParseFailed", "onMoovParseSucceed", "onMoovReady", "offset", "length", "onNeedCompletion", "onPause", "onPrepared", "isOnline", "path", "", "onProgress", "time", "onRequestAllData", "onRequestH264", "onSeek", "current", "onSeekCompleted", "onStart", "onStartDownload", "onStop", "onStopDownload", "pageDuration", "playDuration", "Companion", "Measurement", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a, c
{
  public static final b.a TFZ;
  private int Aqc;
  private long Fqp;
  private long GdW;
  private int Gpp;
  private long GtN;
  private long TGa;
  private long TGb;
  private long TGc;
  private long TGd;
  private int TGe;
  private int TGf;
  private boolean cVt;
  private final long enterTime;
  private long sXR;
  private long teM;
  
  static
  {
    AppMethodBeat.i(272103);
    TFZ = new b.a((byte)0);
    AppMethodBeat.o(272103);
  }
  
  public b(long paramLong)
  {
    this.enterTime = paramLong;
  }
  
  private final long hLF()
  {
    AppMethodBeat.i(272074);
    if (this.TGa <= 0L) {
      this.TGa = Util.nowMilliSecond();
    }
    long l = this.TGa;
    AppMethodBeat.o(272074);
    return l;
  }
  
  private final long hLG()
  {
    AppMethodBeat.i(272079);
    if ((this.TGd == 0L) && (this.TGc > 0L)) {
      this.TGd += (int)Util.milliSecondsToNow(this.TGc);
    }
    long l = this.TGd;
    AppMethodBeat.o(272079);
    return l;
  }
  
  private final long hLH()
  {
    AppMethodBeat.i(272086);
    if (this.GdW <= 0L) {
      this.GdW = Util.nowMilliSecond();
    }
    if ((this.GdW > 0L) && (this.enterTime >= 0L) && (this.GdW > this.enterTime))
    {
      long l1 = this.GdW;
      long l2 = this.enterTime;
      AppMethodBeat.o(272086);
      return l1 - l2;
    }
    AppMethodBeat.o(272086);
    return 0L;
  }
  
  private final long hLJ()
  {
    AppMethodBeat.i(272094);
    if (this.GtN <= 0L)
    {
      l = Util.nowMilliSecond();
      AppMethodBeat.o(272094);
      return l;
    }
    long l = this.GtN;
    AppMethodBeat.o(272094);
    return l;
  }
  
  private final long hLK()
  {
    if (this.sXR <= 0L) {
      return 0L;
    }
    return this.GtN;
  }
  
  public final void aD(boolean paramBoolean, String paramString) {}
  
  public final void aga(int paramInt)
  {
    AppMethodBeat.i(272190);
    this.TGf = Math.max(this.TGf, paramInt);
    AppMethodBeat.o(272190);
  }
  
  public final void aoF(int paramInt) {}
  
  public final void be(int paramInt, long paramLong) {}
  
  public final void bq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272260);
    this.GtN = Util.nowMilliSecond();
    AppMethodBeat.o(272260);
  }
  
  public final void fvq()
  {
    AppMethodBeat.i(272159);
    if (this.teM > 0L)
    {
      this.TGb += Util.milliSecondsToNow(this.teM);
      this.teM = 0L;
    }
    this.cVt = true;
    AppMethodBeat.o(272159);
  }
  
  public final void gZM()
  {
    AppMethodBeat.i(272204);
    this.sXR = Util.nowMilliSecond();
    AppMethodBeat.o(272204);
  }
  
  public final void hLA() {}
  
  public final void hLB()
  {
    AppMethodBeat.i(272136);
    this.Fqp = Util.nowMilliSecond();
    AppMethodBeat.o(272136);
  }
  
  public final void hLC() {}
  
  public final void hLD()
  {
    AppMethodBeat.i(272174);
    this.Gpp += 1;
    this.TGc = Util.nowMilliSecond();
    AppMethodBeat.o(272174);
  }
  
  public final void hLE()
  {
    AppMethodBeat.i(272184);
    if (this.TGc > 0L)
    {
      this.TGc = 0L;
      this.TGd = Util.milliSecondsToNow(this.TGc);
    }
    AppMethodBeat.o(272184);
  }
  
  public final b hLI()
  {
    AppMethodBeat.i(272197);
    long l4 = this.TGb / 1000L;
    long l1 = hLF() - hLK();
    if (l1 <= 0L) {
      l1 = 0L;
    }
    for (;;)
    {
      long l2 = hLJ() - hLK();
      if (l2 <= 0L) {
        l2 = 0L;
      }
      for (;;)
      {
        int j = this.Gpp;
        int i;
        long l5;
        int k;
        if (j > 0)
        {
          i = (int)(hLG() / j);
          l5 = hLH();
          k = this.Aqc;
          if (this.sXR <= 0L) {
            break label157;
          }
        }
        label157:
        for (long l3 = this.sXR;; l3 = this.TGa)
        {
          b localb = new b((int)l4, (int)l1, (int)l2, j, i, (int)l5, k, this.Fqp - l3, this.TGe, this.TGf, this.cVt);
          AppMethodBeat.o(272197);
          return localb;
          i = 0;
          break;
        }
      }
    }
  }
  
  public final void hLs() {}
  
  public final void hLt() {}
  
  public final void hLu() {}
  
  public final void hLv() {}
  
  public final void hLw() {}
  
  public final void hLx() {}
  
  public final void hLy() {}
  
  public final void hLz() {}
  
  public final void jy(long paramLong) {}
  
  public final void ml(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272114);
    Log.i("MicroMsg.CdnPlayerReporter", s.X("seek to ", Integer.valueOf(paramInt2)));
    if (paramInt2 != 0)
    {
      if (paramInt2 >= paramInt1) {
        break label58;
      }
      this.TGe |= 0x2;
    }
    for (;;)
    {
      h.OAn.idkeyStat(354L, 4L, 1L, false);
      AppMethodBeat.o(272114);
      return;
      label58:
      if (paramInt2 > paramInt1) {
        this.TGe |= 0x1;
      }
    }
  }
  
  public final void oc(int paramInt)
  {
    AppMethodBeat.i(272155);
    this.Aqc = paramInt;
    if (this.teM > 0L)
    {
      this.TGb += Util.milliSecondsToNow(this.teM);
      this.teM = 0L;
    }
    AppMethodBeat.o(272155);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(272149);
    if (this.teM > 0L)
    {
      this.TGb += Util.milliSecondsToNow(this.teM);
      this.teM = 0L;
    }
    AppMethodBeat.o(272149);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(272122);
    this.teM = Util.nowMilliSecond();
    if (this.TGa == 0L) {
      this.TGa = this.teM;
    }
    AppMethodBeat.o(272122);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(272167);
    if (this.teM > 0L)
    {
      this.TGb += Util.milliSecondsToNow(this.teM);
      this.teM = 0L;
    }
    this.GdW = Util.nowMilliSecond();
    AppMethodBeat.o(272167);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter$Measurement;", "", "playDuration", "", "startWaitTime", "moovWaitTime", "bufferingCount", "avgBufferingDuration", "pageTime", "errorCode", "timeBeforeFirstFrame", "", "seekFlags", "maxProgressMilliseconds", "completed", "", "(IIIIIIIJIIZ)V", "getAvgBufferingDuration", "()I", "getBufferingCount", "getCompleted", "()Z", "getErrorCode", "getMaxProgressMilliseconds", "getMoovWaitTime", "getPageTime", "getPlayDuration", "getSeekFlags", "getStartWaitTime", "getTimeBeforeFirstFrame", "()J", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public final int Gpp;
    public final int Kyp;
    public final int TGe;
    public final int TGf;
    public final int TGg;
    public final int TGh;
    public final int TGi;
    public final int TGj;
    public final long TGk;
    public final boolean TGl;
    public final int errorCode;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, int paramInt8, int paramInt9, boolean paramBoolean)
    {
      this.Kyp = paramInt1;
      this.TGg = paramInt2;
      this.TGh = paramInt3;
      this.Gpp = paramInt4;
      this.TGi = paramInt5;
      this.TGj = paramInt6;
      this.errorCode = paramInt7;
      this.TGk = paramLong;
      this.TGe = paramInt8;
      this.TGf = paramInt9;
      this.TGl = paramBoolean;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return false;
        }
        paramObject = (b)paramObject;
        if (this.Kyp != paramObject.Kyp) {
          return false;
        }
        if (this.TGg != paramObject.TGg) {
          return false;
        }
        if (this.TGh != paramObject.TGh) {
          return false;
        }
        if (this.Gpp != paramObject.Gpp) {
          return false;
        }
        if (this.TGi != paramObject.TGi) {
          return false;
        }
        if (this.TGj != paramObject.TGj) {
          return false;
        }
        if (this.errorCode != paramObject.errorCode) {
          return false;
        }
        if (this.TGk != paramObject.TGk) {
          return false;
        }
        if (this.TGe != paramObject.TGe) {
          return false;
        }
        if (this.TGf != paramObject.TGf) {
          return false;
        }
      } while (this.TGl == paramObject.TGl);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(272078);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Measurement(playDuration=").append(this.Kyp).append(", startWaitTime=").append(this.TGg).append(", moovWaitTime=").append(this.TGh).append(", bufferingCount=").append(this.Gpp).append(", avgBufferingDuration=").append(this.TGi).append(", pageTime=").append(this.TGj).append(", errorCode=").append(this.errorCode).append(", timeBeforeFirstFrame=").append(this.TGk).append(", seekFlags=").append(this.TGe).append(", maxProgressMilliseconds=").append(this.TGf).append(", completed=").append(this.TGl).append(')');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(272078);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.f.b
 * JD-Core Version:    0.7.0.1
 */