package com.tencent.mmkv;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  static
  {
    AppMethodBeat.i(13539);
    agZL = new c("LevelDebug", 0);
    agZM = new c("LevelInfo", 1);
    agZN = new c("LevelWarning", 2);
    agZO = new c("LevelError", 3);
    agZP = new c("LevelNone", 4);
    agZQ = new c[] { agZL, agZM, agZN, agZO, agZP };
    AppMethodBeat.o(13539);
  }
  
  private c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mmkv.c
 * JD-Core Version:    0.7.0.1
 */