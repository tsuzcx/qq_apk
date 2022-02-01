package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class h
  extends n
  implements k
{
  private static boolean isRunning;
  private static Object lock;
  private com.tencent.mm.ak.f callback;
  private com.tencent.mm.ak.b rr;
  private a ywU;
  private azw ywX;
  
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
    this.ywX = null;
    this.ywU = new a();
    setIsRunning(true);
    this.ywX = SmcProtoBufUtil.toMMGetStrategyReq();
    if (this.ywX != null)
    {
      this.ywX.GqH = new bop();
      this.ywX.GqH.HbX = a.ON(0);
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
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(143803);
    this.callback = paramf;
    g.ajP();
    boolean bool = com.tencent.mm.kernel.a.aiY();
    if (!bool) {
      this.ywX.GqG = com.tencent.mm.bw.b.cm(bu.fpG());
    }
    b.a locala = new b.a();
    locala.hQI = false;
    locala.hQF = this.ywX;
    locala.hQG = new azx();
    if (bool) {
      paramf = "/cgi-bin/micromsg-bin/getkvidkeystrategy";
    }
    for (;;)
    {
      locala.uri = paramf;
      locala.funcId = getType();
      this.rr = locala.aDS();
      if (!bool)
      {
        this.rr.setRsaInfo(ac.fko());
        this.rr.option = 1;
      }
      int i = dispatch(parame, this.rr, this);
      if (i < 0) {
        ae.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
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
          ae.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bu.o(parame) });
        }
      }
    }
  }
  
  public final int getType()
  {
    AppMethodBeat.i(143802);
    g.ajP();
    if (com.tencent.mm.kernel.a.aiY())
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
    if ((g.ajQ().gDv == null) || (g.ajQ().gDv.hRo == null))
    {
      ae.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(143801);
      return;
    }
    if (paramInt2 != 0)
    {
      ae.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 1);
      SmcLogic.OnStrategyResp(paramInt2, paramInt3, null, 2);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      setIsRunning(false);
      AppMethodBeat.o(143801);
      return;
    }
    ae.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
    paramArrayOfByte = (azx)this.rr.hQE.hQJ;
    this.ywU.a(paramArrayOfByte.GqR, 0);
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
        ae.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bu.o(paramq) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.h
 * JD-Core Version:    0.7.0.1
 */