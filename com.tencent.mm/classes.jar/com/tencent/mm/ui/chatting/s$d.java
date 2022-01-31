package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.az;

public final class s$d
  implements View.OnLongClickListener
{
  private a zzP;
  
  public s$d(a parama)
  {
    this.zzP = parama;
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(30720);
    if (((o)this.zzP.ay(o.class)).dIg().doA())
    {
      ab.w("changelcai", "ChattingUI isScrolling!!!");
      AppMethodBeat.o(30720);
      return true;
    }
    Object localObject3 = (az)paramView.getTag();
    o localo = (o)this.zzP.ay(o.class);
    String str = localo.dIg().getLastText();
    int i = localo.dIg().getSelectionStart();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      if ((((az)localObject3).userName.equals(r.Zn())) || (((az)localObject3).userName.equals("notifymessage")))
      {
        AppMethodBeat.o(30720);
        return true;
        if (i > str.length()) {
          i = str.length();
        }
      }
      else
      {
        if (((o)this.zzP.ay(o.class)).dIg().getIsVoiceInputPanleShow())
        {
          ab.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
          AppMethodBeat.o(30720);
          return true;
        }
        Object localObject1 = (d)this.zzP.ay(d.class);
        Object localObject2;
        if ((t.lA(this.zzP.getTalkerUserName())) || (((d)localObject1).dHw()))
        {
          h.qsU.e(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
          aw.aaz();
          localObject2 = c.YJ().oU(((az)localObject3).chatroomName);
          if (((d)localObject1).dHw())
          {
            localObject1 = ((f)this.zzP.ay(f.class)).atS(((az)localObject3).userName);
            localObject2 = new StringBuffer(str);
            ((StringBuffer)localObject2).insert(i, "@" + localObject1 + ' ');
            localo.dIg().u(((StringBuffer)localObject2).toString(), i + ((CharSequence)localObject1).length() + 2, true);
            localObject2 = localo.dIg();
            str = ((az)localObject3).chatroomName;
            localObject3 = ((az)localObject3).userName;
            if (localObject1 != null) {
              break label482;
            }
            localObject1 = null;
            ((ChatFooter)localObject2).aA(str, (String)localObject3, (String)localObject1);
            localo.dIg().setMode(1);
            paramView.postDelayed(new s.d.1(this), 2000L);
          }
        }
        label482:
        while ((!t.nT(this.zzP.getTalkerUserName())) || (this.zzP.getTalkerUserName().contains("@"))) {
          for (;;)
          {
            AppMethodBeat.o(30720);
            return true;
            localObject2 = AtSomeoneUI.a((u)localObject2, ((az)localObject3).userName);
            localObject1 = localObject2;
            if (bo.aa((CharSequence)localObject2))
            {
              localObject1 = s.nC(((az)localObject3).userName);
              continue;
              localObject1 = ((CharSequence)localObject1).toString();
            }
          }
        }
        h.qsU.e(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
        if ((((d)localObject1).dHv()) && (!((d)localObject1).dHw())) {}
        for (localObject1 = ((f)this.zzP.ay(f.class)).atS(((az)localObject3).userName);; localObject1 = s.nC(((az)localObject3).userName))
        {
          localObject2 = new StringBuffer(str);
          ((StringBuffer)localObject2).insert(i, (CharSequence)localObject1);
          localo.dIg().u(((StringBuffer)localObject2).toString(), ((CharSequence)localObject1).length() + i, true);
          localo.dIg().setMode(1);
          paramView.postDelayed(new s.d.2(this), 2000L);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.d
 * JD-Core Version:    0.7.0.1
 */