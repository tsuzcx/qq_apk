package com.tencent.mm.pluginsdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bk;

final class MMPhoneNumberEditText$2
  implements TextWatcher
{
  MMPhoneNumberEditText$2(MMPhoneNumberEditText paramMMPhoneNumberEditText) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (bk.bl(paramCharSequence.toString()))
    {
      MMPhoneNumberEditText.a(this.saj, true);
      return;
    }
    MMPhoneNumberEditText.a(this.saj, false);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    MMPhoneNumberEditText.c(this.saj);
    if ((paramCharSequence.toString().equals("")) && (!MMPhoneNumberEditText.d(this.saj))) {
      if ((MMPhoneNumberEditText.b(this.saj) != null) && (this.saj.isFocused())) {
        MMPhoneNumberEditText.b(this.saj).g(this.saj);
      }
    }
    do
    {
      do
      {
        return;
        if ((paramCharSequence.toString().equals("")) || (!MMPhoneNumberEditText.d(this.saj))) {
          break;
        }
      } while ((MMPhoneNumberEditText.b(this.saj) == null) || (!this.saj.isFocused()));
      MMPhoneNumberEditText.b(this.saj).cmo();
      return;
    } while ((MMPhoneNumberEditText.b(this.saj) == null) || (!this.saj.isFocused()));
    MMPhoneNumberEditText.b(this.saj).cmp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.2
 * JD-Core Version:    0.7.0.1
 */