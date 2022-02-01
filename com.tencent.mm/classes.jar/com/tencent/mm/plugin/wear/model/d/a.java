package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bog;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  public String cVh;
  private f callback;
  public String dpB;
  private com.tencent.mm.ak.b hZD;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(30054);
    this.cVh = paramString1;
    this.dpB = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1091;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/register";
    ((b.a)localObject).hQF = new bog();
    ((b.a)localObject).hQG = new boh();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hZD = ((b.a)localObject).aDS();
    localObject = (bog)this.hZD.hQD.hQJ;
    ((bog)localObject).FUz = new com.tencent.mm.bw.b(paramString1.getBytes());
    ((bog)localObject).FUB = new com.tencent.mm.bw.b(paramString2.getBytes());
    ((bog)localObject).Hbq = new com.tencent.mm.bw.b("5".getBytes());
    AppMethodBeat.o(30054);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(30055);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(30055);
    return i;
  }
  
  public final int getType()
  {
    return 1091;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30056);
    ae.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.a
 * JD-Core Version:    0.7.0.1
 */