package com.tencent.tencentmap.mapsdk.a;

import android.os.Build.VERSION;
import com.tencent.map.lib.gl.e;

public class ht
{
  public static boolean a(e parame, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return false;
    }
    parame.setPreserveEGLContextOnPause(paramBoolean);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ht
 * JD-Core Version:    0.7.0.1
 */