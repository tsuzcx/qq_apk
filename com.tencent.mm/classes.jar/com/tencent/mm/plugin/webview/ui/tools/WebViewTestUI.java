package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;

public class WebViewTestUI
  extends MMActivity
{
  MMWebViewWithJsApi BgA;
  private ab lef;
  
  public WebViewTestUI()
  {
    AppMethodBeat.i(80040);
    this.lef = new ab()
    {
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(80039);
        super.b(paramAnonymousWebView, paramAnonymousString);
        AppMethodBeat.o(80039);
      }
    };
    AppMethodBeat.o(80040);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80041);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("rawUrl");
    this.BgA = MMWebViewWithJsApi.a.gJ(this);
    this.BgA.setWebViewClient(this.lef);
    setContentView(this.BgA);
    this.BgA.loadUrl(paramBundle);
    AppMethodBeat.o(80041);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewTestUI
 * JD-Core Version:    0.7.0.1
 */