package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.f.a.mj;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;

public final class g
  implements com.tencent.mm.an.h
{
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(30937);
    db localdb = parama.jQG;
    if ((localdb == null) || (localdb.COi != 47))
    {
      Log.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
      AppMethodBeat.o(30937);
      return null;
    }
    Object localObject1 = z.a(localdb.RID);
    Object localObject2 = z.a(localdb.RIE);
    bh.beI();
    if (((String)c.aHp().b(2, null)).equals(localObject1))
    {
      localObject1 = localObject2;
      localObject2 = z.a(localdb.RIF);
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((String)localObject1, (String)localObject2, localdb.HlH, localdb.RII, parama);
      localObject1 = bq.RR(localdb.RII);
      if (localObject1 != null)
      {
        Log.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", new Object[] { ((bq.b)localObject1).lus });
        if ((((bq.b)localObject1).luy != null) && (((bq.b)localObject1).scene == 1))
        {
          parama = z.a(localdb.RID);
          bh.beI();
          c.aHp().i(73729, Integer.valueOf(1));
          localObject2 = new bx();
          ((bx)localObject2).field_content = MMApplicationContext.getContext().getString(R.l.nearby_say_hi_type_emoji);
          ((bx)localObject2).field_createtime = Util.nowSecond();
          ((bx)localObject2).field_imgpath = "";
          ((bx)localObject2).field_sayhicontent = ((bx)localObject2).field_content;
          ((bx)localObject2).field_sayhiuser = parama;
          ((bx)localObject2).field_scene = 18;
          if (localdb.rVU <= 3) {
            break label373;
          }
        }
      }
    }
    label373:
    for (int i = localdb.rVU;; i = 3)
    {
      ((bx)localObject2).field_status = i;
      ((bx)localObject2).field_svrid = localdb.HlH;
      ((bx)localObject2).field_talker = parama;
      ((bx)localObject2).field_type = localdb.COi;
      ((bx)localObject2).field_isSend = 0;
      ((bx)localObject2).field_sayhiencryptuser = parama;
      ((bx)localObject2).field_ticket = ((bq.b)localObject1).luy;
      com.tencent.mm.bl.d.bqd().a((bx)localObject2);
      localObject1 = new mj();
      ((mj)localObject1).fKt.fKu = parama;
      EventCenter.instance.publish((IEvent)localObject1);
      AppMethodBeat.o(30937);
      return null;
      break;
    }
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.g
 * JD-Core Version:    0.7.0.1
 */