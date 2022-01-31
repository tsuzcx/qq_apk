package com.tencent.mm.plugin.webview.ui.tools;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

final class CreateAvatarUI$4
  implements View.OnKeyListener
{
  CreateAvatarUI$4(CreateAvatarUI paramCreateAvatarUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      CreateAvatarUI.a(this.rkL, (InputMethodManager)this.rkL.getSystemService("input_method"));
      if ((CreateAvatarUI.a(this.rkL) != null) && (CreateAvatarUI.a(this.rkL).isActive()))
      {
        CreateAvatarUI.a(this.rkL).hideSoftInputFromWindow(this.rkL.getCurrentFocus().getWindowToken(), 0);
        CreateAvatarUI.b(this.rkL).setCursorVisible(false);
        this.rkL.getWindow().getDecorView().requestFocus();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.4
 * JD-Core Version:    0.7.0.1
 */