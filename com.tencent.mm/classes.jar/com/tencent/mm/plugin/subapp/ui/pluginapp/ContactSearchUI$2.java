package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.bk;

final class ContactSearchUI$2
  implements TextView.OnEditorActionListener
{
  ContactSearchUI$2(ContactSearchUI paramContactSearchUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66) && (!bk.bl(ContactSearchUI.a(this.pxO).getText().toString().trim()))) {
      ContactSearchUI.b(this.pxO);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI.2
 * JD-Core Version:    0.7.0.1
 */