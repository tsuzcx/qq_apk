package com.tencent.mm.plugin.voip.video.b;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static d tIG;
  public SurfaceTexture mSurfaceTexture;
  public boolean tIH = false;
  public d.a tII;
  public int textureId = -1;
  
  public static d cPX()
  {
    AppMethodBeat.i(140233);
    if (tIG == null) {
      tIG = new d();
    }
    d locald = tIG;
    AppMethodBeat.o(140233);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.d
 * JD-Core Version:    0.7.0.1
 */