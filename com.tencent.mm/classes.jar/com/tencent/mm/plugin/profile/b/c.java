package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cwn;
import com.tencent.mm.protocal.protobuf.cwo;
import com.tencent.mm.sdk.platformtools.ac;

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
    ((b.a)localObject).hvt = new cwn();
    ((b.a)localObject).hvu = new cwo();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
    ((b.a)localObject).funcId = 1363;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cwn)this.rr.hvr.hvw;
    ((cwn)localObject).Ebs = paramString;
    ((cwn)localObject).FGO = paramInt;
    ((cwn)localObject).FGP = 4;
    AppMethodBeat.o(26907);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(26909);
    this.callback = paramg;
    ac.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
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
    ac.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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