package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$2
  implements DialogInterface.OnClickListener
{
  i$2(i parami, GeolocationPermissions.Callback paramCallback, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(9904);
    this.vgL.invoke(this.vgM, false, false);
    AppMethodBeat.o(9904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.i.2
 * JD-Core Version:    0.7.0.1
 */