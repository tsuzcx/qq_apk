package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.sdk.platformtools.bo;

public final class c$a
  extends l.d
  implements l.b
{
  public ayu qrU;
  
  public c$a()
  {
    AppMethodBeat.i(72671);
    this.qrU = new ayu();
    AppMethodBeat.o(72671);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 499;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(72672);
    setRsaInfo(aa.dqF());
    this.qrU.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.qrU.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.qrU.toByteArray();
    AppMethodBeat.o(72672);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.c.a
 * JD-Core Version:    0.7.0.1
 */