package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.sdk.platformtools.bt;

public final class c$a
  extends l.d
  implements l.b
{
  public bsi ygY;
  
  public c$a()
  {
    AppMethodBeat.i(143787);
    this.ygY = new bsi();
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
    setRsaInfo(ac.fgy());
    this.ygY.FDQ = new SKBuiltinBuffer_t().setBuffer(bt.flL());
    this.ygY.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.ygY.toByteArray();
    AppMethodBeat.o(143788);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.c.a
 * JD-Core Version:    0.7.0.1
 */