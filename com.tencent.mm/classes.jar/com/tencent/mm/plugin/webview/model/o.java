package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.axu;
import com.tencent.mm.sdk.platformtools.ad;
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
    ((b.a)localObject).hNM = new axt();
    ((b.a)localObject).hNN = new axu();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
    ((b.a)localObject).funcId = 1393;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (axt)this.rr.hNK.hNQ;
    ((axt)localObject).GaY = paramString1;
    ((axt)localObject).FKT = paramString2;
    ((axt)localObject).GvH = ((String)paramMap.get("groupId"));
    ((axt)localObject).CWf = ((String)paramMap.get("timestamp"));
    ((axt)localObject).oIw = ((String)paramMap.get("nonceStr"));
    ((axt)localObject).signature = ((String)paramMap.get("signature"));
    ((axt)localObject).GvI = paramMap.get("params").toString();
    AppMethodBeat.o(78882);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78884);
    this.callback = paramf;
    ad.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78884);
    return i;
  }
  
  public final axu ePW()
  {
    if ((this.rr != null) && (this.rr.hNL.hNQ != null)) {
      return (axu)this.rr.hNL.hNQ;
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
    ad.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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