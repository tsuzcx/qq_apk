package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.ly;

public final class n$b
  extends l.e
  implements l.c
{
  public ly RBz;
  
  public n$b()
  {
    AppMethodBeat.i(186441);
    this.RBz = new ly();
    AppMethodBeat.o(186441);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186443);
    this.RBz = ((ly)new ly().parseFrom(paramArrayOfByte));
    l.a(this, this.RBz.getBaseResponse());
    int i = this.RBz.getBaseResponse().CqV;
    AppMethodBeat.o(186443);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.n.b
 * JD-Core Version:    0.7.0.1
 */