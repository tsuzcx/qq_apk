package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.a.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.v;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

public final class ai$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(244254);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.een);
      ((View)localObject).setTag(new ai.c((View)localObject, Boolean.TRUE));
    }
    AppMethodBeat.o(244254);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(244255);
    this.WBq = parama1;
    String str;
    if ((parama instanceof ai.c))
    {
      str = paramca.field_content;
      if (str == null) {
        break label205;
      }
    }
    for (paramString = k.b.aG(str, paramca.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        ((ai.c)parama).XhE.aL(l.c(MMApplicationContext.getContext(), paramString.getTitle()));
        final long l = Long.parseLong(((v)paramString.ar(v.class)).kwM);
        paramString = parama1.getTalkerUserName();
        ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).refreshLiveStatus(l, paramString, new a.a()
        {
          public final void d(long paramAnonymousLong, int paramAnonymousInt)
          {
            AppMethodBeat.i(272691);
            if (l == paramAnonymousLong)
            {
              if (paramAnonymousInt != 1) {
                break label86;
              }
              ((ai.c)parama1).XhF.setText(this.QWD.WQv.getContext().getResources().getString(R.l.eQN));
            }
            label86:
            do
            {
              ((ai.c)parama1).VYJ.setVisibility(8);
              ((ai.c)parama1).XhG.setVisibility(0);
              AppMethodBeat.o(272691);
              return;
              ((ai.c)parama1).XhF.setText(this.QWD.WQv.getContext().getResources().getString(R.l.eQO));
              r localr = r.VYx;
            } while (!r.hHo());
            ((ai.c)parama1).VYJ.setVisibility(0);
            ((ai.c)parama1).XhG.setVisibility(8);
            AppMethodBeat.o(272691);
          }
        });
      }
      paramca = new by(paramca, parama1.hRi(), paramInt, null, '\000');
      parama.clickArea.setTag(paramca);
      parama.clickArea.setOnClickListener(d(parama1));
      parama.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
      parama.clickArea.setOnLongClickListener(c(parama1));
      Log.i("MicroMsg.ChattingItemAppMsgShareLiveTo", "filling");
      AppMethodBeat.o(244255);
      return;
      label205:
      Log.e("MicroMsg.ChattingItemAppMsgShareLiveTo", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramca.field_msgId), paramString });
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(244256);
    int i = ((by)paramView.getTag()).position;
    if (((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker)) && (!as.OS(this.WBq.getTalkerUserName()))) {
      paramo.a(i, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
    }
    AppMethodBeat.o(244256);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 855638065);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(244257);
    ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
    paramView = paramca.field_content;
    if (paramView != null) {}
    for (paramView = k.b.aG(paramView, paramca.field_reserved);; paramView = null)
    {
      if ((paramView != null) && (paramView.type == 60)) {
        try
        {
          if ((((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.q.a.p(parama.WQv.getContext(), true)) && (!com.tencent.mm.q.a.cy(parama.WQv.getContext())) && (!com.tencent.mm.q.a.cw(parama.WQv.getContext())) && (!com.tencent.mm.q.a.cB(parama.WQv.getContext()))))
          {
            Object localObject = (v)paramView.ar(v.class);
            long l = Long.parseLong(((v)localObject).kwM);
            paramView = ((v)localObject).kie;
            localObject = ((v)localObject).thumbUrl;
            paramca = a(parama, paramca);
            LiveConfig.a locala = new LiveConfig.a();
            locala.kic = LiveConfig.khW;
            locala.thumbUrl = ((String)localObject);
            locala.kid = parama.getTalkerUserName();
            locala.liveId = l;
            locala.kie = paramView;
            locala.kig = paramca;
            localObject = locala.aJw();
            paramView = paramca;
            if (paramca == null) {
              paramView = parama.NKq.field_username;
            }
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl = paramView;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm = com.tencent.mm.plugin.expt.hellhound.core.b.Fw((int)parama.NKq.jxt);
            ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).liveEntranceJumper().c(parama.WQv.getContext(), (LiveConfig)localObject);
          }
          AppMethodBeat.o(244257);
          return true;
        }
        catch (Exception paramView)
        {
          Log.w("MicroMsg.ChattingItemAppMsgShareLiveTo", "jump to live fail: %s", new Object[] { paramView.getMessage() });
          AppMethodBeat.o(244257);
          return true;
        }
      }
      AppMethodBeat.o(244257);
      return false;
    }
  }
  
  public final boolean hTD()
  {
    return true;
  }
  
  final boolean hTF()
  {
    return false;
  }
  
  protected final boolean hTH()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.b
 * JD-Core Version:    0.7.0.1
 */