package com.tencent.xweb.pinus;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p;
import com.tencent.xweb.pinus.sdk.PSCoreWrapper;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;

public final class d
  implements p
{
  private PSCoreWrapper coreWrapper;
  private ReflectMethod getBooleanValueStringMethod;
  private ReflectMethod getIntegerValueStringMethod;
  private ReflectMethod getStringValueStringMethod;
  private ReflectMethod getValueStringMethod;
  private ReflectMethod setValueStringStringMethod;
  private ReflectMethod setValueStringbooleanMethod;
  private ReflectMethod setValueStringintMethod;
  
  public d()
  {
    AppMethodBeat.i(213332);
    this.setValueStringbooleanMethod = new ReflectMethod(null, "setValue", new Class[0]);
    this.setValueStringintMethod = new ReflectMethod(null, "setValue", new Class[0]);
    this.setValueStringStringMethod = new ReflectMethod(null, "setValue", new Class[0]);
    this.getValueStringMethod = new ReflectMethod(null, "getValue", new Class[0]);
    this.getBooleanValueStringMethod = new ReflectMethod(null, "getBooleanValue", new Class[0]);
    this.getIntegerValueStringMethod = new ReflectMethod(null, "getIntegerValue", new Class[0]);
    this.getStringValueStringMethod = new ReflectMethod(null, "getStringValue", new Class[0]);
    AppMethodBeat.o(213332);
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(213343);
    if (this.coreWrapper != null)
    {
      AppMethodBeat.o(213343);
      return;
    }
    if (PSCoreWrapper.getInstance() == null)
    {
      Log.w("PinusPreferences", "reflectionInit, pinus core wrapper is null");
      AppMethodBeat.o(213343);
      return;
    }
    this.coreWrapper = PSCoreWrapper.getInstance();
    Class localClass = this.coreWrapper.getBridgeClassFromXWalk("XWalkPreferencesBridge");
    this.setValueStringbooleanMethod.init(null, localClass, "setValue", new Class[] { String.class, Boolean.TYPE });
    this.setValueStringintMethod.init(null, localClass, "setValue", new Class[] { String.class, Integer.TYPE });
    this.setValueStringStringMethod.init(null, localClass, "setValue", new Class[] { String.class, String.class });
    this.getValueStringMethod.init(null, localClass, "getValue", new Class[] { String.class });
    this.getBooleanValueStringMethod.init(null, localClass, "getBooleanValue", new Class[] { String.class });
    this.getIntegerValueStringMethod.init(null, localClass, "getIntegerValue", new Class[] { String.class });
    this.getStringValueStringMethod.init(null, localClass, "getStringValue", new Class[] { String.class });
    AppMethodBeat.o(213343);
  }
  
  public final boolean getBooleanValue(String paramString)
  {
    AppMethodBeat.i(213373);
    reflectionInit();
    try
    {
      boolean bool = ((Boolean)this.getBooleanValueStringMethod.invoke(new Object[] { paramString })).booleanValue();
      AppMethodBeat.o(213373);
      return bool;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(213373);
        throw paramString;
      }
      PSCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(213373);
    }
    return false;
  }
  
  public final void setValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213361);
    reflectionInit();
    try
    {
      this.setValueStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(213361);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(213361);
        throw paramString1;
      }
      PSCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(213361);
    }
  }
  
  public final void setValue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(213352);
    reflectionInit();
    try
    {
      this.setValueStringbooleanMethod.invoke(new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(213352);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(213352);
        throw paramString;
      }
      PSCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(213352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.d
 * JD-Core Version:    0.7.0.1
 */