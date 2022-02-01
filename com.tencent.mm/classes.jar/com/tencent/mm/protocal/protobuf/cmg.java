package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cmg
  extends com.tencent.mm.bx.a
{
  public int Ehp;
  private boolean Ehq;
  
  private cmg eCp()
  {
    AppMethodBeat.i(2380);
    if (!this.Ehq)
    {
      b localb = new b("Not all required fields were included (false = not included in message),  uiVal:" + this.Ehq);
      AppMethodBeat.o(2380);
      throw localb;
    }
    AppMethodBeat.o(2380);
    return this;
  }
  
  public final cmg VP(int paramInt)
  {
    this.Ehp = paramInt;
    this.Ehq = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(2381);
    int i = f.a.a.b.b.a.bA(1, this.Ehp);
    AppMethodBeat.o(2381);
    return i + 0 + 0;
  }
  
  public final boolean populateBuilderWithField(f.a.a.a.a parama, com.tencent.mm.bx.a parama1, int paramInt)
  {
    AppMethodBeat.i(2384);
    parama1 = (cmg)parama1;
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
      parama1.VP(parama.KhF.xS());
    }
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2382);
    eCp();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(2382);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(2379);
    String str = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("")).append(getClass().getName()).append("(").toString())).append("uiVal = ").append(this.Ehp).append("   ").toString() + ")";
    AppMethodBeat.o(2379);
    return str;
  }
  
  public final void writeFields(f.a.a.c.a parama)
  {
    AppMethodBeat.i(2383);
    parama.aR(1, this.Ehp);
    AppMethodBeat.o(2383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmg
 * JD-Core Version:    0.7.0.1
 */