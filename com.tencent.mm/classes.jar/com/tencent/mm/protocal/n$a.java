package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.lx;
import com.tencent.mm.sdk.platformtools.Util;

public final class n$a
  extends l.d
  implements l.b
{
  public lx RBy;
  
  public n$a()
  {
    AppMethodBeat.i(186565);
    this.RBy = new lx();
    AppMethodBeat.o(186565);
  }
  
  public final int getFuncId()
  {
    return 145;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(186567);
    setRsaInfo(ac.hph());
    this.RBy.RQU = new eae().dc(Util.getUuidRandom());
    this.RBy.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.RBy.toByteArray();
    AppMethodBeat.o(186567);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.n.a
 * JD-Core Version:    0.7.0.1
 */