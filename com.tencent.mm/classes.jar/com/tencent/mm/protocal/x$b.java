package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class x$b
  extends l.e
  implements l.c
{
  public dco RBZ;
  public byte[] RBq;
  private byte[] RBr;
  public int jWd;
  private byte[] mtS;
  private byte[] mtT;
  
  public x$b()
  {
    AppMethodBeat.i(133122);
    this.RBZ = new dco();
    this.jWd = 0;
    AppMethodBeat.o(133122);
  }
  
  public final byte[] arm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new byte[0];
    case 1: 
      return this.RBr;
    case 2: 
      return this.mtS;
    }
    return this.mtT;
  }
  
  public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(133124);
    this.RBr = paramArrayOfByte1;
    this.mtS = paramArrayOfByte2;
    this.mtT = paramArrayOfByte3;
    Log.i("MicroMsg.MMReg2.Resp", "summerauths setSession [%s] [%s] [%s]", new Object[] { Util.secPrint(Util.dumpHex(this.RBr)), Util.secPrint(Util.dumpHex(this.mtS)), Util.secPrint(Util.dumpHex(this.mtT)) });
    AppMethodBeat.o(133124);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133123);
    this.jWd = 0;
    this.RBZ = ((dco)new dco().parseFrom(paramArrayOfByte));
    l.a(this, this.RBZ.getBaseResponse());
    this.jWd = 0;
    int i = this.RBZ.getBaseResponse().CqV;
    AppMethodBeat.o(133123);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.x.b
 * JD-Core Version:    0.7.0.1
 */