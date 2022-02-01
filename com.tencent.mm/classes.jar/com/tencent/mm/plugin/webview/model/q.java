package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.sdk.platformtools.ac;

public final class q
  extends n
  implements k
{
  private g gfX;
  public final b rr;
  public Object tag;
  
  public q(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78888);
    ac.d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bcu();
    ((b.a)localObject).hvu = new bcv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
    ((b.a)localObject).funcId = 673;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bcu)this.rr.hvr.hvw;
    ((bcu)localObject).URL = paramString1;
    ((bcu)localObject).ESQ = paramString2;
    ((bcu)localObject).Width = paramInt1;
    ((bcu)localObject).Height = paramInt2;
    AppMethodBeat.o(78888);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78890);
    ac.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
    this.gfX = paramg;
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
    ac.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + paramInt2 + ", errCode = " + paramInt3);
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