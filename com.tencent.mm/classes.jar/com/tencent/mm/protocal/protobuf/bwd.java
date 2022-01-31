package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bwd
  extends com.tencent.mm.bv.a
{
  public int xJG;
  private boolean xJH;
  
  private bwd dqJ()
  {
    AppMethodBeat.i(51846);
    if (!this.xJH)
    {
      b localb = new b("Not all required fields were included (false = not included in message),  uiVal:" + this.xJH);
      AppMethodBeat.o(51846);
      throw localb;
    }
    AppMethodBeat.o(51846);
    return this;
  }
  
  public final bwd MU(int paramInt)
  {
    this.xJG = paramInt;
    this.xJH = true;
    return this;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(51847);
    int i = e.a.a.b.b.a.bl(1, this.xJG);
    AppMethodBeat.o(51847);
    return i + 0 + 0;
  }
  
  public final boolean populateBuilderWithField(e.a.a.a.a parama, com.tencent.mm.bv.a parama1, int paramInt)
  {
    AppMethodBeat.i(51850);
    parama1 = (bwd)parama1;
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(51850);
      return bool;
      parama1.MU(parama.CLY.sl());
    }
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(51848);
    dqJ();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(51848);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(51845);
    String str = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("")).append(getClass().getName()).append("(").toString())).append("uiVal = ").append(this.xJG).append("   ").toString() + ")";
    AppMethodBeat.o(51845);
    return str;
  }
  
  public final void writeFields(e.a.a.c.a parama)
  {
    AppMethodBeat.i(51849);
    parama.aO(1, this.xJG);
    AppMethodBeat.o(51849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwd
 * JD-Core Version:    0.7.0.1
 */