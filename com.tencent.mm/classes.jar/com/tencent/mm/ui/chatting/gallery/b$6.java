package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j;
import com.tencent.mm.app.j.a;
import com.tencent.mm.app.j.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class b$6
  implements Runnable
{
  b$6(ca paramca, String paramString, s params) {}
  
  public final void run()
  {
    AppMethodBeat.i(233279);
    try
    {
      j.b localb;
      if (ab.Eq(this.iBP.field_talker))
      {
        localb = j.b(j.a.dkR);
        if (this.iBP.field_isSend == 1)
        {
          localb.dkU = z.aTY();
          localb.dkV = this.iBP.field_talker;
        }
      }
      MultiMediaVideoChecker.a locala;
      for (;;)
      {
        locala = MultiMediaVideoChecker.GyY.aTV(this.cJK);
        if (locala != null) {
          break;
        }
        Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to get video data info, skip reporting. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(this.iBP.field_msgId), Long.valueOf(this.iBP.field_msgSvrId) });
        AppMethodBeat.o(233279);
        return;
        localb.dkU = bp.Ks(this.iBP.field_content);
        localb.dkV = this.iBP.field_talker;
        continue;
        localb = j.a(j.a.dkR);
        if (this.iBP.field_isSend == 1)
        {
          localb.dkU = z.aTY();
          localb.dkV = this.iBP.field_talker;
        }
        else
        {
          localb.dkU = this.iBP.field_talker;
          localb.dkV = z.aTY();
        }
      }
      if (this.zuE != null) {}
      for (Object localObject = XmlParser.parseXml(this.zuE.bhv(), "msg", null); localObject == null; localObject = Collections.emptyMap())
      {
        Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to parse recv xml. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(this.iBP.field_msgId), Long.valueOf(this.iBP.field_msgSvrId) });
        AppMethodBeat.o(233279);
        return;
      }
      localb.msgId = this.iBP.field_msgSvrId;
      localb.dkW = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"));
      localb.dkX = locala.width;
      localb.dkY = locala.height;
      localb.dkZ = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$cdnthumburl"));
      localb.dla = ((int)locala.duration);
      localb.fileId = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"));
      localb.fileKey = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$aeskey"));
      localb.md5 = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$md5"));
      if (ab.Eq(this.iBP.field_talker))
      {
        localObject = ((c)g.af(c.class)).aSX().Kh(this.iBP.field_talker);
        if (localObject == null) {
          break label471;
        }
      }
      label471:
      for (int i = ((List)localObject).size();; i = 0)
      {
        localb.dlc = i;
        j.a(localb);
        AppMethodBeat.o(233279);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.ImageGalleryAdapter", localThrowable, "[-] Exception was thrown when report.", new Object[0]);
      AppMethodBeat.o(233279);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b.6
 * JD-Core Version:    0.7.0.1
 */