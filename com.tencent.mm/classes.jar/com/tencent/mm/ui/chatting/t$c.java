package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.b.b.e;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.aw;

public final class t$c
  implements View.OnLongClickListener
{
  private a vko;
  
  public t$c(a parama)
  {
    this.vko = parama;
  }
  
  public final boolean onLongClick(View paramView)
  {
    if (((n)this.vko.ac(n.class)).cEq().cnC()) {
      y.w("changelcai", "ChattingUI isScrolling!!!");
    }
    Object localObject2;
    int i;
    do
    {
      return true;
      localObject2 = (aw)paramView.getTag();
      i = ((n)this.vko.ac(n.class)).cEq().getSelectionStart();
    } while ((((aw)localObject2).userName.equals(q.Gj())) || (((aw)localObject2).userName.equals("notifymessage")));
    if (((n)this.vko.ac(n.class)).cEq().getIsVoiceInputPanleShow())
    {
      y.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
      return true;
    }
    Object localObject1 = (com.tencent.mm.ui.chatting.b.b.c)this.vko.ac(com.tencent.mm.ui.chatting.b.b.c.class);
    Object localObject3;
    if ((s.fn(this.vko.getTalkerUserName())) || (((com.tencent.mm.ui.chatting.b.b.c)localObject1).cDH()))
    {
      h.nFQ.f(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
      au.Hx();
      localObject3 = com.tencent.mm.model.c.FF().in(((aw)localObject2).chatroomName);
      if (((com.tencent.mm.ui.chatting.b.b.c)localObject1).cDH()) {
        localObject1 = ((e)this.vko.ac(e.class)).adr(((aw)localObject2).userName);
      }
    }
    label646:
    for (;;)
    {
      localObject3 = (n)this.vko.ac(n.class);
      Object localObject4 = new StringBuffer(((n)localObject3).cEq().getLastText());
      ((StringBuffer)localObject4).insert(i, "@" + localObject1 + ' ');
      ((n)localObject3).cEq().r(((StringBuffer)localObject4).toString(), i + ((CharSequence)localObject1).length() + 2, true);
      localObject4 = ((n)localObject3).cEq();
      String str = ((aw)localObject2).chatroomName;
      localObject2 = ((aw)localObject2).userName;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((CharSequence)localObject1).toString())
      {
        ((ChatFooter)localObject4).ak(str, (String)localObject2, (String)localObject1);
        ((n)localObject3).cEq().setMode(1);
        paramView.postDelayed(new t.c.1(this), 2000L);
        return true;
        localObject1 = AtSomeoneUI.a((u)localObject3, ((aw)localObject2).userName);
        if (!bk.L((CharSequence)localObject1)) {
          break label646;
        }
        localObject1 = r.gT(((aw)localObject2).userName);
        break;
      }
      if ((!s.hk(this.vko.getTalkerUserName())) || (this.vko.getTalkerUserName().contains("@"))) {
        break;
      }
      h.nFQ.f(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
      if ((((com.tencent.mm.ui.chatting.b.b.c)localObject1).cDG()) && (!((com.tencent.mm.ui.chatting.b.b.c)localObject1).cDH())) {}
      for (localObject1 = ((e)this.vko.ac(e.class)).adr(((aw)localObject2).userName);; localObject1 = r.gT(((aw)localObject2).userName))
      {
        localObject2 = (n)this.vko.ac(n.class);
        localObject3 = new StringBuffer(((n)localObject2).cEq().getLastText());
        ((StringBuffer)localObject3).insert(i, (CharSequence)localObject1);
        ((n)localObject2).cEq().r(((StringBuffer)localObject3).toString(), ((CharSequence)localObject1).length() + i, true);
        ((n)localObject2).cEq().setMode(1);
        paramView.postDelayed(new t.c.2(this), 2000L);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.c
 * JD-Core Version:    0.7.0.1
 */