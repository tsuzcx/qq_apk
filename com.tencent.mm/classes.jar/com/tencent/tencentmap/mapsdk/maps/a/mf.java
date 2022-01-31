package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class mf<T, S extends mq>
  implements mg<T, S>
{
  private final List<md<T, S>> a;
  private final mv b;
  private final mc c;
  
  mf(List<md<T, S>> paramList, mc parammc)
  {
    AppMethodBeat.i(149293);
    this.a = paramList;
    this.c = parammc;
    this.b = mp.a(paramList);
    AppMethodBeat.o(149293);
  }
  
  private List<mg<T, S>> a(mt<md<T, S>> parammt)
  {
    AppMethodBeat.i(149297);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new mf(parammt.a().a(), this.c));
    localArrayList.add(new mf(parammt.b().a(), this.c));
    AppMethodBeat.o(149297);
    return localArrayList;
  }
  
  final List<md<T, S>> a()
  {
    return this.a;
  }
  
  public final List<mg<T, S>> a(md<? extends T, ? extends S> parammd)
  {
    AppMethodBeat.i(149296);
    parammd = mp.a(this.a, parammd);
    if (parammd.size() <= this.c.a())
    {
      parammd = Collections.singletonList(new mf(parammd, this.c));
      AppMethodBeat.o(149296);
      return parammd;
    }
    parammd = a(this.c.c().a(parammd, this.c.b()));
    AppMethodBeat.o(149296);
    return parammd;
  }
  
  public final void a(oe<? super mq, Boolean> paramoe, nx<? super md<T, S>> paramnx)
  {
    AppMethodBeat.i(149294);
    if (!((Boolean)paramoe.a(b().a())).booleanValue())
    {
      AppMethodBeat.o(149294);
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      md localmd = (md)localIterator.next();
      if (paramnx.c())
      {
        AppMethodBeat.o(149294);
        return;
      }
      if (((Boolean)paramoe.a(localmd.b())).booleanValue()) {
        paramnx.a(localmd);
      }
    }
    AppMethodBeat.o(149294);
  }
  
  public final mq b()
  {
    return this.b;
  }
  
  public final int c()
  {
    AppMethodBeat.i(149295);
    int i = this.a.size();
    AppMethodBeat.o(149295);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mf
 * JD-Core Version:    0.7.0.1
 */