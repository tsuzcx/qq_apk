package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsEditText$1
  implements TextWatcher
{
  SnsEditText$1(SnsEditText paramSnsEditText) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38931);
    if (paramCharSequence != null) {
      SnsEditText.b(this.rQz, paramCharSequence.length());
    }
    AppMethodBeat.o(38931);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38930);
    try
    {
      if (SnsEditText.a(this.rQz))
      {
        if ((paramCharSequence == null) || (paramCharSequence.length() < a.raX))
        {
          SnsEditText.a(this.rQz, 0);
          AppMethodBeat.o(38930);
          return;
        }
        if (paramCharSequence.length() - SnsEditText.b(this.rQz) > a.raX) {
          SnsEditText.a(this.rQz, paramCharSequence.length() - SnsEditText.b(this.rQz));
        }
      }
      AppMethodBeat.o(38930);
      return;
    }
    catch (Exception paramCharSequence)
    {
      ab.printErrStackTrace("MicroMsg.SnsEditText", paramCharSequence, "", new Object[0]);
      AppMethodBeat.o(38930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsEditText.1
 * JD-Core Version:    0.7.0.1
 */