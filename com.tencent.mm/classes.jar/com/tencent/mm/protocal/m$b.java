package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.jf;
import com.tencent.mm.sdk.platformtools.ab;

public final class m$b
  extends l.e
  implements l.c
{
  public jf wiv;
  
  public m$b()
  {
    AppMethodBeat.i(28281);
    this.wiv = new jf();
    AppMethodBeat.o(28281);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28282);
    this.wiv = ((jf)new jf().parseFrom(paramArrayOfByte));
    ab.d("MicroMsg.MMBgFg", "retcode:" + this.wiv.cnK);
    int i = this.wiv.cnK;
    AppMethodBeat.o(28282);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.m.b
 * JD-Core Version:    0.7.0.1
 */