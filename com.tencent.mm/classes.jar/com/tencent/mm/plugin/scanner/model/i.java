package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends n
  implements k
{
  private f callback;
  private String dok;
  private String pdi;
  public b rr;
  private int scene;
  
  public i(String paramString1, int paramInt, String paramString2)
  {
    this.dok = paramString1;
    this.scene = paramInt;
    this.pdi = paramString2;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(51620);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new ns();
    paramf.hNN = new nt();
    paramf.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
    paramf.funcId = 1063;
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDC();
    paramf = (ns)this.rr.hNK.hNQ;
    paramf.ProductID = this.dok;
    paramf.Scene = this.scene;
    paramf.FIa = this.pdi;
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
    paramq = (ns)((b)paramq).hNK.hNQ;
    if ((paramq.Scene < 0) || (paramq.ProductID == null) || (paramq.ProductID.length() <= 0))
    {
      ad.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(paramq.Scene) });
      paramq = n.b.hOq;
      AppMethodBeat.o(51621);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(51621);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.i
 * JD-Core Version:    0.7.0.1
 */