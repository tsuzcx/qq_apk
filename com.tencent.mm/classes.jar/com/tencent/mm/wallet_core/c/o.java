package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.wallet.c.a;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

public final class o
  extends m
  implements k
{
  private int AWY;
  private c.a AWZ;
  private f callback;
  private final b rr;
  
  public o(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, c.a parama)
  {
    AppMethodBeat.i(49069);
    ab.i("MicroMsg.NetSceneJSAPISecureTunnel", "new pay sercuretunnel netscene url :" + paramString1 + " appid: " + paramString2);
    this.AWZ = parama;
    parama = new b.a();
    parama.fsX = new byn();
    parama.fsY = new byo();
    parama.uri = "/cgi-bin/mmpay-bin/securetunnel";
    this.AWY = 2632;
    parama.funcId = this.AWY;
    if (paramMap.containsKey("timeout")) {
      parama.eBM = ((Integer)paramMap.get("timeout")).intValue();
    }
    this.rr = parama.ado();
    parama = (byn)this.rr.fsV.fta;
    parama.xKU = ((String)paramMap.get("reqbuf"));
    parama.wMy = ((String)paramMap.get("cmd"));
    parama.url = paramString1;
    parama.cwc = paramString2;
    parama.scene = paramInt;
    parama.cpt = 0;
    AppMethodBeat.o(49069);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(49071);
    this.callback = paramf;
    ab.d("MicroMsg.NetSceneJSAPISecureTunnel", "doScene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(49071);
    return i;
  }
  
  public final int getType()
  {
    return this.AWY;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(49070);
    ab.i("MicroMsg.NetSceneJSAPISecureTunnel", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (this.AWZ != null)
    {
      ab.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback");
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label121;
      }
      ab.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback fail");
      this.AWZ.CF(paramString);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(49070);
      return;
      label121:
      ab.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback success");
      this.AWZ.onSuccess(((byo)this.rr.fsW.fta).xKV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.o
 * JD-Core Version:    0.7.0.1
 */