package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGSolidLayer
  extends PAGLayer
{
  static
  {
    AppMethodBeat.i(236923);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(236923);
  }
  
  public PAGSolidLayer(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void nativeInit();
  
  public native void setSolidColor(int paramInt);
  
  public native int solidColor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.libpag.PAGSolidLayer
 * JD-Core Version:    0.7.0.1
 */