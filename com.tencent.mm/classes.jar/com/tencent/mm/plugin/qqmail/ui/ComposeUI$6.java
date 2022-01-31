package com.tencent.mm.plugin.qqmail.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ComposeUI$6
  implements View.OnTouchListener
{
  ComposeUI$6(ComposeUI paramComposeUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(68172);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(68172);
      return false;
      if (!paramView.hasFocus()) {
        paramView.requestFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.6
 * JD-Core Version:    0.7.0.1
 */