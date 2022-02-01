package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private String dft;
  private String nWs;
  public b rr;
  private int scene;
  
  public g(String paramString1, int paramInt, String paramString2)
  {
    this.dft = paramString1;
    this.scene = paramInt;
    this.nWs = paramString2;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(51620);
    this.callback = paramg;
    paramg = new b.a();
    paramg.gUU = new mr();
    paramg.gUV = new ms();
    paramg.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
    paramg.funcId = 1063;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.atI();
    paramg = (mr)this.rr.gUS.gUX;
    paramg.ProductID = this.dft;
    paramg.Scene = this.scene;
    paramg.CJC = this.nWs;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(51620);
    return i;
  }
  
  public final int getType()
  {
    return 1063;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51622);
    ad.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51622);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(51621);
    paramq = (mr)((b)paramq).gUS.gUX;
    if ((paramq.Scene < 0) || (paramq.ProductID == null) || (paramq.ProductID.length() <= 0))
    {
      ad.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(paramq.Scene) });
      paramq = n.b.gVC;
      AppMethodBeat.o(51621);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(51621);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.g
 * JD-Core Version:    0.7.0.1
 */