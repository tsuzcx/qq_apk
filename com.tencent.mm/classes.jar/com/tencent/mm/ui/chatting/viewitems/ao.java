package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ag;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.d;

public final class ao
{
  public static void a(com.tencent.mm.ui.chatting.d.a parama, az paramaz)
  {
    AppMethodBeat.i(33378);
    if ((com.tencent.mm.r.a.bO(parama.zJz.getContext())) || (com.tencent.mm.r.a.bM(parama.zJz.getContext())))
    {
      ab.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
      AppMethodBeat.o(33378);
      return;
    }
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      t.ii(parama.zJz.getContext());
      AppMethodBeat.o(33378);
      return;
    }
    Object localObject;
    bi localbi;
    int i;
    if ((paramaz != null) && (paramaz.cEE != null))
    {
      localObject = new p(paramaz.cEE.field_content);
      if ((ah.isNullOrNil(paramaz.cEE.field_content)) || (((p)localObject).time == 0L))
      {
        Toast.makeText(parama.zJz.getContext(), 2131298162, 0).show();
        AppMethodBeat.o(33378);
        return;
      }
      localObject = ((aj)parama.ay(aj.class)).dJv();
      if ((parama.ay(com.tencent.mm.ui.chatting.c.b.h.class) != null) && (localObject != null))
      {
        localbi = paramaz.cEE;
        if (((aj)parama.ay(aj.class)).dJv().zwt != localbi.field_msgId)
        {
          parama = (ag)parama.ay(ag.class);
          if (!parama.oJ(localbi.field_msgId)) {
            break label302;
          }
          i = 7;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        parama = new fu();
        parama.cuc.cud = 1;
        parama.cuc.scene = i;
        parama.cuc.fileName = localbi.field_imgPath;
        com.tencent.mm.sdk.b.a.ymk.l(parama);
      }
      i = paramaz.position;
      parama = paramaz.cEE;
      if ((parama == null) || (!parama.dvW()))
      {
        AppMethodBeat.o(33378);
        return;
        label302:
        if (parama.oG(localbi.field_msgId)) {
          i = 6;
        }
      }
      else
      {
        paramaz = new p(parama.field_content);
        if (((paramaz.time == 0L) && (parama.field_isSend == 0)) || ((parama.field_status == 1) && (parama.field_isSend == 1)))
        {
          AppMethodBeat.o(33378);
          return;
        }
        if ((parama.field_isSend != 0) || (paramaz.time != -1L))
        {
          ((d)localObject).dFI();
          aw.aaz();
          paramaz = (Boolean)c.Ru().get(4115, null);
          if ((paramaz == null) || (!paramaz.booleanValue()))
          {
            aw.aaz();
            c.Ru().set(4115, Boolean.TRUE);
            ((d)localObject).dFO();
            ((d)localObject).zww = t.a(((d)localObject).caz.zJz.getActivity(), ((d)localObject).context.getString(2131298264), 4000L);
          }
          if ((((d)localObject).mtU.isPlaying()) && (parama.field_msgId == ((d)localObject).zwt))
          {
            ((d)localObject).zwC = true;
            ((d)localObject).dFN();
            AppMethodBeat.o(33378);
            return;
          }
          ((d)localObject).av(parama);
          if ((parama.field_isSend == 0) && (!s.K(parama))) {
            ((d)localObject).Ph(i + 1);
          }
          ((d)localObject).qR(true);
        }
        AppMethodBeat.o(33378);
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao
 * JD-Core Version:    0.7.0.1
 */