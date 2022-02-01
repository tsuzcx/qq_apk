package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;

public final class p
  extends n
  implements k
{
  public byk AFL;
  public byj AFM;
  private g callback;
  private b hdD;
  
  public p(byj parambyj)
  {
    AppMethodBeat.i(117620);
    this.AFM = parambyj;
    Object localObject = this.AFM;
    if (ai.Eq()) {}
    for (int i = 1;; i = 0)
    {
      ((byj)localObject).DVd = i;
      parambyj.DLE = aa.bCk();
      this.AFL = new byk();
      localObject = new b.a();
      ((b.a)localObject).funcId = 1076;
      ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/pardussearch";
      ((b.a)localObject).gUU = parambyj;
      ((b.a)localObject).gUV = this.AFL;
      this.hdD = ((b.a)localObject).atI();
      AppMethodBeat.o(117620);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117621);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(117621);
    return i;
  }
  
  public final int getType()
  {
    return 1076;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117622);
    ad.i("MicroMsg.FTS.NetScenePardusSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.p
 * JD-Core Version:    0.7.0.1
 */