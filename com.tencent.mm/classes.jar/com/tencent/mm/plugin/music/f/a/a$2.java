package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;

final class a$2
  implements ISoLibraryLoader
{
  public final String findLibPath(String paramString)
  {
    AppMethodBeat.i(137640);
    if (a.bWi() != null)
    {
      paramString = a.bWi().findLibPath(paramString);
      AppMethodBeat.o(137640);
      return paramString;
    }
    AppMethodBeat.o(137640);
    return null;
  }
  
  public final boolean load(String paramString)
  {
    AppMethodBeat.i(137639);
    if (a.bWi() != null)
    {
      boolean bool = a.bWi().load(paramString);
      AppMethodBeat.o(137639);
      return bool;
    }
    AppMethodBeat.o(137639);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a.2
 * JD-Core Version:    0.7.0.1
 */