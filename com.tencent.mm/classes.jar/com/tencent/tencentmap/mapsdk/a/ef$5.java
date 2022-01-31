package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener;

class ef$5
  implements ah.k
{
  ef$5(ef paramef, TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener) {}
  
  public void a(db paramdb)
  {
    AppMethodBeat.i(150222);
    if (this.a != null) {
      this.a.onClicked(eh.a(paramdb));
    }
    AppMethodBeat.o(150222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.5
 * JD-Core Version:    0.7.0.1
 */