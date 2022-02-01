package com.tencent.mm.plugin.wallet_index.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.soter.model.b;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cck;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.geh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.j;
import com.tencent.mm.wallet_core.model.w;
import com.tencent.mm.wallet_core.ui.i;

public class f
  extends w
  implements j
{
  public String Wam;
  public String Wan;
  public geh Wao;
  public String Wap;
  private h callback;
  private com.tencent.mm.am.c rr;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, int paramInt3, String paramString9)
  {
    AppMethodBeat.i(71816);
    this.Wap = "";
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new cck();
    ((c.a)localObject1).otF = new ccl();
    ((c.a)localObject1).uri = getUri();
    ((c.a)localObject1).funcId = getType();
    ((c.a)localObject1).otG = 189;
    ((c.a)localObject1).respCmdId = 1000000189;
    ((c.a)localObject1).routeInfo = i.bEV(paramString4);
    this.rr = ((c.a)localObject1).bEF();
    this.Wap = paramString7;
    Object localObject2 = b.htz();
    localObject1 = ((com.tencent.mm.plugin.soter.model.c)localObject2).RZY;
    localObject2 = ((com.tencent.mm.plugin.soter.model.c)localObject2).mXG;
    cck localcck = (cck)c.b.b(this.rr.otB);
    localcck.oOI = paramString1;
    localcck.ZjJ = paramString4;
    localcck.ZjI = paramString3;
    localcck.ZjK = paramString5;
    localcck.ZjL = paramString2;
    localcck.YNW = paramString6;
    localcck.ZiL = paramString7;
    localcck.aalN = paramString8;
    localcck.YJZ = paramInt1;
    localcck.aalR = ((String)localObject1);
    localcck.aalQ = ((String)localObject2);
    localcck.Zbi = k.iis();
    if (paramInt2 > 0) {
      localcck.IJG = paramInt2;
    }
    localcck.aalS = paramInt3;
    localcck.aalT = paramString9;
    Log.d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString9 });
    AppMethodBeat.o(71816);
  }
  
  public int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(71818);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
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
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71817);
    Log.d("MicroMsg.NetSceneGenPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (ccl)c.c.b(((com.tencent.mm.am.c)params).otC);
    Log.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.ytv), paramString.ytw });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneGenPrepay", "rr " + paramString.aalO);
      this.Wam = paramString.aalO;
      this.Wan = paramString.aalP;
      this.Wao = paramString.aalU;
    }
    params = paramString.ytw;
    paramInt1 = paramString.ytv;
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(71817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.model.f
 * JD-Core Version:    0.7.0.1
 */