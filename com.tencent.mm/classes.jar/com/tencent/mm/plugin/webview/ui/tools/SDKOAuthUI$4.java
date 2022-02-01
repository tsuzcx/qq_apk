package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class SDKOAuthUI$4
  implements DialogInterface.OnCancelListener
{
  SDKOAuthUI$4(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(79735);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(79735);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ae.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(79735);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.4
 * JD-Core Version:    0.7.0.1
 */