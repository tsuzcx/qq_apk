package com.tencent.mm.plugin.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.protocal.protobuf.ai;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
  extends n
  implements k
{
  private static boolean isRunning;
  private static Object lock;
  private com.tencent.mm.ak.g callback;
  private arr cyf;
  private com.tencent.mm.ak.b rr;
  public ai wTv;
  
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
    this.cyf = null;
    setIsRunning(true);
    ah localah = new ah();
    this.cyf = new arr();
    try
    {
      localah.DMe = paramInt1;
      localah.DMf = paramInt2;
      this.cyf.ELu = localah;
      AppMethodBeat.o(143796);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
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
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(143798);
    this.callback = paramg;
    com.tencent.mm.kernel.g.agP();
    if (!a.afX())
    {
      ac.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
      AppMethodBeat.o(143798);
      return -1;
    }
    paramg = new b.a();
    paramg.hvv = false;
    paramg.hvt = this.cyf;
    paramg.hvu = new ars();
    paramg.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
    paramg.funcId = getType();
    this.rr = paramg.aAz();
    int i = dispatch(parame, this.rr, this);
    if (i < 0) {
      ac.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
    }
    try
    {
      this.wTv = null;
      setIsRunning(false);
      AppMethodBeat.o(143798);
      return i;
    }
    catch (Exception parame)
    {
      for (;;)
      {
        ac.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bs.m(parame) });
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
      this.wTv = null;
      if ((com.tencent.mm.kernel.g.agQ().ghe == null) || (com.tencent.mm.kernel.g.agQ().ghe.hwg == null))
      {
        ac.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      if (paramInt2 != 0)
      {
        ac.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      ac.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
      this.wTv = ((ars)this.rr.hvs.hvw).ELv;
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
 * Qualified Name:     com.tencent.mm.plugin.report.c.g
 * JD-Core Version:    0.7.0.1
 */