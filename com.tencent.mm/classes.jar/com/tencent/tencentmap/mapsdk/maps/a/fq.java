package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.f.b;
import com.tencent.tencentmap.mapsdk.a.f.c;
import com.tencent.tencentmap.mapsdk.a.f.d;
import java.lang.reflect.Type;

public class fq
  implements dp<f.b>
{
  public f.b a(dq paramdq, Type paramType, do paramdo)
  {
    AppMethodBeat.i(147957);
    paramType = paramdq.m().a("mode");
    if (paramType == null)
    {
      AppMethodBeat.o(147957);
      return null;
    }
    if ("WALKING".equalsIgnoreCase(paramType.c()))
    {
      paramdq = (f.b)paramdo.a(paramdq, f.d.class);
      AppMethodBeat.o(147957);
      return paramdq;
    }
    if ("TRANSIT".equalsIgnoreCase(paramType.c()))
    {
      paramdq = (f.b)paramdo.a(paramdq, f.c.class);
      AppMethodBeat.o(147957);
      return paramdq;
    }
    AppMethodBeat.o(147957);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fq
 * JD-Core Version:    0.7.0.1
 */