package com.tencent.mm.plugin.wallet_index.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cci;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class e
  extends w
{
  public String Wam;
  public String Wan;
  private h callback;
  private c rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9)
  {
    AppMethodBeat.i(71813);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cci();
    ((c.a)localObject).otF = new ccj();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/genmallprepay";
    ((c.a)localObject).funcId = 2755;
    ((c.a)localObject).otG = 189;
    ((c.a)localObject).respCmdId = 1000000189;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cci)c.b.b(this.rr.otB);
    ((cci)localObject).oOI = paramString1;
    ((cci)localObject).ZjJ = paramString4;
    ((cci)localObject).ZjI = paramString3;
    ((cci)localObject).ZjK = paramString5;
    ((cci)localObject).ZjL = paramString2;
    ((cci)localObject).YNW = paramString6;
    ((cci)localObject).ZiL = paramString7;
    ((cci)localObject).aalN = paramString8;
    ((cci)localObject).YJZ = paramInt1;
    ((cci)localObject).IMu = paramString9;
    if (paramInt2 > 0) {
      ((cci)localObject).IJG = paramInt2;
    }
    Log.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    AppMethodBeat.o(71813);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(71815);
    this.callback = paramh;
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
    paramString = (ccj)c.c.b(((c)params).otC);
    Log.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.ytv), paramString.ytw });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneGenMallPrepay", "rr " + paramString.aalO);
      this.Wam = paramString.aalO;
      this.Wan = paramString.aalP;
    }
    params = paramString.ytw;
    paramInt1 = paramString.ytv;
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(71814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.model.e
 * JD-Core Version:    0.7.0.1
 */