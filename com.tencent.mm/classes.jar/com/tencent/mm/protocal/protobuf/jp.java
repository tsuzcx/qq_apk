package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jp
  extends dop
{
  private byte[] KOg;
  
  public jp(byte[] paramArrayOfByte)
  {
    this.KOg = paramArrayOfByte;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    return -1;
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(197129);
    validate();
    int i = this.BaseRequest.computeSize();
    byte[] arrayOfByte = new byte[g.a.a.a.nh(1, i)];
    Object localObject = new g.a.a.c.a(arrayOfByte);
    ((g.a.a.c.a)localObject).ni(1, i);
    this.BaseRequest.writeFields((g.a.a.c.a)localObject);
    ((g.a.a.c.a)localObject).hPu();
    localObject = new byte[arrayOfByte.length + this.KOg.length];
    System.arraycopy(arrayOfByte, 0, localObject, 0, arrayOfByte.length);
    System.arraycopy(this.KOg, 0, localObject, arrayOfByte.length, this.KOg.length);
    AppMethodBeat.o(197129);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jp
 * JD-Core Version:    0.7.0.1
 */