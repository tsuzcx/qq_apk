package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.dob;

public final class i
  extends n
  implements k
{
  private g callback;
  private final String djj;
  private final int scene;
  public final String xom;
  public final int xon;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.djj = paramString1;
    this.xom = paramString2;
    this.xon = paramInt1;
    this.scene = paramInt2;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(73777);
    this.callback = paramg;
    paramg = new b.a();
    bvx localbvx = new bvx();
    localbvx.djj = this.djj;
    localbvx.Fls = this.xom;
    localbvx.Flt = this.xon;
    paramg.hvt = localbvx;
    paramg.uri = "/cgi-bin/mmbiz-bin/moduserauth";
    paramg.hvu = new bvy();
    paramg.funcId = getType();
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    int i = dispatch(parame, paramg.aAz(), this);
    AppMethodBeat.o(73777);
    return i;
  }
  
  public final int getType()
  {
    return 1144;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73776);
    paramString = (bvy)((b)paramq).hvs.hvw;
    this.callback.onSceneEnd(paramInt2, paramString.EuM.dfm, paramString.EuM.dfn, this);
    AppMethodBeat.o(73776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.i
 * JD-Core Version:    0.7.0.1
 */