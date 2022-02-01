package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class j$d
  extends l.e
  implements l.c
{
  public ell Kzw;
  
  public j$d()
  {
    AppMethodBeat.i(133092);
    this.Kzw = new ell();
    AppMethodBeat.o(133092);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133093);
    try
    {
      this.Kzw = ((ell)this.Kzw.parseFrom(paramArrayOfByte));
      l.a(this, this.Kzw.getBaseResponse());
      if ((this.Kzw.getBaseResponse().Ret == 0) && ((this.Kzw.Nky == null) || (this.Kzw.Nky.rBx == 0) || (Util.isNullOrNil(z.a(this.Kzw.Nky.KKY)))))
      {
        Log.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
        this.Kzw.getBaseResponse().Ret = -1;
      }
      paramArrayOfByte = getErrMsg();
      Log.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
      a.FL(paramArrayOfByte);
      int i = this.Kzw.getBaseResponse().Ret;
      AppMethodBeat.o(133093);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      this.Kzw.getBaseResponse().Ret = -1;
      AppMethodBeat.o(133093);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.j.d
 * JD-Core Version:    0.7.0.1
 */