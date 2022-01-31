package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class b
{
  private static boolean mInitialized = false;
  private static String mPackageName = "";
  private static boolean ySE = false;
  private static boolean ySF = false;
  
  private static final Object atf(String paramString)
  {
    AppMethodBeat.i(70123);
    try
    {
      Class localClass = Class.forName(mPackageName + ".svg.SVGBuildConfig");
      paramString = localClass.getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString = paramString.get(localClass);
      AppMethodBeat.o(70123);
      return paramString;
    }
    catch (NoSuchFieldException paramString)
    {
      c.printErrStackTrace("MicroMSG.WeChatSVGConfig", paramString, "NoSuchFieldException", new Object[0]);
      AppMethodBeat.o(70123);
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
  
  public static final boolean dAj()
  {
    return ySF;
  }
  
  public static final boolean dAk()
  {
    AppMethodBeat.i(70124);
    Object localObject;
    if (!mInitialized)
    {
      localObject = atf("WxSVGCode");
      if (localObject != null) {
        break label62;
      }
    }
    label62:
    for (ySE = false;; ySE = ((Boolean)localObject).booleanValue())
    {
      c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", new Object[] { Boolean.valueOf(ySE) });
      mInitialized = true;
      if (ySE) {
        break;
      }
      AppMethodBeat.o(70124);
      return true;
    }
    AppMethodBeat.o(70124);
    return false;
  }
  
  public static final Class<?> dAl()
  {
    AppMethodBeat.i(70125);
    Object localObject = atf("WxSVGRawClass");
    if (localObject != null)
    {
      localObject = (Class)localObject;
      AppMethodBeat.o(70125);
      return localObject;
    }
    AppMethodBeat.o(70125);
    return null;
  }
  
  public static long dAm()
  {
    AppMethodBeat.i(70126);
    long l = System.nanoTime();
    AppMethodBeat.o(70126);
    return l;
  }
  
  public static void dC(String paramString)
  {
    mPackageName = paramString;
  }
  
  public static long ot(long paramLong)
  {
    AppMethodBeat.i(70127);
    paramLong = (System.nanoTime() - paramLong) / 1000L;
    AppMethodBeat.o(70127);
    return paramLong;
  }
  
  public static final void pW(boolean paramBoolean)
  {
    ySF = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.b.b
 * JD-Core Version:    0.7.0.1
 */