package com.tencent.mm.ui.chatting.viewitems;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.subapp.c.a;

final class ap$4$1$2
  implements DialogInterface.OnCancelListener
{
  ap$4$1$2(ap.4.1 param1, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(33387);
    aw.Rc().a(this.zYf);
    aw.Rc().b(331, ap.b(this.zYe.zYd.zYa));
    ap.a(this.zYe.zYd.zYa, null);
    if (ap.c(this.zYe.zYd.zYa) != null) {
      ap.c(this.zYe.zYd.zYa).dismiss();
    }
    AppMethodBeat.o(33387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.4.1.2
 * JD-Core Version:    0.7.0.1
 */