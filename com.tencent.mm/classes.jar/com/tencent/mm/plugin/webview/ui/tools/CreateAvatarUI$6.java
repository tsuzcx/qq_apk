package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

final class CreateAvatarUI$6
  implements View.OnTouchListener
{
  CreateAvatarUI$6(CreateAvatarUI paramCreateAvatarUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      CreateAvatarUI.b(this.rkL).setCursorVisible(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.6
 * JD-Core Version:    0.7.0.1
 */