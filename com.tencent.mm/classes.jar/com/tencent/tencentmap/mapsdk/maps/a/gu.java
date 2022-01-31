package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Build.VERSION;
import com.tencent.map.lib.gl.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class gu
{
  public static boolean a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(148028);
    if (Build.VERSION.SDK_INT < 11)
    {
      AppMethodBeat.o(148028);
      return false;
    }
    parame.setPreserveEGLContextOnPause(paramBoolean);
    AppMethodBeat.o(148028);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gu
 * JD-Core Version:    0.7.0.1
 */