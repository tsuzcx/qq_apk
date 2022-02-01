package com.tencent.mm.ui.chatting.gallery;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j;
import com.tencent.mm.app.j.a;
import com.tencent.mm.app.j.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class b$9
  implements Runnable
{
  b$9(String paramString, ca paramca, com.tencent.mm.av.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(233282);
    label528:
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = BitmapUtil.getImageOptions(this.msL);
        if (localOptions == null)
        {
          Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to get bmp opts. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(this.iBP.field_msgId), Long.valueOf(this.iBP.field_msgSvrId) });
          AppMethodBeat.o(233282);
          return;
        }
        j.b localb;
        if (ab.Eq(this.iBP.field_talker))
        {
          localb = j.b(j.a.dkQ);
          if (this.iBP.field_isSend == 1)
          {
            localb.dkU = z.aTY();
            localb.dkV = this.iBP.field_talker;
            localObject = d.AEF.aIU(this.msL);
            if (localObject == null) {
              break label528;
            }
            localObject = localObject[0];
            if (this.iYL != null)
            {
              localMap = XmlParser.parseXml(this.iYL.iXy, "msg", null);
              if (localMap != null) {
                continue;
              }
              Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to parse cdn info. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(this.iBP.field_msgId), Long.valueOf(this.iBP.field_msgSvrId) });
              AppMethodBeat.o(233282);
            }
          }
          else
          {
            localb.dkU = bp.Ks(this.iBP.field_content);
            localb.dkV = this.iBP.field_talker;
            continue;
          }
        }
        else
        {
          localb = j.a(j.a.dkQ);
          if (this.iBP.field_isSend == 1)
          {
            localb.dkU = z.aTY();
            localb.dkV = this.iBP.field_talker;
            continue;
          }
          localb.dkU = this.iBP.field_talker;
          localb.dkV = z.aTY();
          continue;
        }
        Map localMap = Collections.emptyMap();
        continue;
        String str;
        if (this.iYL.iXp == 1)
        {
          str = (String)localMap.get(".msg.img.$cdnbigimgurl");
          localb.msgId = this.iBP.field_msgSvrId;
          localb.dkW = Util.nullAsNil(str);
          localb.dkX = localOptions.outWidth;
          localb.dkY = localOptions.outHeight;
          localb.dkZ = Util.nullAsNil((String)localMap.get(".msg.img.$cdnthumburl"));
          localb.fileId = Util.nullAsNil(str);
          localb.fileKey = Util.nullAsNil((String)localMap.get(".msg.img.$aeskey"));
          localb.md5 = com.tencent.mm.b.g.getMD5(this.msL);
          localb.dlb = ((String)localObject);
          if (ab.Eq(this.iBP.field_talker))
          {
            localObject = ((c)com.tencent.mm.kernel.g.af(c.class)).aSX().Kh(this.iBP.field_talker);
            if (localObject != null)
            {
              i = ((List)localObject).size();
              localb.dlc = i;
            }
          }
          else
          {
            j.a(localb);
            AppMethodBeat.o(233282);
          }
        }
        else
        {
          str = (String)localMap.get(".msg.img.$cdnmidimgurl");
          continue;
        }
        int i = 0;
        continue;
        Object localObject = "";
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.ImageGalleryAdapter", localThrowable, "[-] Exception was thrown when report.", new Object[0]);
        AppMethodBeat.o(233282);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b.9
 * JD-Core Version:    0.7.0.1
 */