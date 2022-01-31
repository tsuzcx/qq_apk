package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgj;

public final class t$b
  extends l.e
  implements l.c
{
  public bgj wiN;
  
  public t$b()
  {
    AppMethodBeat.i(58858);
    this.wiN = new bgj();
    AppMethodBeat.o(58858);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58859);
    this.wiN = ((bgj)new bgj().parseFrom(paramArrayOfByte));
    int i = this.wiN.Ret;
    AppMethodBeat.o(58859);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000121;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.t.b
 * JD-Core Version:    0.7.0.1
 */