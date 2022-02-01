package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;

public final class j$d
  extends l.e
  implements l.c
{
  public dfm Cqo;
  
  public j$d()
  {
    AppMethodBeat.i(133092);
    this.Cqo = new dfm();
    AppMethodBeat.o(133092);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133093);
    try
    {
      this.Cqo = ((dfm)this.Cqo.parseFrom(paramArrayOfByte));
      l.a(this, this.Cqo.getBaseResponse());
      if ((this.Cqo.getBaseResponse().Ret == 0) && ((this.Cqo.EwP == null) || (this.Cqo.EwP.oXh == 0) || (bt.cw(z.a(this.Cqo.EwP.CBb)))))
      {
        ad.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
        this.Cqo.getBaseResponse().Ret = -1;
      }
      paramArrayOfByte = getErrMsg();
      ad.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
      a.qL(paramArrayOfByte);
      int i = this.Cqo.getBaseResponse().Ret;
      AppMethodBeat.o(133093);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bt.m(paramArrayOfByte) });
      this.Cqo.getBaseResponse().Ret = -1;
      AppMethodBeat.o(133093);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.j.d
 * JD-Core Version:    0.7.0.1
 */