package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends m
  implements k
{
  private f callback;
  private b rr;
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(80850);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new lq();
    ((b.a)localObject).fsY = new lr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
    ((b.a)localObject).funcId = 1064;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (lq)this.rr.fsV.fta;
    ((lq)localObject).wAb = d.whC;
    ((lq)localObject).wAc = d.whB;
    ((lq)localObject).wAd = d.whE;
    ((lq)localObject).wAe = d.whF;
    ((lq)localObject).wAf = aa.dsG();
    ((lq)localObject).qst = 11294;
    ((lq)localObject).wAg = null;
    ((lq)localObject).qtX = paramString1;
    ((lq)localObject).qtW = paramString2;
    ((lq)localObject).type = paramInt1;
    ((lq)localObject).value = paramString3;
    ((lq)localObject).count = paramInt2;
    ((lq)localObject).pmi = paramInt3;
    ab.v("MircoMsg.NetSceneScanProductReport", "statid:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(80850);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(80852);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(80852);
    return i;
  }
  
  public final int getType()
  {
    return 1064;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(80851);
    ab.d("MircoMsg.NetSceneScanProductReport", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(80851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.i
 * JD-Core Version:    0.7.0.1
 */