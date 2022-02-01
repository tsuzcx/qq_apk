package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public h(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(219064);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bjg();
    ((b.a)localObject).hQG = new bjh();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_sns_ad_metric";
    ((b.a)localObject).funcId = 4342;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bjg)this.rr.hQD.hQJ;
    ((bjg)localObject).oGc = 1;
    ((bjg)localObject).GWQ = paramString1;
    ((bjg)localObject).zMk = paramString2;
    ((bjg)localObject).GWR = paramString3;
    ((bjg)localObject).zot = paramString4;
    AppMethodBeat.o(219064);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(219066);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(219066);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(219065);
    int i = this.rr.getType();
    AppMethodBeat.o(219065);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(219067);
    ae.i("NetSceneDynamicAdDataUpdate", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(219067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.h
 * JD-Core Version:    0.7.0.1
 */