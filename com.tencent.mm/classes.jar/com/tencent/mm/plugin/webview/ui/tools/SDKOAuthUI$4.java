package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SDKOAuthUI$4
  implements DialogInterface.OnCancelListener
{
  SDKOAuthUI$4(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(7527);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(7527);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ab.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(7527);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.4
 * JD-Core Version:    0.7.0.1
 */