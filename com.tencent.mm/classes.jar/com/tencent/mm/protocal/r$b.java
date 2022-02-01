package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.sdk.platformtools.Util;

public final class r$b
  extends l.d
  implements l.b
{
  private boolean AEJ;
  public alr KzW;
  
  public r$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149114);
    this.AEJ = true;
    this.KzW = new alr();
    this.AEJ = paramBoolean;
    AppMethodBeat.o(149114);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.AEJ) {
      return 3944;
    }
    return 836;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149115);
    this.KzW.setBaseRequest(l.a(this));
    if (this.AEJ)
    {
      arrayOfByte = Util.getUuidRandom();
      setRsaInfo(ac.gtR());
      this.KzW.Luv = b.cD(arrayOfByte);
      if (!f.KyZ) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.KzW.toByteArray();
    AppMethodBeat.o(149115);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.r.b
 * JD-Core Version:    0.7.0.1
 */