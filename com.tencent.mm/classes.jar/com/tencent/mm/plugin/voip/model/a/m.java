package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.dte;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends n<dte, dtf>
{
  public m(int paramInt1, drv paramdrv, byte[] paramArrayOfByte, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115256);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dte();
    ((b.a)localObject).hvu = new dtf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipsync";
    ((b.a)localObject).funcId = 174;
    ((b.a)localObject).reqCmdId = 62;
    ((b.a)localObject).respCmdId = 1000000062;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dte)this.rr.hvr.hvw;
    ((dte)localObject).Exf = paramInt1;
    ((dte)localObject).Gbv = paramdrv;
    ((dte)localObject).Exg = paramLong;
    ((dte)localObject).Fwn = u.axw();
    ((dte)localObject).Ekh = paramInt2;
    ((dte)localObject).Eki = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((dte)localObject).FYl = System.currentTimeMillis();
    ac.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + ((dte)localObject).FYl);
    AppMethodBeat.o(115256);
  }
  
  public final g eks()
  {
    AppMethodBeat.i(115257);
    m.1 local1 = new m.1(this);
    AppMethodBeat.o(115257);
    return local1;
  }
  
  public final int eku()
  {
    return ((dte)this.rr.hvr.hvw).Ekh;
  }
  
  public final int getType()
  {
    return 174;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m
 * JD-Core Version:    0.7.0.1
 */