package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public i(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(309892);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new csp();
    ((c.a)localObject).otF = new csq();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_sns_ad_metric";
    ((c.a)localObject).funcId = 4342;
    this.rr = ((c.a)localObject).bEF();
    localObject = (csp)c.b.b(this.rr.otB);
    ((csp)localObject).wuj = 1;
    ((csp)localObject).aayH = paramString1;
    ((csp)localObject).aid = paramString2;
    ((csp)localObject).aayI = paramString3;
    ((csp)localObject).mdG = paramString4;
    ((csp)localObject).aayJ = paramInt1;
    ((csp)localObject).aaun = paramInt2;
    ((csp)localObject).aayK = paramInt3;
    AppMethodBeat.o(309892);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(309894);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(309894);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(309893);
    int i = this.rr.getType();
    AppMethodBeat.o(309893);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(309896);
    Log.i("NetSceneDynamicAdDataUpdate", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(309896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.i
 * JD-Core Version:    0.7.0.1
 */