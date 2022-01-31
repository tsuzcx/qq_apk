package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.d.d;

public final class l
  extends m
  implements k, i, d
{
  private f callback;
  public String cnI;
  private b goo;
  public boolean hasRetried;
  public boolean mhe;
  public mw qjn;
  private mv qjo;
  
  public l(ckm paramckm, cz paramcz, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(44747);
    this.mhe = false;
    this.hasRetried = false;
    b.a locala = new b.a();
    locala.fsX = new mv();
    locala.fsY = new mw();
    locala.funcId = 2682;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.qjo = ((mv)this.goo.fsV.fta);
    this.qjo.wAZ = paramcz;
    this.qjo.wBt = paramckm;
    this.qjo.wBu = paramString1;
    this.qjo.wBO = paramInt;
    this.qjo.token = paramString2;
    this.cnI = paramString3;
    ab.i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", new Object[] { paramString2, a.a(paramcz), paramString1 });
    AppMethodBeat.o(44747);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44748);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(44748);
    return i;
  }
  
  public final boolean getHasRetried()
  {
    return this.hasRetried;
  }
  
  public final int getType()
  {
    return 2682;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(44749);
    ab.i("MicroMsg.NetSceneBusiF2fZeroCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qjn = ((mw)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.qjn.koj), this.qjn.kok });
    if (this.callback != null) {
      if (this.qjn.wBP != 1) {
        break label134;
      }
    }
    label134:
    for (boolean bool = true;; bool = false)
    {
      this.mhe = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(44749);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.l
 * JD-Core Version:    0.7.0.1
 */