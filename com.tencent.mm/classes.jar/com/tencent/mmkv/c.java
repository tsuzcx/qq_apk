package com.tencent.mmkv;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  static
  {
    AppMethodBeat.i(13539);
    Zbe = new c("LevelDebug", 0);
    Zbf = new c("LevelInfo", 1);
    Zbg = new c("LevelWarning", 2);
    Zbh = new c("LevelError", 3);
    Zbi = new c("LevelNone", 4);
    Zbj = new c[] { Zbe, Zbf, Zbg, Zbh, Zbi };
    AppMethodBeat.o(13539);
  }
  
  private c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mmkv.c
 * JD-Core Version:    0.7.0.1
 */