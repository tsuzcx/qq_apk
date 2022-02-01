package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eag
  extends com.tencent.mm.cd.a
{
  public int UfA;
  private boolean UfB;
  
  private eag hpI()
  {
    AppMethodBeat.i(2380);
    if (!this.UfB)
    {
      b localb = new b("Not all required fields were included (false = not included in message),  uiVal:" + this.UfB);
      AppMethodBeat.o(2380);
      throw localb;
    }
    AppMethodBeat.o(2380);
    return this;
  }
  
  public final eag arE(int paramInt)
  {
    this.UfA = paramInt;
    this.UfB = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(2381);
    int i = g.a.a.b.b.a.bM(1, this.UfA);
    AppMethodBeat.o(2381);
    return i + 0 + 0;
  }
  
  public final eag df(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198957);
    paramArrayOfByte = new g.a.a.a.a(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.iUs();
      }
    }
    paramArrayOfByte = hpI();
    AppMethodBeat.o(198957);
    return paramArrayOfByte;
  }
  
  public final boolean populateBuilderWithField(g.a.a.a.a parama, com.tencent.mm.cd.a parama1, int paramInt)
  {
    AppMethodBeat.i(2384);
    parama1 = (eag)parama1;
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
      parama1.arE(parama.abFh.AK());
    }
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2382);
    hpI();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(2382);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(2379);
    String str = "" + getClass().getName() + "(";
    str = str + "uiVal = " + this.UfA + "   ";
    str = str + ")";
    AppMethodBeat.o(2379);
    return str;
  }
  
  public final void writeFields(g.a.a.c.a parama)
  {
    AppMethodBeat.i(2383);
    parama.aY(1, this.UfA);
    AppMethodBeat.o(2383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eag
 * JD-Core Version:    0.7.0.1
 */