package com.tencent.mm.ui.base.preference;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AutoHintSizeEditText$1
  implements TextWatcher
{
  AutoHintSizeEditText$1(AutoHintSizeEditText paramAutoHintSizeEditText) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(107123);
    AutoHintSizeEditText.a(this.zqq, paramEditable, this.zqq.getHint(), this.zqq.getWidth() - this.zqq.getPaddingLeft() - this.zqq.getPaddingRight());
    AppMethodBeat.o(107123);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.AutoHintSizeEditText.1
 * JD-Core Version:    0.7.0.1
 */