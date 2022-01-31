package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class nu<T>
{
  private static final oi b;
  private static final nu<Object> c;
  final nu.a<T> a;
  
  static
  {
    AppMethodBeat.i(149582);
    b = ok.a().c();
    c = a(new nu.1());
    AppMethodBeat.o(149582);
  }
  
  protected nu(nu.a<T> parama)
  {
    this.a = parama;
  }
  
  public static final <T> nu<T> a()
  {
    return c;
  }
  
  public static final <T> nu<T> a(nu.a<T> parama)
  {
    AppMethodBeat.i(149578);
    parama = new nu(b.a(parama));
    AppMethodBeat.o(149578);
    return parama;
  }
  
  public final ny a(nx<? super T> paramnx)
  {
    AppMethodBeat.i(149581);
    if (paramnx == null)
    {
      paramnx = new IllegalArgumentException("observer can not be null");
      AppMethodBeat.o(149581);
      throw paramnx;
    }
    if (this.a == null)
    {
      paramnx = new IllegalStateException("onSubscribe function can not be null.");
      AppMethodBeat.o(149581);
      throw paramnx;
    }
    paramnx.d();
    Object localObject = paramnx;
    if (!(paramnx instanceof og)) {
      localObject = new og(paramnx);
    }
    try
    {
      b.a(this, this.a).a(localObject);
      paramnx = b.a((ny)localObject);
      AppMethodBeat.o(149581);
      return paramnx;
    }
    catch (Throwable paramnx)
    {
      oa.a(paramnx);
      try
      {
        ((nx)localObject).a(b.a(paramnx));
        paramnx = ol.a();
        AppMethodBeat.o(149581);
        return paramnx;
      }
      catch (oc paramnx)
      {
        AppMethodBeat.o(149581);
        throw paramnx;
      }
      catch (Throwable localThrowable)
      {
        paramnx = new RuntimeException("Error occurred attempting to subscribe [" + paramnx.getMessage() + "] and then again while trying to pass to onError.", localThrowable);
        b.a(paramnx);
        AppMethodBeat.o(149581);
        throw paramnx;
      }
    }
  }
  
  public final void a(od<? super T> paramod)
  {
    AppMethodBeat.i(149579);
    b(paramod);
    AppMethodBeat.o(149579);
  }
  
  public final ny b(od<? super T> paramod)
  {
    AppMethodBeat.i(149580);
    if (paramod == null)
    {
      paramod = new IllegalArgumentException("onNext can not be null");
      AppMethodBeat.o(149580);
      throw paramod;
    }
    paramod = a(new nu.2(this, paramod));
    AppMethodBeat.o(149580);
    return paramod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nu
 * JD-Core Version:    0.7.0.1
 */