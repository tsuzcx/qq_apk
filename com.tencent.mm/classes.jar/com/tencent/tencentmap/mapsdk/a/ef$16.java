package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;

class ef$16
  implements ah.g
{
  ef$16(ef paramef, TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(dc paramdc)
  {
    AppMethodBeat.i(150201);
    this.a.onInfoWindowClick(ef.a(this.b, paramdc));
    AppMethodBeat.o(150201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.16
 * JD-Core Version:    0.7.0.1
 */