package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class etl
  extends com.tencent.mm.bx.a
{
  public String abwM;
  public boolean abwN;
  
  public final etl btH(String paramString)
  {
    this.abwM = paramString;
    this.abwN = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(2387);
    int i = 0;
    if (this.abwN) {
      i = i.a.a.b.b.a.h(1, this.abwM) + 0;
    }
    AppMethodBeat.o(2387);
    return i + 0;
  }
  
  public final etl dh(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(257862);
    paramArrayOfByte = new i.a.a.a.a(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.kFT();
      }
    }
    AppMethodBeat.o(257862);
    return this;
  }
  
  public final boolean populateBuilderWithField(i.a.a.a.a parama, com.tencent.mm.bx.a parama1, int paramInt)
  {
    AppMethodBeat.i(2390);
    parama1 = (etl)parama1;
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
      parama1.btH(parama.ajGk.readString());
    }
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2388);
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(2388);
    return arrayOfByte;
  }
  
  public final Object toJSON()
  {
    return this.abwM;
  }
  
  public final String toString()
  {
    return this.abwM;
  }
  
  public final void writeFields(i.a.a.c.a parama)
  {
    AppMethodBeat.i(2389);
    if (this.abwN) {
      parama.g(1, this.abwM);
    }
    AppMethodBeat.o(2389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etl
 * JD-Core Version:    0.7.0.1
 */