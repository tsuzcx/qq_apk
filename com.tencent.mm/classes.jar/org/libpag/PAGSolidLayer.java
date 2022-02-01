package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGSolidLayer
  extends PAGLayer
{
  static
  {
    AppMethodBeat.i(187398);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(187398);
  }
  
  public PAGSolidLayer(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void nativeInit();
  
  public native void setSolidColor(int paramInt);
  
  public native int solidColor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.libpag.PAGSolidLayer
 * JD-Core Version:    0.7.0.1
 */