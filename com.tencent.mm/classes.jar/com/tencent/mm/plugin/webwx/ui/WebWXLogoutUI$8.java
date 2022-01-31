package com.tencent.mm.plugin.webwx.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.ui.base.h;

final class WebWXLogoutUI$8
  implements DialogInterface.OnClickListener
{
  WebWXLogoutUI$8(WebWXLogoutUI paramWebWXLogoutUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(26546);
    paramDialogInterface = new ad(1);
    aw.Rc().a(paramDialogInterface, 0);
    WebWXLogoutUI localWebWXLogoutUI = this.vuJ;
    AppCompatActivity localAppCompatActivity = this.vuJ.getContext();
    this.vuJ.getString(2131297087);
    WebWXLogoutUI.a(localWebWXLogoutUI, h.b(localAppCompatActivity, null, true, new WebWXLogoutUI.8.1(this, paramDialogInterface)));
    AppMethodBeat.o(26546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.8
 * JD-Core Version:    0.7.0.1
 */