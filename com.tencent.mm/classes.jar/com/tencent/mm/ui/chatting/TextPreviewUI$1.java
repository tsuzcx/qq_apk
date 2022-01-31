package com.tencent.mm.ui.chatting;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;

final class TextPreviewUI$1
  implements ViewTreeObserver.OnPreDrawListener
{
  TextPreviewUI$1(TextPreviewUI paramTextPreviewUI) {}
  
  public final boolean onPreDraw()
  {
    TextPreviewUI.a(this.vnn).getViewTreeObserver().removeOnPreDrawListener(this);
    if (TextPreviewUI.a(this.vnn).getLineCount() == 1) {
      TextPreviewUI.a(this.vnn).setGravity(1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.1
 * JD-Core Version:    0.7.0.1
 */