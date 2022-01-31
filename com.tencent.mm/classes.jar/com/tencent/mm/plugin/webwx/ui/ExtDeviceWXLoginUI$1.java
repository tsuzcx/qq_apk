package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.x;

final class ExtDeviceWXLoginUI$1
  implements View.OnClickListener
{
  ExtDeviceWXLoginUI$1(ExtDeviceWXLoginUI paramExtDeviceWXLoginUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("title", this.rDV.getString(R.l.webwx_login_msg_synchronize));
    paramView.putExtra("rawUrl", this.rDV.getString(R.l.extdevice_login_help_doc, new Object[] { x.cqJ() }));
    paramView.putExtra("showShare", false);
    paramView.putExtra("neverGetA8Key", true);
    d.b(this.rDV, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.1
 * JD-Core Version:    0.7.0.1
 */