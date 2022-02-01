package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.sdk.platformtools.Util;

public final class s$b
  extends l.d
  implements l.b
{
  private boolean MtT;
  public aqm Yyt;
  
  public s$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149120);
    this.MtT = true;
    this.Yyt = new aqm();
    this.MtT = paramBoolean;
    AppMethodBeat.o(149120);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.MtT) {
      return 3789;
    }
    return 3644;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149121);
    this.Yyt.setBaseRequest(l.a(this));
    if (this.MtT)
    {
      arrayOfByte = Util.getUuidRandom();
      setRsaInfo(ac.iQc());
      this.Yyt.ZxD = b.cX(arrayOfByte);
      if (!f.Yxs) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.Yyt.toByteArray();
    AppMethodBeat.o(149121);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.s.b
 * JD-Core Version:    0.7.0.1
 */