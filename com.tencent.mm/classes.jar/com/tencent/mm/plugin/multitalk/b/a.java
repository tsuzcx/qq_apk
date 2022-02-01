package com.tencent.mm.plugin.multitalk.b;

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
  public byte tQn;
  public byte tQo;
  
  public a()
  {
    AppMethodBeat.i(206182);
    this.s2p = new byte[10];
    AppMethodBeat.o(206182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.a
 * JD-Core Version:    0.7.0.1
 */