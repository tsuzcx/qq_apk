package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import a.v;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class RadarMemberView$k
  implements Runnable
{
  RadarMemberView$k(RadarMemberView paramRadarMemberView) {}
  
  public final void run()
  {
    AppMethodBeat.i(102961);
    if ((this.pRw.getContext() instanceof Activity))
    {
      Object localObject1 = RadarMemberView.pRv;
      localObject1 = this.pRw.getContext();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(102961);
        throw ((Throwable)localObject1);
      }
      Activity localActivity = (Activity)localObject1;
      j.q(localActivity, "ac");
      Object localObject2 = localActivity.getSystemService("input_method");
      localObject1 = localObject2;
      if (!(localObject2 instanceof InputMethodManager)) {
        localObject1 = null;
      }
      localObject1 = (InputMethodManager)localObject1;
      if (localObject1 == null)
      {
        AppMethodBeat.o(102961);
        return;
      }
      localObject2 = localActivity.getCurrentFocus();
      if (localObject2 == null)
      {
        AppMethodBeat.o(102961);
        return;
      }
      if (((View)localObject2).getWindowToken() == null)
      {
        AppMethodBeat.o(102961);
        return;
      }
      ((InputMethodManager)localObject1).toggleSoftInput(0, 2);
    }
    AppMethodBeat.o(102961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.k
 * JD-Core Version:    0.7.0.1
 */