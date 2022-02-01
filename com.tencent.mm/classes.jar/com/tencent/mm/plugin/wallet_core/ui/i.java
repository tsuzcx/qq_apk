package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;

public final class i
  extends ac
{
  private Context context;
  
  public i(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(70681);
    paramWebView = new Intent();
    paramWebView.putExtra("rawUrl", paramString);
    Log.d("MicroMsg.ProtoColWebViewClient", "raw url: %s", new Object[] { paramWebView.getStringExtra("rawUrl") });
    c.b(this.context, "webview", ".ui.tools.WebViewUI", paramWebView);
    AppMethodBeat.o(70681);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.i
 * JD-Core Version:    0.7.0.1
 */