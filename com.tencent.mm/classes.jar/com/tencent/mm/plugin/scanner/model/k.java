package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private b rr;
  
  public k(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(51631);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new nk();
    ((b.a)localObject).gUV = new nl();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
    ((b.a)localObject).funcId = 1064;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (nk)this.rr.gUS.gUX;
    ((nk)localObject).fVv = d.CpF;
    ((nk)localObject).fVw = d.CpE;
    ((nk)localObject).fVx = d.CpH;
    ((nk)localObject).fVy = d.CpI;
    ((nk)localObject).fVz = ac.eFu();
    ((nk)localObject).fVA = 11294;
    ((nk)localObject).fVB = null;
    ((nk)localObject).vOa = paramString1;
    ((nk)localObject).vNZ = paramString2;
    ((nk)localObject).type = paramInt1;
    ((nk)localObject).value = paramString3;
    ((nk)localObject).count = paramInt2;
    ((nk)localObject).ukO = paramInt3;
    ad.v("MircoMsg.NetSceneScanProductReport", "statid:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(51631);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(51633);
    this.callback = paramg;
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
    ad.d("MircoMsg.NetSceneScanProductReport", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.k
 * JD-Core Version:    0.7.0.1
 */