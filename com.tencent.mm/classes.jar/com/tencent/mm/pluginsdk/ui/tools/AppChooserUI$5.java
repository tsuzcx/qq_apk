package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppChooserUI$5
  implements DialogInterface.OnDismissListener
{
  AppChooserUI$5(AppChooserUI paramAppChooserUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125858);
    this.wdL.finish();
    AppMethodBeat.o(125858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.5
 * JD-Core Version:    0.7.0.1
 */