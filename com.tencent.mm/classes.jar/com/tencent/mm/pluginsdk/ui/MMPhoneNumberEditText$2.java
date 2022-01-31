package com.tencent.mm.pluginsdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class MMPhoneNumberEditText$2
  implements TextWatcher
{
  MMPhoneNumberEditText$2(MMPhoneNumberEditText paramMMPhoneNumberEditText) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(27493);
    if (bo.isNullOrNil(paramCharSequence.toString()))
    {
      MMPhoneNumberEditText.a(this.vQZ, true);
      AppMethodBeat.o(27493);
      return;
    }
    MMPhoneNumberEditText.a(this.vQZ, false);
    AppMethodBeat.o(27493);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(27492);
    MMPhoneNumberEditText.c(this.vQZ);
    if ((paramCharSequence.toString().equals("")) && (!MMPhoneNumberEditText.d(this.vQZ)))
    {
      if ((MMPhoneNumberEditText.b(this.vQZ) != null) && (this.vQZ.isFocused()))
      {
        MMPhoneNumberEditText.b(this.vQZ).g(this.vQZ);
        AppMethodBeat.o(27492);
      }
    }
    else if ((!paramCharSequence.toString().equals("")) && (MMPhoneNumberEditText.d(this.vQZ)))
    {
      if ((MMPhoneNumberEditText.b(this.vQZ) != null) && (this.vQZ.isFocused()))
      {
        MMPhoneNumberEditText.b(this.vQZ).dne();
        AppMethodBeat.o(27492);
      }
    }
    else if ((MMPhoneNumberEditText.b(this.vQZ) != null) && (this.vQZ.isFocused())) {
      MMPhoneNumberEditText.b(this.vQZ).dnf();
    }
    AppMethodBeat.o(27492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.2
 * JD-Core Version:    0.7.0.1
 */