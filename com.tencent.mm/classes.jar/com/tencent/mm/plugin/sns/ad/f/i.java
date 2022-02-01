package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cdd;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  private d rr;
  
  public i(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(201119);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cdd();
    ((d.a)localObject).lBV = new cde();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_sns_ad_metric";
    ((d.a)localObject).funcId = 4342;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cdd)d.b.b(this.rr.lBR);
    ((cdd)localObject).tpK = 1;
    ((cdd)localObject).Tla = paramString1;
    ((cdd)localObject).aid = paramString2;
    ((cdd)localObject).Tlb = paramString3;
    ((cdd)localObject).jDL = paramString4;
    ((cdd)localObject).Tlc = paramInt1;
    ((cdd)localObject).TgX = paramInt2;
    ((cdd)localObject).Tld = paramInt3;
    AppMethodBeat.o(201119);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(201124);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(201124);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(201120);
    int i = this.rr.getType();
    AppMethodBeat.o(201120);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201125);
    Log.i("NetSceneDynamicAdDataUpdate", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(201125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.i
 * JD-Core Version:    0.7.0.1
 */