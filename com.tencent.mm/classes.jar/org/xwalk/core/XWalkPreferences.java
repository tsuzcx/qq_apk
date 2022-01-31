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
    AppMethodBeat.i(85742);
    setValueStringbooleanMethod = new ReflectMethod(null, "setValue", new Class[0]);
    setValueStringintMethod = new ReflectMethod(null, "setValue", new Class[0]);
    setValueStringStringMethod = new ReflectMethod(null, "setValue", new Class[0]);
    getValueStringMethod = new ReflectMethod(null, "getValue", new Class[0]);
    getBooleanValueStringMethod = new ReflectMethod(null, "getBooleanValue", new Class[0]);
    getIntegerValueStringMethod = new ReflectMethod(null, "getIntegerValue", new Class[0]);
    getStringValueStringMethod = new ReflectMethod(null, "getStringValue", new Class[0]);
    AppMethodBeat.o(85742);
  }
  
  public static boolean getBooleanValue(String paramString)
  {
    AppMethodBeat.i(85738);
    reflectionInit();
    try
    {
      boolean bool = ((Boolean)getBooleanValueStringMethod.invoke(new Object[] { paramString })).booleanValue();
      AppMethodBeat.o(85738);
      return bool;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85738);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85738);
    }
    return false;
  }
  
  public static int getIntegerValue(String paramString)
  {
    AppMethodBeat.i(85739);
    reflectionInit();
    try
    {
      int i = ((Integer)getIntegerValueStringMethod.invoke(new Object[] { paramString })).intValue();
      AppMethodBeat.o(85739);
      return i;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85739);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85739);
    }
    return 0;
  }
  
  public static String getStringValue(String paramString)
  {
    AppMethodBeat.i(85740);
    reflectionInit();
    try
    {
      paramString = (String)getStringValueStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85740);
      return paramString;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85740);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85740);
    }
    return null;
  }
  
  public static boolean getValue(String paramString)
  {
    AppMethodBeat.i(85737);
    reflectionInit();
    try
    {
      boolean bool = ((Boolean)getValueStringMethod.invoke(new Object[] { paramString })).booleanValue();
      AppMethodBeat.o(85737);
      return bool;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85737);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85737);
    }
    return false;
  }
  
  static void reflectionInit()
  {
    AppMethodBeat.i(85741);
    if (coreWrapper != null)
    {
      AppMethodBeat.o(85741);
      return;
    }
    XWalkCoreWrapper.initEmbeddedMode();
    Object localObject = XWalkCoreWrapper.getInstance();
    coreWrapper = (XWalkCoreWrapper)localObject;
    if (localObject == null)
    {
      XWalkCoreWrapper.reserveReflectClass(XWalkPreferences.class);
      AppMethodBeat.o(85741);
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
    AppMethodBeat.o(85741);
  }
  
  public static void setValue(String paramString, int paramInt)
  {
    AppMethodBeat.i(85735);
    reflectionInit();
    try
    {
      setValueStringintMethod.invoke(new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(85735);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (coreWrapper == null)
      {
        setValueStringintMethod.setArguments(new Object[] { paramString, Integer.valueOf(paramInt) });
        XWalkCoreWrapper.reserveReflectMethod(setValueStringintMethod);
        AppMethodBeat.o(85735);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(85735);
    }
  }
  
  public static void setValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(85736);
    reflectionInit();
    try
    {
      setValueStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(85736);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (coreWrapper == null)
      {
        setValueStringStringMethod.setArguments(new Object[] { paramString1, paramString2 });
        XWalkCoreWrapper.reserveReflectMethod(setValueStringStringMethod);
        AppMethodBeat.o(85736);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(85736);
    }
  }
  
  public static void setValue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(85734);
    reflectionInit();
    try
    {
      setValueStringbooleanMethod.invoke(new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85734);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (coreWrapper == null)
      {
        setValueStringbooleanMethod.setArguments(new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        XWalkCoreWrapper.reserveReflectMethod(setValueStringbooleanMethod);
        AppMethodBeat.o(85734);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(85734);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkPreferences
 * JD-Core Version:    0.7.0.1
 */