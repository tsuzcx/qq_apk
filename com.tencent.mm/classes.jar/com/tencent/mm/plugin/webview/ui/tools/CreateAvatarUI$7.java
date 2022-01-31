package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CreateAvatarUI$7
  implements View.OnTouchListener
{
  CreateAvatarUI$7(CreateAvatarUI paramCreateAvatarUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7359);
    if (paramMotionEvent.getAction() == 0) {
      CreateAvatarUI.b(this.vam).setCursorVisible(true);
    }
    AppMethodBeat.o(7359);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.7
 * JD-Core Version:    0.7.0.1
 */