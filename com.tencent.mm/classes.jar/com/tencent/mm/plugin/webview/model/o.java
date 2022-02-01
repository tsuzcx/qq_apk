package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class o
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public o(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(78882);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bjt();
    ((d.a)localObject).iLO = new bju();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
    ((d.a)localObject).funcId = 1393;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bjt)this.rr.iLK.iLR;
    ((bjt)localObject).Lpg = paramString1;
    ((bjt)localObject).KXJ = paramString2;
    ((bjt)localObject).LTm = ((String)paramMap.get("groupId"));
    ((bjt)localObject).HXc = ((String)paramMap.get("timestamp"));
    ((bjt)localObject).qcM = ((String)paramMap.get("nonceStr"));
    ((bjt)localObject).signature = ((String)paramMap.get("signature"));
    ((bjt)localObject).LTn = paramMap.get("params").toString();
    AppMethodBeat.o(78882);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78884);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78884);
    return i;
  }
  
  public final bju gcv()
  {
    if ((this.rr != null) && (this.rr.iLL.iLR != null)) {
      return (bju)this.rr.iLL.iLR;
    }
    return null;
  }
  
  public final int getType()
  {
    return 1393;
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