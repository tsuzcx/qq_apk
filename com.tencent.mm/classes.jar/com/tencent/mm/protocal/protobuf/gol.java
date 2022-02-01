package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class gol
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b aaxD;
  public int abwJ;
  private boolean akll;
  public boolean aklm;
  
  private gol aNF(int paramInt)
  {
    this.abwJ = paramInt;
    this.akll = true;
    return this;
  }
  
  private gol kLV()
  {
    AppMethodBeat.i(2371);
    if (!this.akll)
    {
      i.a.a.b localb = new i.a.a.b("Not all required fields were included (false = not included in message),  iLen:" + this.akll);
      AppMethodBeat.o(2371);
      throw localb;
    }
    AppMethodBeat.o(2371);
    return this;
  }
  
  public final gol ah(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(258038);
    paramArrayOfByte = com.tencent.mm.bx.b.P(paramArrayOfByte, 0, paramInt);
    m(paramArrayOfByte);
    aNF(paramArrayOfByte.Op.length);
    AppMethodBeat.o(258038);
    return this;
  }
  
  public int computeSize()
  {
    AppMethodBeat.i(2372);
    int j = i.a.a.b.b.a.cJ(1, this.abwJ) + 0;
    int i = j;
    if (this.aklm) {
      i = j + i.a.a.b.b.a.c(2, this.aaxD);
    }
    AppMethodBeat.o(2372);
    return i + 0;
  }
  
  public final gol df(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2367);
    paramArrayOfByte = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    m(paramArrayOfByte);
    aNF(paramArrayOfByte.Op.length);
    AppMethodBeat.o(2367);
    return this;
  }
  
  public final gol dg(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2376);
    paramArrayOfByte = new i.a.a.a.a(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.kFT();
      }
    }
    paramArrayOfByte = kLV();
    AppMethodBeat.o(2376);
    return paramArrayOfByte;
  }
  
  public final gol m(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(2369);
    if (paramb == null) {
      df(null);
    }
    this.aaxD = paramb;
    this.aklm = true;
    aNF(this.aaxD.Op.length);
    AppMethodBeat.o(2369);
    return this;
  }
  
  public final boolean populateBuilderWithField(i.a.a.a.a parama, com.tencent.mm.bx.a parama1, int paramInt)
  {
    AppMethodBeat.i(2375);
    parama1 = (gol)parama1;
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(2375);
      return bool;
      parama1.aNF(parama.ajGk.aar());
      continue;
      parama1.m(parama.ajGk.kFX());
    }
  }
  
  public byte[] toByteArray()
  {
    AppMethodBeat.i(2373);
    kLV();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(2373);
    return arrayOfByte;
  }
  
  public Object toJSON()
  {
    return "";
  }
  
  public String toString()
  {
    AppMethodBeat.i(2370);
    Object localObject = "" + getClass().getName() + "(";
    String str = (String)localObject + "iLen = " + this.abwJ + "   ";
    localObject = str;
    if (this.aklm) {
      localObject = str + "Buffer = " + this.aaxD + "   ";
    }
    localObject = (String)localObject + ")";
    AppMethodBeat.o(2370);
    return localObject;
  }
  
  public void writeFields(i.a.a.c.a parama)
  {
    AppMethodBeat.i(2374);
    parama.bS(1, this.abwJ);
    if (this.aklm) {
      parama.d(2, this.aaxD);
    }
    AppMethodBeat.o(2374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gol
 * JD-Core Version:    0.7.0.1
 */