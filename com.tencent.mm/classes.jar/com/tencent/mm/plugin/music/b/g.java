package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MD5Util;

public final class g
{
  public static String esG()
  {
    AppMethodBeat.i(137015);
    String str = "audio" + MD5Util.getMD5String(new StringBuilder().append(System.nanoTime()).toString());
    AppMethodBeat.o(137015);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g
 * JD-Core Version:    0.7.0.1
 */