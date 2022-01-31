package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class ei$a
  implements Serializable, GenericArrayType
{
  private final Type a;
  
  public ei$a(Type paramType)
  {
    AppMethodBeat.i(147530);
    this.a = ei.d(paramType);
    AppMethodBeat.o(147530);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(147531);
    if (((paramObject instanceof GenericArrayType)) && (ei.a(this, (GenericArrayType)paramObject)))
    {
      AppMethodBeat.o(147531);
      return true;
    }
    AppMethodBeat.o(147531);
    return false;
  }
  
  public final Type getGenericComponentType()
  {
    return this.a;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(147532);
    int i = this.a.hashCode();
    AppMethodBeat.o(147532);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147533);
    String str = ei.f(this.a) + "[]";
    AppMethodBeat.o(147533);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ei.a
 * JD-Core Version:    0.7.0.1
 */