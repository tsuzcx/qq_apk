package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.d;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class aj$4
  extends IListener<qz>
{
  aj$4(aj paramaj)
  {
    AppMethodBeat.i(232166);
    this.__eventId = qz.class.getName().hashCode();
    AppMethodBeat.o(232166);
  }
  
  private boolean a(qz paramqz)
  {
    AppMethodBeat.i(232167);
    if (!paramqz.dXz.filePath.equals(this.JWO.BGu.field_fileFullPath))
    {
      AppMethodBeat.o(232167);
      return false;
    }
    localObject1 = "";
    try
    {
      localObject2 = URLEncoder.encode(paramqz.dXz.result, "UTF-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        m localm;
        Log.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", localUnsupportedEncodingException, "", new Object[0]);
        continue;
        localObject1 = this.JWO.hmq.field_filemd5;
        continue;
        localObject1 = this.JWO.hmq.field_fileId;
        continue;
        localObject1 = this.JWO.hmq.field_aesKey;
      }
    }
    if (this.JWO.hmp == 1)
    {
      bg.aVF();
      localObject3 = com.tencent.mm.model.c.aSQ().Hb(this.JWO.BGu.field_msgInfoId);
      localm = new m();
      localm.n("20toUser", this.JWO.toUser + ",");
      localm.n("21source", "4,");
      localm.n("22qrUrl", (String)localObject1 + ",");
      localObject2 = new StringBuilder();
      if (this.JWO.hmq == null)
      {
        localObject1 = "";
        localm.n("23md5", (String)localObject1 + ",");
        localObject2 = new StringBuilder();
        if (this.JWO.hmq != null) {
          break label488;
        }
        localObject1 = "";
        localm.n("24cdnFileId", (String)localObject1 + ",");
        localObject2 = new StringBuilder();
        if (this.JWO.hmq != null) {
          break label502;
        }
        localObject1 = "";
        localm.n("25cdnAesKey", (String)localObject1 + ",");
        localObject2 = "";
        localObject1 = localObject2;
        if (((ca)localObject3).dOQ())
        {
          localObject3 = k.b.HD(((eo)localObject3).field_content);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((k.b)localObject3).appId;
          }
        }
        localm.n("26appip", (String)localObject1 + ",");
        localm.n("27toUsersCount", v.Ie(this.JWO.toUser) + ",");
        localm.n("28codeType", Integer.valueOf(paramqz.dXz.dFL));
        Log.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + localm.abW());
        o.O(13628, localm.toString());
      }
    }
    else
    {
      EventCenter.instance.removeListener(this.JWO.hms);
      AppMethodBeat.o(232167);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aj.4
 * JD-Core Version:    0.7.0.1
 */