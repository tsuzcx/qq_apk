package com.tencent.mm.plugin.sight.encode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  static
  {
    AppMethodBeat.i(25033);
    qVv = new a("WaitStart", 0);
    qVw = new a("Start", 1);
    qVx = new a("PrepareStop", 2);
    qVy = new a("WaitStop", 3);
    qVz = new a("Stop", 4);
    qVA = new a("WaitSend", 5);
    qVB = new a("Sent", 6);
    qVC = new a("Error", 7);
    qVD = new a("Initialized", 8);
    qVE = new a("Pause", 9);
    qVF = new a[] { qVv, qVw, qVx, qVy, qVz, qVA, qVB, qVC, qVD, qVE };
    AppMethodBeat.o(25033);
  }
  
  private a$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.a.a.a
 * JD-Core Version:    0.7.0.1
 */