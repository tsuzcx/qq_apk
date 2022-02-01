package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.blg;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.protocal.protobuf.cbh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends q
  implements m
{
  private static boolean isRunning;
  private static Object lock;
  private a CxQ;
  private blg CxT;
  private i callback;
  private d rr;
  
  static
  {
    AppMethodBeat.i(143804);
    isRunning = false;
    lock = new Object();
    AppMethodBeat.o(143804);
  }
  
  public h()
  {
    AppMethodBeat.i(143800);
    this.CxT = null;
    this.CxQ = new a();
    setIsRunning(true);
    this.CxT = SmcProtoBufUtil.toMMGetStrategyReq();
    if (this.CxT != null)
    {
      this.CxT.LlD = new cbh();
      this.CxT.LlD.Mha = a.Wi(0);
    }
    AppMethodBeat.o(143800);
  }
  
  public static boolean isRunning()
  {
    synchronized (lock)
    {
      boolean bool = isRunning;
      return bool;
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
    AppMethodBeat.i(143803);
    this.callback = parami;
    com.tencent.mm.kernel.g.aAf();
    boolean bool = com.tencent.mm.kernel.a.azo();
    if (!bool) {
      this.CxT.LlC = com.tencent.mm.bw.b.cD(Util.getUuidRandom());
    }
    d.a locala = new d.a();
    locala.iLQ = false;
    locala.iLN = this.CxT;
    locala.iLO = new blh();
    if (bool) {
      parami = "/cgi-bin/micromsg-bin/getkvidkeystrategy";
    }
    for (;;)
    {
      locala.uri = parami;
      locala.funcId = getType();
      this.rr = locala.aXF();
      if (!bool)
      {
        this.rr.setRsaInfo(ac.gtS());
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
        setIsRunning(false);
        AppMethodBeat.o(143803);
        return i;
        parami = "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
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
    com.tencent.mm.kernel.g.aAf();
    if (com.tencent.mm.kernel.a.azo())
    {
      AppMethodBeat.o(143802);
      return 988;
    }
    AppMethodBeat.o(143802);
    return 989;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(143801);
    if ((com.tencent.mm.kernel.g.aAg().hqi == null) || (com.tencent.mm.kernel.g.aAg().hqi.iMw == null))
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
      setIsRunning(false);
      AppMethodBeat.o(143801);
      return;
    }
    Log.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
    paramArrayOfByte = (blh)this.rr.iLL.iLR;
    this.CxQ.a(paramArrayOfByte.LlN, 0);
    try
    {
      params = SmcProtoBufUtil.toSmcKVStrategyResp(paramArrayOfByte);
      paramArrayOfByte = SmcProtoBufUtil.toSmcIdkeyStrategyResp(paramArrayOfByte);
      SmcLogic.OnStrategyResp(0, 0, params.toByteArray(), 1);
      SmcLogic.OnStrategyResp(0, 0, paramArrayOfByte.toByteArray(), 2);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      setIsRunning(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.h
 * JD-Core Version:    0.7.0.1
 */