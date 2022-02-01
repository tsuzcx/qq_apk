package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends p
  implements m
{
  private static boolean Uz;
  private static Object lock;
  private a Ozw;
  private chi Ozz;
  private com.tencent.mm.am.h callback;
  private com.tencent.mm.am.c rr;
  
  static
  {
    AppMethodBeat.i(143804);
    Uz = false;
    lock = new Object();
    AppMethodBeat.o(143804);
  }
  
  public h()
  {
    AppMethodBeat.i(143800);
    this.Ozz = null;
    this.Ozw = new a();
    dL(true);
    this.Ozz = SmcProtoBufUtil.toMMGetStrategyReq();
    if (this.Ozz != null)
    {
      this.Ozz.ZkZ = new czp();
      this.Ozz.ZkZ.aaEW = a.ahs(0);
    }
    AppMethodBeat.o(143800);
  }
  
  private static void dL(boolean paramBoolean)
  {
    synchronized (lock)
    {
      Uz = paramBoolean;
      return;
    }
  }
  
  public static boolean isRunning()
  {
    synchronized (lock)
    {
      boolean bool = Uz;
      return bool;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(143803);
    this.callback = paramh;
    com.tencent.mm.kernel.h.baC();
    boolean bool = com.tencent.mm.kernel.b.aZM();
    if (!bool) {
      this.Ozz.ZkY = com.tencent.mm.bx.b.cX(Util.getUuidRandom());
    }
    c.a locala = new c.a();
    locala.otH = false;
    locala.otE = this.Ozz;
    locala.otF = new chj();
    if (bool) {
      paramh = "/cgi-bin/micromsg-bin/getkvidkeystrategy";
    }
    for (;;)
    {
      locala.uri = paramh;
      locala.funcId = getType();
      this.rr = locala.bEF();
      if (!bool)
      {
        this.rr.setRsaInfo(ac.iQd());
        this.rr.option = 1;
      }
      int i = dispatch(paramg, this.rr, this);
      if (i < 0) {
        Log.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      }
      try
      {
        SmcLogic.OnStrategyResp(3, -1, null, 1);
        SmcLogic.OnStrategyResp(3, -1, null, 2);
        dL(false);
        AppMethodBeat.o(143803);
        return i;
        paramh = "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
      }
      catch (Exception paramg)
      {
        for (;;)
        {
          Log.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), Util.stackTraceToString(paramg) });
        }
      }
    }
  }
  
  public final int getType()
  {
    AppMethodBeat.i(143802);
    com.tencent.mm.kernel.h.baC();
    if (com.tencent.mm.kernel.b.aZM())
    {
      AppMethodBeat.o(143802);
      return 988;
    }
    AppMethodBeat.o(143802);
    return 989;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(143801);
    if ((com.tencent.mm.kernel.h.baD().mCm == null) || (com.tencent.mm.kernel.h.baD().mCm.oun == null))
    {
      Log.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(143801);
      return;
    }
    if (paramInt2 != 0)
    {
      Log.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 1);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 2);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      dL(false);
      AppMethodBeat.o(143801);
      return;
    }
    Log.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
    paramArrayOfByte = (chj)c.c.b(this.rr.otC);
    this.Ozw.a(paramArrayOfByte.Zlj, 0);
    try
    {
      params = SmcProtoBufUtil.toSmcKVStrategyResp(paramArrayOfByte);
      paramArrayOfByte = SmcProtoBufUtil.toSmcIdkeyStrategyResp(paramArrayOfByte);
      SmcLogic.OnStrategyResp(0, 0, params.toByteArray(), 1);
      SmcLogic.OnStrategyResp(0, 0, paramArrayOfByte.toByteArray(), 2);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      dL(false);
      AppMethodBeat.o(143801);
      return;
    }
    catch (Exception params)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), Util.stackTraceToString(params) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.h
 * JD-Core Version:    0.7.0.1
 */