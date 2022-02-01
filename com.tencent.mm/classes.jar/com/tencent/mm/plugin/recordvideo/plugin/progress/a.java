package com.tencent.mm.plugin.recordvideo.plugin.progress;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "progressBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getProgressBar", "()Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "setProgressBar", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "prepareDelete", "", "delete", "", "removeCurrentProgress", "verify", "", "(Ljava/lang/Integer;)V", "reset", "setVisibility", "visibility", "subFinish", "updateProgress", "subProgress", "Ljava/util/ArrayList;", "", "plugin-recordvideo_release"})
public final class a
  implements t
{
  private d sQE;
  public HorizontalSubProgressBar xGK;
  
  public a(HorizontalSubProgressBar paramHorizontalSubProgressBar, d paramd)
  {
    AppMethodBeat.i(200394);
    this.xGK = paramHorizontalSubProgressBar;
    this.sQE = paramd;
    AppMethodBeat.o(200394);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ar(ArrayList<Float> paramArrayList)
  {
    AppMethodBeat.i(200389);
    p.h(paramArrayList, "subProgress");
    this.xGK.ar(paramArrayList);
    AppMethodBeat.o(200389);
  }
  
  public final void ayX() {}
  
  public final void l(Integer paramInteger)
  {
    AppMethodBeat.i(200391);
    this.xGK.l(paramInteger);
    AppMethodBeat.o(200391);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200395);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200395);
  }
  
  public final void onResume() {}
  
  public final void oy(boolean paramBoolean)
  {
    AppMethodBeat.i(200390);
    this.xGK.oy(paramBoolean);
    AppMethodBeat.o(200390);
  }
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(200393);
    HorizontalSubProgressBar localHorizontalSubProgressBar = this.xGK;
    localHorizontalSubProgressBar.xGI = false;
    localHorizontalSubProgressBar.vUy.clear();
    localHorizontalSubProgressBar.postInvalidate();
    AppMethodBeat.o(200393);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(200392);
    if (paramInt == 0) {
      this.xGK.bringToFront();
    }
    this.xGK.setVisibility(paramInt);
    AppMethodBeat.o(200392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.a
 * JD-Core Version:    0.7.0.1
 */