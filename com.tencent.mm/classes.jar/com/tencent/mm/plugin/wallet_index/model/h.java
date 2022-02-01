package com.tencent.mm.plugin.wallet_index.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.ebk;
import com.tencent.mm.protocal.protobuf.ebl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.j;
import com.tencent.mm.wallet_core.model.w;
import com.tencent.mm.wallet_core.ui.i;

public class h
  extends w
  implements j
{
  private com.tencent.mm.am.h callback;
  public c rr;
  
  public h(PayReq paramPayReq, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(71822);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ebk();
    ((c.a)localObject).otF = new ebl();
    ((c.a)localObject).uri = getUri();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 188;
    ((c.a)localObject).respCmdId = 1000000188;
    ((c.a)localObject).routeInfo = i.bEV(paramPayReq.prepayId);
    this.rr = ((c.a)localObject).bEF();
    localObject = (ebk)c.b.b(this.rr.otB);
    ((ebk)localObject).oOI = paramPayReq.appId;
    ((ebk)localObject).abgX = paramPayReq.partnerId;
    ((ebk)localObject).aalO = paramPayReq.prepayId;
    ((ebk)localObject).ZjI = paramPayReq.nonceStr;
    ((ebk)localObject).abgY = paramPayReq.timeStamp;
    ((ebk)localObject).ZjJ = paramPayReq.packageValue;
    ((ebk)localObject).ZjK = paramPayReq.sign;
    ((ebk)localObject).ZjL = paramPayReq.signType;
    ((ebk)localObject).abgZ = paramString1;
    ((ebk)localObject).IcK = paramString2;
    ((ebk)localObject).IKJ = paramString3;
    ((ebk)localObject).Zbi = k.iis();
    ((ebk)localObject).abhb = paramString4;
    AppMethodBeat.o(71822);
  }
  
  public int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(71823);
    this.callback = paramh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.model.h
 * JD-Core Version:    0.7.0.1
 */