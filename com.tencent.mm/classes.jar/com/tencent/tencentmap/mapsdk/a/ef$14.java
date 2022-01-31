package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;

class ef$14
  implements ah.m
{
  ef$14(ef paramef, TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener) {}
  
  public void a(dc paramdc)
  {
    AppMethodBeat.i(150313);
    if (this.a != null) {
      this.a.onMarkerDragStart(ef.a(this.b, paramdc));
    }
    AppMethodBeat.o(150313);
  }
  
  public void b(dc paramdc)
  {
    AppMethodBeat.i(150314);
    if (this.a != null) {
      this.a.onMarkerDrag(ef.a(this.b, paramdc));
    }
    AppMethodBeat.o(150314);
  }
  
  public void c(dc paramdc)
  {
    AppMethodBeat.i(150315);
    if (this.a != null) {
      this.a.onMarkerDragEnd(ef.a(this.b, paramdc));
    }
    AppMethodBeat.o(150315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.14
 * JD-Core Version:    0.7.0.1
 */