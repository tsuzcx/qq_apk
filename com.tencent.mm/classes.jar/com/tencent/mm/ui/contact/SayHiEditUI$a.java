package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.normsg.a.b;

final class SayHiEditUI$a
  implements TextWatcher
{
  private boolean mTriggered = false;
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mTriggered) {
      return;
    }
    this.mTriggered = true;
    b.mGK.S(3, 2, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SayHiEditUI.a
 * JD-Core Version:    0.7.0.1
 */