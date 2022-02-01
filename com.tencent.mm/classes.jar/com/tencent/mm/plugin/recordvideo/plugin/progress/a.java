package com.tencent.mm.plugin.recordvideo.plugin.progress;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "progressBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getProgressBar", "()Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "setProgressBar", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "prepareDelete", "", "delete", "", "removeCurrentProgress", "verify", "", "(Ljava/lang/Integer;)V", "reset", "setVisibility", "visibility", "subFinish", "updateProgress", "subProgress", "Ljava/util/ArrayList;", "", "plugin-recordvideo_release"})
public final class a
  implements t
{
  public HorizontalSubProgressBar LoL;
  private d vjo;
  
  public a(HorizontalSubProgressBar paramHorizontalSubProgressBar, d paramd)
  {
    AppMethodBeat.i(204234);
    this.LoL = paramHorizontalSubProgressBar;
    this.vjo = paramd;
    AppMethodBeat.o(204234);
  }
  
  public final void apt() {}
  
  public final void bb(ArrayList<Float> paramArrayList)
  {
    AppMethodBeat.i(204229);
    k.h(paramArrayList, "subProgress");
    this.LoL.bb(paramArrayList);
    AppMethodBeat.o(204229);
  }
  
  public final boolean dia()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void o(Integer paramInteger)
  {
    AppMethodBeat.i(204231);
    this.LoL.o(paramInteger);
    AppMethodBeat.o(204231);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(204233);
    HorizontalSubProgressBar localHorizontalSubProgressBar = this.LoL;
    localHorizontalSubProgressBar.LoJ = false;
    localHorizontalSubProgressBar.LmQ.clear();
    localHorizontalSubProgressBar.postInvalidate();
    AppMethodBeat.o(204233);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(204232);
    if (paramInt == 0) {
      this.LoL.bringToFront();
    }
    this.LoL.setVisibility(paramInt);
    AppMethodBeat.o(204232);
  }
  
  public final void yY(boolean paramBoolean)
  {
    AppMethodBeat.i(204230);
    this.LoL.yY(paramBoolean);
    AppMethodBeat.o(204230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.a
 * JD-Core Version:    0.7.0.1
 */