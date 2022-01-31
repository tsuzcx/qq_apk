package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.sdk.platformtools.bo;

public final class b$a
  extends l.d
  implements l.b
{
  public ayu qrU;
  
  public b$a()
  {
    AppMethodBeat.i(72669);
    this.qrU = new ayu();
    AppMethodBeat.o(72669);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 694;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(72670);
    setRsaInfo(aa.dqF());
    this.qrU.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.qrU.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.qrU.toByteArray();
    AppMethodBeat.o(72670);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.b.a
 * JD-Core Version:    0.7.0.1
 */