package com.tencent.smtt.sdk.b;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreJsCore;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import com.tencent.smtt.sdk.JsValue;
import java.nio.ByteBuffer;

public class n
  implements IX5CoreJsCore
{
  private DexLoader a;
  
  public n(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  private Object a(String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(188511);
    try
    {
      paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", paramString, paramArrayOfClass, paramVarArgs);
      AppMethodBeat.o(188511);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(188511);
    }
    return null;
  }
  
  public void addJavascriptInterface(Object paramObject1, String paramString, Object paramObject2)
  {
    AppMethodBeat.i(188496);
    a("addJavascriptInterface", new Class[] { Object.class, String.class, Object.class }, new Object[] { paramObject1, paramString, paramObject2 });
    AppMethodBeat.o(188496);
  }
  
  public boolean canUseX5JsCore(Context paramContext)
  {
    AppMethodBeat.i(188507);
    paramContext = a("canUseX5JsCore", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)))
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(188507);
      return bool;
    }
    AppMethodBeat.o(188507);
    return false;
  }
  
  public boolean canUseX5JsCoreNewAPI(Context paramContext)
  {
    AppMethodBeat.i(188508);
    paramContext = a("canUseX5JsCoreNewAPI", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)))
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(188508);
      return bool;
    }
    AppMethodBeat.o(188508);
    return false;
  }
  
  public boolean canX5JsCoreUseBuffer(Context paramContext)
  {
    AppMethodBeat.i(188509);
    paramContext = a("canX5JsCoreUseBuffer", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)))
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(188509);
      return bool;
    }
    AppMethodBeat.o(188509);
    return false;
  }
  
  public Object createX5JavaBridge(Context paramContext)
  {
    AppMethodBeat.i(188510);
    paramContext = a("createX5JavaBridge", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(188510);
    return paramContext;
  }
  
  public IX5JsVirtualMachine createX5JsVirtualMachine(Context paramContext, Looper paramLooper)
  {
    AppMethodBeat.i(188493);
    paramContext = a("createX5JsVirtualMachine", new Class[] { Context.class, Looper.class }, new Object[] { paramContext, paramLooper });
    if (paramContext != null)
    {
      paramContext = (IX5JsVirtualMachine)paramContext;
      AppMethodBeat.o(188493);
      return paramContext;
    }
    AppMethodBeat.o(188493);
    return null;
  }
  
  public Object currentContextData()
  {
    AppMethodBeat.i(188494);
    Object localObject = a("currentContextData", new Class[0], new Object[0]);
    AppMethodBeat.o(188494);
    return localObject;
  }
  
  public void destroyX5JsCore(Object paramObject)
  {
    AppMethodBeat.i(188499);
    a("destroyX5JsCore", new Class[] { Object.class }, new Object[] { paramObject });
    AppMethodBeat.o(188499);
  }
  
  public void evaluateJavaScript(String paramString, ValueCallback<String> paramValueCallback, Object paramObject)
  {
    AppMethodBeat.i(188498);
    a("evaluateJavascript", new Class[] { String.class, ValueCallback.class, Object.class }, new Object[] { paramString, paramValueCallback, paramObject });
    AppMethodBeat.o(188498);
  }
  
  public ByteBuffer getNativeBuffer(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(188506);
    paramObject = a("getNativeBuffer", new Class[] { Object.class, Integer.TYPE }, new Object[] { paramObject, Integer.valueOf(paramInt) });
    if ((paramObject != null) && ((paramObject instanceof ByteBuffer)))
    {
      paramObject = (ByteBuffer)paramObject;
      AppMethodBeat.o(188506);
      return paramObject;
    }
    AppMethodBeat.o(188506);
    return null;
  }
  
  public int getNativeBufferId(Object paramObject)
  {
    AppMethodBeat.i(188504);
    paramObject = a("getNativeBufferId", new Class[] { Object.class }, new Object[] { paramObject });
    if ((paramObject != null) && ((paramObject instanceof Integer)))
    {
      int i = ((Integer)paramObject).intValue();
      AppMethodBeat.o(188504);
      return i;
    }
    AppMethodBeat.o(188504);
    return -1;
  }
  
  public void pause(Object paramObject)
  {
    AppMethodBeat.i(188502);
    a("pause", new Class[] { Object.class }, new Object[] { paramObject });
    AppMethodBeat.o(188502);
  }
  
  public void pauseTimers(Object paramObject)
  {
    AppMethodBeat.i(188500);
    a("pauseTimers", new Class[] { Object.class }, new Object[] { paramObject });
    AppMethodBeat.o(188500);
  }
  
  public void removeJavascriptInterface(String paramString, Object paramObject)
  {
    AppMethodBeat.i(188497);
    a("removeJavascriptInterface", new Class[] { String.class, Object.class }, new Object[] { paramString, paramObject });
    AppMethodBeat.o(188497);
  }
  
  public void resume(Object paramObject)
  {
    AppMethodBeat.i(188503);
    a("resume", new Class[] { Object.class }, new Object[] { paramObject });
    AppMethodBeat.o(188503);
  }
  
  public void resumeTimers(Object paramObject)
  {
    AppMethodBeat.i(188501);
    a("resumeTimers", new Class[] { Object.class }, new Object[] { paramObject });
    AppMethodBeat.o(188501);
  }
  
  public void setJsValueFactory(Object paramObject)
  {
    AppMethodBeat.i(188495);
    paramObject = JsValue.factory();
    a("setJsValueFactory", new Class[] { Object.class }, new Object[] { paramObject });
    AppMethodBeat.o(188495);
  }
  
  public void setNativeBuffer(Object paramObject, int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(188505);
    a("setNativeBuffer", new Class[] { Object.class, Integer.TYPE, ByteBuffer.class }, new Object[] { paramObject, Integer.valueOf(paramInt), paramByteBuffer });
    AppMethodBeat.o(188505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.n
 * JD-Core Version:    0.7.0.1
 */