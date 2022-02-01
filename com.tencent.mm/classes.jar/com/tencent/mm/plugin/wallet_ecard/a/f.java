package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.coz;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  extends n
  implements k
{
  public cpa DGL;
  private com.tencent.mm.ak.f callback;
  private b rr;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(71698);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new coz();
    ((b.a)localObject).hQG = new cpa();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qryecardbanklist4bind";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (coz)this.rr.hQD.hQJ;
    ((coz)localObject).FVJ = paramString;
    ((coz)localObject).dDd = paramInt;
    ae.i("MicroMsg.NetSceneQryBankList4Bind", "cardType: %s, openScene: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(71698);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(71700);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71700);
    return i;
  }
  
  public final int getType()
  {
    return 1988;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71699);
    ae.i("MicroMsg.NetSceneQryBankList4Bind", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.DGL = ((cpa)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneQryBankList4Bind", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.DGL.oGt), this.DGL.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(71699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.f
 * JD-Core Version:    0.7.0.1
 */