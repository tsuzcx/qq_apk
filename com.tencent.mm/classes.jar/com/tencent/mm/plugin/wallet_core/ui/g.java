package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;

public final class g
  extends w
{
  private Context context;
  
  public g(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(47131);
    paramWebView = new Intent();
    paramWebView.putExtra("rawUrl", paramString);
    ab.d("MicroMsg.ProtoColWebViewClient", "raw url: %s", new Object[] { paramWebView.getStringExtra("rawUrl") });
    d.b(this.context, "webview", ".ui.tools.WebViewUI", paramWebView);
    AppMethodBeat.o(47131);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.g
 * JD-Core Version:    0.7.0.1
 */