package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class z$1
  implements f.a
{
  z$1(z paramz) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    if (paramInt == -21005)
    {
      y.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.oqT.eoQ, Integer.valueOf(paramInt), paramc, paramd });
      this.oqT.dmL.onSceneEnd(3, -1, "doScene failed", this.oqT);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode == 0))
    {
      y.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.oqT.eoQ, Integer.valueOf(paramInt), paramc, paramd });
      this.oqT.a(paramd.field_fileUrl, 1, paramd.field_thumbUrl, 1, "upload_" + this.oqT.eoQ, paramd.field_filemd5);
      y.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - this.oqT.oqR) + " " + paramd.field_filemd5);
      new com.tencent.mm.h.b.a.f(a.n(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.oqT.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(this.oqT.eoR), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.dlG })).QX();
      this.oqT.dmL.onSceneEnd(0, 0, "doScene", this.oqT);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode != 0))
    {
      y.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.oqT.eoQ, Integer.valueOf(paramInt), paramc, paramd });
      if (this.oqT.oqS == 21)
      {
        if ((paramd.field_retCode > -10000) || (paramd.field_retCode <= -20000)) {
          break label674;
        }
        b.jdMethod_if(10);
      }
      for (;;)
      {
        z.a(this.oqT, paramd.field_retCode);
        paramString = a.n(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.oqT.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(this.oqT.eoR), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.dlG });
        new com.tencent.mm.h.b.a.f(paramString).QX();
        new com.tencent.mm.h.b.a.d(paramString).QX();
        this.oqT.dmL.onSceneEnd(3, -1, "doScene failed", this.oqT);
        return 0;
        label674:
        if ((paramd.field_retCode <= -20000) && (paramd.field_retCode >= -22000)) {
          b.jdMethod_if(11);
        } else if ((paramd.field_retCode <= -5103000) && (paramd.field_retCode >= -5103087)) {
          b.jdMethod_if(9);
        } else {
          b.jdMethod_if(15);
        }
      }
    }
    if (paramInt != 0)
    {
      y.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.oqT.eoQ, Integer.valueOf(paramInt), paramc, paramd });
      this.oqT.xF(0);
      if (paramd != null) {
        new com.tencent.mm.h.b.a.f(a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.oqT.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(this.oqT.eoR), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.dlG })).QX();
      }
      this.oqT.dmL.onSceneEnd(3, -1, "doScene failed", this.oqT);
      return 0;
    }
    y.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.oqT.eoQ, Integer.valueOf(paramInt), paramc, paramd });
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.z.1
 * JD-Core Version:    0.7.0.1
 */