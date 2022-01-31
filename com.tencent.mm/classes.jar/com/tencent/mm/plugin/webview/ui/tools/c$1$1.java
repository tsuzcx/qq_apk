package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$1$1
  implements DialogInterface.OnCancelListener
{
  c$1$1(c.1 param1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      y.e("MicroMsg.OAuthSession", "onCancel, ex = " + paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.1.1
 * JD-Core Version:    0.7.0.1
 */