package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class UploadVisitor
  implements Collectable, PerformanceTracer.Visitor
{
  private HashMap<String, Long> prefInfos;
  
  public UploadVisitor()
  {
    AppMethodBeat.i(114177);
    this.prefInfos = new HashMap();
    AppMethodBeat.o(114177);
  }
  
  public void accept(ErrorUploadCollector paramErrorUploadCollector) {}
  
  public void accept(PlayerInfoCollector paramPlayerInfoCollector)
  {
    AppMethodBeat.i(114179);
    if (!this.prefInfos.entrySet().isEmpty())
    {
      Iterator localIterator = this.prefInfos.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramPlayerInfoCollector.putLong((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
      }
    }
    AppMethodBeat.o(114179);
  }
  
  public void visitSpeedCheck(List<PerformanceTracer.SpeedCheck> paramList, PerformanceTracer.OverallInfo paramOverallInfo)
  {
    AppMethodBeat.i(114178);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramOverallInfo = (PerformanceTracer.SpeedCheck)paramList.next();
      this.prefInfos.put(paramOverallInfo.getName() + ".ms", Long.valueOf(paramOverallInfo.getTotalTimeMs()));
      this.prefInfos.put(paramOverallInfo.getName() + ".bytes", Long.valueOf(paramOverallInfo.getTotalBufferLength()));
    }
    AppMethodBeat.o(114178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.UploadVisitor
 * JD-Core Version:    0.7.0.1
 */