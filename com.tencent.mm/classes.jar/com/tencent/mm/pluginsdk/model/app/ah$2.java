package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class ah$2
  extends com.tencent.mm.sdk.b.c<ny>
{
  ah$2(ah paramah)
  {
    AppMethodBeat.i(27377);
    this.__eventId = ny.class.getName().hashCode();
    AppMethodBeat.o(27377);
  }
  
  private boolean a(ny paramny)
  {
    AppMethodBeat.i(27378);
    if (!paramny.cEy.filePath.equals(this.vLM.pYg.field_fileFullPath))
    {
      AppMethodBeat.o(27378);
      return false;
    }
    localObject1 = "";
    try
    {
      localObject2 = URLEncoder.encode(paramny.cEy.result, "UTF-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        com.tencent.mm.modelsns.d locald;
        ab.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", localUnsupportedEncodingException, "", new Object[0]);
        continue;
        localObject1 = this.vLM.eDC.field_filemd5;
        continue;
        localObject1 = this.vLM.eDC.field_fileId;
        continue;
        localObject1 = this.vLM.eDC.field_aesKey;
      }
    }
    if (this.vLM.eDB == 1)
    {
      aw.aaz();
      localObject3 = com.tencent.mm.model.c.YC().kB(this.vLM.pYg.field_msgInfoId);
      locald = new com.tencent.mm.modelsns.d();
      locald.k("20toUser", this.vLM.toUser + ",");
      locald.k("21source", "4,");
      locald.k("22qrUrl", (String)localObject1 + ",");
      localObject2 = new StringBuilder();
      if (this.vLM.eDC == null)
      {
        localObject1 = "";
        locald.k("23md5", (String)localObject1 + ",");
        localObject2 = new StringBuilder();
        if (this.vLM.eDC != null) {
          break label491;
        }
        localObject1 = "";
        locald.k("24cdnFileId", (String)localObject1 + ",");
        localObject2 = new StringBuilder();
        if (this.vLM.eDC != null) {
          break label505;
        }
        localObject1 = "";
        locald.k("25cdnAesKey", (String)localObject1 + ",");
        localObject2 = "";
        localObject1 = localObject2;
        if (((bi)localObject3).bCn())
        {
          localObject3 = j.b.mY(((dd)localObject3).field_content);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((j.b)localObject3).appId;
          }
        }
        locald.k("26appip", (String)localObject1 + ",");
        locald.k("27toUsersCount", n.nv(this.vLM.toUser) + ",");
        locald.k("28codeType", Integer.valueOf(paramny.cEy.cpE));
        ab.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + locald.Fg());
        o.B(13628, locald.toString());
      }
    }
    else
    {
      a.ymk.d(this.vLM.eDE);
      AppMethodBeat.o(27378);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah.2
 * JD-Core Version:    0.7.0.1
 */