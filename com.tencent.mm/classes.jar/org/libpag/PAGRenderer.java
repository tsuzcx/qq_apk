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
    AppMethodBeat.i(216950);
    b.loadLibrary("libpag");
    nativeInit();
    PAGFont.loadSystemFonts();
    AppMethodBeat.o(216950);
  }
  
  public PAGRenderer()
  {
    AppMethodBeat.i(216941);
    this.pagSurface = null;
    this.pagFile = null;
    this.nativeContext = 0L;
    nativeSetup();
    AppMethodBeat.o(216941);
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
    AppMethodBeat.i(216949);
    nativeFinalize();
    AppMethodBeat.o(216949);
  }
  
  public boolean flush()
  {
    AppMethodBeat.i(216947);
    boolean bool = flush(false);
    AppMethodBeat.o(216947);
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
    AppMethodBeat.i(216944);
    float[] arrayOfFloat = new float[9];
    nativeGetMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    AppMethodBeat.o(216944);
    return localMatrix;
  }
  
  public native float maxFrameRate();
  
  public void release()
  {
    AppMethodBeat.i(216948);
    nativeRelease();
    AppMethodBeat.o(216948);
  }
  
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    AppMethodBeat.i(216946);
    if (paramPAGImage == null)
    {
      nativeReplaceImage(paramInt, 0L);
      AppMethodBeat.o(216946);
      return;
    }
    nativeReplaceImage(paramInt, paramPAGImage.nativeContext);
    AppMethodBeat.o(216946);
  }
  
  public native void reset();
  
  public native int scaleMode();
  
  public native void setCacheEnabled(boolean paramBoolean);
  
  public native void setCacheScale(float paramFloat);
  
  public void setFile(PAGFile paramPAGFile)
  {
    AppMethodBeat.i(216942);
    this.pagFile = paramPAGFile;
    if (paramPAGFile != null)
    {
      nativeSetFile(paramPAGFile.nativeContext);
      AppMethodBeat.o(216942);
      return;
    }
    nativeSetFile(0L);
    AppMethodBeat.o(216942);
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(216945);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    nativeSetMatrix(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[2], arrayOfFloat[5]);
    AppMethodBeat.o(216945);
  }
  
  public native void setMaxFrameRate(float paramFloat);
  
  public native void setProgress(double paramDouble);
  
  public native void setScaleMode(int paramInt);
  
  public void setSurface(PAGSurface paramPAGSurface)
  {
    AppMethodBeat.i(216943);
    this.pagSurface = paramPAGSurface;
    if (paramPAGSurface == null)
    {
      nativeSetSurface(0L);
      AppMethodBeat.o(216943);
      return;
    }
    nativeSetSurface(paramPAGSurface.nativeSurface);
    AppMethodBeat.o(216943);
  }
  
  public native void setTextData(int paramInt, PAGText paramPAGText);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.libpag.PAGRenderer
 * JD-Core Version:    0.7.0.1
 */