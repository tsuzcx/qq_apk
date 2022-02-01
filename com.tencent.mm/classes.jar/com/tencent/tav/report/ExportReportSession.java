package com.tencent.tav.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;

public final class ExportReportSession
{
  private static final int FLUSH_DURATION_THRESHOLD = 10;
  private static final String TAG = "ExportReportSession";
  private long beginTimeMs = 0L;
  private long compositeTimeUs = 0L;
  private long exportStartTimeNs = 0L;
  private long fileDurationUs = 0L;
  private long framePerSecond = 0L;
  private boolean success = false;
  private int successCount = 0;
  private long totalCostUs = 0L;
  private long totalDecodeUs = 0L;
  private long totalEncodeUs = 0L;
  private long totalRealDecodeUs = 0L;
  private long totalRenderUs = 0L;
  
  private void commit()
  {
    AppMethodBeat.i(214942);
    if ((this.beginTimeMs == 0L) || (this.exportStartTimeNs == 0L))
    {
      Logger.e("ExportReportSession", "commit: 数据错误，beginTimeMs = " + this.beginTimeMs + "， exportStartTimeNs = " + this.exportStartTimeNs);
      AppMethodBeat.o(214942);
      return;
    }
    if (this.successCount >= 10) {
      doCommit();
    }
    AppMethodBeat.o(214942);
  }
  
  private void doCommit()
  {
    AppMethodBeat.i(214957);
    double d1 = this.totalCostUs / this.successCount;
    double d2 = this.totalDecodeUs / this.successCount;
    Logger.i("ExportReportSession", "report export performance, compositeTimeUs:" + this.compositeTimeUs + ", totalCostUs:" + this.totalCostUs + ", totalDecodeUs:" + this.totalDecodeUs + ", successCount:" + this.successCount + ", avg_decode_time:" + d2 + ", avg_render_time:" + d1);
    AppMethodBeat.o(214957);
  }
  
  public final long getAverageDecodeUs()
  {
    AppMethodBeat.i(215048);
    if (this.successCount != 0)
    {
      long l = getTotalDecodeUs() / this.successCount;
      AppMethodBeat.o(215048);
      return l;
    }
    AppMethodBeat.o(215048);
    return 0L;
  }
  
  public final long getAverageEncodeUs()
  {
    if (this.successCount != 0) {
      return this.totalEncodeUs / this.successCount;
    }
    return 0L;
  }
  
  public final long getAverageRenderUs()
  {
    if (this.successCount != 0) {
      return this.totalRenderUs / this.successCount;
    }
    return 0L;
  }
  
  public final long getCompositeTimeUs()
  {
    return this.compositeTimeUs;
  }
  
  public final int getSuccessCount()
  {
    return this.successCount;
  }
  
  public final long getTotalCostUs()
  {
    return this.totalCostUs;
  }
  
  public final long getTotalDecodeUs()
  {
    return this.totalRealDecodeUs;
  }
  
  public final long getTotalEncodeUs()
  {
    return this.totalEncodeUs;
  }
  
  public final long getTotalRenderUs()
  {
    return this.totalRenderUs;
  }
  
  public final void onExportError()
  {
    AppMethodBeat.i(215092);
    this.success = false;
    commit();
    AppMethodBeat.o(215092);
  }
  
  public final void onExportStart(long paramLong)
  {
    AppMethodBeat.i(215073);
    this.exportStartTimeNs = paramLong;
    this.beginTimeMs = System.currentTimeMillis();
    AppMethodBeat.o(215073);
  }
  
  public final void onExportSuccess()
  {
    AppMethodBeat.i(215083);
    if (this.exportStartTimeNs <= 0L)
    {
      Logger.e("ExportReportSession", "onExportSuccess: 数据错误，exportStartTimeNs = " + this.exportStartTimeNs);
      AppMethodBeat.o(215083);
      return;
    }
    this.success = true;
    this.compositeTimeUs = ((System.nanoTime() - this.exportStartTimeNs) / 1000L);
    commit();
    AppMethodBeat.o(215083);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(215113);
    Logger.d("ExportReportSession", "reset() called");
    this.compositeTimeUs = 0L;
    this.success = false;
    this.totalCostUs = 0L;
    this.successCount = 0;
    this.fileDurationUs = 0L;
    this.framePerSecond = 0L;
    AppMethodBeat.o(215113);
  }
  
  public final void setFileDurationUs(long paramLong)
  {
    this.fileDurationUs = paramLong;
  }
  
  public final void setFramePerSecond(int paramInt)
  {
    this.framePerSecond = paramInt;
  }
  
  public final void setTotalEncodeUs(long paramLong)
  {
    this.totalEncodeUs = paramLong;
  }
  
  public final void setTotalRealDecodeUs(long paramLong)
  {
    this.totalRealDecodeUs = paramLong;
  }
  
  public final void setTotalRenderUs(long paramLong)
  {
    this.totalRenderUs = paramLong;
  }
  
  public final void tickDecode(long paramLong)
  {
    this.totalDecodeUs += paramLong / 1000L;
  }
  
  public final void tickExport(long paramLong)
  {
    this.successCount += 1;
    this.totalCostUs += paramLong / 1000L;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(215123);
    String str = "ExportReportSession{success=" + this.success + ", successCount=" + this.successCount + ", compositeTimeUs=" + this.compositeTimeUs + ", totalCostUs=" + getTotalCostUs() + ", totalDecodeUs=" + getTotalDecodeUs() + ", totalEncodeUs=" + getTotalEncodeUs() + ", totalRenderUs=" + getTotalRenderUs() + ", averageDecodeUs=" + getAverageDecodeUs() + ", averageEncodeUs=" + getAverageEncodeUs() + ", averageRenderUs=" + getAverageRenderUs() + '}';
    AppMethodBeat.o(215123);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.report.ExportReportSession
 * JD-Core Version:    0.7.0.1
 */