package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private String dcO;
  private String ozN;
  public b rr;
  private int scene;
  
  public g(String paramString1, int paramInt, String paramString2)
  {
    this.dcO = paramString1;
    this.scene = paramInt;
    this.ozN = paramString2;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(51620);
    this.callback = paramg;
    paramg = new b.a();
    paramg.hvt = new my();
    paramg.hvu = new mz();
    paramg.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
    paramg.funcId = 1063;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.aAz();
    paramg = (my)this.rr.hvr.hvw;
    paramg.ProductID = this.dcO;
    paramg.Scene = this.scene;
    paramg.Ece = this.ozN;
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
    ac.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51622);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(51621);
    paramq = (my)((b)paramq).hvr.hvw;
    if ((paramq.Scene < 0) || (paramq.ProductID == null) || (paramq.ProductID.length() <= 0))
    {
      ac.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(paramq.Scene) });
      paramq = n.b.hwb;
      AppMethodBeat.o(51621);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(51621);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.g
 * JD-Core Version:    0.7.0.1
 */