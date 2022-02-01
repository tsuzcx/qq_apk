package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public class e
  extends w
  implements j
{
  public String DpR;
  public String DpS;
  public ebj DpT;
  public String DpU;
  private f callback;
  private b rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, int paramInt3, String paramString9)
  {
    AppMethodBeat.i(71816);
    this.DpU = "";
    Object localObject1 = new b.a();
    ((b.a)localObject1).hNM = new aur();
    ((b.a)localObject1).hNN = new aus();
    ((b.a)localObject1).uri = getUri();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).hNO = 189;
    ((b.a)localObject1).respCmdId = 1000000189;
    ((b.a)localObject1).routeInfo = com.tencent.mm.wallet_core.ui.e.aYP(paramString4);
    this.rr = ((b.a)localObject1).aDC();
    this.DpU = paramString7;
    Object localObject2 = d.efE();
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject2).AFy;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).AFz;
    aur localaur = (aur)this.rr.hNK.hNQ;
    localaur.iht = paramString1;
    localaur.FXf = paramString4;
    localaur.FXe = paramString3;
    localaur.FXg = paramString5;
    localaur.FXh = paramString2;
    localaur.FDD = paramString6;
    localaur.FWa = paramString7;
    localaur.GsQ = paramString8;
    localaur.FqH = paramInt1;
    localaur.GsU = ((String)localObject1);
    localaur.GsT = ((String)localObject2);
    localaur.FPa = k.eFo();
    if (paramInt2 > 0) {
      localaur.Scene = paramInt2;
    }
    localaur.GsV = paramInt3;
    localaur.GsW = paramString9;
    ad.d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString9 });
    AppMethodBeat.o(71816);
  }
  
  public int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(71818);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71818);
    return i;
  }
  
  public int getType()
  {
    return 398;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/genprepay";
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71817);
    ad.d("MicroMsg.NetSceneGenPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (aus)((b)paramq).hNL.hNQ;
    ad.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.qel), paramString.qem });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.d("MicroMsg.NetSceneGenPrepay", "rr " + paramString.GsR);
      this.DpR = paramString.GsR;
      this.DpS = paramString.GsS;
      this.DpT = paramString.GsX;
    }
    paramq = paramString.qem;
    paramInt1 = paramString.qel;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(71817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.e
 * JD-Core Version:    0.7.0.1
 */