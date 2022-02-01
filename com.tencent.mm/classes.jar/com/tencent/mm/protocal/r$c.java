package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.age;

public final class r$c
  extends l.e
  implements l.c
{
  public age DJh;
  
  public r$c()
  {
    AppMethodBeat.i(149116);
    this.DJh = new age();
    AppMethodBeat.o(149116);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149117);
    this.DJh = ((age)new age().parseFrom(paramArrayOfByte));
    l.a(this, this.DJh.getBaseResponse());
    int i = this.DJh.getBaseResponse().Ret;
    AppMethodBeat.o(149117);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.r.c
 * JD-Core Version:    0.7.0.1
 */