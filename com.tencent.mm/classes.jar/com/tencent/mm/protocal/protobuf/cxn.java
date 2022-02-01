package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxn
  extends com.tencent.mm.bw.a
{
  public String HId;
  private boolean HIe;
  
  public final cxn aQV(String paramString)
  {
    this.HId = paramString;
    this.HIe = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(2387);
    int i = 0;
    if (this.HIe) {
      i = f.a.a.b.b.a.e(1, this.HId) + 0;
    }
    AppMethodBeat.o(2387);
    return i + 0;
  }
  
  public final String getString()
  {
    return this.HId;
  }
  
  public final boolean populateBuilderWithField(f.a.a.a.a parama, com.tencent.mm.bw.a parama1, int paramInt)
  {
    AppMethodBeat.i(2390);
    parama1 = (cxn)parama1;
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
      parama1.aQV(parama.OmT.readString());
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
    return this.HId;
  }
  
  public final void writeFields(f.a.a.c.a parama)
  {
    AppMethodBeat.i(2389);
    if (this.HIe) {
      parama.d(1, this.HId);
    }
    AppMethodBeat.o(2389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxn
 * JD-Core Version:    0.7.0.1
 */