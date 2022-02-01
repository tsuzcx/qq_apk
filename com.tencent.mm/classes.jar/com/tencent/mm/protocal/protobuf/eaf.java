package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eaf
  extends com.tencent.mm.cd.a
{
  public String Ufy;
  public boolean Ufz;
  
  public final eaf btQ(String paramString)
  {
    this.Ufy = paramString;
    this.Ufz = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(2387);
    int i = 0;
    if (this.Ufz) {
      i = g.a.a.b.b.a.g(1, this.Ufy) + 0;
    }
    AppMethodBeat.o(2387);
    return i + 0;
  }
  
  public final eaf de(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198946);
    paramArrayOfByte = new g.a.a.a.a(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.iUs();
      }
    }
    AppMethodBeat.o(198946);
    return this;
  }
  
  public final boolean populateBuilderWithField(g.a.a.a.a parama, com.tencent.mm.cd.a parama1, int paramInt)
  {
    AppMethodBeat.i(2390);
    parama1 = (eaf)parama1;
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
      parama1.btQ(parama.abFh.readString());
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
    return this.Ufy;
  }
  
  public final void writeFields(g.a.a.c.a parama)
  {
    AppMethodBeat.i(2389);
    if (this.Ufz) {
      parama.f(1, this.Ufy);
    }
    AppMethodBeat.o(2389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaf
 * JD-Core Version:    0.7.0.1
 */