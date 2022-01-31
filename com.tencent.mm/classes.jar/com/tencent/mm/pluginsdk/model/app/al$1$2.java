package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class al$1$2
  implements aa.a
{
  al$1$2(al.1 param1, int paramInt) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    String str1 = bk.aac(paramString2);
    String str2 = bk.aac(paramString3);
    String str3 = bk.aac(paramString4);
    String str4 = bk.aac(paramString5);
    if (this.rVa.rUZ.bFI == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramString1, str1, str2, str3, str4, Boolean.valueOf(bool), Boolean.valueOf(this.rVa.rUZ.epi) });
      if (!bk.bl(paramString3))
      {
        this.rVa.rUZ.rUA.field_signature = paramString3;
        this.rVa.rUZ.rUA.field_fakeAeskey = paramString4;
        this.rVa.rUZ.rUA.field_fakeSignature = paramString5;
        this.rVa.rUZ.rUA.field_lastModifyTime = bk.UY();
        if (this.rVa.rUZ.bFI != null)
        {
          this.rVa.rUZ.bFI.filemd5 = paramString1;
          this.rVa.rUZ.bFI.dQR = paramString2;
          this.rVa.rUZ.bFI.dQv = ((int)paramLong);
          au.Hx();
          paramString1 = com.tencent.mm.model.c.Fy().fd(this.rVa.rUZ.rUA.field_msgInfoId);
          paramString1.setContent(g.a.a(this.rVa.rUZ.bFI, null, null));
          au.Hx();
          com.tencent.mm.model.c.Fy().a(paramString1.field_msgId, paramString1);
        }
      }
      this.rVa.rUZ.epi = false;
      bool = ap.avh().c(this.rVa.rUZ.rUA, new String[0]);
      if (bool) {
        break;
      }
      y.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + bool);
      this.rVa.rUZ.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      this.rVa.rUZ.dmL.onSceneEnd(3, this.iIk, "", this.rVa.rUZ);
      return;
    }
    au.DS().O(new al.1.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al.1.2
 * JD-Core Version:    0.7.0.1
 */