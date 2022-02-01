package com.tencent.tavkit.ciimage;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Arrays;

class GLBlendStateCache
{
  private static final String TAG = "GLBlendStateCache";
  private final int[] pNames;
  private final int[] params;
  
  GLBlendStateCache()
  {
    AppMethodBeat.i(211200);
    this.pNames = new int[] { 32777, 32777, 34877, 32969, 32968, 32971, 32970 };
    this.params = new int[7];
    AppMethodBeat.o(211200);
  }
  
  void cache()
  {
    try
    {
      AppMethodBeat.i(211201);
      int i = 0;
      while (i < this.pNames.length)
      {
        GLES20.glGetIntegerv(this.pNames[i], this.params, i);
        i += 1;
      }
      AppMethodBeat.o(211201);
      return;
    }
    finally {}
  }
  
  void restore()
  {
    try
    {
      AppMethodBeat.i(211202);
      Logger.v("GLBlendStateCache", "restore: params = " + Arrays.toString(this.params));
      GLES20.glEnable(3042);
      GLES20.glBlendEquation(this.params[0]);
      GLES20.glBlendEquationSeparate(this.params[1], this.params[2]);
      GLES20.glBlendFuncSeparate(this.params[3], this.params[4], this.params[5], this.params[6]);
      AppMethodBeat.o(211202);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.GLBlendStateCache
 * JD-Core Version:    0.7.0.1
 */