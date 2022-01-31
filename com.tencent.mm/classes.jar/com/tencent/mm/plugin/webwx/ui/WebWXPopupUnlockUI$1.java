package com.tencent.mm.plugin.webwx.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webwx.a;
import com.tencent.mm.plugin.webwx.a.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.y;

final class WebWXPopupUnlockUI$1
  implements View.OnClickListener
{
  WebWXPopupUnlockUI$1(WebWXPopupUnlockUI paramWebWXPopupUnlockUI, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    paramView = new b(2);
    au.Dk().a(paramView, 0);
    y.d("MicroMsg.WebWxPopUnlockUI", "doScene netSceneExtDeviceControl : UNLOCK");
    a.eUS.es(1);
    y.d("MicroMsg.WebWxPopUnlockUI", "trigger netSceneSync notify");
    this.lgi.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI.1
 * JD-Core Version:    0.7.0.1
 */