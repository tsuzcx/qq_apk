package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.map.lib.gl.JNI;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.opengles.GL10;

class if$10
  implements ik.a
{
  if$10(if paramif, Rect paramRect1, Rect paramRect2, boolean paramBoolean) {}
  
  public void a(GL10 paramGL10)
  {
    AppMethodBeat.i(148179);
    if (if.a(this.d) != 0L) {
      if.b(this.d).nativeZoomToSpan(if.a(this.d), this.a, this.b, this.c);
    }
    AppMethodBeat.o(148179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.if.10
 * JD-Core Version:    0.7.0.1
 */