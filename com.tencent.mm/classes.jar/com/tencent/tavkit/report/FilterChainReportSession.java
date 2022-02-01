package com.tencent.tavkit.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FilterChainReportSession
{
  private static IReporter reporter;
  private Map<String, TimeConsumer> timeConsumerMap;
  
  public FilterChainReportSession()
  {
    AppMethodBeat.i(197643);
    this.timeConsumerMap = new HashMap();
    AppMethodBeat.o(197643);
  }
  
  public static void setReporter(IReporter paramIReporter)
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
  
  public void commit()
  {
    AppMethodBeat.i(197645);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.timeConsumerMap.values().iterator();
    while (localIterator.hasNext())
    {
      TimeConsumer localTimeConsumer = (TimeConsumer)localIterator.next();
      if (localTimeConsumer != null) {
        localHashMap.put(localTimeConsumer.key, Long.valueOf(TimeConsumer.access$200(localTimeConsumer)));
      }
    }
    try
    {
      if (reporter != null) {
        reporter.onCommit(localHashMap);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(197645);
    }
  }
  
  public void tick(String paramString, long paramLong)
  {
    AppMethodBeat.i(197644);
    TimeConsumer localTimeConsumer2 = (TimeConsumer)this.timeConsumerMap.get(paramString);
    TimeConsumer localTimeConsumer1 = localTimeConsumer2;
    if (localTimeConsumer2 == null)
    {
      localTimeConsumer1 = new TimeConsumer(paramString);
      this.timeConsumerMap.put(localTimeConsumer1.key, localTimeConsumer1);
    }
    TimeConsumer.access$100(localTimeConsumer1, paramLong / 1000L);
    AppMethodBeat.o(197644);
  }
  
  public static abstract interface IReporter
  {
    public abstract void onCommit(Map<String, Long> paramMap);
  }
  
  static class TimeConsumer
  {
    private long count = 0L;
    private final String key;
    private long totalUs = 0L;
    
    public TimeConsumer(String paramString)
    {
      this.key = paramString;
    }
    
    private long getAvgTimeUs()
    {
      if (this.count == 0L) {
        return 0L;
      }
      return this.totalUs / this.count;
    }
    
    private void tick(long paramLong)
    {
      this.totalUs += paramLong;
      this.count += 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.report.FilterChainReportSession
 * JD-Core Version:    0.7.0.1
 */