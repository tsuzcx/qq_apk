package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ag;

public final class e
{
  public static String bTX()
  {
    AppMethodBeat.i(137265);
    String str = "audio" + ag.cE(new StringBuilder().append(System.nanoTime()).toString());
    AppMethodBeat.o(137265);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.e
 * JD-Core Version:    0.7.0.1
 */