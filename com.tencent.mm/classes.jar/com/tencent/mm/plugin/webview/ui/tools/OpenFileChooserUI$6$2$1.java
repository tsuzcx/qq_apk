package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class OpenFileChooserUI$6$2$1
  implements DialogInterface.OnClickListener
{
  OpenFileChooserUI$6$2$1(OpenFileChooserUI.6.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7449);
    this.vbj.vbh.vbg.setResult(1);
    this.vbj.vbh.vbg.finish();
    AppMethodBeat.o(7449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6.2.1
 * JD-Core Version:    0.7.0.1
 */