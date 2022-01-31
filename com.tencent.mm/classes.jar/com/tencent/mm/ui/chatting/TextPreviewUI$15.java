package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TextPreviewUI$15
  implements View.OnTouchListener
{
  TextPreviewUI$15(TextPreviewUI paramTextPreviewUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(31059);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31059);
      return false;
      TextPreviewUI.a(this.zCJ, true);
      continue;
      if (!TextPreviewUI.e(this.zCJ))
      {
        TextPreviewUI.b(this.zCJ, true);
        TextPreviewUI.a(this.zCJ, true);
        continue;
        TextPreviewUI.a(this.zCJ, false);
        TextPreviewUI.b(this.zCJ, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.15
 * JD-Core Version:    0.7.0.1
 */