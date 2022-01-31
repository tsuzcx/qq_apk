package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.sdk.platformtools.ab;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  String appId;
  private f eGj;
  String hgk;
  final b rr;
  
  public k(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6592);
    this.appId = paramString1;
    this.hgk = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bbg();
    ((b.a)localObject).fsY = new bbh();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_downloadcdninfo";
    ((b.a)localObject).funcId = 1035;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bbg)this.rr.fsV.fta;
    ((bbg)localObject).cwc = paramString1;
    ((bbg)localObject).xqG = paramString2;
    ab.i("MicroMsg.NetSceneDownloadCdnInfo", "download cdn info, appid : %s, mediaId : %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(6592);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6594);
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6594);
    return i;
  }
  
  public final int getType()
  {
    return 1035;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6593);
    ab.i("MicroMsg.NetSceneDownloadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.k
 * JD-Core Version:    0.7.0.1
 */