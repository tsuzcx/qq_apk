package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.eda;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public class e
  extends w
  implements j
{
  public String DHA;
  public String DHx;
  public String DHy;
  public eda DHz;
  private com.tencent.mm.ak.f callback;
  private b rr;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, int paramInt3, String paramString9)
  {
    AppMethodBeat.i(71816);
    this.DHA = "";
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new avh();
    ((b.a)localObject1).hQG = new avi();
    ((b.a)localObject1).uri = getUri();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).hQH = 189;
    ((b.a)localObject1).respCmdId = 1000000189;
    ((b.a)localObject1).routeInfo = com.tencent.mm.wallet_core.ui.f.bas(paramString4);
    this.rr = ((b.a)localObject1).aDS();
    this.DHA = paramString7;
    Object localObject2 = d.ejm();
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject2).AXb;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).AXc;
    avh localavh = (avh)this.rr.hQD.hQJ;
    localavh.ikm = paramString1;
    localavh.GpE = paramString4;
    localavh.GpD = paramString3;
    localavh.GpF = paramString5;
    localavh.GpG = paramString2;
    localavh.FVY = paramString6;
    localavh.Goz = paramString7;
    localavh.GMo = paramString8;
    localavh.FJf = paramInt1;
    localavh.GMs = ((String)localObject1);
    localavh.GMr = ((String)localObject2);
    localavh.Ghz = k.eIV();
    if (paramInt2 > 0) {
      localavh.Scene = paramInt2;
    }
    localavh.GMt = paramInt3;
    localavh.GMu = paramString9;
    ae.d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString9 });
    AppMethodBeat.o(71816);
  }
  
  public int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(71818);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneGenPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (avi)((b)paramq).hQE.hQJ;
    ae.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.qkQ), paramString.qkR });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.d("MicroMsg.NetSceneGenPrepay", "rr " + paramString.GMp);
      this.DHx = paramString.GMp;
      this.DHy = paramString.GMq;
      this.DHz = paramString.GMv;
    }
    paramq = paramString.qkR;
    paramInt1 = paramString.qkQ;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(71817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.e
 * JD-Core Version:    0.7.0.1
 */