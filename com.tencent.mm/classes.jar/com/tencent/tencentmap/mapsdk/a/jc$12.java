package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.gl.JNI;
import javax.microedition.khronos.opengles.GL10;

class jc$12
  implements jh.a
{
  jc$12(jc paramjc, boolean paramBoolean, float paramFloat1, float paramFloat2) {}
  
  public void a(GL10 paramGL10)
  {
    if (this.a)
    {
      jc.b(this.d).nativeSetScreenCenterOffset(jc.a(this.d), this.b, this.c, true);
      return;
    }
    paramGL10 = jc.c(this.d).d();
    DoublePoint localDoublePoint1 = paramGL10.b(this.d.s());
    jc.b(this.d).nativeSetScreenCenterOffset(jc.a(this.d), this.b, this.c, false);
    DoublePoint localDoublePoint2 = paramGL10.b(this.d.s());
    double d1 = localDoublePoint2.x;
    double d2 = localDoublePoint1.x;
    double d3 = localDoublePoint2.y;
    double d4 = localDoublePoint1.y;
    paramGL10 = paramGL10.a(new DoublePoint(d1 - d2 + localDoublePoint2.x, d3 - d4 + localDoublePoint2.y));
    jc.b(this.d).nativeSetCenter(jc.a(this.d), paramGL10, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jc.12
 * JD-Core Version:    0.7.0.1
 */