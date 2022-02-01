package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ewl;
import com.tencent.mm.sdk.platformtools.Util;

public final class c$a
  extends l.d
  implements l.b
{
  public ewl LvV;
  
  public c$a()
  {
    AppMethodBeat.i(130805);
    this.LvV = new ewl();
    AppMethodBeat.o(130805);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 627;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(130806);
    setRsaInfo(ac.hph());
    this.LvV.RQU = new eae().dc(Util.getUuidRandom());
    this.LvV.setBaseRequest(l.a(this));
    setPassKey(this.LvV.RQU.Tkb.toByteArray());
    byte[] arrayOfByte = this.LvV.toByteArray();
    AppMethodBeat.o(130806);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.c.a
 * JD-Core Version:    0.7.0.1
 */