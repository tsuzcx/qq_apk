package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.jh;

public final class s$c
  extends l.e
  implements l.c
{
  public amv RBR;
  
  public s$c()
  {
    AppMethodBeat.i(149122);
    this.RBR = new amv();
    AppMethodBeat.o(149122);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149123);
    this.RBR = ((amv)new amv().parseFrom(paramArrayOfByte));
    l.a(this, this.RBR.getBaseResponse());
    int i = this.RBR.getBaseResponse().CqV;
    AppMethodBeat.o(149123);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.s.c
 * JD-Core Version:    0.7.0.1
 */