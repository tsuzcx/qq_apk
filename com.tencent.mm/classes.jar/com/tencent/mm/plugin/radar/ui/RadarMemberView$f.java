package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class RadarMemberView$f
  implements View.OnTouchListener
{
  RadarMemberView$f(RadarMemberView paramRadarMemberView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView != RadarMemberView.b(this.nmh))
    {
      g.j(paramMotionEvent, "event");
      if ((paramMotionEvent.getAction() == 1) && (this.nmh.isShowing())) {
        this.nmh.dismiss();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.f
 * JD-Core Version:    0.7.0.1
 */