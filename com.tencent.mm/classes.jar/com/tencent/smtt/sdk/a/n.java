package com.tencent.smtt.sdk.a;

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
    AppMethodBeat.i(54774);
    try
    {
      paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", paramString, paramArrayOfClass, paramVarArgs);
      AppMethodBeat.o(54774);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(54774);
    }
    return null;
  }
  
  public void addJavascriptInterface(Object paramObject1, String paramString, Object paramObject2)
  {
    AppMethodBeat.i(54759);
    a("addJavascriptInterface", new Class[] { Object.class, String.class, Object.class }, new Object[] { paramObject1, paramString, paramObject2 });
    AppMethodBeat.o(54759);
  }
  
  public boolean canUseX5JsCore(Context paramContext)
  {
    AppMethodBeat.i(54770);
    paramContext = a("canUseX5JsCore", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)))
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(54770);
      return bool;
    }
    AppMethodBeat.o(54770);
    return false;
  }
  
  public boolean canUseX5JsCoreNewAPI(Context paramContext)
  {
    AppMethodBeat.i(54771);
    paramContext = a("canUseX5JsCoreNewAPI", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)))
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(54771);
      return bool;
    }
    AppMethodBeat.o(54771);
    return false;
  }
  
  public boolean canX5JsCoreUseBuffer(Context paramContext)
  {
    AppMethodBeat.i(54772);
    paramContext = a("canX5JsCoreUseBuffer", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext != null) && ((paramContext instanceof Boolean)))
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(54772);
      return bool;
    }
    AppMethodBeat.o(54772);
    return false;
  }
  
  public Object createX5JavaBridge(Context paramContext)
  {
    AppMethodBeat.i(54773);
    paramContext = a("createX5JavaBridge", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(54773);
    return paramContext;
  }
  
  public IX5JsVirtualMachine createX5JsVirtualMachine(Context paramContext, Looper paramLooper)
  {
    AppMethodBeat.i(54756);
    paramContext = a("createX5JsVirtualMachine", new Class[] { Context.class, Looper.class }, new Object[] { paramContext, paramLooper });
    if (paramContext != null)
    {
      paramContext = (IX5JsVirtualMachine)paramContext;
      AppMethodBeat.o(54756);
      return paramContext;
    }
    AppMethodBeat.o(54756);
    return null;
  }
  
  public Object currentContextData()
  {
    AppMethodBeat.i(54757);
    Object localObject = a("currentContextData", new Class[0], new Object[0]);
    AppMethodBeat.o(54757);
    return localObject;
  }
  
  public void destroyX5JsCore(Object paramObject)
  {
    AppMethodBeat.i(54762);
    a("destroyX5JsCore", new Class[] { Object.class }, new Object[] { paramObject });
    AppMethodBeat.o(54762);
  }
  
  public void evaluateJavaScript(String paramString, ValueCallback<String> paramValueCallback, Object paramObject)
  {
    AppMethodBeat.i(54761);
    a("evaluateJavascript", new Class[] { String.class, ValueCallback.class, Object.class }, new Object[] { paramString, paramValueCallback, paramObject });
    AppMethodBeat.o(54761);
  }
  
  public ByteBuffer getNativeBuffer(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(54769);
    paramObject = a("getNativeBuffer", new Class[] { Object.class, Integer.TYPE }, new Object[] { paramObject, Integer.valueOf(paramInt) });
    if ((paramObject != null) && ((paramObject instanceof ByteBuffer)))
    {
      paramObject = (ByteBuffer)paramObject;
      AppMethodBeat.o(54769);
      return paramObject;
    }
    AppMethodBeat.o(54769);
    return null;
  }
  
  public int getNativeBufferId(Object paramObject)
  {
    AppMethodBeat.i(54767);
    paramObject = a("getNativeBufferId", new Class[] { Object.class }, new Object[] { paramObject });
    if ((paramObject != null) && ((paramObject instanceof Integer)))
    {
      int i = ((Integer)paramObject).intValue();
      AppMethodBeat.o(54767);
      return i;
    }
    AppMethodBeat.o(54767);
    return -1;
  }
  
  public void pause(Object paramObject)
  {
    AppMethodBeat.i(54765);
    a("pause", new Class[] { Object.class }, new Object[] { paramObject });
    AppMethodBeat.o(54765);
  }
  
  public void pauseTimers(Object paramObject)
  {
    AppMethodBeat.i(54763);
    a("pauseTimers", new Class[] { Object.class }, new Object[] { paramObject });
    AppMethodBeat.o(54763);
  }
  
  public void removeJavascriptInterface(String paramString, Object paramObject)
  {
    AppMethodBeat.i(54760);
    a("removeJavascriptInterface", new Class[] { String.class, Object.class }, new Object[] { paramString, paramObject });
    AppMethodBeat.o(54760);
  }
  
  public void resume(Object paramObject)
  {
    AppMethodBeat.i(54766);
    a("resume", new Class[] { Object.class }, new Object[] { paramObject });
    AppMethodBeat.o(54766);
  }
  
  public void resumeTimers(Object paramObject)
  {
    AppMethodBeat.i(54764);
    a("resumeTimers", new Class[] { Object.class }, new Object[] { paramObject });
    AppMethodBeat.o(54764);
  }
  
  public void setJsValueFactory(Object paramObject)
  {
    AppMethodBeat.i(54758);
    paramObject = JsValue.factory();
    a("setJsValueFactory", new Class[] { Object.class }, new Object[] { paramObject });
    AppMethodBeat.o(54758);
  }
  
  public void setNativeBuffer(Object paramObject, int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(54768);
    a("setNativeBuffer", new Class[] { Object.class, Integer.TYPE, ByteBuffer.class }, new Object[] { paramObject, Integer.valueOf(paramInt), paramByteBuffer });
    AppMethodBeat.o(54768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.n
 * JD-Core Version:    0.7.0.1
 */