package com.tencent.mm.plugin.normsg.b;

import android.os.IInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class b$c$1
  implements InvocationHandler
{
  b$c$1(b.c paramc) {}
  
  public final Object invoke(Object arg1, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(10398);
    Object localObject;
    synchronized (this.phR.phI)
    {
      localObject = paramMethod.getName();
      if (b.bjK().equals(localObject))
      {
        paramMethod = b.b(this.phR.phI);
        AppMethodBeat.o(10398);
        return paramMethod;
      }
    }
    try
    {
      paramArrayOfObject = paramMethod.invoke(this.phR.phT.asBinder(), paramArrayOfObject);
      AppMethodBeat.o(10398);
      return paramArrayOfObject;
    }
    catch (InvocationTargetException paramArrayOfObject)
    {
      paramArrayOfObject = paramArrayOfObject.getTargetException();
      localObject = paramMethod.getExceptionTypes();
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = paramMethod.getExceptionTypes();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i].isAssignableFrom(paramArrayOfObject.getClass()))
          {
            AppMethodBeat.o(10398);
            throw paramArrayOfObject;
            paramMethod = finally;
            AppMethodBeat.o(10398);
            throw paramMethod;
          }
          i += 1;
        }
      }
      b.a(this.phR.phI, paramArrayOfObject);
      paramMethod = b.c(paramMethod);
      AppMethodBeat.o(10398);
      return paramMethod;
    }
    catch (Throwable paramArrayOfObject)
    {
      b.a(this.phR.phI, paramArrayOfObject);
      paramMethod = b.c(paramMethod);
      AppMethodBeat.o(10398);
    }
    return paramMethod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.c.1
 * JD-Core Version:    0.7.0.1
 */