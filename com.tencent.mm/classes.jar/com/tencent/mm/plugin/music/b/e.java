package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

public final class e
{
  public static String duJ()
  {
    AppMethodBeat.i(137015);
    String str = "audio" + aj.ej(new StringBuilder().append(System.nanoTime()).toString());
    AppMethodBeat.o(137015);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.e
 * JD-Core Version:    0.7.0.1
 */