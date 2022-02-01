package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.a.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

public final class z$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(194407);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131496165);
      ((View)localObject).setTag(new z.c((View)localObject, Boolean.TRUE));
    }
    AppMethodBeat.o(194407);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(194408);
    this.JBI = parama1;
    String str;
    if ((parama instanceof z.c))
    {
      str = parambu.field_content;
      if (str == null) {
        break label205;
      }
    }
    for (paramString = k.b.aA(str, parambu.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        ((z.c)parama).KcT.ar(com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), paramString.getTitle()));
        final long l = Long.parseLong(((com.tencent.mm.live.b.l)paramString.ao(com.tencent.mm.live.b.l.class)).gPn);
        paramString = parama1.getTalkerUserName();
        ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).refreshLiveStatus(l, paramString, new a.a()
        {
          public final void c(long paramAnonymousLong, int paramAnonymousInt)
          {
            AppMethodBeat.i(194406);
            if (l == paramAnonymousLong)
            {
              if (paramAnonymousInt == 1)
              {
                ((z.c)parama1).KcU.setText(this.JYk.JOR.getContext().getResources().getString(2131766792));
                AppMethodBeat.o(194406);
                return;
              }
              ((z.c)parama1).KcU.setText(this.JYk.JOR.getContext().getResources().getString(2131766793));
            }
            AppMethodBeat.o(194406);
          }
        });
      }
      parambu = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
      parama.ofK.setTag(parambu);
      parama.ofK.setOnClickListener(d(parama1));
      parama.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
      parama.ofK.setOnLongClickListener(c(parama1));
      ad.i("MicroMsg.ChattingItemAppMsgShareLiveTo", "filling");
      AppMethodBeat.o(194408);
      return;
      label205:
      ad.e("MicroMsg.ChattingItemAppMsgShareLiveTo", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambu.field_msgId), paramString });
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194409);
    int i = ((bk)paramView.getTag()).position;
    if (((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker)) && (!am.yt(this.JBI.getTalkerUserName()))) {
      paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
    }
    AppMethodBeat.o(194409);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(194410);
    ((b)g.ab(b.class)).ZT(parambu.field_talker);
    paramView = parambu.field_content;
    if (paramView != null) {}
    for (paramView = k.b.aA(paramView, parambu.field_reserved);; paramView = null)
    {
      if ((paramView != null) && (paramView.type == 60)) {
        try
        {
          if ((((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.s.a.n(parama.JOR.getContext(), true)) && (!com.tencent.mm.s.a.cf(parama.JOR.getContext())) && (!com.tencent.mm.s.a.cd(parama.JOR.getContext())) && (!com.tencent.mm.s.a.ch(parama.JOR.getContext()))))
          {
            Object localObject = (com.tencent.mm.live.b.l)paramView.ao(com.tencent.mm.live.b.l.class);
            long l = Long.parseLong(((com.tencent.mm.live.b.l)localObject).gPn);
            paramView = ((com.tencent.mm.live.b.l)localObject).gGA;
            localObject = ((com.tencent.mm.live.b.l)localObject).thumbUrl;
            parambu = b(parama, parambu);
            LiveConfig.a locala = new LiveConfig.a();
            locala.gGx = LiveConfig.gGr;
            locala.thumbUrl = ((String)localObject);
            locala.gGz = parama.getTalkerUserName();
            locala.gGy = l;
            locala.gGA = paramView;
            locala.gGC = parambu;
            paramView = locala.alb();
            ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(parama.JOR.getContext(), paramView);
          }
          AppMethodBeat.o(194410);
          return true;
        }
        catch (Exception paramView)
        {
          ad.w("MicroMsg.ChattingItemAppMsgShareLiveTo", "jump to live fail: %s", new Object[] { paramView.getMessage() });
          AppMethodBeat.o(194410);
          return true;
        }
      }
      AppMethodBeat.o(194410);
      return false;
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 855638065);
  }
  
  public final boolean fHh()
  {
    return true;
  }
  
  final boolean fHi()
  {
    return false;
  }
  
  protected final boolean fHk()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.b
 * JD-Core Version:    0.7.0.1
 */