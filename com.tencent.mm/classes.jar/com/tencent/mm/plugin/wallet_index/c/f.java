package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.bcw;
import com.tencent.mm.protocal.c.bcx;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.s;

public class f
  extends s
  implements g
{
  public b dmK;
  private com.tencent.mm.ah.f dmL;
  
  public f(PayReq paramPayReq, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bcw();
    ((b.a)localObject).ecI = new bcx();
    ((b.a)localObject).uri = getUri();
    ((b.a)localObject).ecG = getType();
    ((b.a)localObject).ecJ = 188;
    ((b.a)localObject).ecK = 1000000188;
    ((b.a)localObject).ecM = com.tencent.mm.wallet_core.ui.e.afr(paramPayReq.prepayId);
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bcw)this.dmK.ecE.ecN;
    ((bcw)localObject).euK = paramPayReq.appId;
    ((bcw)localObject).tyj = paramPayReq.partnerId;
    ((bcw)localObject).sZx = paramPayReq.prepayId;
    ((bcw)localObject).sNf = paramPayReq.nonceStr;
    ((bcw)localObject).tyk = paramPayReq.timeStamp;
    ((bcw)localObject).sNg = paramPayReq.packageValue;
    ((bcw)localObject).sNh = paramPayReq.sign;
    ((bcw)localObject).sNi = paramPayReq.signType;
    ((bcw)localObject).tyl = paramString1;
    ((bcw)localObject).kSb = paramString2;
    ((bcw)localObject).kVn = paramString3;
    ((bcw)localObject).sHl = i.bVj();
    ((bcw)localObject).tyn = paramString4;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetScenePayAuthApp", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public int getType()
  {
    return 397;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/payauthapp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.f
 * JD-Core Version:    0.7.0.1
 */