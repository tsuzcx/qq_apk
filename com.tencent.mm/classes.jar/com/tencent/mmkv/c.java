package com.tencent.mmkv;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  static
  {
    AppMethodBeat.i(124051);
    AZV = new c("OnErrorDiscard", 0);
    AZW = new c("OnErrorRecover", 1);
    AZX = new c[] { AZV, AZW };
    AppMethodBeat.o(124051);
  }
  
  private c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mmkv.c
 * JD-Core Version:    0.7.0.1
 */