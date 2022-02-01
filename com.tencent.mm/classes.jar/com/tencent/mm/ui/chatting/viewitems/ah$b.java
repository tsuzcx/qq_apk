package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.a.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.model.v;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

public final class ah$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public static boolean b(com.tencent.mm.ui.chatting.d.a parama, cc paramcc, String paramString)
  {
    AppMethodBeat.i(255162);
    ((com.tencent.mm.plugin.comm.a.c)h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    Object localObject = paramcc.field_content;
    if (localObject != null) {}
    for (paramcc = k.b.aP((String)localObject, paramcc.field_reserved);; paramcc = null)
    {
      if ((paramcc != null) && (paramcc.type == 60)) {
        try
        {
          if ((((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.n.a.p(parama.aezO.getContext(), true)) && (!com.tencent.mm.n.a.dm(parama.aezO.getContext())) && (!com.tencent.mm.n.a.dl(parama.aezO.getContext())) && (!com.tencent.mm.n.a.dp(parama.aezO.getContext()))))
          {
            localObject = (v)paramcc.aK(v.class);
            long l = Long.parseLong(((v)localObject).liveId);
            paramcc = ((v)localObject).mIA;
            localObject = ((v)localObject).thumbUrl;
            LiveConfig.a locala = new LiveConfig.a();
            locala.mIy = LiveConfig.mIs;
            locala.thumbUrl = ((String)localObject);
            locala.mIz = parama.getTalkerUserName();
            locala.liveId = l;
            locala.mIA = paramcc;
            locala.mIC = paramString;
            localObject = locala.bcd();
            paramcc = paramString;
            if (paramString == null) {
              paramcc = parama.Uxa.field_username;
            }
            com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq = paramcc;
            com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr = b.hF((int)parama.Uxa.maN);
            ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).liveEntranceJumper().c(parama.aezO.getContext(), (LiveConfig)localObject);
          }
          AppMethodBeat.o(255162);
          return true;
        }
        catch (Exception parama)
        {
          Log.w("MicroMsg.ChattingItemAppMsgShareLiveTo", "jump to live fail: %s", new Object[] { parama.getMessage() });
          AppMethodBeat.o(255162);
          return true;
        }
      }
      AppMethodBeat.o(255162);
      return false;
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(255173);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ghd);
      ((View)localObject).setTag(new ah.c((View)localObject, Boolean.TRUE));
    }
    AppMethodBeat.o(255173);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(255181);
    this.aeiK = parama1;
    String str;
    if ((parama instanceof ah.c))
    {
      str = paramcc.field_content;
      if (str == null) {
        break label207;
      }
    }
    for (paramString = k.b.aP(str, paramcc.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        ((ah.c)parama).aeRK.aZ(p.b(MMApplicationContext.getContext(), paramString.getTitle()));
        final long l = Long.parseLong(((v)paramString.aK(v.class)).liveId);
        paramString = parama1.getTalkerUserName();
        ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).refreshLiveStatus(l, paramString, new a.a()
        {
          public final void l(long paramAnonymousLong, int paramAnonymousInt)
          {
            AppMethodBeat.i(255071);
            if (l == paramAnonymousLong)
            {
              if (paramAnonymousInt != 1) {
                break label86;
              }
              ((ah.c)parama1).aeRL.setText(this.XSz.aezO.getContext().getResources().getString(R.l.gTt));
            }
            label86:
            do
            {
              ((ah.c)parama1).adDe.setVisibility(8);
              ((ah.c)parama1).aeRM.setVisibility(0);
              AppMethodBeat.o(255071);
              return;
              ((ah.c)parama1).aeRL.setText(this.XSz.aezO.getContext().getResources().getString(R.l.gTu));
              t localt = t.adCS;
            } while (!t.jjz());
            ((ah.c)parama1).adDe.setVisibility(0);
            ((ah.c)parama1).aeRM.setVisibility(8);
            AppMethodBeat.o(255071);
          }
        });
      }
      paramcc = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
      parama.clickArea.setTag(paramcc);
      parama.clickArea.setOnClickListener(d(parama1));
      parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
      parama.clickArea.setOnLongClickListener(c(parama1));
      Log.i("MicroMsg.ChattingItemAppMsgShareLiveTo", "filling");
      AppMethodBeat.o(255181);
      return;
      label207:
      Log.e("MicroMsg.ChattingItemAppMsgShareLiveTo", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramcc.field_msgId), paramString });
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255186);
    int i = ((bz)paramView.getTag()).position;
    if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!au.Hh(this.aeiK.getTalkerUserName()))) {
      params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
    }
    AppMethodBeat.o(255186);
    return true;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255189);
    boolean bool = b(parama, paramcc, a(parama, paramcc));
    AppMethodBeat.o(255189);
    return bool;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 855638065);
  }
  
  public final boolean fXn()
  {
    return true;
  }
  
  final boolean jxi()
  {
    return false;
  }
  
  protected final boolean jxk()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah.b
 * JD-Core Version:    0.7.0.1
 */