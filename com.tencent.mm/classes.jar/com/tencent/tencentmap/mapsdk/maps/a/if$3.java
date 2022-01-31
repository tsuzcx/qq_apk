package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.gl.JNI;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.opengles.GL10;

class if$3
  implements ik.a
{
  if$3(if paramif, String paramString, byte[] paramArrayOfByte) {}
  
  public void a(GL10 paramGL10)
  {
    AppMethodBeat.i(148200);
    if (if.a(this.c) != 0L) {
      if.b(this.c).nativeWriteMapDataBlock(if.a(this.c), this.a, this.b);
    }
    AppMethodBeat.o(148200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.if.3
 * JD-Core Version:    0.7.0.1
 */