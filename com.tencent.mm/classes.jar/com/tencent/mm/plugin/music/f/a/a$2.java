package com.tencent.mm.plugin.music.f.a;

import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;

final class a$2
  implements ISoLibraryLoader
{
  public final String findLibPath(String paramString)
  {
    if (a.bnL() != null) {
      return a.bnL().findLibPath(paramString);
    }
    return null;
  }
  
  public final boolean load(String paramString)
  {
    if (a.bnL() != null) {
      return a.bnL().load(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a.2
 * JD-Core Version:    0.7.0.1
 */