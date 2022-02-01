package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dcq;

public final class v$a
  extends l.d
  implements l.b
{
  public dcq RBW;
  
  public v$a()
  {
    AppMethodBeat.i(133115);
    this.RBW = new dcq();
    AppMethodBeat.o(133115);
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
    AppMethodBeat.i(133116);
    byte[] arrayOfByte = this.RBW.toByteArray();
    AppMethodBeat.o(133116);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.v.a
 * JD-Core Version:    0.7.0.1
 */