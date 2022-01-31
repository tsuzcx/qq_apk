package com.tencent.mm.ui.chatting.viewitems;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.subapp.c.a;

final class am$4$1$2
  implements DialogInterface.OnCancelListener
{
  am$4$1$2(am.4.1 param1, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().c(this.vGJ);
    au.Dk().b(331, am.b(this.vGI.vGH.vGE));
    am.a(this.vGI.vGH.vGE, null);
    if (am.c(this.vGI.vGH.vGE) != null) {
      am.c(this.vGI.vGH.vGE).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.4.1.2
 * JD-Core Version:    0.7.0.1
 */