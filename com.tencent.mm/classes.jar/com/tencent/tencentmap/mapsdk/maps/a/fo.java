package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.e.a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class fo
  implements dp<e.a>
{
  public e.a a(dq paramdq, Type paramType, do paramdo)
  {
    AppMethodBeat.i(147953);
    paramType = new e.a();
    paramdq = paramdq.m();
    paramdo = paramdq.a("act_desc");
    if (paramdo != null) {
      paramType.f = paramdo.c();
    }
    paramdo = paramdq.a("dir_desc");
    if (paramdo != null) {
      paramType.d = paramdo.c();
    }
    paramdo = paramdq.a("distance");
    if (paramdo != null) {
      paramType.e = paramdo.e();
    }
    paramdo = paramdq.a("road_name");
    if (paramdo != null) {
      paramType.c = paramdo.c();
    }
    paramdo = paramdq.a("instruction");
    if (paramdo != null) {
      paramType.a = paramdo.c();
    }
    paramdq = paramdq.a("polyline_idx");
    if (paramdq != null)
    {
      paramdq = paramdq.n();
      if (paramdq.a() == 2)
      {
        paramType.b = new ArrayList();
        paramType.b.add(Integer.valueOf(paramdq.a(0).g() / 2));
        paramType.b.add(Integer.valueOf(paramdq.a(1).g() / 2));
      }
    }
    AppMethodBeat.o(147953);
    return paramType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fo
 * JD-Core Version:    0.7.0.1
 */