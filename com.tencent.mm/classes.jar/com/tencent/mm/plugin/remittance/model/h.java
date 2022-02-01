package com.tencent.mm.plugin.remittance.model;

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
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.qe;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
  extends n
  implements k
{
  private f callback;
  private b gRX;
  public qf ynK;
  
  public h(dk paramdk, String paramString)
  {
    AppMethodBeat.i(67846);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new qe();
    ((b.a)localObject).hQG = new qf();
    ((b.a)localObject).funcId = 1241;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gRX = ((b.a)localObject).aDS();
    localObject = (qe)this.gRX.hQD.hQJ;
    ((qe)localObject).GdN = paramdk;
    ((qe)localObject).GdO = paramString;
    ae.i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", new Object[] { paramdk.FOf, paramdk.FOg, Integer.valueOf(paramdk.FOj), a.a(paramdk) });
    AppMethodBeat.o(67846);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67847);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(67847);
    return i;
  }
  
  public final int getType()
  {
    return 1241;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67848);
    ae.i("MicroMsg.NetSceneBusiF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.ynK = ((qf)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ynK.oGt), this.ynK.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.h
 * JD-Core Version:    0.7.0.1
 */