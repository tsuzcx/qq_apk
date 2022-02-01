package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.protocal.protobuf.wj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  int channel;
  private boolean pNk;
  private com.tencent.mm.al.b rr;
  private wi vJo;
  private a vJp;
  
  public e(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(143791);
    this.pNk = false;
    this.vJo = null;
    this.channel = 0;
    this.vJp = new a();
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("data must not be null");
      AppMethodBeat.o(143791);
      throw paramArrayOfByte;
    }
    this.channel = paramInt;
    com.tencent.mm.kernel.g.afz();
    this.pNk = com.tencent.mm.kernel.a.aeH();
    if (paramInt == 1) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new i();
        ((i)localObject).parseFrom(paramArrayOfByte);
        this.vJo = SmcProtoBufUtil.toMMReportKvReq((i)localObject);
        if (this.vJo == null) {
          break;
        }
        this.vJo.CYo = new bfx();
        this.vJo.CYo.DDD = a.KG(this.channel);
        AppMethodBeat.o(143791);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ad.e("MicroMsg.NetSceneCliReportKV", "parse data error");
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afE().ax(new Runnable()
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
          this.vJo = SmcProtoBufUtil.toMMReportIdkeyReq((com.tencent.mm.protocal.a.a.g)localObject);
        }
        catch (Exception paramArrayOfByte)
        {
          ad.e("MicroMsg.NetSceneCliReportKV", "parse data error");
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afE().ax(new Runnable()
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
    ad.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", new Object[] { bt.eGN() });
    AppMethodBeat.o(143791);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(143793);
    this.callback = paramg;
    if (this.vJo == null)
    {
      ad.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
      AppMethodBeat.o(143793);
      return -2;
    }
    if (!this.pNk) {
      this.vJo.CYn = com.tencent.mm.bx.b.cd(bt.eGG());
    }
    b.a locala = new b.a();
    locala.gUW = false;
    locala.gUU = this.vJo;
    locala.gUV = new wj();
    if (1 == this.channel) {
      paramg = "/cgi-bin/micromsg-bin/newreportkvcomm";
    }
    for (;;)
    {
      String str;
      label111:
      int i;
      if (1 == this.channel)
      {
        str = "/cgi-bin/micromsg-bin/newreportkvcommrsa";
        if (!this.pNk) {
          break label230;
        }
        locala.uri = paramg;
        locala.funcId = getType();
        this.rr = locala.atI();
        if (!this.pNk)
        {
          this.rr.setRsaInfo(ac.eBZ());
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
        paramg = "/cgi-bin/micromsg-bin/newreportidkey";
        continue;
        str = "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        break label111;
        label230:
        paramg = str;
      }
      catch (Exception parame)
      {
        for (;;)
        {
          ad.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bt.m(parame) });
        }
      }
    }
  }
  
  public final int getType()
  {
    if (!this.pNk)
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
    if ((com.tencent.mm.kernel.g.afA().gcy == null) || (com.tencent.mm.kernel.g.afA().gcy.gVH == null))
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
    paramq = (wj)this.rr.gUT.gUX;
    this.vJp.a(paramq.CYy, this.channel);
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
        ad.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bt.m(paramq) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.e
 * JD-Core Version:    0.7.0.1
 */