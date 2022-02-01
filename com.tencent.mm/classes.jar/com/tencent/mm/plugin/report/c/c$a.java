package com.tencent.mm.plugin.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.sdk.platformtools.bs;

public final class c$a
  extends l.d
  implements l.b
{
  public bnw wTo;
  
  public c$a()
  {
    AppMethodBeat.i(143787);
    this.wTo = new bnw();
    AppMethodBeat.o(143787);
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
    AppMethodBeat.i(143788);
    setRsaInfo(ac.eRu());
    this.wTo.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
    this.wTo.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.wTo.toByteArray();
    AppMethodBeat.o(143788);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.c.c.a
 * JD-Core Version:    0.7.0.1
 */