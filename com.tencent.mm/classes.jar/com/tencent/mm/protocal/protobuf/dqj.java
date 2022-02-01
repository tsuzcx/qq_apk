package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dqj
  extends com.tencent.mm.bw.a
{
  public int MTq;
  private boolean MTr;
  
  private dqj gul()
  {
    AppMethodBeat.i(2380);
    if (!this.MTr)
    {
      b localb = new b("Not all required fields were included (false = not included in message),  uiVal:" + this.MTr);
      AppMethodBeat.o(2380);
      throw localb;
    }
    AppMethodBeat.o(2380);
    return this;
  }
  
  public final dqj ajp(int paramInt)
  {
    this.MTq = paramInt;
    this.MTr = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(2381);
    int i = g.a.a.b.b.a.bu(1, this.MTq);
    AppMethodBeat.o(2381);
    return i + 0 + 0;
  }
  
  public final boolean populateBuilderWithField(g.a.a.a.a parama, com.tencent.mm.bw.a parama1, int paramInt)
  {
    AppMethodBeat.i(2384);
    parama1 = (dqj)parama1;
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
      parama1.ajp(parama.UbS.zi());
    }
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2382);
    gul();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(2382);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(2379);
    String str = "" + getClass().getName() + "(";
    str = str + "uiVal = " + this.MTq + "   ";
    str = str + ")";
    AppMethodBeat.o(2379);
    return str;
  }
  
  public final void writeFields(g.a.a.c.a parama)
  {
    AppMethodBeat.i(2383);
    parama.aM(1, this.MTq);
    AppMethodBeat.o(2383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqj
 * JD-Core Version:    0.7.0.1
 */