package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;

class ef$3
  implements ah.h
{
  ef$3(ef paramef, TencentMap.OnMapClickListener paramOnMapClickListener) {}
  
  public void a(cz paramcz)
  {
    AppMethodBeat.i(150202);
    if (this.a != null) {
      this.a.onMapClick(eh.a(paramcz));
    }
    AppMethodBeat.o(150202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.3
 * JD-Core Version:    0.7.0.1
 */