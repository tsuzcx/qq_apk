package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.la;
import com.tencent.mm.sdk.platformtools.bt;

public final class n$a
  extends l.d
  implements l.b
{
  public la CqA;
  
  public n$a()
  {
    AppMethodBeat.i(134234);
    this.CqA = new la();
    AppMethodBeat.o(134234);
  }
  
  public final int getFuncId()
  {
    return 145;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(134235);
    setRsaInfo(ac.eBY());
    this.CqA.CFU = new SKBuiltinBuffer_t().setBuffer(bt.eGG());
    this.CqA.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.CqA.toByteArray();
    AppMethodBeat.o(134235);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.n.a
 * JD-Core Version:    0.7.0.1
 */