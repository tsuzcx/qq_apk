package com.tencent.tavkit.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class CompositingReportSession
{
  private static final int FLUSH_DURATION_THRESHOLD = 10;
  private static final String REPORT_EVENT = "android_tavkit_compositing";
  public static final String REPORT_KEY_AVG_RENDER_TIME_US = "avg_render_time_us";
  private static final String REPORT_SERVICE = "TAVKit_Android";
  private static final String REPORT_VERSION = "1.3.5.6";
  private static final String TAG = "CompositingReportSessio";
  private static CompositingReportSession.IReporter reporter;
  private long beginTimeMs;
  private int failureCount;
  private final FilterChainReporter filterChainReporter;
  private float renderHeight;
  private float renderWidth;
  private int successCount;
  private long totalCostUs;
  
  public CompositingReportSession(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200968);
    this.beginTimeMs = 0L;
    this.successCount = 0;
    this.failureCount = 0;
    this.totalCostUs = 0L;
    this.renderWidth = paramFloat1;
    this.renderHeight = paramFloat2;
    this.filterChainReporter = new FilterChainReporter(null);
    FilterChainReportSession.setReporter(this.filterChainReporter);
    AppMethodBeat.o(200968);
  }
  
  private void commit() {}
  
  private void reset()
  {
    this.beginTimeMs = 0L;
    this.totalCostUs = 0L;
    this.successCount = 0;
  }
  
  public static void setReporter(CompositingReportSession.IReporter paramIReporter)
  {
    try
    {
      reporter = paramIReporter;
      return;
    }
    finally
    {
      paramIReporter = finally;
      throw paramIReporter;
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(200969);
    if (this.beginTimeMs == 0L)
    {
      AppMethodBeat.o(200969);
      return;
    }
    if (this.successCount >= 10) {
      commit();
    }
    reset();
    AppMethodBeat.o(200969);
  }
  
  public final void tickFailed()
  {
    this.failureCount += 1;
  }
  
  public final void tickSuccess(long paramLong)
  {
    AppMethodBeat.i(200970);
    if (this.beginTimeMs == 0L) {
      this.beginTimeMs = (System.currentTimeMillis() - paramLong / 1000L / 1000L);
    }
    this.successCount += 1;
    this.totalCostUs += paramLong / 1000L;
    AppMethodBeat.o(200970);
  }
  
  static class FilterChainReporter
    implements FilterChainReportSession.IReporter
  {
    private Map<String, Long> values;
    
    private FilterChainReporter()
    {
      AppMethodBeat.i(200966);
      this.values = new HashMap();
      AppMethodBeat.o(200966);
    }
    
    public void onCommit(Map<String, Long> paramMap)
    {
      AppMethodBeat.i(200967);
      paramMap.putAll(paramMap);
      AppMethodBeat.o(200967);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.report.CompositingReportSession
 * JD-Core Version:    0.7.0.1
 */