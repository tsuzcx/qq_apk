package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public byte cFps;
  public byte cIPeriod;
  public byte cIReqFlag;
  public byte cResolution;
  public byte cRsvd1;
  public byte cSkipFlag;
  public short iKbps;
  public byte[] s2p;
  public byte wTD;
  public byte wTE;
  
  public a()
  {
    AppMethodBeat.i(285126);
    this.s2p = new byte[10];
    AppMethodBeat.o(285126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.a
 * JD-Core Version:    0.7.0.1
 */