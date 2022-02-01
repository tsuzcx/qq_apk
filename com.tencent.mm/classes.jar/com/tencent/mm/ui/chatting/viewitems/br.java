package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.a.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.d.f;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.widget.MMTextView;

public final class br
{
  public static final class a
    extends c
  {
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(204975);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new af(paramLayoutInflater, 2131494167);
        ((View)localObject).setTag(new br.c((View)localObject, Boolean.TRUE));
      }
      AppMethodBeat.o(204975);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(204976);
      String str;
      if ((parama instanceof br.c))
      {
        str = parambl.field_content;
        if (str == null) {
          break label200;
        }
      }
      for (paramString = k.b.ar(str, parambl.field_reserved);; paramString = null)
      {
        if (paramString != null)
        {
          ((br.c)parama).LCU.setText(com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), paramString.getTitle()));
          final long l = Long.parseLong(((com.tencent.mm.live.b.k)paramString.ao(com.tencent.mm.live.b.k.class)).zaR);
          paramString = parama1.getTalkerUserName();
          ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).refreshLiveStatus(l, paramString, new a.a()
          {
            public final void ak(long paramAnonymousLong, int paramAnonymousInt)
            {
              AppMethodBeat.i(204974);
              if (l == paramAnonymousLong)
              {
                if (paramAnonymousInt == 1)
                {
                  ((br.c)parama1).LCV.setText(this.GIy.GzJ.getContext().getResources().getString(2131766754));
                  AppMethodBeat.o(204974);
                  return;
                }
                ((br.c)parama1).LCV.setText(this.GIy.GzJ.getContext().getResources().getString(2131766755));
              }
              AppMethodBeat.o(204974);
            }
          });
        }
        parambl = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
        parama.naN.setTag(parambl);
        parama.naN.setOnClickListener(d(parama1));
        parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
        parama.naN.setOnLongClickListener(c(parama1));
        ad.i("MicroMsg.ChattingItemAppMsgShareLiveFrom", "filling");
        AppMethodBeat.o(204976);
        return;
        label200:
        ad.e("MicroMsg.ChattingItemAppMsgShareLiveFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambl.field_msgId), paramString });
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(204977);
      paramContextMenu.add(((bi)paramView.getTag()).position, 136, 0, paramView.getContext().getString(2131757226));
      AppMethodBeat.o(204977);
      return true;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      return false;
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 855638065);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(204978);
      ((b)g.ab(b.class)).Sa(parambl.field_talker);
      paramView = parambl.field_content;
      if (paramView != null) {}
      for (paramView = k.b.ar(paramView, parambl.field_reserved);; paramView = null)
      {
        if ((paramView != null) && (paramView.type == 60)) {
          try
          {
            if ((((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.r.a.cd(parama.GzJ.getContext())) && (!com.tencent.mm.r.a.ce(parama.GzJ.getContext())) && (!com.tencent.mm.r.a.cc(parama.GzJ.getContext()))))
            {
              Object localObject = (com.tencent.mm.live.b.k)paramView.ao(com.tencent.mm.live.b.k.class);
              long l = Long.parseLong(((com.tencent.mm.live.b.k)localObject).zaR);
              paramView = ((com.tencent.mm.live.b.k)localObject).qud;
              localObject = ((com.tencent.mm.live.b.k)localObject).thumbUrl;
              parambl = b(parama, parambl);
              LiveConfig.a locala = new LiveConfig.a();
              locala.qsO = LiveConfig.qsJ;
              locala.thumbUrl = ((String)localObject);
              locala.qsP = parama.getTalkerUserName();
              locala.DlB = l;
              locala.qud = paramView;
              locala.fromScene = LiveConfig.qsM;
              locala.quk = parambl;
              paramView = locala.cld();
              ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().b(parama.GzJ.getContext(), paramView);
              as.ci(parama.getTalkerUserName(), l);
              f.fPZ();
            }
            AppMethodBeat.o(204978);
            return true;
          }
          catch (Exception paramView)
          {
            ad.w("MicroMsg.ChattingItemAppMsgShareLiveFrom", "jump to live fail: %s", new Object[] { paramView.getMessage() });
          }
        }
        AppMethodBeat.o(204978);
        return false;
      }
    }
    
    public final boolean faE()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a Gob;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(204980);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new af(paramLayoutInflater, 2131496164);
        ((View)localObject).setTag(new br.c((View)localObject, Boolean.TRUE));
      }
      AppMethodBeat.o(204980);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(204981);
      this.Gob = parama1;
      String str;
      if ((parama instanceof br.c))
      {
        str = parambl.field_content;
        if (str == null) {
          break label205;
        }
      }
      for (paramString = k.b.ar(str, parambl.field_reserved);; paramString = null)
      {
        if (paramString != null)
        {
          ((br.c)parama).LCU.setText(com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), paramString.getTitle()));
          final long l = Long.parseLong(((com.tencent.mm.live.b.k)paramString.ao(com.tencent.mm.live.b.k.class)).zaR);
          paramString = parama1.getTalkerUserName();
          ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).refreshLiveStatus(l, paramString, new a.a()
          {
            public final void ak(long paramAnonymousLong, int paramAnonymousInt)
            {
              AppMethodBeat.i(204979);
              if (l == paramAnonymousLong)
              {
                if (paramAnonymousInt == 1)
                {
                  ((br.c)parama1).LCV.setText(this.GIy.GzJ.getContext().getResources().getString(2131766754));
                  AppMethodBeat.o(204979);
                  return;
                }
                ((br.c)parama1).LCV.setText(this.GIy.GzJ.getContext().getResources().getString(2131766755));
              }
              AppMethodBeat.o(204979);
            }
          });
        }
        parambl = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
        parama.naN.setTag(parambl);
        parama.naN.setOnClickListener(d(parama1));
        parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
        parama.naN.setOnLongClickListener(c(parama1));
        ad.i("MicroMsg.ChattingItemAppMsgShareLiveTo", "filling");
        AppMethodBeat.o(204981);
        return;
        label205:
        ad.e("MicroMsg.ChattingItemAppMsgShareLiveTo", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambl.field_msgId), paramString });
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(204982);
      int i = ((bi)paramView.getTag()).position;
      if (((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker)) && (!com.tencent.mm.storage.af.rz(this.Gob.getTalkerUserName()))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
      }
      paramContextMenu.add(i, 136, 0, paramView.getContext().getString(2131757226));
      AppMethodBeat.o(204982);
      return true;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      return false;
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 855638065);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(204983);
      ((b)g.ab(b.class)).Sa(parambl.field_talker);
      paramView = parambl.field_content;
      if (paramView != null) {}
      for (paramView = k.b.ar(paramView, parambl.field_reserved);; paramView = null)
      {
        if ((paramView != null) && (paramView.type == 60)) {
          try
          {
            if ((((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isAnchorLiving()) || (((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) || ((!com.tencent.mm.r.a.cd(parama.GzJ.getContext())) && (!com.tencent.mm.r.a.ce(parama.GzJ.getContext())) && (!com.tencent.mm.r.a.cc(parama.GzJ.getContext()))))
            {
              Object localObject = (com.tencent.mm.live.b.k)paramView.ao(com.tencent.mm.live.b.k.class);
              long l = Long.parseLong(((com.tencent.mm.live.b.k)localObject).zaR);
              paramView = ((com.tencent.mm.live.b.k)localObject).qud;
              localObject = ((com.tencent.mm.live.b.k)localObject).thumbUrl;
              parambl = b(parama, parambl);
              LiveConfig.a locala = new LiveConfig.a();
              locala.qsO = LiveConfig.qsH;
              locala.thumbUrl = ((String)localObject);
              locala.qsP = parama.getTalkerUserName();
              locala.DlB = l;
              locala.qud = paramView;
              locala.quk = parambl;
              paramView = locala.cld();
              ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(parama.GzJ.getContext(), paramView);
            }
            AppMethodBeat.o(204983);
            return true;
          }
          catch (Exception paramView)
          {
            ad.w("MicroMsg.ChattingItemAppMsgShareLiveTo", "jump to live fail: %s", new Object[] { paramView.getMessage() });
            AppMethodBeat.o(204983);
            return true;
          }
        }
        AppMethodBeat.o(204983);
        return false;
      }
    }
    
    public final boolean faE()
    {
      return true;
    }
  }
  
  static final class c
    extends c.a
  {
    boolean GKS;
    MMTextView LCU;
    MMTextView LCV;
    
    public c(View paramView, Boolean paramBoolean)
    {
      AppMethodBeat.i(204984);
      super.fK(paramView);
      this.wet = ((TextView)paramView.findViewById(2131298185));
      this.LCU = ((MMTextView)paramView.findViewById(2131307872));
      this.LCV = ((MMTextView)paramView.findViewById(2131307873));
      this.GKS = paramBoolean.booleanValue();
      AppMethodBeat.o(204984);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.br
 * JD-Core Version:    0.7.0.1
 */