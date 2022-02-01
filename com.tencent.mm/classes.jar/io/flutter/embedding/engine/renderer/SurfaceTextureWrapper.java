package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
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
    AppMethodBeat.i(253371);
    this.surfaceTexture.attachToGLContext(paramInt);
    AppMethodBeat.o(253371);
  }
  
  public void detachFromGLContext()
  {
    AppMethodBeat.i(253373);
    this.surfaceTexture.detachFromGLContext();
    AppMethodBeat.o(253373);
  }
  
  public void getTransformMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(253374);
    this.surfaceTexture.getTransformMatrix(paramArrayOfFloat);
    AppMethodBeat.o(253374);
  }
  
  public void release()
  {
    AppMethodBeat.i(253370);
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
      AppMethodBeat.o(253370);
    }
  }
  
  public SurfaceTexture surfaceTexture()
  {
    return this.surfaceTexture;
  }
  
  public void updateTexImage()
  {
    AppMethodBeat.i(253369);
    try
    {
      if (!this.released) {
        this.surfaceTexture.updateTexImage();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(253369);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.renderer.SurfaceTextureWrapper
 * JD-Core Version:    0.7.0.1
 */