package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private d rr;
  
  public i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(202035);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bvl();
    ((d.a)localObject).iLO = new bvm();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_sns_ad_metric";
    ((d.a)localObject).funcId = 4342;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bvl)this.rr.iLK.iLR;
    ((bvl)localObject).pTI = 1;
    ((bvl)localObject).MbA = paramString1;
    ((bvl)localObject).aid = paramString2;
    ((bvl)localObject).MbB = paramString3;
    ((bvl)localObject).gTk = paramString4;
    AppMethodBeat.o(202035);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(202037);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(202037);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(202036);
    int i = this.rr.getType();
    AppMethodBeat.o(202036);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202038);
    Log.i("NetSceneDynamicAdDataUpdate", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(202038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.i
 * JD-Core Version:    0.7.0.1
 */