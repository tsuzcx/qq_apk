package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.gl.JNI;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.opengles.GL10;

class if$23
  implements ik.a
{
  if$23(if paramif, boolean paramBoolean, float paramFloat1, float paramFloat2) {}
  
  public void a(GL10 paramGL10)
  {
    AppMethodBeat.i(148193);
    if (if.a(this.d) == 0L)
    {
      AppMethodBeat.o(148193);
      return;
    }
    if (this.a)
    {
      if.b(this.d).nativeSetScreenCenterOffset(if.a(this.d), this.b, this.c, true);
      AppMethodBeat.o(148193);
      return;
    }
    paramGL10 = if.c(this.d).d();
    DoublePoint localDoublePoint1 = paramGL10.b(this.d.o());
    if.b(this.d).nativeSetScreenCenterOffset(if.a(this.d), this.b, this.c, false);
    DoublePoint localDoublePoint2 = paramGL10.b(this.d.o());
    double d1 = localDoublePoint2.x;
    double d2 = localDoublePoint1.x;
    double d3 = localDoublePoint2.y;
    double d4 = localDoublePoint1.y;
    paramGL10 = paramGL10.a(new DoublePoint(d1 - d2 + localDoublePoint2.x, d3 - d4 + localDoublePoint2.y));
    if.b(this.d).nativeSetCenter(if.a(this.d), paramGL10, false);
    AppMethodBeat.o(148193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.if.23
 * JD-Core Version:    0.7.0.1
 */