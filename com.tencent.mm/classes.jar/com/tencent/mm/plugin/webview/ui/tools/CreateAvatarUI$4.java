package com.tencent.mm.plugin.webview.ui.tools;

import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CreateAvatarUI$4
  implements TextView.OnEditorActionListener
{
  CreateAvatarUI$4(CreateAvatarUI paramCreateAvatarUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(7356);
    if ((paramInt == 6) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      CreateAvatarUI.a(this.vam, (InputMethodManager)this.vam.getSystemService("input_method"));
      if ((CreateAvatarUI.a(this.vam) != null) && (CreateAvatarUI.a(this.vam).isActive()))
      {
        CreateAvatarUI.a(this.vam).hideSoftInputFromWindow(this.vam.getCurrentFocus().getWindowToken(), 0);
        CreateAvatarUI.b(this.vam).setCursorVisible(false);
        this.vam.getWindow().getDecorView().requestFocus();
      }
    }
    AppMethodBeat.o(7356);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.4
 * JD-Core Version:    0.7.0.1
 */