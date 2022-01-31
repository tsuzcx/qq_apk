package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.GridView;

final class SettingsTrustFriendUI$7
  implements View.OnTouchListener
{
  SettingsTrustFriendUI$7(SettingsTrustFriendUI paramSettingsTrustFriendUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((SettingsTrustFriendUI.b(this.nWp)) && (paramMotionEvent.getAction() == 1) && (SettingsTrustFriendUI.d(this.nWp).pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1))
    {
      SettingsTrustFriendUI.a(this.nWp, false);
      SettingsTrustFriendUI.c(this.nWp).notifyDataSetChanged();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.7
 * JD-Core Version:    0.7.0.1
 */