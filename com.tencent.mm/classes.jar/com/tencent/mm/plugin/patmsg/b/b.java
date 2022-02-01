package com.tencent.mm.plugin.patmsg.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.kc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eeb;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  public kc GKA;
  public Pair<Long, Long> GKz;
  private i callback;
  public d lKU;
  
  public b(Pair<Long, Long> paramPair, String paramString1, String paramString2)
  {
    this(paramPair, paramString1, paramString2, 0);
  }
  
  public b(Pair<Long, Long> paramPair, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(186488);
    eea localeea = new eea();
    localeea.TWw = z.bcZ();
    localeea.Uia = paramString1;
    localeea.Uib = paramString2;
    localeea.RJQ = ((com.tencent.mm.plugin.patmsg.a.b)h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).d(paramPair);
    localeea.CPw = paramInt;
    this.GKz = paramPair;
    paramPair = new d.a();
    paramPair.lBU = localeea;
    paramPair.uri = "/cgi-bin/micromsg-bin/sendpat";
    paramPair.funcId = getType();
    paramPair.lBV = new eeb();
    this.lKU = paramPair.bgN();
    AppMethodBeat.o(186488);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(186493);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(186493);
    return i;
  }
  
  public final int getType()
  {
    return 849;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186496);
    Log.i("MicroMsg.NetSceneSendPat", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(186496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.b.b
 * JD-Core Version:    0.7.0.1
 */