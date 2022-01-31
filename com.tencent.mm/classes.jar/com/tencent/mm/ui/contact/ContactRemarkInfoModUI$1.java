package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ContactRemarkInfoModUI$1
  implements TextWatcher
{
  ContactRemarkInfoModUI$1(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(33628);
    ContactRemarkInfoModUI.a(this.Acv);
    AppMethodBeat.o(33628);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.1
 * JD-Core Version:    0.7.0.1
 */