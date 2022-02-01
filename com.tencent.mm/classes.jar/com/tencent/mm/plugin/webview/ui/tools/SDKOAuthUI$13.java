package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SDKOAuthUI$13
  implements View.OnTouchListener
{
  SDKOAuthUI$13(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79745);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79745);
      return false;
      SDKOAuthUI.b(this.Qcn, (int)paramMotionEvent.getRawX());
      SDKOAuthUI.c(this.Qcn, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.13
 * JD-Core Version:    0.7.0.1
 */