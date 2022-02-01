package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  extends n
  implements k
{
  public cjg BON;
  private g callback;
  private b rr;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(71698);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cjf();
    ((b.a)localObject).hvu = new cjg();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qryecardbanklist4bind";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cjf)this.rr.hvr.hvw;
    ((cjf)localObject).DXS = paramString;
    ((cjf)localObject).dql = paramInt;
    ac.i("MicroMsg.NetSceneQryBankList4Bind", "cardType: %s, openScene: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(71698);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(71700);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneQryBankList4Bind", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.BON = ((cjg)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneQryBankList4Bind", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.BON.nWx), this.BON.nWy });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(71699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.f
 * JD-Core Version:    0.7.0.1
 */