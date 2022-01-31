package org.apache.commons.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public final class a
{
  public static Constructor a(Class paramClass, Class[] paramArrayOfClass)
  {
    AppMethodBeat.i(142950);
    try
    {
      Constructor localConstructor = paramClass.getConstructor(paramArrayOfClass);
      b.a(localConstructor);
      AppMethodBeat.o(142950);
      return localConstructor;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Constructor[] arrayOfConstructor = paramClass.getConstructors();
      int i = 0;
      Object localObject1 = null;
      if (i < arrayOfConstructor.length)
      {
        Object localObject2 = localObject1;
        if (org.apache.commons.b.b.a(paramArrayOfClass, arrayOfConstructor[i].getParameterTypes()))
        {
          paramClass = arrayOfConstructor[i];
          if ((!b.c(paramClass)) || (!Modifier.isPublic(paramClass.getDeclaringClass().getModifiers()))) {
            break label128;
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (paramClass != null)
          {
            b.a(paramClass);
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (b.a(paramClass.getParameterTypes(), localObject1.getParameterTypes(), paramArrayOfClass) >= 0) {}
            }
            else
            {
              localObject2 = paramClass;
            }
          }
          i += 1;
          localObject1 = localObject2;
          break;
          label128:
          paramClass = null;
        }
      }
      AppMethodBeat.o(142950);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.apache.commons.b.c.a
 * JD-Core Version:    0.7.0.1
 */