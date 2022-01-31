package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewUI$g$4
  implements DialogInterface.OnClickListener
{
  WebViewUI$g$4(WebViewUI.g paramg, GeolocationPermissions.Callback paramCallback, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7904);
    ab.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel");
    this.vgL.invoke(this.vgM, false, false);
    g.a(this.vgN.vgz.igU, 14340, new Object[] { this.vgN.vgz.cJr, this.vgN.vgz.dek(), Integer.valueOf(this.vgN.vgz.cNH), this.vgN.vgz.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(as.aDS()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(7904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.g.4
 * JD-Core Version:    0.7.0.1
 */