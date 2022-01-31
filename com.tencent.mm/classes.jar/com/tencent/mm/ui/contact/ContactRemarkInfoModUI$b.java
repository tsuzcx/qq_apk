package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.f;

final class ContactRemarkInfoModUI$b
  implements TextWatcher
{
  private String Acx = "";
  private int qFM = 800;
  
  private ContactRemarkInfoModUI$b(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(33648);
    this.qFM = f.bO(800, paramEditable.toString());
    if (this.qFM < 0) {
      this.qFM = 0;
    }
    if (ContactRemarkInfoModUI.b(this.Acv) != null) {
      ContactRemarkInfoModUI.b(this.Acv).setText(this.qFM);
    }
    ContactRemarkInfoModUI.a(this.Acv);
    AppMethodBeat.o(33648);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.b
 * JD-Core Version:    0.7.0.1
 */