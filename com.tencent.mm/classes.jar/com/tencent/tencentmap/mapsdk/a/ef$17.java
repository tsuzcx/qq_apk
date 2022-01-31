package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;

class ef$17
  implements ah.l
{
  ef$17(ef paramef, TencentMap.OnMarkerClickListener paramOnMarkerClickListener) {}
  
  public boolean a(dc paramdc)
  {
    AppMethodBeat.i(150165);
    if (this.a != null)
    {
      boolean bool = this.a.onMarkerClick(ef.a(this.b, paramdc));
      AppMethodBeat.o(150165);
      return bool;
    }
    AppMethodBeat.o(150165);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.17
 * JD-Core Version:    0.7.0.1
 */