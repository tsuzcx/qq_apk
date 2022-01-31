package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.h.a.iy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.z;

public final class b
  implements e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    cd localcd = parama.dBs;
    if ((localcd == null) || (localcd.kSW != 47)) {
      y.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
    }
    Object localObject1;
    do
    {
      do
      {
        return null;
        localObject1 = aa.a(localcd.svF);
        localObject2 = aa.a(localcd.svG);
        au.Hx();
        if (!((String)c.Dz().get(2, null)).equals(localObject1)) {
          break;
        }
        localObject1 = localObject2;
        localObject2 = aa.a(localcd.svH);
        ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((String)localObject1, (String)localObject2, localcd.ndp, localcd.svK, parama);
        localObject1 = bd.iM(localcd.svK);
      } while (localObject1 == null);
      y.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", new Object[] { ((bd.b)localObject1).dWz });
    } while ((((bd.b)localObject1).dWD == null) || (((bd.b)localObject1).scene != 1));
    parama = aa.a(localcd.svF);
    au.Hx();
    c.Dz().o(73729, Integer.valueOf(1));
    Object localObject2 = new bf();
    ((bf)localObject2).field_content = ae.getContext().getString(R.l.nearby_say_hi_type_emoji);
    ((bf)localObject2).field_createtime = bk.UX();
    ((bf)localObject2).field_imgpath = "";
    ((bf)localObject2).field_sayhicontent = ((bf)localObject2).field_content;
    ((bf)localObject2).field_sayhiuser = parama;
    ((bf)localObject2).field_scene = 18;
    if (localcd.hQq > 3) {}
    for (int i = localcd.hQq;; i = 3)
    {
      ((bf)localObject2).field_status = i;
      ((bf)localObject2).field_svrid = localcd.ndp;
      ((bf)localObject2).field_talker = parama;
      ((bf)localObject2).field_type = localcd.kSW;
      ((bf)localObject2).field_isSend = 0;
      ((bf)localObject2).field_sayhiencryptuser = parama;
      ((bf)localObject2).field_ticket = ((bd.b)localObject1).dWD;
      com.tencent.mm.bh.d.RZ().a((bf)localObject2);
      localObject1 = new iy();
      ((iy)localObject1).bRi.bRj = parama;
      a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      return null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.b
 * JD-Core Version:    0.7.0.1
 */