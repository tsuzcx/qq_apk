package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.frg;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class j$b
  extends j.i
{
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133089);
    try
    {
      this.YxP = ((frg)this.YxP.parseFrom(paramArrayOfByte));
      l.a(this, this.YxP.getBaseResponse());
      this.mvX = 0;
      if ((this.YxP.getBaseResponse().Idd == 0) && ((this.YxP.abQQ == null) || (this.YxP.abQQ.yth == 0) || (Util.isNullOrNil(w.a(this.YxP.abQQ.YJi)))))
      {
        Log.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
        this.YxP.getBaseResponse().Idd = -1;
      }
      paramArrayOfByte = getErrMsg();
      Log.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
      b.Fu(paramArrayOfByte);
      int i = this.YxP.getBaseResponse().Idd;
      AppMethodBeat.o(133089);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      this.YxP.getBaseResponse().Idd = -1;
      AppMethodBeat.o(133089);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.j.b
 * JD-Core Version:    0.7.0.1
 */