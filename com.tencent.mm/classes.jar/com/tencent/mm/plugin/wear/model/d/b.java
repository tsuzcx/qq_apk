package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.bj;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.edr;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.al.b hWL;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30057);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 976;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendyo";
    ((b.a)localObject).hNM = new edr();
    ((b.a)localObject).hNN = new eds();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hWL = ((b.a)localObject).aDC();
    localObject = (edr)this.hWL.hNK.hNQ;
    ((edr)localObject).uki = paramString;
    ((edr)localObject).GUe = ((edr)localObject).CreateTime;
    ((edr)localObject).CreateTime = ((int)bj.Bo(paramString));
    ((edr)localObject).nEf = 63;
    ((edr)localObject).HPd = 1;
    ((edr)localObject).nDi = 1;
    AppMethodBeat.o(30057);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(30059);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(30059);
    return i;
  }
  
  public final int getType()
  {
    return 976;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30058);
    ad.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.b
 * JD-Core Version:    0.7.0.1
 */