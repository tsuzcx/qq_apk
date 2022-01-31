package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bga;

public final class s$a
  extends l.d
  implements l.b
{
  public bga wiK;
  
  public s$a()
  {
    AppMethodBeat.i(58852);
    this.wiK = new bga();
    AppMethodBeat.o(58852);
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
    AppMethodBeat.i(58853);
    this.wiK.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.wiK.toByteArray();
    AppMethodBeat.o(58853);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.s.a
 * JD-Core Version:    0.7.0.1
 */