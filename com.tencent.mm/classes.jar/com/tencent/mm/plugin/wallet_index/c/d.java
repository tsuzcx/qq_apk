package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.w;

public final class d
  extends w
{
  public String DHx;
  public String DHy;
  private f callback;
  private b rr;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9)
  {
    AppMethodBeat.i(71813);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new avf();
    ((b.a)localObject).hQG = new avg();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/genmallprepay";
    ((b.a)localObject).funcId = 2755;
    ((b.a)localObject).hQH = 189;
    ((b.a)localObject).respCmdId = 1000000189;
    this.rr = ((b.a)localObject).aDS();
    localObject = (avf)this.rr.hQD.hQJ;
    ((avf)localObject).ikm = paramString1;
    ((avf)localObject).GpE = paramString4;
    ((avf)localObject).GpD = paramString3;
    ((avf)localObject).GpF = paramString5;
    ((avf)localObject).GpG = paramString2;
    ((avf)localObject).FVY = paramString6;
    ((avf)localObject).Goz = paramString7;
    ((avf)localObject).GMo = paramString8;
    ((avf)localObject).FJf = paramInt1;
    ((avf)localObject).uvT = paramString9;
    if (paramInt2 > 0) {
      ((avf)localObject).Scene = paramInt2;
    }
    ae.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
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
    ae.d("MicroMsg.NetSceneGenMallPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (avg)((b)paramq).hQE.hQJ;
    ae.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.qkQ), paramString.qkR });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.d("MicroMsg.NetSceneGenMallPrepay", "rr " + paramString.GMp);
      this.DHx = paramString.GMp;
      this.DHy = paramString.GMq;
    }
    paramq = paramString.qkR;
    paramInt1 = paramString.qkQ;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(71814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.d
 * JD-Core Version:    0.7.0.1
 */