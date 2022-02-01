package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
  extends n
  implements k
{
  private static boolean isRunning;
  private static Object lock;
  private com.tencent.mm.al.g callback;
  private com.tencent.mm.al.b rr;
  private a vJp;
  private ase vJs;
  
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
    this.vJs = null;
    this.vJp = new a();
    setIsRunning(true);
    this.vJs = SmcProtoBufUtil.toMMGetStrategyReq();
    if (this.vJs != null)
    {
      this.vJs.CYo = new bfx();
      this.vJs.CYo.DDD = a.KG(0);
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
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(143803);
    this.callback = paramg;
    com.tencent.mm.kernel.g.afz();
    boolean bool = com.tencent.mm.kernel.a.aeH();
    if (!bool) {
      this.vJs.CYn = com.tencent.mm.bx.b.cd(bt.eGG());
    }
    b.a locala = new b.a();
    locala.gUW = false;
    locala.gUU = this.vJs;
    locala.gUV = new asf();
    if (bool) {
      paramg = "/cgi-bin/micromsg-bin/getkvidkeystrategy";
    }
    for (;;)
    {
      locala.uri = paramg;
      locala.funcId = getType();
      this.rr = locala.atI();
      if (!bool)
      {
        this.rr.setRsaInfo(ac.eBZ());
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
        paramg = "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
      }
      catch (Exception parame)
      {
        for (;;)
        {
          ad.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bt.m(parame) });
        }
      }
    }
  }
  
  public final int getType()
  {
    AppMethodBeat.i(143802);
    com.tencent.mm.kernel.g.afz();
    if (com.tencent.mm.kernel.a.aeH())
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
    if ((com.tencent.mm.kernel.g.afA().gcy == null) || (com.tencent.mm.kernel.g.afA().gcy.gVH == null))
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
    paramArrayOfByte = (asf)this.rr.gUT.gUX;
    this.vJp.a(paramArrayOfByte.CYy, 0);
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
        ad.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bt.m(paramq) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.h
 * JD-Core Version:    0.7.0.1
 */