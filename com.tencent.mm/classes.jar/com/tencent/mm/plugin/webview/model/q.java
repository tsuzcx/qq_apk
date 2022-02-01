package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.bhq;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.sdk.platformtools.ae;

public final class q
  extends n
  implements k
{
  private f gCo;
  public final b rr;
  public Object tag;
  
  public q(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78888);
    ae.d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bhq();
    ((b.a)localObject).hQG = new bhr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
    ((b.a)localObject).funcId = 673;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bhq)this.rr.hQD.hQJ;
    ((bhq)localObject).URL = paramString1;
    ((bhq)localObject).GVJ = paramString2;
    ((bhq)localObject).Width = paramInt1;
    ((bhq)localObject).Height = paramInt2;
    AppMethodBeat.o(78888);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78890);
    ae.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
    this.gCo = paramf;
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
    ae.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + paramInt2 + ", errCode = " + paramInt3);
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