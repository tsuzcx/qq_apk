package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class etm
  extends com.tencent.mm.bx.a
{
  public int abwO;
  private boolean abwP;
  
  private etm iQu()
  {
    AppMethodBeat.i(2380);
    if (!this.abwP)
    {
      b localb = new b("Not all required fields were included (false = not included in message),  uiVal:" + this.abwP);
      AppMethodBeat.o(2380);
      throw localb;
    }
    AppMethodBeat.o(2380);
    return this;
  }
  
  public final etm axM(int paramInt)
  {
    this.abwO = paramInt;
    this.abwP = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(2381);
    int i = i.a.a.b.b.a.cJ(1, this.abwO);
    AppMethodBeat.o(2381);
    return i + 0 + 0;
  }
  
  public final etm di(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(257843);
    paramArrayOfByte = new i.a.a.a.a(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.kFT();
      }
    }
    paramArrayOfByte = iQu();
    AppMethodBeat.o(257843);
    return paramArrayOfByte;
  }
  
  public final boolean populateBuilderWithField(i.a.a.a.a parama, com.tencent.mm.bx.a parama1, int paramInt)
  {
    AppMethodBeat.i(2384);
    parama1 = (etm)parama1;
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
      parama1.axM(parama.ajGk.aar());
    }
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2382);
    iQu();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(2382);
    return arrayOfByte;
  }
  
  public final Object toJSON()
  {
    AppMethodBeat.i(257847);
    int i = this.abwO;
    AppMethodBeat.o(257847);
    return Integer.valueOf(i);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(2379);
    String str = "" + getClass().getName() + "(";
    str = str + "uiVal = " + this.abwO + "   ";
    str = str + ")";
    AppMethodBeat.o(2379);
    return str;
  }
  
  public final void writeFields(i.a.a.c.a parama)
  {
    AppMethodBeat.i(2383);
    parama.bS(1, this.abwO);
    AppMethodBeat.o(2383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etm
 * JD-Core Version:    0.7.0.1
 */