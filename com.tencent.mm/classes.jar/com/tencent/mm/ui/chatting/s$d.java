package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.h;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.viewitems.bk;

public final class s$d
  implements View.OnLongClickListener
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
  public s$d(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.JBI = parama;
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(34594);
    Object localObject1 = new b();
    ((b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject1).ahq());
    if (((s)this.JBI.bh(s.class)).fDC().fdJ())
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return true;
    }
    if (((h)this.JBI.bh(h.class)).fDl())
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return false;
    }
    Object localObject3 = (bk)paramView.getTag();
    s locals = (s)this.JBI.bh(s.class);
    String str = locals.fDC().getLastText();
    int i = locals.fDC().getSelectionStart();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      if (((localObject3 != null) && (u.aAm().equals(((bk)localObject3).userName))) || (((bk)localObject3).userName.equals("notifymessage")) || (((bk)localObject3).userName.equals("appbrand_notify_message")))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(34594);
        return true;
        if (i > str.length()) {
          i = str.length();
        }
      }
      else
      {
        if (((s)this.JBI.bh(s.class)).fDC().getIsVoiceInputPanleShow())
        {
          ad.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(34594);
          return true;
        }
        localObject1 = (d)this.JBI.bh(d.class);
        Object localObject2;
        if ((w.vF(this.JBI.getTalkerUserName())) || (((d)localObject1).fCI()))
        {
          g.yhR.f(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
          ba.aBQ();
          localObject2 = c.azz().AN(((bk)localObject3).chatroomName);
          if (((d)localObject1).fCI())
          {
            localObject1 = ((f)this.JBI.bh(f.class)).aWa(((bk)localObject3).userName);
            localObject2 = new StringBuffer(str);
            ((StringBuffer)localObject2).insert(i, "@" + localObject1 + ' ');
            locals.fDC().w(((StringBuffer)localObject2).toString(), i + ((CharSequence)localObject1).length() + 2, true);
            localObject2 = locals.fDC();
            str = ((bk)localObject3).chatroomName;
            localObject3 = ((bk)localObject3).userName;
            if (localObject1 != null) {
              break label609;
            }
            localObject1 = null;
            ((ChatFooter)localObject2).aY(str, (String)localObject3, (String)localObject1);
            locals.fDC().setMode(1);
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
        label609:
        while ((!w.zD(this.JBI.getTalkerUserName())) || (this.JBI.getTalkerUserName().contains("@"))) {
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(34594);
            return true;
            localObject2 = AtSomeoneUI.a((ab)localObject2, ((bk)localObject3).userName);
            localObject1 = localObject2;
            if (bt.ai((CharSequence)localObject2))
            {
              localObject1 = v.zd(((bk)localObject3).userName);
              continue;
              localObject1 = ((CharSequence)localObject1).toString();
            }
          }
        }
        g.yhR.f(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
        if ((((d)localObject1).fCH()) && (!((d)localObject1).fCI())) {}
        for (localObject1 = ((f)this.JBI.bh(f.class)).aWa(((bk)localObject3).userName);; localObject1 = v.zd(((bk)localObject3).userName))
        {
          localObject2 = new StringBuffer(str);
          ((StringBuffer)localObject2).insert(i, (CharSequence)localObject1);
          locals.fDC().w(((StringBuffer)localObject2).toString(), ((CharSequence)localObject1).length() + i, true);
          locals.fDC().setMode(1);
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