package com.tencent.mm.plugin.webview.ui.tools.game;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.xweb.WebView;

public class GameBaseWebViewUI
  extends WebViewUI
{
  private c kMB = new GameBaseWebViewUI.1(this);
  protected a rvQ;
  
  protected final void S(Bundle paramBundle)
  {
    this.kMB.rwj.ae(paramBundle);
  }
  
  protected final boolean aoZ()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    c.a(this.kMB.rwj.rwk);
    if (this.rvQ != null) {
      this.rvQ.onDestroy();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.kMB.rwj.onPause();
    if (this.rvQ != null) {
      this.rvQ.kMB.rwj.onPause();
    }
  }
  
  protected void onResume()
  {
    this.kMB.rwj.onResume();
    if (this.rvQ != null) {
      this.rvQ.kMB.rwj.onResume();
    }
    super.onResume();
  }
  
  protected class a
    extends WebViewUI.i
  {
    protected a()
    {
      super();
    }
    
    public void a(WebView paramWebView, String paramString)
    {
      super.a(paramWebView, paramString);
      GameBaseWebViewUI.c(GameBaseWebViewUI.this).rwj.cfQ();
    }
    
    public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      GameBaseWebViewUI.c(GameBaseWebViewUI.this).rwj.cfP();
      super.b(paramWebView, paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */