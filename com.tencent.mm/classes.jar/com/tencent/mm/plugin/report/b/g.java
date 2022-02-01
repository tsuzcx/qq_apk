package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.protocal.protobuf.ai;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends n
  implements k
{
  private static boolean isRunning;
  private static Object lock;
  private aon cAW;
  private com.tencent.mm.al.g callback;
  private com.tencent.mm.al.b rr;
  public ai vJr;
  
  static
  {
    AppMethodBeat.i(143799);
    isRunning = false;
    lock = new Object();
    AppMethodBeat.o(143799);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143796);
    this.cAW = null;
    setIsRunning(true);
    ah localah = new ah();
    this.cAW = new aon();
    try
    {
      localah.CtN = paramInt1;
      localah.CtO = paramInt2;
      this.cAW.Dqs = localah;
      AppMethodBeat.o(143796);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
      AppMethodBeat.o(143796);
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
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(143798);
    this.callback = paramg;
    com.tencent.mm.kernel.g.afz();
    if (!a.aeH())
    {
      ad.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
      AppMethodBeat.o(143798);
      return -1;
    }
    paramg = new b.a();
    paramg.gUW = false;
    paramg.gUU = this.cAW;
    paramg.gUV = new aoo();
    paramg.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
    paramg.funcId = getType();
    this.rr = paramg.atI();
    int i = dispatch(parame, this.rr, this);
    if (i < 0) {
      ad.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
    }
    try
    {
      this.vJr = null;
      setIsRunning(false);
      AppMethodBeat.o(143798);
      return i;
    }
    catch (Exception parame)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bt.m(parame) });
      }
    }
  }
  
  public final int getType()
  {
    return 914;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(143797);
    try
    {
      this.vJr = null;
      if ((com.tencent.mm.kernel.g.afA().gcy == null) || (com.tencent.mm.kernel.g.afA().gcy.gVH == null))
      {
        ad.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      if (paramInt2 != 0)
      {
        ad.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      ad.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
      this.vJr = ((aoo)this.rr.gUT.gUX).Dqt;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    finally
    {
      setIsRunning(false);
      AppMethodBeat.o(143797);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.g
 * JD-Core Version:    0.7.0.1
 */