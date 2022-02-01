package org.libpag;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGLayer
{
  public static final int LayerTypeImage = 5;
  public static final int LayerTypeNull = 1;
  public static final int LayerTypePreCompose = 6;
  public static final int LayerTypeShape = 4;
  public static final int LayerTypeSolid = 2;
  public static final int LayerTypeText = 3;
  public static final int LayerTypeUnknown = 0;
  protected long nativeContext;
  
  static
  {
    AppMethodBeat.i(195127);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(195127);
  }
  
  public PAGLayer(long paramLong)
  {
    this.nativeContext = paramLong;
  }
  
  private native void getTotalMatrix(float[] paramArrayOfFloat);
  
  private native void matrix(float[] paramArrayOfFloat);
  
  private static native void nativeInit();
  
  private native void nativeRelease();
  
  private native void setMatrix(float[] paramArrayOfFloat);
  
  public native void addFilter(PAGFilter paramPAGFilter);
  
  public native long currentTime();
  
  public native long duration();
  
  public native int editableIndex();
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195123);
    if (this == paramObject)
    {
      AppMethodBeat.o(195123);
      return true;
    }
    if ((paramObject instanceof PAGLayer))
    {
      if (hashCode() == paramObject.hashCode())
      {
        AppMethodBeat.o(195123);
        return true;
      }
      AppMethodBeat.o(195123);
      return false;
    }
    AppMethodBeat.o(195123);
    return false;
  }
  
  public native boolean excludedFromTimeline();
  
  protected void finalize()
  {
    AppMethodBeat.i(195120);
    nativeRelease();
    AppMethodBeat.o(195120);
  }
  
  public native float frameRate();
  
  public native RectF getBounds();
  
  public native double getProgress();
  
  public Matrix getTotalMatrix()
  {
    AppMethodBeat.i(195101);
    float[] arrayOfFloat = new float[9];
    getTotalMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    AppMethodBeat.o(195101);
    return localMatrix;
  }
  
  public native long globalToLocalTime(long paramLong);
  
  public int hashCode()
  {
    return (int)(this.nativeContext ^ this.nativeContext >>> 32) + 527;
  }
  
  public native String layerName();
  
  public native int layerType();
  
  public native long localTimeToGlobal(long paramLong);
  
  public native PAGMarker[] markers();
  
  public Matrix matrix()
  {
    AppMethodBeat.i(195091);
    float[] arrayOfFloat = new float[9];
    matrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    AppMethodBeat.o(195091);
    return localMatrix;
  }
  
  public native int numFilters();
  
  public native PAGComposition parent();
  
  public native void removeAllFilters();
  
  public native void resetMatrix();
  
  public native void setCurrentTime(long paramLong);
  
  public native void setExcludedFromTimeline(boolean paramBoolean);
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(195098);
    if (paramMatrix == null)
    {
      AppMethodBeat.o(195098);
      return;
    }
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    setMatrix(arrayOfFloat);
    AppMethodBeat.o(195098);
  }
  
  public native void setProgress(double paramDouble);
  
  public native void setStartTime(long paramLong);
  
  public native void setVisible(boolean paramBoolean);
  
  public native long startTime();
  
  public native PAGLayer trackMatteLayer();
  
  public native boolean visible();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.libpag.PAGLayer
 * JD-Core Version:    0.7.0.1
 */