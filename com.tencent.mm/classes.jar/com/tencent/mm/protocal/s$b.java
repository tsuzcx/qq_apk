package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.aiv;
import com.tencent.mm.sdk.platformtools.bt;

public final class s$b
  extends l.d
  implements l.b
{
  public aiv For;
  private boolean wtN;
  
  public s$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149120);
    this.wtN = true;
    this.For = new aiv();
    this.wtN = paramBoolean;
    AppMethodBeat.o(149120);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.wtN) {
      return 3789;
    }
    return 3644;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149121);
    this.For.setBaseRequest(l.a(this));
    if (this.wtN)
    {
      arrayOfByte = bt.flL();
      setRsaInfo(ac.fgx());
      this.For.GfY = b.cj(arrayOfByte);
      if (!f.Fns) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.For.toByteArray();
    AppMethodBeat.o(149121);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.s.b
 * JD-Core Version:    0.7.0.1
 */