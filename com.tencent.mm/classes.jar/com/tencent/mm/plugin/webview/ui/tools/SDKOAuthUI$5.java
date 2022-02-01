package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class SDKOAuthUI$5
  implements DialogInterface.OnCancelListener
{
  SDKOAuthUI$5(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(79736);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(79736);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ae.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(79736);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.5
 * JD-Core Version:    0.7.0.1
 */