package com.tencent.mm.plugin.patmsg.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.ek;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private f callback;
  public com.tencent.mm.al.b hWL;
  public Pair<Long, Long> wFK;
  public ek wFL;
  
  public b(Pair<Long, Long> paramPair, String paramString1, String paramString2)
  {
    this(paramPair, paramString1, paramString2, 0);
  }
  
  public b(Pair<Long, Long> paramPair, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(215714);
    daa localdaa = new daa();
    localdaa.Hgt = u.aAm();
    localdaa.Hqt = paramString1;
    localdaa.Hqu = paramString2;
    localdaa.Fwt = ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).d(paramPair);
    localdaa.Scene = paramInt;
    this.wFK = paramPair;
    paramPair = new b.a();
    paramPair.hNM = localdaa;
    paramPair.uri = "/cgi-bin/micromsg-bin/sendpat";
    paramPair.funcId = getType();
    paramPair.hNN = new dab();
    this.hWL = paramPair.aDC();
    AppMethodBeat.o(215714);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215715);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(215715);
    return i;
  }
  
  public final int getType()
  {
    return 849;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215716);
    ad.i("MicroMsg.NetSceneSendPat", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(215716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.b.b
 * JD-Core Version:    0.7.0.1
 */