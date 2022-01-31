package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import a.k;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

final class RadarMemberView$k
  implements Runnable
{
  RadarMemberView$k(RadarMemberView paramRadarMemberView) {}
  
  public final void run()
  {
    Object localObject1;
    Activity localActivity;
    Object localObject2;
    if ((this.nmh.getContext() instanceof Activity))
    {
      localObject1 = RadarMemberView.nmg;
      localObject1 = this.nmh.getContext();
      if (localObject1 == null) {
        throw new k("null cannot be cast to non-null type android.app.Activity");
      }
      localActivity = (Activity)localObject1;
      g.k(localActivity, "ac");
      localObject2 = localActivity.getSystemService("input_method");
      localObject1 = localObject2;
      if (!(localObject2 instanceof InputMethodManager)) {
        localObject1 = null;
      }
      localObject1 = (InputMethodManager)localObject1;
      if (localObject1 != null) {
        break label78;
      }
    }
    label78:
    do
    {
      return;
      localObject2 = localActivity.getCurrentFocus();
    } while ((localObject2 == null) || (((View)localObject2).getWindowToken() == null));
    ((InputMethodManager)localObject1).toggleSoftInput(0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.k
 * JD-Core Version:    0.7.0.1
 */