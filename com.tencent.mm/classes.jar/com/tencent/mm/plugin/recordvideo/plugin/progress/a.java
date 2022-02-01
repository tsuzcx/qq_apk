package com.tencent.mm.plugin.recordvideo.plugin.progress;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "progressBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getProgressBar", "()Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "setProgressBar", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "prepareDelete", "", "delete", "", "removeCurrentProgress", "verify", "", "(Ljava/lang/Integer;)V", "reset", "setVisibility", "visibility", "subFinish", "updateProgress", "subProgress", "Ljava/util/ArrayList;", "", "plugin-recordvideo_release"})
public final class a
  implements t
{
  private d rTT;
  public HorizontalSubProgressBar wxQ;
  
  public a(HorizontalSubProgressBar paramHorizontalSubProgressBar, d paramd)
  {
    AppMethodBeat.i(199353);
    this.wxQ = paramHorizontalSubProgressBar;
    this.rTT = paramd;
    AppMethodBeat.o(199353);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void at(ArrayList<Float> paramArrayList)
  {
    AppMethodBeat.i(199348);
    k.h(paramArrayList, "subProgress");
    this.wxQ.at(paramArrayList);
    AppMethodBeat.o(199348);
  }
  
  public final void awk() {}
  
  public final void k(Integer paramInteger)
  {
    AppMethodBeat.i(199350);
    this.wxQ.k(paramInteger);
    AppMethodBeat.o(199350);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void oe(boolean paramBoolean)
  {
    AppMethodBeat.i(199349);
    this.wxQ.oe(paramBoolean);
    AppMethodBeat.o(199349);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(199352);
    HorizontalSubProgressBar localHorizontalSubProgressBar = this.wxQ;
    localHorizontalSubProgressBar.wxO = false;
    localHorizontalSubProgressBar.uRo.clear();
    localHorizontalSubProgressBar.postInvalidate();
    AppMethodBeat.o(199352);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(199351);
    if (paramInt == 0) {
      this.wxQ.bringToFront();
    }
    this.wxQ.setVisibility(paramInt);
    AppMethodBeat.o(199351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.a
 * JD-Core Version:    0.7.0.1
 */