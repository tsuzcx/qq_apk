package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMAppMgr$3
  implements DialogInterface.OnCancelListener
{
  MMAppMgr$3(Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(153810);
    this.gjR.onKeyDown(4, new KeyEvent(0, 4));
    AppMethodBeat.o(153810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.3
 * JD-Core Version:    0.7.0.1
 */