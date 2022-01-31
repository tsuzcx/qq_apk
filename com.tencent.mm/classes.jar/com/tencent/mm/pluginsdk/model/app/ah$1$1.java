package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ah$1$1
  implements z.a
{
  ah$1$1(ah.1 param1, int paramInt, d paramd) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    boolean bool = true;
    AppMethodBeat.i(27370);
    paramString2 = bo.aqg(paramString2);
    String str1 = bo.aqg(paramString3);
    String str2 = bo.aqg(paramString4);
    String str3 = bo.aqg(paramString5);
    if (this.vLN.vLM.cmR == null) {}
    for (;;)
    {
      ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramString1, paramString2, str1, str2, str3, Boolean.valueOf(bool), Boolean.valueOf(this.vLN.vLM.fFG) });
      if (!bo.isNullOrNil(paramString3))
      {
        this.vLN.vLM.pYg.field_signature = paramString3;
        this.vLN.vLM.pYg.field_fakeAeskey = paramString4;
        this.vLN.vLM.pYg.field_fakeSignature = paramString5;
      }
      this.vLN.a(this.kOP, this.fyV);
      AppMethodBeat.o(27370);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah.1.1
 * JD-Core Version:    0.7.0.1
 */