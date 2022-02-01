package com.tencent.mm.plugin.recordvideo.plugin.progress;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "progressBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getProgressBar", "()Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "setProgressBar", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "prepareDelete", "", "delete", "", "removeCurrentProgress", "verify", "", "(Ljava/lang/Integer;)V", "reset", "setVisibility", "visibility", "subFinish", "updateProgress", "subProgress", "Ljava/util/ArrayList;", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  public HorizontalSubProgressBar NQP;
  
  public a(HorizontalSubProgressBar paramHorizontalSubProgressBar, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(280516);
    this.NQP = paramHorizontalSubProgressBar;
    this.GrC = parama;
    AppMethodBeat.o(280516);
  }
  
  public final void B(Integer paramInteger)
  {
    AppMethodBeat.i(280525);
    this.NQP.B(paramInteger);
    AppMethodBeat.o(280525);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280541);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280541);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280563);
    s.u(this, "this");
    AppMethodBeat.o(280563);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280547);
    String str = v.a.b(this);
    AppMethodBeat.o(280547);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280554);
    s.u(this, "this");
    AppMethodBeat.o(280554);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280568);
    s.u(this, "this");
    AppMethodBeat.o(280568);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280572);
    s.u(this, "this");
    AppMethodBeat.o(280572);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280579);
    s.u(this, "this");
    AppMethodBeat.o(280579);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280582);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280582);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280587);
    s.u(this, "this");
    AppMethodBeat.o(280587);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280590);
    s.u(this, "this");
    AppMethodBeat.o(280590);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280535);
    s.u((v)this, "this");
    HorizontalSubProgressBar localHorizontalSubProgressBar = this.NQP;
    localHorizontalSubProgressBar.NQO = false;
    localHorizontalSubProgressBar.Lbx.clear();
    localHorizontalSubProgressBar.postInvalidate();
    AppMethodBeat.o(280535);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280528);
    s.u((v)this, "this");
    if (paramInt == 0) {
      this.NQP.bringToFront();
    }
    this.NQP.setVisibility(paramInt);
    AppMethodBeat.o(280528);
  }
  
  public final void yC(boolean paramBoolean)
  {
    AppMethodBeat.i(280519);
    this.NQP.yC(paramBoolean);
    AppMethodBeat.o(280519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.a
 * JD-Core Version:    0.7.0.1
 */