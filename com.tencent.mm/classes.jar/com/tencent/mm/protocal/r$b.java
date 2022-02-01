package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.sdk.platformtools.Util;

public final class r$b
  extends l.d
  implements l.b
{
  private boolean MtT;
  public aqk Yyp;
  
  public r$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149114);
    this.MtT = true;
    this.Yyp = new aqk();
    this.MtT = paramBoolean;
    AppMethodBeat.o(149114);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.MtT) {
      return 3944;
    }
    return 836;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149115);
    this.Yyp.setBaseRequest(l.a(this));
    if (this.MtT)
    {
      arrayOfByte = Util.getUuidRandom();
      setRsaInfo(ac.iQc());
      this.Yyp.ZxD = b.cX(arrayOfByte);
      if (!f.Yxs) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.Yyp.toByteArray();
    AppMethodBeat.o(149115);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.r.b
 * JD-Core Version:    0.7.0.1
 */