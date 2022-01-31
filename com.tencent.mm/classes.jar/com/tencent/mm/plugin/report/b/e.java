package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
  extends m
  implements k
{
  int cCy;
  private f callback;
  private boolean mgv;
  private tm qrY;
  private a qrZ;
  private com.tencent.mm.ai.b rr;
  
  public e(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(72675);
    this.mgv = false;
    this.qrY = null;
    this.cCy = 0;
    this.qrZ = new a();
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("data must not be null");
      AppMethodBeat.o(72675);
      throw paramArrayOfByte;
    }
    this.cCy = paramInt;
    com.tencent.mm.kernel.g.RJ();
    this.mgv = com.tencent.mm.kernel.a.QT();
    if (paramInt == 1) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new i();
        ((i)localObject).parseFrom(paramArrayOfByte);
        this.qrY = SmcProtoBufUtil.toMMReportKvReq((i)localObject);
        if (this.qrY == null) {
          break;
        }
        this.qrY.wLU = new auv();
        this.qrY.wLU.xkc = a.Cw(this.cCy);
        AppMethodBeat.o(72675);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ab.e("MicroMsg.NetSceneCliReportKV", "parse data error");
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RO().ac(new e.1(this));
        continue;
      }
      if (paramInt == 2) {
        try
        {
          localObject = new com.tencent.mm.protocal.a.a.g();
          ((com.tencent.mm.protocal.a.a.g)localObject).parseFrom(paramArrayOfByte);
          this.qrY = SmcProtoBufUtil.toMMReportIdkeyReq((com.tencent.mm.protocal.a.a.g)localObject);
        }
        catch (Exception paramArrayOfByte)
        {
          ab.e("MicroMsg.NetSceneCliReportKV", "parse data error");
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RO().ac(new e.2(this));
        }
      }
    }
    ab.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", new Object[] { bo.dtY() });
    AppMethodBeat.o(72675);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(72677);
    this.callback = paramf;
    if (this.qrY == null)
    {
      ab.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
      AppMethodBeat.o(72677);
      return -2;
    }
    if (!this.mgv) {
      this.qrY.wLT = com.tencent.mm.bv.b.bL(bo.dtR());
    }
    b.a locala = new b.a();
    locala.fsZ = false;
    locala.fsX = this.qrY;
    locala.fsY = new tn();
    if (1 == this.cCy) {
      paramf = "/cgi-bin/micromsg-bin/newreportkvcomm";
    }
    for (;;)
    {
      String str;
      label111:
      int i;
      if (1 == this.cCy)
      {
        str = "/cgi-bin/micromsg-bin/newreportkvcommrsa";
        if (!this.mgv) {
          break label230;
        }
        locala.uri = paramf;
        locala.funcId = getType();
        this.rr = locala.ado();
        if (!this.mgv)
        {
          this.rr.setRsaInfo(aa.dqF());
          this.rr.option = 1;
        }
        i = dispatch(parame, this.rr, this);
        if (i < 0) {
          ab.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
        }
      }
      try
      {
        SmcLogic.OnReportResp(3, -1, null, this.cCy);
        AppMethodBeat.o(72677);
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
          ab.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bo.l(parame) });
        }
      }
    }
  }
  
  public final int getType()
  {
    if (!this.mgv)
    {
      if (1 == this.cCy) {
        return 997;
      }
      return 987;
    }
    if (1 == this.cCy) {
      return 996;
    }
    return 986;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72676);
    if ((com.tencent.mm.kernel.g.RK().eHt == null) || (com.tencent.mm.kernel.g.RK().eHt.ftA == null))
    {
      ab.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(72676);
      return;
    }
    if (paramInt2 != 0)
    {
      ab.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnReportResp(paramInt2, paramInt3, null, this.cCy);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(72676);
      return;
    }
    ab.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.cCy);
    paramq = (tn)this.rr.fsW.fta;
    this.qrZ.a(paramq.wMe, this.cCy);
    try
    {
      if (this.cCy == 1) {
        SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(paramq).toByteArray(), this.cCy);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(72676);
        return;
        if (this.cCy == 2) {
          SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(paramq).toByteArray(), this.cCy);
        }
      }
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bo.l(paramq) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.e
 * JD-Core Version:    0.7.0.1
 */