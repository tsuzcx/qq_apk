package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SDKOAuthFriendUI$1
  implements DialogInterface.OnCancelListener
{
  SDKOAuthFriendUI$1(SDKOAuthFriendUI paramSDKOAuthFriendUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(153175);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(153175);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ab.e("MicroMsg.SDKOAuthFriendUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(153175);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.1
 * JD-Core Version:    0.7.0.1
 */