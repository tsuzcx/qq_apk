package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;

final class MMAutoCompleteTextView$2
  implements TextWatcher
{
  MMAutoCompleteTextView$2(MMAutoCompleteTextView paramMMAutoCompleteTextView) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    MMAutoCompleteTextView.b(this.uUi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoCompleteTextView.2
 * JD-Core Version:    0.7.0.1
 */