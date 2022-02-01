package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.drl;

public final class c$b
  extends l.e
  implements l.c
{
  public drl AEV;
  
  public c$b()
  {
    AppMethodBeat.i(130807);
    this.AEV = new drl();
    AppMethodBeat.o(130807);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130808);
    this.AEV = ((drl)new drl().parseFrom(paramArrayOfByte));
    l.a(this, this.AEV.getBaseResponse());
    int i = this.AEV.getBaseResponse().Ret;
    AppMethodBeat.o(130808);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.c.b
 * JD-Core Version:    0.7.0.1
 */