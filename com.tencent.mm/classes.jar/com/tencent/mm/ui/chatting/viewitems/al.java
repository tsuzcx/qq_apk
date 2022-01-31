package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.h;
import com.tencent.mm.h.a.fr;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.b.b.af;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.x;

public final class al
{
  public static void a(com.tencent.mm.ui.chatting.c.a parama, aw paramaw)
  {
    if ((com.tencent.mm.r.a.bk(parama.vtz.getContext())) || (com.tencent.mm.r.a.bi(parama.vtz.getContext()))) {
      y.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        au.Hx();
        if (!c.isSDCardAvailable())
        {
          s.gM(parama.vtz.getContext());
          return;
        }
      } while ((paramaw == null) || (paramaw.bWO == null));
      localObject = new n(paramaw.bWO.field_content);
      if ((ah.bl(paramaw.bWO.field_content)) || (((n)localObject).time == 0L))
      {
        Toast.makeText(parama.vtz.getContext(), R.l.chatting_data_broken, 0).show();
        return;
      }
      localObject = ((ai)parama.ac(ai.class)).cFx();
    } while ((parama.ac(g.class) == null) || (localObject == null));
    bi localbi = paramaw.bWO;
    int i;
    if (((ai)parama.ac(ai.class)).cFx().vhz != localbi.field_msgId)
    {
      parama = (af)parama.ac(af.class);
      if (!parama.hX(localbi.field_msgId)) {
        break label457;
      }
      i = 7;
    }
    for (;;)
    {
      if (i != 0)
      {
        parama = new fr();
        parama.bMI.bMJ = 1;
        parama.bMI.scene = i;
        parama.bMI.fileName = localbi.field_imgPath;
        com.tencent.mm.sdk.b.a.udP.m(parama);
      }
      i = paramaw.position;
      parama = paramaw.bWO;
      if ((parama == null) || (!parama.ctA())) {
        break;
      }
      paramaw = new n(parama.field_content);
      if (((paramaw.time == 0L) && (parama.field_isSend == 0)) || ((parama.field_status == 1) && (parama.field_isSend == 1)) || ((parama.field_isSend == 0) && (paramaw.time == -1L))) {
        break;
      }
      ((d)localObject).cBW();
      au.Hx();
      paramaw = (Boolean)c.Dz().get(4115, null);
      if ((paramaw == null) || (!paramaw.booleanValue()))
      {
        au.Hx();
        c.Dz().o(4115, Boolean.valueOf(true));
        ((d)localObject).cCc();
        ((d)localObject).vhC = s.a(((d)localObject).byx.vtz.getActivity(), ((d)localObject).context.getString(R.l.chatting_music_volumn_change), 4000L);
      }
      if ((((d)localObject).jZC.isPlaying()) && (parama.field_msgId == ((d)localObject).vhz))
      {
        ((d)localObject).vhI = true;
        ((d)localObject).cCb();
        return;
        label457:
        if (parama.hU(localbi.field_msgId)) {
          i = 6;
        }
      }
      else
      {
        ((d)localObject).an(parama);
        if ((parama.field_isSend == 0) && (!q.F(parama))) {
          ((d)localObject).GI(i + 1);
        }
        ((d)localObject).ni(true);
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al
 * JD-Core Version:    0.7.0.1
 */