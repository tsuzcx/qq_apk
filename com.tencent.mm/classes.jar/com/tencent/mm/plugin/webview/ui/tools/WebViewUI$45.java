package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewUI$45
  implements DialogInterface.OnClickListener
{
  WebViewUI$45(WebViewUI paramWebViewUI, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(153259);
    if ((this.tyr != null) && (this.tyr.isChecked())) {}
    try
    {
      if (this.vgz.igU.ddb()) {
        this.vgz.igU.gN(327792, 1);
      }
      this.vgz.vfK = true;
      this.vgz.vfp = null;
      m.vdm.close();
      this.vgz.finish();
      AppMethodBeat.o(153259);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + paramDialogInterface.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.45
 * JD-Core Version:    0.7.0.1
 */