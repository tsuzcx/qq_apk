package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.sdk.platformtools.bu;

public final class r$b
  extends l.d
  implements l.b
{
  public ajd FGL;
  private boolean wJx;
  
  public r$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149114);
    this.wJx = true;
    this.FGL = new ajd();
    this.wJx = paramBoolean;
    AppMethodBeat.o(149114);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.wJx) {
      return 3944;
    }
    return 836;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149115);
    this.FGL.setBaseRequest(l.a(this));
    if (this.wJx)
    {
      arrayOfByte = bu.fpG();
      setRsaInfo(ac.fkn());
      this.FGL.GyH = b.cm(arrayOfByte);
      if (!f.FFQ) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.FGL.toByteArray();
    AppMethodBeat.o(149115);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.r.b
 * JD-Core Version:    0.7.0.1
 */