package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dtl;

public final class z$a
  extends l.d
  implements l.b
{
  public dtl KAp;
  
  public z$a()
  {
    AppMethodBeat.i(152472);
    this.KAp = new dtl();
    AppMethodBeat.o(152472);
  }
  
  public final int getCmdId()
  {
    return 42;
  }
  
  public final int getFuncId()
  {
    return 131;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(152473);
    this.KAp.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.KAp.toByteArray();
    AppMethodBeat.o(152473);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.z.a
 * JD-Core Version:    0.7.0.1
 */