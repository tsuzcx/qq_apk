package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bnx;
import com.tencent.mm.protocal.protobuf.bny;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class e
  extends w
{
  public String Pju;
  public String Pjv;
  private i callback;
  private d rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9)
  {
    AppMethodBeat.i(71813);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bnx();
    ((d.a)localObject).lBV = new bny();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/genmallprepay";
    ((d.a)localObject).funcId = 2755;
    ((d.a)localObject).lBW = 189;
    ((d.a)localObject).respCmdId = 1000000189;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bnx)d.b.b(this.rr.lBR);
    ((bnx)localObject).lVG = paramString1;
    ((bnx)localObject).Slz = paramString4;
    ((bnx)localObject).Sly = paramString3;
    ((bnx)localObject).SlA = paramString5;
    ((bnx)localObject).SlB = paramString2;
    ((bnx)localObject).RQH = paramString6;
    ((bnx)localObject).SkB = paramString7;
    ((bnx)localObject).SYV = paramString8;
    ((bnx)localObject).RML = paramInt1;
    ((bnx)localObject).CSe = paramString9;
    if (paramInt2 > 0) {
      ((bnx)localObject).CPw = paramInt2;
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
    paramString = (bny)d.c.b(((d)params).lBS);
    Log.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.vht), paramString.vhu });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneGenMallPrepay", "rr " + paramString.SYW);
      this.Pju = paramString.SYW;
      this.Pjv = paramString.SYX;
    }
    params = paramString.vhu;
    paramInt1 = paramString.vht;
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(71814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.e
 * JD-Core Version:    0.7.0.1
 */