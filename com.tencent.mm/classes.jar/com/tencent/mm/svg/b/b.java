package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class b
{
  private static boolean Jlp = false;
  private static boolean Jlq = false;
  private static boolean mInitialized;
  private static String mPackageName = "";
  
  static
  {
    mInitialized = false;
  }
  
  public static long Ej(long paramLong)
  {
    AppMethodBeat.i(148761);
    paramLong = (System.nanoTime() - paramLong) / 1000L;
    AppMethodBeat.o(148761);
    return paramLong;
  }
  
  private static final Object aWD(String paramString)
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
  
  public static final boolean fyi()
  {
    return Jlq;
  }
  
  public static final boolean fyj()
  {
    AppMethodBeat.i(148758);
    Object localObject;
    if (!mInitialized)
    {
      localObject = aWD("WxSVGCode");
      if (localObject != null) {
        break label62;
      }
    }
    label62:
    for (Jlp = false;; Jlp = ((Boolean)localObject).booleanValue())
    {
      c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", new Object[] { Boolean.valueOf(Jlp) });
      mInitialized = true;
      if (Jlp) {
        break;
      }
      AppMethodBeat.o(148758);
      return true;
    }
    AppMethodBeat.o(148758);
    return false;
  }
  
  public static final Class<?> fyk()
  {
    AppMethodBeat.i(148759);
    Object localObject = aWD("WxSVGRawClass");
    if (localObject != null)
    {
      localObject = (Class)localObject;
      AppMethodBeat.o(148759);
      return localObject;
    }
    AppMethodBeat.o(148759);
    return null;
  }
  
  public static long fyl()
  {
    AppMethodBeat.i(148760);
    long l = System.nanoTime();
    AppMethodBeat.o(148760);
    return l;
  }
  
  public static void fz(String paramString)
  {
    mPackageName = paramString;
  }
  
  public static final void xb(boolean paramBoolean)
  {
    Jlq = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.b.b
 * JD-Core Version:    0.7.0.1
 */