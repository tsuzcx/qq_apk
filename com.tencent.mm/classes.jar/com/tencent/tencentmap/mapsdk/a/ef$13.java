package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

class ef$13
  implements ah.b
{
  ef$13(ef paramef, TencentMap.InfoWindowAdapter paramInfoWindowAdapter) {}
  
  public View a(dc paramdc)
  {
    AppMethodBeat.i(150381);
    if (this.a != null)
    {
      paramdc = this.a.getInfoWindow(ef.a(this.b, paramdc));
      AppMethodBeat.o(150381);
      return paramdc;
    }
    AppMethodBeat.o(150381);
    return null;
  }
  
  public View b(dc paramdc)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.13
 * JD-Core Version:    0.7.0.1
 */