package org.libpag;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGRenderer
{
  private long nativeContext;
  private PAGFile pagFile;
  private PAGSurface pagSurface;
  
  static
  {
    AppMethodBeat.i(236921);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(236921);
  }
  
  public PAGRenderer()
  {
    AppMethodBeat.i(236912);
    this.pagSurface = null;
    this.pagFile = null;
    this.nativeContext = 0L;
    nativeSetup();
    AppMethodBeat.o(236912);
  }
  
  private native void nativeFinalize();
  
  private native void nativeGetMatrix(float[] paramArrayOfFloat);
  
  private static final native void nativeInit();
  
  private final native void nativeRelease();
  
  private native void nativeReplaceImage(int paramInt, long paramLong);
  
  private native void nativeSetFile(long paramLong);
  
  private native void nativeSetMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  private native void nativeSetSurface(long paramLong);
  
  private final native void nativeSetup();
  
  public native boolean cacheEnabled();
  
  public native float cacheScale();
  
  public native void draw();
  
  protected void finalize()
  {
    AppMethodBeat.i(236920);
    nativeFinalize();
    AppMethodBeat.o(236920);
  }
  
  public boolean flush()
  {
    AppMethodBeat.i(236918);
    boolean bool = flush(false);
    AppMethodBeat.o(236918);
    return bool;
  }
  
  public native boolean flush(boolean paramBoolean);
  
  public PAGFile getFile()
  {
    return this.pagFile;
  }
  
  public native PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2);
  
  public native double getProgress();
  
  public native PAGComposition getRootComposition();
  
  public PAGSurface getSurface()
  {
    return this.pagSurface;
  }
  
  public Matrix matrix()
  {
    AppMethodBeat.i(236915);
    float[] arrayOfFloat = new float[9];
    nativeGetMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    AppMethodBeat.o(236915);
    return localMatrix;
  }
  
  public native float maxFrameRate();
  
  public void release()
  {
    AppMethodBeat.i(236919);
    nativeRelease();
    AppMethodBeat.o(236919);
  }
  
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    AppMethodBeat.i(236917);
    if (paramPAGImage == null)
    {
      nativeReplaceImage(paramInt, 0L);
      AppMethodBeat.o(236917);
      return;
    }
    nativeReplaceImage(paramInt, paramPAGImage.nativeContext);
    AppMethodBeat.o(236917);
  }
  
  public native void reset();
  
  public native int scaleMode();
  
  public native void setCacheEnabled(boolean paramBoolean);
  
  public native void setCacheScale(float paramFloat);
  
  public void setFile(PAGFile paramPAGFile)
  {
    AppMethodBeat.i(236913);
    this.pagFile = paramPAGFile;
    if (paramPAGFile != null)
    {
      nativeSetFile(paramPAGFile.nativeContext);
      AppMethodBeat.o(236913);
      return;
    }
    nativeSetFile(0L);
    AppMethodBeat.o(236913);
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(236916);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    nativeSetMatrix(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[2], arrayOfFloat[5]);
    AppMethodBeat.o(236916);
  }
  
  public native void setMaxFrameRate(float paramFloat);
  
  public native void setProgress(double paramDouble);
  
  public native void setScaleMode(int paramInt);
  
  public void setSurface(PAGSurface paramPAGSurface)
  {
    AppMethodBeat.i(236914);
    this.pagSurface = paramPAGSurface;
    if (paramPAGSurface == null)
    {
      nativeSetSurface(0L);
      AppMethodBeat.o(236914);
      return;
    }
    nativeSetSurface(paramPAGSurface.nativeSurface);
    AppMethodBeat.o(236914);
  }
  
  public native void setTextData(int paramInt, PAGText paramPAGText);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.libpag.PAGRenderer
 * JD-Core Version:    0.7.0.1
 */