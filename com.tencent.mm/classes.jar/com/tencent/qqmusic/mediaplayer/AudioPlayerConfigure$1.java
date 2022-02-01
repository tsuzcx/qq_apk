package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AudioPlayerConfigure$1
  implements ISoLibraryLoader
{
  public final String findLibPath(String paramString)
  {
    AppMethodBeat.i(114308);
    String str = paramString;
    if (!paramString.startsWith("lib")) {
      str = "lib".concat(String.valueOf(paramString));
    }
    paramString = str;
    if (!str.endsWith(".so")) {
      paramString = str + ".so";
    }
    AppMethodBeat.o(114308);
    return paramString;
  }
  
  public final boolean load(String paramString)
  {
    AppMethodBeat.i(114307);
    System.loadLibrary(paramString);
    AppMethodBeat.o(114307);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure.1
 * JD-Core Version:    0.7.0.1
 */