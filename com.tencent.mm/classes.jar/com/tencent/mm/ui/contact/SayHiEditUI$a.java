package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;

final class SayHiEditUI$a
  implements TextWatcher
{
  private boolean keQ = false;
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(37964);
    if (this.keQ)
    {
      AppMethodBeat.o(37964);
      return;
    }
    this.keQ = true;
    d.GxJ.ay(3, 2, 10);
    AppMethodBeat.o(37964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SayHiEditUI.a
 * JD-Core Version:    0.7.0.1
 */