package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

final class ah$1$2
  implements z.a
{
  ah$1$2(ah.1 param1, int paramInt) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    AppMethodBeat.i(27372);
    String str1 = bo.aqg(paramString2);
    String str2 = bo.aqg(paramString3);
    String str3 = bo.aqg(paramString4);
    String str4 = bo.aqg(paramString5);
    if (this.vLN.vLM.cmR == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramString1, str1, str2, str3, str4, Boolean.valueOf(bool), Boolean.valueOf(this.vLN.vLM.fFG) });
      if (!bo.isNullOrNil(paramString3))
      {
        this.vLN.vLM.pYg.field_signature = paramString3;
        this.vLN.vLM.pYg.field_fakeAeskey = paramString4;
        this.vLN.vLM.pYg.field_fakeSignature = paramString5;
        this.vLN.vLM.pYg.field_lastModifyTime = bo.aoy();
        if (this.vLN.vLM.cmR != null)
        {
          this.vLN.vLM.cmR.filemd5 = paramString1;
          this.vLN.vLM.cmR.ewj = paramString2;
          this.vLN.vLM.cmR.fgw = ((int)paramLong);
          aw.aaz();
          paramString1 = com.tencent.mm.model.c.YC().kB(this.vLN.vLM.pYg.field_msgInfoId);
          paramString1.setContent(j.b.a(this.vLN.vLM.cmR, null, null));
          aw.aaz();
          com.tencent.mm.model.c.YC().a(paramString1.field_msgId, paramString1);
        }
      }
      this.vLN.vLM.fFG = false;
      bool = al.aUJ().a(this.vLN.vLM.pYg, new String[0]);
      if (bool) {
        break;
      }
      ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
      this.vLN.vLM.retCode = (-10000 - g.getLine());
      this.vLN.vLM.callback.onSceneEnd(3, this.kOP, "", this.vLN.vLM);
      AppMethodBeat.o(27372);
      return;
    }
    aw.RO().ac(new ah.1.2.1(this));
    AppMethodBeat.o(27372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah.1.2
 * JD-Core Version:    0.7.0.1
 */