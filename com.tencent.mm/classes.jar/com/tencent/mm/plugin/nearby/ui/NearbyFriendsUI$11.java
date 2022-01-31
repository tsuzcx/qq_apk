package com.tencent.mm.plugin.nearby.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.applet.b;

final class NearbyFriendsUI$11
  implements View.OnTouchListener
{
  NearbyFriendsUI$11(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(55452);
    if (NearbyFriendsUI.u(this.pdm) != null)
    {
      paramView = NearbyFriendsUI.u(this.pdm);
      if (paramView.gxo != null) {
        paramView.gxo.onTouchEvent(paramMotionEvent);
      }
    }
    AppMethodBeat.o(55452);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.11
 * JD-Core Version:    0.7.0.1
 */