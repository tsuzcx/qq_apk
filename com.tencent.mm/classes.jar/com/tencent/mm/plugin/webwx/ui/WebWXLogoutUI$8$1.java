package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.ac;

final class WebWXLogoutUI$8$1
  implements DialogInterface.OnCancelListener
{
  WebWXLogoutUI$8$1(WebWXLogoutUI.8 param8, ac paramac) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().c(this.nTi);
    if (WebWXLogoutUI.i(this.rEj.rEh) != null) {
      WebWXLogoutUI.i(this.rEj.rEh).cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.8.1
 * JD-Core Version:    0.7.0.1
 */