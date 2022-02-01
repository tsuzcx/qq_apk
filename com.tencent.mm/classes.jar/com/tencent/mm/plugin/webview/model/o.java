package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;

public final class o
  extends n
  implements k
{
  private g callback;
  public b rr;
  
  public o(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(78882);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new atv();
    ((b.a)localObject).hvu = new atw();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
    ((b.a)localObject).funcId = 1393;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (atv)this.rr.hvr.hvw;
    ((atv)localObject).EtG = paramString1;
    ((atv)localObject).Eeu = paramString2;
    ((atv)localObject).EMD = ((String)paramMap.get("groupId"));
    ((atv)localObject).BvP = ((String)paramMap.get("timestamp"));
    ((atv)localObject).ofc = ((String)paramMap.get("nonceStr"));
    ((atv)localObject).signature = ((String)paramMap.get("signature"));
    ((atv)localObject).EME = paramMap.get("params").toString();
    AppMethodBeat.o(78882);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78884);
    this.callback = paramg;
    ac.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78884);
    return i;
  }
  
  public final atw eBe()
  {
    if ((this.rr != null) && (this.rr.hvs.hvw != null)) {
      return (atw)this.rr.hvs.hvw;
    }
    return null;
  }
  
  public final int getType()
  {
    return 1393;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78883);
    ac.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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