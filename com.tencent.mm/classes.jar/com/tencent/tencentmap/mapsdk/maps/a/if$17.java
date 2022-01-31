package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.gl.JNI;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.opengles.GL10;

class if$17
  implements ik.a
{
  if$17(if paramif, GeoPoint paramGeoPoint, boolean paramBoolean) {}
  
  public void a(GL10 paramGL10)
  {
    AppMethodBeat.i(148186);
    if (if.a(this.c) != 0L) {
      if.b(this.c).nativeSetCenter(if.a(this.c), this.a, this.b);
    }
    AppMethodBeat.o(148186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.if.17
 * JD-Core Version:    0.7.0.1
 */