package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGImageLayer
  extends PAGLayer
{
  static
  {
    AppMethodBeat.i(187509);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(187509);
  }
  
  public PAGImageLayer(long paramLong)
  {
    super(paramLong);
  }
  
  public static PAGImageLayer Make(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(187480);
    paramLong = nativeMake(paramInt1, paramInt2, paramLong);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(187480);
      return null;
    }
    PAGImageLayer localPAGImageLayer = new PAGImageLayer(paramLong);
    AppMethodBeat.o(187480);
    return localPAGImageLayer;
  }
  
  private static native void nativeInit();
  
  private static native long nativeMake(int paramInt1, int paramInt2, long paramLong);
  
  private native void replaceImage(long paramLong);
  
  public native long contentDuration();
  
  public native PAGVideoRange[] getVideoRanges();
  
  public void replaceImage(PAGImage paramPAGImage)
  {
    AppMethodBeat.i(187526);
    if (paramPAGImage == null) {}
    for (long l = 0L;; l = paramPAGImage.nativeContext)
    {
      replaceImage(l);
      AppMethodBeat.o(187526);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.libpag.PAGImageLayer
 * JD-Core Version:    0.7.0.1
 */