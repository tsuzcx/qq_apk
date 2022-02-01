package com.tencent.mm.plugin.sight.encode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  static
  {
    AppMethodBeat.i(28704);
    yTT = new a("WaitStart", 0);
    yTU = new a("Start", 1);
    yTV = new a("PrepareStop", 2);
    yTW = new a("WaitStop", 3);
    yTX = new a("Stop", 4);
    yTY = new a("WaitSend", 5);
    yTZ = new a("Sent", 6);
    yUa = new a("Error", 7);
    yUb = new a("Initialized", 8);
    yUc = new a("Pause", 9);
    yUd = new a[] { yTT, yTU, yTV, yTW, yTX, yTY, yTZ, yUa, yUb, yUc };
    AppMethodBeat.o(28704);
  }
  
  private a$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.a.a.a
 * JD-Core Version:    0.7.0.1
 */