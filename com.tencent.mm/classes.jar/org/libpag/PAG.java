package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAG
{
  static
  {
    AppMethodBeat.i(187380);
    b.loadLibrary("libpag");
    AppMethodBeat.o(187380);
  }
  
  public static native String SDKVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.libpag.PAG
 * JD-Core Version:    0.7.0.1
 */