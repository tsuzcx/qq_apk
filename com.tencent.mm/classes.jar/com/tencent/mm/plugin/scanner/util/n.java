package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  private static n qDr;
  byte[] qDs = null;
  private byte[] qDt = null;
  
  public static n cjJ()
  {
    AppMethodBeat.i(81461);
    if (qDr == null) {
      qDr = new n();
    }
    n localn = qDr;
    AppMethodBeat.o(81461);
    return localn;
  }
  
  public final void cjK()
  {
    if (this.qDs != null) {
      this.qDs = null;
    }
    if (this.qDt != null) {
      this.qDt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.n
 * JD-Core Version:    0.7.0.1
 */