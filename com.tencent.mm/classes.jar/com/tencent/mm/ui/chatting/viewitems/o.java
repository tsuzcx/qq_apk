package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.n;

public final class o
{
  static final class a
    extends c.a
  {
    public ImageView Kyb;
    TextView fQm;
    ImageView fTj;
    TextView sPw;
    ImageView soY;
    
    public final a I(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(163352);
      super.gs(paramView);
      this.fTj = ((ImageView)paramView.findViewById(2131299973));
      this.fQm = ((TextView)paramView.findViewById(2131300019));
      this.soY = ((ImageView)paramView.findViewById(2131300003));
      this.sPw = ((TextView)paramView.findViewById(2131300004));
      this.yUp = ((TextView)paramView.findViewById(2131298185));
      if (paramBoolean)
      {
        this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
        this.Kyb = ((ImageView)paramView.findViewById(2131298176));
      }
      AppMethodBeat.o(163352);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(163353);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ah(paramLayoutInflater, 2131493438);
        ((View)localObject).setTag(new o.a().I((View)localObject, false));
      }
      AppMethodBeat.o(163353);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(163354);
      this.JWz = parama1;
      paramString = (o.a)parama;
      Object localObject = parambv.field_content;
      parama = null;
      if (localObject != null) {
        parama = k.b.aB((String)localObject, parambv.field_reserved);
      }
      com.tencent.mm.plugin.finder.loader.l locall;
      ImageView localImageView;
      i locali;
      if (parama != null)
      {
        parama = (com.tencent.mm.plugin.i.a.a)parama.ao(com.tencent.mm.plugin.i.a.a.class);
        if (parama != null)
        {
          localObject = i.srW;
          localObject = i.cEo();
          locall = new com.tencent.mm.plugin.finder.loader.l(parama.ssR, r.sJv);
          localImageView = paramString.fTj;
          locali = i.srW;
          ((d)localObject).a(locall, localImageView, i.a(i.a.ssc));
          paramString.fQm.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.nickname));
          int i = parama.tqD;
          if (i <= 0) {
            break label439;
          }
          paramString.soY.setVisibility(0);
          switch (i)
          {
          default: 
            if ((i == 1) && (!bu.isNullOrNil(parama.tqC)))
            {
              paramString.sPw.setVisibility(0);
              paramString.sPw.setText(parama.tqC);
            }
            break;
          }
        }
      }
      for (;;)
      {
        paramString.olI.setOnClickListener(d(parama1));
        paramString.olI.setOnLongClickListener(c(parama1));
        paramString.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
        parama = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
        paramString.olI.setTag(parama);
        AppMethodBeat.o(163354);
        return;
        if (!parama.authIconUrl.isEmpty())
        {
          localObject = i.srW;
          localObject = i.cEn();
          locall = new com.tencent.mm.plugin.finder.loader.l(parama.authIconUrl, r.sJu);
          localImageView = paramString.soY;
          locali = i.srW;
          ((d)localObject).a(locall, localImageView, i.a(i.a.srX));
          break;
        }
        paramString.soY.setImageDrawable(ao.k(parama1.Kkd.getContext(), 2131690481, parama1.Kkd.getMMResources().getColor(2131099777)));
        break;
        paramString.soY.setImageResource(2131691604);
        break;
        paramString.soY.setVisibility(8);
        break;
        label439:
        paramString.soY.setVisibility(8);
        break;
        paramString.sPw.setVisibility(8);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163355);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163355);
        return false;
      }
      o.c(parama.Kkd.getContext(), parambv);
      AppMethodBeat.o(163355);
      return true;
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187745);
      paraml.a(0, 111, paramView.getContext().getString(2131762559), 2131690478);
      AppMethodBeat.o(187745);
      return true;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      int i = 2;
      AppMethodBeat.i(163356);
      Object localObject = parambv.field_content;
      paramView = null;
      if (localObject != null) {
        paramView = k.b.aB((String)localObject, parambv.field_reserved);
      }
      if (paramView != null)
      {
        paramView = (com.tencent.mm.plugin.i.a.a)paramView.ao(com.tencent.mm.plugin.i.a.a.class);
        if ((paramView != null) && (!bu.isNullOrNil(paramView.username)))
        {
          localObject = new Intent();
          if (!x.wb(parambv.field_talker)) {
            break label206;
          }
          ((Intent)localObject).putExtra("key_from_profile_share_scene", 2);
        }
      }
      for (;;)
      {
        t localt = (t)g.ad(t.class);
        if (x.wb(parambv.field_talker)) {
          i = 3;
        }
        localt.fillContextIdToIntent(i, 3, 32, (Intent)localObject);
        ((Intent)localObject).putExtra("key_enter_profile_type", 4);
        ((Intent)localObject).putExtra("key_comment_scene", 11);
        ((Intent)localObject).putExtra("from_user", parambv.field_talker);
        ((Intent)localObject).putExtra("finder_username", paramView.username);
        ((t)g.ad(t.class)).enterFinderProfileUI(parama.Kkd.getContext(), (Intent)localObject);
        AppMethodBeat.o(163356);
        return false;
        label206:
        ((Intent)localObject).putExtra("key_from_profile_share_scene", 1);
      }
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 771751985);
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
      AppMethodBeat.i(163357);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ah(paramLayoutInflater, 2131493482);
        ((View)localObject).setTag(new o.a().I((View)localObject, true));
      }
      AppMethodBeat.o(163357);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163359);
      if (parambv.cVH())
      {
        m.aF(parambv);
        bl.rW(parambv.field_msgId);
        parama.xY(true);
      }
      AppMethodBeat.o(163359);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(163358);
      this.JWz = parama1;
      paramString = (o.a)parama;
      Object localObject = parambv.field_content;
      parama = null;
      if (localObject != null) {
        parama = k.b.aB((String)localObject, parambv.field_reserved);
      }
      com.tencent.mm.plugin.finder.loader.l locall;
      ImageView localImageView;
      i locali;
      int i;
      if (parama != null)
      {
        parama = (com.tencent.mm.plugin.i.a.a)parama.ao(com.tencent.mm.plugin.i.a.a.class);
        if (parama != null)
        {
          localObject = i.srW;
          localObject = i.cEo();
          locall = new com.tencent.mm.plugin.finder.loader.l(parama.ssR, r.sJv);
          localImageView = paramString.fTj;
          locali = i.srW;
          ((d)localObject).a(locall, localImageView, i.a(i.a.ssc));
          paramString.fQm.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.nickname));
          i = parama.tqD;
          if (i <= 0) {
            break label520;
          }
          paramString.soY.setVisibility(0);
        }
      }
      switch (i)
      {
      default: 
        if ((i == 1) && (!bu.isNullOrNil(parama.tqC)))
        {
          paramString.sPw.setVisibility(0);
          paramString.sPw.setText(parama.tqC);
          label229:
          paramString.olI.setOnClickListener(d(parama1));
          paramString.olI.setOnLongClickListener(c(parama1));
          paramString.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          parama = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
          paramString.olI.setTag(parama);
          if (!fLB()) {
            break label567;
          }
          b(paramString, false);
          if ((parambv.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv.field_msgId))) {
            break label546;
          }
          if (paramString.Kyb != null) {
            paramString.Kyb.setVisibility(0);
          }
        }
        break;
      }
      for (;;)
      {
        a(paramInt, paramString, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
        AppMethodBeat.o(163358);
        return;
        if (!parama.authIconUrl.isEmpty())
        {
          localObject = i.srW;
          localObject = i.cEn();
          locall = new com.tencent.mm.plugin.finder.loader.l(parama.authIconUrl, r.sJu);
          localImageView = paramString.soY;
          locali = i.srW;
          ((d)localObject).a(locall, localImageView, i.a(i.a.srX));
          break;
        }
        paramString.soY.setImageDrawable(ao.k(parama1.Kkd.getContext(), 2131690481, parama1.Kkd.getMMResources().getColor(2131099777)));
        break;
        paramString.soY.setImageResource(2131691604);
        break;
        paramString.soY.setVisibility(8);
        break;
        label520:
        paramString.soY.setVisibility(8);
        break;
        paramString.sPw.setVisibility(8);
        break label229;
        label546:
        if (paramString.Kyb != null) {
          paramString.Kyb.setVisibility(8);
        }
      }
      label567:
      if (paramString.Kyb != null) {
        paramString.Kyb.setVisibility(8);
      }
      if (parambv.field_status < 2) {}
      for (boolean bool = true;; bool = false)
      {
        b(paramString, bool);
        break;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(163361);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163361);
        return false;
      }
      o.c(parama.Kkd.getContext(), parambv);
      AppMethodBeat.o(163361);
      return true;
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187746);
      int i = ((bk)paramView.getTag()).position;
      if (parambv != null)
      {
        if (((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker)) && (!an.zd(this.JWz.getTalkerUserName()))) {
          paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
        }
        paraml.a(i, 111, paramView.getContext().getString(2131762559), 2131690478);
      }
      AppMethodBeat.o(187746);
      return true;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      int i = 2;
      AppMethodBeat.i(163362);
      Object localObject = parambv.field_content;
      paramView = null;
      if (localObject != null) {
        paramView = k.b.aB((String)localObject, parambv.field_reserved);
      }
      if (paramView != null)
      {
        paramView = (com.tencent.mm.plugin.i.a.a)paramView.ao(com.tencent.mm.plugin.i.a.a.class);
        if ((paramView != null) && (!bu.isNullOrNil(paramView.username)))
        {
          localObject = new Intent();
          if (!x.wb(parambv.field_talker)) {
            break label206;
          }
          ((Intent)localObject).putExtra("key_from_profile_share_scene", 2);
        }
      }
      for (;;)
      {
        t localt = (t)g.ad(t.class);
        if (x.wb(parambv.field_talker)) {
          i = 3;
        }
        localt.fillContextIdToIntent(i, 3, 32, (Intent)localObject);
        ((Intent)localObject).putExtra("key_enter_profile_type", 4);
        ((Intent)localObject).putExtra("key_comment_scene", 11);
        ((Intent)localObject).putExtra("from_user", parambv.field_talker);
        ((Intent)localObject).putExtra("finder_username", paramView.username);
        ((t)g.ad(t.class)).enterFinderProfileUI(parama.Kkd.getContext(), (Intent)localObject);
        AppMethodBeat.o(163362);
        return false;
        label206:
        ((Intent)localObject).putExtra("key_from_profile_share_scene", 1);
      }
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 771751985);
    }
    
    public final boolean fLz()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o
 * JD-Core Version:    0.7.0.1
 */