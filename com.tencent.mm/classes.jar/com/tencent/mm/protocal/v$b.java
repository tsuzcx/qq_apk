package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccs;

public final class v$b
  extends l.e
  implements l.c
{
  public ccs Foy;
  
  public v$b()
  {
    AppMethodBeat.i(133117);
    this.Foy = new ccs();
    AppMethodBeat.o(133117);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133118);
    this.Foy = ((ccs)new ccs().parseFrom(paramArrayOfByte));
    int i = this.Foy.Ret;
    AppMethodBeat.o(133118);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000121;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.v.b
 * JD-Core Version:    0.7.0.1
 */