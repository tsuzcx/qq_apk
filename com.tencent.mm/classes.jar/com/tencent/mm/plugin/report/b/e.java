package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.bnx;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.protocal.protobuf.yt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends n
  implements k
{
  private f callback;
  int channel;
  private boolean rfI;
  private com.tencent.mm.al.b rr;
  private ys yhc;
  private a yhd;
  
  public e(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(143791);
    this.rfI = false;
    this.yhc = null;
    this.channel = 0;
    this.yhd = new a();
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("data must not be null");
      AppMethodBeat.o(143791);
      throw paramArrayOfByte;
    }
    this.channel = paramInt;
    com.tencent.mm.kernel.g.ajA();
    this.rfI = com.tencent.mm.kernel.a.aiJ();
    if (paramInt == 1) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new i();
        ((i)localObject).parseFrom(paramArrayOfByte);
        this.yhc = SmcProtoBufUtil.toMMReportKvReq((i)localObject);
        if (this.yhc == null) {
          break;
        }
        this.yhc.FYi = new bnx();
        this.yhc.FYi.GIv = a.Oh(this.channel);
        AppMethodBeat.o(143791);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ad.e("MicroMsg.NetSceneCliReportKV", "parse data error");
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajF().ay(new Runnable()
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
          this.yhc = SmcProtoBufUtil.toMMReportIdkeyReq((com.tencent.mm.protocal.a.a.g)localObject);
        }
        catch (Exception paramArrayOfByte)
        {
          ad.e("MicroMsg.NetSceneCliReportKV", "parse data error");
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajF().ay(new Runnable()
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
    ad.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", new Object[] { bt.flS() });
    AppMethodBeat.o(143791);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(143793);
    this.callback = paramf;
    if (this.yhc == null)
    {
      ad.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
      AppMethodBeat.o(143793);
      return -2;
    }
    if (!this.rfI) {
      this.yhc.FYh = com.tencent.mm.bx.b.cj(bt.flL());
    }
    b.a locala = new b.a();
    locala.hNP = false;
    locala.hNM = this.yhc;
    locala.hNN = new yt();
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
        if (!this.rfI) {
          break label230;
        }
        locala.uri = paramf;
        locala.funcId = getType();
        this.rr = locala.aDC();
        if (!this.rfI)
        {
          this.rr.setRsaInfo(ac.fgy());
          this.rr.option = 1;
        }
        i = dispatch(parame, this.rr, this);
        if (i < 0) {
          ad.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
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
          ad.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bt.n(parame) });
        }
      }
    }
  }
  
  public final int getType()
  {
    if (!this.rfI)
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
    if ((com.tencent.mm.kernel.g.ajB().gAO == null) || (com.tencent.mm.kernel.g.ajB().gAO.hOv == null))
    {
      ad.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(143792);
      return;
    }
    if (paramInt2 != 0)
    {
      ad.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnReportResp(paramInt2, paramInt3, null, this.channel);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(143792);
      return;
    }
    ad.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.channel);
    paramq = (yt)this.rr.hNL.hNQ;
    this.yhd.a(paramq.FYs, this.channel);
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
        ad.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bt.n(paramq) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.e
 * JD-Core Version:    0.7.0.1
 */