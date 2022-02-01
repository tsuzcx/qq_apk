package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.protocal.protobuf.coh;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.ak.b rr;
  boolean wHN;
  int wHO;
  
  @Deprecated
  public b(int paramInt, String paramString)
  {
    AppMethodBeat.i(127209);
    this.wHN = false;
    this.wHO = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cog();
    ((b.a)localObject).hQG = new coh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pushnewtips";
    ((b.a)localObject).funcId = 597;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cog)this.rr.hQD.hQJ;
    ((cog)localObject).HAf = paramInt;
    ((cog)localObject).HAg = 1;
    ((cog)localObject).uuW = paramString;
    this.wHO = paramInt;
    AppMethodBeat.o(127209);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(127211);
    ae.d("MicroMsg.NetScenePushCompatNewTips", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(127211);
    return i;
  }
  
  public final int getType()
  {
    return 597;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127210);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetScenePushCompatNewTips", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(127210);
      return;
    }
    this.wHN = ((coh)((com.tencent.mm.ak.b)paramq).hQE.hQJ).HAi;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.b
 * JD-Core Version:    0.7.0.1
 */