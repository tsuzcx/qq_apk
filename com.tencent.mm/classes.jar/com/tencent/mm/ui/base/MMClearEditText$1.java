package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMClearEditText$1
  implements TextWatcher
{
  MMClearEditText$1(MMClearEditText paramMMClearEditText) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106504);
    MMClearEditText.a(this.zja);
    AppMethodBeat.o(106504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText.1
 * JD-Core Version:    0.7.0.1
 */