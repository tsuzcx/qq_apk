package com.tencent.qqmusic.mediaplayer.perf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class UploadVisitor
  implements Collectable, PerformanceTracer.Visitor
{
  private HashMap<String, Long> prefInfos = new HashMap();
  
  public void accept(ErrorUploadCollector paramErrorUploadCollector) {}
  
  public void accept(PlayerInfoCollector paramPlayerInfoCollector)
  {
    if (!this.prefInfos.entrySet().isEmpty())
    {
      Iterator localIterator = this.prefInfos.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramPlayerInfoCollector.putLong((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
      }
    }
  }
  
  public void visitSpeedCheck(List<PerformanceTracer.SpeedCheck> paramList, PerformanceTracer.OverallInfo paramOverallInfo)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramOverallInfo = (PerformanceTracer.SpeedCheck)paramList.next();
      this.prefInfos.put(paramOverallInfo.getName() + ".ms", Long.valueOf(paramOverallInfo.getTotalTimeMs()));
      this.prefInfos.put(paramOverallInfo.getName() + ".bytes", Long.valueOf(paramOverallInfo.getTotalBufferLength()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.UploadVisitor
 * JD-Core Version:    0.7.0.1
 */