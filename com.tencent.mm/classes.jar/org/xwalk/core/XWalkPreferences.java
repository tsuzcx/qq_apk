package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p;

public class XWalkPreferences
  implements p
{
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod getBooleanValueStringMethod;
  private ReflectMethod getIntegerValueStringMethod;
  private ReflectMethod getStringValueStringMethod;
  private ReflectMethod getValueStringMethod;
  private ReflectMethod setValueStringStringMethod;
  private ReflectMethod setValueStringbooleanMethod;
  private ReflectMethod setValueStringintMethod;
  
  public XWalkPreferences()
  {
    AppMethodBeat.i(187527);
    this.setValueStringbooleanMethod = new ReflectMethod(null, "setValue", new Class[0]);
    this.setValueStringintMethod = new ReflectMethod(null, "setValue", new Class[0]);
    this.setValueStringStringMethod = new ReflectMethod(null, "setValue", new Class[0]);
    this.getValueStringMethod = new ReflectMethod(null, "getValue", new Class[0]);
    this.getBooleanValueStringMethod = new ReflectMethod(null, "getBooleanValue", new Class[0]);
    this.getIntegerValueStringMethod = new ReflectMethod(null, "getIntegerValue", new Class[0]);
    this.getStringValueStringMethod = new ReflectMethod(null, "getStringValue", new Class[0]);
    AppMethodBeat.o(187527);
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(154836);
    if (this.coreWrapper != null)
    {
      AppMethodBeat.o(154836);
      return;
    }
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(154836);
      return;
    }
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    Class localClass = this.coreWrapper.getBridgeClass("XWalkPreferencesBridge");
    this.setValueStringbooleanMethod.init(null, localClass, "setValue", new Class[] { String.class, Boolean.TYPE });
    this.setValueStringintMethod.init(null, localClass, "setValue", new Class[] { String.class, Integer.TYPE });
    this.setValueStringStringMethod.init(null, localClass, "setValue", new Class[] { String.class, String.class });
    this.getValueStringMethod.init(null, localClass, "getValue", new Class[] { String.class });
    this.getBooleanValueStringMethod.init(null, localClass, "getBooleanValue", new Class[] { String.class });
    this.getIntegerValueStringMethod.init(null, localClass, "getIntegerValue", new Class[] { String.class });
    this.getStringValueStringMethod.init(null, localClass, "getStringValue", new Class[] { String.class });
    AppMethodBeat.o(154836);
  }
  
  public boolean getBooleanValue(String paramString)
  {
    AppMethodBeat.i(154833);
    reflectionInit();
    try
    {
      boolean bool = ((Boolean)this.getBooleanValueStringMethod.invoke(new Object[] { paramString })).booleanValue();
      AppMethodBeat.o(154833);
      return bool;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154833);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154833);
    }
    return false;
  }
  
  public int getIntegerValue(String paramString)
  {
    AppMethodBeat.i(154834);
    reflectionInit();
    try
    {
      int i = ((Integer)this.getIntegerValueStringMethod.invoke(new Object[] { paramString })).intValue();
      AppMethodBeat.o(154834);
      return i;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154834);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154834);
    }
    return 0;
  }
  
  public String getStringValue(String paramString)
  {
    AppMethodBeat.i(154835);
    reflectionInit();
    try
    {
      paramString = (String)this.getStringValueStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154835);
      return paramString;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154835);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154835);
    }
    return null;
  }
  
  public boolean getValue(String paramString)
  {
    AppMethodBeat.i(154832);
    reflectionInit();
    try
    {
      boolean bool = ((Boolean)this.getValueStringMethod.invoke(new Object[] { paramString })).booleanValue();
      AppMethodBeat.o(154832);
      return bool;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154832);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154832);
    }
    return false;
  }
  
  public void setValue(String paramString, int paramInt)
  {
    AppMethodBeat.i(154830);
    reflectionInit();
    try
    {
      this.setValueStringintMethod.invoke(new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(154830);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setValueStringintMethod.setArguments(new Object[] { paramString, Integer.valueOf(paramInt) });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setValueStringintMethod);
        AppMethodBeat.o(154830);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(154830);
    }
  }
  
  public void setValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154831);
    reflectionInit();
    try
    {
      this.setValueStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(154831);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setValueStringStringMethod.setArguments(new Object[] { paramString1, paramString2 });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setValueStringStringMethod);
        AppMethodBeat.o(154831);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(154831);
    }
  }
  
  public void setValue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154829);
    reflectionInit();
    try
    {
      this.setValueStringbooleanMethod.invoke(new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154829);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setValueStringbooleanMethod.setArguments(new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setValueStringbooleanMethod);
        AppMethodBeat.o(154829);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(154829);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkPreferences
 * JD-Core Version:    0.7.0.1
 */