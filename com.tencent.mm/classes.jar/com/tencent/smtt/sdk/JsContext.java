package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import java.net.URL;

public final class JsContext
{
  private final JsVirtualMachine a;
  private final IX5JsContext b;
  private JsContext.ExceptionHandler c;
  private String d;
  
  public JsContext(Context paramContext)
  {
    this(new JsVirtualMachine(paramContext));
  }
  
  public JsContext(JsVirtualMachine paramJsVirtualMachine)
  {
    if (paramJsVirtualMachine == null) {
      throw new IllegalArgumentException("The virtualMachine value can not be null");
    }
    this.a = paramJsVirtualMachine;
    this.b = this.a.a();
    try
    {
      this.b.setPerContextData(this);
      return;
    }
    catch (AbstractMethodError paramJsVirtualMachine) {}
  }
  
  public static JsContext current()
  {
    return (JsContext)X5JsCore.a();
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.b.addJavascriptInterface(paramObject, paramString);
  }
  
  public final void destroy()
  {
    this.b.destroy();
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString, paramValueCallback, null);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
  {
    this.b.evaluateJavascript(paramString, paramValueCallback, paramURL);
  }
  
  public final JsValue evaluateScript(String paramString)
  {
    return evaluateScript(paramString, null);
  }
  
  public final JsValue evaluateScript(String paramString, URL paramURL)
  {
    paramString = this.b.evaluateScript(paramString, paramURL);
    if (paramString == null) {
      return null;
    }
    return new JsValue(this, paramString);
  }
  
  public final void evaluateScriptAsync(String paramString, ValueCallback<JsValue> paramValueCallback, URL paramURL)
  {
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new c(this, paramValueCallback))
    {
      this.b.evaluateScriptAsync(paramString, paramValueCallback, paramURL);
      return;
    }
  }
  
  public final JsContext.ExceptionHandler exceptionHandler()
  {
    return this.c;
  }
  
  public final String name()
  {
    return this.d;
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    this.b.removeJavascriptInterface(paramString);
  }
  
  public final void setExceptionHandler(JsContext.ExceptionHandler paramExceptionHandler)
  {
    this.c = paramExceptionHandler;
    if (paramExceptionHandler == null)
    {
      this.b.setExceptionHandler(null);
      return;
    }
    this.b.setExceptionHandler(new d(this));
  }
  
  public final void setName(String paramString)
  {
    this.d = paramString;
    this.b.setName(paramString);
  }
  
  public final void stealValueFromOtherCtx(String paramString1, JsContext paramJsContext, String paramString2)
  {
    this.b.stealValueFromOtherCtx(paramString1, paramJsContext.b, paramString2);
  }
  
  public final JsVirtualMachine virtualMachine()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsContext
 * JD-Core Version:    0.7.0.1
 */