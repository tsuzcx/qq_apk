package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class he
  implements Cloneable
{
  private static final hg<Integer> d;
  private static final hg<Number> e;
  int a;
  Class<?> b;
  hc c = null;
  private hg f;
  
  static
  {
    AppMethodBeat.i(148069);
    d = new ha();
    e = new gx();
    AppMethodBeat.o(148069);
  }
  
  private he(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static he a(int paramInt, hg<Object> paramhg, Object... paramVarArgs)
  {
    AppMethodBeat.i(148062);
    he localhe = new he(paramInt);
    localhe.a(paramVarArgs);
    localhe.a(paramhg);
    AppMethodBeat.o(148062);
    return localhe;
  }
  
  public static he a(int paramInt, double... paramVarArgs)
  {
    AppMethodBeat.i(148061);
    paramVarArgs = new a(paramInt, paramVarArgs);
    AppMethodBeat.o(148061);
    return paramVarArgs;
  }
  
  public he a()
  {
    AppMethodBeat.i(148065);
    try
    {
      he localhe = (he)super.clone();
      localhe.a = this.a;
      localhe.c = this.c.b();
      localhe.f = this.f;
      AppMethodBeat.o(148065);
      return localhe;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AppMethodBeat.o(148065);
    }
    return null;
  }
  
  public void a(hg paramhg)
  {
    AppMethodBeat.i(148066);
    this.f = paramhg;
    this.c.a(paramhg);
    AppMethodBeat.o(148066);
  }
  
  public void a(double... paramVarArgs)
  {
    AppMethodBeat.i(148063);
    this.b = Double.TYPE;
    this.c = hc.a(paramVarArgs);
    AppMethodBeat.o(148063);
  }
  
  public void a(Object... paramVarArgs)
  {
    AppMethodBeat.i(148064);
    this.b = paramVarArgs[0].getClass();
    this.c = hc.a(paramVarArgs);
    AppMethodBeat.o(148064);
  }
  
  public int b()
  {
    return this.a;
  }
  
  public String toString()
  {
    AppMethodBeat.i(148067);
    String str = this.a + ": " + this.c.toString();
    AppMethodBeat.o(148067);
    return str;
  }
  
  static class a
    extends he
  {
    gy d;
    
    public a(int paramInt, double... paramVarArgs)
    {
      super(null);
      AppMethodBeat.i(148056);
      a(paramVarArgs);
      AppMethodBeat.o(148056);
    }
    
    public void a(double... paramVarArgs)
    {
      AppMethodBeat.i(148057);
      super.a(paramVarArgs);
      this.d = ((gy)this.c);
      AppMethodBeat.o(148057);
    }
    
    public a c()
    {
      AppMethodBeat.i(148058);
      a locala = (a)super.a();
      locala.d = ((gy)locala.c);
      AppMethodBeat.o(148058);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.he
 * JD-Core Version:    0.7.0.1
 */