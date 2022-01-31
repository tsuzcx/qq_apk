package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class OpenFileChooserUI$2
  implements DialogInterface.OnCancelListener
{
  OpenFileChooserUI$2(OpenFileChooserUI paramOpenFileChooserUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(7443);
    this.vbg.setResult(0);
    this.vbg.finish();
    AppMethodBeat.o(7443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.2
 * JD-Core Version:    0.7.0.1
 */