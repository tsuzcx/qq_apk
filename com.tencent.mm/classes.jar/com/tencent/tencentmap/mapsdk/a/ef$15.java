package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;

class ef$15
  implements ah.i
{
  ef$15(ef paramef, TencentMap.OnMapLoadedListener paramOnMapLoadedListener) {}
  
  public void a()
  {
    AppMethodBeat.i(150397);
    if (this.a != null) {
      this.a.onMapLoaded();
    }
    AppMethodBeat.o(150397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.15
 * JD-Core Version:    0.7.0.1
 */