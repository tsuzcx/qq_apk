package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.protocal.protobuf.jh;

public final class t$b
  extends l.e
  implements l.c
{
  public bsf RBT;
  
  public t$b()
  {
    AppMethodBeat.i(133109);
    this.RBT = new bsf();
    AppMethodBeat.o(133109);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133110);
    this.RBT = ((bsf)new bsf().parseFrom(paramArrayOfByte));
    l.a(this, this.RBT.getBaseResponse());
    int i = this.RBT.getBaseResponse().CqV;
    AppMethodBeat.o(133110);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000179;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.t.b
 * JD-Core Version:    0.7.0.1
 */