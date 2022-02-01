package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ka
  extends erp
{
  private byte[] YMo;
  
  public ka(byte[] paramArrayOfByte)
  {
    this.YMo = paramArrayOfByte;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    return -1;
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(260058);
    validate();
    int i = this.BaseRequest.computeSize();
    int j = i.a.a.a.qC(1, i);
    byte[] arrayOfByte = new byte[j];
    Object localObject = new i.a.a.c.a(arrayOfByte);
    ((i.a.a.c.a)localObject).qD(1, i);
    this.BaseRequest.writeFields((i.a.a.c.a)localObject);
    ((i.a.a.c.a)localObject).kGd();
    localObject = new byte[this.YMo.length + j];
    System.arraycopy(arrayOfByte, 0, localObject, 0, j);
    System.arraycopy(this.YMo, 0, localObject, j, this.YMo.length);
    AppMethodBeat.o(260058);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ka
 * JD-Core Version:    0.7.0.1
 */