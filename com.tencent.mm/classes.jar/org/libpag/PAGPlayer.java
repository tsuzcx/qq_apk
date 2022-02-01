package org.libpag;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGPlayer
{
  private long nativeContext;
  private PAGSurface pagSurface;
  
  static
  {
    AppMethodBeat.i(216940);
    b.loadLibrary("libpag");
    nativeInit();
    PAGFont.loadSystemFonts();
    AppMethodBeat.o(216940);
  }
  
  public PAGPlayer()
  {
    AppMethodBeat.i(216934);
    this.pagSurface = null;
    this.nativeContext = 0L;
    nativeSetup();
    AppMethodBeat.o(216934);
  }
  
  private native void nativeFinalize();
  
  private native void nativeGetMatrix(float[] paramArrayOfFloat);
  
  private static final native void nativeInit();
  
  private final native void nativeRelease();
  
  private native void nativeSetMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  private native void nativeSetSurface(long paramLong);
  
  private final native void nativeSetup();
  
  public native boolean cacheEnabled();
  
  public native float cacheScale();
  
  public native long duration();
  
  protected void finalize()
  {
    AppMethodBeat.i(216939);
    nativeFinalize();
    AppMethodBeat.o(216939);
  }
  
  public native boolean flush();
  
  public native RectF getBounds(PAGLayer paramPAGLayer);
  
  public native PAGComposition getComposition();
  
  public native PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2);
  
  public native double getProgress();
  
  public PAGSurface getSurface()
  {
    return this.pagSurface;
  }
  
  public native boolean hitTestPoint(PAGLayer paramPAGLayer, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public Matrix matrix()
  {
    AppMethodBeat.i(216936);
    float[] arrayOfFloat = new float[9];
    nativeGetMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    AppMethodBeat.o(216936);
    return localMatrix;
  }
  
  public native float maxFrameRate();
  
  public void release()
  {
    AppMethodBeat.i(216938);
    nativeRelease();
    AppMethodBeat.o(216938);
  }
  
  public native int scaleMode();
  
  public native void setCacheEnabled(boolean paramBoolean);
  
  public native void setCacheScale(float paramFloat);
  
  public native void setComposition(PAGComposition paramPAGComposition);
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(216937);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    nativeSetMatrix(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[2], arrayOfFloat[5]);
    AppMethodBeat.o(216937);
  }
  
  public native void setMaxFrameRate(float paramFloat);
  
  public native void setProgress(double paramDouble);
  
  public native void setScaleMode(int paramInt);
  
  public void setSurface(PAGSurface paramPAGSurface)
  {
    AppMethodBeat.i(216935);
    this.pagSurface = paramPAGSurface;
    if (paramPAGSurface == null)
    {
      nativeSetSurface(0L);
      AppMethodBeat.o(216935);
      return;
    }
    nativeSetSurface(paramPAGSurface.nativeSurface);
    AppMethodBeat.o(216935);
  }
  
  public native void setVideoEnabled(boolean paramBoolean);
  
  public native boolean videoEnabled();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.libpag.PAGPlayer
 * JD-Core Version:    0.7.0.1
 */