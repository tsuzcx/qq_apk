package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.sdk.platformtools.bo;

public final class c$a
  extends l.d
  implements l.b
{
  public cne snK;
  
  public c$a()
  {
    AppMethodBeat.i(59298);
    this.snK = new cne();
    AppMethodBeat.o(59298);
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
    AppMethodBeat.i(59299);
    setRsaInfo(aa.dqE());
    this.snK.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.snK.setBaseRequest(l.a(this));
    setPassKey(this.snK.wvN.getBuffer().toByteArray());
    byte[] arrayOfByte = this.snK.toByteArray();
    AppMethodBeat.o(59299);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.c.a
 * JD-Core Version:    0.7.0.1
 */