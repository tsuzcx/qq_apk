package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends SurfaceTexture
{
  public final void release()
  {
    AppMethodBeat.i(224442);
    super.release();
    AppMethodBeat.o(224442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.b
 * JD-Core Version:    0.7.0.1
 */