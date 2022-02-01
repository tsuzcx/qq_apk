package com.tencent.mm.plugin.patmsg.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.em;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  private f callback;
  public com.tencent.mm.ak.b hZD;
  public Pair<Long, Long> wVv;
  public em wVw;
  
  public b(Pair<Long, Long> paramPair, String paramString1, String paramString2)
  {
    this(paramPair, paramString1, paramString2, 0);
  }
  
  public b(Pair<Long, Long> paramPair, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(220348);
    dau localdau = new dau();
    localdau.HzT = v.aAC();
    localdau.HJV = paramString1;
    localdau.HJW = paramString2;
    localdau.FOR = ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).d(paramPair);
    localdau.Scene = paramInt;
    this.wVv = paramPair;
    paramPair = new b.a();
    paramPair.hQF = localdau;
    paramPair.uri = "/cgi-bin/micromsg-bin/sendpat";
    paramPair.funcId = getType();
    paramPair.hQG = new dav();
    this.hZD = paramPair.aDS();
    AppMethodBeat.o(220348);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(220349);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(220349);
    return i;
  }
  
  public final int getType()
  {
    return 849;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220350);
    ae.i("MicroMsg.NetSceneSendPat", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(220350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.b.b
 * JD-Core Version:    0.7.0.1
 */