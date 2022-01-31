package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.j.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class al$1$1
  implements aa.a
{
  al$1$1(al.1 param1, int paramInt, d paramd) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    boolean bool = true;
    paramString2 = bk.aac(paramString2);
    String str1 = bk.aac(paramString3);
    String str2 = bk.aac(paramString4);
    String str3 = bk.aac(paramString5);
    if (this.rVa.rUZ.bFI == null) {}
    for (;;)
    {
      y.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramString1, paramString2, str1, str2, str3, Boolean.valueOf(bool), Boolean.valueOf(this.rVa.rUZ.epi) });
      if (!bk.bl(paramString3))
      {
        this.rVa.rUZ.rUA.field_signature = paramString3;
        this.rVa.rUZ.rUA.field_fakeAeskey = paramString4;
        this.rVa.rUZ.rUA.field_fakeSignature = paramString5;
      }
      this.rVa.a(this.iIk, this.eiR);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al.1.1
 * JD-Core Version:    0.7.0.1
 */