package com.tencent.mm.plugin.webview.ui.tools;

import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class CreateAvatarUI$3
  implements TextView.OnEditorActionListener
{
  CreateAvatarUI$3(CreateAvatarUI paramCreateAvatarUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.3
 * JD-Core Version:    0.7.0.1
 */