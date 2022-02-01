package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dah;

public final class z$a
  extends l.d
  implements l.b
{
  public dah FHe;
  
  public z$a()
  {
    AppMethodBeat.i(152472);
    this.FHe = new dah();
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
    this.FHe.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.FHe.toByteArray();
    AppMethodBeat.o(152473);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.z.a
 * JD-Core Version:    0.7.0.1
 */