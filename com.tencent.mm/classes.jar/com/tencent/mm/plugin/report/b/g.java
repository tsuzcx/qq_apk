package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.protocal.protobuf.ai;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
  extends n
  implements k
{
  private static boolean isRunning;
  private static Object lock;
  private awd cJJ;
  private f callback;
  private com.tencent.mm.ak.b rr;
  public ai ywW;
  
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
    this.cJJ = null;
    setIsRunning(true);
    ah localah = new ah();
    this.cJJ = new awd();
    try
    {
      localah.FJH = paramInt1;
      localah.FJI = paramInt2;
      this.cJJ.GNW = localah;
      AppMethodBeat.o(143796);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
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
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(143798);
    this.callback = paramf;
    com.tencent.mm.kernel.g.ajP();
    if (!a.aiY())
    {
      ae.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
      AppMethodBeat.o(143798);
      return -1;
    }
    paramf = new b.a();
    paramf.hQI = false;
    paramf.hQF = this.cJJ;
    paramf.hQG = new awe();
    paramf.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
    paramf.funcId = getType();
    this.rr = paramf.aDS();
    int i = dispatch(parame, this.rr, this);
    if (i < 0) {
      ae.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
    }
    try
    {
      this.ywW = null;
      setIsRunning(false);
      AppMethodBeat.o(143798);
      return i;
    }
    catch (Exception parame)
    {
      for (;;)
      {
        ae.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bu.o(parame) });
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
      this.ywW = null;
      if ((com.tencent.mm.kernel.g.ajQ().gDv == null) || (com.tencent.mm.kernel.g.ajQ().gDv.hRo == null))
      {
        ae.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      if (paramInt2 != 0)
      {
        ae.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      ae.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
      this.ywW = ((awe)this.rr.hQE.hQJ).GNX;
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