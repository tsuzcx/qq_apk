package com.tencent.mm.plugin.recharge.ui.form;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class c$b$1
  implements TextWatcher
{
  private int nqj = 0;
  
  public c$b$1(c.b paramb) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = paramCharSequence.toString();
    paramInt2 = this.nrS.nrP.getContentEditText().getSelectionStart();
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
      if (i <= this.nqj) {
        break label204;
      }
      if (((paramInt2 != 4) && (paramInt2 != 9)) || (paramInt3 != 1)) {
        break label175;
      }
      paramInt1 = paramInt2 + 1;
    }
    for (;;)
    {
      this.nqj = i;
      if (!str.equals(paramCharSequence))
      {
        this.nrS.nrP.getContentEditText().setText(paramCharSequence);
        if (paramInt1 >= this.nqj) {
          break;
        }
        this.nrS.nrP.getContentEditText().setSelection(paramInt1);
      }
      return;
      label175:
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
          label204:
          paramInt1 = paramInt2;
          if (i < this.nqj) {
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
    this.nrS.nrP.getContentEditText().setSelection(this.nqj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.c.b.1
 * JD-Core Version:    0.7.0.1
 */