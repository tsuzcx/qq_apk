package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(63961);
    this.a = new WebView(paramContext);
    this.a.getSettings().setJavaScriptEnabled(true);
    AppMethodBeat.o(63961);
  }
  
  public void a()
  {
    AppMethodBeat.i(63962);
    if (this.a == null)
    {
      AppMethodBeat.o(63962);
      return;
    }
    this.a.onPause();
    AppMethodBeat.o(63962);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(63964);
    if (this.a == null)
    {
      AppMethodBeat.o(63964);
      return;
    }
    this.a.addJavascriptInterface(paramObject, paramString);
    this.a.loadUrl("about:blank");
    AppMethodBeat.o(63964);
  }
  
  public void b()
  {
    AppMethodBeat.i(63963);
    if (this.a == null)
    {
      AppMethodBeat.o(63963);
      return;
    }
    this.a.onResume();
    AppMethodBeat.o(63963);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(63965);
    if (this.a == null)
    {
      AppMethodBeat.o(63965);
      return;
    }
    this.a.clearHistory();
    this.a.clearCache(true);
    this.a.loadUrl("about:blank");
    this.a.freeMemory();
    this.a.pauseTimers();
    this.a.destroy();
    this.a = null;
    AppMethodBeat.o(63965);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
  {
    AppMethodBeat.i(63966);
    if (this.a == null)
    {
      AppMethodBeat.o(63966);
      return;
    }
    paramURL = this.a;
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new e(this, paramValueCallback))
    {
      paramURL.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(63966);
      return;
    }
  }
  
  public IX5JsValue evaluateScript(String paramString, URL paramURL)
  {
    AppMethodBeat.i(63967);
    if (this.a == null)
    {
      AppMethodBeat.o(63967);
      return null;
    }
    this.a.evaluateJavascript(paramString, null);
    AppMethodBeat.o(63967);
    return null;
  }
  
  public void evaluateScriptAsync(String paramString, ValueCallback<IX5JsValue> paramValueCallback, URL paramURL)
  {
    AppMethodBeat.i(63968);
    if (this.a == null)
    {
      AppMethodBeat.o(63968);
      return;
    }
    paramURL = this.a;
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new f(this, paramValueCallback))
    {
      paramURL.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(63968);
      return;
    }
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    return null;
  }
  
  public int getNativeBufferId()
  {
    return -1;
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(63969);
    if (this.a == null)
    {
      AppMethodBeat.o(63969);
      return;
    }
    this.a.removeJavascriptInterface(paramString);
    AppMethodBeat.o(63969);
  }
  
  public void setExceptionHandler(ValueCallback<IX5JsError> paramValueCallback) {}
  
  public void setName(String paramString) {}
  
  public int setNativeBuffer(int paramInt, byte[] paramArrayOfByte)
  {
    return -1;
  }
  
  public void setPerContextData(Object paramObject) {}
  
  public void stealValueFromOtherCtx(String paramString1, IX5JsContext paramIX5JsContext, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsVirtualMachine.a
 * JD-Core Version:    0.7.0.1
 */