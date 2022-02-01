package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.sdk.platformtools.bt;

public final class r$b
  extends l.d
  implements l.b
{
  public ait Fon;
  private boolean wtN;
  
  public r$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149114);
    this.wtN = true;
    this.Fon = new ait();
    this.wtN = paramBoolean;
    AppMethodBeat.o(149114);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.wtN) {
      return 3944;
    }
    return 836;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149115);
    this.Fon.setBaseRequest(l.a(this));
    if (this.wtN)
    {
      arrayOfByte = bt.flL();
      setRsaInfo(ac.fgx());
      this.Fon.GfY = b.cj(arrayOfByte);
      if (!f.Fns) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.Fon.toByteArray();
    AppMethodBeat.o(149115);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.r.b
 * JD-Core Version:    0.7.0.1
 */