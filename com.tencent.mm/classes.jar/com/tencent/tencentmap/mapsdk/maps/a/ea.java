package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ea<T>
  extends eb<T>
{
  private final dx<T> a;
  private final dp<T> b;
  private final dk c;
  private final fe<T> d;
  private final ec e;
  private eb<T> f;
  
  private ea(dx<T> paramdx, dp<T> paramdp, dk paramdk, fe<T> paramfe, ec paramec)
  {
    this.a = paramdx;
    this.b = paramdp;
    this.c = paramdk;
    this.d = paramfe;
    this.e = paramec;
  }
  
  private eb<T> a()
  {
    AppMethodBeat.i(147525);
    eb localeb = this.f;
    if (localeb != null)
    {
      AppMethodBeat.o(147525);
      return localeb;
    }
    localeb = this.c.a(this.e, this.d);
    this.f = localeb;
    AppMethodBeat.o(147525);
    return localeb;
  }
  
  public static ec a(fe<?> paramfe, Object paramObject)
  {
    AppMethodBeat.i(147526);
    paramfe = new ea.a(paramObject, paramfe, false, null, null);
    AppMethodBeat.o(147526);
    return paramfe;
  }
  
  public static ec b(fe<?> paramfe, Object paramObject)
  {
    AppMethodBeat.i(147527);
    if (paramfe.b() == paramfe.a()) {}
    for (boolean bool = true;; bool = false)
    {
      paramfe = new ea.a(paramObject, paramfe, bool, null, null);
      AppMethodBeat.o(147527);
      return paramfe;
    }
  }
  
  public final void a(fh paramfh, T paramT)
  {
    AppMethodBeat.i(147524);
    if (this.a == null)
    {
      a().a(paramfh, paramT);
      AppMethodBeat.o(147524);
      return;
    }
    if (paramT == null)
    {
      paramfh.f();
      AppMethodBeat.o(147524);
      return;
    }
    eq.a(this.a.a(paramT, this.d.b(), this.c.b), paramfh);
    AppMethodBeat.o(147524);
  }
  
  public final T b(ff paramff)
  {
    AppMethodBeat.i(147523);
    if (this.b == null)
    {
      paramff = a().b(paramff);
      AppMethodBeat.o(147523);
      return paramff;
    }
    paramff = eq.a(paramff);
    if (paramff.l())
    {
      AppMethodBeat.o(147523);
      return null;
    }
    paramff = this.b.b(paramff, this.d.b(), this.c.a);
    AppMethodBeat.o(147523);
    return paramff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ea
 * JD-Core Version:    0.7.0.1
 */