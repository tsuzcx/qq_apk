package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ji;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.g;
import com.tencent.mm.ui.chatting.component.api.i;
import com.tencent.mm.ui.chatting.component.api.k;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.viewitems.bz;

public final class v$d
  implements View.OnLongClickListener
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public v$d(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.aeiK = parama;
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(34594);
    Object localObject1 = new b();
    ((b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject1).aYj());
    if (((x)this.aeiK.cm(x.class)).jsd().iMy())
    {
      Log.i("MicroMsg.ChattingListAvatarListener", "onLongClick: isScrolling return");
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return true;
    }
    if (((i)this.aeiK.cm(i.class)).jrA())
    {
      Log.i("MicroMsg.ChattingListAvatarListener", "onLongClick: isFinderScene return:%s", new Object[] { this.aeiK.getTalkerUserName() });
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return false;
    }
    if (((k)this.aeiK.cm(k.class)).jrF())
    {
      Log.i("MicroMsg.ChattingListAvatarListener", "onLongClick: isGameLifeScene return:%s", new Object[] { this.aeiK.getTalkerUserName() });
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(34594);
      return false;
    }
    Object localObject3 = (bz)paramView.getTag();
    x localx = (x)this.aeiK.cm(x.class);
    String str = localx.jsd().getLastText();
    int i = localx.jsd().getSelectionStart();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      if (((localObject3 != null) && (z.bAM().equals(((bz)localObject3).userName))) || (((bz)localObject3).userName.equals("notifymessage")) || (((bz)localObject3).userName.equals("appbrand_notify_message")))
      {
        Log.i("MicroMsg.ChattingListAvatarListener", "onLongClick: tag.userName return %s", new Object[] { ((bz)localObject3).userName });
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(34594);
        return true;
        if (i > str.length()) {
          i = str.length();
        }
      }
      else
      {
        if (((x)this.aeiK.cm(x.class)).jsd().getIsVoiceInputPanleShow())
        {
          Log.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(34594);
          return true;
        }
        Object localObject2 = (e)this.aeiK.cm(e.class);
        aj localaj;
        if ((au.bwE(this.aeiK.getTalkerUserName())) || (((e)localObject2).jqW()))
        {
          h.OAn.b(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
          bh.bCz();
          localaj = com.tencent.mm.model.c.bzK().Ju(((bz)localObject3).chatroomName);
          if (((e)localObject2).jqW())
          {
            paramView = ((g)this.aeiK.cm(g.class)).bAK(((bz)localObject3).userName);
            localObject1 = new StringBuffer(str);
            ((StringBuffer)localObject1).insert(i, "@" + paramView + ' ');
            localx.jsd().F(((StringBuffer)localObject1).toString(), i + paramView.length() + 2, true);
            localObject1 = localx.jsd();
            str = ((bz)localObject3).chatroomName;
            localObject3 = ((bz)localObject3).userName;
            if (paramView != null) {
              break label779;
            }
            paramView = null;
            label624:
            ((ChatFooter)localObject1).by(str, (String)localObject3, paramView);
            localx.jsd().setMode(1);
            if ((!((e)localObject2).jqW()) && (localaj != null))
            {
              paramView = new ji();
              if (!localaj.Jf(z.bAM())) {
                break label789;
              }
              i = 1;
            }
          }
        }
        for (;;)
        {
          label680:
          paramView.imN = paramView.F("ChatName", this.aeiK.getTalkerUserName(), true);
          paramView.imZ = localaj.field_memberCount;
          paramView.imY = i;
          paramView.bMH();
          localObject1 = com.tencent.mm.util.c.agsX;
          com.tencent.mm.util.c.a(paramView);
          label779:
          label789:
          do
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(34594);
            return true;
            localObject1 = AtSomeoneUI.a(localaj, ((bz)localObject3).userName);
            paramView = (View)localObject1;
            if (!Util.isNullOrNil((CharSequence)localObject1)) {
              break;
            }
            paramView = aa.IC(((bz)localObject3).userName);
            break;
            paramView = paramView.toString();
            break label624;
            if (!localaj.bvK(z.bAM())) {
              break label1017;
            }
            i = 2;
            break label680;
          } while ((!ab.IR(this.aeiK.getTalkerUserName())) || (this.aeiK.getTalkerUserName().contains("@")));
          Log.i("MicroMsg.ChattingListAvatarListener", "onLongClick special - talker:%s", new Object[] { this.aeiK.getTalkerUserName() });
          h.OAn.b(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
          if ((((e)localObject2).jqV()) && (!((e)localObject2).jqW())) {}
          for (localObject1 = ((g)this.aeiK.cm(g.class)).bAK(((bz)localObject3).userName);; localObject1 = aa.IC(((bz)localObject3).userName))
          {
            localObject2 = new StringBuffer(str);
            ((StringBuffer)localObject2).insert(i, (CharSequence)localObject1);
            localx.jsd().F(((StringBuffer)localObject2).toString(), ((CharSequence)localObject1).length() + i, true);
            localx.jsd().setMode(1);
            paramView.postDelayed(new v.d.1(this), 2000L);
            break;
          }
          label1017:
          i = 3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v.d
 * JD-Core Version:    0.7.0.1
 */