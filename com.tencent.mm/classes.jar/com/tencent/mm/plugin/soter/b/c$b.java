package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dsi;

public final class c$b
  extends l.e
  implements l.c
{
  public dsi AWy;
  
  public c$b()
  {
    AppMethodBeat.i(130807);
    this.AWy = new dsi();
    AppMethodBeat.o(130807);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130808);
    this.AWy = ((dsi)new dsi().parseFrom(paramArrayOfByte));
    l.a(this, this.AWy.getBaseResponse());
    int i = this.AWy.getBaseResponse().Ret;
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