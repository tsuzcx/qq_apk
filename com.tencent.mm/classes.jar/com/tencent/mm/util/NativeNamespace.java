package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class NativeNamespace
{
  static
  {
    AppMethodBeat.i(4355);
    System.loadLibrary("wechatnativeutils");
    AppMethodBeat.o(4355);
  }
  
  private NativeNamespace()
  {
    AppMethodBeat.i(4354);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(4354);
    throw localUnsupportedOperationException;
  }
  
  private static native int nativeResetNamespace();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.util.NativeNamespace
 * JD-Core Version:    0.7.0.1
 */