package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.ag;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
  extends m
  implements k
{
  private static boolean isRunning;
  private static Object lock;
  private f callback;
  private afj qsb;
  public ag qsc;
  private com.tencent.mm.ai.b rr;
  
  static
  {
    AppMethodBeat.i(72683);
    isRunning = false;
    lock = new Object();
    AppMethodBeat.o(72683);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(72680);
    this.qsb = null;
    setIsRunning(true);
    af localaf = new af();
    this.qsb = new afj();
    try
    {
      localaf.wlz = paramInt1;
      localaf.wlA = paramInt2;
      this.qsb.wYH = localaf;
      AppMethodBeat.o(72680);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
      AppMethodBeat.o(72680);
    }
  }
  
  private static void setIsRunning(boolean paramBoolean)
  {
    synchronized (lock)
    {
      isRunning = paramBoolean;
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(72682);
    this.callback = paramf;
    com.tencent.mm.kernel.g.RJ();
    if (!a.QT())
    {
      ab.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
      AppMethodBeat.o(72682);
      return -1;
    }
    paramf = new b.a();
    paramf.fsZ = false;
    paramf.fsX = this.qsb;
    paramf.fsY = new afk();
    paramf.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
    paramf.funcId = getType();
    this.rr = paramf.ado();
    int i = dispatch(parame, this.rr, this);
    if (i < 0) {
      ab.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
    }
    try
    {
      this.qsc = null;
      setIsRunning(false);
      AppMethodBeat.o(72682);
      return i;
    }
    catch (Exception parame)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bo.l(parame) });
      }
    }
  }
  
  public final int getType()
  {
    return 914;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72681);
    try
    {
      this.qsc = null;
      if ((com.tencent.mm.kernel.g.RK().eHt == null) || (com.tencent.mm.kernel.g.RK().eHt.ftA == null))
      {
        ab.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      if (paramInt2 != 0)
      {
        ab.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      ab.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
      this.qsc = ((afk)this.rr.fsW.fta).wYI;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    finally
    {
      setIsRunning(false);
      AppMethodBeat.o(72681);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.g
 * JD-Core Version:    0.7.0.1
 */