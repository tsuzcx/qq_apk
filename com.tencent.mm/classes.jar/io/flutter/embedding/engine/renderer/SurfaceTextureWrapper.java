package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SurfaceTextureWrapper
{
  private boolean released;
  private SurfaceTexture surfaceTexture;
  
  public SurfaceTextureWrapper(SurfaceTexture paramSurfaceTexture)
  {
    this.surfaceTexture = paramSurfaceTexture;
    this.released = false;
  }
  
  public void attachToGLContext(int paramInt)
  {
    AppMethodBeat.i(190057);
    this.surfaceTexture.attachToGLContext(paramInt);
    AppMethodBeat.o(190057);
  }
  
  public void detachFromGLContext()
  {
    AppMethodBeat.i(190062);
    this.surfaceTexture.detachFromGLContext();
    AppMethodBeat.o(190062);
  }
  
  public void getTransformMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(190068);
    this.surfaceTexture.getTransformMatrix(paramArrayOfFloat);
    AppMethodBeat.o(190068);
  }
  
  public void release()
  {
    AppMethodBeat.i(190055);
    try
    {
      if (!this.released)
      {
        this.surfaceTexture.release();
        this.released = true;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(190055);
    }
  }
  
  public SurfaceTexture surfaceTexture()
  {
    return this.surfaceTexture;
  }
  
  public void updateTexImage()
  {
    AppMethodBeat.i(190050);
    try
    {
      if (!this.released) {
        this.surfaceTexture.updateTexImage();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(190050);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.renderer.SurfaceTextureWrapper
 * JD-Core Version:    0.7.0.1
 */