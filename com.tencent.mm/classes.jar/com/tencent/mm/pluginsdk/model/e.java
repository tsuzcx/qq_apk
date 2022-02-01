package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;

public final class e
  implements h
{
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(30937);
    de localde = parama.heO;
    if ((localde == null) || (localde.xKb != 47))
    {
      Log.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
      AppMethodBeat.o(30937);
      return null;
    }
    Object localObject1 = z.a(localde.KHl);
    Object localObject2 = z.a(localde.KHm);
    bg.aVF();
    if (((String)c.azQ().get(2, null)).equals(localObject1))
    {
      localObject1 = localObject2;
      localObject2 = z.a(localde.KHn);
      ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((String)localObject1, (String)localObject2, localde.Brn, localde.KHq, parama);
      localObject1 = bp.Ky(localde.KHq);
      if (localObject1 != null)
      {
        Log.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", new Object[] { ((bp.b)localObject1).iEr });
        if ((((bp.b)localObject1).iEw != null) && (((bp.b)localObject1).scene == 1))
        {
          parama = z.a(localde.KHl);
          bg.aVF();
          c.azQ().set(73729, Integer.valueOf(1));
          localObject2 = new bx();
          ((bx)localObject2).field_content = MMApplicationContext.getContext().getString(2131763488);
          ((bx)localObject2).field_createtime = Util.nowSecond();
          ((bx)localObject2).field_imgpath = "";
          ((bx)localObject2).field_sayhicontent = ((bx)localObject2).field_content;
          ((bx)localObject2).field_sayhiuser = parama;
          ((bx)localObject2).field_scene = 18;
          if (localde.oTW <= 3) {
            break label372;
          }
        }
      }
    }
    label372:
    for (int i = localde.oTW;; i = 3)
    {
      ((bx)localObject2).field_status = i;
      ((bx)localObject2).field_svrid = localde.Brn;
      ((bx)localObject2).field_talker = parama;
      ((bx)localObject2).field_type = localde.xKb;
      ((bx)localObject2).field_isSend = 0;
      ((bx)localObject2).field_sayhiencryptuser = parama;
      ((bx)localObject2).field_ticket = ((bp.b)localObject1).iEw;
      com.tencent.mm.bj.d.bgO().a((bx)localObject2);
      localObject1 = new ls();
      ((ls)localObject1).dRd.dRe = parama;
      EventCenter.instance.publish((IEvent)localObject1);
      AppMethodBeat.o(30937);
      return null;
      break;
    }
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.e
 * JD-Core Version:    0.7.0.1
 */