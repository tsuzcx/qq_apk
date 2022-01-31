package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class n$4
  implements DialogInterface.OnCancelListener
{
  n$4(n paramn, n.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
    this.rCS.e(3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.4
 * JD-Core Version:    0.7.0.1
 */