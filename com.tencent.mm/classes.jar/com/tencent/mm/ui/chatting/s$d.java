package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bi;

public final class s$d
  implements View.OnLongClickListener
{
  private a Gob;
  
  public s$d(a parama)
  {
    this.Gob = parama;
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(34594);
    if (((q)this.Gob.be(q.class)).eXs().ezp())
    {
      ad.w("changelcai", "ChattingUI isScrolling!!!");
      AppMethodBeat.o(34594);
      return true;
    }
    Object localObject3 = (bi)paramView.getTag();
    q localq = (q)this.Gob.be(q.class);
    String str = localq.eXs().getLastText();
    int i = localq.eXs().getSelectionStart();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      if (((localObject3 != null) && (u.aqG().equals(((bi)localObject3).userName))) || (((bi)localObject3).userName.equals("notifymessage")) || (((bi)localObject3).userName.equals("appbrand_notify_message")))
      {
        AppMethodBeat.o(34594);
        return true;
        if (i > str.length()) {
          i = str.length();
        }
      }
      else
      {
        if (((q)this.Gob.be(q.class)).eXs().getIsVoiceInputPanleShow())
        {
          ad.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
          AppMethodBeat.o(34594);
          return true;
        }
        Object localObject1 = (d)this.Gob.be(d.class);
        Object localObject2;
        if ((com.tencent.mm.model.w.pF(this.Gob.getTalkerUserName())) || (((d)localObject1).eWD()))
        {
          h.vKh.f(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
          az.arV();
          localObject2 = c.apV().tH(((bi)localObject3).chatroomName);
          if (((d)localObject1).eWD())
          {
            localObject1 = ((f)this.Gob.be(f.class)).aKG(((bi)localObject3).userName);
            localObject2 = new StringBuffer(str);
            ((StringBuffer)localObject2).insert(i, "@" + localObject1 + ' ');
            localq.eXs().w(((StringBuffer)localObject2).toString(), i + ((CharSequence)localObject1).length() + 2, true);
            localObject2 = localq.eXs();
            str = ((bi)localObject3).chatroomName;
            localObject3 = ((bi)localObject3).userName;
            if (localObject1 != null) {
              break label495;
            }
            localObject1 = null;
            ((ChatFooter)localObject2).aN(str, (String)localObject3, (String)localObject1);
            localq.eXs().setMode(1);
            paramView.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(34592);
                AppMethodBeat.o(34592);
              }
            }, 2000L);
          }
        }
        label495:
        while ((!com.tencent.mm.model.w.sD(this.Gob.getTalkerUserName())) || (this.Gob.getTalkerUserName().contains("@"))) {
          for (;;)
          {
            AppMethodBeat.o(34594);
            return true;
            localObject2 = AtSomeoneUI.a((com.tencent.mm.storage.w)localObject2, ((bi)localObject3).userName);
            localObject1 = localObject2;
            if (bt.ai((CharSequence)localObject2))
            {
              localObject1 = v.sf(((bi)localObject3).userName);
              continue;
              localObject1 = ((CharSequence)localObject1).toString();
            }
          }
        }
        h.vKh.f(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
        if ((((d)localObject1).eWC()) && (!((d)localObject1).eWD())) {}
        for (localObject1 = ((f)this.Gob.be(f.class)).aKG(((bi)localObject3).userName);; localObject1 = v.sf(((bi)localObject3).userName))
        {
          localObject2 = new StringBuffer(str);
          ((StringBuffer)localObject2).insert(i, (CharSequence)localObject1);
          localq.eXs().w(((StringBuffer)localObject2).toString(), ((CharSequence)localObject1).length() + i, true);
          localq.eXs().setMode(1);
          paramView.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34593);
              AppMethodBeat.o(34593);
            }
          }, 2000L);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.d
 * JD-Core Version:    0.7.0.1
 */