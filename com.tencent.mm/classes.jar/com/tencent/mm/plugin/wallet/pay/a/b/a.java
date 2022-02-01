package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.f;

public class a
  extends w
{
  private i callback;
  private d rr;
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69276);
    d.a locala = new d.a();
    tj localtj = new tj();
    localtj.KKR = paramString;
    localtj.LbX = paramInt1;
    localtj.LbY = paramInt2;
    locala.iLN = localtj;
    locala.iLO = new tk();
    locala.uri = getUri();
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    locala.routeInfo = f.bpA(paramString);
    this.rr = locala.aXF();
    Log.i("MicroMsg.NetSceneCancelPay", "request uri: %s, reqKey: %s, payScene: %d, payChannel:%d", new Object[] { getUri(), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(69276);
  }
  
  public int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69277);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
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
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69278);
    Log.d("MicroMsg.NetSceneCancelPay", "response uri: %s, errType: %d, errCode: %d, errMsg: %s", new Object[] { getUri(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    try
    {
      params = (tk)((d)params).iLL.iLR;
      Log.i("MicroMsg.NetSceneCancelPay", "NetSceneCancelPay BaseResponse.Ret is %d, BaseResponse.ErrMsg is %s", new Object[] { Integer.valueOf(params.BaseResponse.Ret), params.BaseResponse.ErrMsg });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(69278);
      return;
    }
    catch (Exception params)
    {
      for (;;)
      {
        Log.i("MicroMsg.NetSceneCancelPay", params.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.b.a
 * JD-Core Version:    0.7.0.1
 */