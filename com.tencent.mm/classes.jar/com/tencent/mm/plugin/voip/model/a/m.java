package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dxp;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n<dyy, dyz>
{
  public m(int paramInt1, dxp paramdxp, byte[] paramArrayOfByte, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115256);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dyy();
    ((b.a)localObject).hNN = new dyz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipsync";
    ((b.a)localObject).funcId = 174;
    ((b.a)localObject).hNO = 62;
    ((b.a)localObject).respCmdId = 1000000062;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dyy)this.rr.hNK.hNQ;
    ((dyy)localObject).GeI = paramInt1;
    ((dyy)localObject).HMs = paramdxp;
    ((dyy)localObject).GeJ = paramLong;
    ((dyy)localObject).Hgt = u.aAm();
    ((dyy)localObject).FRq = paramInt2;
    ((dyy)localObject).FRr = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((dyy)localObject).HJh = System.currentTimeMillis();
    ad.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + ((dyy)localObject).HJh);
    AppMethodBeat.o(115256);
  }
  
  public final f eyd()
  {
    AppMethodBeat.i(115257);
    m.1 local1 = new m.1(this);
    AppMethodBeat.o(115257);
    return local1;
  }
  
  public final int eyf()
  {
    return ((dyy)this.rr.hNK.hNQ).FRq;
  }
  
  public final int getType()
  {
    return 174;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m
 * JD-Core Version:    0.7.0.1
 */