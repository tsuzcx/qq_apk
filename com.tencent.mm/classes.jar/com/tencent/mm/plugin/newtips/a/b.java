package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.al.b rr;
  boolean udN;
  int udO;
  
  @Deprecated
  public b(int paramInt, String paramString)
  {
    AppMethodBeat.i(127209);
    this.udN = false;
    this.udO = 0;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cdj();
    ((b.a)localObject).gUV = new cdk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pushnewtips";
    ((b.a)localObject).funcId = 597;
    this.rr = ((b.a)localObject).atI();
    localObject = (cdj)this.rr.gUS.gUX;
    ((cdj)localObject).DZE = paramInt;
    ((cdj)localObject).DZF = 1;
    ((cdj)localObject).sdv = paramString;
    this.udO = paramInt;
    AppMethodBeat.o(127209);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(127211);
    ad.d("MicroMsg.NetScenePushCompatNewTips", "doScene");
    this.callback = paramg;
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
    this.udN = ((cdk)((com.tencent.mm.al.b)paramq).gUT.gUX).DZH;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.b
 * JD-Core Version:    0.7.0.1
 */