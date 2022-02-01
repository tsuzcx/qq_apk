package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.sdk.platformtools.bs;

public final class s$b
  extends l.d
  implements l.b
{
  public agf DJk;
  private boolean vou;
  
  public s$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149120);
    this.vou = true;
    this.DJk = new agf();
    this.vou = paramBoolean;
    AppMethodBeat.o(149120);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.vou) {
      return 3789;
    }
    return 3644;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149121);
    this.DJk.setBaseRequest(l.a(this));
    if (this.vou)
    {
      arrayOfByte = bs.eWb();
      setRsaInfo(ac.eRt());
      this.DJk.Eym = b.cc(arrayOfByte);
      if (!f.DIl) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.DJk.toByteArray();
    AppMethodBeat.o(149121);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.s.b
 * JD-Core Version:    0.7.0.1
 */