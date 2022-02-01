package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmf
  extends com.tencent.mm.bx.a
{
  public String Ehn;
  private boolean Eho;
  
  public final cmf aEE(String paramString)
  {
    this.Ehn = paramString;
    this.Eho = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(2387);
    int i = 0;
    if (this.Eho) {
      i = f.a.a.b.b.a.e(1, this.Ehn) + 0;
    }
    AppMethodBeat.o(2387);
    return i + 0;
  }
  
  public final String getString()
  {
    return this.Ehn;
  }
  
  public final boolean populateBuilderWithField(f.a.a.a.a parama, com.tencent.mm.bx.a parama1, int paramInt)
  {
    AppMethodBeat.i(2390);
    parama1 = (cmf)parama1;
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
      parama1.aEE(parama.KhF.readString());
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
    return this.Ehn;
  }
  
  public final void writeFields(f.a.a.c.a parama)
  {
    AppMethodBeat.i(2389);
    if (this.Eho) {
      parama.d(1, this.Ehn);
    }
    AppMethodBeat.o(2389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmf
 * JD-Core Version:    0.7.0.1
 */