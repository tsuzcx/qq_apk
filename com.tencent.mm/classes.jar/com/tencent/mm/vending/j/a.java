package com.tencent.mm.vending.j;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public Object[] HQZ;
  
  public static <$1, $2> c<$1, $2> L($1 param$1, $2 param$2)
  {
    AppMethodBeat.i(74900);
    c localc = new c();
    localc.HQZ = new Object[] { param$1, param$2 };
    param$1 = (c)localc;
    AppMethodBeat.o(74900);
    return param$1;
  }
  
  public static <$1, $2, $3, $4> e<$1, $2, $3, $4> c($1 param$1, $2 param$2, $3 param$3, $4 param$4)
  {
    AppMethodBeat.i(74902);
    e locale = new e();
    locale.HQZ = new Object[] { param$1, param$2, param$3, param$4 };
    param$1 = (e)locale;
    AppMethodBeat.o(74902);
    return param$1;
  }
  
  public static <$1> b<$1> eg($1 param$1)
  {
    AppMethodBeat.i(74899);
    b localb = new b();
    localb.HQZ = new Object[] { param$1 };
    param$1 = (b)localb;
    AppMethodBeat.o(74899);
    return param$1;
  }
  
  public static <$1, $2, $3> d<$1, $2, $3> i($1 param$1, $2 param$2, $3 param$3)
  {
    AppMethodBeat.i(74901);
    d locald = new d();
    locald.HQZ = new Object[] { param$1, param$2, param$3 };
    param$1 = (d)locald;
    AppMethodBeat.o(74901);
    return param$1;
  }
  
  public final <T> T get(int paramInt)
  {
    if (this.HQZ.length <= paramInt) {
      return null;
    }
    return this.HQZ[paramInt];
  }
  
  public final int size()
  {
    if (this.HQZ == null) {
      return 0;
    }
    return this.HQZ.length;
  }
  
  public String toString()
  {
    AppMethodBeat.i(74903);
    Object localObject1 = new StringBuilder();
    int j = 1;
    Object[] arrayOfObject = this.HQZ;
    int k = arrayOfObject.length;
    int i = 0;
    if (i < k)
    {
      Object localObject2 = arrayOfObject[i];
      if (j != 0) {
        j = 0;
      }
      for (;;)
      {
        ((StringBuilder)localObject1).append(localObject2);
        i += 1;
        break;
        ((StringBuilder)localObject1).append(",");
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(74903);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.j.a
 * JD-Core Version:    0.7.0.1
 */