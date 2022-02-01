package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.kd;

public final class s$c
  extends l.e
  implements l.c
{
  public aqn Yyu;
  
  public s$c()
  {
    AppMethodBeat.i(149122);
    this.Yyu = new aqn();
    AppMethodBeat.o(149122);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149123);
    this.Yyu = ((aqn)new aqn().parseFrom(paramArrayOfByte));
    l.a(this, this.Yyu.getBaseResponse());
    int i = this.Yyu.getBaseResponse().Idd;
    AppMethodBeat.o(149123);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.s.c
 * JD-Core Version:    0.7.0.1
 */