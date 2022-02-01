package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.protocal.protobuf.dac;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

public final class q
  extends n
  implements k
{
  private int LVg;
  private com.tencent.mm.pluginsdk.wallet.b.a LVh;
  private f callback;
  private final b rr;
  
  public q(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, com.tencent.mm.pluginsdk.wallet.b.a parama)
  {
    AppMethodBeat.i(72789);
    ae.i("MicroMsg.NetSceneJSAPISecureTunnel", "new pay sercuretunnel netscene url :" + paramString1 + " appid: " + paramString2);
    this.LVh = parama;
    parama = new com.tencent.mm.ak.b.a();
    parama.hQF = new dab();
    parama.hQG = new dac();
    parama.uri = "/cgi-bin/mmpay-bin/securetunnel";
    this.LVg = 2632;
    parama.funcId = this.LVg;
    if (paramMap.containsKey("timeout")) {
      parama.timeout = ((Integer)paramMap.get("timeout")).intValue();
    }
    this.rr = parama.aDS();
    parama = (dab)this.rr.hQD.hQJ;
    parama.HJF = ((String)paramMap.get("reqbuf"));
    parama.Grr = ((String)paramMap.get("cmd"));
    parama.url = paramString1;
    parama.dwb = paramString2;
    parama.scene = paramInt;
    parama.doj = 0;
    AppMethodBeat.o(72789);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(72791);
    this.callback = paramf;
    ae.d("MicroMsg.NetSceneJSAPISecureTunnel", "doScene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72791);
    return i;
  }
  
  public final int getType()
  {
    return this.LVg;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72790);
    ae.i("MicroMsg.NetSceneJSAPISecureTunnel", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (this.LVh != null)
    {
      ae.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback");
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label121;
      }
      ae.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback fail");
      this.LVh.QR(paramString);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(72790);
      return;
      label121:
      ae.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback success");
      this.LVh.onSuccess(((dac)this.rr.hQE.hQJ).HJG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.q
 * JD-Core Version:    0.7.0.1
 */