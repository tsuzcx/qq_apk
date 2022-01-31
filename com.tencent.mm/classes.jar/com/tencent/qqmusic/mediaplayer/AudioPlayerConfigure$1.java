package com.tencent.qqmusic.mediaplayer;

final class AudioPlayerConfigure$1
  implements ISoLibraryLoader
{
  public final String findLibPath(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("lib")) {
      str = "lib" + paramString;
    }
    paramString = str;
    if (!str.endsWith(".so")) {
      paramString = str + ".so";
    }
    return paramString;
  }
  
  public final boolean load(String paramString)
  {
    System.loadLibrary(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure.1
 * JD-Core Version:    0.7.0.1
 */