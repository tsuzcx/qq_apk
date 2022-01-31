package com.tencent.mm.plugin.qqmail.ui;

import android.text.Editable;
import android.text.TextWatcher;

final class MailAddrsViewControl$6
  implements TextWatcher
{
  MailAddrsViewControl$6(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = paramCharSequence.toString();
    if ((paramCharSequence.endsWith("\n")) || (paramCharSequence.endsWith(" "))) {
      MailAddrsViewControl.a(this.nir, paramCharSequence, true);
    }
    this.nir.buk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.6
 * JD-Core Version:    0.7.0.1
 */