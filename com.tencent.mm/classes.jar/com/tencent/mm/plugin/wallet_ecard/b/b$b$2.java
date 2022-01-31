package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class b$b$2
  implements DialogInterface.OnClickListener
{
  b$b$2(b.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48076);
    this.uzt.uzs.b(this.uzt.hwZ, null);
    this.uzt.hwZ.finish();
    AppMethodBeat.o(48076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.b.2
 * JD-Core Version:    0.7.0.1
 */