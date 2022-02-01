package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aj;
import com.tencent.mm.protocal.protobuf.ak;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.protocal.protobuf.bho;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends q
  implements m
{
  private static boolean isRunning;
  private static Object lock;
  public ak CxS;
  private i callback;
  private bhn dah;
  private d rr;
  
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
    this.dah = null;
    setIsRunning(true);
    aj localaj = new aj();
    this.dah = new bhn();
    try
    {
      localaj.KCZ = paramInt1;
      localaj.KDa = paramInt2;
      this.dah.LSc = localaj;
      AppMethodBeat.o(143796);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
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
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(143798);
    this.callback = parami;
    com.tencent.mm.kernel.g.aAf();
    if (!a.azo())
    {
      Log.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
      AppMethodBeat.o(143798);
      return -1;
    }
    parami = new d.a();
    parami.iLQ = false;
    parami.iLN = this.dah;
    parami.iLO = new bho();
    parami.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
    parami.funcId = getType();
    this.rr = parami.aXF();
    int i = dispatch(paramg, this.rr, this);
    if (i < 0) {
      Log.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
    }
    try
    {
      this.CxS = null;
      setIsRunning(false);
      AppMethodBeat.o(143798);
      return i;
    }
    catch (Exception paramg)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), Util.stackTraceToString(paramg) });
      }
    }
  }
  
  public final int getType()
  {
    return 914;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(143797);
    try
    {
      this.CxS = null;
      if ((com.tencent.mm.kernel.g.aAg().hqi == null) || (com.tencent.mm.kernel.g.aAg().hqi.iMw == null))
      {
        Log.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      if (paramInt2 != 0)
      {
        Log.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      Log.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
      this.CxS = ((bho)this.rr.iLL.iLR).LSd;
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