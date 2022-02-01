package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.protocal.protobuf.ckv;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends q
  implements m
{
  String appId;
  private i heq;
  String laS;
  final d rr;
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78873);
    this.appId = paramString1;
    this.laS = paramString2;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cku();
    ((d.a)localObject).iLO = new ckv();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_downloadcdninfo";
    ((d.a)localObject).funcId = 1035;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cku)this.rr.iLK.iLR;
    ((cku)localObject).dNI = paramString1;
    ((cku)localObject).Mqw = paramString2;
    Log.i("MicroMsg.NetSceneDownloadCdnInfo", "download cdn info, appid : %s, mediaId : %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(78873);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78875);
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78875);
    return i;
  }
  
  public final int getType()
  {
    return 1035;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78874);
    Log.i("MicroMsg.NetSceneDownloadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.l
 * JD-Core Version:    0.7.0.1
 */