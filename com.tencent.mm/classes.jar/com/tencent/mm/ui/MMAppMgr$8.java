package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMEntryLock;

final class MMAppMgr$8
  implements DialogInterface.OnDismissListener
{
  MMAppMgr$8(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(33410);
    MMEntryLock.unlock("show_wap_adviser");
    if (this.WRL != null) {
      this.WRL.onClick(paramDialogInterface, 0);
    }
    AppMethodBeat.o(33410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.8
 * JD-Core Version:    0.7.0.1
 */