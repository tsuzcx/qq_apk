package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.vc;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;
import com.tencent.mm.wallet_core.ui.i;

public class a
  extends w
{
  private h callback;
  private c rr;
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69276);
    c.a locala = new c.a();
    vc localvc = new vc();
    localvc.YIV = paramString;
    localvc.Zbd = paramInt1;
    localvc.Zbe = paramInt2;
    locala.otE = localvc;
    locala.otF = new vd();
    locala.uri = getUri();
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    locala.routeInfo = i.bEV(paramString);
    this.rr = locala.bEF();
    Log.i("MicroMsg.NetSceneCancelPay", "request uri: %s, reqKey: %s, payScene: %d, payChannel:%d", new Object[] { getUri(), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(69276);
  }
  
  public int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(69277);
    this.callback = paramh;
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
      params = (vd)c.c.b(((c)params).otC);
      Log.i("MicroMsg.NetSceneCancelPay", "NetSceneCancelPay BaseResponse.Ret is %d, BaseResponse.ErrMsg is %s", new Object[] { Integer.valueOf(params.BaseResponse.Idd), params.BaseResponse.akjO });
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