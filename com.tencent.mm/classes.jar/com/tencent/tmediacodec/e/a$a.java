package com.tencent.tmediacodec.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  static
  {
    AppMethodBeat.i(190167);
    Smx = new a("ADAPTATION_WORKAROUND_MODE_NEVER", 0);
    Smy = new a("ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION", 1);
    Smz = new a("ADAPTATION_WORKAROUND_MODE_ALWAYS", 2);
    SmA = new a[] { Smx, Smy, Smz };
    AppMethodBeat.o(190167);
  }
  
  private a$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmediacodec.e.a.a
 * JD-Core Version:    0.7.0.1
 */