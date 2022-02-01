package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cdd;

public final class u$a
  extends l.d
  implements l.b
{
  public cdd FGT;
  
  public u$a()
  {
    AppMethodBeat.i(133111);
    this.FGT = new cdd();
    AppMethodBeat.o(133111);
  }
  
  public final int getCmdId()
  {
    return 27;
  }
  
  public final int getFuncId()
  {
    return 139;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(133112);
    this.FGT.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.FGT.toByteArray();
    AppMethodBeat.o(133112);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.u.a
 * JD-Core Version:    0.7.0.1
 */