package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import com.tencent.mm.model.bt;
import com.tencent.mm.ui.base.h.c;

final class VcardContactUI$4
  implements h.c
{
  VcardContactUI$4(VcardContactUI paramVcardContactUI) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      bt.If().d(10238, new Object[] { Integer.valueOf(1) });
      localIntent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
      VcardContactUI.a(this.nOb, localIntent);
      this.nOb.startActivity(localIntent);
      return;
    }
    bt.If().d(10239, new Object[] { Integer.valueOf(1) });
    Intent localIntent = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
    localIntent.setType("vnd.android.cursor.item/person");
    VcardContactUI.a(this.nOb, localIntent);
    this.nOb.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI.4
 * JD-Core Version:    0.7.0.1
 */