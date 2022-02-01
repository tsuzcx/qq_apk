package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crm
  extends com.tencent.mm.bw.a
{
  public String FEm;
  private boolean FEn;
  
  public final crm aJV(String paramString)
  {
    this.FEm = paramString;
    this.FEn = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(2387);
    int i = 0;
    if (this.FEn) {
      i = f.a.a.b.b.a.e(1, this.FEm) + 0;
    }
    AppMethodBeat.o(2387);
    return i + 0;
  }
  
  public final String getString()
  {
    return this.FEm;
  }
  
  public final boolean populateBuilderWithField(f.a.a.a.a parama, com.tencent.mm.bw.a parama1, int paramInt)
  {
    AppMethodBeat.i(2390);
    parama1 = (crm)parama1;
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
      parama1.aJV(parama.LVo.readString());
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
    return this.FEm;
  }
  
  public final void writeFields(f.a.a.c.a parama)
  {
    AppMethodBeat.i(2389);
    if (this.FEn) {
      parama.d(1, this.FEm);
    }
    AppMethodBeat.o(2389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crm
 * JD-Core Version:    0.7.0.1
 */