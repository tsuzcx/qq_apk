package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.protocal.protobuf.ews;
import com.tencent.mm.protocal.protobuf.ewt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class q
  extends p
  implements m
{
  private int agTp;
  private b.a agTq;
  private h callback;
  private final c rr;
  
  public q(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, b.a parama)
  {
    AppMethodBeat.i(72789);
    Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "new pay sercuretunnel netscene url :" + paramString1 + " appid: " + paramString2);
    this.agTq = parama;
    parama = new c.a();
    parama.otE = new ews();
    parama.otF = new ewt();
    parama.uri = "/cgi-bin/mmpay-bin/securetunnel";
    this.agTp = 2632;
    parama.funcId = this.agTp;
    if (paramMap.containsKey("timeout")) {
      parama.timeout = ((Integer)paramMap.get("timeout")).intValue();
    }
    this.rr = parama.bEF();
    parama = (ews)c.b.b(this.rr.otB);
    parama.abyT = ((String)paramMap.get("reqbuf"));
    parama.ZlZ = ((String)paramMap.get("cmd"));
    parama.url = paramString1;
    parama.appid = paramString2;
    parama.scene = paramInt;
    parama.source = 0;
    AppMethodBeat.o(72789);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(72791);
    this.callback = paramh;
    Log.d("MicroMsg.NetSceneJSAPISecureTunnel", "doScene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(72791);
    return i;
  }
  
  public final int getType()
  {
    return this.agTp;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72790);
    Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (this.agTq != null)
    {
      Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback");
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label121;
      }
      Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback fail");
      this.agTq.abh(paramString);
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
      this.agTq.onSuccess(((ewt)c.c.b(this.rr.otC)).abyU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.q
 * JD-Core Version:    0.7.0.1
 */