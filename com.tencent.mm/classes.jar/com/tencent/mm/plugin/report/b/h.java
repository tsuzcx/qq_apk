package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h
  extends m
  implements k
{
  private static boolean isRunning;
  private static Object lock;
  private com.tencent.mm.ai.f callback;
  private a qrZ;
  private aix qsd;
  private com.tencent.mm.ai.b rr;
  
  static
  {
    AppMethodBeat.i(72688);
    isRunning = false;
    lock = new Object();
    AppMethodBeat.o(72688);
  }
  
  public h()
  {
    AppMethodBeat.i(72684);
    this.qsd = null;
    this.qrZ = new a();
    setIsRunning(true);
    this.qsd = SmcProtoBufUtil.toMMGetStrategyReq();
    if (this.qsd != null)
    {
      this.qsd.wLU = new auv();
      this.qsd.wLU.xkc = a.Cw(0);
    }
    AppMethodBeat.o(72684);
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
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(72687);
    this.callback = paramf;
    g.RJ();
    boolean bool = com.tencent.mm.kernel.a.QT();
    if (!bool) {
      this.qsd.wLT = com.tencent.mm.bv.b.bL(bo.dtR());
    }
    b.a locala = new b.a();
    locala.fsZ = false;
    locala.fsX = this.qsd;
    locala.fsY = new aiy();
    if (bool) {
      paramf = "/cgi-bin/micromsg-bin/getkvidkeystrategy";
    }
    for (;;)
    {
      locala.uri = paramf;
      locala.funcId = getType();
      this.rr = locala.ado();
      if (!bool)
      {
        this.rr.setRsaInfo(aa.dqF());
        this.rr.option = 1;
      }
      int i = dispatch(parame, this.rr, this);
      if (i < 0) {
        ab.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      }
      try
      {
        SmcLogic.OnStrategyResp(3, -1, null, 1);
        SmcLogic.OnStrategyResp(3, -1, null, 2);
        setIsRunning(false);
        AppMethodBeat.o(72687);
        return i;
        paramf = "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
      }
      catch (Exception parame)
      {
        for (;;)
        {
          ab.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bo.l(parame) });
        }
      }
    }
  }
  
  public final int getType()
  {
    AppMethodBeat.i(72686);
    g.RJ();
    if (com.tencent.mm.kernel.a.QT())
    {
      AppMethodBeat.o(72686);
      return 988;
    }
    AppMethodBeat.o(72686);
    return 989;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72685);
    if ((g.RK().eHt == null) || (g.RK().eHt.ftA == null))
    {
      ab.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(72685);
      return;
    }
    if (paramInt2 != 0)
    {
      ab.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 1);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 2);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      setIsRunning(false);
      AppMethodBeat.o(72685);
      return;
    }
    ab.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
    paramArrayOfByte = (aiy)this.rr.fsW.fta;
    this.qrZ.a(paramArrayOfByte.wMe, 0);
    try
    {
      paramq = SmcProtoBufUtil.toSmcKVStrategyResp(paramArrayOfByte);
      paramArrayOfByte = SmcProtoBufUtil.toSmcIdkeyStrategyResp(paramArrayOfByte);
      SmcLogic.OnStrategyResp(0, 0, paramq.toByteArray(), 1);
      SmcLogic.OnStrategyResp(0, 0, paramArrayOfByte.toByteArray(), 2);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      setIsRunning(false);
      AppMethodBeat.o(72685);
      return;
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bo.l(paramq) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.h
 * JD-Core Version:    0.7.0.1
 */