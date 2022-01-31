package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.ad;

final class WebWXLogoutUI$8$1
  implements DialogInterface.OnCancelListener
{
  WebWXLogoutUI$8$1(WebWXLogoutUI.8 param8, ad paramad) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(26545);
    aw.Rc().a(this.qHi);
    if (WebWXLogoutUI.i(this.vuL.vuJ) != null) {
      WebWXLogoutUI.i(this.vuL.vuJ).cancel();
    }
    AppMethodBeat.o(26545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.8.1
 * JD-Core Version:    0.7.0.1
 */