package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

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
    ((d.a)localObject).lBU = new dja();
    ((d.a)localObject).lBV = new djb();
    ((d.a)localObject).uri = getUri();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 188;
    ((d.a)localObject).respCmdId = 1000000188;
    ((d.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.g.bCx(paramPayReq.prepayId);
    this.rr = ((d.a)localObject).bgN();
    localObject = (dja)d.b.b(this.rr.lBR);
    ((dja)localObject).lVG = paramPayReq.appId;
    ((dja)localObject).TQy = paramPayReq.partnerId;
    ((dja)localObject).SYW = paramPayReq.prepayId;
    ((dja)localObject).Sly = paramPayReq.nonceStr;
    ((dja)localObject).TQz = paramPayReq.timeStamp;
    ((dja)localObject).Slz = paramPayReq.packageValue;
    ((dja)localObject).SlA = paramPayReq.sign;
    ((dja)localObject).SlB = paramPayReq.signType;
    ((dja)localObject).TQA = paramString1;
    ((dja)localObject).CqB = paramString2;
    ((dja)localObject).CQz = paramString3;
    ((dja)localObject).Sdp = k.gJe();
    ((dja)localObject).TQC = paramString4;
    AppMethodBeat.o(71822);
  }
  
  public int doScene(com.tencent.mm.network.g paramg, i parami)
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