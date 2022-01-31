package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ma
{
  private static <T, S extends mq> ma.a<mh<T, S>> a(oe<? super mq, Boolean> paramoe, nx<? super md<T, S>> paramnx, ma.a<mh<T, S>> parama, mh<T, S> parammh)
  {
    AppMethodBeat.i(149267);
    md localmd = (md)((mf)parammh.a()).a().get(parammh.b());
    if (((Boolean)paramoe.a(localmd.b())).booleanValue()) {
      paramnx.a(localmd);
    }
    for (long l = ma.a.b(parama) - 1L;; l = ma.a.b(parama))
    {
      paramoe = ma.a.a(ma.a.a(parama).d().b(parammh.c()), l);
      AppMethodBeat.o(149267);
      return paramoe;
    }
  }
  
  private static <S extends mq, T> mw<mh<T, S>> a(mw<mh<T, S>> parammw)
  {
    AppMethodBeat.i(149268);
    parammw = parammw.d();
    if (!parammw.b())
    {
      mh localmh = (mh)parammw.c();
      parammw = parammw.d().b(localmh.c());
    }
    for (;;)
    {
      AppMethodBeat.o(149268);
      return parammw;
    }
  }
  
  private static <S extends mq, T> mw<mh<T, S>> a(oe<? super mq, Boolean> paramoe, mw<mh<T, S>> parammw, mh<T, S> parammh)
  {
    AppMethodBeat.i(149269);
    mg localmg = (mg)((mi)parammh.a()).a().get(parammh.b());
    if (((Boolean)paramoe.a(localmg.b())).booleanValue()) {}
    for (paramoe = parammw.b(new mh(localmg, 0));; paramoe = parammw.d().b(parammh.c()))
    {
      AppMethodBeat.o(149269);
      return paramoe;
    }
  }
  
  private static <S extends mq, T> mw<mh<T, S>> a(oe<? super mq, Boolean> paramoe, nx<? super md<T, S>> paramnx, ma.a<mh<T, S>> parama)
  {
    AppMethodBeat.i(149266);
    while (!ma.a.a(parama).b())
    {
      mh localmh = (mh)ma.a.a(parama).c();
      if (paramnx.c())
      {
        paramoe = mw.a();
        AppMethodBeat.o(149266);
        return paramoe;
      }
      if (ma.a.b(parama) <= 0L)
      {
        paramoe = ma.a.a(parama);
        AppMethodBeat.o(149266);
        return paramoe;
      }
      if (localmh.b() == localmh.a().c()) {
        parama = ma.a.a(a(ma.a.a(parama)), ma.a.b(parama));
      } else if ((localmh.a() instanceof mi)) {
        parama = ma.a.a(a(paramoe, ma.a.a(parama), localmh), ma.a.b(parama));
      } else {
        parama = a(paramoe, paramnx, parama, localmh);
      }
    }
    paramoe = ma.a.a(parama);
    AppMethodBeat.o(149266);
    return paramoe;
  }
  
  static <T, S extends mq> mw<mh<T, S>> a(oe<? super mq, Boolean> paramoe, nx<? super md<T, S>> paramnx, mw<mh<T, S>> parammw, long paramLong)
  {
    AppMethodBeat.i(149265);
    paramoe = a(paramoe, paramnx, ma.a.a(parammw, paramLong));
    AppMethodBeat.o(149265);
    return paramoe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ma
 * JD-Core Version:    0.7.0.1
 */