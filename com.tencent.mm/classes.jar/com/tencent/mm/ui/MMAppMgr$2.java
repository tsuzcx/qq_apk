package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMAppMgr$2
  implements DialogInterface.OnClickListener
{
  MMAppMgr$2(Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(153809);
    paramDialogInterface.dismiss();
    MMAppMgr.l(this.gjR, true);
    AppMethodBeat.o(153809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.2
 * JD-Core Version:    0.7.0.1
 */