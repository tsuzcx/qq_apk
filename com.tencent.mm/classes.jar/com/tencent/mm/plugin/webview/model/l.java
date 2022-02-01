package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.sdk.platformtools.ad;

public final class l
  extends n
  implements k
{
  String appId;
  private f gzH;
  String jUD;
  final b rr;
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78873);
    this.appId = paramString1;
    this.jUD = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bwi();
    ((b.a)localObject).hNN = new bwj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_downloadcdninfo";
    ((b.a)localObject).funcId = 1035;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bwi)this.rr.hNK.hNQ;
    ((bwi)localObject).duW = paramString1;
    ((bwi)localObject).GQH = paramString2;
    ad.i("MicroMsg.NetSceneDownloadCdnInfo", "download cdn info, appid : %s, mediaId : %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(78873);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78875);
    this.gzH = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78875);
    return i;
  }
  
  public final int getType()
  {
    return 1035;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78874);
    ad.i("MicroMsg.NetSceneDownloadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.l
 * JD-Core Version:    0.7.0.1
 */