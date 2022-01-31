package com.tencent.mm.plugin.recharge.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;

final class MallEditText$1
  implements TextWatcher
{
  MallEditText$1(MallEditText paramMallEditText) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = paramCharSequence.toString();
    paramInt2 = MallEditText.a(this.nqk).getSelectionStart();
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
      if (i <= MallEditText.b(this.nqk)) {
        break label205;
      }
      if (((paramInt2 != 4) && (paramInt2 != 9)) || (paramInt3 != 1)) {
        break label176;
      }
      paramInt1 = paramInt2 + 1;
    }
    for (;;)
    {
      MallEditText.a(this.nqk, i);
      if (str.equals(paramCharSequence)) {
        break label257;
      }
      MallEditText.a(this.nqk).setText(paramCharSequence);
      if (paramInt1 >= MallEditText.b(this.nqk)) {
        break;
      }
      MallEditText.a(this.nqk).setSelection(paramInt1);
      return;
      label176:
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
          label205:
          paramInt1 = paramInt2;
          if (i < MallEditText.b(this.nqk)) {
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
    MallEditText.a(this.nqk).setSelection(MallEditText.b(this.nqk));
    return;
    label257:
    MallEditText.c(this.nqk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText.1
 * JD-Core Version:    0.7.0.1
 */