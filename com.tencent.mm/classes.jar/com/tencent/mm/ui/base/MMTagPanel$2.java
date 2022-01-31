package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;

final class MMTagPanel$2
  implements TextWatcher
{
  MMTagPanel$2(MMTagPanel paramMMTagPanel) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (MMTagPanel.e(this.uYn) != null) {
      MMTagPanel.e(this.uYn).Bf(paramEditable);
    }
    if (paramEditable.length() > 0) {
      this.uYn.cBd();
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.2
 * JD-Core Version:    0.7.0.1
 */