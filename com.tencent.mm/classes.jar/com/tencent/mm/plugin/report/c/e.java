package com.tencent.mm.plugin.report.c;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public final class e
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  int channel;
  private boolean qvS;
  private com.tencent.mm.ak.b rr;
  private wt wTs;
  private a wTt;
  
  public e(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(143791);
    this.qvS = false;
    this.wTs = null;
    this.channel = 0;
    this.wTt = new a();
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("data must not be null");
      AppMethodBeat.o(143791);
      throw paramArrayOfByte;
    }
    this.channel = paramInt;
    com.tencent.mm.kernel.g.agP();
    this.qvS = com.tencent.mm.kernel.a.afX();
    if (paramInt == 1) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new i();
        ((i)localObject).parseFrom(paramArrayOfByte);
        this.wTs = SmcProtoBufUtil.toMMReportKvReq((i)localObject);
        if (this.wTs == null) {
          break;
        }
        this.wTs.EqY = new bjp();
        this.wTs.EqY.EYZ = a.MF(this.channel);
        AppMethodBeat.o(143791);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneCliReportKV", "parse data error");
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agU().az(new Runnable()
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
          this.wTs = SmcProtoBufUtil.toMMReportIdkeyReq((com.tencent.mm.protocal.a.a.g)localObject);
        }
        catch (Exception paramArrayOfByte)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneCliReportKV", "parse data error");
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agU().az(new Runnable()
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", new Object[] { bs.eWi() });
    AppMethodBeat.o(143791);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(143793);
    this.callback = paramg;
    if (this.wTs == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
      AppMethodBeat.o(143793);
      return -2;
    }
    if (!this.qvS) {
      this.wTs.EqX = com.tencent.mm.bw.b.cc(bs.eWb());
    }
    b.a locala = new b.a();
    locala.hvv = false;
    locala.hvt = this.wTs;
    locala.hvu = new wu();
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
        if (!this.qvS) {
          break label230;
        }
        locala.uri = paramg;
        locala.funcId = getType();
        this.rr = locala.aAz();
        if (!this.qvS)
        {
          this.rr.setRsaInfo(com.tencent.mm.protocal.ac.eRu());
          this.rr.option = 1;
        }
        i = dispatch(parame, this.rr, this);
        if (i < 0) {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
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
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bs.m(parame) });
        }
      }
    }
  }
  
  public final int getType()
  {
    if (!this.qvS)
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
    if ((com.tencent.mm.kernel.g.agQ().ghe == null) || (com.tencent.mm.kernel.g.agQ().ghe.hwg == null))
    {
      com.tencent.mm.sdk.platformtools.ac.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(143792);
      return;
    }
    if (paramInt2 != 0)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnReportResp(paramInt2, paramInt3, null, this.channel);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(143792);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.channel);
    paramq = (wu)this.rr.hvs.hvw;
    this.wTt.a(paramq.Eri, this.channel);
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
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bs.m(paramq) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.report.c.e
 * JD-Core Version:    0.7.0.1
 */