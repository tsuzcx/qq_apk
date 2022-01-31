package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.y;

final class MMFormMobileInputView$2
  implements TextWatcher
{
  private ar fqH = new ar();
  
  MMFormMobileInputView$2(MMFormMobileInputView paramMMFormMobileInputView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    int i = MMFormMobileInputView.b(this.uVa).getSelectionEnd();
    paramEditable = MMFormMobileInputView.b(this.uVa).getText().toString();
    String str1 = MMFormMobileInputView.b(this.uVa).getText().toString().substring(0, i);
    String str2;
    if ((paramEditable != null) && (!paramEditable.equals(MMFormMobileInputView.c(this.uVa))))
    {
      str2 = MMFormMobileInputView.a(this.uVa).getText().toString();
      MMFormMobileInputView.a(this.uVa, ar.formatNumber(str2.replace("+", ""), paramEditable));
      MMFormMobileInputView.b(this.uVa, ar.formatNumber(str2.replace("+", ""), str1));
      if (!paramEditable.equals(MMFormMobileInputView.c(this.uVa))) {}
    }
    else
    {
      return;
    }
    MMFormMobileInputView.b(this.uVa).setText(MMFormMobileInputView.c(this.uVa));
    int j = MMFormMobileInputView.b(this.uVa).getText().toString().length();
    if (str1 != null)
    {
      try
      {
        MMFormMobileInputView.b(this.uVa, ar.formatNumber(str2.replace("+", ""), str1));
        if ((paramEditable.length() > 13) && (i <= j)) {
          break label293;
        }
        if ((i > j) || (MMFormMobileInputView.d(this.uVa).toString().length() > j))
        {
          MMFormMobileInputView.b(this.uVa).setSelection(j - Math.abs(paramEditable.length() - i));
          return;
        }
      }
      catch (Exception paramEditable)
      {
        y.printErrStackTrace("MicroMsg.MMFormMobileInputView", paramEditable, "", new Object[0]);
        return;
      }
      MMFormMobileInputView.b(this.uVa).setSelection(MMFormMobileInputView.d(this.uVa).toString().length());
      return;
      label293:
      MMFormMobileInputView.b(this.uVa).setSelection(str1.toString().length());
      return;
    }
    MMFormMobileInputView.b(this.uVa).setSelection(0);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormMobileInputView.2
 * JD-Core Version:    0.7.0.1
 */