package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.platformtools.bs;

public final class c$a
  extends l.d
  implements l.b
{
  public dlt zna;
  
  public c$a()
  {
    AppMethodBeat.i(130805);
    this.zna = new dlt();
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
    setRsaInfo(ac.eRt());
    this.zna.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
    this.zna.setBaseRequest(l.a(this));
    setPassKey(this.zna.DYu.getBuffer().toByteArray());
    byte[] arrayOfByte = this.zna.toByteArray();
    AppMethodBeat.o(130806);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.c.a
 * JD-Core Version:    0.7.0.1
 */