package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class je
  extends dyl
{
  private byte[] RPb;
  
  public je(byte[] paramArrayOfByte)
  {
    this.RPb = paramArrayOfByte;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    return -1;
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(197570);
    validate();
    int i = this.BaseRequest.computeSize();
    byte[] arrayOfByte = new byte[g.a.a.a.oD(1, i)];
    Object localObject = new g.a.a.c.a(arrayOfByte);
    ((g.a.a.c.a)localObject).oE(1, i);
    this.BaseRequest.writeFields((g.a.a.c.a)localObject);
    ((g.a.a.c.a)localObject).iUC();
    localObject = new byte[arrayOfByte.length + this.RPb.length];
    System.arraycopy(arrayOfByte, 0, localObject, 0, arrayOfByte.length);
    System.arraycopy(this.RPb, 0, localObject, arrayOfByte.length, this.RPb.length);
    AppMethodBeat.o(197570);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.je
 * JD-Core Version:    0.7.0.1
 */