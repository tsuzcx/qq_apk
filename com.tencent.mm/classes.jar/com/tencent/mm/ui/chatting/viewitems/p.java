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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.n;

public final class p
{
  private static com.tencent.mm.loader.c.e Ahx;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(163379);
    TAG = "Finder.ChattingItemAppMsgFinderTopic";
    e.a locala = new e.a();
    locala.hgP = true;
    locala.hgO = true;
    Ahx = locala.aru();
    AppMethodBeat.o(163379);
  }
  
  static final class a
    extends c.a
  {
    public ImageView Kyb;
    public TextView Kyf;
    public ImageView Kyh;
    public TextView Kyl;
    
    public final a J(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(163364);
      super.gs(paramView);
      this.Kyl = ((TextView)paramView.findViewById(2131298129));
      this.Kyh = ((ImageView)paramView.findViewById(2131298131));
      this.Kyf = ((TextView)paramView.findViewById(2131298130));
      this.yUp = ((TextView)paramView.findViewById(2131298185));
      ((t)g.ad(t.class)).showFinderEntry();
      if (paramBoolean)
      {
        this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
        this.Kyb = ((ImageView)paramView.findViewById(2131298176));
      }
      AppMethodBeat.o(163364);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    
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
        ((View)localObject).setTag(new p.a().J((View)localObject, false));
      }
      AppMethodBeat.o(163365);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(163366);
      this.JWz = parama1;
      paramString = (p.a)parama;
      parama = parambv.field_content;
      if (parama != null) {}
      for (parama = k.b.aB(parama, parambv.field_reserved);; parama = null)
      {
        arz localarz;
        if (parama != null)
        {
          localarz = p.n(parama);
          if (localarz != null) {
            if (localarz.sXu != 1) {
              break label227;
            }
          }
        }
        label227:
        for (parama = ak.getContext().getString(2131759380, new Object[] { localarz.dBe });; parama = localarz.dBe)
        {
          paramString.Kyl.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama));
          parama = com.tencent.mm.loader.e.hfa;
          com.tencent.mm.loader.e.aqU().a(localarz.iconUrl, paramString.Kyh, p.fLH());
          paramString.Kyf.setText(localarz.desc);
          if (paramString.olI != null)
          {
            paramString.olI.setOnClickListener(d(parama1));
            paramString.olI.setOnLongClickListener(c(parama1));
            paramString.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
            parama = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
            paramString.olI.setTag(parama);
          }
          AppMethodBeat.o(163366);
          return;
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163368);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163368);
        return false;
      }
      p.d(parama.Kkd.getContext(), parambv);
      AppMethodBeat.o(163368);
      return true;
    }
    
    public final boolean a(l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187747);
      int j = ((bk)paramView.getTag()).position;
      if (!((t)g.ad(t.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((parambv != null) && (d.aJN("favorite")) && (i == 0)) {
          paraml.a(j, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
        }
        AppMethodBeat.o(187747);
        return true;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163369);
      String str = parambv.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aB(str, parambv.field_reserved);
      }
      paramView = p.n(paramView);
      if (paramView != null) {
        p.a(parama.Kkd.getContext(), parambv, paramView.dBe, paramView.sXu, paramView.GIz);
      }
      AppMethodBeat.o(163369);
      return false;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 838860849);
    }
    
    public final boolean fLz()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    
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
        ((View)localObject).setTag(new p.a().J((View)localObject, true));
      }
      AppMethodBeat.o(163370);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163372);
      if (parambv.cVH())
      {
        m.aF(parambv);
        bl.rW(parambv.field_msgId);
        parama.xY(true);
      }
      AppMethodBeat.o(163372);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(163371);
      this.JWz = parama1;
      paramString = (p.a)parama;
      Object localObject = parambv.field_content;
      parama = null;
      if (localObject != null) {
        parama = k.b.aB((String)localObject, parambv.field_reserved);
      }
      if (parama != null)
      {
        localObject = p.n(parama);
        if (localObject != null)
        {
          if (((arz)localObject).sXu != 1) {
            break label313;
          }
          parama = ak.getContext().getString(2131759380, new Object[] { ((arz)localObject).dBe });
          paramString.Kyl.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama));
          parama = com.tencent.mm.loader.e.hfa;
          com.tencent.mm.loader.e.aqU().a(((arz)localObject).iconUrl, paramString.Kyh, p.fLH());
          paramString.Kyf.setText(((arz)localObject).desc);
        }
        if (paramString.olI != null)
        {
          paramString.olI.setOnClickListener(d(parama1));
          paramString.olI.setOnLongClickListener(c(parama1));
          paramString.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          parama = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
          paramString.olI.setTag(parama);
        }
      }
      if (fLB())
      {
        b(paramString, false);
        if ((parambv.field_status == 2) && (b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv.field_msgId))) {
          if (paramString.Kyb != null) {
            paramString.Kyb.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        a(paramInt, paramString, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
        AppMethodBeat.o(163371);
        return;
        label313:
        parama = ((arz)localObject).dBe;
        break;
        if (paramString.Kyb != null)
        {
          paramString.Kyb.setVisibility(8);
          continue;
          if (paramString.Kyb != null) {
            paramString.Kyb.setVisibility(8);
          }
          if (parambv.field_status < 2) {
            bool = true;
          }
          b(paramString, bool);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163374);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163374);
        return false;
      }
      p.d(parama.Kkd.getContext(), parambv);
      AppMethodBeat.o(163374);
      return true;
    }
    
    public final boolean a(l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187748);
      int j = ((bk)paramView.getTag()).position;
      if (!((t)g.ad(t.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((parambv != null) && (i == 0))
        {
          paraml.a(j, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
          d.aJN("favorite");
          if (((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker)) && (!an.zd(this.JWz.getTalkerUserName()))) {
            paraml.a(j, 123, paramView.getContext().getString(2131757234), 2131690462);
          }
        }
        AppMethodBeat.o(187748);
        return true;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163375);
      String str = parambv.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aB(str, parambv.field_reserved);
      }
      paramView = p.n(paramView);
      if (paramView != null) {
        p.a(parama.Kkd.getContext(), parambv, paramView.dBe, paramView.sXu, paramView.GIz);
      }
      AppMethodBeat.o(163375);
      return false;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 838860849);
    }
    
    public final boolean fLz()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p
 * JD-Core Version:    0.7.0.1
 */