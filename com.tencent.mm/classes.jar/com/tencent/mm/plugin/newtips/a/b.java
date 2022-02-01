package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.al.b rr;
  boolean wse;
  int wsf;
  
  @Deprecated
  public b(int paramInt, String paramString)
  {
    AppMethodBeat.i(127209);
    this.wse = false;
    this.wsf = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cnm();
    ((b.a)localObject).hNN = new cnn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pushnewtips";
    ((b.a)localObject).funcId = 597;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cnm)this.rr.hNK.hNQ;
    ((cnm)localObject).HgF = paramInt;
    ((cnm)localObject).HgG = 1;
    ((cnm)localObject).ujy = paramString;
    this.wsf = paramInt;
    AppMethodBeat.o(127209);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(127211);
    ad.d("MicroMsg.NetScenePushCompatNewTips", "doScene");
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
      ad.e("MicroMsg.NetScenePushCompatNewTips", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(127210);
      return;
    }
    this.wse = ((cnn)((com.tencent.mm.al.b)paramq).hNL.hNQ).HgI;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.b
 * JD-Core Version:    0.7.0.1
 */