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
    AppMethodBeat.i(7536);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(7536);
      return false;
      SDKOAuthUI.b(this.vbR, (int)paramMotionEvent.getRawX());
      SDKOAuthUI.c(this.vbR, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.13
 * JD-Core Version:    0.7.0.1
 */