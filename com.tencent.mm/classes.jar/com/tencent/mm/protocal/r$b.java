package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.afe;
import com.tencent.mm.sdk.platformtools.bt;

public final class r$b
  extends l.d
  implements l.b
{
  public afe CqO;
  private boolean ufv;
  
  public r$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149114);
    this.ufv = true;
    this.CqO = new afe();
    this.ufv = paramBoolean;
    AppMethodBeat.o(149114);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.ufv) {
      return 3944;
    }
    return 836;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149115);
    this.CqO.setBaseRequest(l.a(this));
    if (this.ufv)
    {
      arrayOfByte = bt.eGG();
      setRsaInfo(ac.eBY());
      this.CqO.Dfg = b.cd(arrayOfByte);
      if (!f.CpT) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.CqO.toByteArray();
    AppMethodBeat.o(149115);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.r.b
 * JD-Core Version:    0.7.0.1
 */