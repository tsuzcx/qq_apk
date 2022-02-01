package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  private f callback;
  public com.tencent.mm.ak.b rr;
  private int scene;
  private String zdS;
  
  public b(String paramString, int paramInt)
  {
    this.zdS = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(28274);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new bjs();
    paramf.hQG = new bjt();
    paramf.uri = "/cgi-bin/micromsg-bin/gettvinfo";
    paramf.funcId = 552;
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDS();
    paramf = (bjs)this.rr.hQD.hQJ;
    paramf.GXl = this.zdS;
    paramf.Scene = this.scene;
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
    ae.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28276);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(28275);
    paramq = (bjs)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    if ((paramq.Scene < 0) || (paramq.GXl == null) || (paramq.GXl.length() <= 0))
    {
      ae.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(paramq.Scene) });
      paramq = n.b.hRj;
      AppMethodBeat.o(28275);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(28275);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.b
 * JD-Core Version:    0.7.0.1
 */