package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGShapeLayer
  extends PAGLayer
{
  static
  {
    AppMethodBeat.i(187492);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(187492);
  }
  
  public PAGShapeLayer(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void nativeInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.libpag.PAGShapeLayer
 * JD-Core Version:    0.7.0.1
 */