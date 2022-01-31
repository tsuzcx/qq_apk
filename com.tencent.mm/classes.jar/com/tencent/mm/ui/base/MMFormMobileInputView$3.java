package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bk;

final class MMFormMobileInputView$3
  implements TextWatcher
{
  MMFormMobileInputView$3(MMFormMobileInputView paramMMFormMobileInputView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    paramEditable = MMFormMobileInputView.a(this.uVa).getText().toString();
    if (bk.bl(paramEditable))
    {
      MMFormMobileInputView.a(this.uVa).setText("+");
      MMFormMobileInputView.a(this.uVa).setSelection(MMFormMobileInputView.a(this.uVa).getText().toString().length());
    }
    do
    {
      do
      {
        return;
        if (!paramEditable.contains("+"))
        {
          paramEditable = "+" + paramEditable;
          MMFormMobileInputView.a(this.uVa).setText(paramEditable);
          MMFormMobileInputView.a(this.uVa).setSelection(MMFormMobileInputView.a(this.uVa).getText().toString().length());
          return;
        }
      } while (paramEditable.length() <= 1);
      paramEditable = paramEditable.substring(1);
    } while (paramEditable.length() <= 4);
    MMFormMobileInputView.a(this.uVa).setText(paramEditable.substring(0, 4));
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormMobileInputView.3
 * JD-Core Version:    0.7.0.1
 */