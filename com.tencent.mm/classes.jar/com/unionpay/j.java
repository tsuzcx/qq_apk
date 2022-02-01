package com.unionpay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j
  implements DialogInterface.OnClickListener
{
  j(i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(207266);
    UPPayWapActivity.a(this.aisS.aisR, "cancel", null);
    AppMethodBeat.o(207266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.j
 * JD-Core Version:    0.7.0.1
 */