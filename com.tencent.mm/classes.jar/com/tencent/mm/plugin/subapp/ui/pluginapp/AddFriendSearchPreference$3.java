package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

final class AddFriendSearchPreference$3
  implements View.OnTouchListener
{
  AddFriendSearchPreference$3(AddFriendSearchPreference paramAddFriendSearchPreference) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      AddFriendSearchPreference.c(this.pxC).onClick(paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference.3
 * JD-Core Version:    0.7.0.1
 */