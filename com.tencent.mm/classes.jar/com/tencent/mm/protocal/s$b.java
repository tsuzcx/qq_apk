package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.sdk.platformtools.Util;

public final class s$b
  extends l.d
  implements l.b
{
  private boolean AEJ;
  public alt KAa;
  
  public s$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149120);
    this.AEJ = true;
    this.KAa = new alt();
    this.AEJ = paramBoolean;
    AppMethodBeat.o(149120);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.AEJ) {
      return 3789;
    }
    return 3644;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149121);
    this.KAa.setBaseRequest(l.a(this));
    if (this.AEJ)
    {
      arrayOfByte = Util.getUuidRandom();
      setRsaInfo(ac.gtR());
      this.KAa.Luv = b.cD(arrayOfByte);
      if (!f.KyZ) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.KAa.toByteArray();
    AppMethodBeat.o(149121);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.s.b
 * JD-Core Version:    0.7.0.1
 */