package com.tencent.mm.plugin.webview.core;

import android.content.Intent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/IWebViewUI;", "Lcom/tencent/mm/plugin/webview/core/IWebViewJsApiStub;", "currentURL", "", "getCurrentURL", "()Ljava/lang/String;", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "rawUrl", "getRawUrl", "getCachedAppId", "url", "getTransText", "", "content", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
  extends c
{
  public abstract String bjg(String paramString);
  
  public abstract void bjj(String paramString);
  
  public abstract String dgY();
  
  public abstract String fqa();
  
  public abstract Intent getIntent();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.d
 * JD-Core Version:    0.7.0.1
 */