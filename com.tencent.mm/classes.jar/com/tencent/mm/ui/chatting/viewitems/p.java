package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.n;

public final class p
{
  private static String TAG;
  private static com.tencent.mm.loader.c.e zQq;
  
  static
  {
    AppMethodBeat.i(163379);
    TAG = "Finder.ChattingItemAppMsgFinderTopic";
    e.a locala = new e.a();
    locala.heb = true;
    locala.hea = true;
    zQq = locala.arf();
    AppMethodBeat.o(163379);
  }
  
  static final class a
    extends c.a
  {
    public ImageView KbJ;
    public TextView KbN;
    public ImageView KbP;
    public TextView KbT;
    
    public final a E(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(163364);
      super.gn(paramView);
      this.KbT = ((TextView)paramView.findViewById(2131298129));
      this.KbP = ((ImageView)paramView.findViewById(2131298131));
      this.KbN = ((TextView)paramView.findViewById(2131298130));
      this.yEk = ((TextView)paramView.findViewById(2131298185));
      ((t)g.ad(t.class)).showFinderEntry();
      if (paramBoolean)
      {
        this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
        this.KbJ = ((ImageView)paramView.findViewById(2131298176));
      }
      AppMethodBeat.o(163364);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(163365);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ah(paramLayoutInflater, 2131493439);
        ((View)localObject).setTag(new p.a().E((View)localObject, false));
      }
      AppMethodBeat.o(163365);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      AppMethodBeat.i(163366);
      this.JBI = parama1;
      paramString = (p.a)parama;
      parama = parambu.field_content;
      if (parama != null) {}
      for (parama = k.b.aA(parama, parambu.field_reserved);; parama = null)
      {
        ark localark;
        if (parama != null)
        {
          localark = p.n(parama);
          if (localark != null) {
            if (localark.sMj != 1) {
              break label227;
            }
          }
        }
        label227:
        for (parama = aj.getContext().getString(2131759380, new Object[] { localark.dzZ });; parama = localark.dzZ)
        {
          paramString.KbT.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama));
          parama = com.tencent.mm.loader.e.hcm;
          com.tencent.mm.loader.e.aqF().a(localark.iconUrl, paramString.KbP, p.fHp());
          paramString.KbN.setText(localark.desc);
          if (paramString.ofK != null)
          {
            paramString.ofK.setOnClickListener(d(parama1));
            paramString.ofK.setOnLongClickListener(c(parama1));
            paramString.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
            parama = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
            paramString.ofK.setTag(parama);
          }
          AppMethodBeat.o(163366);
          return;
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(163368);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163368);
        return false;
      }
      p.d(parama.JOR.getContext(), parambu);
      AppMethodBeat.o(163368);
      return true;
    }
    
    public final boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194352);
      int j = ((bk)paramView.getTag()).position;
      if (!((t)g.ad(t.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((parambu != null) && (d.aIu("favorite")) && (i == 0)) {
          paraml.a(j, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
        }
        AppMethodBeat.o(194352);
        return true;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(163369);
      String str = parambu.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aA(str, parambu.field_reserved);
      }
      paramView = p.n(paramView);
      if (paramView != null) {
        p.a(parama.JOR.getContext(), parambu, paramView.dzZ, paramView.sMj, paramView.Gpj);
      }
      AppMethodBeat.o(163369);
      return false;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 838860849);
    }
    
    public final boolean fHh()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(163370);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ah(paramLayoutInflater, 2131493483);
        ((View)localObject).setTag(new p.a().E((View)localObject, true));
      }
      AppMethodBeat.o(163370);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(163372);
      if (parambu.cTc())
      {
        m.aG(parambu);
        bj.rJ(parambu.field_msgId);
        parama.xR(true);
      }
      AppMethodBeat.o(163372);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(163371);
      this.JBI = parama1;
      paramString = (p.a)parama;
      Object localObject = parambu.field_content;
      parama = null;
      if (localObject != null) {
        parama = k.b.aA((String)localObject, parambu.field_reserved);
      }
      if (parama != null)
      {
        localObject = p.n(parama);
        if (localObject != null)
        {
          if (((ark)localObject).sMj != 1) {
            break label313;
          }
          parama = aj.getContext().getString(2131759380, new Object[] { ((ark)localObject).dzZ });
          paramString.KbT.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama));
          parama = com.tencent.mm.loader.e.hcm;
          com.tencent.mm.loader.e.aqF().a(((ark)localObject).iconUrl, paramString.KbP, p.fHp());
          paramString.KbN.setText(((ark)localObject).desc);
        }
        if (paramString.ofK != null)
        {
          paramString.ofK.setOnClickListener(d(parama1));
          paramString.ofK.setOnLongClickListener(c(parama1));
          paramString.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
          parama = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
          paramString.ofK.setTag(parama);
        }
      }
      if (fHj())
      {
        b(paramString, false);
        if ((parambu.field_status == 2) && (b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu.field_msgId))) {
          if (paramString.KbJ != null) {
            paramString.KbJ.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        a(paramInt, paramString, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
        AppMethodBeat.o(163371);
        return;
        label313:
        parama = ((ark)localObject).dzZ;
        break;
        if (paramString.KbJ != null)
        {
          paramString.KbJ.setVisibility(8);
          continue;
          if (paramString.KbJ != null) {
            paramString.KbJ.setVisibility(8);
          }
          if (parambu.field_status < 2) {
            bool = true;
          }
          b(paramString, bool);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(163374);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163374);
        return false;
      }
      p.d(parama.JOR.getContext(), parambu);
      AppMethodBeat.o(163374);
      return true;
    }
    
    public final boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194353);
      int j = ((bk)paramView.getTag()).position;
      if (!((t)g.ad(t.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((parambu != null) && (i == 0))
        {
          paraml.a(j, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
          d.aIu("favorite");
          if (((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker)) && (!am.yt(this.JBI.getTalkerUserName()))) {
            paraml.a(j, 123, paramView.getContext().getString(2131757234), 2131690462);
          }
        }
        AppMethodBeat.o(194353);
        return true;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(163375);
      String str = parambu.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aA(str, parambu.field_reserved);
      }
      paramView = p.n(paramView);
      if (paramView != null) {
        p.a(parama.JOR.getContext(), parambu, paramView.dzZ, paramView.sMj, paramView.Gpj);
      }
      AppMethodBeat.o(163375);
      return false;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 838860849);
    }
    
    public final boolean fHh()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p
 * JD-Core Version:    0.7.0.1
 */