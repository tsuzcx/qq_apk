package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SKBuiltinBuffer_t
  extends com.tencent.mm.bw.a
{
  private static final int fieldNumberBuffer = 2;
  private static final int fieldNumberILen = 1;
  private com.tencent.mm.bw.b Buffer;
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
    int j = f.a.a.b.b.a.bz(1, this.iLen) + 0;
    int i = j;
    if (this.hasBuffer) {
      i = j + f.a.a.b.b.a.b(2, this.Buffer);
    }
    j = computeNestedMessageSize();
    AppMethodBeat.o(2372);
    return i + j;
  }
  
  public com.tencent.mm.bw.b getBuffer()
  {
    return this.Buffer;
  }
  
  public byte[] getBufferToBytes()
  {
    return this.Buffer.zr;
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
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.gCg();
      }
    }
    paramArrayOfByte = validate();
    AppMethodBeat.o(2376);
    return paramArrayOfByte;
  }
  
  public final boolean populateBuilderWithField(f.a.a.a.a parama, com.tencent.mm.bw.a parama1, int paramInt)
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
      parama1.setILen(parama.OmT.zc());
      continue;
      parama1.setBuffer(parama.OmT.gCk());
    }
  }
  
  public SKBuiltinBuffer_t setBuffer(com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(2369);
    if (paramb == null) {
      setBuffer(null);
    }
    this.Buffer = paramb;
    this.hasBuffer = true;
    setILen(this.Buffer.zr.length);
    AppMethodBeat.o(2369);
    return this;
  }
  
  public SKBuiltinBuffer_t setBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2367);
    paramArrayOfByte = com.tencent.mm.bw.b.cm(paramArrayOfByte);
    setBuffer(paramArrayOfByte);
    setILen(paramArrayOfByte.zr.length);
    AppMethodBeat.o(2367);
    return this;
  }
  
  public SKBuiltinBuffer_t setBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2368);
    paramArrayOfByte = com.tencent.mm.bw.b.G(paramArrayOfByte, paramInt1, paramInt2);
    setBuffer(paramArrayOfByte);
    setILen(paramArrayOfByte.zr.length);
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
    Object localObject = "" + getClass().getName() + "(";
    String str = (String)localObject + "iLen = " + this.iLen + "   ";
    localObject = str;
    if (this.hasBuffer) {
      localObject = str + "Buffer = " + this.Buffer + "   ";
    }
    localObject = (String)localObject + ")";
    AppMethodBeat.o(2370);
    return localObject;
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
    parama.aS(1, this.iLen);
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