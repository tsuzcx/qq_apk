package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$h$4
  implements DialogInterface.OnClickListener
{
  WebViewUI$h$4(WebViewUI.h paramh, GeolocationPermissions.Callback paramCallback, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel, origin = %s");
    this.rqH.invoke(this.rqI, false, false);
    e.a(this.rqJ.rpH.gGn, 14340, new Object[] { this.rqJ.rpH.caS, this.rqJ.rpH.cdR(), Integer.valueOf(WebViewUI.d(this.rqJ.rpH)), this.rqJ.rpH.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(an.ccb()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h.4
 * JD-Core Version:    0.7.0.1
 */