package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private f callback;
  private b rr;
  
  public n(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(51631);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new oy();
    ((b.a)localObject).hQG = new oz();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
    ((b.a)localObject).funcId = 1064;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (oy)this.rr.hQD.hQJ;
    ((oy)localObject).gvo = d.FFC;
    ((oy)localObject).gvp = d.FFB;
    ((oy)localObject).gvq = d.FFE;
    ((oy)localObject).gvr = d.FFF;
    ((oy)localObject).gvs = ad.fom();
    ((oy)localObject).gvt = 11294;
    ((oy)localObject).gvu = null;
    ((oy)localObject).yCe = paramString1;
    ((oy)localObject).yCd = paramString2;
    ((oy)localObject).type = paramInt1;
    ((oy)localObject).value = paramString3;
    ((oy)localObject).count = paramInt2;
    ((oy)localObject).wON = paramInt3;
    ae.v("MircoMsg.NetSceneScanProductReport", "statid:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(51631);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(51633);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(51633);
    return i;
  }
  
  public final int getType()
  {
    return 1064;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51632);
    ae.d("MircoMsg.NetSceneScanProductReport", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.n
 * JD-Core Version:    0.7.0.1
 */