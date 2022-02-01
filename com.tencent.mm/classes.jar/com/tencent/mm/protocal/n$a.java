package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.sdk.platformtools.Util;

public final class n$a
  extends l.d
  implements l.b
{
  public my Yyb;
  
  public n$a()
  {
    AppMethodBeat.i(257294);
    this.Yyb = new my();
    AppMethodBeat.o(257294);
  }
  
  public final int getFuncId()
  {
    return 145;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(257296);
    setRsaInfo(ac.iQc());
    this.Yyb.YOj = new gol().df(Util.getUuidRandom());
    this.Yyb.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.Yyb.toByteArray();
    AppMethodBeat.o(257296);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.n.a
 * JD-Core Version:    0.7.0.1
 */