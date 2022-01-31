package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mm.ui.tools.f;

final class ContactRemarkInfoModUI$b
  implements TextWatcher
{
  private int nRO = 800;
  private String vKV = "";
  
  private ContactRemarkInfoModUI$b(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    this.nRO = f.bi(800, paramEditable.toString());
    if (this.nRO < 0) {
      this.nRO = 0;
    }
    if (ContactRemarkInfoModUI.a(this.vKT) != null) {
      ContactRemarkInfoModUI.a(this.vKT).setText(this.nRO);
    }
    ContactRemarkInfoModUI.b(this.vKT);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.b
 * JD-Core Version:    0.7.0.1
 */