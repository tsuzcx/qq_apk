package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class TextPreviewUI$15
  implements View.OnTouchListener
{
  TextPreviewUI$15(TextPreviewUI paramTextPreviewUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return false;
        TextPreviewUI.a(this.vnn, true);
        return false;
      } while (TextPreviewUI.e(this.vnn));
      TextPreviewUI.b(this.vnn, true);
      TextPreviewUI.a(this.vnn, true);
      return false;
    }
    TextPreviewUI.a(this.vnn, false);
    TextPreviewUI.b(this.vnn, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.15
 * JD-Core Version:    0.7.0.1
 */