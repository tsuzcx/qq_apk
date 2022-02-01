package com.tencent.tav.core.parallel.control;

import android.os.Handler;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetParallelSegmentStatus;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.core.parallel.info.PipelineWorkInfo;
import com.tencent.tav.core.parallel.viewmodel.ParallelWorkResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/core/parallel/control/ParallelMuxerController;", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/tav/core/parallel/viewmodel/ParallelWorkResult;", "exportWork", "Ljava/util/ArrayList;", "Lcom/tencent/tav/core/parallel/info/PipelineWorkInfo;", "Lkotlin/collections/ArrayList;", "exportHandler", "Landroid/os/Handler;", "(Ljava/util/ArrayList;Landroid/os/Handler;)V", "getExportHandler", "()Landroid/os/Handler;", "setExportHandler", "(Landroid/os/Handler;)V", "getExportWork", "()Ljava/util/ArrayList;", "setExportWork", "(Ljava/util/ArrayList;)V", "allWorkSuccess", "", "exportFail", "", "exportSuccess", "onChanged", "p0", "avfoundation_release"}, k=1, mv={1, 1, 15})
public final class ParallelMuxerController
  implements y<List<? extends ParallelWorkResult>>
{
  private Handler exportHandler;
  private ArrayList<PipelineWorkInfo> exportWork;
  
  public ParallelMuxerController(ArrayList<PipelineWorkInfo> paramArrayList, Handler paramHandler)
  {
    AppMethodBeat.i(215595);
    this.exportWork = paramArrayList;
    this.exportHandler = paramHandler;
    AppMethodBeat.o(215595);
  }
  
  private final boolean allWorkSuccess()
  {
    AppMethodBeat.i(215587);
    Object localObject = this.exportWork;
    int i;
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        PipelineIndicatorInfo localPipelineIndicatorInfo = ((PipelineWorkInfo)localObject).getIndicator();
        s.r(localPipelineIndicatorInfo, "it.indicator");
        if (localPipelineIndicatorInfo.getSegmentStatus() != AssetParallelSegmentStatus.AssetReaderStatusWriteFinish)
        {
          i = 1;
          label69:
          if (i == 0) {
            break label92;
          }
        }
      }
    }
    label73:
    for (localObject = (PipelineWorkInfo)localObject;; localObject = null)
    {
      if (localObject != null) {
        break label104;
      }
      AppMethodBeat.o(215587);
      return true;
      i = 0;
      break label69;
      label92:
      break;
      localObject = null;
      break label73;
    }
    label104:
    AppMethodBeat.o(215587);
    return false;
  }
  
  public final void exportFail() {}
  
  public final void exportSuccess()
  {
    AppMethodBeat.i(215613);
    Handler localHandler = this.exportHandler;
    if (localHandler != null)
    {
      localHandler.post((Runnable)ParallelMuxerController.exportSuccess.1.INSTANCE);
      AppMethodBeat.o(215613);
      return;
    }
    AppMethodBeat.o(215613);
  }
  
  public final Handler getExportHandler()
  {
    return this.exportHandler;
  }
  
  public final ArrayList<PipelineWorkInfo> getExportWork()
  {
    return this.exportWork;
  }
  
  public final void onChanged(List<ParallelWorkResult> paramList)
  {
    AppMethodBeat.i(215603);
    if (paramList != null)
    {
      if (paramList.size() != this.exportWork.size()) {
        break label52;
      }
      if (allWorkSuccess())
      {
        exportSuccess();
        AppMethodBeat.o(215603);
      }
    }
    else
    {
      AppMethodBeat.o(215603);
      return;
    }
    exportFail();
    label52:
    AppMethodBeat.o(215603);
  }
  
  public final void setExportHandler(Handler paramHandler)
  {
    this.exportHandler = paramHandler;
  }
  
  public final void setExportWork(ArrayList<PipelineWorkInfo> paramArrayList)
  {
    AppMethodBeat.i(215624);
    s.t(paramArrayList, "<set-?>");
    this.exportWork = paramArrayList;
    AppMethodBeat.o(215624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.control.ParallelMuxerController
 * JD-Core Version:    0.7.0.1
 */