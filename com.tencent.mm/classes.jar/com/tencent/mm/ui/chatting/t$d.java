package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.viewitems.bq;

public final class t$d
  implements View.OnLongClickListener
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
  public t$d(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.PhN = parama;
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(34594);
    Object localObject1 = new b();
    ((b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject1).axR());
    if (((u)this.PhN.bh(u.class)).gPO().gqI())
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return true;
    }
    if (((com.tencent.mm.ui.chatting.d.b.h)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu())
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return false;
    }
    if (((i)this.PhN.bh(i.class)).gPw())
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return false;
    }
    Object localObject3 = (bq)paramView.getTag();
    u localu = (u)this.PhN.bh(u.class);
    String str = localu.gPO().getLastText();
    int i = localu.gPO().getSelectionStart();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      if (((localObject3 != null) && (z.aTY().equals(((bq)localObject3).userName))) || (((bq)localObject3).userName.equals("notifymessage")) || (((bq)localObject3).userName.equals("appbrand_notify_message")))
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
        if (((u)this.PhN.bh(u.class)).gPO().getIsVoiceInputPanleShow())
        {
          Log.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(34594);
          return true;
        }
        localObject1 = (d)this.PhN.bh(d.class);
        Object localObject2;
        if ((ab.Eq(this.PhN.getTalkerUserName())) || (((d)localObject1).gOQ()))
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
          bg.aVF();
          localObject2 = c.aSX().Kd(((bq)localObject3).chatroomName);
          if (((d)localObject1).gOQ())
          {
            localObject1 = ((f)this.PhN.bh(f.class)).bmF(((bq)localObject3).userName);
            localObject2 = new StringBuffer(str);
            ((StringBuffer)localObject2).insert(i, "@" + localObject1 + ' ');
            localu.gPO().z(((StringBuffer)localObject2).toString(), i + ((CharSequence)localObject1).length() + 2, true);
            localObject2 = localu.gPO();
            str = ((bq)localObject3).chatroomName;
            localObject3 = ((bq)localObject3).userName;
            if (localObject1 != null) {
              break label649;
            }
            localObject1 = null;
            ((ChatFooter)localObject2).bj(str, (String)localObject3, (String)localObject1);
            localu.gPO().setMode(1);
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
        while ((!ab.IS(this.PhN.getTalkerUserName())) || (this.PhN.getTalkerUserName().contains("@"))) {
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(34594);
            return true;
            localObject2 = AtSomeoneUI.a((ah)localObject2, ((bq)localObject3).userName);
            localObject1 = localObject2;
            if (Util.isNullOrNil((CharSequence)localObject2))
            {
              localObject1 = aa.Iq(((bq)localObject3).userName);
              continue;
              localObject1 = ((CharSequence)localObject1).toString();
            }
          }
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
        if ((((d)localObject1).gOP()) && (!((d)localObject1).gOQ())) {}
        for (localObject1 = ((f)this.PhN.bh(f.class)).bmF(((bq)localObject3).userName);; localObject1 = aa.Iq(((bq)localObject3).userName))
        {
          localObject2 = new StringBuffer(str);
          ((StringBuffer)localObject2).insert(i, (CharSequence)localObject1);
          localu.gPO().z(((StringBuffer)localObject2).toString(), ((CharSequence)localObject1).length() + i, true);
          localu.gPO().setMode(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.d
 * JD-Core Version:    0.7.0.1
 */