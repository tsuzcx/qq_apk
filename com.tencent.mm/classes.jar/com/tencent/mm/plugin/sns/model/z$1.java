package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;

final class z$1
  implements g.a
{
  z$1(z paramz) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(36345);
    if (paramInt == -21005)
    {
      ab.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.rfE.fFo, Integer.valueOf(paramInt), paramc, paramd });
      this.rfE.callback.onSceneEnd(3, -1, "doScene failed", this.rfE);
      AppMethodBeat.o(36345);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode == 0))
    {
      ab.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.rfE.fFo, Integer.valueOf(paramInt), paramc, paramd });
      this.rfE.a(paramd.field_fileUrl, 1, paramd.field_thumbUrl, 1, "upload_" + this.rfE.fFo, paramd.field_filemd5);
      ab.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - this.rfE.rfC) + " " + paramd.field_filemd5);
      new com.tencent.mm.g.b.a.f(a.s(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.rfE.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.rfE.fFp), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb })).ake();
      this.rfE.callback.onSceneEnd(0, 0, "doScene", this.rfE);
      AppMethodBeat.o(36345);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode != 0))
    {
      ab.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.rfE.fFo, Integer.valueOf(paramInt), paramc, paramd });
      if (this.rfE.rfD == 21)
      {
        if ((paramd.field_retCode > -10000) || (paramd.field_retCode <= -20000)) {
          break label694;
        }
        b.kS(10);
      }
      for (;;)
      {
        z.a(this.rfE, paramd.field_retCode);
        paramString = a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.rfE.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.rfE.fFp), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb });
        new com.tencent.mm.g.b.a.f(paramString).ake();
        new com.tencent.mm.g.b.a.d(paramString).ake();
        this.rfE.callback.onSceneEnd(3, -1, "doScene failed", this.rfE);
        AppMethodBeat.o(36345);
        return 0;
        label694:
        if ((paramd.field_retCode <= -20000) && (paramd.field_retCode >= -22000)) {
          b.kS(11);
        } else if ((paramd.field_retCode <= -5103000) && (paramd.field_retCode >= -5103087)) {
          b.kS(9);
        } else {
          b.kS(15);
        }
      }
    }
    if (paramInt != 0)
    {
      ab.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.rfE.fFo, Integer.valueOf(paramInt), paramc, paramd });
      this.rfE.DF(0);
      if (paramd != null) {
        new com.tencent.mm.g.b.a.f(a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.rfE.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.rfE.fFp), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb })).ake();
      }
      this.rfE.callback.onSceneEnd(3, -1, "doScene failed", this.rfE);
      AppMethodBeat.o(36345);
      return 0;
    }
    ab.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.rfE.fFo, Integer.valueOf(paramInt), paramc, paramd });
    AppMethodBeat.o(36345);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.z.1
 * JD-Core Version:    0.7.0.1
 */