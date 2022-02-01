package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;

public final class d$c
{
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(220802);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(220802);
        return;
      }
      catch (IOException paramCloseable)
      {
        e.hES();
      }
    }
    AppMethodBeat.o(220802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.d.c
 * JD-Core Version:    0.7.0.1
 */