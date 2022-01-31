package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class k$4
  implements DialogInterface.OnClickListener
{
  k$4(k paramk, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49044);
    ab.i("MicroMsg.JumpRemind", "onClick2");
    if ((this.AWR.AWN != null) && (this.AWR.AWN.tMg.equals("left_button_wording")))
    {
      this.AWR.iK(this.gjR);
      AppMethodBeat.o(49044);
      return;
    }
    this.AWR.AWO.onCancel();
    AppMethodBeat.o(49044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.k.4
 * JD-Core Version:    0.7.0.1
 */