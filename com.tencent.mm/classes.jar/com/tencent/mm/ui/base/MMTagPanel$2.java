package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMTagPanel$2
  implements TextWatcher
{
  MMTagPanel$2(MMTagPanel paramMMTagPanel) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(106811);
    paramEditable = paramEditable.toString();
    if (MMTagPanel.e(this.zmE) != null) {
      MMTagPanel.e(this.zmE).Lh(paramEditable);
    }
    if (paramEditable.length() > 0) {
      this.zmE.dEq();
    }
    AppMethodBeat.o(106811);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.2
 * JD-Core Version:    0.7.0.1
 */