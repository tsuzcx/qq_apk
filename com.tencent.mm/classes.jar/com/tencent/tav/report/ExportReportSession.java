package com.tencent.tav.report;

import com.tencent.matrix.trace.core.AppMethodBeat;

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
  
  private void commit()
  {
    AppMethodBeat.i(202254);
    if ((this.beginTimeMs == 0L) || (this.exportStartTimeNs == 0L))
    {
      new StringBuilder("commit: 数据错误，beginTimeMs = ").append(this.beginTimeMs).append("， exportStartTimeNs = ").append(this.exportStartTimeNs);
      AppMethodBeat.o(202254);
      return;
    }
    if (this.successCount >= 10) {
      doCommit();
    }
    reset();
    AppMethodBeat.o(202254);
  }
  
  private void doCommit() {}
  
  public final void onExportError()
  {
    AppMethodBeat.i(202253);
    this.success = false;
    commit();
    AppMethodBeat.o(202253);
  }
  
  public final void onExportStart(long paramLong)
  {
    AppMethodBeat.i(202251);
    this.exportStartTimeNs = paramLong;
    this.beginTimeMs = System.currentTimeMillis();
    AppMethodBeat.o(202251);
  }
  
  public final void onExportSuccess()
  {
    AppMethodBeat.i(202252);
    if (this.exportStartTimeNs <= 0L)
    {
      new StringBuilder("onExportSuccess: 数据错误，exportStartTimeNs = ").append(this.exportStartTimeNs);
      AppMethodBeat.o(202252);
      return;
    }
    this.success = true;
    this.compositeTimeUs = ((System.nanoTime() - this.exportStartTimeNs) / 1000L);
    commit();
    AppMethodBeat.o(202252);
  }
  
  public final void reset()
  {
    this.compositeTimeUs = 0L;
    this.success = false;
    this.totalCostUs = 0L;
    this.successCount = 0;
    this.fileDurationUs = 0L;
    this.framePerSecond = 0L;
  }
  
  public final void setFileDurationUs(long paramLong)
  {
    this.fileDurationUs = paramLong;
  }
  
  public final void setFramePerSecond(int paramInt)
  {
    this.framePerSecond = paramInt;
  }
  
  public final void tickExport(long paramLong)
  {
    this.successCount += 1;
    this.totalCostUs += paramLong / 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.report.ExportReportSession
 * JD-Core Version:    0.7.0.1
 */