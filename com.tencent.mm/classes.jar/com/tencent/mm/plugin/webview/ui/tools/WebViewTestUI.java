package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.p;

public class WebViewTestUI
  extends MMActivity
{
  private p gIG = new WebViewTestUI.1(this);
  MMWebViewWithJsApi rnp;
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("rawUrl");
    this.rnp = MMWebViewWithJsApi.a.eC(this);
    this.rnp.setWebViewClient(this.gIG);
    setContentView(this.rnp);
    this.rnp.loadUrl(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewTestUI
 * JD-Core Version:    0.7.0.1
 */