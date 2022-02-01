package com.tencent.mm.plugin.recordvideo.plugin.progress;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "progressBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getProgressBar", "()Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "setProgressBar", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "prepareDelete", "", "delete", "", "removeCurrentProgress", "verify", "", "(Ljava/lang/Integer;)V", "reset", "setVisibility", "visibility", "subFinish", "updateProgress", "subProgress", "Ljava/util/ArrayList;", "", "plugin-recordvideo_release"})
public final class a
  implements t
{
  public HorizontalSubProgressBar BXq;
  private d wgr;
  
  public a(HorizontalSubProgressBar paramHorizontalSubProgressBar, d paramd)
  {
    AppMethodBeat.i(237430);
    this.BXq = paramHorizontalSubProgressBar;
    this.wgr = paramd;
    AppMethodBeat.o(237430);
  }
  
  public final void aJ(ArrayList<Float> paramArrayList)
  {
    AppMethodBeat.i(237425);
    p.h(paramArrayList, "subProgress");
    this.BXq.aJ(paramArrayList);
    AppMethodBeat.o(237425);
  }
  
  public final void aSs() {}
  
  public final void m(Integer paramInteger)
  {
    AppMethodBeat.i(237427);
    this.BXq.m(paramInteger);
    AppMethodBeat.o(237427);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237431);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237431);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(237429);
    HorizontalSubProgressBar localHorizontalSubProgressBar = this.BXq;
    localHorizontalSubProgressBar.BXo = false;
    localHorizontalSubProgressBar.zBc.clear();
    localHorizontalSubProgressBar.postInvalidate();
    AppMethodBeat.o(237429);
  }
  
  public final void rl(boolean paramBoolean)
  {
    AppMethodBeat.i(237426);
    this.BXq.rl(paramBoolean);
    AppMethodBeat.o(237426);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(237428);
    if (paramInt == 0) {
      this.BXq.bringToFront();
    }
    this.BXq.setVisibility(paramInt);
    AppMethodBeat.o(237428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.a
 * JD-Core Version:    0.7.0.1
 */