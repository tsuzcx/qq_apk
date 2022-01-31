package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener;

class ef$4
  implements ah.j
{
  ef$4(ef paramef, TencentMap.OnMapLongClickListener paramOnMapLongClickListener) {}
  
  public void a(cz paramcz)
  {
    AppMethodBeat.i(150164);
    if (this.a != null) {
      this.a.onMapLongClick(eh.a(paramcz));
    }
    AppMethodBeat.o(150164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.4
 * JD-Core Version:    0.7.0.1
 */