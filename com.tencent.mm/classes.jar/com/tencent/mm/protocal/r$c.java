package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aiu;

public final class r$c
  extends l.e
  implements l.c
{
  public aiu Foo;
  
  public r$c()
  {
    AppMethodBeat.i(149116);
    this.Foo = new aiu();
    AppMethodBeat.o(149116);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149117);
    this.Foo = ((aiu)new aiu().parseFrom(paramArrayOfByte));
    l.a(this, this.Foo.getBaseResponse());
    int i = this.Foo.getBaseResponse().Ret;
    AppMethodBeat.o(149117);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.r.c
 * JD-Core Version:    0.7.0.1
 */