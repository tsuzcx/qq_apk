package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class fd$18
  extends eb<dq>
{
  public final dq a(ff paramff)
  {
    AppMethodBeat.i(147780);
    switch (fd.26.a[paramff.f().ordinal()])
    {
    default: 
      paramff = new IllegalArgumentException();
      AppMethodBeat.o(147780);
      throw paramff;
    case 3: 
      paramff = new dv(paramff.h());
      AppMethodBeat.o(147780);
      return paramff;
    case 1: 
      paramff = new dv(new em(paramff.h()));
      AppMethodBeat.o(147780);
      return paramff;
    case 2: 
      paramff = new dv(Boolean.valueOf(paramff.i()));
      AppMethodBeat.o(147780);
      return paramff;
    case 4: 
      paramff.j();
      paramff = ds.a;
      AppMethodBeat.o(147780);
      return paramff;
    case 5: 
      localObject = new dn();
      paramff.a();
      while (paramff.e()) {
        ((dn)localObject).a(a(paramff));
      }
      paramff.b();
      AppMethodBeat.o(147780);
      return localObject;
    }
    Object localObject = new dt();
    paramff.c();
    while (paramff.e()) {
      ((dt)localObject).a(paramff.g(), a(paramff));
    }
    paramff.d();
    AppMethodBeat.o(147780);
    return localObject;
  }
  
  public final void a(fh paramfh, dq paramdq)
  {
    AppMethodBeat.i(147781);
    if ((paramdq == null) || (paramdq.l()))
    {
      paramfh.f();
      AppMethodBeat.o(147781);
      return;
    }
    if (paramdq.k())
    {
      paramdq = paramdq.o();
      if (paramdq.q())
      {
        paramfh.a(paramdq.b());
        AppMethodBeat.o(147781);
        return;
      }
      if (paramdq.a())
      {
        paramfh.a(paramdq.h());
        AppMethodBeat.o(147781);
        return;
      }
      paramfh.b(paramdq.c());
      AppMethodBeat.o(147781);
      return;
    }
    if (paramdq.i())
    {
      paramfh.b();
      paramdq = paramdq.n().iterator();
      while (paramdq.hasNext()) {
        a(paramfh, (dq)paramdq.next());
      }
      paramfh.c();
      AppMethodBeat.o(147781);
      return;
    }
    if (paramdq.j())
    {
      paramfh.d();
      paramdq = paramdq.m().a().iterator();
      while (paramdq.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramdq.next();
        paramfh.a((String)localEntry.getKey());
        a(paramfh, (dq)localEntry.getValue());
      }
      paramfh.e();
      AppMethodBeat.o(147781);
      return;
    }
    paramfh = new IllegalArgumentException("Couldn't write " + paramdq.getClass());
    AppMethodBeat.o(147781);
    throw paramfh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.18
 * JD-Core Version:    0.7.0.1
 */