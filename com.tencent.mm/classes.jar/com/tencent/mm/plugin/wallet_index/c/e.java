package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.u;

public class e
  extends u
  implements i
{
  private f callback;
  private b rr;
  public String uAd;
  public String uAe;
  public cvm uAf;
  public String uAg;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, int paramInt3, String paramString9)
  {
    AppMethodBeat.i(48181);
    this.uAg = "";
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new afa();
    ((b.a)localObject1).fsY = new afb();
    ((b.a)localObject1).uri = getUri();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).reqCmdId = 189;
    ((b.a)localObject1).respCmdId = 1000000189;
    ((b.a)localObject1).routeInfo = com.tencent.mm.wallet_core.ui.e.awk(paramString4);
    this.rr = ((b.a)localObject1).ado();
    this.uAg = paramString7;
    Object localObject2 = d.cyc();
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject2).son;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).kbP;
    afa localafa = (afa)this.rr.fsV.fta;
    localafa.fKw = paramString1;
    localafa.wKW = paramString4;
    localafa.wKV = paramString3;
    localafa.wKX = paramString5;
    localafa.wKY = paramString2;
    localafa.wvC = paramString6;
    localafa.wJT = paramString7;
    localafa.wXP = paramString8;
    localafa.wkX = paramInt1;
    localafa.wXT = ((String)localObject1);
    localafa.wXS = ((String)localObject2);
    localafa.wDH = m.cTC();
    if (paramInt2 > 0) {
      localafa.Scene = paramInt2;
    }
    localafa.wXU = paramInt3;
    localafa.wXV = paramString9;
    ab.d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString9 });
    AppMethodBeat.o(48181);
  }
  
  public int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(48183);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48183);
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
    AppMethodBeat.i(142579);
    ab.d("MicroMsg.NetSceneGenPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (afb)((b)paramq).fsW.fta;
    ab.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.lGK), paramString.lGL });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.d("MicroMsg.NetSceneGenPrepay", "rr " + paramString.wXQ);
      this.uAd = paramString.wXQ;
      this.uAe = paramString.wXR;
      this.uAf = paramString.wXW;
    }
    paramq = paramString.lGL;
    paramInt1 = paramString.lGK;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(142579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.e
 * JD-Core Version:    0.7.0.1
 */