package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
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
import com.tencent.mm.live.d.f;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

public final class z$a
  extends c
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(194402);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131496164);
      ((View)localObject).setTag(new z.c((View)localObject, Boolean.TRUE));
    }
    AppMethodBeat.o(194402);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(194403);
    String str;
    if ((parama instanceof z.c))
    {
      str = parambu.field_content;
      if (str == null) {
        break label200;
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
            AppMethodBeat.i(194401);
            if (l == paramAnonymousLong)
            {
              if (paramAnonymousInt == 1)
              {
                ((z.c)parama1).KcU.setText(this.JYk.JOR.getContext().getResources().getString(2131766792));
                AppMethodBeat.o(194401);
                return;
              }
              ((z.c)parama1).KcU.setText(this.JYk.JOR.getContext().getResources().getString(2131766793));
            }
            AppMethodBeat.o(194401);
          }
        });
      }
      parambu = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
      parama.ofK.setTag(parambu);
      parama.ofK.setOnClickListener(d(parama1));
      parama.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
      parama.ofK.setOnLongClickListener(c(parama1));
      ad.i("MicroMsg.ChattingItemAppMsgShareLiveFrom", "filling");
      AppMethodBeat.o(194403);
      return;
      label200:
      ad.e("MicroMsg.ChattingItemAppMsgShareLiveFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambu.field_msgId), paramString });
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194404);
    paramView.getTag();
    AppMethodBeat.o(194404);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(194405);
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
            locala.gGx = LiveConfig.gGs;
            locala.thumbUrl = ((String)localObject);
            locala.gGz = parama.getTalkerUserName();
            locala.gGy = l;
            locala.gGA = paramView;
            locala.fromScene = LiveConfig.gGv;
            locala.gGC = parambu;
            paramView = locala.alb();
            ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().b(parama.JOR.getContext(), paramView);
            f.apY();
          }
          AppMethodBeat.o(194405);
          return true;
        }
        catch (Exception paramView)
        {
          ad.w("MicroMsg.ChattingItemAppMsgShareLiveFrom", "jump to live fail: %s", new Object[] { paramView.getMessage() });
        }
      }
      AppMethodBeat.o(194405);
      return false;
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 855638065);
  }
  
  public final boolean fHh()
  {
    return false;
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
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.a
 * JD-Core Version:    0.7.0.1
 */