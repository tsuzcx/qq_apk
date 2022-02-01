package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;

public final class j$d
  extends l.e
  implements l.c
{
  public drp FGl;
  
  public j$d()
  {
    AppMethodBeat.i(133092);
    this.FGl = new drp();
    AppMethodBeat.o(133092);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133093);
    try
    {
      this.FGl = ((drp)this.FGl.parseFrom(paramArrayOfByte));
      l.a(this, this.FGl.getBaseResponse());
      if ((this.FGl.getBaseResponse().Ret == 0) && ((this.FGl.HYs == null) || (this.FGl.HYs.qkC == 0) || (bu.cF(z.a(this.FGl.HYs.FRr)))))
      {
        ae.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
        this.FGl.getBaseResponse().Ret = -1;
      }
      paramArrayOfByte = getErrMsg();
      ae.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
      a.xz(paramArrayOfByte);
      int i = this.FGl.getBaseResponse().Ret;
      AppMethodBeat.o(133093);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ae.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bu.o(paramArrayOfByte) });
      this.FGl.getBaseResponse().Ret = -1;
      AppMethodBeat.o(133093);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.j.d
 * JD-Core Version:    0.7.0.1
 */