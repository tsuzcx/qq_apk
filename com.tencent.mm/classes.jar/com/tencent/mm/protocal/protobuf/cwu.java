package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cwu
  extends com.tencent.mm.bx.a
{
  public int HoD;
  private boolean HoE;
  
  private cwu fgO()
  {
    AppMethodBeat.i(2380);
    if (!this.HoE)
    {
      b localb = new b("Not all required fields were included (false = not included in message),  uiVal:" + this.HoE);
      AppMethodBeat.o(2380);
      throw localb;
    }
    AppMethodBeat.o(2380);
    return this;
  }
  
  public final cwu ZU(int paramInt)
  {
    this.HoD = paramInt;
    this.HoE = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(2381);
    int i = f.a.a.b.b.a.bz(1, this.HoD);
    AppMethodBeat.o(2381);
    return i + 0 + 0;
  }
  
  public final boolean populateBuilderWithField(f.a.a.a.a parama, com.tencent.mm.bx.a parama1, int paramInt)
  {
    AppMethodBeat.i(2384);
    parama1 = (cwu)parama1;
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(2384);
      return bool;
      parama1.ZU(parama.NPN.zc());
    }
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2382);
    fgO();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(2382);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(2379);
    String str = "" + getClass().getName() + "(";
    str = str + "uiVal = " + this.HoD + "   ";
    str = str + ")";
    AppMethodBeat.o(2379);
    return str;
  }
  
  public final void writeFields(f.a.a.c.a parama)
  {
    AppMethodBeat.i(2383);
    parama.aS(1, this.HoD);
    AppMethodBeat.o(2383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwu
 * JD-Core Version:    0.7.0.1
 */