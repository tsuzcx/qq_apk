package com.tencent.mmkv;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  static
  {
    AppMethodBeat.i(13539);
    LZf = new b("LevelDebug", 0);
    LZg = new b("LevelInfo", 1);
    LZh = new b("LevelWarning", 2);
    LZi = new b("LevelError", 3);
    LZj = new b("LevelNone", 4);
    LZk = new b[] { LZf, LZg, LZh, LZi, LZj };
    AppMethodBeat.o(13539);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mmkv.b
 * JD-Core Version:    0.7.0.1
 */