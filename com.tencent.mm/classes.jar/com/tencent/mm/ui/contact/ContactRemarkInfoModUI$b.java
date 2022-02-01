package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.f;

final class ContactRemarkInfoModUI$b
  implements TextWatcher
{
  private int CYV = 800;
  private String PVm = "";
  
  private ContactRemarkInfoModUI$b(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(37768);
    this.CYV = f.dp(800, paramEditable.toString());
    if (this.CYV < 0) {
      this.CYV = 0;
    }
    if (ContactRemarkInfoModUI.b(this.PVk) != null) {
      ContactRemarkInfoModUI.b(this.PVk).setText(this.CYV);
    }
    ContactRemarkInfoModUI.a(this.PVk);
    AppMethodBeat.o(37768);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.b
 * JD-Core Version:    0.7.0.1
 */