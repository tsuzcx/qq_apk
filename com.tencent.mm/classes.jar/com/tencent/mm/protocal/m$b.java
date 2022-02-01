package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.platformtools.Log;

public final class m$b
  extends l.e
  implements l.c
{
  public mk Yya;
  
  public m$b()
  {
    AppMethodBeat.i(32085);
    this.Yya = new mk();
    AppMethodBeat.o(32085);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32086);
    this.Yya = ((mk)new mk().parseFrom(paramArrayOfByte));
    Log.d("MicroMsg.MMBgFg", "retcode:" + this.Yya.hAV);
    int i = this.Yya.hAV;
    AppMethodBeat.o(32086);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000312;
  }
  
  public final boolean isRawData()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.m.b
 * JD-Core Version:    0.7.0.1
 */