package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class x$b
  extends l.e
  implements l.c
{
  public byte[] YxT;
  private byte[] YxU;
  public dug YyC;
  public int mvX;
  private byte[] pnm;
  private byte[] pnn;
  
  public x$b()
  {
    AppMethodBeat.i(133122);
    this.YyC = new dug();
    this.mvX = 0;
    AppMethodBeat.o(133122);
  }
  
  public final byte[] axu(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new byte[0];
    case 1: 
      return this.YxU;
    case 2: 
      return this.pnm;
    }
    return this.pnn;
  }
  
  public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(133124);
    this.YxU = paramArrayOfByte1;
    this.pnm = paramArrayOfByte2;
    this.pnn = paramArrayOfByte3;
    Log.i("MicroMsg.MMReg2.Resp", "summerauths setSession [%s] [%s] [%s]", new Object[] { Util.secPrint(Util.dumpHex(this.YxU)), Util.secPrint(Util.dumpHex(this.pnm)), Util.secPrint(Util.dumpHex(this.pnn)) });
    AppMethodBeat.o(133124);
  }
  
  public int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133123);
    this.mvX = 0;
    this.YyC = ((dug)new dug().parseFrom(paramArrayOfByte));
    l.a(this, this.YyC.getBaseResponse());
    this.mvX = 0;
    int i = this.YyC.getBaseResponse().Idd;
    AppMethodBeat.o(133123);
    return i;
  }
  
  public int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.x.b
 * JD-Core Version:    0.7.0.1
 */