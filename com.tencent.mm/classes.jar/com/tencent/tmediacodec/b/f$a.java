package com.tencent.tmediacodec.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f$a
{
  static
  {
    AppMethodBeat.i(224324);
    ZOI = new a("Uninitialized", 0);
    ZOJ = new a("Configured", 1);
    ZOK = new a("Error", 2);
    ZOL = new a("Flushed", 3);
    ZOM = new a("Running", 4);
    ZON = new a("EndOfStream", 5);
    ZOO = new a("Released", 6);
    ZOP = new a[] { ZOI, ZOJ, ZOK, ZOL, ZOM, ZON, ZOO };
    AppMethodBeat.o(224324);
  }
  
  private f$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmediacodec.b.f.a
 * JD-Core Version:    0.7.0.1
 */