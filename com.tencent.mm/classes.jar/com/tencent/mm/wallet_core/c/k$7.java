package com.tencent.mm.wallet_core.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class k$7
  implements DialogInterface.OnClickListener
{
  k$7(k paramk, g paramg) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49049);
    ab.i("MicroMsg.JumpRemind", "onClick2");
    if ((this.AWR.AWN != null) && (this.AWR.AWN.tMg.equals("left_button_wording")))
    {
      this.AWU.aQ(this.AWR.AWN.type, this.AWR.AWN.path);
      AppMethodBeat.o(49049);
      return;
    }
    this.AWU.onCancel();
    AppMethodBeat.o(49049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.k.7
 * JD-Core Version:    0.7.0.1
 */