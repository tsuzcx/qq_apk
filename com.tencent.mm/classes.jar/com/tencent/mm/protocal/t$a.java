package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Util;

public final class t$a
  extends l.d
  implements l.b
{
  public bse RBS;
  
  public t$a()
  {
    AppMethodBeat.i(133107);
    this.RBS = new bse();
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
    setRsaInfo(ac.hpj());
    this.RBS.RQU = new eae().dc(Util.getUuidRandom());
    this.RBS.Tcs = ac.hph().ver;
    this.RBS.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.RBS.toByteArray();
    AppMethodBeat.o(133108);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.t.a
 * JD-Core Version:    0.7.0.1
 */