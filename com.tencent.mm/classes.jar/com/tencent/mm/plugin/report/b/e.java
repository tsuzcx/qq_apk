package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.cbh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends q
  implements m
{
  private aak CxP;
  private a CxQ;
  private com.tencent.mm.ak.i callback;
  int channel;
  private d rr;
  private boolean sPq;
  
  public e(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(143791);
    this.sPq = false;
    this.CxP = null;
    this.channel = 0;
    this.CxQ = new a();
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("data must not be null");
      AppMethodBeat.o(143791);
      throw paramArrayOfByte;
    }
    this.channel = paramInt;
    com.tencent.mm.kernel.g.aAf();
    this.sPq = com.tencent.mm.kernel.a.azo();
    if (paramInt == 1) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new com.tencent.mm.protocal.a.a.i();
        ((com.tencent.mm.protocal.a.a.i)localObject).parseFrom(paramArrayOfByte);
        this.CxP = SmcProtoBufUtil.toMMReportKvReq((com.tencent.mm.protocal.a.a.i)localObject);
        if (this.CxP == null) {
          break;
        }
        this.CxP.LlD = new cbh();
        this.CxP.LlD.Mha = a.Wi(this.channel);
        AppMethodBeat.o(143791);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.NetSceneCliReportKV", "parse data error");
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(143789);
            SmcLogic.OnReportResp(3, -1, null, e.this.channel);
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
          this.CxP = SmcProtoBufUtil.toMMReportIdkeyReq((com.tencent.mm.protocal.a.a.g)localObject);
        }
        catch (Exception paramArrayOfByte)
        {
          Log.e("MicroMsg.NetSceneCliReportKV", "parse data error");
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(143790);
              SmcLogic.OnReportResp(3, -1, null, e.this.channel);
              AppMethodBeat.o(143790);
            }
          });
        }
      }
    }
    Log.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", new Object[] { Util.getStack() });
    AppMethodBeat.o(143791);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(143793);
    this.callback = parami;
    if (this.CxP == null)
    {
      Log.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
      AppMethodBeat.o(143793);
      return -2;
    }
    if (!this.sPq) {
      this.CxP.LlC = com.tencent.mm.bw.b.cD(Util.getUuidRandom());
    }
    d.a locala = new d.a();
    locala.iLQ = false;
    locala.iLN = this.CxP;
    locala.iLO = new aal();
    if (1 == this.channel) {
      parami = "/cgi-bin/micromsg-bin/newreportkvcomm";
    }
    for (;;)
    {
      String str;
      label111:
      int i;
      if (1 == this.channel)
      {
        str = "/cgi-bin/micromsg-bin/newreportkvcommrsa";
        if (!this.sPq) {
          break label230;
        }
        locala.uri = parami;
        locala.funcId = getType();
        this.rr = locala.aXF();
        if (!this.sPq)
        {
          this.rr.setRsaInfo(ac.gtS());
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
        parami = "/cgi-bin/micromsg-bin/newreportidkey";
        continue;
        str = "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        break label111;
        label230:
        parami = str;
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
    if (!this.sPq)
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(143792);
    if ((com.tencent.mm.kernel.g.aAg().hqi == null) || (com.tencent.mm.kernel.g.aAg().hqi.iMw == null))
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
    params = (aal)this.rr.iLL.iLR;
    this.CxQ.a(params.LlN, this.channel);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.e
 * JD-Core Version:    0.7.0.1
 */