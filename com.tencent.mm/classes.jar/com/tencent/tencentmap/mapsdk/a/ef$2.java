package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;

class ef$2
  implements ah.c
{
  ef$2(ef paramef, TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener) {}
  
  public void onCameraChange(cn paramcn)
  {
    AppMethodBeat.i(150166);
    if (this.a != null) {
      this.a.onCameraChange(eh.a(paramcn));
    }
    AppMethodBeat.o(150166);
  }
  
  public void onCameraChangeFinished(cn paramcn)
  {
    AppMethodBeat.i(150167);
    if (this.a != null) {
      this.a.onCameraChangeFinish(eh.a(paramcn));
    }
    AppMethodBeat.o(150167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.2
 * JD-Core Version:    0.7.0.1
 */