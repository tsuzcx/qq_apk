package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private com.tencent.mm.ak.b gRX;
  public pz ynD;
  
  public f(String paramString1, String paramString2, String paramString3, int paramInt, com.tencent.mm.bw.b paramb, String paramString4)
  {
    AppMethodBeat.i(67840);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new py();
    ((b.a)localObject).hQG = new pz();
    ((b.a)localObject).funcId = 1680;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2factqry";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gRX = ((b.a)localObject).aDS();
    localObject = (py)this.gRX.hQD.hQJ;
    ((py)localObject).yoT = paramString3;
    ((py)localObject).FOf = paramString1;
    ((py)localObject).FOg = paramString2;
    ((py)localObject).FOj = paramInt;
    ((py)localObject).GdB = paramb;
    ((py)localObject).FOh = paramString4;
    ae.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(67840);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(67841);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(67841);
    return i;
  }
  
  public final int getType()
  {
    return 1680;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67842);
    ae.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.ynD = ((pz)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ynD.oGt), this.ynD.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.f
 * JD-Core Version:    0.7.0.1
 */