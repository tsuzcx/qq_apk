package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.z;

public final class b
  implements e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(27234);
    cm localcm = parama.eyJ;
    if ((localcm == null) || (localcm.nqW != 47))
    {
      ab.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
      AppMethodBeat.o(27234);
      return null;
    }
    Object localObject1 = aa.a(localcm.woP);
    Object localObject2 = aa.a(localcm.woQ);
    aw.aaz();
    if (((String)c.Ru().get(2, null)).equals(localObject1))
    {
      localObject1 = localObject2;
      localObject2 = aa.a(localcm.woR);
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((String)localObject1, (String)localObject2, localcm.pIG, localcm.woU, parama);
      localObject1 = com.tencent.mm.model.bf.pA(localcm.woU);
      if (localObject1 != null)
      {
        ab.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", new Object[] { ((bf.b)localObject1).fmH });
        if ((((bf.b)localObject1).fmL != null) && (((bf.b)localObject1).scene == 1))
        {
          parama = aa.a(localcm.woP);
          aw.aaz();
          c.Ru().set(73729, Integer.valueOf(1));
          localObject2 = new com.tencent.mm.storage.bf();
          ((com.tencent.mm.storage.bf)localObject2).field_content = ah.getContext().getString(2131301780);
          ((com.tencent.mm.storage.bf)localObject2).field_createtime = bo.aox();
          ((com.tencent.mm.storage.bf)localObject2).field_imgpath = "";
          ((com.tencent.mm.storage.bf)localObject2).field_sayhicontent = ((com.tencent.mm.storage.bf)localObject2).field_content;
          ((com.tencent.mm.storage.bf)localObject2).field_sayhiuser = parama;
          ((com.tencent.mm.storage.bf)localObject2).field_scene = 18;
          if (localcm.jJS <= 3) {
            break label372;
          }
        }
      }
    }
    label372:
    for (int i = localcm.jJS;; i = 3)
    {
      ((com.tencent.mm.storage.bf)localObject2).field_status = i;
      ((com.tencent.mm.storage.bf)localObject2).field_svrid = localcm.pIG;
      ((com.tencent.mm.storage.bf)localObject2).field_talker = parama;
      ((com.tencent.mm.storage.bf)localObject2).field_type = localcm.nqW;
      ((com.tencent.mm.storage.bf)localObject2).field_isSend = 0;
      ((com.tencent.mm.storage.bf)localObject2).field_sayhiencryptuser = parama;
      ((com.tencent.mm.storage.bf)localObject2).field_ticket = ((bf.b)localObject1).fmL;
      com.tencent.mm.bi.d.alj().a((com.tencent.mm.storage.bf)localObject2);
      localObject1 = new jh();
      ((jh)localObject1).cyK.cyL = parama;
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(27234);
      return null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.b
 * JD-Core Version:    0.7.0.1
 */