package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webwx.a.c;

final class ExtDeviceWXLoginUI$7
  implements DialogInterface.OnCancelListener
{
  ExtDeviceWXLoginUI$7(ExtDeviceWXLoginUI paramExtDeviceWXLoginUI, c paramc) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().c(this.rDX);
    if (ExtDeviceWXLoginUI.e(this.rDV) != null) {
      ExtDeviceWXLoginUI.e(this.rDV).cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.7
 * JD-Core Version:    0.7.0.1
 */