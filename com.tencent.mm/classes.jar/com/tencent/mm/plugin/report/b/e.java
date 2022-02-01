package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
  extends n
  implements k
{
  private f callback;
  int channel;
  private boolean rnL;
  private com.tencent.mm.ak.b rr;
  private yv ywT;
  private a ywU;
  
  public e(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(143791);
    this.rnL = false;
    this.ywT = null;
    this.channel = 0;
    this.ywU = new a();
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("data must not be null");
      AppMethodBeat.o(143791);
      throw paramArrayOfByte;
    }
    this.channel = paramInt;
    com.tencent.mm.kernel.g.ajP();
    this.rnL = com.tencent.mm.kernel.a.aiY();
    if (paramInt == 1) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new i();
        ((i)localObject).parseFrom(paramArrayOfByte);
        this.ywT = SmcProtoBufUtil.toMMReportKvReq((i)localObject);
        if (this.ywT == null) {
          break;
        }
        this.ywT.GqH = new bop();
        this.ywT.GqH.HbX = a.ON(this.channel);
        AppMethodBeat.o(143791);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ae.e("MicroMsg.NetSceneCliReportKV", "parse data error");
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajU().aw(new Runnable()
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
          this.ywT = SmcProtoBufUtil.toMMReportIdkeyReq((com.tencent.mm.protocal.a.a.g)localObject);
        }
        catch (Exception paramArrayOfByte)
        {
          ae.e("MicroMsg.NetSceneCliReportKV", "parse data error");
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajU().aw(new Runnable()
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
    ae.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", new Object[] { bu.fpN() });
    AppMethodBeat.o(143791);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(143793);
    this.callback = paramf;
    if (this.ywT == null)
    {
      ae.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
      AppMethodBeat.o(143793);
      return -2;
    }
    if (!this.rnL) {
      this.ywT.GqG = com.tencent.mm.bw.b.cm(bu.fpG());
    }
    b.a locala = new b.a();
    locala.hQI = false;
    locala.hQF = this.ywT;
    locala.hQG = new yw();
    if (1 == this.channel) {
      paramf = "/cgi-bin/micromsg-bin/newreportkvcomm";
    }
    for (;;)
    {
      String str;
      label111:
      int i;
      if (1 == this.channel)
      {
        str = "/cgi-bin/micromsg-bin/newreportkvcommrsa";
        if (!this.rnL) {
          break label230;
        }
        locala.uri = paramf;
        locala.funcId = getType();
        this.rr = locala.aDS();
        if (!this.rnL)
        {
          this.rr.setRsaInfo(ac.fko());
          this.rr.option = 1;
        }
        i = dispatch(parame, this.rr, this);
        if (i < 0) {
          ae.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
        }
      }
      try
      {
        SmcLogic.OnReportResp(3, -1, null, this.channel);
        AppMethodBeat.o(143793);
        return i;
        paramf = "/cgi-bin/micromsg-bin/newreportidkey";
        continue;
        str = "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        break label111;
        label230:
        paramf = str;
      }
      catch (Exception parame)
      {
        for (;;)
        {
          ae.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bu.o(parame) });
        }
      }
    }
  }
  
  public final int getType()
  {
    if (!this.rnL)
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(143792);
    if ((com.tencent.mm.kernel.g.ajQ().gDv == null) || (com.tencent.mm.kernel.g.ajQ().gDv.hRo == null))
    {
      ae.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(143792);
      return;
    }
    if (paramInt2 != 0)
    {
      ae.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnReportResp(paramInt2, paramInt3, null, this.channel);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(143792);
      return;
    }
    ae.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.channel);
    paramq = (yw)this.rr.hQE.hQJ;
    this.ywU.a(paramq.GqR, this.channel);
    try
    {
      if (this.channel == 1) {
        SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(paramq).toByteArray(), this.channel);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(143792);
        return;
        if (this.channel == 2) {
          SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(paramq).toByteArray(), this.channel);
        }
      }
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        ae.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bu.o(paramq) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.e
 * JD-Core Version:    0.7.0.1
 */