package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bxs;

public final class u$a
  extends l.d
  implements l.b
{
  public bxs DJo;
  
  public u$a()
  {
    AppMethodBeat.i(133111);
    this.DJo = new bxs();
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
    this.DJo.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.DJo.toByteArray();
    AppMethodBeat.o(133112);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.u.a
 * JD-Core Version:    0.7.0.1
 */