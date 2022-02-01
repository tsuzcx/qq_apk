package org.libpag;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

@Deprecated
public class PAGRenderer
{
  private long nativeContext;
  private PAGFile pagFile;
  private PAGSurface pagSurface;
  
  static
  {
    AppMethodBeat.i(187417);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(187417);
  }
  
  @Deprecated
  public PAGRenderer()
  {
    AppMethodBeat.i(187364);
    this.pagSurface = null;
    this.pagFile = null;
    this.nativeContext = 0L;
    nativeSetup();
    AppMethodBeat.o(187364);
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
  
  @Deprecated
  public native boolean cacheEnabled();
  
  @Deprecated
  public native float cacheScale();
  
  @Deprecated
  public native void draw();
  
  protected void finalize()
  {
    AppMethodBeat.i(187554);
    nativeFinalize();
    AppMethodBeat.o(187554);
  }
  
  @Deprecated
  public boolean flush()
  {
    AppMethodBeat.i(187532);
    boolean bool = flush(false);
    AppMethodBeat.o(187532);
    return bool;
  }
  
  @Deprecated
  public native boolean flush(boolean paramBoolean);
  
  @Deprecated
  public PAGFile getFile()
  {
    return this.pagFile;
  }
  
  @Deprecated
  public native PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2);
  
  @Deprecated
  public native double getProgress();
  
  @Deprecated
  public native PAGComposition getRootComposition();
  
  @Deprecated
  public PAGSurface getSurface()
  {
    return this.pagSurface;
  }
  
  @Deprecated
  public Matrix matrix()
  {
    AppMethodBeat.i(187500);
    float[] arrayOfFloat = new float[9];
    nativeGetMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    AppMethodBeat.o(187500);
    return localMatrix;
  }
  
  @Deprecated
  public native float maxFrameRate();
  
  public void release()
  {
    AppMethodBeat.i(187547);
    nativeRelease();
    AppMethodBeat.o(187547);
  }
  
  @Deprecated
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    AppMethodBeat.i(187513);
    if (paramPAGImage == null)
    {
      nativeReplaceImage(paramInt, 0L);
      AppMethodBeat.o(187513);
      return;
    }
    nativeReplaceImage(paramInt, paramPAGImage.nativeContext);
    AppMethodBeat.o(187513);
  }
  
  @Deprecated
  public native void reset();
  
  @Deprecated
  public native int scaleMode();
  
  @Deprecated
  public native void setCacheEnabled(boolean paramBoolean);
  
  @Deprecated
  public native void setCacheScale(float paramFloat);
  
  @Deprecated
  public void setFile(PAGFile paramPAGFile)
  {
    AppMethodBeat.i(187431);
    this.pagFile = paramPAGFile;
    if (paramPAGFile != null)
    {
      nativeSetFile(paramPAGFile.nativeContext);
      AppMethodBeat.o(187431);
      return;
    }
    nativeSetFile(0L);
    AppMethodBeat.o(187431);
  }
  
  @Deprecated
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(187505);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    nativeSetMatrix(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[2], arrayOfFloat[5]);
    AppMethodBeat.o(187505);
  }
  
  @Deprecated
  public native void setMaxFrameRate(float paramFloat);
  
  @Deprecated
  public native void setProgress(double paramDouble);
  
  @Deprecated
  public native void setScaleMode(int paramInt);
  
  @Deprecated
  public void setSurface(PAGSurface paramPAGSurface)
  {
    AppMethodBeat.i(187447);
    this.pagSurface = paramPAGSurface;
    if (paramPAGSurface == null)
    {
      nativeSetSurface(0L);
      AppMethodBeat.o(187447);
      return;
    }
    nativeSetSurface(paramPAGSurface.nativeSurface);
    AppMethodBeat.o(187447);
  }
  
  @Deprecated
  public native void setTextData(int paramInt, PAGText paramPAGText);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.libpag.PAGRenderer
 * JD-Core Version:    0.7.0.1
 */