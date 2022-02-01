package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.w;

public class a
  extends w
{
  private g callback;
  private b rr;
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69276);
    b.a locala = new b.a();
    qn localqn = new qn();
    localqn.DTt = paramString;
    localqn.EhO = paramInt1;
    localqn.EhP = paramInt2;
    locala.hvt = localqn;
    locala.hvu = new qo();
    locala.uri = getUri();
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.routeInfo = com.tencent.mm.wallet_core.ui.e.aSQ(paramString);
    this.rr = locala.aAz();
    ac.i("MicroMsg.NetSceneCancelPay", "request uri: %s, reqKey: %s, payScene: %d, payChannel:%d", new Object[] { getUri(), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(69276);
  }
  
  public int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(69277);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69277);
    return i;
  }
  
  public int getFuncId()
  {
    return 2823;
  }
  
  public int getType()
  {
    AppMethodBeat.i(69279);
    int i = getFuncId();
    AppMethodBeat.o(69279);
    return i;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/ts_cancelpay";
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69278);
    ac.d("MicroMsg.NetSceneCancelPay", "response uri: %s, errType: %d, errCode: %d, errMsg: %s", new Object[] { getUri(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    try
    {
      paramq = (qo)((b)paramq).hvs.hvw;
      ac.i("MicroMsg.NetSceneCancelPay", "NetSceneCancelPay BaseResponse.Ret is %d, BaseResponse.ErrMsg is %s", new Object[] { Integer.valueOf(paramq.BaseResponse.Ret), paramq.BaseResponse.ErrMsg });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(69278);
      return;
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        ac.i("MicroMsg.NetSceneCancelPay", paramq.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.b.a
 * JD-Core Version:    0.7.0.1
 */