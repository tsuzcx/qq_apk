package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Util;

public final class t$a
  extends l.d
  implements l.b
{
  public cgx Yyv;
  
  public t$a()
  {
    AppMethodBeat.i(133107);
    this.Yyv = new cgx();
    AppMethodBeat.o(133107);
  }
  
  public final int getCmdId()
  {
    return 179;
  }
  
  public final int getFuncId()
  {
    return 381;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(133108);
    setRsaInfo(ac.iQe());
    this.Yyv.YOj = new gol().df(Util.getUuidRandom());
    this.Yyv.aapH = ac.iQc().ver;
    this.Yyv.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.Yyv.toByteArray();
    AppMethodBeat.o(133108);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.t.a
 * JD-Core Version:    0.7.0.1
 */