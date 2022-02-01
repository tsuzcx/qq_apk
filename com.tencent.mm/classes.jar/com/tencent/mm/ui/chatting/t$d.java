package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.hk;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.viewitems.by;

public final class t$d
  implements View.OnLongClickListener
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
  public t$d(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.WBq = parama;
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(34594);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject1).aFi());
    if (((u)this.WBq.bC(u.class)).hPj().hlH())
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return true;
    }
    if (((com.tencent.mm.ui.chatting.d.b.h)this.WBq.bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOK())
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return false;
    }
    if (((i)this.WBq.bC(i.class)).hOP())
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return false;
    }
    Object localObject3 = (by)paramView.getTag();
    u localu = (u)this.WBq.bC(u.class);
    String str = localu.hPj().getLastText();
    int i = localu.hPj().getSelectionStart();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      if (((localObject3 != null) && (z.bcZ().equals(((by)localObject3).userName))) || (((by)localObject3).userName.equals("notifymessage")) || (((by)localObject3).userName.equals("appbrand_notify_message")))
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
        if (((u)this.WBq.bC(u.class)).hPj().getIsVoiceInputPanleShow())
        {
          Log.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(34594);
          return true;
        }
        Object localObject2 = (d)this.WBq.bC(d.class);
        ah localah;
        if ((ab.Lj(this.WBq.getTalkerUserName())) || (((d)localObject2).hOf()))
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
          bh.beI();
          localah = com.tencent.mm.model.c.bbV().Rw(((by)localObject3).chatroomName);
          if (((d)localObject2).hOf())
          {
            paramView = ((f)this.WBq.bC(f.class)).bzg(((by)localObject3).userName);
            localObject1 = new StringBuffer(str);
            ((StringBuffer)localObject1).insert(i, "@" + paramView + ' ');
            localu.hPj().D(((StringBuffer)localObject1).toString(), i + paramView.length() + 2, true);
            localObject1 = localu.hPj();
            str = ((by)localObject3).chatroomName;
            localObject3 = ((by)localObject3).userName;
            if (paramView != null) {
              break label711;
            }
            paramView = null;
            label556:
            ((ChatFooter)localObject1).be(str, (String)localObject3, paramView);
            localu.hPj().setMode(1);
            if ((!((d)localObject2).hOf()) && (localah != null))
            {
              paramView = new hk();
              if (!localah.Rh(z.bcZ())) {
                break label721;
              }
              i = 1;
            }
          }
        }
        for (;;)
        {
          label612:
          paramView.ggg = paramView.z("ChatName", this.WBq.getTalkerUserName(), true);
          paramView.ggi = localah.field_memberCount;
          paramView.ggh = i;
          paramView.bpa();
          localObject1 = com.tencent.mm.util.c.Yyz;
          com.tencent.mm.util.c.a(paramView);
          label711:
          label721:
          do
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(34594);
            return true;
            localObject1 = AtSomeoneUI.a(localah, ((by)localObject3).userName);
            paramView = (View)localObject1;
            if (!Util.isNullOrNil((CharSequence)localObject1)) {
              break;
            }
            paramView = aa.PH(((by)localObject3).userName);
            break;
            paramView = paramView.toString();
            break label556;
            if (!localah.bvA(z.bcZ())) {
              break label927;
            }
            i = 2;
            break label612;
          } while ((!ab.Ql(this.WBq.getTalkerUserName())) || (this.WBq.getTalkerUserName().contains("@")));
          com.tencent.mm.plugin.report.service.h.IzE.a(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
          if ((((d)localObject2).hOe()) && (!((d)localObject2).hOf())) {}
          for (localObject1 = ((f)this.WBq.bC(f.class)).bzg(((by)localObject3).userName);; localObject1 = aa.PH(((by)localObject3).userName))
          {
            localObject2 = new StringBuffer(str);
            ((StringBuffer)localObject2).insert(i, (CharSequence)localObject1);
            localu.hPj().D(((StringBuffer)localObject2).toString(), ((CharSequence)localObject1).length() + i, true);
            localu.hPj().setMode(1);
            paramView.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(34592);
                AppMethodBeat.o(34592);
              }
            }, 2000L);
            break;
          }
          label927:
          i = 3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.d
 * JD-Core Version:    0.7.0.1
 */