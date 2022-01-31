package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.c.aed;
import com.tencent.mm.protocal.c.aee;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.sdk.platformtools.bk;

public final class h
  extends m
  implements k
{
  private static boolean isRunning = false;
  private static Object lock = new Object();
  private com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  private a nEX = new a();
  private aed nFb = null;
  
  public h()
  {
    iv(true);
    this.nFb = SmcProtoBufUtil.toMMGetStrategyReq();
    if (this.nFb != null)
    {
      this.nFb.sOa = new apa();
      this.nFb.sOa.tkU = a.wG(0);
    }
  }
  
  public static boolean isRunning()
  {
    synchronized (lock)
    {
      boolean bool = isRunning;
      return bool;
    }
  }
  
  private static void iv(boolean paramBoolean)
  {
    synchronized (lock)
    {
      isRunning = paramBoolean;
      return;
    }
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    g.DN();
    boolean bool = com.tencent.mm.kernel.a.Db();
    if (!bool) {
      this.nFb.sNZ = com.tencent.mm.bv.b.bk(bk.crT());
    }
    b.a locala = new b.a();
    locala.ecL = false;
    locala.ecH = this.nFb;
    locala.ecI = new aee();
    if (bool) {}
    int i;
    for (paramf = "/cgi-bin/micromsg-bin/getkvidkeystrategy";; paramf = "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa")
    {
      locala.uri = paramf;
      locala.ecG = getType();
      this.dmK = locala.Kt();
      if (!bool)
      {
        this.dmK.a(com.tencent.mm.protocal.y.cpi());
        this.dmK.ccs = 1;
      }
      i = a(parame, this.dmK, this);
      if (i < 0) {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      }
      try
      {
        SmcLogic.OnStrategyResp(3, -1, null, 1);
        SmcLogic.OnStrategyResp(3, -1, null, 2);
        iv(false);
        return i;
      }
      catch (Exception parame)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bk.j(parame) });
      }
    }
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((g.DO().dJT == null) || (g.DO().dJT.edx == null))
    {
      com.tencent.mm.sdk.platformtools.y.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramInt2 != 0)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 1);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 2);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      iv(false);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
    paramArrayOfByte = (aee)this.dmK.ecF.ecN;
    this.nEX.a(paramArrayOfByte.sOk, 0);
    try
    {
      paramq = SmcProtoBufUtil.toSmcKVStrategyResp(paramArrayOfByte);
      paramArrayOfByte = SmcProtoBufUtil.toSmcIdkeyStrategyResp(paramArrayOfByte);
      SmcLogic.OnStrategyResp(0, 0, paramq.toByteArray(), 1);
      SmcLogic.OnStrategyResp(0, 0, paramArrayOfByte.toByteArray(), 2);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      iv(false);
      return;
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bk.j(paramq) });
      }
    }
  }
  
  public final int getType()
  {
    g.DN();
    if (com.tencent.mm.kernel.a.Db()) {
      return 988;
    }
    return 989;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.h
 * JD-Core Version:    0.7.0.1
 */