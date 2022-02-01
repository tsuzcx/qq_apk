package com.tencent.tav.core.parallel.viewmodel;

import androidx.lifecycle.af;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetExportSession.AssetExportSessionStatus;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.parallel.info.PipelineWorkInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/core/parallel/viewmodel/ParallelResultViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "resultList", "Ljava/util/ArrayList;", "Lcom/tencent/tav/core/parallel/viewmodel/ParallelWorkResult;", "Lkotlin/collections/ArrayList;", "<set-?>", "Landroidx/lifecycle/MutableLiveData;", "", "resultLiveData", "getResultLiveData", "()Landroidx/lifecycle/MutableLiveData;", "updateWorkResult", "", "work", "Lcom/tencent/tav/core/parallel/info/PipelineWorkInfo;", "status", "Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;", "errorCode", "Lcom/tencent/tav/core/ExportErrorStatus;", "updateWorkResultSuccess", "avfoundation_release"}, k=1, mv={1, 1, 15})
public final class ParallelResultViewModel
  extends af
{
  private final ArrayList<ParallelWorkResult> resultList;
  private x<List<ParallelWorkResult>> resultLiveData;
  
  public ParallelResultViewModel()
  {
    AppMethodBeat.i(215534);
    this.resultLiveData = new x();
    this.resultList = new ArrayList();
    AppMethodBeat.o(215534);
  }
  
  public final x<List<ParallelWorkResult>> getResultLiveData()
  {
    return this.resultLiveData;
  }
  
  public final void updateWorkResult(PipelineWorkInfo paramPipelineWorkInfo, AssetExportSession.AssetExportSessionStatus paramAssetExportSessionStatus, ExportErrorStatus paramExportErrorStatus)
  {
    AppMethodBeat.i(215551);
    s.t(paramPipelineWorkInfo, "work");
    s.t(paramAssetExportSessionStatus, "status");
    s.t(paramExportErrorStatus, "errorCode");
    Iterator localIterator = ((Iterable)this.resultList).iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (s.p(((ParallelWorkResult)localObject).getIndicatorInfo(), paramPipelineWorkInfo.getIndicator()))
      {
        localObject = (ParallelWorkResult)localObject;
        if (localObject == null) {
          break label121;
        }
        ((ParallelWorkResult)localObject).setStatus(paramAssetExportSessionStatus);
        ((ParallelWorkResult)localObject).setExportErrorStatus(paramExportErrorStatus);
      }
    }
    for (;;)
    {
      this.resultLiveData.t(this.resultList);
      AppMethodBeat.o(215551);
      return;
      localObject = null;
      break;
      label121:
      localObject = this.resultList;
      paramPipelineWorkInfo = paramPipelineWorkInfo.getIndicator();
      s.r(paramPipelineWorkInfo, "work.indicator");
      ((ArrayList)localObject).add(new ParallelWorkResult(paramPipelineWorkInfo, paramAssetExportSessionStatus, paramExportErrorStatus));
    }
  }
  
  public final void updateWorkResultSuccess(PipelineWorkInfo paramPipelineWorkInfo)
  {
    AppMethodBeat.i(215558);
    s.t(paramPipelineWorkInfo, "work");
    updateWorkResult(paramPipelineWorkInfo, AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted, new ExportErrorStatus(0));
    AppMethodBeat.o(215558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.viewmodel.ParallelResultViewModel
 * JD-Core Version:    0.7.0.1
 */