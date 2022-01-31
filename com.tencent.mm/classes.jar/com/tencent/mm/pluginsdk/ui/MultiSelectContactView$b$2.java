package com.tencent.mm.pluginsdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MultiSelectContactView$b$2
  implements TextWatcher
{
  MultiSelectContactView$b$2(MultiSelectContactView.b paramb, MultiSelectContactView paramMultiSelectContactView) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(146169);
    MultiSelectContactView.c(this.vRo.vRm);
    if (MultiSelectContactView.d(this.vRo.vRm) != null) {
      MultiSelectContactView.d(this.vRo.vRm).Sk(paramCharSequence.toString());
    }
    AppMethodBeat.o(146169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b.2
 * JD-Core Version:    0.7.0.1
 */