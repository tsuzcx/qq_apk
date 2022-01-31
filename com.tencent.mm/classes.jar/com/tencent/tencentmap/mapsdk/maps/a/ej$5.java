package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ej$5
  implements eo<T>
{
  ej$5(ej paramej, Constructor paramConstructor) {}
  
  public T a()
  {
    AppMethodBeat.i(147572);
    try
    {
      Object localObject = this.a.newInstance(null);
      AppMethodBeat.o(147572);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      RuntimeException localRuntimeException1 = new RuntimeException("Failed to invoke " + this.a + " with no args", localInstantiationException);
      AppMethodBeat.o(147572);
      throw localRuntimeException1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      RuntimeException localRuntimeException2 = new RuntimeException("Failed to invoke " + this.a + " with no args", localInvocationTargetException.getTargetException());
      AppMethodBeat.o(147572);
      throw localRuntimeException2;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      AssertionError localAssertionError = new AssertionError(localIllegalAccessException);
      AppMethodBeat.o(147572);
      throw localAssertionError;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ej.5
 * JD-Core Version:    0.7.0.1
 */