package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class RadarMemberView$f
  implements View.OnTouchListener
{
  RadarMemberView$f(RadarMemberView paramRadarMemberView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(102952);
    if (paramView != RadarMemberView.b(this.pRw))
    {
      j.p(paramMotionEvent, "event");
      if ((paramMotionEvent.getAction() == 1) && (this.pRw.isShowing())) {
        this.pRw.dismiss();
      }
    }
    AppMethodBeat.o(102952);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.f
 * JD-Core Version:    0.7.0.1
 */