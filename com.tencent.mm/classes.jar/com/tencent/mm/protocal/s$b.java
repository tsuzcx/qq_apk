package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.sdk.platformtools.Util;

public final class s$b
  extends l.d
  implements l.b
{
  private boolean GxN;
  public amu RBQ;
  
  public s$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149120);
    this.GxN = true;
    this.RBQ = new amu();
    this.GxN = paramBoolean;
    AppMethodBeat.o(149120);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.GxN) {
      return 3789;
    }
    return 3644;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149121);
    this.RBQ.setBaseRequest(l.a(this));
    if (this.GxN)
    {
      arrayOfByte = Util.getUuidRandom();
      setRsaInfo(ac.hph());
      this.RBQ.SwT = b.cU(arrayOfByte);
      if (!f.RAO) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.RBQ.toByteArray();
    AppMethodBeat.o(149121);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.s.b
 * JD-Core Version:    0.7.0.1
 */