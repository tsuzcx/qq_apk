package com.tencent.mm.pluginsdk.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.ui.widget.MMEditText;

final class MultiSelectContactView$2
  implements View.OnKeyListener
{
  MultiSelectContactView$2(MultiSelectContactView paramMultiSelectContactView) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0) && (MultiSelectContactView.c(this.saw).getSelectionStart() == 0) && (MultiSelectContactView.c(this.saw).getSelectionEnd() == 0)) {
      MultiSelectContactView.d(this.saw);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView.2
 * JD-Core Version:    0.7.0.1
 */