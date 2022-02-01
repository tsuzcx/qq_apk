package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public class f
  extends w
  implements j
{
  public String IqL;
  public String IqM;
  public exi IqN;
  public String IqO;
  private i callback;
  private com.tencent.mm.ak.d rr;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, int paramInt3, String paramString9)
  {
    AppMethodBeat.i(71816);
    this.IqO = "";
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new bgr();
    ((d.a)localObject1).iLO = new bgs();
    ((d.a)localObject1).uri = getUri();
    ((d.a)localObject1).funcId = getType();
    ((d.a)localObject1).iLP = 189;
    ((d.a)localObject1).respCmdId = 1000000189;
    ((d.a)localObject1).routeInfo = com.tencent.mm.wallet_core.ui.f.bpA(paramString4);
    this.rr = ((d.a)localObject1).aXF();
    this.IqO = paramString7;
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.flM();
    localObject1 = ((e)localObject2).FhU;
    localObject2 = ((e)localObject2).hFF;
    bgr localbgr = (bgr)this.rr.iLK.iLR;
    localbgr.jfi = paramString1;
    localbgr.Lkq = paramString4;
    localbgr.Lkp = paramString3;
    localbgr.Lkr = paramString5;
    localbgr.Lks = paramString2;
    localbgr.KPJ = paramString6;
    localbgr.Ljk = paramString7;
    localbgr.LQu = paramString8;
    localbgr.KCx = paramInt1;
    localbgr.LQy = ((String)localObject1);
    localbgr.LQx = ((String)localObject2);
    localbgr.Lcc = k.fQy();
    if (paramInt2 > 0) {
      localbgr.Scene = paramInt2;
    }
    localbgr.LQz = paramInt3;
    localbgr.LQA = paramString9;
    Log.d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString9 });
    AppMethodBeat.o(71816);
  }
  
  public int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(71818);
    this.callback = parami;
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
    paramString = (bgs)((com.tencent.mm.ak.d)params).iLL.iLR;
    Log.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.rBL), paramString.rBM });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneGenPrepay", "rr " + paramString.LQv);
      this.IqL = paramString.LQv;
      this.IqM = paramString.LQw;
      this.IqN = paramString.LQB;
    }
    params = paramString.rBM;
    paramInt1 = paramString.rBL;
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(71817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.f
 * JD-Core Version:    0.7.0.1
 */