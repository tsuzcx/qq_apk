package com.tencent.mm.plugin.recordvideo.plugin.progress;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "progressBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getProgressBar", "()Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "setProgressBar", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "prepareDelete", "", "delete", "", "removeCurrentProgress", "verify", "", "(Ljava/lang/Integer;)V", "reset", "setVisibility", "visibility", "subFinish", "updateProgress", "subProgress", "Ljava/util/ArrayList;", "", "plugin-recordvideo_release"})
public final class a
  implements t
{
  private d tbP;
  public HorizontalSubProgressBar xWF;
  
  public a(HorizontalSubProgressBar paramHorizontalSubProgressBar, d paramd)
  {
    AppMethodBeat.i(206655);
    this.xWF = paramHorizontalSubProgressBar;
    this.tbP = paramd;
    AppMethodBeat.o(206655);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void as(ArrayList<Float> paramArrayList)
  {
    AppMethodBeat.i(206650);
    p.h(paramArrayList, "subProgress");
    this.xWF.as(paramArrayList);
    AppMethodBeat.o(206650);
  }
  
  public final void azm() {}
  
  public final void m(Integer paramInteger)
  {
    AppMethodBeat.i(206652);
    this.xWF.m(paramInteger);
    AppMethodBeat.o(206652);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void oD(boolean paramBoolean)
  {
    AppMethodBeat.i(206651);
    this.xWF.oD(paramBoolean);
    AppMethodBeat.o(206651);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206656);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206656);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(206654);
    HorizontalSubProgressBar localHorizontalSubProgressBar = this.xWF;
    localHorizontalSubProgressBar.xWD = false;
    localHorizontalSubProgressBar.wgC.clear();
    localHorizontalSubProgressBar.postInvalidate();
    AppMethodBeat.o(206654);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(206653);
    if (paramInt == 0) {
      this.xWF.bringToFront();
    }
    this.xWF.setVisibility(paramInt);
    AppMethodBeat.o(206653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.a
 * JD-Core Version:    0.7.0.1
 */