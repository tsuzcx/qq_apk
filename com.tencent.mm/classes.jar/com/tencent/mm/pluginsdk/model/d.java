package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bt;

public final class d
  implements e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(30937);
    cv localcv = parama.gte;
    if ((localcv == null) || (localcv.urJ != 47))
    {
      ae.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
      AppMethodBeat.o(30937);
      return null;
    }
    Object localObject1 = z.a(localcv.FNG);
    Object localObject2 = z.a(localcv.FNH);
    bc.aCg();
    if (((String)c.ajA().get(2, null)).equals(localObject1))
    {
      localObject1 = localObject2;
      localObject2 = z.a(localcv.FNI);
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((String)localObject1, (String)localObject2, localcv.xrk, localcv.FNL, parama);
      localObject1 = bl.BS(localcv.FNL);
      if (localObject1 != null)
      {
        ae.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", new Object[] { ((bl.b)localObject1).hJH });
        if ((((bl.b)localObject1).hJM != null) && (((bl.b)localObject1).scene == 1))
        {
          parama = z.a(localcv.FNG);
          bc.aCg();
          c.ajA().set(73729, Integer.valueOf(1));
          localObject2 = new bs();
          ((bs)localObject2).field_content = ak.getContext().getString(2131761527);
          ((bs)localObject2).field_createtime = bu.aRi();
          ((bs)localObject2).field_imgpath = "";
          ((bs)localObject2).field_sayhicontent = ((bs)localObject2).field_content;
          ((bs)localObject2).field_sayhiuser = parama;
          ((bs)localObject2).field_scene = 18;
          if (localcv.nJb <= 3) {
            break label372;
          }
        }
      }
    }
    label372:
    for (int i = localcv.nJb;; i = 3)
    {
      ((bs)localObject2).field_status = i;
      ((bs)localObject2).field_svrid = localcv.xrk;
      ((bs)localObject2).field_talker = parama;
      ((bs)localObject2).field_type = localcv.urJ;
      ((bs)localObject2).field_isSend = 0;
      ((bs)localObject2).field_sayhiencryptuser = parama;
      ((bs)localObject2).field_ticket = ((bl.b)localObject1).hJM;
      com.tencent.mm.bj.d.aMN().a((bs)localObject2);
      localObject1 = new lc();
      ((lc)localObject1).dzq.dzr = parama;
      a.IvT.l((b)localObject1);
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