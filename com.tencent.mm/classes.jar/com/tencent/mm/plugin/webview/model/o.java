package com.tencent.mm.plugin.webview.model;

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
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.protocal.protobuf.cfu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class o
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public o(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(78882);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cft();
    ((c.a)localObject).otF = new cfu();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
    ((c.a)localObject).funcId = 1393;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cft)c.b.b(this.rr.otB);
    ((cft)localObject).ZpC = paramString1;
    ((cft)localObject).YWS = paramString2;
    ((cft)localObject).TpV = ((String)paramMap.get("groupId"));
    ((cft)localObject).VEW = ((String)paramMap.get("timestamp"));
    ((cft)localObject).wDg = ((String)paramMap.get("nonceStr"));
    ((cft)localObject).signature = ((String)paramMap.get("signature"));
    ((cft)localObject).aapj = paramMap.get("params").toString();
    AppMethodBeat.o(78882);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78884);
    this.callback = paramh;
    Log.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78884);
    return i;
  }
  
  public final int getType()
  {
    return 1393;
  }
  
  public final cfu ivb()
  {
    AppMethodBeat.i(298402);
    if ((this.rr != null) && (c.c.b(this.rr.otC) != null))
    {
      cfu localcfu = (cfu)c.c.b(this.rr.otC);
      AppMethodBeat.o(298402);
      return localcfu;
    }
    AppMethodBeat.o(298402);
    return null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78883);
    Log.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.o
 * JD-Core Version:    0.7.0.1
 */