package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;

public final class d
  implements f
{
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(30937);
    cu localcu = parama.fXi;
    if ((localcu == null) || (localcu.tit != 47))
    {
      ac.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
      AppMethodBeat.o(30937);
      return null;
    }
    Object localObject1 = z.a(localcu.DPT);
    Object localObject2 = z.a(localcu.DPU);
    az.ayM();
    if (((String)c.agA().get(2, null)).equals(localObject1))
    {
      localObject1 = localObject2;
      localObject2 = z.a(localcu.DPV);
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((String)localObject1, (String)localObject2, localcu.vTQ, localcu.DPY, parama);
      localObject1 = bi.yr(localcu.DPY);
      if (localObject1 != null)
      {
        ac.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", new Object[] { ((bi.b)localObject1).hox });
        if ((((bi.b)localObject1).hoC != null) && (((bi.b)localObject1).scene == 1))
        {
          parama = z.a(localcu.DPT);
          az.ayM();
          c.agA().set(73729, Integer.valueOf(1));
          localObject2 = new bl();
          ((bl)localObject2).field_content = ai.getContext().getString(2131761527);
          ((bl)localObject2).field_createtime = bs.aNx();
          ((bl)localObject2).field_imgpath = "";
          ((bl)localObject2).field_sayhicontent = ((bl)localObject2).field_content;
          ((bl)localObject2).field_sayhiuser = parama;
          ((bl)localObject2).field_scene = 18;
          if (localcu.ndj <= 3) {
            break label372;
          }
        }
      }
    }
    label372:
    for (int i = localcu.ndj;; i = 3)
    {
      ((bl)localObject2).field_status = i;
      ((bl)localObject2).field_svrid = localcu.vTQ;
      ((bl)localObject2).field_talker = parama;
      ((bl)localObject2).field_type = localcu.tit;
      ((bl)localObject2).field_isSend = 0;
      ((bl)localObject2).field_sayhiencryptuser = parama;
      ((bl)localObject2).field_ticket = ((bi.b)localObject1).hoC;
      com.tencent.mm.bj.d.aJf().a((bl)localObject2);
      localObject1 = new ks();
      ((ks)localObject1).dmx.dmy = parama;
      a.GpY.l((b)localObject1);
      AppMethodBeat.o(30937);
      return null;
      break;
    }
  }
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.d
 * JD-Core Version:    0.7.0.1
 */