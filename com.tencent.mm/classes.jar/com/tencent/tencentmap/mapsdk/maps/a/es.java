package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class es<E>
  extends eb<Object>
{
  public static final ec a;
  private final dk b;
  private final Class<E> c;
  private final eb<E> d;
  
  static
  {
    AppMethodBeat.i(147644);
    a = new es.1();
    AppMethodBeat.o(147644);
  }
  
  public es(dk paramdk, eb<E> parameb, Class<E> paramClass)
  {
    AppMethodBeat.i(147641);
    this.b = paramdk;
    this.d = new fc(paramdk, parameb, paramClass);
    this.c = paramClass;
    AppMethodBeat.o(147641);
  }
  
  public final void a(fh paramfh, Object paramObject)
  {
    AppMethodBeat.i(147643);
    if (paramObject == null)
    {
      paramfh.f();
      AppMethodBeat.o(147643);
      return;
    }
    paramfh.b();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.d.a(paramfh, localObject);
      i += 1;
    }
    paramfh.c();
    AppMethodBeat.o(147643);
  }
  
  public final Object b(ff paramff)
  {
    AppMethodBeat.i(147642);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147642);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramff.a();
    while (paramff.e()) {
      localArrayList.add(this.d.b(paramff));
    }
    paramff.b();
    paramff = Array.newInstance(this.c, localArrayList.size());
    int i = 0;
    while (i < localArrayList.size())
    {
      Array.set(paramff, i, localArrayList.get(i));
      i += 1;
    }
    AppMethodBeat.o(147642);
    return paramff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.es
 * JD-Core Version:    0.7.0.1
 */