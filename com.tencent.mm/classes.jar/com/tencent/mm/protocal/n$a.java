package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.sdk.platformtools.bo;

public final class n$a
  extends l.d
  implements l.b
{
  public js wiw;
  
  public n$a()
  {
    AppMethodBeat.i(123502);
    this.wiw = new js();
    AppMethodBeat.o(123502);
  }
  
  public final int getFuncId()
  {
    return 145;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(123503);
    setRsaInfo(aa.dqE());
    this.wiw.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.wiw.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.wiw.toByteArray();
    AppMethodBeat.o(123503);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.n.a
 * JD-Core Version:    0.7.0.1
 */