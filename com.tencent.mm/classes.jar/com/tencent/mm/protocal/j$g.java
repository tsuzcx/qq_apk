package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class j$g
  extends j.i
{
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133096);
    try
    {
      this.RBm = ((evr)this.RBm.parseFrom(paramArrayOfByte));
      l.a(this, this.RBm.getBaseResponse());
      this.jWd = 0;
      if ((this.RBm.getBaseResponse().CqV == 0) && ((this.RBm.Uxi == null) || (this.RBm.Uxi.vhf == 0) || (Util.isNullOrNil(z.a(this.RBm.Uxi.RLU)))))
      {
        Log.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
        this.RBm.getBaseResponse().CqV = -1;
      }
      paramArrayOfByte = getErrMsg();
      Log.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", new Object[] { paramArrayOfByte });
      b.ML(paramArrayOfByte);
      int i = this.RBm.getBaseResponse().CqV;
      AppMethodBeat.o(133096);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      this.RBm.getBaseResponse().CqV = -1;
      AppMethodBeat.o(133096);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.j.g
 * JD-Core Version:    0.7.0.1
 */