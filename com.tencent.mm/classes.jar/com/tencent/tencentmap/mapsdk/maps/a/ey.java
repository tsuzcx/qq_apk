package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ey
  extends eb<Object>
{
  public static final ec a;
  private final dk b;
  
  static
  {
    AppMethodBeat.i(147715);
    a = new ey.1();
    AppMethodBeat.o(147715);
  }
  
  private ey(dk paramdk)
  {
    this.b = paramdk;
  }
  
  public final void a(fh paramfh, Object paramObject)
  {
    AppMethodBeat.i(147714);
    if (paramObject == null)
    {
      paramfh.f();
      AppMethodBeat.o(147714);
      return;
    }
    eb localeb = this.b.a(paramObject.getClass());
    if ((localeb instanceof ey))
    {
      paramfh.d();
      paramfh.e();
      AppMethodBeat.o(147714);
      return;
    }
    localeb.a(paramfh, paramObject);
    AppMethodBeat.o(147714);
  }
  
  public final Object b(ff paramff)
  {
    AppMethodBeat.i(147713);
    Object localObject = paramff.f();
    switch (ey.2.a[localObject.ordinal()])
    {
    default: 
      paramff = new IllegalStateException();
      AppMethodBeat.o(147713);
      throw paramff;
    case 1: 
      localObject = new ArrayList();
      paramff.a();
      while (paramff.e()) {
        ((List)localObject).add(b(paramff));
      }
      paramff.b();
      AppMethodBeat.o(147713);
      return localObject;
    case 2: 
      localObject = new en();
      paramff.c();
      while (paramff.e()) {
        ((Map)localObject).put(paramff.g(), b(paramff));
      }
      paramff.d();
      AppMethodBeat.o(147713);
      return localObject;
    case 3: 
      paramff = paramff.h();
      AppMethodBeat.o(147713);
      return paramff;
    case 4: 
      double d = paramff.k();
      AppMethodBeat.o(147713);
      return Double.valueOf(d);
    case 5: 
      boolean bool = paramff.i();
      AppMethodBeat.o(147713);
      return Boolean.valueOf(bool);
    }
    paramff.j();
    AppMethodBeat.o(147713);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ey
 * JD-Core Version:    0.7.0.1
 */