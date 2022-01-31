package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.w;

public class WebViewTestUI
  extends MMActivity
{
  private w iyq;
  MMWebViewWithJsApi vea;
  
  public WebViewTestUI()
  {
    AppMethodBeat.i(7805);
    this.iyq = new WebViewTestUI.1(this);
    AppMethodBeat.o(7805);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7806);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("rawUrl");
    this.vea = MMWebViewWithJsApi.a.fD(this);
    this.vea.setWebViewClient(this.iyq);
    setContentView(this.vea);
    this.vea.loadUrl(paramBundle);
    AppMethodBeat.o(7806);
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