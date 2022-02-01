package com.tencent.mm.plugin.patmsg.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.mt;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.exr;
import com.tencent.mm.protocal.protobuf.exs;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  public Pair<Long, Long> MHt;
  public mt MHu;
  private com.tencent.mm.am.h callback;
  public c oDw;
  
  public b(Pair<Long, Long> paramPair, String paramString1, String paramString2)
  {
    this(paramPair, paramString1, paramString2, 0);
  }
  
  public b(Pair<Long, Long> paramPair, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(266358);
    exr localexr = new exr();
    localexr.abnl = z.bAM();
    localexr.abzq = paramString1;
    localexr.abzr = paramString2;
    localexr.YHk = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).d(paramPair);
    localexr.IJG = paramInt;
    this.MHt = paramPair;
    paramPair = new c.a();
    paramPair.otE = localexr;
    paramPair.uri = "/cgi-bin/micromsg-bin/sendpat";
    paramPair.funcId = getType();
    paramPair.otF = new exs();
    this.oDw = paramPair.bEF();
    AppMethodBeat.o(266358);
  }
  
  public final String aJK()
  {
    AppMethodBeat.i(266367);
    String str = ((exr)c.b.b(this.oDw.otB)).abzq;
    AppMethodBeat.o(266367);
    return str;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(266372);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(266372);
    return i;
  }
  
  public final int getType()
  {
    return 849;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(266379);
    Log.i("MicroMsg.NetSceneSendPat", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(266379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.b.b
 * JD-Core Version:    0.7.0.1
 */