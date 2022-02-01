package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkPreferences
{
  public static final String ALLOW_UNIVERSAL_ACCESS_FROM_FILE = "allow-universal-access-from-file";
  public static final String ANIMATABLE_XWALK_VIEW = "animatable-xwalk-view";
  public static final String ENABLE_EXTENSIONS = "enable-extensions";
  public static final String ENABLE_JAVASCRIPT = "enable-javascript";
  public static final String ENABLE_THEME_COLOR = "enable-theme-color";
  public static final String JAVASCRIPT_CAN_OPEN_WINDOW = "javascript-can-open-window";
  public static final String PROFILE_NAME = "profile-name";
  public static final String REMOTE_DEBUGGING = "remote-debugging";
  public static final String SPATIAL_NAVIGATION = "enable-spatial-navigation";
  public static final String SUPPORT_MULTIPLE_WINDOWS = "support-multiple-windows";
  public static final String XWEBSDK_VERSION = "xwebsdk-version";
  public static final String XWEB_VERSION = "xweb-version";
  private static XWalkCoreWrapper coreWrapper;
  private static ReflectMethod getBooleanValueStringMethod;
  private static ReflectMethod getIntegerValueStringMethod;
  private static ReflectMethod getStringValueStringMethod;
  private static ReflectMethod getValueStringMethod;
  private static ReflectMethod setValueStringStringMethod;
  private static ReflectMethod setValueStringbooleanMethod;
  private static ReflectMethod setValueStringintMethod;
  
  static
  {
    AppMethodBeat.i(154837);
    setValueStringbooleanMethod = new ReflectMethod(null, "setValue", new Class[0]);
    setValueStringintMethod = new ReflectMethod(null, "setValue", new Class[0]);
    setValueStringStringMethod = new ReflectMethod(null, "setValue", new Class[0]);
    getValueStringMethod = new ReflectMethod(null, "getValue", new Class[0]);
    getBooleanValueStringMethod = new ReflectMethod(null, "getBooleanValue", new Class[0]);
    getIntegerValueStringMethod = new ReflectMethod(null, "getIntegerValue", new Class[0]);
    getStringValueStringMethod = new ReflectMethod(null, "getStringValue", new Class[0]);
    AppMethodBeat.o(154837);
  }
  
  public static boolean getBooleanValue(String paramString)
  {
    AppMethodBeat.i(154833);
    reflectionInit();
    try
    {
      boolean bool = ((Boolean)getBooleanValueStringMethod.invoke(new Object[] { paramString })).booleanValue();
      AppMethodBeat.o(154833);
      return bool;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (coreWrapper == null)
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
  
  public static int getIntegerValue(String paramString)
  {
    AppMethodBeat.i(154834);
    reflectionInit();
    try
    {
      int i = ((Integer)getIntegerValueStringMethod.invoke(new Object[] { paramString })).intValue();
      AppMethodBeat.o(154834);
      return i;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (coreWrapper == null)
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
  
  public static String getStringValue(String paramString)
  {
    AppMethodBeat.i(154835);
    reflectionInit();
    try
    {
      paramString = (String)getStringValueStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154835);
      return paramString;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (coreWrapper == null)
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
  
  public static boolean getValue(String paramString)
  {
    AppMethodBeat.i(154832);
    reflectionInit();
    try
    {
      boolean bool = ((Boolean)getValueStringMethod.invoke(new Object[] { paramString })).booleanValue();
      AppMethodBeat.o(154832);
      return bool;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (coreWrapper == null)
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
  
  static void reflectionInit()
  {
    AppMethodBeat.i(154836);
    if (coreWrapper != null)
    {
      AppMethodBeat.o(154836);
      return;
    }
    XWalkCoreWrapper.initEmbeddedMode();
    Object localObject = XWalkCoreWrapper.getInstance();
    coreWrapper = (XWalkCoreWrapper)localObject;
    if (localObject == null)
    {
      XWalkCoreWrapper.reserveReflectClass(XWalkPreferences.class);
      AppMethodBeat.o(154836);
      return;
    }
    localObject = coreWrapper.getBridgeClass("XWalkPreferencesBridge");
    setValueStringbooleanMethod.init(null, (Class)localObject, "setValue", new Class[] { String.class, Boolean.TYPE });
    setValueStringintMethod.init(null, (Class)localObject, "setValue", new Class[] { String.class, Integer.TYPE });
    setValueStringStringMethod.init(null, (Class)localObject, "setValue", new Class[] { String.class, String.class });
    getValueStringMethod.init(null, (Class)localObject, "getValue", new Class[] { String.class });
    getBooleanValueStringMethod.init(null, (Class)localObject, "getBooleanValue", new Class[] { String.class });
    getIntegerValueStringMethod.init(null, (Class)localObject, "getIntegerValue", new Class[] { String.class });
    getStringValueStringMethod.init(null, (Class)localObject, "getStringValue", new Class[] { String.class });
    AppMethodBeat.o(154836);
  }
  
  public static void setValue(String paramString, int paramInt)
  {
    AppMethodBeat.i(154830);
    reflectionInit();
    try
    {
      setValueStringintMethod.invoke(new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(154830);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (coreWrapper == null)
      {
        setValueStringintMethod.setArguments(new Object[] { paramString, Integer.valueOf(paramInt) });
        XWalkCoreWrapper.reserveReflectMethod(setValueStringintMethod);
        AppMethodBeat.o(154830);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(154830);
    }
  }
  
  public static void setValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154831);
    reflectionInit();
    try
    {
      setValueStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(154831);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (coreWrapper == null)
      {
        setValueStringStringMethod.setArguments(new Object[] { paramString1, paramString2 });
        XWalkCoreWrapper.reserveReflectMethod(setValueStringStringMethod);
        AppMethodBeat.o(154831);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(154831);
    }
  }
  
  public static void setValue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154829);
    reflectionInit();
    try
    {
      setValueStringbooleanMethod.invoke(new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154829);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (coreWrapper == null)
      {
        setValueStringbooleanMethod.setArguments(new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        XWalkCoreWrapper.reserveReflectMethod(setValueStringbooleanMethod);
        AppMethodBeat.o(154829);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(154829);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkPreferences
 * JD-Core Version:    0.7.0.1
 */