package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class MMFormMobileInputView$3
  implements TextWatcher
{
  MMFormMobileInputView$3(MMFormMobileInputView paramMMFormMobileInputView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(106573);
    paramEditable = MMFormMobileInputView.a(this.zjv).getText().toString();
    if (bo.isNullOrNil(paramEditable))
    {
      MMFormMobileInputView.a(this.zjv).setText("+");
      MMFormMobileInputView.a(this.zjv).setSelection(MMFormMobileInputView.a(this.zjv).getText().toString().length());
    }
    do
    {
      do
      {
        for (;;)
        {
          if (MMFormMobileInputView.e(this.zjv) != null) {
            MMFormMobileInputView.e(this.zjv);
          }
          AppMethodBeat.o(106573);
          return;
          if (paramEditable.contains("+")) {
            break;
          }
          paramEditable = "+".concat(String.valueOf(paramEditable));
          MMFormMobileInputView.a(this.zjv).setText(paramEditable);
          MMFormMobileInputView.a(this.zjv).setSelection(MMFormMobileInputView.a(this.zjv).getText().toString().length());
        }
      } while (paramEditable.length() <= 1);
      paramEditable = paramEditable.substring(1);
    } while (paramEditable.length() <= 4);
    MMFormMobileInputView.a(this.zjv).setText(paramEditable.substring(0, 4));
    AppMethodBeat.o(106573);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormMobileInputView.3
 * JD-Core Version:    0.7.0.1
 */