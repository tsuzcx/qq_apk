package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.duk;

public final class v$b
  extends l.e
  implements l.c
{
  public duk YyA;
  
  public v$b()
  {
    AppMethodBeat.i(133117);
    this.YyA = new duk();
    AppMethodBeat.o(133117);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133118);
    this.YyA = ((duk)new duk().parseFrom(paramArrayOfByte));
    int i = this.YyA.Idd;
    AppMethodBeat.o(133118);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000121;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.v.b
 * JD-Core Version:    0.7.0.1
 */