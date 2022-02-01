package com.tencent.tmediacodec.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class c
{
  public static final Class<?>[] SmY = new Class[0];
  public static final Object[] SmZ = new Object[0];
  
  public static Field k(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(190192);
    paramClass = m(paramClass, paramString);
    AppMethodBeat.o(190192);
    return paramClass;
  }
  
  private static Field m(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(190191);
    Object localObject = null;
    Class localClass;
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      localObject = localField;
      AppMethodBeat.o(190191);
      return localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      localClass = paramClass.getSuperclass();
      paramClass = (Class<?>)localObject;
    }
    for (;;)
    {
      localObject = paramClass;
      if (paramClass != null) {
        break;
      }
      localObject = paramClass;
      if (localClass == null) {
        break;
      }
      try
      {
        localObject = localClass.getDeclaredField(paramString);
        paramClass = (Class<?>)localObject;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        localClass = localClass.getSuperclass();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmediacodec.g.c
 * JD-Core Version:    0.7.0.1
 */