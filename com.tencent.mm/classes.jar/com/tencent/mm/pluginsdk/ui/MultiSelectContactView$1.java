package com.tencent.mm.pluginsdk.ui;

import android.text.Editable;
import android.text.TextWatcher;

final class MultiSelectContactView$1
  implements TextWatcher
{
  MultiSelectContactView$1(MultiSelectContactView paramMultiSelectContactView) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    MultiSelectContactView.a(this.saw);
    if (MultiSelectContactView.b(this.saw) != null) {
      MultiSelectContactView.b(this.saw).GH(paramCharSequence.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView.1
 * JD-Core Version:    0.7.0.1
 */