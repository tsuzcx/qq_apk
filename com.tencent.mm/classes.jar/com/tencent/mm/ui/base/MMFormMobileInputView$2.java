package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;

final class MMFormMobileInputView$2
  implements TextWatcher
{
  private av gIk;
  
  MMFormMobileInputView$2(MMFormMobileInputView paramMMFormMobileInputView)
  {
    AppMethodBeat.i(106571);
    this.gIk = new av();
    AppMethodBeat.o(106571);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(106572);
    int i = MMFormMobileInputView.b(this.zjv).getSelectionEnd();
    paramEditable = MMFormMobileInputView.b(this.zjv).getText().toString();
    String str1 = MMFormMobileInputView.b(this.zjv).getText().toString().substring(0, i);
    if ((paramEditable != null) && (!paramEditable.equals(MMFormMobileInputView.c(this.zjv))))
    {
      String str2 = MMFormMobileInputView.a(this.zjv).getText().toString();
      MMFormMobileInputView.a(this.zjv, av.formatNumber(str2.replace("+", ""), paramEditable));
      MMFormMobileInputView.b(this.zjv, av.formatNumber(str2.replace("+", ""), str1));
      if (paramEditable.equals(MMFormMobileInputView.c(this.zjv)))
      {
        AppMethodBeat.o(106572);
        return;
      }
      MMFormMobileInputView.b(this.zjv).setText(MMFormMobileInputView.c(this.zjv));
      int j = MMFormMobileInputView.b(this.zjv).getText().toString().length();
      if (str1 == null) {
        break label342;
      }
      try
      {
        MMFormMobileInputView.b(this.zjv, av.formatNumber(str2.replace("+", ""), str1));
        if ((paramEditable.length() > 13) && (i <= j)) {
          break label318;
        }
        if ((i <= j) && (MMFormMobileInputView.d(this.zjv).toString().length() <= j)) {
          break label289;
        }
        MMFormMobileInputView.b(this.zjv).setSelection(j - Math.abs(paramEditable.length() - i));
        AppMethodBeat.o(106572);
        return;
      }
      catch (Exception paramEditable)
      {
        ab.printErrStackTrace("MicroMsg.MMFormMobileInputView", paramEditable, "", new Object[0]);
      }
    }
    else
    {
      AppMethodBeat.o(106572);
      return;
    }
    label289:
    MMFormMobileInputView.b(this.zjv).setSelection(MMFormMobileInputView.d(this.zjv).toString().length());
    AppMethodBeat.o(106572);
    return;
    label318:
    MMFormMobileInputView.b(this.zjv).setSelection(str1.toString().length());
    AppMethodBeat.o(106572);
    return;
    label342:
    MMFormMobileInputView.b(this.zjv).setSelection(0);
    AppMethodBeat.o(106572);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormMobileInputView.2
 * JD-Core Version:    0.7.0.1
 */