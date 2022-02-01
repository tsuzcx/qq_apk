package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.g.b.a.f;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;

final class y$1
  implements g.a
{
  y$1(y paramy) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(95671);
    if (paramInt == -21005)
    {
      ad.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.wGe.hhN, Integer.valueOf(paramInt), paramc, paramd });
      this.wGe.callback.onSceneEnd(3, -1, "doScene failed", this.wGe);
      AppMethodBeat.o(95671);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode == 0))
    {
      ad.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.wGe.hhN, Integer.valueOf(paramInt), paramc, paramd });
      this.wGe.a(paramd.field_fileUrl, 1, paramd.field_thumbUrl, 1, "upload_" + this.wGe.hhN, paramd.field_filemd5);
      ad.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - this.wGe.hZo) + " " + paramd.field_filemd5);
      new h(a.s(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.wGe.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.wGe.fLB), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.fns })).aBj();
      this.wGe.callback.onSceneEnd(0, 0, "doScene", this.wGe);
      AppMethodBeat.o(95671);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode != 0))
    {
      ad.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.wGe.hhN, Integer.valueOf(paramInt), paramc, paramd });
      if (this.wGe.wGd == 21)
      {
        if ((paramd.field_retCode > -10000) || (paramd.field_retCode <= -20000)) {
          break label694;
        }
        b.lI(10);
      }
      for (;;)
      {
        y.a(this.wGe, paramd.field_retCode);
        paramString = a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.wGe.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.wGe.fLB), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.fns });
        new h(paramString).aBj();
        new f(paramString).aBj();
        this.wGe.callback.onSceneEnd(3, -1, "doScene failed", this.wGe);
        AppMethodBeat.o(95671);
        return 0;
        label694:
        if ((paramd.field_retCode <= -20000) && (paramd.field_retCode >= -22000)) {
          b.lI(11);
        } else if ((paramd.field_retCode <= -5103000) && (paramd.field_retCode >= -5103087)) {
          b.lI(9);
        } else {
          b.lI(15);
        }
      }
    }
    if (paramInt != 0)
    {
      ad.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.wGe.hhN, Integer.valueOf(paramInt), paramc, paramd });
      this.wGe.Mf(0);
      if (paramd != null) {
        new h(a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.wGe.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.wGe.fLB), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.fns })).aBj();
      }
      this.wGe.callback.onSceneEnd(3, -1, "doScene failed", this.wGe);
      AppMethodBeat.o(95671);
      return 0;
    }
    ad.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.wGe.hhN, Integer.valueOf(paramInt), paramc, paramd });
    AppMethodBeat.o(95671);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.y.1
 * JD-Core Version:    0.7.0.1
 */