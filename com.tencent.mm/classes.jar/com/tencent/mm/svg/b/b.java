package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class b
{
  private static boolean IQH = false;
  private static boolean IQI = false;
  private static boolean mInitialized;
  private static String mPackageName = "";
  
  static
  {
    mInitialized = false;
  }
  
  public static long DK(long paramLong)
  {
    AppMethodBeat.i(148761);
    paramLong = (System.nanoTime() - paramLong) / 1000L;
    AppMethodBeat.o(148761);
    return paramLong;
  }
  
  private static final Object aVc(String paramString)
  {
    AppMethodBeat.i(148757);
    try
    {
      Class localClass = Class.forName(mPackageName + ".svg.SVGBuildConfig");
      paramString = localClass.getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString = paramString.get(localClass);
      AppMethodBeat.o(148757);
      return paramString;
    }
    catch (NoSuchFieldException paramString)
    {
      c.printErrStackTrace("MicroMSG.WeChatSVGConfig", paramString, "NoSuchFieldException", new Object[0]);
      AppMethodBeat.o(148757);
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;)
      {
        c.printErrStackTrace("MicroMSG.WeChatSVGConfig", paramString, "IllegalArgumentException", new Object[0]);
      }
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        c.printErrStackTrace("MicroMSG.WeChatSVGConfig", paramString, "ClassNotFoundException", new Object[0]);
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        c.printErrStackTrace("MicroMSG.WeChatSVGConfig", paramString, "IllegalAccessException", new Object[0]);
      }
    }
  }
  
  public static void ft(String paramString)
  {
    mPackageName = paramString;
  }
  
  public static final boolean fuh()
  {
    return IQI;
  }
  
  public static final boolean fui()
  {
    AppMethodBeat.i(148758);
    Object localObject;
    if (!mInitialized)
    {
      localObject = aVc("WxSVGCode");
      if (localObject != null) {
        break label62;
      }
    }
    label62:
    for (IQH = false;; IQH = ((Boolean)localObject).booleanValue())
    {
      c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", new Object[] { Boolean.valueOf(IQH) });
      mInitialized = true;
      if (IQH) {
        break;
      }
      AppMethodBeat.o(148758);
      return true;
    }
    AppMethodBeat.o(148758);
    return false;
  }
  
  public static final Class<?> fuj()
  {
    AppMethodBeat.i(148759);
    Object localObject = aVc("WxSVGRawClass");
    if (localObject != null)
    {
      localObject = (Class)localObject;
      AppMethodBeat.o(148759);
      return localObject;
    }
    AppMethodBeat.o(148759);
    return null;
  }
  
  public static long fuk()
  {
    AppMethodBeat.i(148760);
    long l = System.nanoTime();
    AppMethodBeat.o(148760);
    return l;
  }
  
  public static final void wT(boolean paramBoolean)
  {
    IQI = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.b.b
 * JD-Core Version:    0.7.0.1
 */