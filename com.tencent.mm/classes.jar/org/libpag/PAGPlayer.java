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
    AppMethodBeat.i(187403);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(187403);
  }
  
  public PAGPlayer()
  {
    AppMethodBeat.i(187352);
    this.pagSurface = null;
    this.nativeContext = 0L;
    nativeSetup();
    AppMethodBeat.o(187352);
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
    AppMethodBeat.i(187553);
    nativeFinalize();
    AppMethodBeat.o(187553);
  }
  
  public boolean flush()
  {
    AppMethodBeat.i(187522);
    boolean bool = flushAndFenceSync(null);
    AppMethodBeat.o(187522);
    return bool;
  }
  
  public native boolean flushAndFenceSync(long[] paramArrayOfLong);
  
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
    AppMethodBeat.i(187499);
    float[] arrayOfFloat = new float[9];
    nativeGetMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    AppMethodBeat.o(187499);
    return localMatrix;
  }
  
  public native float maxFrameRate();
  
  public void release()
  {
    AppMethodBeat.i(187546);
    nativeRelease();
    AppMethodBeat.o(187546);
  }
  
  public native int scaleMode();
  
  public native void setCacheEnabled(boolean paramBoolean);
  
  public native void setCacheScale(float paramFloat);
  
  public native void setComposition(PAGComposition paramPAGComposition);
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(187506);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    nativeSetMatrix(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[2], arrayOfFloat[5]);
    AppMethodBeat.o(187506);
  }
  
  public native void setMaxFrameRate(float paramFloat);
  
  public native void setProgress(double paramDouble);
  
  public native void setScaleMode(int paramInt);
  
  public void setSurface(PAGSurface paramPAGSurface)
  {
    AppMethodBeat.i(187424);
    this.pagSurface = paramPAGSurface;
    if (paramPAGSurface == null)
    {
      nativeSetSurface(0L);
      AppMethodBeat.o(187424);
      return;
    }
    nativeSetSurface(paramPAGSurface.nativeSurface);
    AppMethodBeat.o(187424);
  }
  
  public native void setVideoEnabled(boolean paramBoolean);
  
  public native boolean videoEnabled();
  
  public native boolean waitSync(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     org.libpag.PAGPlayer
 * JD-Core Version:    0.7.0.1
 */