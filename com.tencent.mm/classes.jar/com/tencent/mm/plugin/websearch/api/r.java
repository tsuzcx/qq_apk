package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.ui.al;

public final class r
  extends n
  implements k
{
  public cie DAX;
  public cid DAY;
  private f callback;
  private b hWL;
  
  public r(cid paramcid)
  {
    AppMethodBeat.i(117620);
    this.DAY = paramcid;
    Object localObject = this.DAY;
    if (al.isDarkMode()) {}
    for (int i = 1;; i = 0)
    {
      ((cid)localObject).HbV = i;
      paramcid.GRt = ad.bNG();
      this.DAX = new cie();
      localObject = new b.a();
      ((b.a)localObject).funcId = 1076;
      ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/pardussearch";
      ((b.a)localObject).hNM = paramcid;
      ((b.a)localObject).hNN = this.DAX;
      this.hWL = ((b.a)localObject).aDC();
      AppMethodBeat.o(117620);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117621);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(117621);
    return i;
  }
  
  public final cie eLV()
  {
    return this.DAX;
  }
  
  public final int getType()
  {
    return 1076;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117622);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.NetScenePardusSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.r
 * JD-Core Version:    0.7.0.1
 */