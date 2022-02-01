package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.sdk.platformtools.bs;

public final class n$a
  extends l.d
  implements l.b
{
  public lg DIS;
  
  public n$a()
  {
    AppMethodBeat.i(134234);
    this.DIS = new lg();
    AppMethodBeat.o(134234);
  }
  
  public final int getFuncId()
  {
    return 145;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(134235);
    setRsaInfo(ac.eRt());
    this.DIS.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
    this.DIS.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.DIS.toByteArray();
    AppMethodBeat.o(134235);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.n.a
 * JD-Core Version:    0.7.0.1
 */