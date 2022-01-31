package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum t$a
{
  static
  {
    AppMethodBeat.i(30747);
    zAp = new a("DEFAULT", 0);
    zAq = new a("NEED_DOWNLOAD", 1);
    zAr = new a("DOWNLOADING", 2);
    zAs = new a("NEED_INSTALL", 3);
    zAt = new a("INSTALLED", 4);
    zAu = new a("NO_URL", 5);
    zAv = new a[] { zAp, zAq, zAr, zAs, zAt, zAu };
    AppMethodBeat.o(30747);
  }
  
  private t$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.a
 * JD-Core Version:    0.7.0.1
 */