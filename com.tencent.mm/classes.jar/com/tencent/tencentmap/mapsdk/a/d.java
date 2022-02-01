package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;

public class d
{
  public static final void a(Closeable paramCloseable)
  {
    AppMethodBeat.i(181484);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(181484);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(181484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.d
 * JD-Core Version:    0.7.0.1
 */