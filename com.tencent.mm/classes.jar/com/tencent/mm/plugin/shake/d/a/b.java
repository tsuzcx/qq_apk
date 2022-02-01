package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private f callback;
  public com.tencent.mm.al.b rr;
  private int scene;
  private String yNI;
  
  public b(String paramString, int paramInt)
  {
    this.yNI = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(28274);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new bja();
    paramf.hNN = new bjb();
    paramf.uri = "/cgi-bin/micromsg-bin/gettvinfo";
    paramf.funcId = 552;
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDC();
    paramf = (bja)this.rr.hNK.hNQ;
    paramf.GDI = this.yNI;
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
    ad.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28276);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(28275);
    paramq = (bja)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    if ((paramq.Scene < 0) || (paramq.GDI == null) || (paramq.GDI.length() <= 0))
    {
      ad.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(paramq.Scene) });
      paramq = n.b.hOq;
      AppMethodBeat.o(28275);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(28275);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.b
 * JD-Core Version:    0.7.0.1
 */