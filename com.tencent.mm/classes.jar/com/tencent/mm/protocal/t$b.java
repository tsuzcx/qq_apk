package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.kd;

public final class t$b
  extends l.e
  implements l.c
{
  public cgy Yyw;
  
  public t$b()
  {
    AppMethodBeat.i(133109);
    this.Yyw = new cgy();
    AppMethodBeat.o(133109);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133110);
    this.Yyw = ((cgy)new cgy().parseFrom(paramArrayOfByte));
    l.a(this, this.Yyw.getBaseResponse());
    int i = this.Yyw.getBaseResponse().Idd;
    AppMethodBeat.o(133110);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000179;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.t.b
 * JD-Core Version:    0.7.0.1
 */