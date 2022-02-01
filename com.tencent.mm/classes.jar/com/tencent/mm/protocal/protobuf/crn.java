package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class crn
  extends com.tencent.mm.bw.a
{
  public int FEo;
  private boolean FEp;
  
  private crn eRK()
  {
    AppMethodBeat.i(2380);
    if (!this.FEp)
    {
      b localb = new b("Not all required fields were included (false = not included in message),  uiVal:" + this.FEp);
      AppMethodBeat.o(2380);
      throw localb;
    }
    AppMethodBeat.o(2380);
    return this;
  }
  
  public final crn XY(int paramInt)
  {
    this.FEo = paramInt;
    this.FEp = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(2381);
    int i = f.a.a.b.b.a.bx(1, this.FEo);
    AppMethodBeat.o(2381);
    return i + 0 + 0;
  }
  
  public final boolean populateBuilderWithField(f.a.a.a.a parama, com.tencent.mm.bw.a parama1, int paramInt)
  {
    AppMethodBeat.i(2384);
    parama1 = (crn)parama1;
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
      parama1.XY(parama.LVo.xF());
    }
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2382);
    eRK();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(2382);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(2379);
    String str = "" + getClass().getName() + "(";
    str = str + "uiVal = " + this.FEo + "   ";
    str = str + ")";
    AppMethodBeat.o(2379);
    return str;
  }
  
  public final void writeFields(f.a.a.c.a parama)
  {
    AppMethodBeat.i(2383);
    parama.aR(1, this.FEo);
    AppMethodBeat.o(2383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crn
 * JD-Core Version:    0.7.0.1
 */