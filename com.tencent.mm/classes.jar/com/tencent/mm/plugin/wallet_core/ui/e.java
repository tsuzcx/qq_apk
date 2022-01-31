package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

public final class e
  extends p
{
  private Context context;
  
  public e(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    paramWebView = new Intent();
    paramWebView.putExtra("rawUrl", paramString);
    y.d("MicroMsg.ProtoColWebViewClient", "raw url: %s", new Object[] { paramWebView.getStringExtra("rawUrl") });
    d.b(this.context, "webview", ".ui.tools.WebViewUI", paramWebView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */