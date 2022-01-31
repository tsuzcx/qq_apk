package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$b$1
  implements DialogInterface.OnCancelListener
{
  c$b$1(c.b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(85176);
    this.BJm.BIO.aAd();
    AppMethodBeat.o(85176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.b.1
 * JD-Core Version:    0.7.0.1
 */