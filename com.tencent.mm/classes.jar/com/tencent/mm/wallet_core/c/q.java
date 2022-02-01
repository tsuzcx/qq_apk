package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.protocal.protobuf.cor;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;

public final class q
  extends n
  implements k
{
  private int IdL;
  private com.tencent.mm.pluginsdk.wallet.b.a IdM;
  private g callback;
  private final b rr;
  
  public q(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, com.tencent.mm.pluginsdk.wallet.b.a parama)
  {
    AppMethodBeat.i(72789);
    ad.i("MicroMsg.NetSceneJSAPISecureTunnel", "new pay sercuretunnel netscene url :" + paramString1 + " appid: " + paramString2);
    this.IdM = parama;
    parama = new com.tencent.mm.al.b.a();
    parama.gUU = new coq();
    parama.gUV = new cor();
    parama.uri = "/cgi-bin/mmpay-bin/securetunnel";
    this.IdL = 2632;
    parama.funcId = this.IdL;
    if (paramMap.containsKey("timeout")) {
      parama.timeout = ((Integer)paramMap.get("timeout")).intValue();
    }
    this.rr = parama.atI();
    parama = (coq)this.rr.gUS.gUX;
    parama.EiG = ((String)paramMap.get("reqbuf"));
    parama.CYV = ((String)paramMap.get("cmd"));
    parama.url = paramString1;
    parama.dlB = paramString2;
    parama.scene = paramInt;
    parama.dep = 0;
    AppMethodBeat.o(72789);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(72791);
    this.callback = paramg;
    ad.d("MicroMsg.NetSceneJSAPISecureTunnel", "doScene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72791);
    return i;
  }
  
  public final int getType()
  {
    return this.IdL;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72790);
    ad.i("MicroMsg.NetSceneJSAPISecureTunnel", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (this.IdM != null)
    {
      ad.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback");
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label121;
      }
      ad.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback fail");
      this.IdM.IK(paramString);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(72790);
      return;
      label121:
      ad.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback success");
      this.IdM.onSuccess(((cor)this.rr.gUT.gUX).EiH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.q
 * JD-Core Version:    0.7.0.1
 */