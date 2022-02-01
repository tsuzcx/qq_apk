package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bs;

public final class d
  implements e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(30937);
    cv localcv = parama.gqE;
    if ((localcv == null) || (localcv.ugm != 47))
    {
      ad.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
      AppMethodBeat.o(30937);
      return null;
    }
    Object localObject1 = z.a(localcv.Fvi);
    Object localObject2 = z.a(localcv.Fvj);
    ba.aBQ();
    if (((String)c.ajl().get(2, null)).equals(localObject1))
    {
      localObject1 = localObject2;
      localObject2 = z.a(localcv.Fvk);
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((String)localObject1, (String)localObject2, localcv.xbt, localcv.Fvn, parama);
      localObject1 = bj.Bq(localcv.Fvn);
      if (localObject1 != null)
      {
        ad.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", new Object[] { ((bj.b)localObject1).hGP });
        if ((((bj.b)localObject1).hGU != null) && (((bj.b)localObject1).scene == 1))
        {
          parama = z.a(localcv.Fvi);
          ba.aBQ();
          c.ajl().set(73729, Integer.valueOf(1));
          localObject2 = new br();
          ((br)localObject2).field_content = aj.getContext().getString(2131761527);
          ((br)localObject2).field_createtime = bt.aQJ();
          ((br)localObject2).field_imgpath = "";
          ((br)localObject2).field_sayhicontent = ((br)localObject2).field_content;
          ((br)localObject2).field_sayhiuser = parama;
          ((br)localObject2).field_scene = 18;
          if (localcv.nDG <= 3) {
            break label372;
          }
        }
      }
    }
    label372:
    for (int i = localcv.nDG;; i = 3)
    {
      ((br)localObject2).field_status = i;
      ((br)localObject2).field_svrid = localcv.xbt;
      ((br)localObject2).field_talker = parama;
      ((br)localObject2).field_type = localcv.ugm;
      ((br)localObject2).field_isSend = 0;
      ((br)localObject2).field_sayhiencryptuser = parama;
      ((br)localObject2).field_ticket = ((bj.b)localObject1).hGU;
      com.tencent.mm.bk.d.aMp().a((br)localObject2);
      localObject1 = new lb();
      ((lb)localObject1).dyl.dym = parama;
      a.IbL.l((b)localObject1);
      AppMethodBeat.o(30937);
      return null;
      break;
    }
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.d
 * JD-Core Version:    0.7.0.1
 */