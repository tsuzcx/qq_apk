package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

final class et$a<E>
  extends eb<Collection<E>>
{
  private final dk b;
  private final Type c;
  private final eb<E> d;
  private final eo<? extends Collection<E>> e;
  
  public et$a(dk paramdk, Type paramType, eb<E> parameb, eo<? extends Collection<E>> parameo)
  {
    AppMethodBeat.i(147645);
    this.b = paramType;
    this.c = parameb;
    this.d = new fc(paramType, parameo, parameb);
    Object localObject;
    this.e = localObject;
    AppMethodBeat.o(147645);
  }
  
  public final Collection<E> a(ff paramff)
  {
    AppMethodBeat.i(147646);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147646);
      return null;
    }
    Collection localCollection = (Collection)this.e.a();
    paramff.a();
    while (paramff.e()) {
      localCollection.add(this.d.b(paramff));
    }
    paramff.b();
    AppMethodBeat.o(147646);
    return localCollection;
  }
  
  public final void a(fh paramfh, Collection<E> paramCollection)
  {
    AppMethodBeat.i(147647);
    if (paramCollection == null)
    {
      paramfh.f();
      AppMethodBeat.o(147647);
      return;
    }
    paramfh.b();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      this.d.a(paramfh, localObject);
    }
    paramfh.c();
    AppMethodBeat.o(147647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.et.a
 * JD-Core Version:    0.7.0.1
 */