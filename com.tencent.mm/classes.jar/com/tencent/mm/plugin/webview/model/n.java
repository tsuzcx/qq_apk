package com.tencent.mm.plugin.webview.model;

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
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

public final class n
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public n(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(6601);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ahk();
    ((b.a)localObject).fsY = new ahl();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
    ((b.a)localObject).funcId = 1393;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ahk)this.rr.fsV.fta;
    ((ahk)localObject).wOf = paramString1;
    ((ahk)localObject).wAE = paramString2;
    ((ahk)localObject).wZM = ((String)paramMap.get("groupId"));
    ((ahk)localObject).uho = ((String)paramMap.get("timestamp"));
    ((ahk)localObject).kwJ = ((String)paramMap.get("nonceStr"));
    ((ahk)localObject).signature = ((String)paramMap.get("signature"));
    ((ahk)localObject).wZN = paramMap.get("params").toString();
    AppMethodBeat.o(6601);
  }
  
  public final ahl dbK()
  {
    if ((this.rr != null) && (this.rr.fsW.fta != null)) {
      return (ahl)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6603);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6603);
    return i;
  }
  
  public final int getType()
  {
    return 1393;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6602);
    ab.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(6602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.n
 * JD-Core Version:    0.7.0.1
 */