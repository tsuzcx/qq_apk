package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.dpt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public class e
  extends w
  implements j
{
  public String Axf;
  public String Axg;
  public dpt Axh;
  public String Axi;
  private g callback;
  private b rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, int paramInt3, String paramString9)
  {
    AppMethodBeat.i(71816);
    this.Axi = "";
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new anr();
    ((b.a)localObject1).gUV = new ans();
    ((b.a)localObject1).uri = getUri();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).reqCmdId = 189;
    ((b.a)localObject1).respCmdId = 1000000189;
    ((b.a)localObject1).routeInfo = com.tencent.mm.wallet_core.ui.e.aNn(paramString4);
    this.rr = ((b.a)localObject1).atI();
    this.Axi = paramString7;
    Object localObject2 = d.dEQ();
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject2).yaF;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).yaG;
    anr localanr = (anr)this.rr.gUS.gUX;
    localanr.hnC = paramString1;
    localanr.CXl = paramString4;
    localanr.CXk = paramString3;
    localanr.CXm = paramString5;
    localanr.CXn = paramString2;
    localanr.CFH = paramString6;
    localanr.CWf = paramString7;
    localanr.DoO = paramString8;
    localanr.Ctl = paramInt1;
    localanr.DoS = ((String)localObject1);
    localanr.DoR = ((String)localObject2);
    localanr.CPi = k.ebS();
    if (paramInt2 > 0) {
      localanr.Scene = paramInt2;
    }
    localanr.DoT = paramInt3;
    localanr.DoU = paramString9;
    ad.d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString9 });
    AppMethodBeat.o(71816);
  }
  
  public int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(71818);
    this.callback = paramg;
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
    paramString = (ans)((b)paramq).gUT.gUX;
    ad.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.oXv), paramString.oXw });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.d("MicroMsg.NetSceneGenPrepay", "rr " + paramString.DoP);
      this.Axf = paramString.DoP;
      this.Axg = paramString.DoQ;
      this.Axh = paramString.DoV;
    }
    paramq = paramString.oXw;
    paramInt1 = paramString.oXv;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(71817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.e
 * JD-Core Version:    0.7.0.1
 */