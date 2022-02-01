package com.tencent.mm.plugin.report.c;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.sdk.platformtools.bs;

public final class h
  extends n
  implements k
{
  private static boolean isRunning;
  private static Object lock;
  private com.tencent.mm.ak.g callback;
  private com.tencent.mm.ak.b rr;
  private a wTt;
  private avi wTw;
  
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
    this.wTw = null;
    this.wTt = new a();
    setIsRunning(true);
    this.wTw = SmcProtoBufUtil.toMMGetStrategyReq();
    if (this.wTw != null)
    {
      this.wTw.EqY = new bjp();
      this.wTw.EqY.EYZ = a.MF(0);
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
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(143803);
    this.callback = paramg;
    com.tencent.mm.kernel.g.agP();
    boolean bool = com.tencent.mm.kernel.a.afX();
    if (!bool) {
      this.wTw.EqX = com.tencent.mm.bw.b.cc(bs.eWb());
    }
    b.a locala = new b.a();
    locala.hvv = false;
    locala.hvt = this.wTw;
    locala.hvu = new avj();
    if (bool) {
      paramg = "/cgi-bin/micromsg-bin/getkvidkeystrategy";
    }
    for (;;)
    {
      locala.uri = paramg;
      locala.funcId = getType();
      this.rr = locala.aAz();
      if (!bool)
      {
        this.rr.setRsaInfo(com.tencent.mm.protocal.ac.eRu());
        this.rr.option = 1;
      }
      int i = dispatch(parame, this.rr, this);
      if (i < 0) {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      }
      try
      {
        SmcLogic.OnStrategyResp(3, -1, null, 1);
        SmcLogic.OnStrategyResp(3, -1, null, 2);
        setIsRunning(false);
        AppMethodBeat.o(143803);
        return i;
        paramg = "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
      }
      catch (Exception parame)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bs.m(parame) });
        }
      }
    }
  }
  
  public final int getType()
  {
    AppMethodBeat.i(143802);
    com.tencent.mm.kernel.g.agP();
    if (com.tencent.mm.kernel.a.afX())
    {
      AppMethodBeat.o(143802);
      return 988;
    }
    AppMethodBeat.o(143802);
    return 989;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(143801);
    if ((com.tencent.mm.kernel.g.agQ().ghe == null) || (com.tencent.mm.kernel.g.agQ().ghe.hwg == null))
    {
      com.tencent.mm.sdk.platformtools.ac.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(143801);
      return;
    }
    if (paramInt2 != 0)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 1);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 2);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      setIsRunning(false);
      AppMethodBeat.o(143801);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
    paramArrayOfByte = (avj)this.rr.hvs.hvw;
    this.wTt.a(paramArrayOfByte.Eri, 0);
    try
    {
      paramq = SmcProtoBufUtil.toSmcKVStrategyResp(paramArrayOfByte);
      paramArrayOfByte = SmcProtoBufUtil.toSmcIdkeyStrategyResp(paramArrayOfByte);
      SmcLogic.OnStrategyResp(0, 0, paramq.toByteArray(), 1);
      SmcLogic.OnStrategyResp(0, 0, paramArrayOfByte.toByteArray(), 2);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      setIsRunning(false);
      AppMethodBeat.o(143801);
      return;
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bs.m(paramq) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.report.c.h
 * JD-Core Version:    0.7.0.1
 */