package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.protocal.protobuf.crf;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private g callback;
  public b rr;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(26907);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cre();
    ((b.a)localObject).gUV = new crf();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
    ((b.a)localObject).funcId = 1363;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cre)this.rr.gUS.gUX;
    ((cre)localObject).CIQ = paramString;
    ((cre)localObject).EjQ = paramInt;
    ((cre)localObject).EjR = 4;
    AppMethodBeat.o(26907);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(26909);
    this.callback = paramg;
    ad.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26909);
    return i;
  }
  
  public final int getType()
  {
    return 1363;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26908);
    ad.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(26908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.c
 * JD-Core Version:    0.7.0.1
 */