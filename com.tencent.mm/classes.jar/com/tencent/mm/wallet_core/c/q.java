package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.protocal.protobuf.edd;
import com.tencent.mm.protocal.protobuf.ede;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class q
  extends com.tencent.mm.an.q
  implements m
{
  private int YVv;
  private b.a YVw;
  private i callback;
  private final d rr;
  
  public q(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, b.a parama)
  {
    AppMethodBeat.i(72789);
    Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "new pay sercuretunnel netscene url :" + paramString1 + " appid: " + paramString2);
    this.YVw = parama;
    parama = new d.a();
    parama.lBU = new edd();
    parama.lBV = new ede();
    parama.uri = "/cgi-bin/mmpay-bin/securetunnel";
    this.YVv = 2632;
    parama.funcId = this.YVv;
    if (paramMap.containsKey("timeout")) {
      parama.timeout = ((Integer)paramMap.get("timeout")).intValue();
    }
    this.rr = parama.bgN();
    parama = (edd)d.b.b(this.rr.lBR);
    parama.UhF = ((String)paramMap.get("reqbuf"));
    parama.SnD = ((String)paramMap.get("cmd"));
    parama.url = paramString1;
    parama.appid = paramString2;
    parama.scene = paramInt;
    parama.source = 0;
    AppMethodBeat.o(72789);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(72791);
    this.callback = parami;
    Log.d("MicroMsg.NetSceneJSAPISecureTunnel", "doScene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(72791);
    return i;
  }
  
  public final int getType()
  {
    return this.YVv;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72790);
    Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (this.YVw != null)
    {
      Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback");
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label121;
      }
      Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback fail");
      this.YVw.aij(paramString);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(72790);
      return;
      label121:
      Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback success");
      this.YVw.onSuccess(((ede)d.c.b(this.rr.lBS)).UhG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.q
 * JD-Core Version:    0.7.0.1
 */