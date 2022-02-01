package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;

public final class j$d
  extends l.e
  implements l.c
{
  public dqs FnN;
  
  public j$d()
  {
    AppMethodBeat.i(133092);
    this.FnN = new dqs();
    AppMethodBeat.o(133092);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133093);
    try
    {
      this.FnN = ((dqs)this.FnN.parseFrom(paramArrayOfByte));
      l.a(this, this.FnN.getBaseResponse());
      if ((this.FnN.getBaseResponse().Ret == 0) && ((this.FnN.HEF == null) || (this.FnN.HEF.qdX == 0) || (bt.cC(z.a(this.FnN.HEF.FyT)))))
      {
        ad.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
        this.FnN.getBaseResponse().Ret = -1;
      }
      paramArrayOfByte = getErrMsg();
      ad.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
      a.wQ(paramArrayOfByte);
      int i = this.FnN.getBaseResponse().Ret;
      AppMethodBeat.o(133093);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bt.n(paramArrayOfByte) });
      this.FnN.getBaseResponse().Ret = -1;
      AppMethodBeat.o(133093);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.j.d
 * JD-Core Version:    0.7.0.1
 */