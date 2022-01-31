package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byr;

public final class x$a
  extends l.d
  implements l.b
{
  public byr wiV;
  
  public x$a()
  {
    AppMethodBeat.i(80000);
    this.wiV = new byr();
    AppMethodBeat.o(80000);
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
    AppMethodBeat.i(80001);
    this.wiV.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.wiV.toByteArray();
    AppMethodBeat.o(80001);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.x.a
 * JD-Core Version:    0.7.0.1
 */