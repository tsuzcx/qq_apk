package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public final class d
  extends m
  implements k
{
  private f callback;
  private b fBd;
  aqd spC;
  aqe spD;
  private WeakReference<c> spE;
  
  public d(long paramLong1, long paramLong2, c paramc)
  {
    AppMethodBeat.i(93657);
    this.spE = new WeakReference(paramc);
    paramc = new b.a();
    paramc.funcId = 1734;
    paramc.uri = "/cgi-bin/mmoc-bin/hardware/getsteplist";
    paramc.fsX = new aqd();
    paramc.fsY = new aqe();
    this.fBd = paramc.ado();
    this.spC = ((aqd)this.fBd.fsV.fta);
    this.spC.wPH = ((int)(paramLong1 / 1000L));
    this.spC.wPI = ((int)(paramLong2 / 1000L));
    AppMethodBeat.o(93657);
  }
  
  public final c cyI()
  {
    AppMethodBeat.i(138291);
    c localc = (c)this.spE.get();
    AppMethodBeat.o(138291);
    return localc;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(93658);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(93658);
    return i;
  }
  
  public final int getType()
  {
    return 1734;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93659);
    ab.i("MicroMsg.Sport.NetSceneGetStepList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.spD = ((aqe)this.fBd.fsW.fta);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(93659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.d
 * JD-Core Version:    0.7.0.1
 */