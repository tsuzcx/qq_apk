package com.tencent.mm.plugin.nearby.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.applet.b;

final class NearbyFriendsUI$11
  implements View.OnTouchListener
{
  NearbyFriendsUI$11(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (NearbyFriendsUI.s(this.mDs) != null)
    {
      paramView = NearbyFriendsUI.s(this.mDs);
      if (paramView.ffG != null) {
        paramView.ffG.onTouchEvent(paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.11
 * JD-Core Version:    0.7.0.1
 */