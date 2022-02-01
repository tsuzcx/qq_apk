package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGFilter
{
  protected long nativeContext;
  
  static
  {
    AppMethodBeat.i(216894);
    b.loadLibrary("libpag");
    nativeInit();
    AppMethodBeat.o(216894);
  }
  
  public PAGFilter(long paramLong)
  {
    this.nativeContext = paramLong;
  }
  
  public static native PAGFilter FromPAGFile(PAGFile paramPAGFile, int paramInt);
  
  private static native void nativeInit();
  
  private native void nativeRelease();
  
  public native long currentTime();
  
  public native long duration();
  
  public native boolean excludedFromTimeline();
  
  public native void setCurrentTime(long paramLong);
  
  public native void setDuration(long paramLong);
  
  public native void setExcludedFromTimeline(boolean paramBoolean);
  
  public native void setVisible(boolean paramBoolean);
  
  public native boolean visible();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.libpag.PAGFilter
 * JD-Core Version:    0.7.0.1
 */