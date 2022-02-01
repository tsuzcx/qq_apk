package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bba;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private g callback;
  public com.tencent.mm.al.b rr;
  private int scene;
  private String wnH;
  
  public b(String paramString, int paramInt)
  {
    this.wnH = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(28274);
    this.callback = paramg;
    paramg = new b.a();
    paramg.gUU = new bba();
    paramg.gUV = new bbb();
    paramg.uri = "/cgi-bin/micromsg-bin/gettvinfo";
    paramg.funcId = 552;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.atI();
    paramg = (bba)this.rr.gUS.gUX;
    paramg.DyP = this.wnH;
    paramg.Scene = this.scene;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28274);
    return i;
  }
  
  public final int getType()
  {
    return 552;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28276);
    ad.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28276);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(28275);
    paramq = (bba)((com.tencent.mm.al.b)paramq).gUS.gUX;
    if ((paramq.Scene < 0) || (paramq.DyP == null) || (paramq.DyP.length() <= 0))
    {
      ad.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(paramq.Scene) });
      paramq = n.b.gVC;
      AppMethodBeat.o(28275);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(28275);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.b
 * JD-Core Version:    0.7.0.1
 */