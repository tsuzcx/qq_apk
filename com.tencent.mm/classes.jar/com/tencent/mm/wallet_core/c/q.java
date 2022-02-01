package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;

public final class q
  extends n
  implements k
{
  private int JFn;
  private com.tencent.mm.pluginsdk.wallet.b.a JFo;
  private g callback;
  private final b rr;
  
  public q(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, com.tencent.mm.pluginsdk.wallet.b.a parama)
  {
    AppMethodBeat.i(72789);
    ac.i("MicroMsg.NetSceneJSAPISecureTunnel", "new pay sercuretunnel netscene url :" + paramString1 + " appid: " + paramString2);
    this.JFo = parama;
    parama = new com.tencent.mm.ak.b.a();
    parama.hvt = new ctx();
    parama.hvu = new cty();
    parama.uri = "/cgi-bin/mmpay-bin/securetunnel";
    this.JFn = 2632;
    parama.funcId = this.JFn;
    if (paramMap.containsKey("timeout")) {
      parama.timeout = ((Integer)paramMap.get("timeout")).intValue();
    }
    this.rr = parama.aAz();
    parama = (ctx)this.rr.hvr.hvw;
    parama.FFE = ((String)paramMap.get("reqbuf"));
    parama.ErI = ((String)paramMap.get("cmd"));
    parama.url = paramString1;
    parama.djj = paramString2;
    parama.scene = paramInt;
    parama.dbL = 0;
    AppMethodBeat.o(72789);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(72791);
    this.callback = paramg;
    ac.d("MicroMsg.NetSceneJSAPISecureTunnel", "doScene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72791);
    return i;
  }
  
  public final int getType()
  {
    return this.JFn;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72790);
    ac.i("MicroMsg.NetSceneJSAPISecureTunnel", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (this.JFo != null)
    {
      ac.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback");
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label121;
      }
      ac.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback fail");
      this.JFo.ML(paramString);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(72790);
      return;
      label121:
      ac.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback success");
      this.JFo.onSuccess(((cty)this.rr.hvs.hvw).FFF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.q
 * JD-Core Version:    0.7.0.1
 */