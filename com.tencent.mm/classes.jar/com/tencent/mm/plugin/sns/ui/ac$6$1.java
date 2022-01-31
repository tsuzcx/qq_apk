package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class ac$6$1
  implements DialogInterface.OnCancelListener
{
  ac$6$1(ac.6 param6) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(38343);
    this.rIS.rIQ.rIM = null;
    this.rIS.rIQ.rIx = false;
    al.ae(this.rIS.rIQ.rIO);
    AppMethodBeat.o(38343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac.6.1
 * JD-Core Version:    0.7.0.1
 */