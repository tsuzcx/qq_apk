package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;

public final class d
  extends w
{
  public String Axf;
  public String Axg;
  private g callback;
  private b rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9)
  {
    AppMethodBeat.i(71813);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new anp();
    ((b.a)localObject).gUV = new anq();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/genmallprepay";
    ((b.a)localObject).funcId = 2755;
    ((b.a)localObject).reqCmdId = 189;
    ((b.a)localObject).respCmdId = 1000000189;
    this.rr = ((b.a)localObject).atI();
    localObject = (anp)this.rr.gUS.gUX;
    ((anp)localObject).hnC = paramString1;
    ((anp)localObject).CXl = paramString4;
    ((anp)localObject).CXk = paramString3;
    ((anp)localObject).CXm = paramString5;
    ((anp)localObject).CXn = paramString2;
    ((anp)localObject).CFH = paramString6;
    ((anp)localObject).CWf = paramString7;
    ((anp)localObject).DoO = paramString8;
    ((anp)localObject).Ctl = paramInt1;
    ((anp)localObject).sed = paramString9;
    if (paramInt2 > 0) {
      ((anp)localObject).Scene = paramInt2;
    }
    ad.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    AppMethodBeat.o(71813);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(71815);
    this.callback = paramg;
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
    paramString = (anq)((b)paramq).gUT.gUX;
    ad.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.oXv), paramString.oXw });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.d("MicroMsg.NetSceneGenMallPrepay", "rr " + paramString.DoP);
      this.Axf = paramString.DoP;
      this.Axg = paramString.DoQ;
    }
    paramq = paramString.oXw;
    paramInt1 = paramString.oXv;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(71814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.d
 * JD-Core Version:    0.7.0.1
 */