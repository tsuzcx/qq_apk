package com.tencent.tav.core.parallel.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetExportSession.AssetExportSessionStatus;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/core/parallel/viewmodel/ParallelWorkResult;", "", "indicatorInfo", "Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;", "status", "Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;", "exportErrorStatus", "Lcom/tencent/tav/core/ExportErrorStatus;", "(Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;Lcom/tencent/tav/core/ExportErrorStatus;)V", "getExportErrorStatus", "()Lcom/tencent/tav/core/ExportErrorStatus;", "setExportErrorStatus", "(Lcom/tencent/tav/core/ExportErrorStatus;)V", "getIndicatorInfo", "()Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;", "setIndicatorInfo", "(Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;)V", "getStatus", "()Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;", "setStatus", "(Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "avfoundation_release"}, k=1, mv={1, 1, 15})
public final class ParallelWorkResult
{
  public static final Companion Companion;
  private ExportErrorStatus exportErrorStatus;
  private PipelineIndicatorInfo indicatorInfo;
  private AssetExportSession.AssetExportSessionStatus status;
  
  static
  {
    AppMethodBeat.i(215576);
    Companion = new Companion(null);
    AppMethodBeat.o(215576);
  }
  
  public ParallelWorkResult(PipelineIndicatorInfo paramPipelineIndicatorInfo, AssetExportSession.AssetExportSessionStatus paramAssetExportSessionStatus, ExportErrorStatus paramExportErrorStatus)
  {
    AppMethodBeat.i(215552);
    this.indicatorInfo = paramPipelineIndicatorInfo;
    this.status = paramAssetExportSessionStatus;
    this.exportErrorStatus = paramExportErrorStatus;
    AppMethodBeat.o(215552);
  }
  
  public final PipelineIndicatorInfo component1()
  {
    return this.indicatorInfo;
  }
  
  public final AssetExportSession.AssetExportSessionStatus component2()
  {
    return this.status;
  }
  
  public final ExportErrorStatus component3()
  {
    return this.exportErrorStatus;
  }
  
  public final ParallelWorkResult copy(PipelineIndicatorInfo paramPipelineIndicatorInfo, AssetExportSession.AssetExportSessionStatus paramAssetExportSessionStatus, ExportErrorStatus paramExportErrorStatus)
  {
    AppMethodBeat.i(215663);
    s.t(paramPipelineIndicatorInfo, "indicatorInfo");
    s.t(paramAssetExportSessionStatus, "status");
    paramPipelineIndicatorInfo = new ParallelWorkResult(paramPipelineIndicatorInfo, paramAssetExportSessionStatus, paramExportErrorStatus);
    AppMethodBeat.o(215663);
    return paramPipelineIndicatorInfo;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(215694);
    if (this != paramObject)
    {
      if ((paramObject instanceof ParallelWorkResult))
      {
        paramObject = (ParallelWorkResult)paramObject;
        if ((!s.p(this.indicatorInfo, paramObject.indicatorInfo)) || (!s.p(this.status, paramObject.status)) || (!s.p(this.exportErrorStatus, paramObject.exportErrorStatus))) {}
      }
    }
    else
    {
      AppMethodBeat.o(215694);
      return true;
    }
    AppMethodBeat.o(215694);
    return false;
  }
  
  public final ExportErrorStatus getExportErrorStatus()
  {
    return this.exportErrorStatus;
  }
  
  public final PipelineIndicatorInfo getIndicatorInfo()
  {
    return this.indicatorInfo;
  }
  
  public final AssetExportSession.AssetExportSessionStatus getStatus()
  {
    return this.status;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(215682);
    Object localObject = this.indicatorInfo;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.status;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.exportErrorStatus;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(215682);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final void setExportErrorStatus(ExportErrorStatus paramExportErrorStatus)
  {
    this.exportErrorStatus = paramExportErrorStatus;
  }
  
  public final void setIndicatorInfo(PipelineIndicatorInfo paramPipelineIndicatorInfo)
  {
    AppMethodBeat.i(215612);
    s.t(paramPipelineIndicatorInfo, "<set-?>");
    this.indicatorInfo = paramPipelineIndicatorInfo;
    AppMethodBeat.o(215612);
  }
  
  public final void setStatus(AssetExportSession.AssetExportSessionStatus paramAssetExportSessionStatus)
  {
    AppMethodBeat.i(215621);
    s.t(paramAssetExportSessionStatus, "<set-?>");
    this.status = paramAssetExportSessionStatus;
    AppMethodBeat.o(215621);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(215672);
    String str = "ParallelWorkResult(indicatorInfo=" + this.indicatorInfo + ", status=" + this.status + ", exportErrorStatus=" + this.exportErrorStatus + ")";
    AppMethodBeat.o(215672);
    return str;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/core/parallel/viewmodel/ParallelWorkResult$Companion;", "", "()V", "getSuccessResult", "Lcom/tencent/tav/core/parallel/viewmodel/ParallelWorkResult;", "indicatorInfo", "Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;", "avfoundation_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    public final ParallelWorkResult getSuccessResult(PipelineIndicatorInfo paramPipelineIndicatorInfo)
    {
      AppMethodBeat.i(215545);
      s.t(paramPipelineIndicatorInfo, "indicatorInfo");
      paramPipelineIndicatorInfo = new ParallelWorkResult(paramPipelineIndicatorInfo, AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted, new ExportErrorStatus(0));
      AppMethodBeat.o(215545);
      return paramPipelineIndicatorInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.viewmodel.ParallelWorkResult
 * JD-Core Version:    0.7.0.1
 */