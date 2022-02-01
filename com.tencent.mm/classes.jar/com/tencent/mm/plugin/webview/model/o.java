package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

public final class o
  extends n
  implements k
{
  private f callback;
  public b rr;
  
  public o(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(78882);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ayj();
    ((b.a)localObject).hQG = new ayk();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
    ((b.a)localObject).funcId = 1393;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ayj)this.rr.hQD.hQJ;
    ((ayj)localObject).GtF = paramString1;
    ((ayj)localObject).Gds = paramString2;
    ((ayj)localObject).GPg = ((String)paramMap.get("groupId"));
    ((ayj)localObject).DnK = ((String)paramMap.get("timestamp"));
    ((ayj)localObject).oOY = ((String)paramMap.get("nonceStr"));
    ((ayj)localObject).signature = ((String)paramMap.get("signature"));
    ((ayj)localObject).GPh = paramMap.get("params").toString();
    AppMethodBeat.o(78882);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78884);
    this.callback = paramf;
    ae.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78884);
    return i;
  }
  
  public final ayk eTI()
  {
    if ((this.rr != null) && (this.rr.hQE.hQJ != null)) {
      return (ayk)this.rr.hQE.hQJ;
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
    ae.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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