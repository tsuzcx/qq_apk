package com.tencent.mm.plugin.recharge.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallEditText$1
  implements TextWatcher
{
  MallEditText$1(MallEditText paramMallEditText) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(44208);
    String str = paramCharSequence.toString();
    paramInt2 = MallEditText.a(this.pVy).getSelectionStart();
    paramCharSequence = "";
    paramInt1 = paramInt2;
    int i;
    if (str != null)
    {
      paramCharSequence = new StringBuilder(str.replaceAll(" ", ""));
      paramInt1 = paramCharSequence.length();
      if (paramInt1 >= 4) {
        paramCharSequence.insert(3, ' ');
      }
      if (paramInt1 >= 8) {
        paramCharSequence.insert(8, ' ');
      }
      paramCharSequence = paramCharSequence.toString();
      i = paramCharSequence.length();
      if (i <= MallEditText.b(this.pVy)) {
        break label215;
      }
      if (((paramInt2 != 4) && (paramInt2 != 9)) || (paramInt3 != 1)) {
        break label186;
      }
      paramInt1 = paramInt2 + 1;
    }
    for (;;)
    {
      MallEditText.a(this.pVy, i);
      if (str.equals(paramCharSequence)) {
        break label272;
      }
      MallEditText.a(this.pVy).setText(paramCharSequence);
      if (paramInt1 >= MallEditText.b(this.pVy)) {
        break;
      }
      MallEditText.a(this.pVy).setSelection(paramInt1);
      AppMethodBeat.o(44208);
      return;
      label186:
      if (paramInt2 != 4)
      {
        paramInt1 = paramInt2;
        if (paramInt2 != 9) {}
      }
      else
      {
        paramInt1 = paramInt2;
        if (paramInt3 > 1)
        {
          paramInt1 = paramInt2 + paramInt3;
          continue;
          label215:
          paramInt1 = paramInt2;
          if (i < MallEditText.b(this.pVy)) {
            if (paramInt2 != 4)
            {
              paramInt1 = paramInt2;
              if (paramInt2 != 9) {}
            }
            else
            {
              paramInt1 = paramInt2 - 1;
            }
          }
        }
      }
    }
    MallEditText.a(this.pVy).setSelection(MallEditText.b(this.pVy));
    AppMethodBeat.o(44208);
    return;
    label272:
    MallEditText.c(this.pVy);
    AppMethodBeat.o(44208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText.1
 * JD-Core Version:    0.7.0.1
 */