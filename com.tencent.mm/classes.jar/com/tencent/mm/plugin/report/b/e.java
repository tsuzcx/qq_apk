package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends p
  implements m
{
  private acp Ozv;
  private a Ozw;
  private com.tencent.mm.am.h callback;
  private int channel;
  private boolean isLogin;
  private com.tencent.mm.am.c rr;
  
  public e(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(143791);
    this.isLogin = false;
    this.Ozv = null;
    this.channel = 0;
    this.Ozw = new a();
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("data must not be null");
      AppMethodBeat.o(143791);
      throw paramArrayOfByte;
    }
    this.channel = paramInt;
    com.tencent.mm.kernel.h.baC();
    this.isLogin = com.tencent.mm.kernel.b.aZM();
    if (paramInt == 1) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new i();
        ((i)localObject).parseFrom(paramArrayOfByte);
        this.Ozv = SmcProtoBufUtil.toMMReportKvReq((i)localObject);
        if (this.Ozv == null) {
          break;
        }
        this.Ozv.ZkZ = new czp();
        this.Ozv.ZkZ.aaEW = a.ahs(this.channel);
        AppMethodBeat.o(143791);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.NetSceneCliReportKV", "parse data error");
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(143789);
            SmcLogic.OnReportResp(3, -1, null, e.a(e.this));
            AppMethodBeat.o(143789);
          }
        });
        continue;
      }
      if (paramInt == 2) {
        try
        {
          localObject = new com.tencent.mm.protocal.a.a.g();
          ((com.tencent.mm.protocal.a.a.g)localObject).parseFrom(paramArrayOfByte);
          this.Ozv = SmcProtoBufUtil.toMMReportIdkeyReq((com.tencent.mm.protocal.a.a.g)localObject);
        }
        catch (Exception paramArrayOfByte)
        {
          Log.e("MicroMsg.NetSceneCliReportKV", "parse data error");
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(143790);
              SmcLogic.OnReportResp(3, -1, null, e.a(e.this));
              AppMethodBeat.o(143790);
            }
          });
        }
      }
    }
    Log.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", new Object[] { Util.getStack() });
    AppMethodBeat.o(143791);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(143793);
    this.callback = paramh;
    if (this.Ozv == null)
    {
      Log.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
      AppMethodBeat.o(143793);
      return -2;
    }
    if (!this.isLogin) {
      this.Ozv.ZkY = com.tencent.mm.bx.b.cX(Util.getUuidRandom());
    }
    c.a locala = new c.a();
    locala.otH = false;
    locala.otE = this.Ozv;
    locala.otF = new acq();
    if (1 == this.channel) {
      paramh = "/cgi-bin/micromsg-bin/newreportkvcomm";
    }
    for (;;)
    {
      String str;
      label111:
      int i;
      if (1 == this.channel)
      {
        str = "/cgi-bin/micromsg-bin/newreportkvcommrsa";
        if (!this.isLogin) {
          break label230;
        }
        locala.uri = paramh;
        locala.funcId = getType();
        this.rr = locala.bEF();
        if (!this.isLogin)
        {
          this.rr.setRsaInfo(ac.iQd());
          this.rr.option = 1;
        }
        i = dispatch(paramg, this.rr, this);
        if (i < 0) {
          Log.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
        }
      }
      try
      {
        SmcLogic.OnReportResp(3, -1, null, this.channel);
        AppMethodBeat.o(143793);
        return i;
        paramh = "/cgi-bin/micromsg-bin/newreportidkey";
        continue;
        str = "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        break label111;
        label230:
        paramh = str;
      }
      catch (Exception paramg)
      {
        for (;;)
        {
          Log.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), Util.stackTraceToString(paramg) });
        }
      }
    }
  }
  
  public final int getType()
  {
    if (!this.isLogin)
    {
      if (1 == this.channel) {
        return 997;
      }
      return 987;
    }
    if (1 == this.channel) {
      return 996;
    }
    return 986;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(143792);
    if ((com.tencent.mm.kernel.h.baD().mCm == null) || (com.tencent.mm.kernel.h.baD().mCm.oun == null))
    {
      Log.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(143792);
      return;
    }
    if (paramInt2 != 0)
    {
      Log.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnReportResp(paramInt2, paramInt3, null, this.channel);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(143792);
      return;
    }
    Log.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.channel);
    params = (acq)c.c.b(this.rr.otC);
    this.Ozw.a(params.Zlj, this.channel);
    try
    {
      if (this.channel == 1) {
        SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(params).toByteArray(), this.channel);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(143792);
        return;
        if (this.channel == 2) {
          SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(params).toByteArray(), this.channel);
        }
      }
    }
    catch (Exception params)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), Util.stackTraceToString(params) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.e
 * JD-Core Version:    0.7.0.1
 */