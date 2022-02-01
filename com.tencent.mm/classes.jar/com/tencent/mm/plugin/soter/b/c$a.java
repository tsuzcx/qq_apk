package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.sdk.platformtools.bt;

public final class c$a
  extends l.d
  implements l.b
{
  public drk AEU;
  
  public c$a()
  {
    AppMethodBeat.i(130805);
    this.AEU = new drk();
    AppMethodBeat.o(130805);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 627;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(130806);
    setRsaInfo(ac.fgx());
    this.AEU.FDQ = new SKBuiltinBuffer_t().setBuffer(bt.flL());
    this.AEU.setBaseRequest(l.a(this));
    setPassKey(this.AEU.FDQ.getBuffer().toByteArray());
    byte[] arrayOfByte = this.AEU.toByteArray();
    AppMethodBeat.o(130806);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.c.a
 * JD-Core Version:    0.7.0.1
 */