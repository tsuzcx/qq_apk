package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class RadarMemberView$k
  implements Runnable
{
  RadarMemberView$k(RadarMemberView paramRadarMemberView) {}
  
  public final void run()
  {
    AppMethodBeat.i(138606);
    if ((this.xzN.getContext() instanceof Activity))
    {
      Object localObject1 = RadarMemberView.xzM;
      localObject1 = this.xzN.getContext();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(138606);
        throw ((Throwable)localObject1);
      }
      Activity localActivity = (Activity)localObject1;
      p.h(localActivity, "ac");
      Object localObject2 = localActivity.getSystemService("input_method");
      localObject1 = localObject2;
      if (!(localObject2 instanceof InputMethodManager)) {
        localObject1 = null;
      }
      localObject1 = (InputMethodManager)localObject1;
      if (localObject1 == null)
      {
        AppMethodBeat.o(138606);
        return;
      }
      localObject2 = localActivity.getCurrentFocus();
      if (localObject2 == null)
      {
        AppMethodBeat.o(138606);
        return;
      }
      if (((View)localObject2).getWindowToken() == null)
      {
        AppMethodBeat.o(138606);
        return;
      }
      ((InputMethodManager)localObject1).toggleSoftInput(0, 2);
    }
    AppMethodBeat.o(138606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.k
 * JD-Core Version:    0.7.0.1
 */