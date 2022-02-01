package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bj;

public final class d
  implements f
{
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(30937);
    cs localcs = parama.fTo;
    if ((localcs == null) || (localcs.saz != 47))
    {
      ad.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
      AppMethodBeat.o(30937);
      return null;
    }
    Object localObject1 = z.a(localcs.Cxx);
    Object localObject2 = z.a(localcs.Cxy);
    az.arV();
    if (((String)c.afk().get(2, null)).equals(localObject1))
    {
      localObject1 = localObject2;
      localObject2 = z.a(localcs.Cxz);
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((String)localObject1, (String)localObject2, localcs.uKZ, localcs.CxC, parama);
      localObject1 = com.tencent.mm.model.bi.ul(localcs.CxC);
      if (localObject1 != null)
      {
        ad.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", new Object[] { ((bi.b)localObject1).gNX });
        if ((((bi.b)localObject1).gOc != null) && (((bi.b)localObject1).scene == 1))
        {
          parama = z.a(localcs.Cxx);
          az.arV();
          c.afk().set(73729, Integer.valueOf(1));
          localObject2 = new com.tencent.mm.storage.bi();
          ((com.tencent.mm.storage.bi)localObject2).field_content = aj.getContext().getString(2131761527);
          ((com.tencent.mm.storage.bi)localObject2).field_createtime = bt.aGK();
          ((com.tencent.mm.storage.bi)localObject2).field_imgpath = "";
          ((com.tencent.mm.storage.bi)localObject2).field_sayhicontent = ((com.tencent.mm.storage.bi)localObject2).field_content;
          ((com.tencent.mm.storage.bi)localObject2).field_sayhiuser = parama;
          ((com.tencent.mm.storage.bi)localObject2).field_scene = 18;
          if (localcs.mBi <= 3) {
            break label372;
          }
        }
      }
    }
    label372:
    for (int i = localcs.mBi;; i = 3)
    {
      ((com.tencent.mm.storage.bi)localObject2).field_status = i;
      ((com.tencent.mm.storage.bi)localObject2).field_svrid = localcs.uKZ;
      ((com.tencent.mm.storage.bi)localObject2).field_talker = parama;
      ((com.tencent.mm.storage.bi)localObject2).field_type = localcs.saz;
      ((com.tencent.mm.storage.bi)localObject2).field_isSend = 0;
      ((com.tencent.mm.storage.bi)localObject2).field_sayhiencryptuser = parama;
      ((com.tencent.mm.storage.bi)localObject2).field_ticket = ((bi.b)localObject1).gOc;
      com.tencent.mm.bk.d.aCp().a((com.tencent.mm.storage.bi)localObject2);
      localObject1 = new kk();
      ((kk)localObject1).doP.doQ = parama;
      a.ESL.l((b)localObject1);
      AppMethodBeat.o(30937);
      return null;
      break;
    }
  }
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.d
 * JD-Core Version:    0.7.0.1
 */