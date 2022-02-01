package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class b
{
  private static boolean Ovi = false;
  private static boolean Ovj = false;
  private static boolean mInitialized;
  private static String mPackageName = "";
  
  static
  {
    mInitialized = false;
  }
  
  public static final void AP(boolean paramBoolean)
  {
    Ovj = paramBoolean;
  }
  
  public static long Nn(long paramLong)
  {
    AppMethodBeat.i(148761);
    paramLong = (System.nanoTime() - paramLong) / 1000L;
    AppMethodBeat.o(148761);
    return paramLong;
  }
  
  private static final Object blC(String paramString)
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
  
  public static final boolean gFW()
  {
    return Ovj;
  }
  
  public static final boolean gFX()
  {
    AppMethodBeat.i(148758);
    Object localObject;
    if (!mInitialized)
    {
      localObject = blC("WxSVGCode");
      if (localObject != null) {
        break label62;
      }
    }
    label62:
    for (Ovi = false;; Ovi = ((Boolean)localObject).booleanValue())
    {
      c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", new Object[] { Boolean.valueOf(Ovi) });
      mInitialized = true;
      if (Ovi) {
        break;
      }
      AppMethodBeat.o(148758);
      return true;
    }
    AppMethodBeat.o(148758);
    return false;
  }
  
  public static final Class<?> gFY()
  {
    AppMethodBeat.i(148759);
    Object localObject = blC("WxSVGRawClass");
    if (localObject != null)
    {
      localObject = (Class)localObject;
      AppMethodBeat.o(148759);
      return localObject;
    }
    AppMethodBeat.o(148759);
    return null;
  }
  
  public static long gFZ()
  {
    AppMethodBeat.i(148760);
    long l = System.nanoTime();
    AppMethodBeat.o(148760);
    return l;
  }
  
  public static void gm(String paramString)
  {
    mPackageName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.b.b
 * JD-Core Version:    0.7.0.1
 */