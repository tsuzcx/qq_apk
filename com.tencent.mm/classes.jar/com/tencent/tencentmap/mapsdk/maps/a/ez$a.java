package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class ez$a<T>
  extends eb<T>
{
  private final eo<T> b;
  private final Map<String, ez.b> c;
  
  private ez$a(eo<T> parameo, Map<String, ez.b> paramMap)
  {
    this.b = paramMap;
    Object localObject;
    this.c = localObject;
  }
  
  public final void a(fh paramfh, T paramT)
  {
    AppMethodBeat.i(147720);
    if (paramT == null)
    {
      paramfh.f();
      AppMethodBeat.o(147720);
      return;
    }
    paramfh.d();
    try
    {
      Iterator localIterator = this.c.values().iterator();
      while (localIterator.hasNext())
      {
        ez.b localb = (ez.b)localIterator.next();
        if (localb.h)
        {
          paramfh.a(localb.g);
          localb.a(paramfh, paramT);
        }
      }
      paramfh.e();
    }
    catch (IllegalAccessException paramfh)
    {
      paramfh = new AssertionError();
      AppMethodBeat.o(147720);
      throw paramfh;
    }
    AppMethodBeat.o(147720);
  }
  
  public final T b(ff paramff)
  {
    AppMethodBeat.i(147719);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147719);
      return null;
    }
    Object localObject1 = this.b.a();
    try
    {
      paramff.c();
      for (;;)
      {
        if (!paramff.e()) {
          break label127;
        }
        localObject2 = paramff.g();
        localObject2 = (ez.b)this.c.get(localObject2);
        if ((localObject2 != null) && (((ez.b)localObject2).i)) {
          break;
        }
        paramff.n();
      }
    }
    catch (IllegalStateException paramff)
    {
      for (;;)
      {
        Object localObject2;
        paramff = new dy(paramff);
        AppMethodBeat.o(147719);
        throw paramff;
        ((ez.b)localObject2).a(paramff, localObject1);
      }
    }
    catch (IllegalAccessException paramff)
    {
      paramff = new AssertionError(paramff);
      AppMethodBeat.o(147719);
      throw paramff;
    }
    label127:
    paramff.d();
    AppMethodBeat.o(147719);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ez.a
 * JD-Core Version:    0.7.0.1
 */