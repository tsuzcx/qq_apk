package com.tencent.mm.pluginsdk.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MultiSelectContactView$b$3
  implements View.OnKeyListener
{
  MultiSelectContactView$b$3(MultiSelectContactView.b paramb, MultiSelectContactView paramMultiSelectContactView) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(146170);
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0) && (this.vRo.vRm.getInputText().getSelectionStart() == 0) && (this.vRo.vRm.getInputText().getSelectionEnd() == 0)) {
      MultiSelectContactView.e(this.vRo.vRm);
    }
    AppMethodBeat.o(146170);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b.3
 * JD-Core Version:    0.7.0.1
 */