package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cq;
import com.tencent.tencentmap.mapsdk.a.cs.c;
import java.util.List;

class lu$a
  implements Runnable
{
  private List<cq> b;
  
  public lu$a(List<cq> paramList)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public void run()
  {
    AppMethodBeat.i(149233);
    lu.a(this.a, this.a.b);
    lu.a(this.a, this.a.c);
    lu.a(this.a).a(this.b);
    if (lu.b(this.a) != null) {
      lu.b(this.a).a();
    }
    lu.d(this.a).b().j(lu.c(this.a));
    AppMethodBeat.o(149233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lu.a
 * JD-Core Version:    0.7.0.1
 */