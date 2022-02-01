package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqi
  extends com.tencent.mm.bw.a
{
  public String MTo;
  public boolean MTp;
  
  public final dqi bhy(String paramString)
  {
    this.MTo = paramString;
    this.MTp = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(2387);
    int i = 0;
    if (this.MTp) {
      i = g.a.a.b.b.a.f(1, this.MTo) + 0;
    }
    AppMethodBeat.o(2387);
    return i + 0;
  }
  
  public final boolean populateBuilderWithField(g.a.a.a.a parama, com.tencent.mm.bw.a parama1, int paramInt)
  {
    AppMethodBeat.i(2390);
    parama1 = (dqi)parama1;
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(2390);
      return bool;
      parama1.bhy(parama.UbS.readString());
    }
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2388);
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(2388);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    return this.MTo;
  }
  
  public final void writeFields(g.a.a.c.a parama)
  {
    AppMethodBeat.i(2389);
    if (this.MTp) {
      parama.e(1, this.MTo);
    }
    AppMethodBeat.o(2389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqi
 * JD-Core Version:    0.7.0.1
 */