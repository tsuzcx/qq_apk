package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwc
  extends com.tencent.mm.bv.a
{
  public String xJE;
  private boolean xJF;
  
  public final bwc aoF(String paramString)
  {
    this.xJE = paramString;
    this.xJF = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(51853);
    int i = 0;
    if (this.xJF) {
      i = e.a.a.b.b.a.f(1, this.xJE) + 0;
    }
    AppMethodBeat.o(51853);
    return i + 0;
  }
  
  public final boolean populateBuilderWithField(e.a.a.a.a parama, com.tencent.mm.bv.a parama1, int paramInt)
  {
    AppMethodBeat.i(51856);
    parama1 = (bwc)parama1;
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(51856);
      return bool;
      parama1.aoF(parama.CLY.readString());
    }
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(51854);
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(51854);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    return this.xJE;
  }
  
  public final void writeFields(e.a.a.c.a parama)
  {
    AppMethodBeat.i(51855);
    if (this.xJF) {
      parama.e(1, this.xJE);
    }
    AppMethodBeat.o(51855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwc
 * JD-Core Version:    0.7.0.1
 */