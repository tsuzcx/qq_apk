package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class mi<T, S extends mq>
  implements mg<T, S>
{
  private final List<? extends mg<T, S>> a;
  private final mv b;
  private final mc c;
  
  mi(List<? extends mg<T, S>> paramList, mc parammc)
  {
    AppMethodBeat.i(149299);
    if (paramList.isEmpty())
    {
      paramList = new IllegalArgumentException();
      AppMethodBeat.o(149299);
      throw paramList;
    }
    this.c = parammc;
    this.a = paramList;
    this.b = mp.a(paramList);
    AppMethodBeat.o(149299);
  }
  
  private List<mg<T, S>> a(mt<? extends mg<T, S>> parammt)
  {
    AppMethodBeat.i(149303);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new mi(parammt.a().a(), this.c));
    localArrayList.add(new mi(parammt.b().a(), this.c));
    AppMethodBeat.o(149303);
    return localArrayList;
  }
  
  final List<? extends mg<T, S>> a()
  {
    return this.a;
  }
  
  public final List<mg<T, S>> a(md<? extends T, ? extends S> parammd)
  {
    AppMethodBeat.i(149302);
    mg localmg = this.c.d().a(parammd.b().a(), this.a);
    parammd = localmg.a(parammd);
    parammd = mp.a(this.a, localmg, parammd);
    if (parammd.size() <= this.c.a())
    {
      parammd = Collections.singletonList(new mi(parammd, this.c));
      AppMethodBeat.o(149302);
      return parammd;
    }
    parammd = a(this.c.c().a(parammd, this.c.b()));
    AppMethodBeat.o(149302);
    return parammd;
  }
  
  public final void a(oe<? super mq, Boolean> paramoe, nx<? super md<T, S>> paramnx)
  {
    AppMethodBeat.i(149300);
    if (!((Boolean)paramoe.a(b().a())).booleanValue())
    {
      AppMethodBeat.o(149300);
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      mg localmg = (mg)localIterator.next();
      if (paramnx.c())
      {
        AppMethodBeat.o(149300);
        return;
      }
      localmg.a(paramoe, paramnx);
    }
    AppMethodBeat.o(149300);
  }
  
  public final mq b()
  {
    return this.b;
  }
  
  public final int c()
  {
    AppMethodBeat.i(149301);
    int i = this.a.size();
    AppMethodBeat.o(149301);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mi
 * JD-Core Version:    0.7.0.1
 */