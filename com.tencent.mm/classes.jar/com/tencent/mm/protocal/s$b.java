package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.ajf;
import com.tencent.mm.sdk.platformtools.bu;

public final class s$b
  extends l.d
  implements l.b
{
  public ajf FGP;
  private boolean wJx;
  
  public s$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149120);
    this.wJx = true;
    this.FGP = new ajf();
    this.wJx = paramBoolean;
    AppMethodBeat.o(149120);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.wJx) {
      return 3789;
    }
    return 3644;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149121);
    this.FGP.setBaseRequest(l.a(this));
    if (this.wJx)
    {
      arrayOfByte = bu.fpG();
      setRsaInfo(ac.fkn());
      this.FGP.GyH = b.cm(arrayOfByte);
      if (!f.FFQ) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.FGP.toByteArray();
    AppMethodBeat.o(149121);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.s.b
 * JD-Core Version:    0.7.0.1
 */