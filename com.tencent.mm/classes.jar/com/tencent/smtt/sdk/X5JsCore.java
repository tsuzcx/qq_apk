package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreJsCore;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

public class X5JsCore
  extends x
{
  private static X5JsCore.a a = X5JsCore.a.a;
  private static X5JsCore.a b = X5JsCore.a.a;
  private static X5JsCore.a c = X5JsCore.a.a;
  private final Context d;
  private Object e;
  private WebView f;
  
  @Deprecated
  public X5JsCore(Context paramContext)
  {
    AppMethodBeat.i(54543);
    this.e = null;
    this.f = null;
    this.d = paramContext;
    if (canUseX5JsCore(paramContext))
    {
      Object localObject = b().createX5JavaBridge(paramContext);
      if (localObject != null)
      {
        this.e = localObject;
        AppMethodBeat.o(54543);
        return;
      }
    }
    this.f = new WebView(paramContext);
    this.f.getSettings().setJavaScriptEnabled(true);
    AppMethodBeat.o(54543);
  }
  
  protected static IX5JsVirtualMachine a(Context paramContext, Looper paramLooper)
  {
    AppMethodBeat.i(54541);
    if (canUseX5JsCore(paramContext))
    {
      paramContext = b().createX5JsVirtualMachine(paramContext, paramLooper);
      AppMethodBeat.o(54541);
      return paramContext;
    }
    AppMethodBeat.o(54541);
    return null;
  }
  
  protected static Object a()
  {
    AppMethodBeat.i(54542);
    Object localObject = b().currentContextData();
    AppMethodBeat.o(54542);
    return localObject;
  }
  
  private static IX5CoreJsCore b()
  {
    AppMethodBeat.i(54538);
    if (v.a().b())
    {
      IX5CoreJsCore localIX5CoreJsCore = getJSCoreImpl();
      AppMethodBeat.o(54538);
      return localIX5CoreJsCore;
    }
    AppMethodBeat.o(54538);
    return null;
  }
  
  public static boolean canUseX5JsCore(Context paramContext)
  {
    AppMethodBeat.i(54539);
    if (a != X5JsCore.a.a)
    {
      if (a == X5JsCore.a.c)
      {
        AppMethodBeat.o(54539);
        return true;
      }
      AppMethodBeat.o(54539);
      return false;
    }
    a = X5JsCore.a.b;
    if (b() == null) {}
    for (boolean bool = false; bool; bool = b().canUseX5JsCore(paramContext))
    {
      b().setJsValueFactory(JsValue.factory());
      a = X5JsCore.a.c;
      AppMethodBeat.o(54539);
      return true;
    }
    AppMethodBeat.o(54539);
    return false;
  }
  
  public static boolean canUseX5JsCoreNewAPI(Context paramContext)
  {
    AppMethodBeat.i(54537);
    if (c != X5JsCore.a.a)
    {
      if (c == X5JsCore.a.c)
      {
        AppMethodBeat.o(54537);
        return true;
      }
      AppMethodBeat.o(54537);
      return false;
    }
    c = X5JsCore.a.b;
    if (b() == null) {}
    for (boolean bool = false; bool; bool = b().canUseX5JsCoreNewAPI(paramContext))
    {
      c = X5JsCore.a.c;
      AppMethodBeat.o(54537);
      return true;
    }
    AppMethodBeat.o(54537);
    return false;
  }
  
  public static boolean canX5JsCoreUseNativeBuffer(Context paramContext)
  {
    AppMethodBeat.i(54540);
    if (b != X5JsCore.a.a)
    {
      if (b == X5JsCore.a.c)
      {
        AppMethodBeat.o(54540);
        return true;
      }
      AppMethodBeat.o(54540);
      return false;
    }
    b = X5JsCore.a.b;
    if (!canUseX5JsCore(paramContext))
    {
      AppMethodBeat.o(54540);
      return false;
    }
    if (b().canX5JsCoreUseBuffer(paramContext))
    {
      b = X5JsCore.a.c;
      AppMethodBeat.o(54540);
      return true;
    }
    AppMethodBeat.o(54540);
    return false;
  }
  
  @Deprecated
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(54544);
    if (this.e != null)
    {
      b().addJavascriptInterface(paramObject, paramString, this.e);
      AppMethodBeat.o(54544);
      return;
    }
    if (this.f != null)
    {
      this.f.addJavascriptInterface(paramObject, paramString);
      this.f.loadUrl("about:blank");
    }
    AppMethodBeat.o(54544);
  }
  
  @Deprecated
  public void destroy()
  {
    AppMethodBeat.i(54554);
    if (this.e != null)
    {
      b().destroyX5JsCore(this.e);
      this.e = null;
      AppMethodBeat.o(54554);
      return;
    }
    if (this.f != null)
    {
      this.f.clearHistory();
      this.f.clearCache(true);
      this.f.loadUrl("about:blank");
      this.f.freeMemory();
      this.f.pauseTimers();
      this.f.destroy();
      this.f = null;
    }
    AppMethodBeat.o(54554);
  }
  
  @Deprecated
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(54546);
    if (this.e != null)
    {
      b().evaluateJavaScript(paramString, paramValueCallback, this.e);
      AppMethodBeat.o(54546);
      return;
    }
    if (this.f != null) {
      this.f.evaluateJavascript(paramString, paramValueCallback);
    }
    AppMethodBeat.o(54546);
  }
  
  @Deprecated
  public ByteBuffer getNativeBuffer(int paramInt)
  {
    AppMethodBeat.i(54553);
    if ((this.e != null) && (canX5JsCoreUseNativeBuffer(this.d)))
    {
      ByteBuffer localByteBuffer = b().getNativeBuffer(this.e, paramInt);
      AppMethodBeat.o(54553);
      return localByteBuffer;
    }
    AppMethodBeat.o(54553);
    return null;
  }
  
  @Deprecated
  public int getNativeBufferId()
  {
    AppMethodBeat.i(54551);
    if ((this.e != null) && (canX5JsCoreUseNativeBuffer(this.d)))
    {
      int i = b().getNativeBufferId(this.e);
      AppMethodBeat.o(54551);
      return i;
    }
    AppMethodBeat.o(54551);
    return -1;
  }
  
  @Deprecated
  public void pause()
  {
    AppMethodBeat.i(54549);
    if (this.e != null) {
      b().pause(this.e);
    }
    AppMethodBeat.o(54549);
  }
  
  @Deprecated
  public void pauseTimers()
  {
    AppMethodBeat.i(54547);
    if (this.e != null) {
      b().pauseTimers(this.e);
    }
    AppMethodBeat.o(54547);
  }
  
  @Deprecated
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(54545);
    if (this.e != null)
    {
      b().removeJavascriptInterface(paramString, this.e);
      AppMethodBeat.o(54545);
      return;
    }
    if (this.f != null) {
      this.f.removeJavascriptInterface(paramString);
    }
    AppMethodBeat.o(54545);
  }
  
  @Deprecated
  public void resume()
  {
    AppMethodBeat.i(54550);
    if (this.e != null) {
      b().resume(this.e);
    }
    AppMethodBeat.o(54550);
  }
  
  @Deprecated
  public void resumeTimers()
  {
    AppMethodBeat.i(54548);
    if (this.e != null) {
      b().resumeTimers(this.e);
    }
    AppMethodBeat.o(54548);
  }
  
  @Deprecated
  public void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(54552);
    if ((this.e != null) && (canX5JsCoreUseNativeBuffer(this.d))) {
      b().setNativeBuffer(this.e, paramInt, paramByteBuffer);
    }
    AppMethodBeat.o(54552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.X5JsCore
 * JD-Core Version:    0.7.0.1
 */