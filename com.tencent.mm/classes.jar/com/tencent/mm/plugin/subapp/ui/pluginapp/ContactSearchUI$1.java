package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.text.Editable;
import android.text.TextWatcher;

final class ContactSearchUI$1
  implements TextWatcher
{
  ContactSearchUI$1(ContactSearchUI paramContactSearchUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    ContactSearchUI localContactSearchUI = this.pxO;
    if (paramEditable.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localContactSearchUI.enableOptionMenu(bool);
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI.1
 * JD-Core Version:    0.7.0.1
 */