package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private b rr;
  public bpk uzq;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(48065);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bpj();
    ((b.a)localObject).fsY = new bpk();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qryecardbanklist4bind";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bpj)this.rr.fsV.fta;
    ((bpj)localObject).wvn = paramString;
    ((bpj)localObject).cCc = paramInt;
    ab.i("MicroMsg.NetSceneQryBankList4Bind", "cardType: %s, openScene: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(48065);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(48067);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48067);
    return i;
  }
  
  public final int getType()
  {
    return 1988;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(48066);
    ab.i("MicroMsg.NetSceneQryBankList4Bind", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.uzq = ((bpk)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneQryBankList4Bind", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.uzq.koj), this.uzq.kok });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(48066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.f
 * JD-Core Version:    0.7.0.1
 */