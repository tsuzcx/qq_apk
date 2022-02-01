package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class SDKOAuthOtherUI$1
  implements DialogInterface.OnCancelListener
{
  SDKOAuthOtherUI$1(SDKOAuthOtherUI paramSDKOAuthOtherUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(79710);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(79710);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ae.e("MicroMsg.SDKOAuthOtherUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(79710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.1
 * JD-Core Version:    0.7.0.1
 */