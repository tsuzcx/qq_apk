package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bys;

public final class x$b
  extends l.e
  implements l.c
{
  public bys wiW;
  
  public x$b()
  {
    AppMethodBeat.i(80002);
    this.wiW = new bys();
    AppMethodBeat.o(80002);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(80003);
    this.wiW = ((bys)new bys().parseFrom(paramArrayOfByte));
    l.a(this, this.wiW.getBaseResponse());
    int i = this.wiW.getBaseResponse().Ret;
    AppMethodBeat.o(80003);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.x.b
 * JD-Core Version:    0.7.0.1
 */