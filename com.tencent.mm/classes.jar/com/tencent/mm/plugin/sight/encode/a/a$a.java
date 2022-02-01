package com.tencent.mm.plugin.sight.encode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  static
  {
    AppMethodBeat.i(28704);
    DoT = new a("WaitStart", 0);
    DoU = new a("Start", 1);
    DoV = new a("PrepareStop", 2);
    DoW = new a("WaitStop", 3);
    DoX = new a("Stop", 4);
    DoY = new a("WaitSend", 5);
    DoZ = new a("Sent", 6);
    Dpa = new a("Error", 7);
    Dpb = new a("Initialized", 8);
    Dpc = new a("Pause", 9);
    Dpd = new a[] { DoT, DoU, DoV, DoW, DoX, DoY, DoZ, Dpa, Dpb, Dpc };
    AppMethodBeat.o(28704);
  }
  
  private a$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.a.a.a
 * JD-Core Version:    0.7.0.1
 */