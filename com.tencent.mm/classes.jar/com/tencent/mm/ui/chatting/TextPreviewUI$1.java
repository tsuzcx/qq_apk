package com.tencent.mm.ui.chatting;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TextPreviewUI$1
  implements ViewTreeObserver.OnPreDrawListener
{
  TextPreviewUI$1(TextPreviewUI paramTextPreviewUI) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(31043);
    TextPreviewUI.a(this.zCJ).getViewTreeObserver().removeOnPreDrawListener(this);
    if (TextPreviewUI.a(this.zCJ).getLineCount() == 1) {
      TextPreviewUI.a(this.zCJ).setGravity(1);
    }
    AppMethodBeat.o(31043);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.1
 * JD-Core Version:    0.7.0.1
 */