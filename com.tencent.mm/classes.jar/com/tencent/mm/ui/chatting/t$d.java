package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.h;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.viewitems.bk;

public final class t$d
  implements View.OnLongClickListener
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
  public t$d(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.JWz = parama;
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(34594);
    Object localObject1 = new b();
    ((b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject1).ahF());
    if (((s)this.JWz.bh(s.class)).fHF().fhy())
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return true;
    }
    if (((h)this.JWz.bh(h.class)).fHo())
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return false;
    }
    if (((i)this.JWz.bh(i.class)).fHq())
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return false;
    }
    Object localObject3 = (bk)paramView.getTag();
    s locals = (s)this.JWz.bh(s.class);
    String str = locals.fHF().getLastText();
    int i = locals.fHF().getSelectionStart();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      if (((localObject3 != null) && (v.aAC().equals(((bk)localObject3).userName))) || (((bk)localObject3).userName.equals("notifymessage")) || (((bk)localObject3).userName.equals("appbrand_notify_message")))
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
        if (((s)this.JWz.bh(s.class)).fHF().getIsVoiceInputPanleShow())
        {
          ae.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(34594);
          return true;
        }
        localObject1 = (d)this.JWz.bh(d.class);
        Object localObject2;
        if ((x.wb(this.JWz.getTalkerUserName())) || (((d)localObject1).fGK()))
        {
          g.yxI.f(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
          bc.aCg();
          localObject2 = c.azP().Bx(((bk)localObject3).chatroomName);
          if (((d)localObject1).fGK())
          {
            localObject1 = ((f)this.JWz.bh(f.class)).aXB(((bk)localObject3).userName);
            localObject2 = new StringBuffer(str);
            ((StringBuffer)localObject2).insert(i, "@" + localObject1 + ' ');
            locals.fHF().w(((StringBuffer)localObject2).toString(), i + ((CharSequence)localObject1).length() + 2, true);
            localObject2 = locals.fHF();
            str = ((bk)localObject3).chatroomName;
            localObject3 = ((bk)localObject3).userName;
            if (localObject1 != null) {
              break label649;
            }
            localObject1 = null;
            ((ChatFooter)localObject2).aZ(str, (String)localObject3, (String)localObject1);
            locals.fHF().setMode(1);
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
        label649:
        while ((!x.An(this.JWz.getTalkerUserName())) || (this.JWz.getTalkerUserName().contains("@"))) {
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(34594);
            return true;
            localObject2 = AtSomeoneUI.a((ac)localObject2, ((bk)localObject3).userName);
            localObject1 = localObject2;
            if (bu.ah((CharSequence)localObject2))
            {
              localObject1 = w.zN(((bk)localObject3).userName);
              continue;
              localObject1 = ((CharSequence)localObject1).toString();
            }
          }
        }
        g.yxI.f(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
        if ((((d)localObject1).fGJ()) && (!((d)localObject1).fGK())) {}
        for (localObject1 = ((f)this.JWz.bh(f.class)).aXB(((bk)localObject3).userName);; localObject1 = w.zN(((bk)localObject3).userName))
        {
          localObject2 = new StringBuffer(str);
          ((StringBuffer)localObject2).insert(i, (CharSequence)localObject1);
          locals.fHF().w(((StringBuffer)localObject2).toString(), ((CharSequence)localObject1).length() + i, true);
          locals.fHF().setMode(1);
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
 * Qualified Name:     com.tencent.mm.ui.chatting.t.d
 * JD-Core Version:    0.7.0.1
 */