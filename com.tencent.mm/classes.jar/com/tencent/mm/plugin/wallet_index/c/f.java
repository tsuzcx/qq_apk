package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.protocal.protobuf.fhv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public class f
  extends w
  implements j
{
  public String Pju;
  public String Pjv;
  public fhv Pjw;
  public String Pjx;
  private i callback;
  private com.tencent.mm.an.d rr;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, int paramInt3, String paramString9)
  {
    AppMethodBeat.i(71816);
    this.Pjx = "";
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new bnz();
    ((d.a)localObject1).lBV = new boa();
    ((d.a)localObject1).uri = getUri();
    ((d.a)localObject1).funcId = getType();
    ((d.a)localObject1).lBW = 189;
    ((d.a)localObject1).respCmdId = 1000000189;
    ((d.a)localObject1).routeInfo = com.tencent.mm.wallet_core.ui.g.bCx(paramString4);
    this.rr = ((d.a)localObject1).bgN();
    this.Pjx = paramString7;
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.gai();
    localObject1 = ((e)localObject2).Lwz;
    localObject2 = ((e)localObject2).ktM;
    bnz localbnz = (bnz)d.b.b(this.rr.lBR);
    localbnz.lVG = paramString1;
    localbnz.Slz = paramString4;
    localbnz.Sly = paramString3;
    localbnz.SlA = paramString5;
    localbnz.SlB = paramString2;
    localbnz.RQH = paramString6;
    localbnz.SkB = paramString7;
    localbnz.SYV = paramString8;
    localbnz.RML = paramInt1;
    localbnz.SYZ = ((String)localObject1);
    localbnz.SYY = ((String)localObject2);
    localbnz.Sdp = k.gJe();
    if (paramInt2 > 0) {
      localbnz.CPw = paramInt2;
    }
    localbnz.SZa = paramInt3;
    localbnz.SZb = paramString9;
    Log.d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString9 });
    AppMethodBeat.o(71816);
  }
  
  public int doScene(com.tencent.mm.network.g paramg, i parami)
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
    paramString = (boa)d.c.b(((com.tencent.mm.an.d)params).lBS);
    Log.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.vht), paramString.vhu });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneGenPrepay", "rr " + paramString.SYW);
      this.Pju = paramString.SYW;
      this.Pjv = paramString.SYX;
      this.Pjw = paramString.SZc;
    }
    params = paramString.vhu;
    paramInt1 = paramString.vht;
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(71817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.f
 * JD-Core Version:    0.7.0.1
 */