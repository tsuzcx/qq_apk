package com.tencent.mmkv;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  static
  {
    AppMethodBeat.i(13542);
    LCh = new c("OnErrorDiscard", 0);
    LCi = new c("OnErrorRecover", 1);
    LCj = new c[] { LCh, LCi };
    AppMethodBeat.o(13542);
  }
  
  private c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mmkv.c
 * JD-Core Version:    0.7.0.1
 */