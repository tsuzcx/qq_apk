package com.tencent.mm.pluginsdk.model.app;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.autogen.a.to.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class NetSceneUploadAppAttach$4
  extends IListener<to>
{
  NetSceneUploadAppAttach$4(an paraman, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(244937);
    this.__eventId = to.class.getName().hashCode();
    AppMethodBeat.o(244937);
  }
  
  private boolean a(to paramto)
  {
    AppMethodBeat.i(244944);
    if (!paramto.hXi.filePath.equals(an.b(this.XTf).field_fileFullPath))
    {
      AppMethodBeat.o(244944);
      return false;
    }
    Object localObject1 = "";
    Object localObject2 = o.YtW;
    localObject2 = o.d(paramto);
    Object localObject3 = o.YtW;
    int i = o.e(paramto);
    try
    {
      paramto = URLEncoder.encode((String)localObject2, "UTF-8");
      if (an.n(this.XTf) == 1)
      {
        bh.bCz();
        localObject3 = com.tencent.mm.model.c.bzD().sl(an.b(this.XTf).field_msgInfoId);
        localObject2 = new com.tencent.mm.modelsns.n();
        ((com.tencent.mm.modelsns.n)localObject2).s("20toUser", an.j(this.XTf) + ",");
        ((com.tencent.mm.modelsns.n)localObject2).s("21source", "4,");
        ((com.tencent.mm.modelsns.n)localObject2).s("22qrUrl", paramto + ",");
        localObject1 = new StringBuilder();
        if (an.o(this.XTf) == null)
        {
          paramto = "";
          ((com.tencent.mm.modelsns.n)localObject2).s("23md5", paramto + ",");
          localObject1 = new StringBuilder();
          if (an.o(this.XTf) != null) {
            break label494;
          }
          paramto = "";
          ((com.tencent.mm.modelsns.n)localObject2).s("24cdnFileId", paramto + ",");
          localObject1 = new StringBuilder();
          if (an.o(this.XTf) != null) {
            break label508;
          }
          paramto = "";
          ((com.tencent.mm.modelsns.n)localObject2).s("25cdnAesKey", paramto + ",");
          localObject1 = "";
          paramto = (to)localObject1;
          if (((cc)localObject3).fxR())
          {
            localObject3 = k.b.Hf(((fi)localObject3).field_content);
            paramto = (to)localObject1;
            if (localObject3 != null) {
              paramto = ((k.b)localObject3).appId;
            }
          }
          ((com.tencent.mm.modelsns.n)localObject2).s("26appip", paramto + ",");
          ((com.tencent.mm.modelsns.n)localObject2).s("27toUsersCount", v.getMembersCountByChatRoomName(an.j(this.XTf)) + ",");
          ((com.tencent.mm.modelsns.n)localObject2).s("28codeType", Integer.valueOf(i));
          Log.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + ((com.tencent.mm.modelsns.n)localObject2).aIF());
          com.tencent.mm.modelstat.n.V(13628, ((com.tencent.mm.modelsns.n)localObject2).toString());
        }
      }
      else
      {
        an.p(this.XTf).dead();
        AppMethodBeat.o(244944);
        return false;
      }
    }
    catch (UnsupportedEncodingException paramto)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", paramto, "", new Object[0]);
        paramto = (to)localObject1;
        continue;
        paramto = an.o(this.XTf).field_filemd5;
        continue;
        label494:
        paramto = an.o(this.XTf).field_fileId;
        continue;
        label508:
        paramto = an.o(this.XTf).field_aesKey;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.NetSceneUploadAppAttach.4
 * JD-Core Version:    0.7.0.1
 */