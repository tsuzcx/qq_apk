package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgi;

public final class t$a
  extends l.d
  implements l.b
{
  public bgi wiM;
  
  public t$a()
  {
    AppMethodBeat.i(58856);
    this.wiM = new bgi();
    AppMethodBeat.o(58856);
  }
  
  public final int getCmdId()
  {
    return 121;
  }
  
  public final int getFuncId()
  {
    return 138;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(58857);
    byte[] arrayOfByte = this.wiM.toByteArray();
    AppMethodBeat.o(58857);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.t.a
 * JD-Core Version:    0.7.0.1
 */