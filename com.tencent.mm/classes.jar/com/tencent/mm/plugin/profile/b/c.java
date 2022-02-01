package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends n
  implements k
{
  private f callback;
  public b rr;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(26907);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dcu();
    ((b.a)localObject).hQG = new dcv();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
    ((b.a)localObject).funcId = 1363;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dcu)this.rr.hQD.hQJ;
    ((dcu)localObject).FZx = paramString;
    ((dcu)localObject).HKY = paramInt;
    ((dcu)localObject).HKZ = 4;
    AppMethodBeat.o(26907);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26909);
    this.callback = paramf;
    ae.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
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
    ae.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(26908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.c
 * JD-Core Version:    0.7.0.1
 */