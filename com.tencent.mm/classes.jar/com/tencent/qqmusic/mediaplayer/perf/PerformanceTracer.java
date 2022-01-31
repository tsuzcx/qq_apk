package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PerformanceTracer
{
  private IDataSource dataSource;
  private long lastTimeStampNanoSecond;
  private long playStartTimestampNanoSec;
  private final Map<String, PerformanceTracer.SpeedCheck> speedMap;
  private long totalPcmInByte;
  private long totalTimeCostInNanoSec;
  
  public PerformanceTracer()
  {
    AppMethodBeat.i(128420);
    this.speedMap = new LinkedHashMap();
    this.lastTimeStampNanoSecond = 0L;
    this.playStartTimestampNanoSec = 0L;
    this.totalTimeCostInNanoSec = 0L;
    AppMethodBeat.o(128420);
  }
  
  private PerformanceTracer.SpeedCheck getSpeedCheck(String paramString)
  {
    AppMethodBeat.i(128427);
    PerformanceTracer.SpeedCheck localSpeedCheck = (PerformanceTracer.SpeedCheck)this.speedMap.get(paramString);
    if (localSpeedCheck != null)
    {
      AppMethodBeat.o(128427);
      return localSpeedCheck;
    }
    localSpeedCheck = new PerformanceTracer.SpeedCheck(paramString, null);
    this.speedMap.put(paramString, localSpeedCheck);
    AppMethodBeat.o(128427);
    return localSpeedCheck;
  }
  
  public void accept(PerformanceTracer.Visitor paramVisitor)
  {
    AppMethodBeat.i(128426);
    ArrayList localArrayList = new ArrayList(this.speedMap.values());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      PerformanceTracer.SpeedCheck.access$100((PerformanceTracer.SpeedCheck)localIterator.next());
    }
    paramVisitor.visitSpeedCheck(localArrayList, new PerformanceTracer.OverallInfo(this.dataSource, Math.round(this.totalTimeCostInNanoSec / 1000000.0D), this.totalPcmInByte));
    AppMethodBeat.o(128426);
  }
  
  public void end(String paramString, int paramInt)
  {
    AppMethodBeat.i(128425);
    long l1 = System.nanoTime();
    long l2 = this.lastTimeStampNanoSecond;
    PerformanceTracer.SpeedCheck.access$000(getSpeedCheck(paramString), paramInt, l1 - l2);
    AppMethodBeat.o(128425);
  }
  
  public void init(IDataSource paramIDataSource)
  {
    AppMethodBeat.i(128421);
    this.dataSource = paramIDataSource;
    this.lastTimeStampNanoSecond = 0L;
    paramIDataSource = this.speedMap.values().iterator();
    while (paramIDataSource.hasNext()) {
      ((PerformanceTracer.SpeedCheck)paramIDataSource.next()).reset();
    }
    AppMethodBeat.o(128421);
  }
  
  public void playEnd() {}
  
  public void playStart()
  {
    this.totalPcmInByte = 0L;
  }
  
  public void roundEnd(int paramInt)
  {
    AppMethodBeat.i(128423);
    this.totalPcmInByte += paramInt;
    this.totalTimeCostInNanoSec += System.nanoTime() - this.playStartTimestampNanoSec;
    AppMethodBeat.o(128423);
  }
  
  public void roundStart()
  {
    AppMethodBeat.i(128422);
    this.playStartTimestampNanoSec = System.nanoTime();
    AppMethodBeat.o(128422);
  }
  
  public void start(String paramString)
  {
    AppMethodBeat.i(128424);
    getSpeedCheck(paramString);
    this.lastTimeStampNanoSecond = System.nanoTime();
    AppMethodBeat.o(128424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer
 * JD-Core Version:    0.7.0.1
 */