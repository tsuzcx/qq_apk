package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.sdk.platformtools.Util;

public final class r$b
  extends l.d
  implements l.b
{
  private boolean GxN;
  public ams RBM;
  
  public r$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149114);
    this.GxN = true;
    this.RBM = new ams();
    this.GxN = paramBoolean;
    AppMethodBeat.o(149114);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.GxN) {
      return 3944;
    }
    return 836;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149115);
    this.RBM.setBaseRequest(l.a(this));
    if (this.GxN)
    {
      arrayOfByte = Util.getUuidRandom();
      setRsaInfo(ac.hph());
      this.RBM.SwT = b.cU(arrayOfByte);
      if (!f.RAO) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.RBM.toByteArray();
    AppMethodBeat.o(149115);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.r.b
 * JD-Core Version:    0.7.0.1
 */