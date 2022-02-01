package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SKBuiltinBuffer_t
  extends com.tencent.mm.bx.a
{
  private static final int fieldNumberBuffer = 2;
  private static final int fieldNumberILen = 1;
  private com.tencent.mm.bx.b Buffer;
  private boolean hasBuffer;
  private boolean hasILen;
  private int iLen;
  
  private int computeNestedMessageSize()
  {
    return 0;
  }
  
  private SKBuiltinBuffer_t setILen(int paramInt)
  {
    this.iLen = paramInt;
    this.hasILen = true;
    return this;
  }
  
  public int computeSize()
  {
    AppMethodBeat.i(2372);
    int j = f.a.a.b.b.a.bA(1, this.iLen) + 0;
    int i = j;
    if (this.hasBuffer) {
      i = j + f.a.a.b.b.a.b(2, this.Buffer);
    }
    j = computeNestedMessageSize();
    AppMethodBeat.o(2372);
    return i + j;
  }
  
  public com.tencent.mm.bx.b getBuffer()
  {
    return this.Buffer;
  }
  
  public byte[] getBufferToBytes()
  {
    return this.Buffer.wA;
  }
  
  public int getILen()
  {
    return this.iLen;
  }
  
  public boolean hasBuffer()
  {
    return this.hasBuffer;
  }
  
  public SKBuiltinBuffer_t parseFrom(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2376);
    paramArrayOfByte = new f.a.a.a.a(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte);; i = getNextFieldNumber(paramArrayOfByte))
    {
      if (i <= 0)
      {
        paramArrayOfByte = validate();
        AppMethodBeat.o(2376);
        return paramArrayOfByte;
      }
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.fMq();
      }
    }
  }
  
  public final boolean populateBuilderWithField(f.a.a.a.a parama, com.tencent.mm.bx.a parama1, int paramInt)
  {
    AppMethodBeat.i(2375);
    parama1 = (SKBuiltinBuffer_t)parama1;
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
      parama1.setILen(parama.KhF.xS());
      continue;
      parama1.setBuffer(parama.KhF.fMu());
    }
  }
  
  public SKBuiltinBuffer_t setBuffer(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(2369);
    if (paramb == null) {
      setBuffer(null);
    }
    this.Buffer = paramb;
    this.hasBuffer = true;
    setILen(this.Buffer.wA.length);
    AppMethodBeat.o(2369);
    return this;
  }
  
  public SKBuiltinBuffer_t setBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2367);
    paramArrayOfByte = com.tencent.mm.bx.b.cd(paramArrayOfByte);
    setBuffer(paramArrayOfByte);
    setILen(paramArrayOfByte.wA.length);
    AppMethodBeat.o(2367);
    return this;
  }
  
  public SKBuiltinBuffer_t setBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2368);
    paramArrayOfByte = com.tencent.mm.bx.b.F(paramArrayOfByte, paramInt1, paramInt2);
    setBuffer(paramArrayOfByte);
    setILen(paramArrayOfByte.wA.length);
    AppMethodBeat.o(2368);
    return this;
  }
  
  public byte[] toByteArray()
  {
    AppMethodBeat.i(2373);
    validate();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(2373);
    return arrayOfByte;
  }
  
  public String toString()
  {
    AppMethodBeat.i(2370);
    String str2 = new StringBuilder(String.valueOf("")).append(getClass().getName()).append("(").toString() + "iLen = " + this.iLen + "   ";
    String str1 = str2;
    if (this.hasBuffer) {
      str1 = str2 + "Buffer = " + this.Buffer + "   ";
    }
    str1 = str1 + ")";
    AppMethodBeat.o(2370);
    return str1;
  }
  
  protected SKBuiltinBuffer_t validate()
  {
    AppMethodBeat.i(2371);
    if (!this.hasILen)
    {
      f.a.a.b localb = new f.a.a.b("Not all required fields were included (false = not included in message),  iLen:" + this.hasILen);
      AppMethodBeat.o(2371);
      throw localb;
    }
    AppMethodBeat.o(2371);
    return this;
  }
  
  public void writeFields(f.a.a.c.a parama)
  {
    AppMethodBeat.i(2374);
    parama.aR(1, this.iLen);
    if (this.hasBuffer) {
      parama.c(2, this.Buffer);
    }
    AppMethodBeat.o(2374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t
 * JD-Core Version:    0.7.0.1
 */