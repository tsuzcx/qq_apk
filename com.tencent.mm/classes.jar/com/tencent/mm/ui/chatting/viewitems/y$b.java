package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.a.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.l;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.widget.MMTextView;

public final class y$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(196718);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131496165);
      ((View)localObject).setTag(new y.c((View)localObject, Boolean.TRUE));
    }
    AppMethodBeat.o(196718);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(196719);
    this.HNS = parama1;
    String str;
    if ((parama instanceof y.c))
    {
      str = parambo.field_content;
      if (str == null) {
        break label205;
      }
    }
    for (paramString = k.b.az(str, parambo.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        ((y.c)parama).Imv.setText(k.c(com.tencent.mm.sdk.platformtools.ai.getContext(), paramString.getTitle()));
        final long l = Long.parseLong(((l)paramString.ao(l.class)).gvC);
        paramString = parama1.getTalkerUserName();
        ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).refreshLiveStatus(l, paramString, new a.a()
        {
          public final void c(long paramAnonymousLong, int paramAnonymousInt)
          {
            AppMethodBeat.i(196717);
            if (l == paramAnonymousLong)
            {
              if (paramAnonymousInt == 1)
              {
                ((y.c)parama1).Imw.setText(this.Iiv.HZF.getContext().getResources().getString(2131766792));
                AppMethodBeat.o(196717);
                return;
              }
              ((y.c)parama1).Imw.setText(this.Iiv.HZF.getContext().getResources().getString(2131766793));
            }
            AppMethodBeat.o(196717);
          }
        });
      }
      parambo = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
      parama.nDl.setTag(parambo);
      parama.nDl.setOnClickListener(d(parama1));
      parama.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
      parama.nDl.setOnLongClickListener(c(parama1));
      ac.i("MicroMsg.ChattingItemAppMsgShareLiveTo", "filling");
      AppMethodBeat.o(196719);
      return;
      label205:
      ac.e("MicroMsg.ChattingItemAppMsgShareLiveTo", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambo.field_msgId), paramString });
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(196720);
    int i = ((bj)paramView.getTag()).position;
    if (((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker)) && (!com.tencent.mm.storage.ai.vC(this.HNS.getTalkerUserName()))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
    }
    AppMethodBeat.o(196720);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(196721);
    ((b)g.ab(b.class)).Wm(parambo.field_talker);
    paramView = parambo.field_content;
    if (paramView != null) {}
    for (paramView = k.b.az(paramView, parambo.field_reserved);; paramView = null)
    {
      if ((paramView != null) && (paramView.type == 60)) {
        try
        {
          if ((((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.r.a.cg(parama.HZF.getContext())) && (!com.tencent.mm.r.a.ci(parama.HZF.getContext())) && (!com.tencent.mm.r.a.cf(parama.HZF.getContext())) && (!com.tencent.mm.r.a.ck(parama.HZF.getContext()))))
          {
            Object localObject = (l)paramView.ao(l.class);
            long l = Long.parseLong(((l)localObject).gvC);
            paramView = ((l)localObject).gmR;
            localObject = ((l)localObject).thumbUrl;
            parambo = b(parama, parambo);
            LiveConfig.a locala = new LiveConfig.a();
            locala.gmO = LiveConfig.gmI;
            locala.thumbUrl = ((String)localObject);
            locala.gmQ = parama.getTalkerUserName();
            locala.gmP = l;
            locala.gmR = paramView;
            locala.gmT = parambo;
            paramView = locala.aip();
            ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(parama.HZF.getContext(), paramView);
          }
          AppMethodBeat.o(196721);
          return true;
        }
        catch (Exception paramView)
        {
          ac.w("MicroMsg.ChattingItemAppMsgShareLiveTo", "jump to live fail: %s", new Object[] { paramView.getMessage() });
          AppMethodBeat.o(196721);
          return true;
        }
      }
      AppMethodBeat.o(196721);
      return false;
    }
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 855638065);
  }
  
  public final boolean fqu()
  {
    return true;
  }
  
  final boolean fqv()
  {
    return false;
  }
  
  protected final boolean fqx()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.b
 * JD-Core Version:    0.7.0.1
 */