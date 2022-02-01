package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  private g callback;
  public com.tencent.mm.ak.b rr;
  private int scene;
  private String xyY;
  
  public b(String paramString, int paramInt)
  {
    this.xyY = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(28274);
    this.callback = paramg;
    paramg = new b.a();
    paramg.hvt = new bes();
    paramg.hvu = new bet();
    paramg.uri = "/cgi-bin/micromsg-bin/gettvinfo";
    paramg.funcId = 552;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.aAz();
    paramg = (bes)this.rr.hvr.hvw;
    paramg.EUl = this.xyY;
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
    ac.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28276);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(28275);
    paramq = (bes)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    if ((paramq.Scene < 0) || (paramq.EUl == null) || (paramq.EUl.length() <= 0))
    {
      ac.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(paramq.Scene) });
      paramq = n.b.hwb;
      AppMethodBeat.o(28275);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(28275);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.b
 * JD-Core Version:    0.7.0.1
 */