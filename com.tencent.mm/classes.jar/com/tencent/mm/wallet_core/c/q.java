package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class q
  extends com.tencent.mm.ak.q
  implements m
{
  private int RtW;
  private b.a RtX;
  private i callback;
  private final d rr;
  
  public q(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, b.a parama)
  {
    AppMethodBeat.i(72789);
    Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "new pay sercuretunnel netscene url :" + paramString1 + " appid: " + paramString2);
    this.RtX = parama;
    parama = new d.a();
    parama.iLN = new dtf();
    parama.iLO = new dtg();
    parama.uri = "/cgi-bin/mmpay-bin/securetunnel";
    this.RtW = 2632;
    parama.funcId = this.RtW;
    if (paramMap.containsKey("timeout")) {
      parama.timeout = ((Integer)paramMap.get("timeout")).intValue();
    }
    this.rr = parama.aXF();
    parama = (dtf)this.rr.iLK.iLR;
    parama.MVs = ((String)paramMap.get("reqbuf"));
    parama.Lmp = ((String)paramMap.get("cmd"));
    parama.url = paramString1;
    parama.dNI = paramString2;
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
    return this.RtW;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72790);
    Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (this.RtX != null)
    {
      Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback");
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label121;
      }
      Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback fail");
      this.RtX.aas(paramString);
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
      this.RtX.onSuccess(((dtg)this.rr.iLL.iLR).MVt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.q
 * JD-Core Version:    0.7.0.1
 */