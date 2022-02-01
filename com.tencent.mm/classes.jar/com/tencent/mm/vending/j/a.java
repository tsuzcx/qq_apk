package com.tencent.mm.vending.j;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private Object[] YBh;
  
  public static <$1, $2> c<$1, $2> J($1 param$1, $2 param$2)
  {
    AppMethodBeat.i(74900);
    c localc = new c();
    localc.YBh = new Object[] { param$1, param$2 };
    param$1 = (c)localc;
    AppMethodBeat.o(74900);
    return param$1;
  }
  
  public static <$1, $2, $3, $4> e<$1, $2, $3, $4> c($1 param$1, $2 param$2, $3 param$3, $4 param$4)
  {
    AppMethodBeat.i(74902);
    e locale = new e();
    locale.YBh = new Object[] { param$1, param$2, param$3, param$4 };
    param$1 = (e)locale;
    AppMethodBeat.o(74902);
    return param$1;
  }
  
  public static <$1, $2, $3, $4, $5> f<$1, $2, $3, $4, $5> c($1 param$1, $2 param$2, $3 param$3, $4 param$4, $5 param$5)
  {
    AppMethodBeat.i(247740);
    f localf = new f();
    localf.YBh = new Object[] { param$1, param$2, param$3, param$4, param$5 };
    param$1 = (f)localf;
    AppMethodBeat.o(247740);
    return param$1;
  }
  
  public static <$1, $2, $3, $4, $5, $6, $7> h<$1, $2, $3, $4, $5, $6, $7> c($1 param$1, $2 param$2, $3 param$3, $4 param$4, $5 param$5, $6 param$6, $7 param$7)
  {
    AppMethodBeat.i(247742);
    h localh = new h();
    localh.YBh = new Object[] { param$1, param$2, param$3, param$4, param$5, param$6, param$7 };
    param$1 = (h)localh;
    AppMethodBeat.o(247742);
    return param$1;
  }
  
  public static <$1> b<$1> ev($1 param$1)
  {
    AppMethodBeat.i(74899);
    b localb = new b();
    localb.YBh = new Object[] { param$1 };
    param$1 = (b)localb;
    AppMethodBeat.o(74899);
    return param$1;
  }
  
  public static <$1, $2, $3> d<$1, $2, $3> h($1 param$1, $2 param$2, $3 param$3)
  {
    AppMethodBeat.i(74901);
    d locald = new d();
    locald.YBh = new Object[] { param$1, param$2, param$3 };
    param$1 = (d)locald;
    AppMethodBeat.o(74901);
    return param$1;
  }
  
  final <T> T J(Object... paramVarArgs)
  {
    this.YBh = paramVarArgs;
    return this;
  }
  
  public final <T> T get(int paramInt)
  {
    if (this.YBh.length <= paramInt) {
      return null;
    }
    return this.YBh[paramInt];
  }
  
  public final int size()
  {
    if (this.YBh == null) {
      return 0;
    }
    return this.YBh.length;
  }
  
  public String toString()
  {
    AppMethodBeat.i(74903);
    Object localObject1 = new StringBuilder();
    int j = 1;
    Object[] arrayOfObject = this.YBh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.j.a
 * JD-Core Version:    0.7.0.1
 */