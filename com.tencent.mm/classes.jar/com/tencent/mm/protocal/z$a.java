package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.exb;

public final class z$a
  extends l.d
  implements l.b
{
  public exb YyH;
  
  public z$a()
  {
    AppMethodBeat.i(152472);
    this.YyH = new exb();
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
    this.YyH.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.YyH.toByteArray();
    AppMethodBeat.o(152473);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.z.a
 * JD-Core Version:    0.7.0.1
 */