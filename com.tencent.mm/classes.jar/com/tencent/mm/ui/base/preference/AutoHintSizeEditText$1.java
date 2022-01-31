package com.tencent.mm.ui.base.preference;

import android.text.Editable;
import android.text.TextWatcher;

final class AutoHintSizeEditText$1
  implements TextWatcher
{
  AutoHintSizeEditText$1(AutoHintSizeEditText paramAutoHintSizeEditText) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AutoHintSizeEditText.a(this.vbU, paramEditable, this.vbU.getHint(), this.vbU.getWidth() - this.vbU.getPaddingLeft() - this.vbU.getPaddingRight());
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.AutoHintSizeEditText.1
 * JD-Core Version:    0.7.0.1
 */