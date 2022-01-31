package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49403);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(49403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.b.2
 * JD-Core Version:    0.7.0.1
 */