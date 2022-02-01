package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.sdk.platformtools.Util;

public final class n$a
  extends l.d
  implements l.b
{
  public mh KzI;
  
  public n$a()
  {
    AppMethodBeat.i(222853);
    this.KzI = new mh();
    AppMethodBeat.o(222853);
  }
  
  public final int getFuncId()
  {
    return 145;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(222854);
    setRsaInfo(ac.gtR());
    this.KzI.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
    this.KzI.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.KzI.toByteArray();
    AppMethodBeat.o(222854);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.n.a
 * JD-Core Version:    0.7.0.1
 */