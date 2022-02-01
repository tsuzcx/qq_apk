package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends n
  implements k
{
  public String cIZ;
  private g callback;
  public String dda;
  private com.tencent.mm.ak.b hEg;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(30054);
    this.cIZ = paramString1;
    this.dda = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1091;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/register";
    ((b.a)localObject).hvt = new bjg();
    ((b.a)localObject).hvu = new bjh();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hEg = ((b.a)localObject).aAz();
    localObject = (bjg)this.hEg.hvr.hvw;
    ((bjg)localObject).DWI = new com.tencent.mm.bw.b(paramString1.getBytes());
    ((bjg)localObject).DWK = new com.tencent.mm.bw.b(paramString2.getBytes());
    ((bjg)localObject).EYs = new com.tencent.mm.bw.b("5".getBytes());
    AppMethodBeat.o(30054);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(30055);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.a
 * JD-Core Version:    0.7.0.1
 */