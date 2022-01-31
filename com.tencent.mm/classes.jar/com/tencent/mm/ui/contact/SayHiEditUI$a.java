package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class SayHiEditUI$a
  implements TextWatcher
{
  private boolean eKb = false;
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(33843);
    if (this.eKb)
    {
      AppMethodBeat.o(33843);
      return;
    }
    this.eKb = true;
    b.pgQ.ad(3, 2, 10);
    AppMethodBeat.o(33843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SayHiEditUI.a
 * JD-Core Version:    0.7.0.1
 */