package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends m
  implements k
{
  public String bYu;
  private f callback;
  public String cqJ;
  private com.tencent.mm.ai.b fBd;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26372);
    this.bYu = paramString1;
    this.cqJ = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1091;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/register";
    ((b.a)localObject).fsX = new aum();
    ((b.a)localObject).fsY = new aun();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fBd = ((b.a)localObject).ado();
    localObject = (aum)this.fBd.fsV.fta;
    ((aum)localObject).wuq = new com.tencent.mm.bv.b(paramString1.getBytes());
    ((aum)localObject).wus = new com.tencent.mm.bv.b(paramString2.getBytes());
    ((aum)localObject).xjB = new com.tencent.mm.bv.b("5".getBytes());
    AppMethodBeat.o(26372);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26373);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(26373);
    return i;
  }
  
  public final int getType()
  {
    return 1091;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26374);
    ab.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.a
 * JD-Core Version:    0.7.0.1
 */