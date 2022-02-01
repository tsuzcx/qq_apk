package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.nu;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.sdk.platformtools.ae;

public final class j
  extends n
  implements k
{
  private f callback;
  private String dpp;
  private String pjO;
  public b rr;
  private int scene;
  
  public j(String paramString1, int paramInt, String paramString2)
  {
    this.dpp = paramString1;
    this.scene = paramInt;
    this.pjO = paramString2;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(51620);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new nu();
    paramf.hQG = new nv();
    paramf.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
    paramf.funcId = 1063;
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDS();
    paramf = (nu)this.rr.hQD.hQJ;
    paramf.ProductID = this.dpp;
    paramf.Scene = this.scene;
    paramf.Gaw = this.pjO;
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
    ae.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51622);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(51621);
    paramq = (nu)((b)paramq).hQD.hQJ;
    if ((paramq.Scene < 0) || (paramq.ProductID == null) || (paramq.ProductID.length() <= 0))
    {
      ae.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(paramq.Scene) });
      paramq = n.b.hRj;
      AppMethodBeat.o(51621);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(51621);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.j
 * JD-Core Version:    0.7.0.1
 */