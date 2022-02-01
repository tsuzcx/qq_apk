package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dub;
import com.tencent.mm.protocal.protobuf.kd;

public final class u$b
  extends l.e
  implements l.c
{
  public dub Yyy;
  
  public u$b()
  {
    AppMethodBeat.i(133113);
    this.Yyy = new dub();
    AppMethodBeat.o(133113);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133114);
    this.Yyy = ((dub)new dub().parseFrom(paramArrayOfByte));
    l.a(this, this.Yyy.getBaseResponse());
    int i = this.Yyy.getBaseResponse().Idd;
    AppMethodBeat.o(133114);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000027;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.u.b
 * JD-Core Version:    0.7.0.1
 */