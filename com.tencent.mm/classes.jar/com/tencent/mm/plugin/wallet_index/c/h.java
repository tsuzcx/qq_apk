package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.czm;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.f;

public class h
  extends w
  implements j
{
  private i callback;
  public d rr;
  
  public h(PayReq paramPayReq, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(71822);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new czm();
    ((d.a)localObject).iLO = new czn();
    ((d.a)localObject).uri = getUri();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 188;
    ((d.a)localObject).respCmdId = 1000000188;
    ((d.a)localObject).routeInfo = f.bpA(paramPayReq.prepayId);
    this.rr = ((d.a)localObject).aXF();
    localObject = (czm)this.rr.iLK.iLR;
    ((czm)localObject).jfi = paramPayReq.appId;
    ((czm)localObject).MEM = paramPayReq.partnerId;
    ((czm)localObject).LQv = paramPayReq.prepayId;
    ((czm)localObject).Lkp = paramPayReq.nonceStr;
    ((czm)localObject).MEN = paramPayReq.timeStamp;
    ((czm)localObject).Lkq = paramPayReq.packageValue;
    ((czm)localObject).Lkr = paramPayReq.sign;
    ((czm)localObject).Lks = paramPayReq.signType;
    ((czm)localObject).MEO = paramString1;
    ((czm)localObject).xuk = paramString2;
    ((czm)localObject).xMq = paramString3;
    ((czm)localObject).Lcc = k.fQy();
    ((czm)localObject).MEQ = paramString4;
    AppMethodBeat.o(71822);
  }
  
  public int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(71823);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71823);
    return i;
  }
  
  public int getType()
  {
    return 397;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/payauthapp";
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71824);
    Log.d("MicroMsg.NetScenePayAuthApp", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(71824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.h
 * JD-Core Version:    0.7.0.1
 */