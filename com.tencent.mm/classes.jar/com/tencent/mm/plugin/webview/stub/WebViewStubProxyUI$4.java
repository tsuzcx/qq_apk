package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.av.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

final class WebViewStubProxyUI$4
  implements av.a
{
  WebViewStubProxyUI$4(WebViewStubProxyUI paramWebViewStubProxyUI, p paramp) {}
  
  public final void ia(boolean paramBoolean)
  {
    AppMethodBeat.i(7072);
    if (this.lME != null) {
      this.lME.dismiss();
    }
    if (paramBoolean)
    {
      Bundle localBundle1;
      if (WebViewStubProxyUI.a(this.uZk) != null)
      {
        localBundle1 = new Bundle();
        localBundle1.putBoolean("add_shortcut_status", true);
      }
      try
      {
        WebViewStubProxyUI.a(this.uZk).i(54, localBundle1);
        h.a(this.uZk, 2131305996, 2131297087, false, new WebViewStubProxyUI.4.1(this));
        AppMethodBeat.o(7072);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ab.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + localException1.getMessage());
        }
      }
    }
    Toast.makeText(this.uZk.getContext(), this.uZk.getContext().getString(2131305995), 0).show();
    Bundle localBundle2;
    if (WebViewStubProxyUI.a(this.uZk) != null)
    {
      localBundle2 = new Bundle();
      localBundle2.putBoolean("add_shortcut_status", false);
    }
    try
    {
      WebViewStubProxyUI.a(this.uZk).i(54, localBundle2);
      this.uZk.finish();
      AppMethodBeat.o(7072);
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + localException2.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.4
 * JD-Core Version:    0.7.0.1
 */