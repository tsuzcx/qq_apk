package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.sdk.platformtools.ad;

public final class q
  extends n
  implements k
{
  private g gbr;
  public final b rr;
  public Object tag;
  
  public q(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78888);
    ad.d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new azc();
    ((b.a)localObject).gUV = new azd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
    ((b.a)localObject).funcId = 673;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (azc)this.rr.gUS.gUX;
    ((azc)localObject).URL = paramString1;
    ((azc)localObject).Dxu = paramString2;
    ((azc)localObject).Width = paramInt1;
    ((azc)localObject).Height = paramInt2;
    AppMethodBeat.o(78888);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78890);
    ad.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
    this.gbr = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78890);
    return i;
  }
  
  public final int getType()
  {
    return 673;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78889);
    ad.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(78889);
      return;
    }
    AppMethodBeat.o(78889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.q
 * JD-Core Version:    0.7.0.1
 */