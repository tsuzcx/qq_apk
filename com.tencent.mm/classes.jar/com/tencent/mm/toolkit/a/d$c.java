package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;

public final class d$c
{
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(193033);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(193033);
        return;
      }
      catch (IOException paramCloseable)
      {
        e.fei();
      }
    }
    AppMethodBeat.o(193033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.d.c
 * JD-Core Version:    0.7.0.1
 */