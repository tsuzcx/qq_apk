package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class NativeNamespace
{
  static
  {
    AppMethodBeat.i(4355);
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("wechatnativeutils");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/util/NativeNamespace", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/util/NativeNamespace", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
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