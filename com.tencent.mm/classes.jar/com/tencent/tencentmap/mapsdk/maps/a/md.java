package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class md<T, S extends mq>
  implements ms
{
  private final T a;
  private final S b;
  
  public md(T paramT, S paramS)
  {
    AppMethodBeat.i(149282);
    if (paramS == null)
    {
      paramT = new IllegalArgumentException();
      AppMethodBeat.o(149282);
      throw paramT;
    }
    this.a = paramT;
    this.b = paramS;
    AppMethodBeat.o(149282);
  }
  
  public static <T, S extends mq> md<T, S> a(T paramT, S paramS)
  {
    AppMethodBeat.i(149283);
    paramT = new md(paramT, paramS);
    AppMethodBeat.o(149283);
    return paramT;
  }
  
  public final T a()
  {
    return this.a;
  }
  
  public final S b()
  {
    return this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(149286);
    if (paramObject == null)
    {
      AppMethodBeat.o(149286);
      return false;
    }
    if (!(paramObject instanceof md))
    {
      AppMethodBeat.o(149286);
      return false;
    }
    paramObject = (md)paramObject;
    int i;
    if ((this.a == paramObject.a) || ((this.a != null) && (this.a.equals(paramObject.a))))
    {
      i = 1;
      if ((this.b != paramObject.b) && ((this.b == null) || (!this.b.equals(paramObject.b)))) {
        break label123;
      }
    }
    label123:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label128;
      }
      AppMethodBeat.o(149286);
      return true;
      i = 0;
      break;
    }
    label128:
    AppMethodBeat.o(149286);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(149285);
    int i = Arrays.hashCode(new Object[] { this.a, this.b });
    AppMethodBeat.o(149285);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149284);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Entry [value=");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", geometry=");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(149284);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.md
 * JD-Core Version:    0.7.0.1
 */