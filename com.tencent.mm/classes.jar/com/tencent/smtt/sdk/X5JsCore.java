package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

public class X5JsCore
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
    AppMethodBeat.i(65120);
    this.e = null;
    this.f = null;
    this.d = paramContext;
    if (canUseX5JsCore(paramContext))
    {
      Object localObject = a("createX5JavaBridge", new Class[] { Context.class }, new Object[] { paramContext });
      if (localObject != null)
      {
        this.e = localObject;
        AppMethodBeat.o(65120);
        return;
      }
    }
    this.f = new WebView(paramContext);
    this.f.getSettings().setJavaScriptEnabled(true);
    AppMethodBeat.o(65120);
  }
  
  protected static IX5JsVirtualMachine a(Context paramContext, Looper paramLooper)
  {
    AppMethodBeat.i(65118);
    if (canUseX5JsCore(paramContext))
    {
      paramContext = a("createX5JsVirtualMachine", new Class[] { Context.class, Looper.class }, new Object[] { paramContext, paramLooper });
      if (paramContext != null)
      {
        paramContext = (IX5JsVirtualMachine)paramContext;
        AppMethodBeat.o(65118);
        return paramContext;
      }
    }
    AppMethodBeat.o(65118);
    return null;
  }
  
  protected static Object a()
  {
    AppMethodBeat.i(65119);
    Object localObject = a("currentContextData", new Class[0], new Object[0]);
    AppMethodBeat.o(65119);
    return localObject;
  }
  
  private static Object a(String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(65114);
    try
    {
      bz localbz = bz.a();
      if ((localbz != null) && (localbz.b()))
      {
        paramString = localbz.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", paramString, paramArrayOfClass, paramVarArgs);
        AppMethodBeat.o(65114);
        return paramString;
      }
      new StringBuilder("X5Jscore#").append(paramString).append(" - x5CoreEngine is null or is not x5core.");
    }
    catch (Exception paramString)
    {
      label62:
      break label62;
    }
    AppMethodBeat.o(65114);
    return null;
  }
  
  public static boolean canUseX5JsCore(Context paramContext)
  {
    AppMethodBeat.i(65116);
    if (a != X5JsCore.a.a)
    {
      if (a == X5JsCore.a.c)
      {
        AppMethodBeat.o(65116);
        return true;
      }
      AppMethodBeat.o(65116);
      return false;
    }
    a = X5JsCore.a.b;
    paramContext = a("canUseX5JsCore", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)) && (((Boolean)paramContext).booleanValue()))
    {
      paramContext = JsValue.a();
      a("setJsValueFactory", new Class[] { Object.class }, new Object[] { paramContext });
      a = X5JsCore.a.c;
      AppMethodBeat.o(65116);
      return true;
    }
    AppMethodBeat.o(65116);
    return false;
  }
  
  public static boolean canUseX5JsCoreNewAPI(Context paramContext)
  {
    AppMethodBeat.i(65115);
    if (c != X5JsCore.a.a)
    {
      if (c == X5JsCore.a.c)
      {
        AppMethodBeat.o(65115);
        return true;
      }
      AppMethodBeat.o(65115);
      return false;
    }
    c = X5JsCore.a.b;
    paramContext = a("canUseX5JsCoreNewAPI", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)) && (((Boolean)paramContext).booleanValue()))
    {
      c = X5JsCore.a.c;
      AppMethodBeat.o(65115);
      return true;
    }
    AppMethodBeat.o(65115);
    return false;
  }
  
  public static boolean canX5JsCoreUseNativeBuffer(Context paramContext)
  {
    AppMethodBeat.i(65117);
    if (b != X5JsCore.a.a)
    {
      if (b == X5JsCore.a.c)
      {
        AppMethodBeat.o(65117);
        return true;
      }
      AppMethodBeat.o(65117);
      return false;
    }
    b = X5JsCore.a.b;
    if (!canUseX5JsCore(paramContext))
    {
      AppMethodBeat.o(65117);
      return false;
    }
    paramContext = a("canX5JsCoreUseBuffer", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)) && (((Boolean)paramContext).booleanValue()))
    {
      b = X5JsCore.a.c;
      AppMethodBeat.o(65117);
      return true;
    }
    AppMethodBeat.o(65117);
    return false;
  }
  
  @Deprecated
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(65121);
    if (this.e != null)
    {
      Object localObject = this.e;
      a("addJavascriptInterface", new Class[] { Object.class, String.class, Object.class }, new Object[] { paramObject, paramString, localObject });
      AppMethodBeat.o(65121);
      return;
    }
    if (this.f != null)
    {
      this.f.addJavascriptInterface(paramObject, paramString);
      this.f.loadUrl("about:blank");
    }
    AppMethodBeat.o(65121);
  }
  
  @Deprecated
  public void destroy()
  {
    AppMethodBeat.i(65131);
    if (this.e != null)
    {
      Object localObject = this.e;
      a("destroyX5JsCore", new Class[] { Object.class }, new Object[] { localObject });
      this.e = null;
      AppMethodBeat.o(65131);
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
    AppMethodBeat.o(65131);
  }
  
  @Deprecated
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(65123);
    if (this.e != null)
    {
      Object localObject = this.e;
      a("evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class, Object.class }, new Object[] { paramString, paramValueCallback, localObject });
      AppMethodBeat.o(65123);
      return;
    }
    if (this.f != null) {
      this.f.evaluateJavascript(paramString, paramValueCallback);
    }
    AppMethodBeat.o(65123);
  }
  
  @Deprecated
  public ByteBuffer getNativeBuffer(int paramInt)
  {
    AppMethodBeat.i(65130);
    if ((this.e != null) && (canX5JsCoreUseNativeBuffer(this.d)))
    {
      Object localObject1 = Integer.TYPE;
      Object localObject2 = this.e;
      localObject1 = a("getNativeBuffer", new Class[] { Object.class, localObject1 }, new Object[] { localObject2, Integer.valueOf(paramInt) });
      if ((localObject1 != null) && ((localObject1 instanceof ByteBuffer)))
      {
        localObject1 = (ByteBuffer)localObject1;
        AppMethodBeat.o(65130);
        return localObject1;
      }
    }
    AppMethodBeat.o(65130);
    return null;
  }
  
  @Deprecated
  public int getNativeBufferId()
  {
    AppMethodBeat.i(65128);
    if ((this.e != null) && (canX5JsCoreUseNativeBuffer(this.d)))
    {
      Object localObject = this.e;
      localObject = a("getNativeBufferId", new Class[] { Object.class }, new Object[] { localObject });
      if ((localObject != null) && ((localObject instanceof Integer)))
      {
        int i = ((Integer)localObject).intValue();
        AppMethodBeat.o(65128);
        return i;
      }
    }
    AppMethodBeat.o(65128);
    return -1;
  }
  
  @Deprecated
  public void pause()
  {
    AppMethodBeat.i(65126);
    if (this.e != null)
    {
      Object localObject = this.e;
      a("pause", new Class[] { Object.class }, new Object[] { localObject });
    }
    AppMethodBeat.o(65126);
  }
  
  @Deprecated
  public void pauseTimers()
  {
    AppMethodBeat.i(65124);
    if (this.e != null)
    {
      Object localObject = this.e;
      a("pauseTimers", new Class[] { Object.class }, new Object[] { localObject });
    }
    AppMethodBeat.o(65124);
  }
  
  @Deprecated
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(65122);
    if (this.e != null)
    {
      Object localObject = this.e;
      a("removeJavascriptInterface", new Class[] { String.class, Object.class }, new Object[] { paramString, localObject });
      AppMethodBeat.o(65122);
      return;
    }
    if (this.f != null) {
      this.f.removeJavascriptInterface(paramString);
    }
    AppMethodBeat.o(65122);
  }
  
  @Deprecated
  public void resume()
  {
    AppMethodBeat.i(65127);
    if (this.e != null)
    {
      Object localObject = this.e;
      a("resume", new Class[] { Object.class }, new Object[] { localObject });
    }
    AppMethodBeat.o(65127);
  }
  
  @Deprecated
  public void resumeTimers()
  {
    AppMethodBeat.i(65125);
    if (this.e != null)
    {
      Object localObject = this.e;
      a("resumeTimers", new Class[] { Object.class }, new Object[] { localObject });
    }
    AppMethodBeat.o(65125);
  }
  
  @Deprecated
  public void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(65129);
    if ((this.e != null) && (canX5JsCoreUseNativeBuffer(this.d)))
    {
      Class localClass = Integer.TYPE;
      Object localObject = this.e;
      a("setNativeBuffer", new Class[] { Object.class, localClass, ByteBuffer.class }, new Object[] { localObject, Integer.valueOf(paramInt), paramByteBuffer });
    }
    AppMethodBeat.o(65129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.X5JsCore
 * JD-Core Version:    0.7.0.1
 */