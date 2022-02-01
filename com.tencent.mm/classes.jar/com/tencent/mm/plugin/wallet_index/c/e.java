package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bgp;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class e
  extends w
{
  public String IqL;
  public String IqM;
  private i callback;
  private d rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9)
  {
    AppMethodBeat.i(71813);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bgp();
    ((d.a)localObject).iLO = new bgq();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/genmallprepay";
    ((d.a)localObject).funcId = 2755;
    ((d.a)localObject).iLP = 189;
    ((d.a)localObject).respCmdId = 1000000189;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bgp)this.rr.iLK.iLR;
    ((bgp)localObject).jfi = paramString1;
    ((bgp)localObject).Lkq = paramString4;
    ((bgp)localObject).Lkp = paramString3;
    ((bgp)localObject).Lkr = paramString5;
    ((bgp)localObject).Lks = paramString2;
    ((bgp)localObject).KPJ = paramString6;
    ((bgp)localObject).Ljk = paramString7;
    ((bgp)localObject).LQu = paramString8;
    ((bgp)localObject).KCx = paramInt1;
    ((bgp)localObject).xNU = paramString9;
    if (paramInt2 > 0) {
      ((bgp)localObject).Scene = paramInt2;
    }
    Log.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    AppMethodBeat.o(71813);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(71815);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71815);
    return i;
  }
  
  public final int getType()
  {
    return 2755;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71814);
    Log.d("MicroMsg.NetSceneGenMallPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (bgq)((d)params).iLL.iLR;
    Log.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.rBL), paramString.rBM });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneGenMallPrepay", "rr " + paramString.LQv);
      this.IqL = paramString.LQv;
      this.IqM = paramString.LQw;
    }
    params = paramString.rBM;
    paramInt1 = paramString.rBL;
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(71814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.e
 * JD-Core Version:    0.7.0.1
 */