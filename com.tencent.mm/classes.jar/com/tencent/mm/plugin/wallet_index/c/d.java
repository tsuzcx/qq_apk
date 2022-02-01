package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.w;

public final class d
  extends w
{
  public String BPA;
  public String BPz;
  private g callback;
  private b rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9)
  {
    AppMethodBeat.i(71813);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new aqt();
    ((b.a)localObject).hvu = new aqu();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/genmallprepay";
    ((b.a)localObject).funcId = 2755;
    ((b.a)localObject).reqCmdId = 189;
    ((b.a)localObject).respCmdId = 1000000189;
    this.rr = ((b.a)localObject).aAz();
    localObject = (aqt)this.rr.hvr.hvw;
    ((aqt)localObject).hOf = paramString1;
    ((aqt)localObject).EpU = paramString4;
    ((aqt)localObject).EpT = paramString3;
    ((aqt)localObject).EpV = paramString5;
    ((aqt)localObject).EpW = paramString2;
    ((aqt)localObject).DYh = paramString6;
    ((aqt)localObject).EoO = paramString7;
    ((aqt)localObject).EJO = paramString8;
    ((aqt)localObject).DLC = paramInt1;
    ((aqt)localObject).tlX = paramString9;
    if (paramInt2 > 0) {
      ((aqt)localObject).Scene = paramInt2;
    }
    ac.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
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
    ac.d("MicroMsg.NetSceneGenMallPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (aqu)((b)paramq).hvs.hvw;
    ac.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.pAG), paramString.pAH });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.d("MicroMsg.NetSceneGenMallPrepay", "rr " + paramString.EJP);
      this.BPz = paramString.EJP;
      this.BPA = paramString.EJQ;
    }
    paramq = paramString.pAH;
    paramInt1 = paramString.pAG;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(71814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.d
 * JD-Core Version:    0.7.0.1
 */