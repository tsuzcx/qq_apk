package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.Map;

final class q$3
  implements Runnable
{
  q$3(q paramq, String paramString1, String paramString2, Map paramMap, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    int i = 1;
    AppMethodBeat.i(281460);
    bh.beI();
    Object localObject2 = m.aw(c.bce(), this.WAz, u.asq(this.oMi));
    u.on(this.oMi, (String)localObject2);
    Object localObject3 = new WXFileObject();
    ((WXFileObject)localObject3).setFilePath((String)localObject2);
    Object localObject1 = new WXMediaMessage();
    ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject3);
    localObject3 = new com.tencent.mm.vfs.q((String)localObject2);
    ((WXMediaMessage)localObject1).title = ((com.tencent.mm.vfs.q)localObject3).getName();
    ((WXMediaMessage)localObject1).description = Util.getSizeKB(((com.tencent.mm.vfs.q)localObject3).length());
    m.a((WXMediaMessage)localObject1, "", "", q.p(this.WAw), this.WAA);
    int j = ((com.tencent.mm.vfs.q)localObject3).getName().lastIndexOf(".");
    localObject2 = "";
    localObject1 = localObject2;
    if (j >= 0)
    {
      localObject1 = localObject2;
      if (j < ((com.tencent.mm.vfs.q)localObject3).getName().length() - 1) {
        localObject1 = ((com.tencent.mm.vfs.q)localObject3).getName().substring(j + 1);
      }
    }
    localObject2 = h.IzE;
    long l = ((com.tencent.mm.vfs.q)localObject3).length();
    if (this.WAB) {}
    for (;;)
    {
      ((h)localObject2).a(14986, new Object[] { Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(this.WAC), localObject1 });
      AppMethodBeat.o(281460);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.3
 * JD-Core Version:    0.7.0.1
 */