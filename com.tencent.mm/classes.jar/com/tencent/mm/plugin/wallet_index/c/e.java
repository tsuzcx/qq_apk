package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aqv;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public class e
  extends w
  implements j
{
  public String BPA;
  public dvk BPB;
  public String BPC;
  public String BPz;
  private g callback;
  private b rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, int paramInt3, String paramString9)
  {
    AppMethodBeat.i(71816);
    this.BPC = "";
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new aqv();
    ((b.a)localObject1).hvu = new aqw();
    ((b.a)localObject1).uri = getUri();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).reqCmdId = 189;
    ((b.a)localObject1).respCmdId = 1000000189;
    ((b.a)localObject1).routeInfo = com.tencent.mm.wallet_core.ui.e.aSQ(paramString4);
    this.rr = ((b.a)localObject1).aAz();
    this.BPC = paramString7;
    Object localObject2 = d.dTq();
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject2).znE;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).znF;
    aqv localaqv = (aqv)this.rr.hvr.hvw;
    localaqv.hOf = paramString1;
    localaqv.EpU = paramString4;
    localaqv.EpT = paramString3;
    localaqv.EpV = paramString5;
    localaqv.EpW = paramString2;
    localaqv.DYh = paramString6;
    localaqv.EoO = paramString7;
    localaqv.EJO = paramString8;
    localaqv.DLC = paramInt1;
    localaqv.EJS = ((String)localObject1);
    localaqv.EJR = ((String)localObject2);
    localaqv.EhT = k.ero();
    if (paramInt2 > 0) {
      localaqv.Scene = paramInt2;
    }
    localaqv.EJT = paramInt3;
    localaqv.EJU = paramString9;
    ac.d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString9 });
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
    ac.d("MicroMsg.NetSceneGenPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (aqw)((b)paramq).hvs.hvw;
    ac.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.pAG), paramString.pAH });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.d("MicroMsg.NetSceneGenPrepay", "rr " + paramString.EJP);
      this.BPz = paramString.EJP;
      this.BPA = paramString.EJQ;
      this.BPB = paramString.EJV;
    }
    paramq = paramString.pAH;
    paramInt1 = paramString.pAG;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(71817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.e
 * JD-Core Version:    0.7.0.1
 */