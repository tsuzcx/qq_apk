package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.fsc;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Util;

public final class c$a
  extends l.d
  implements l.b
{
  public fsc RZu;
  
  public c$a()
  {
    AppMethodBeat.i(130805);
    this.RZu = new fsc();
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
    setRsaInfo(ac.iQc());
    this.RZu.YOj = new gol().df(Util.getUuidRandom());
    this.RZu.setBaseRequest(l.a(this));
    setPassKey(this.RZu.YOj.aaxD.toByteArray());
    byte[] arrayOfByte = this.RZu.toByteArray();
    AppMethodBeat.o(130806);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.c.a
 * JD-Core Version:    0.7.0.1
 */