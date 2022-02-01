package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.jh;

public final class r$c
  extends l.e
  implements l.c
{
  public amt RBN;
  
  public r$c()
  {
    AppMethodBeat.i(149116);
    this.RBN = new amt();
    AppMethodBeat.o(149116);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149117);
    this.RBN = ((amt)new amt().parseFrom(paramArrayOfByte));
    l.a(this, this.RBN.getBaseResponse());
    int i = this.RBN.getBaseResponse().CqV;
    AppMethodBeat.o(149117);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.r.c
 * JD-Core Version:    0.7.0.1
 */