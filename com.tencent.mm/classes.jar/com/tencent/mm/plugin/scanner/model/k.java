package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.nr;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;

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
    ((b.a)localObject).hvt = new nr();
    ((b.a)localObject).hvu = new ns();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
    ((b.a)localObject).funcId = 1064;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (nr)this.rr.hvr.hvw;
    ((nr)localObject).fZq = d.DHX;
    ((nr)localObject).fZr = d.DHW;
    ((nr)localObject).fZs = d.DHZ;
    ((nr)localObject).fZt = d.DIa;
    ((nr)localObject).fZu = ab.eUO();
    ((nr)localObject).fZv = 11294;
    ((nr)localObject).fZw = null;
    ((nr)localObject).wYw = paramString1;
    ((nr)localObject).wYv = paramString2;
    ((nr)localObject).type = paramInt1;
    ((nr)localObject).value = paramString3;
    ((nr)localObject).count = paramInt2;
    ((nr)localObject).vtK = paramInt3;
    ac.v("MircoMsg.NetSceneScanProductReport", "statid:".concat(String.valueOf(paramString2)));
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
    ac.d("MircoMsg.NetSceneScanProductReport", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.k
 * JD-Core Version:    0.7.0.1
 */