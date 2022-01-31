package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.b.c;
import java.lang.ref.WeakReference;

final class a$9
  implements DialogInterface.OnClickListener
{
  a$9(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142478);
    paramDialogInterface.dismiss();
    this.ueQ.ueN.dismiss();
    if ((this.ueQ.ueK != null) && (this.ueQ.ueK.get() != null)) {
      ((MMActivity)this.ueQ.ueK.get()).finish();
    }
    this.ueQ.destory();
    AppMethodBeat.o(142478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.9
 * JD-Core Version:    0.7.0.1
 */