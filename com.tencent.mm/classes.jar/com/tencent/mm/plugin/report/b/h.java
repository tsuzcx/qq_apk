package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.bnx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
  extends n
  implements k
{
  private static boolean isRunning;
  private static Object lock;
  private com.tencent.mm.al.f callback;
  private com.tencent.mm.al.b rr;
  private a yhd;
  private azg yhg;
  
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
    this.yhg = null;
    this.yhd = new a();
    setIsRunning(true);
    this.yhg = SmcProtoBufUtil.toMMGetStrategyReq();
    if (this.yhg != null)
    {
      this.yhg.FYi = new bnx();
      this.yhg.FYi.GIv = a.Oh(0);
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
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(143803);
    this.callback = paramf;
    g.ajA();
    boolean bool = com.tencent.mm.kernel.a.aiJ();
    if (!bool) {
      this.yhg.FYh = com.tencent.mm.bx.b.cj(bt.flL());
    }
    b.a locala = new b.a();
    locala.hNP = false;
    locala.hNM = this.yhg;
    locala.hNN = new azh();
    if (bool) {
      paramf = "/cgi-bin/micromsg-bin/getkvidkeystrategy";
    }
    for (;;)
    {
      locala.uri = paramf;
      locala.funcId = getType();
      this.rr = locala.aDC();
      if (!bool)
      {
        this.rr.setRsaInfo(ac.fgy());
        this.rr.option = 1;
      }
      int i = dispatch(parame, this.rr, this);
      if (i < 0) {
        ad.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      }
      try
      {
        SmcLogic.OnStrategyResp(3, -1, null, 1);
        SmcLogic.OnStrategyResp(3, -1, null, 2);
        setIsRunning(false);
        AppMethodBeat.o(143803);
        return i;
        paramf = "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
      }
      catch (Exception parame)
      {
        for (;;)
        {
          ad.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bt.n(parame) });
        }
      }
    }
  }
  
  public final int getType()
  {
    AppMethodBeat.i(143802);
    g.ajA();
    if (com.tencent.mm.kernel.a.aiJ())
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
    if ((g.ajB().gAO == null) || (g.ajB().gAO.hOv == null))
    {
      ad.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(143801);
      return;
    }
    if (paramInt2 != 0)
    {
      ad.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 1);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 2);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      setIsRunning(false);
      AppMethodBeat.o(143801);
      return;
    }
    ad.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
    paramArrayOfByte = (azh)this.rr.hNL.hNQ;
    this.yhd.a(paramArrayOfByte.FYs, 0);
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
        ad.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bt.n(paramq) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.h
 * JD-Core Version:    0.7.0.1
 */