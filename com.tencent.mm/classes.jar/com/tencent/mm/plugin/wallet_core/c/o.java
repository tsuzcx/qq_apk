package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahr;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.sdk.platformtools.ae;

public final class o
  extends n
  implements k
{
  private boolean Dgt;
  private ahr Dgy;
  public ahs Dgz;
  private f callback;
  private b gRX;
  
  public o(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69920);
    this.Dgt = paramBoolean;
    b.a locala = new b.a();
    locala.hQF = new ahr();
    locala.hQG = new ahs();
    if (paramBoolean) {
      locala.funcId = 2529;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktf2fmodifyexposure";; locala.uri = "/cgi-bin/mmpay-bin/mktmodifyexposure")
    {
      locala.hQH = 0;
      locala.respCmdId = 0;
      this.gRX = locala.aDS();
      this.Dgy = ((ahr)this.gRX.hQD.hQJ);
      this.Dgy.GxC = paramString;
      AppMethodBeat.o(69920);
      return;
      locala.funcId = 2888;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69921);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(69921);
    return i;
  }
  
  public final int getType()
  {
    if (this.Dgt) {
      return 2529;
    }
    return 2888;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69922);
    ae.i("MicroMsg.NetSceneMktModifyExposure", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Dgz = ((ahs)((b)paramq).hQE.hQJ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.o
 * JD-Core Version:    0.7.0.1
 */