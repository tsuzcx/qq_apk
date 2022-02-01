package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.agd;
import com.tencent.mm.sdk.platformtools.bs;

public final class r$b
  extends l.d
  implements l.b
{
  public agd DJg;
  private boolean vou;
  
  public r$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149114);
    this.vou = true;
    this.DJg = new agd();
    this.vou = paramBoolean;
    AppMethodBeat.o(149114);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.vou) {
      return 3944;
    }
    return 836;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149115);
    this.DJg.setBaseRequest(l.a(this));
    if (this.vou)
    {
      arrayOfByte = bs.eWb();
      setRsaInfo(ac.eRt());
      this.DJg.Eym = b.cc(arrayOfByte);
      if (!f.DIl) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.DJg.toByteArray();
    AppMethodBeat.o(149115);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.r.b
 * JD-Core Version:    0.7.0.1
 */