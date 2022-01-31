package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class SDKOAuthUI$10
  implements DialogInterface.OnCancelListener
{
  SDKOAuthUI$10(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      y.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.10
 * JD-Core Version:    0.7.0.1
 */