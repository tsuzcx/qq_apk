package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.protocal.c.qh;
import com.tencent.mm.protocal.c.qi;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;

public final class e
  extends m
  implements k
{
  int bUR = 0;
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private boolean jMp = false;
  private qh nEW = null;
  private a nEX = new a();
  
  public e(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("data must not be null");
    }
    this.bUR = paramInt;
    com.tencent.mm.kernel.g.DN();
    this.jMp = com.tencent.mm.kernel.a.Db();
    if (paramInt == 1) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new i();
        ((i)localObject).aH(paramArrayOfByte);
        this.nEW = SmcProtoBufUtil.toMMReportKvReq((i)localObject);
        if (this.nEW == null) {
          break;
        }
        this.nEW.sOa = new apa();
        this.nEW.sOa.tkU = a.wG(this.bUR);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneCliReportKV", "parse data error");
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DS().O(new e.1(this));
        continue;
      }
      if (paramInt == 2) {
        try
        {
          localObject = new com.tencent.mm.protocal.a.a.g();
          ((com.tencent.mm.protocal.a.a.g)localObject).aH(paramArrayOfByte);
          this.nEW = SmcProtoBufUtil.toMMReportIdkeyReq((com.tencent.mm.protocal.a.a.g)localObject);
        }
        catch (Exception paramArrayOfByte)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneCliReportKV", "parse data error");
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DS().O(new e.2(this));
        }
      }
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", new Object[] { bk.csb() });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    int i;
    if (this.nEW == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
      i = -2;
      return i;
    }
    if (!this.jMp) {
      this.nEW.sNZ = com.tencent.mm.bv.b.bk(bk.crT());
    }
    b.a locala = new b.a();
    locala.ecL = false;
    locala.ecH = this.nEW;
    locala.ecI = new qi();
    label91:
    String str;
    if (1 == this.bUR)
    {
      paramf = "/cgi-bin/micromsg-bin/newreportkvcomm";
      if (1 != this.bUR) {
        break label249;
      }
      str = "/cgi-bin/micromsg-bin/newreportkvcommrsa";
      label103:
      if (!this.jMp) {
        break label256;
      }
    }
    for (;;)
    {
      locala.uri = paramf;
      locala.ecG = getType();
      this.dmK = locala.Kt();
      if (!this.jMp)
      {
        this.dmK.a(com.tencent.mm.protocal.y.cpi());
        this.dmK.ccs = 1;
      }
      int j = a(parame, this.dmK, this);
      i = j;
      if (j >= 0) {
        break;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", new Object[] { Integer.valueOf(j) });
      try
      {
        SmcLogic.OnReportResp(3, -1, null, this.bUR);
        return j;
      }
      catch (Exception parame)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bk.j(parame) });
        return j;
      }
      paramf = "/cgi-bin/micromsg-bin/newreportidkey";
      break label91;
      label249:
      str = "/cgi-bin/micromsg-bin/newreportidkeyrsa";
      break label103;
      label256:
      paramf = str;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((com.tencent.mm.kernel.g.DO().dJT == null) || (com.tencent.mm.kernel.g.DO().dJT.edx == null))
    {
      com.tencent.mm.sdk.platformtools.y.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramInt2 != 0)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
      SmcLogic.OnReportResp(paramInt2, paramInt3, null, this.bUR);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.bUR);
    paramq = (qi)this.dmK.ecF.ecN;
    this.nEX.a(paramq.sOk, this.bUR);
    try
    {
      if (this.bUR == 1) {
        SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(paramq).toByteArray(), this.bUR);
      }
      for (;;)
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        if (this.bUR == 2) {
          SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(paramq).toByteArray(), this.bUR);
        }
      }
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bk.j(paramq) });
      }
    }
  }
  
  public final int getType()
  {
    if (!this.jMp)
    {
      if (1 == this.bUR) {
        return 997;
      }
      return 987;
    }
    if (1 == this.bUR) {
      return 996;
    }
    return 986;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.e
 * JD-Core Version:    0.7.0.1
 */