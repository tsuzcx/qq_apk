package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;

final class ai$1
  implements f.a
{
  ai$1(ai paramai) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    y.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.rUR.eoQ, Integer.valueOf(paramInt), paramc, paramd });
    if (paramInt == -21005)
    {
      y.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.rUR.eoQ });
      return 0;
    }
    if (paramInt != 0)
    {
      this.rUR.bWO.setStatus(5);
      com.tencent.mm.plugin.report.f.nEG.a(111L, 34L, 1L, true);
      au.Hx();
      com.tencent.mm.model.c.Fy().a(this.rUR.bWO.field_msgId, this.rUR.bWO);
      new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.rUR.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_FILE), Integer.valueOf(0), "" })).QX();
      this.rUR.dmL.onSceneEnd(3, paramInt, "", this.rUR);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode != 0)
      {
        y.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, "", "", "", "", "", "", "", paramd.dlG });
        this.rUR.bWO.setStatus(5);
        com.tencent.mm.plugin.report.f.nEG.a(111L, 34L, 1L, true);
        au.Hx();
        com.tencent.mm.model.c.Fy().a(this.rUR.bWO.field_msgId, this.rUR.bWO);
        paramString = com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.rUR.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_FILE), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.dlG });
        new com.tencent.mm.h.b.a.f(paramString).QX();
        new com.tencent.mm.h.b.a.d(paramString).QX();
        this.rUR.dmL.onSceneEnd(3, paramd.field_retCode, "", this.rUR);
      }
    }
    else {
      return 0;
    }
    if ((this.rUR.eGn > 0) && (paramd.field_fileLength > 0))
    {
      paramString = this.rUR.eGn + "," + paramd.field_fileLength + "," + paramd.field_fileId;
      if (this.rUR.eGn * 2 <= paramd.field_fileLength) {
        break label782;
      }
    }
    label782:
    for (boolean bool = true;; bool = false)
    {
      al.x("SendAppMsgThumbTooBig", paramString, bool);
      y.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Boolean.valueOf(paramBoolean), Boolean.valueOf(paramd.field_exist_whencheck), bk.aac(paramd.field_aesKey), paramd.field_filemd5 });
      au.Dk().a(new aj(this.rUR.bIt, false, paramd, new ai.1.1(this, paramd), this.rUR.fKV, null), 0);
      break;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ai.1
 * JD-Core Version:    0.7.0.1
 */