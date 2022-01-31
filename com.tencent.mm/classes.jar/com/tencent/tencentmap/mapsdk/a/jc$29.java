package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.gl.JNI;
import javax.microedition.khronos.opengles.GL10;

class jc$29
  implements jh.a
{
  jc$29(jc paramjc, Rect paramRect1, Rect paramRect2, boolean paramBoolean) {}
  
  public void a(GL10 paramGL10)
  {
    jc.b(this.d).nativeZoomToSpan(jc.a(this.d), this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jc.29
 * JD-Core Version:    0.7.0.1
 */