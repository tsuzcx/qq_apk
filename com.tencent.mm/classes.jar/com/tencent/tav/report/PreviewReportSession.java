package com.tencent.tav.report;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PreviewReportSession
{
  private static final int FLUSH_DURATION_THRESHOLD = 10;
  private static final String TAG = "PreviewReportSession";
  private long beginTimeMs = 0L;
  private int frameCount = 0;
  private long totalReadCostUs = 0L;
  private long totalRenderCount = 0L;
  
  private void commit() {}
  
  private void reset()
  {
    this.beginTimeMs = 0L;
    this.totalReadCostUs = 0L;
    this.totalRenderCount = 0L;
    this.frameCount = 0;
  }
  
  public final void flush()
  {
    AppMethodBeat.i(193409);
    if (this.beginTimeMs == 0L)
    {
      AppMethodBeat.o(193409);
      return;
    }
    if (this.frameCount >= 10) {
      commit();
    }
    reset();
    AppMethodBeat.o(193409);
  }
  
  public final void tickPreview(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(193410);
    if (this.beginTimeMs == 0L) {
      this.beginTimeMs = (System.currentTimeMillis() - paramLong1 / 1000L / 1000L);
    }
    this.frameCount += 1;
    this.totalReadCostUs += paramLong1 / 1000L;
    this.totalRenderCount += paramLong2 / 1000L;
    AppMethodBeat.o(193410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.report.PreviewReportSession
 * JD-Core Version:    0.7.0.1
 */