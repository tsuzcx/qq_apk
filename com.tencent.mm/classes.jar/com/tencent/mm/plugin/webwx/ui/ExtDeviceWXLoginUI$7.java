package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.webwx.a.c;

final class ExtDeviceWXLoginUI$7
  implements DialogInterface.OnCancelListener
{
  ExtDeviceWXLoginUI$7(ExtDeviceWXLoginUI paramExtDeviceWXLoginUI, c paramc) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(26527);
    aw.Rc().a(this.vuz);
    if (ExtDeviceWXLoginUI.f(this.vux) != null) {
      ExtDeviceWXLoginUI.f(this.vux).cancel();
    }
    AppMethodBeat.o(26527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.7
 * JD-Core Version:    0.7.0.1
 */