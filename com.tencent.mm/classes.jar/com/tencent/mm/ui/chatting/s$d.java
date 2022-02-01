package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bj;

public final class s$d
  implements View.OnLongClickListener
{
  private a HNS;
  
  public s$d(a parama)
  {
    this.HNS = parama;
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(34594);
    if (((q)this.HNS.bf(q.class)).fne().eOJ())
    {
      ac.w("changelcai", "ChattingUI isScrolling!!!");
      AppMethodBeat.o(34594);
      return true;
    }
    Object localObject3 = (bj)paramView.getTag();
    q localq = (q)this.HNS.bf(q.class);
    String str = localq.fne().getLastText();
    int i = localq.fne().getSelectionStart();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      if (((localObject3 != null) && (u.axw().equals(((bj)localObject3).userName))) || (((bj)localObject3).userName.equals("notifymessage")) || (((bj)localObject3).userName.equals("appbrand_notify_message")))
      {
        AppMethodBeat.o(34594);
        return true;
        if (i > str.length()) {
          i = str.length();
        }
      }
      else
      {
        if (((q)this.HNS.bf(q.class)).fne().getIsVoiceInputPanleShow())
        {
          ac.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
          AppMethodBeat.o(34594);
          return true;
        }
        Object localObject1 = (d)this.HNS.bf(d.class);
        Object localObject2;
        if ((w.sQ(this.HNS.getTalkerUserName())) || (((d)localObject1).fmp()))
        {
          h.wUl.f(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
          az.ayM();
          localObject2 = c.awK().xN(((bj)localObject3).chatroomName);
          if (((d)localObject1).fmp())
          {
            localObject1 = ((f)this.HNS.bf(f.class)).aQj(((bj)localObject3).userName);
            localObject2 = new StringBuffer(str);
            ((StringBuffer)localObject2).insert(i, "@" + localObject1 + ' ');
            localq.fne().w(((StringBuffer)localObject2).toString(), i + ((CharSequence)localObject1).length() + 2, true);
            localObject2 = localq.fne();
            str = ((bj)localObject3).chatroomName;
            localObject3 = ((bj)localObject3).userName;
            if (localObject1 != null) {
              break label495;
            }
            localObject1 = null;
            ((ChatFooter)localObject2).aQ(str, (String)localObject3, (String)localObject1);
            localq.fne().setMode(1);
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
        while ((!w.wG(this.HNS.getTalkerUserName())) || (this.HNS.getTalkerUserName().contains("@"))) {
          for (;;)
          {
            AppMethodBeat.o(34594);
            return true;
            localObject2 = AtSomeoneUI.a((x)localObject2, ((bj)localObject3).userName);
            localObject1 = localObject2;
            if (bs.aj((CharSequence)localObject2))
            {
              localObject1 = v.wi(((bj)localObject3).userName);
              continue;
              localObject1 = ((CharSequence)localObject1).toString();
            }
          }
        }
        h.wUl.f(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
        if ((((d)localObject1).fmo()) && (!((d)localObject1).fmp())) {}
        for (localObject1 = ((f)this.HNS.bf(f.class)).aQj(((bj)localObject3).userName);; localObject1 = v.wi(((bj)localObject3).userName))
        {
          localObject2 = new StringBuffer(str);
          ((StringBuffer)localObject2).insert(i, (CharSequence)localObject1);
          localq.fne().w(((StringBuffer)localObject2).toString(), ((CharSequence)localObject1).length() + i, true);
          localq.fne().setMode(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.d
 * JD-Core Version:    0.7.0.1
 */