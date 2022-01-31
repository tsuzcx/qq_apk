package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cnf;

public final class c$b
  extends l.e
  implements l.c
{
  public cnf snL;
  
  public c$b()
  {
    AppMethodBeat.i(59300);
    this.snL = new cnf();
    AppMethodBeat.o(59300);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59301);
    this.snL = ((cnf)new cnf().parseFrom(paramArrayOfByte));
    l.a(this, this.snL.getBaseResponse());
    int i = this.snL.getBaseResponse().Ret;
    AppMethodBeat.o(59301);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.c.b
 * JD-Core Version:    0.7.0.1
 */