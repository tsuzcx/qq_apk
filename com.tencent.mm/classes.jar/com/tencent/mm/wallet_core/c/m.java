package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.boq;
import com.tencent.mm.protocal.c.bor;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class m
  extends com.tencent.mm.ah.m
  implements k
{
  private final b dmK;
  private f dmL;
  private int wAu;
  private com.tencent.mm.pluginsdk.wallet.b.a wAv;
  
  public m(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, com.tencent.mm.pluginsdk.wallet.b.a parama)
  {
    y.i("MicroMsg.NetSceneJSAPISecureTunnel", "new pay sercuretunnel netscene url :" + paramString1 + " appid: " + paramString2);
    this.wAv = parama;
    parama = new com.tencent.mm.ah.b.a();
    parama.ecH = new boq();
    parama.ecI = new bor();
    parama.uri = "/cgi-bin/mmpay-bin/securetunnel";
    this.wAu = 2632;
    parama.ecG = this.wAu;
    if (paramMap.containsKey("timeout")) {
      parama.dEk = ((Integer)paramMap.get("timeout")).intValue();
    }
    this.dmK = parama.Kt();
    parama = (boq)this.dmK.ecE.ecN;
    parama.tGX = ((String)paramMap.get("reqbuf"));
    parama.sOz = ((String)paramMap.get("cmd"));
    parama.url = paramString1;
    parama.bOL = paramString2;
    parama.scene = paramInt;
    parama.source = 0;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.d("MicroMsg.NetSceneJSAPISecureTunnel", "doScene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneJSAPISecureTunnel", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (this.wAv != null)
    {
      y.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback");
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label111;
      }
      y.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback fail");
      this.wAv.uv(paramString);
    }
    for (;;)
    {
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
      label111:
      y.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback success");
      this.wAv.onSuccess(((bor)this.dmK.ecF.ecN).tGY);
    }
  }
  
  public final int getType()
  {
    return this.wAu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.m
 * JD-Core Version:    0.7.0.1
 */