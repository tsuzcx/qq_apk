package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class eae
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b Tkb;
  public int Ufv;
  private boolean XtU;
  public boolean YtU;
  
  private eae asN(int paramInt)
  {
    this.Ufv = paramInt;
    this.XtU = true;
    return this;
  }
  
  private eae hAR()
  {
    AppMethodBeat.i(2371);
    if (!this.XtU)
    {
      g.a.a.b localb = new g.a.a.b("Not all required fields were included (false = not included in message),  iLen:" + this.XtU);
      AppMethodBeat.o(2371);
      throw localb;
    }
    AppMethodBeat.o(2371);
    return this;
  }
  
  public final eae ag(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(198921);
    paramArrayOfByte = com.tencent.mm.cd.b.S(paramArrayOfByte, 0, paramInt);
    g(paramArrayOfByte);
    asN(paramArrayOfByte.UH.length);
    AppMethodBeat.o(198921);
    return this;
  }
  
  public int computeSize()
  {
    AppMethodBeat.i(2372);
    int j = g.a.a.b.b.a.bM(1, this.Ufv) + 0;
    int i = j;
    if (this.YtU) {
      i = j + g.a.a.b.b.a.b(2, this.Tkb);
    }
    AppMethodBeat.o(2372);
    return i + 0;
  }
  
  public final eae dc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2367);
    paramArrayOfByte = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    g(paramArrayOfByte);
    asN(paramArrayOfByte.UH.length);
    AppMethodBeat.o(2367);
    return this;
  }
  
  public final eae dd(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2376);
    paramArrayOfByte = new g.a.a.a.a(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.iUs();
      }
    }
    paramArrayOfByte = hAR();
    AppMethodBeat.o(2376);
    return paramArrayOfByte;
  }
  
  public final eae g(com.tencent.mm.cd.b paramb)
  {
    AppMethodBeat.i(2369);
    if (paramb == null) {
      dc(null);
    }
    this.Tkb = paramb;
    this.YtU = true;
    asN(this.Tkb.UH.length);
    AppMethodBeat.o(2369);
    return this;
  }
  
  public final boolean populateBuilderWithField(g.a.a.a.a parama, com.tencent.mm.cd.a parama1, int paramInt)
  {
    AppMethodBeat.i(2375);
    parama1 = (eae)parama1;
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
      parama1.asN(parama.abFh.AK());
      continue;
      parama1.g(parama.abFh.iUw());
    }
  }
  
  public byte[] toByteArray()
  {
    AppMethodBeat.i(2373);
    hAR();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(2373);
    return arrayOfByte;
  }
  
  public String toString()
  {
    AppMethodBeat.i(2370);
    Object localObject = "" + getClass().getName() + "(";
    String str = (String)localObject + "iLen = " + this.Ufv + "   ";
    localObject = str;
    if (this.YtU) {
      localObject = str + "Buffer = " + this.Tkb + "   ";
    }
    localObject = (String)localObject + ")";
    AppMethodBeat.o(2370);
    return localObject;
  }
  
  public void writeFields(g.a.a.c.a parama)
  {
    AppMethodBeat.i(2374);
    parama.aY(1, this.Ufv);
    if (this.YtU) {
      parama.c(2, this.Tkb);
    }
    AppMethodBeat.o(2374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eae
 * JD-Core Version:    0.7.0.1
 */