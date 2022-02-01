package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.protocal.protobuf.eap;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
  extends n<eap, eaq>
{
  public m(int paramInt1, dzg paramdzg, byte[] paramArrayOfByte, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115256);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new eap();
    ((b.a)localObject).hQG = new eaq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipsync";
    ((b.a)localObject).funcId = 174;
    ((b.a)localObject).hQH = 62;
    ((b.a)localObject).respCmdId = 1000000062;
    this.rr = ((b.a)localObject).aDS();
    localObject = (eap)this.rr.hQD.hQJ;
    ((eap)localObject).Gxq = paramInt1;
    ((eap)localObject).Igz = paramdzg;
    ((eap)localObject).Gxr = paramLong;
    ((eap)localObject).HzT = v.aAC();
    ((eap)localObject).GjP = paramInt2;
    ((eap)localObject).GjQ = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((eap)localObject).Idp = System.currentTimeMillis();
    ae.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + ((eap)localObject).Idp);
    AppMethodBeat.o(115256);
  }
  
  public final f eBL()
  {
    AppMethodBeat.i(115257);
    m.1 local1 = new m.1(this);
    AppMethodBeat.o(115257);
    return local1;
  }
  
  public final int eBN()
  {
    return ((eap)this.rr.hQD.hQJ).GjP;
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