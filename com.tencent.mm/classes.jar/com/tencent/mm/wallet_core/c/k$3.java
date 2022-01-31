package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class k$3
  implements DialogInterface.OnClickListener
{
  k$3(k paramk, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49043);
    ab.i("MicroMsg.JumpRemind", "onClick1 ");
    if ((this.AWR.AWN != null) && (this.AWR.AWN.tMg.equals("right_button_wording")))
    {
      this.AWR.iK(this.gjR);
      AppMethodBeat.o(49043);
      return;
    }
    this.AWR.AWO.onCancel();
    AppMethodBeat.o(49043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.k.3
 * JD-Core Version:    0.7.0.1
 */