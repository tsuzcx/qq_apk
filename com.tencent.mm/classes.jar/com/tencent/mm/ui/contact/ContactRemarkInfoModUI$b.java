package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.g;

final class ContactRemarkInfoModUI$b
  implements TextWatcher
{
  private int JeB = 800;
  private String Xsa = "";
  
  private ContactRemarkInfoModUI$b(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(37768);
    this.JeB = g.dq(800, paramEditable.toString());
    if (this.JeB < 0) {
      this.JeB = 0;
    }
    if (ContactRemarkInfoModUI.b(this.XrY) != null) {
      ContactRemarkInfoModUI.b(this.XrY).setText(this.JeB);
    }
    ContactRemarkInfoModUI.a(this.XrY);
    AppMethodBeat.o(37768);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.b
 * JD-Core Version:    0.7.0.1
 */