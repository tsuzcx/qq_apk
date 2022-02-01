package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cdl;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public class g
  extends w
  implements j
{
  private com.tencent.mm.ak.g callback;
  public b rr;
  
  public g(PayReq paramPayReq, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(71822);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cdl();
    ((b.a)localObject).hvu = new cdm();
    ((b.a)localObject).uri = getUri();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 188;
    ((b.a)localObject).respCmdId = 1000000188;
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.e.aSQ(paramPayReq.prepayId);
    this.rr = ((b.a)localObject).aAz();
    localObject = (cdl)this.rr.hvr.hvw;
    ((cdl)localObject).hOf = paramPayReq.appId;
    ((cdl)localObject).Fsh = paramPayReq.partnerId;
    ((cdl)localObject).EJP = paramPayReq.prepayId;
    ((cdl)localObject).EpT = paramPayReq.nonceStr;
    ((cdl)localObject).Fsi = paramPayReq.timeStamp;
    ((cdl)localObject).EpU = paramPayReq.packageValue;
    ((cdl)localObject).EpV = paramPayReq.sign;
    ((cdl)localObject).EpW = paramPayReq.signType;
    ((cdl)localObject).Fsj = paramString1;
    ((cdl)localObject).thr = paramString2;
    ((cdl)localObject).tkL = paramString3;
    ((cdl)localObject).EhT = k.ero();
    ((cdl)localObject).Fsl = paramString4;
    AppMethodBeat.o(71822);
  }
  
  public int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(71823);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
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
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71824);
    ac.d("MicroMsg.NetScenePayAuthApp", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(71824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.g
 * JD-Core Version:    0.7.0.1
 */