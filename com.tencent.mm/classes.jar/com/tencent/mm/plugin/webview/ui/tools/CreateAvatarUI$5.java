package com.tencent.mm.plugin.webview.ui.tools;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CreateAvatarUI$5
  implements View.OnKeyListener
{
  CreateAvatarUI$5(CreateAvatarUI paramCreateAvatarUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(7357);
    if (paramInt == 4)
    {
      CreateAvatarUI.a(this.vam, (InputMethodManager)this.vam.getSystemService("input_method"));
      if ((CreateAvatarUI.a(this.vam) != null) && (CreateAvatarUI.a(this.vam).isActive()))
      {
        CreateAvatarUI.a(this.vam).hideSoftInputFromWindow(this.vam.getCurrentFocus().getWindowToken(), 0);
        CreateAvatarUI.b(this.vam).setCursorVisible(false);
        this.vam.getWindow().getDecorView().requestFocus();
      }
    }
    AppMethodBeat.o(7357);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.5
 * JD-Core Version:    0.7.0.1
 */