package com.tencent.tav.core.parallel.control;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.core.parallel.info.PipelineWorkInfo;
import com.tencent.tav.coremedia.CMPerformance;
import com.tencent.tav.coremedia.CMPerformance.CMPerformanceStage;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/core/parallel/control/ParallelExportAnalyse;", "", "info", "Lcom/tencent/tav/core/parallel/info/PipelineWorkInfo;", "(Lcom/tencent/tav/core/parallel/info/PipelineWorkInfo;)V", "getInfo", "()Lcom/tencent/tav/core/parallel/info/PipelineWorkInfo;", "setInfo", "stageAnalysis", "Ljava/util/ArrayList;", "Lcom/tencent/tav/core/parallel/control/ParallelExportAnalyse$StageAnalyse;", "Lkotlin/collections/ArrayList;", "analyseAppendSampleBuffer", "", "sample", "Lcom/tencent/tav/coremedia/CMSampleBuffer;", "analyseGetSampleBuffer", "analyseSingleStage", "performanceData", "Lcom/tencent/tav/coremedia/CMPerformance;", "analyseToString", "", "Companion", "StageAnalyse", "avfoundation_release"}, k=1, mv={1, 1, 15})
public final class ParallelExportAnalyse
{
  public static final ParallelExportAnalyse.Companion Companion;
  private static final String TAG = "MicroMsg.ParallelExportAnalyse";
  private PipelineWorkInfo info;
  private final ArrayList<StageAnalyse> stageAnalysis;
  
  static
  {
    AppMethodBeat.i(215589);
    Companion = new ParallelExportAnalyse.Companion(null);
    AppMethodBeat.o(215589);
  }
  
  public ParallelExportAnalyse(PipelineWorkInfo paramPipelineWorkInfo)
  {
    AppMethodBeat.i(215584);
    this.info = paramPipelineWorkInfo;
    this.stageAnalysis = new ArrayList();
    AppMethodBeat.o(215584);
  }
  
  private final void analyseSingleStage(CMPerformance paramCMPerformance)
  {
    AppMethodBeat.i(215567);
    Iterator localIterator = ((Iterable)this.stageAnalysis).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((StageAnalyse)localObject).getStage() == paramCMPerformance.stage)
      {
        i = 1;
        label53:
        if (i == 0) {
          break label157;
        }
        label57:
        localObject = (StageAnalyse)localObject;
        if (localObject != null) {
          break label164;
        }
        localObject = paramCMPerformance.stage;
        s.r(localObject, "performanceData.stage");
        localObject = new StageAnalyse((CMPerformance.CMPerformanceStage)localObject, 1, paramCMPerformance.costMs());
        this.stageAnalysis.add(localObject);
      }
    }
    for (;;)
    {
      paramCMPerformance = paramCMPerformance.preNodes;
      s.r(paramCMPerformance, "performanceData.preNodes");
      paramCMPerformance = ((Iterable)paramCMPerformance).iterator();
      while (paramCMPerformance.hasNext())
      {
        localObject = (CMPerformance)paramCMPerformance.next();
        s.r(localObject, "it");
        analyseSingleStage((CMPerformance)localObject);
      }
      i = 0;
      break label53;
      label157:
      break;
      localObject = null;
      break label57;
      label164:
      ((StageAnalyse)localObject).setCount(((StageAnalyse)localObject).getCount() + 1);
      ((StageAnalyse)localObject).setTotalCostMs(((StageAnalyse)localObject).getTotalCostMs() + paramCMPerformance.costMs());
    }
    AppMethodBeat.o(215567);
  }
  
  private final String analyseToString()
  {
    AppMethodBeat.i(215575);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("\n");
    Iterator localIterator = ((Iterable)this.stageAnalysis).iterator();
    while (localIterator.hasNext())
    {
      StageAnalyse localStageAnalyse = (StageAnalyse)localIterator.next();
      ((StringBuffer)localObject).append("[" + localStageAnalyse.getStage() + ':' + localStageAnalyse.getTotalCostMs() / localStageAnalyse.getCount() + "]\n");
    }
    localObject = ((StringBuffer)localObject).toString();
    s.r(localObject, "sb.toString()");
    AppMethodBeat.o(215575);
    return localObject;
  }
  
  public final void analyseAppendSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(215608);
    s.t(paramCMSampleBuffer, "sample");
    paramCMSampleBuffer = paramCMSampleBuffer.getState().performance;
    s.r(paramCMSampleBuffer, "performanceData");
    analyseSingleStage(paramCMSampleBuffer);
    paramCMSampleBuffer = new StringBuilder("[");
    PipelineIndicatorInfo localPipelineIndicatorInfo = this.info.getIndicator();
    s.r(localPipelineIndicatorInfo, "info.indicator");
    Logger.d("MicroMsg.ParallelExportAnalyse", localPipelineIndicatorInfo.getIndex() + "]analyse output buffer: " + analyseToString());
    AppMethodBeat.o(215608);
  }
  
  public final void analyseGetSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(215599);
    s.t(paramCMSampleBuffer, "sample");
    paramCMSampleBuffer = paramCMSampleBuffer.getState().performance;
    s.r(paramCMSampleBuffer, "performanceData");
    analyseSingleStage(paramCMSampleBuffer);
    Object localObject = ((Iterable)this.stageAnalysis).iterator();
    int i;
    if (((Iterator)localObject).hasNext())
    {
      paramCMSampleBuffer = ((Iterator)localObject).next();
      StageAnalyse localStageAnalyse = (StageAnalyse)paramCMSampleBuffer;
      if ((localStageAnalyse.getStage() == CMPerformance.CMPerformanceStage.RENDER) && (localStageAnalyse.getCount() % 30 == 0))
      {
        i = 1;
        label89:
        if (i == 0) {
          break label161;
        }
      }
    }
    for (;;)
    {
      if ((StageAnalyse)paramCMSampleBuffer != null)
      {
        paramCMSampleBuffer = new StringBuilder("[");
        localObject = this.info.getIndicator();
        s.r(localObject, "info.indicator");
        Logger.d("MicroMsg.ParallelExportAnalyse", ((PipelineIndicatorInfo)localObject).getIndex() + "]analyse input buffer: " + analyseToString());
      }
      AppMethodBeat.o(215599);
      return;
      i = 0;
      break label89;
      label161:
      break;
      paramCMSampleBuffer = null;
    }
  }
  
  public final PipelineWorkInfo getInfo()
  {
    return this.info;
  }
  
  public final void setInfo(PipelineWorkInfo paramPipelineWorkInfo)
  {
    AppMethodBeat.i(215616);
    s.t(paramPipelineWorkInfo, "<set-?>");
    this.info = paramPipelineWorkInfo;
    AppMethodBeat.o(215616);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/core/parallel/control/ParallelExportAnalyse$StageAnalyse;", "", "stage", "Lcom/tencent/tav/coremedia/CMPerformance$CMPerformanceStage;", "count", "", "totalCostMs", "", "(Lcom/tencent/tav/coremedia/CMPerformance$CMPerformanceStage;IJ)V", "getCount", "()I", "setCount", "(I)V", "getStage", "()Lcom/tencent/tav/coremedia/CMPerformance$CMPerformanceStage;", "setStage", "(Lcom/tencent/tav/coremedia/CMPerformance$CMPerformanceStage;)V", "getTotalCostMs", "()J", "setTotalCostMs", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "avfoundation_release"}, k=1, mv={1, 1, 15})
  public static final class StageAnalyse
  {
    private int count;
    private CMPerformance.CMPerformanceStage stage;
    private long totalCostMs;
    
    public StageAnalyse(CMPerformance.CMPerformanceStage paramCMPerformanceStage, int paramInt, long paramLong)
    {
      AppMethodBeat.i(215570);
      this.stage = paramCMPerformanceStage;
      this.count = paramInt;
      this.totalCostMs = paramLong;
      AppMethodBeat.o(215570);
    }
    
    public final CMPerformance.CMPerformanceStage component1()
    {
      return this.stage;
    }
    
    public final int component2()
    {
      return this.count;
    }
    
    public final long component3()
    {
      return this.totalCostMs;
    }
    
    public final StageAnalyse copy(CMPerformance.CMPerformanceStage paramCMPerformanceStage, int paramInt, long paramLong)
    {
      AppMethodBeat.i(215629);
      s.t(paramCMPerformanceStage, "stage");
      paramCMPerformanceStage = new StageAnalyse(paramCMPerformanceStage, paramInt, paramLong);
      AppMethodBeat.o(215629);
      return paramCMPerformanceStage;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(215642);
      if (this != paramObject)
      {
        if (!(paramObject instanceof StageAnalyse)) {
          break label88;
        }
        paramObject = (StageAnalyse)paramObject;
        if (!s.p(this.stage, paramObject.stage)) {
          break label88;
        }
        if (this.count != paramObject.count) {
          break label78;
        }
        i = 1;
        if (i == 0) {
          break label88;
        }
        if (this.totalCostMs != paramObject.totalCostMs) {
          break label83;
        }
      }
      label78:
      label83:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label88;
        }
        AppMethodBeat.o(215642);
        return true;
        i = 0;
        break;
      }
      label88:
      AppMethodBeat.o(215642);
      return false;
    }
    
    public final int getCount()
    {
      return this.count;
    }
    
    public final CMPerformance.CMPerformanceStage getStage()
    {
      return this.stage;
    }
    
    public final long getTotalCostMs()
    {
      return this.totalCostMs;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(215636);
      CMPerformance.CMPerformanceStage localCMPerformanceStage = this.stage;
      if (localCMPerformanceStage != null) {}
      for (int i = localCMPerformanceStage.hashCode();; i = 0)
      {
        int j = this.count;
        long l = this.totalCostMs;
        int k = (int)(l ^ l >>> 32);
        AppMethodBeat.o(215636);
        return (i * 31 + j) * 31 + k;
      }
    }
    
    public final void setCount(int paramInt)
    {
      this.count = paramInt;
    }
    
    public final void setStage(CMPerformance.CMPerformanceStage paramCMPerformanceStage)
    {
      AppMethodBeat.i(215593);
      s.t(paramCMPerformanceStage, "<set-?>");
      this.stage = paramCMPerformanceStage;
      AppMethodBeat.o(215593);
    }
    
    public final void setTotalCostMs(long paramLong)
    {
      this.totalCostMs = paramLong;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(215634);
      String str = "StageAnalyse(stage=" + this.stage + ", count=" + this.count + ", totalCostMs=" + this.totalCostMs + ")";
      AppMethodBeat.o(215634);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.control.ParallelExportAnalyse
 * JD-Core Version:    0.7.0.1
 */