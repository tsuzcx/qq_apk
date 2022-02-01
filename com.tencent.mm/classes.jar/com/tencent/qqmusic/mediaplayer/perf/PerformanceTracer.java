package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PerformanceTracer
{
  private IDataSource dataSource;
  private long lastTimeStampNanoSecond;
  private long playStartTimestampNanoSec;
  private final Map<String, SpeedCheck> speedMap;
  private long totalPcmInByte;
  private long totalTimeCostInNanoSec;
  
  public PerformanceTracer()
  {
    AppMethodBeat.i(114186);
    this.speedMap = new LinkedHashMap();
    this.lastTimeStampNanoSecond = 0L;
    this.playStartTimestampNanoSec = 0L;
    this.totalTimeCostInNanoSec = 0L;
    AppMethodBeat.o(114186);
  }
  
  private SpeedCheck getSpeedCheck(String paramString)
  {
    AppMethodBeat.i(114193);
    SpeedCheck localSpeedCheck = (SpeedCheck)this.speedMap.get(paramString);
    if (localSpeedCheck != null)
    {
      AppMethodBeat.o(114193);
      return localSpeedCheck;
    }
    localSpeedCheck = new SpeedCheck(paramString, null);
    this.speedMap.put(paramString, localSpeedCheck);
    AppMethodBeat.o(114193);
    return localSpeedCheck;
  }
  
  public void accept(Visitor paramVisitor)
  {
    AppMethodBeat.i(114192);
    ArrayList localArrayList = new ArrayList(this.speedMap.values());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      SpeedCheck.access$100((SpeedCheck)localIterator.next());
    }
    paramVisitor.visitSpeedCheck(localArrayList, new OverallInfo(this.dataSource, Math.round(this.totalTimeCostInNanoSec / 1000000.0D), this.totalPcmInByte));
    AppMethodBeat.o(114192);
  }
  
  public void end(String paramString, int paramInt)
  {
    AppMethodBeat.i(114191);
    long l1 = System.nanoTime();
    long l2 = this.lastTimeStampNanoSecond;
    SpeedCheck.access$000(getSpeedCheck(paramString), paramInt, l1 - l2);
    AppMethodBeat.o(114191);
  }
  
  public void init(IDataSource paramIDataSource)
  {
    AppMethodBeat.i(114187);
    this.dataSource = paramIDataSource;
    this.lastTimeStampNanoSecond = 0L;
    paramIDataSource = this.speedMap.values().iterator();
    while (paramIDataSource.hasNext()) {
      ((SpeedCheck)paramIDataSource.next()).reset();
    }
    AppMethodBeat.o(114187);
  }
  
  public void playEnd() {}
  
  public void playStart()
  {
    this.totalPcmInByte = 0L;
  }
  
  public void roundEnd(int paramInt)
  {
    AppMethodBeat.i(114189);
    this.totalPcmInByte += paramInt;
    this.totalTimeCostInNanoSec += System.nanoTime() - this.playStartTimestampNanoSec;
    AppMethodBeat.o(114189);
  }
  
  public void roundStart()
  {
    AppMethodBeat.i(114188);
    this.playStartTimestampNanoSec = System.nanoTime();
    AppMethodBeat.o(114188);
  }
  
  public void start(String paramString)
  {
    AppMethodBeat.i(114190);
    getSpeedCheck(paramString);
    this.lastTimeStampNanoSecond = System.nanoTime();
    AppMethodBeat.o(114190);
  }
  
  static class OverallInfo
  {
    final IDataSource dataSource;
    final long timeCostInMs;
    final long totalPcmToBePlayed;
    
    OverallInfo(IDataSource paramIDataSource, long paramLong1, long paramLong2)
    {
      this.dataSource = paramIDataSource;
      this.timeCostInMs = paramLong1;
      this.totalPcmToBePlayed = paramLong2;
    }
  }
  
  static class SpeedCheck
  {
    private static final double f = 1000000.0D;
    private double avg;
    private double max;
    private double min;
    private final String name;
    private long totalBufferLength;
    private long totalTimeNanoSecond;
    
    private SpeedCheck(String paramString)
    {
      this.name = paramString;
    }
    
    private void compute()
    {
      this.avg = (this.totalBufferLength * 1000000.0D / this.totalTimeNanoSecond);
    }
    
    private void update(int paramInt, long paramLong)
    {
      this.totalBufferLength += paramInt;
      this.totalTimeNanoSecond += paramLong;
      double d = paramInt * 1000000.0D / paramLong;
      if ((d > this.max) || (this.max == 0.0D)) {
        this.max = d;
      }
      while ((d >= this.min) && (this.min != 0.0D)) {
        return;
      }
      this.min = d;
    }
    
    public double getAvg()
    {
      return this.avg;
    }
    
    public double getMax()
    {
      return this.max;
    }
    
    public double getMin()
    {
      return this.min;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public long getTotalBufferLength()
    {
      return this.totalBufferLength;
    }
    
    public long getTotalTimeMs()
    {
      AppMethodBeat.i(114180);
      long l = Math.round(this.totalTimeNanoSecond / 1000000.0D);
      AppMethodBeat.o(114180);
      return l;
    }
    
    void reset()
    {
      this.avg = 0.0D;
      this.max = 0.0D;
      this.min = 0.0D;
      this.totalTimeNanoSecond = 0L;
      this.totalBufferLength = 0L;
    }
    
    public String toString()
    {
      AppMethodBeat.i(114181);
      compute();
      String str = String.format(Locale.getDefault(), "%10s%15.2f%15.2f%15.2f%10d%15d", new Object[] { this.name, Double.valueOf(this.avg), Double.valueOf(this.max), Double.valueOf(this.min), Long.valueOf(this.totalTimeNanoSecond), Long.valueOf(this.totalBufferLength) });
      AppMethodBeat.o(114181);
      return str;
    }
  }
  
  public static abstract interface Visitor
  {
    public abstract void visitSpeedCheck(List<PerformanceTracer.SpeedCheck> paramList, PerformanceTracer.OverallInfo paramOverallInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer
 * JD-Core Version:    0.7.0.1
 */