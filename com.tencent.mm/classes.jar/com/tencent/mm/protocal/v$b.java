package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.btk;

public final class v$b
  extends l.e
  implements l.c
{
  public btk CqZ;
  
  public v$b()
  {
    AppMethodBeat.i(133117);
    this.CqZ = new btk();
    AppMethodBeat.o(133117);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133118);
    this.CqZ = ((btk)new btk().parseFrom(paramArrayOfByte));
    int i = this.CqZ.Ret;
    AppMethodBeat.o(133118);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000121;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.v.b
 * JD-Core Version:    0.7.0.1
 */