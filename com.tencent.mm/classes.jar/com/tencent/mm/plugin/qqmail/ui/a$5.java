package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.t;
import com.tencent.mm.ui.base.h;

final class a$5
  implements DialogInterface.OnClickListener
{
  a$5(a parama, boolean paramBoolean, EditText paramEditText) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new t(this.kaH, com.tencent.mm.a.g.o(this.nhq.getText().toString().trim().getBytes()));
    com.tencent.mm.kernel.g.DO().dJT.a(paramDialogInterface, 0);
    a locala = this.nho;
    Context localContext = a.a(this.nho);
    a.a(this.nho).getString(b.j.contact_info_qqmailhelper_enable);
    a.a(locala, h.b(localContext, a.a(this.nho).getString(b.j.app_waiting), true, new a.5.1(this, paramDialogInterface)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.a.5
 * JD-Core Version:    0.7.0.1
 */