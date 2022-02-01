package com.tencent.mm.plugin.patmsg.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.hu;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.dtz;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  public Pair<Long, Long> ARo;
  public hu ARp;
  private i callback;
  public d iUB;
  
  public b(Pair<Long, Long> paramPair, String paramString1, String paramString2)
  {
    this(paramPair, paramString1, paramString2, 0);
  }
  
  public b(Pair<Long, Long> paramPair, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(206970);
    dty localdty = new dty();
    localdty.MKC = z.aTY();
    localdty.MVH = paramString1;
    localdty.MVI = paramString2;
    localdty.KIz = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.patmsg.a.b.class)).d(paramPair);
    localdty.Scene = paramInt;
    this.ARo = paramPair;
    paramPair = new d.a();
    paramPair.iLN = localdty;
    paramPair.uri = "/cgi-bin/micromsg-bin/sendpat";
    paramPair.funcId = getType();
    paramPair.iLO = new dtz();
    this.iUB = paramPair.aXF();
    AppMethodBeat.o(206970);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(206971);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(206971);
    return i;
  }
  
  public final int getType()
  {
    return 849;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(206972);
    Log.i("MicroMsg.NetSceneSendPat", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(206972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.b.b
 * JD-Core Version:    0.7.0.1
 */