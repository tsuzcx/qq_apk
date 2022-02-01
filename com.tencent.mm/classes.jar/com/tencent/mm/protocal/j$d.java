package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;

public final class j$d
  extends l.e
  implements l.c
{
  public dlb DIG;
  
  public j$d()
  {
    AppMethodBeat.i(133092);
    this.DIG = new dlb();
    AppMethodBeat.o(133092);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133093);
    try
    {
      this.DIG = ((dlb)this.DIG.parseFrom(paramArrayOfByte));
      l.a(this, this.DIG.getBaseResponse());
      if ((this.DIG.getBaseResponse().Ret == 0) && ((this.DIG.FTR == null) || (this.DIG.FTR.pAs == 0) || (bs.cv(z.a(this.DIG.FTR.DTz)))))
      {
        ac.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
        this.DIG.getBaseResponse().Ret = -1;
      }
      paramArrayOfByte = getErrMsg();
      ac.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
      a.ua(paramArrayOfByte);
      int i = this.DIG.getBaseResponse().Ret;
      AppMethodBeat.o(133093);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      ac.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bs.m(paramArrayOfByte) });
      this.DIG.getBaseResponse().Ret = -1;
      AppMethodBeat.o(133093);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.j.d
 * JD-Core Version:    0.7.0.1
 */