package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.h.a.nb.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class al$2
  extends com.tencent.mm.sdk.b.c<nb>
{
  al$2(al paramal)
  {
    this.udX = nb.class.getName().hashCode();
  }
  
  private boolean a(nb paramnb)
  {
    if (!paramnb.bWI.filePath.equals(this.rUZ.rUA.field_fileFullPath)) {
      return false;
    }
    localObject1 = "";
    try
    {
      localObject2 = URLEncoder.encode(paramnb.bWI.result, "UTF-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        com.tencent.mm.modelsns.d locald;
        y.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", localUnsupportedEncodingException, "", new Object[0]);
        continue;
        localObject1 = this.rUZ.dGa.field_filemd5;
        continue;
        localObject1 = this.rUZ.dGa.field_fileId;
        continue;
        localObject1 = this.rUZ.dGa.field_aesKey;
      }
    }
    if (this.rUZ.dFZ == 1)
    {
      au.Hx();
      localObject3 = com.tencent.mm.model.c.Fy().fd(this.rUZ.rUA.field_msgInfoId);
      locald = new com.tencent.mm.modelsns.d();
      locald.j("20toUser", this.rUZ.toUser + ",");
      locald.j("21source", "4,");
      locald.j("22qrUrl", (String)localObject1 + ",");
      localObject2 = new StringBuilder();
      if (this.rUZ.dGa == null)
      {
        localObject1 = "";
        locald.j("23md5", (String)localObject1 + ",");
        localObject2 = new StringBuilder();
        if (this.rUZ.dGa != null) {
          break label473;
        }
        localObject1 = "";
        locald.j("24cdnFileId", (String)localObject1 + ",");
        localObject2 = new StringBuilder();
        if (this.rUZ.dGa != null) {
          break label487;
        }
        localObject1 = "";
        locald.j("25cdnAesKey", (String)localObject1 + ",");
        localObject2 = "";
        localObject1 = localObject2;
        if (((bi)localObject3).aVK())
        {
          localObject3 = g.a.gp(((cs)localObject3).field_content);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((g.a)localObject3).appId;
          }
        }
        locald.j("26appip", (String)localObject1 + ",");
        locald.j("27toUsersCount", m.gM(this.rUZ.toUser) + ",");
        locald.j("28codeType", Integer.valueOf(paramnb.bWI.bIj));
        y.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + locald.uJ());
        o.s(13628, locald.toString());
      }
    }
    else
    {
      a.udP.d(this.rUZ.dGc);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al.2
 * JD-Core Version:    0.7.0.1
 */