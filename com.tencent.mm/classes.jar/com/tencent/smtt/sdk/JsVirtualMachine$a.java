package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

class JsVirtualMachine$a
  implements IX5JsContext
{
  private WebView a;
  
  public JsVirtualMachine$a(Context paramContext)
  {
    this.a = new WebView(paramContext);
    this.a.getSettings().setJavaScriptEnabled(true);
  }
  
  public void a()
  {
    if (this.a == null) {
      return;
    }
    this.a.onPause();
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (this.a == null) {
      return;
    }
    this.a.addJavascriptInterface(paramObject, paramString);
    this.a.loadUrl("about:blank");
  }
  
  public void b()
  {
    if (this.a == null) {
      return;
    }
    this.a.onResume();
  }
  
  public void destroy()
  {
    if (this.a == null) {
      return;
    }
    this.a.clearHistory();
    this.a.clearCache(true);
    this.a.loadUrl("about:blank");
    this.a.freeMemory();
    this.a.pauseTimers();
    this.a.destroy();
    this.a = null;
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
  {
    if (this.a == null) {
      return;
    }
    paramURL = this.a;
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new e(this, paramValueCallback))
    {
      paramURL.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
  }
  
  public IX5JsValue evaluateScript(String paramString, URL paramURL)
  {
    if (this.a == null) {
      return null;
    }
    this.a.evaluateJavascript(paramString, null);
    return null;
  }
  
  public void evaluateScriptAsync(String paramString, ValueCallback<IX5JsValue> paramValueCallback, URL paramURL)
  {
    if (this.a == null) {
      return;
    }
    paramURL = this.a;
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new f(this, paramValueCallback))
    {
      paramURL.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    if (this.a == null) {
      return;
    }
    this.a.removeJavascriptInterface(paramString);
  }
  
  public void setExceptionHandler(ValueCallback<IX5JsError> paramValueCallback) {}
  
  public void setName(String paramString) {}
  
  public void setPerContextData(Object paramObject) {}
  
  public void stealValueFromOtherCtx(String paramString1, IX5JsContext paramIX5JsContext, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsVirtualMachine.a
 * JD-Core Version:    0.7.0.1
 */