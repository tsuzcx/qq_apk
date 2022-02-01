package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class SDKOAuthFriendUI$1
  implements DialogInterface.OnCancelListener
{
  SDKOAuthFriendUI$1(SDKOAuthFriendUI paramSDKOAuthFriendUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(79688);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(79688);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ae.e("MicroMsg.SDKOAuthFriendUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(79688);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.1
 * JD-Core Version:    0.7.0.1
 */