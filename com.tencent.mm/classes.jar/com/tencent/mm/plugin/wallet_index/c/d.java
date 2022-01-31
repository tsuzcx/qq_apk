package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class d
  extends u
{
  private f callback;
  private b rr;
  public String uAd;
  public String uAe;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9)
  {
    AppMethodBeat.i(48178);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aey();
    ((b.a)localObject).fsY = new aez();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/genmallprepay";
    ((b.a)localObject).funcId = 2755;
    ((b.a)localObject).reqCmdId = 189;
    ((b.a)localObject).respCmdId = 1000000189;
    this.rr = ((b.a)localObject).ado();
    localObject = (aey)this.rr.fsV.fta;
    ((aey)localObject).fKw = paramString1;
    ((aey)localObject).wKW = paramString4;
    ((aey)localObject).wKV = paramString3;
    ((aey)localObject).wKX = paramString5;
    ((aey)localObject).wKY = paramString2;
    ((aey)localObject).wvC = paramString6;
    ((aey)localObject).wJT = paramString7;
    ((aey)localObject).wXP = paramString8;
    ((aey)localObject).wkX = paramInt1;
    ((aey)localObject).nuz = paramString9;
    if (paramInt2 > 0) {
      ((aey)localObject).Scene = paramInt2;
    }
    ab.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    AppMethodBeat.o(48178);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(48180);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48180);
    return i;
  }
  
  public final int getType()
  {
    return 2755;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142578);
    ab.d("MicroMsg.NetSceneGenMallPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (aez)((b)paramq).fsW.fta;
    ab.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.lGK), paramString.lGL });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.d("MicroMsg.NetSceneGenMallPrepay", "rr " + paramString.wXQ);
      this.uAd = paramString.wXQ;
      this.uAe = paramString.wXR;
    }
    paramq = paramString.lGL;
    paramInt1 = paramString.lGK;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(142578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.d
 * JD-Core Version:    0.7.0.1
 */