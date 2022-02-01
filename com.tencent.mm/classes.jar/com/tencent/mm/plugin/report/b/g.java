package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.aj;
import com.tencent.mm.protocal.protobuf.ak;
import com.tencent.mm.protocal.protobuf.cdl;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends p
  implements m
{
  private static boolean Uz;
  private static Object lock;
  public ak Ozy;
  private com.tencent.mm.am.h callback;
  private cdl fdk;
  private com.tencent.mm.am.c rr;
  
  static
  {
    AppMethodBeat.i(143799);
    Uz = false;
    lock = new Object();
    AppMethodBeat.o(143799);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143796);
    this.fdk = null;
    dL(true);
    aj localaj = new aj();
    this.fdk = new cdl();
    try
    {
      localaj.YAV = paramInt1;
      localaj.YAW = paramInt2;
      this.fdk.aanP = localaj;
      AppMethodBeat.o(143796);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
      AppMethodBeat.o(143796);
    }
  }
  
  private static void dL(boolean paramBoolean)
  {
    synchronized (lock)
    {
      Uz = paramBoolean;
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(143798);
    this.callback = paramh;
    com.tencent.mm.kernel.h.baC();
    if (!b.aZM())
    {
      Log.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
      AppMethodBeat.o(143798);
      return -1;
    }
    paramh = new c.a();
    paramh.otH = false;
    paramh.otE = this.fdk;
    paramh.otF = new cdm();
    paramh.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
    paramh.funcId = getType();
    this.rr = paramh.bEF();
    int i = dispatch(paramg, this.rr, this);
    if (i < 0) {
      Log.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
    }
    try
    {
      this.Ozy = null;
      dL(false);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(143797);
    try
    {
      this.Ozy = null;
      if ((com.tencent.mm.kernel.h.baD().mCm == null) || (com.tencent.mm.kernel.h.baD().mCm.oun == null))
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
      this.Ozy = ((cdm)c.c.b(this.rr.otC)).aanQ;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    finally
    {
      dL(false);
      AppMethodBeat.o(143797);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.g
 * JD-Core Version:    0.7.0.1
 */