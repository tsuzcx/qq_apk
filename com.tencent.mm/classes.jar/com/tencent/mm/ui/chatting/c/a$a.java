package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum a$a
{
  static
  {
    AppMethodBeat.i(285228);
    WGM = new a("ACTIVITY_CREATE", 0);
    WGN = new a("ACTIVITY_RESUME", 1);
    WGO = new a("ACTIVITY_PAUSE", 2);
    WGP = new a[] { WGM, WGN, WGO };
    AppMethodBeat.o(285228);
  }
  
  private a$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.a.a
 * JD-Core Version:    0.7.0.1
 */