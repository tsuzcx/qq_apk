package com.tencent.mm.svg.b;

import java.lang.reflect.Field;

public final class b
{
  private static boolean dNk = false;
  private static String mPackageName = "";
  private static boolean uFL = false;
  private static boolean uFM = false;
  
  private static final Object acR(String paramString)
  {
    try
    {
      Class localClass = Class.forName(mPackageName + ".svg.SVGBuildConfig");
      paramString = localClass.getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString = paramString.get(localClass);
      return paramString;
    }
    catch (NoSuchFieldException paramString)
    {
      c.printErrStackTrace("MicroMSG.WeChatSVGConfig", paramString, "NoSuchFieldException", new Object[0]);
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
  
  public static void cq(String paramString)
  {
    mPackageName = paramString;
  }
  
  public static final boolean cxr()
  {
    return uFM;
  }
  
  public static final boolean cxs()
  {
    Object localObject;
    if (!dNk)
    {
      localObject = acR("WxSVGCode");
      if (localObject != null) {
        break label52;
      }
    }
    label52:
    for (uFL = false;; uFL = ((Boolean)localObject).booleanValue())
    {
      c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", new Object[] { Boolean.valueOf(uFL) });
      dNk = true;
      if (uFL) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static final Class<?> cxt()
  {
    Object localObject = acR("WxSVGRawClass");
    if (localObject != null) {
      return (Class)localObject;
    }
    return null;
  }
  
  public static long cxu()
  {
    return System.nanoTime();
  }
  
  public static long hJ(long paramLong)
  {
    return (System.nanoTime() - paramLong) / 1000L;
  }
  
  public static final void mE(boolean paramBoolean)
  {
    uFM = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.b.b
 * JD-Core Version:    0.7.0.1
 */