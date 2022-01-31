package com.tencent.mmkv;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  static
  {
    AppMethodBeat.i(124048);
    AZP = new b("LevelDebug", 0);
    AZQ = new b("LevelInfo", 1);
    AZR = new b("LevelWarning", 2);
    AZS = new b("LevelError", 3);
    AZT = new b("LevelNone", 4);
    AZU = new b[] { AZP, AZQ, AZR, AZS, AZT };
    AppMethodBeat.o(124048);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mmkv.b
 * JD-Core Version:    0.7.0.1
 */