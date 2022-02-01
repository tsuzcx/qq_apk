package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.sdk.platformtools.bt;

public final class s$b
  extends l.d
  implements l.b
{
  public afg CqS;
  private boolean ufv;
  
  public s$b(boolean paramBoolean)
  {
    AppMethodBeat.i(149120);
    this.ufv = true;
    this.CqS = new afg();
    this.ufv = paramBoolean;
    AppMethodBeat.o(149120);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    if (this.ufv) {
      return 3789;
    }
    return 3644;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(149121);
    this.CqS.setBaseRequest(l.a(this));
    if (this.ufv)
    {
      arrayOfByte = bt.eGG();
      setRsaInfo(ac.eBY());
      this.CqS.Dfg = b.cd(arrayOfByte);
      if (!f.CpT) {
        setPassKey(arrayOfByte);
      }
    }
    byte[] arrayOfByte = this.CqS.toByteArray();
    AppMethodBeat.o(149121);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.s.b
 * JD-Core Version:    0.7.0.1
 */