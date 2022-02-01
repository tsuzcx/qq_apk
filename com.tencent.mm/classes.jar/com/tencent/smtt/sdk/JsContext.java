package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

public final class JsContext
{
  private final JsVirtualMachine a;
  private final IX5JsContext b;
  private ExceptionHandler c;
  private String d;
  
  public JsContext(Context paramContext)
  {
    this(new JsVirtualMachine(paramContext));
    AppMethodBeat.i(55066);
    AppMethodBeat.o(55066);
  }
  
  public JsContext(JsVirtualMachine paramJsVirtualMachine)
  {
    AppMethodBeat.i(55067);
    if (paramJsVirtualMachine == null)
    {
      paramJsVirtualMachine = new IllegalArgumentException("The virtualMachine value can not be null");
      AppMethodBeat.o(55067);
      throw paramJsVirtualMachine;
    }
    this.a = paramJsVirtualMachine;
    this.b = this.a.a();
    try
    {
      this.b.setPerContextData(this);
      AppMethodBeat.o(55067);
      return;
    }
    catch (AbstractMethodError paramJsVirtualMachine)
    {
      AppMethodBeat.o(55067);
    }
  }
  
  public static JsContext current()
  {
    AppMethodBeat.i(55082);
    JsContext localJsContext = (JsContext)X5JsCore.a();
    AppMethodBeat.o(55082);
    return localJsContext;
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(55068);
    this.b.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(55068);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(55069);
    this.b.destroy();
    AppMethodBeat.o(55069);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(55070);
    evaluateJavascript(paramString, paramValueCallback, null);
    AppMethodBeat.o(55070);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
  {
    AppMethodBeat.i(55071);
    this.b.evaluateJavascript(paramString, paramValueCallback, paramURL);
    AppMethodBeat.o(55071);
  }
  
  public final JsValue evaluateScript(String paramString)
  {
    AppMethodBeat.i(55072);
    paramString = evaluateScript(paramString, null);
    AppMethodBeat.o(55072);
    return paramString;
  }
  
  public final JsValue evaluateScript(String paramString, URL paramURL)
  {
    AppMethodBeat.i(55073);
    paramString = this.b.evaluateScript(paramString, paramURL);
    if (paramString == null)
    {
      AppMethodBeat.o(55073);
      return null;
    }
    paramString = new JsValue(this, paramString);
    AppMethodBeat.o(55073);
    return paramString;
  }
  
  public final void evaluateScriptAsync(String paramString, final ValueCallback<JsValue> paramValueCallback, URL paramURL)
  {
    AppMethodBeat.i(55074);
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new ValueCallback()
        {
          public void a(IX5JsValue paramAnonymousIX5JsValue)
          {
            AppMethodBeat.i(55318);
            ValueCallback localValueCallback = paramValueCallback;
            if (paramAnonymousIX5JsValue == null) {}
            for (paramAnonymousIX5JsValue = null;; paramAnonymousIX5JsValue = new JsValue(JsContext.this, paramAnonymousIX5JsValue))
            {
              localValueCallback.onReceiveValue(paramAnonymousIX5JsValue);
              AppMethodBeat.o(55318);
              return;
            }
          }
        })
    {
      this.b.evaluateScriptAsync(paramString, paramValueCallback, paramURL);
      AppMethodBeat.o(55074);
      return;
    }
  }
  
  public final ExceptionHandler exceptionHandler()
  {
    return this.c;
  }
  
  public final byte[] getNativeBuffer(int paramInt)
  {
    AppMethodBeat.i(55080);
    byte[] arrayOfByte = this.b.getNativeBuffer(paramInt);
    AppMethodBeat.o(55080);
    return arrayOfByte;
  }
  
  public final int getNativeBufferId()
  {
    AppMethodBeat.i(55079);
    int i = this.b.getNativeBufferId();
    AppMethodBeat.o(55079);
    return i;
  }
  
  public final String name()
  {
    return this.d;
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(55075);
    this.b.removeJavascriptInterface(paramString);
    AppMethodBeat.o(55075);
  }
  
  public final void setExceptionHandler(ExceptionHandler paramExceptionHandler)
  {
    AppMethodBeat.i(55076);
    this.c = paramExceptionHandler;
    if (paramExceptionHandler == null)
    {
      this.b.setExceptionHandler(null);
      AppMethodBeat.o(55076);
      return;
    }
    this.b.setExceptionHandler(new ValueCallback()
    {
      public void a(IX5JsError paramAnonymousIX5JsError)
      {
        AppMethodBeat.i(55021);
        JsContext.a(JsContext.this).handleException(JsContext.this, new JsError(paramAnonymousIX5JsError));
        AppMethodBeat.o(55021);
      }
    });
    AppMethodBeat.o(55076);
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(55077);
    this.d = paramString;
    this.b.setName(paramString);
    AppMethodBeat.o(55077);
  }
  
  public final int setNativeBuffer(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55081);
    paramInt = this.b.setNativeBuffer(paramInt, paramArrayOfByte);
    AppMethodBeat.o(55081);
    return paramInt;
  }
  
  public final void stealValueFromOtherCtx(String paramString1, JsContext paramJsContext, String paramString2)
  {
    AppMethodBeat.i(55078);
    this.b.stealValueFromOtherCtx(paramString1, paramJsContext.b, paramString2);
    AppMethodBeat.o(55078);
  }
  
  public final JsVirtualMachine virtualMachine()
  {
    return this.a;
  }
  
  public static abstract interface ExceptionHandler
  {
    public abstract void handleException(JsContext paramJsContext, JsError paramJsError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsContext
 * JD-Core Version:    0.7.0.1
 */