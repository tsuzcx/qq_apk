package com.tencent.mm.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;

final class ah$3
  implements TextWatcher
{
  ah$3(ah paramah) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.length() > 0))
    {
      ah.c(this.uQD).setVisibility(0);
      return;
    }
    ah.c(this.uQD).setVisibility(8);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ah.3
 * JD-Core Version:    0.7.0.1
 */