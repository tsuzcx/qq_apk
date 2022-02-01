package com.unionpay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k
  implements DialogInterface.OnClickListener
{
  k(i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(207273);
    UPPayWapActivity.a(this.aisS.aisR).dismiss();
    AppMethodBeat.o(207273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.k
 * JD-Core Version:    0.7.0.1
 */