package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;

public final class d
  extends w
{
  public String DpR;
  public String DpS;
  private f callback;
  private b rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9)
  {
    AppMethodBeat.i(71813);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new aup();
    ((b.a)localObject).hNN = new auq();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/genmallprepay";
    ((b.a)localObject).funcId = 2755;
    ((b.a)localObject).hNO = 189;
    ((b.a)localObject).respCmdId = 1000000189;
    this.rr = ((b.a)localObject).aDC();
    localObject = (aup)this.rr.hNK.hNQ;
    ((aup)localObject).iht = paramString1;
    ((aup)localObject).FXf = paramString4;
    ((aup)localObject).FXe = paramString3;
    ((aup)localObject).FXg = paramString5;
    ((aup)localObject).FXh = paramString2;
    ((aup)localObject).FDD = paramString6;
    ((aup)localObject).FWa = paramString7;
    ((aup)localObject).GsQ = paramString8;
    ((aup)localObject).FqH = paramInt1;
    ((aup)localObject).ukw = paramString9;
    if (paramInt2 > 0) {
      ((aup)localObject).Scene = paramInt2;
    }
    ad.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    AppMethodBeat.o(71813);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(71815);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71815);
    return i;
  }
  
  public final int getType()
  {
    return 2755;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71814);
    ad.d("MicroMsg.NetSceneGenMallPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (auq)((b)paramq).hNL.hNQ;
    ad.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.qel), paramString.qem });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.d("MicroMsg.NetSceneGenMallPrepay", "rr " + paramString.GsR);
      this.DpR = paramString.GsR;
      this.DpS = paramString.GsS;
    }
    paramq = paramString.qem;
    paramInt1 = paramString.qel;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(71814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.d
 * JD-Core Version:    0.7.0.1
 */