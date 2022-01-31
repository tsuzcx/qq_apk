package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.base.model.d.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;

final class WebViewStubProxyUI$4
  implements d.a
{
  WebViewStubProxyUI$4(WebViewStubProxyUI paramWebViewStubProxyUI, p paramp) {}
  
  public final void el(boolean paramBoolean)
  {
    if (this.iat != null) {
      this.iat.dismiss();
    }
    if (paramBoolean)
    {
      Bundle localBundle1;
      if (WebViewStubProxyUI.a(this.rjS) != null)
      {
        localBundle1 = new Bundle();
        localBundle1.putBoolean("add_shortcut_status", true);
      }
      try
      {
        WebViewStubProxyUI.a(this.rjS).f(54, localBundle1);
        h.a(this.rjS, R.l.wv_add_shortcut_success, R.l.app_tip, false, new WebViewStubProxyUI.4.1(this));
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          y.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + localException1.getMessage());
        }
      }
    }
    Toast.makeText(this.rjS.mController.uMN, this.rjS.mController.uMN.getString(R.l.wv_add_shortcut_fail), 0).show();
    Bundle localBundle2;
    if (WebViewStubProxyUI.a(this.rjS) != null)
    {
      localBundle2 = new Bundle();
      localBundle2.putBoolean("add_shortcut_status", false);
    }
    try
    {
      WebViewStubProxyUI.a(this.rjS).f(54, localBundle2);
      this.rjS.finish();
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        y.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + localException2.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.4
 * JD-Core Version:    0.7.0.1
 */