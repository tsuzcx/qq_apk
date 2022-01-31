package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;

class ej$3
  implements eo<T>
{
  private final er d;
  
  ej$3(ej paramej, Class paramClass, Type paramType)
  {
    AppMethodBeat.i(147569);
    this.d = er.a();
    AppMethodBeat.o(147569);
  }
  
  public T a()
  {
    AppMethodBeat.i(147570);
    try
    {
      Object localObject = this.d.a(this.a);
      AppMethodBeat.o(147570);
      return localObject;
    }
    catch (Exception localException)
    {
      RuntimeException localRuntimeException = new RuntimeException("Unable to invoke no-args constructor for " + this.b + ". Register an InstanceCreator with Gson for this type may fix this problem.", localException);
      AppMethodBeat.o(147570);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ej.3
 * JD-Core Version:    0.7.0.1
 */