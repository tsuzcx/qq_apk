package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.e;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.v.n;

public final class t
{
  public static void h(a parama, cc paramcc)
  {
    int i = 2;
    AppMethodBeat.i(255000);
    Object localObject2 = paramcc.field_content;
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = k.b.aP((String)localObject2, paramcc.field_reserved);
    }
    if (localObject1 != null)
    {
      localObject1 = (e)((k.b)localObject1).aK(e.class);
      if ((localObject1 != null) && (!Util.isNullOrNil(((e)localObject1).username)))
      {
        localObject2 = new Intent();
        if (!au.bwE(paramcc.field_talker)) {
          break label253;
        }
        ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 2);
        ((Intent)localObject2).putExtra("key_from_profile_share_scene", 2);
      }
    }
    for (;;)
    {
      cn localcn = (cn)h.az(cn.class);
      if (au.bwE(paramcc.field_talker)) {
        i = 3;
      }
      localcn.fillContextIdToIntent(i, 3, 32, (Intent)localObject2);
      ((Intent)localObject2).putExtra("key_enter_profile_type", 4);
      ((Intent)localObject2).putExtra("key_entrance_type", 0);
      ((Intent)localObject2).putExtra("key_from_comment_scene", 11);
      ((Intent)localObject2).putExtra("from_user", paramcc.field_talker);
      ((Intent)localObject2).putExtra("finder_username", ((e)localObject1).username);
      ((Intent)localObject2).putExtra("KEY_DO_NOT_CHECK_ENTER_BIZ_PROFILE", true);
      ((Intent)localObject2).putExtra("key_finder_teen_mode_check", true);
      ((Intent)localObject2).putExtra("key_finder_teen_mode_user_name", ((e)localObject1).nickname);
      ((Intent)localObject2).putExtra("key_finder_teen_mode_user_id", ((e)localObject1).username);
      ((cn)h.az(cn.class)).enterFinderProfileUI(parama.aezO.getContext(), (Intent)localObject2);
      AppMethodBeat.o(255000);
      return;
      label253:
      ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 1);
      ((Intent)localObject2).putExtra("key_from_profile_share_scene", 1);
    }
  }
  
  static final class a
    extends c.a
  {
    ImageView FSM;
    TextView FSN;
    TextView lBD;
    ImageView lKK;
    public ImageView tickIV;
    
    public final a W(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(163352);
      super.create(paramView);
      this.lKK = ((ImageView)paramView.findViewById(R.h.finder_avatar_iv));
      this.lBD = ((TextView)paramView.findViewById(R.h.fIh));
      this.FSM = ((ImageView)paramView.findViewById(R.h.fIa));
      this.FSN = ((TextView)paramView.findViewById(R.h.fIb));
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
      if (!((cn)h.az(cn.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
          this.maskView = paramView.findViewById(R.h.fzn);
        }
        if (paramBoolean)
        {
          this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
          this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
        }
        AppMethodBeat.o(163352);
        return this;
      }
    }
  }
  
  public static final class b
    extends c
  {
    private a aeiK;
    
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
        localObject = new ap(paramLayoutInflater, R.i.gfI);
        ((View)localObject).setTag(new t.a().W((View)localObject, false));
      }
      AppMethodBeat.o(163353);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(163354);
      this.aeiK = parama1;
      paramString = (t.a)parama;
      Object localObject = paramcc.field_content;
      parama = null;
      if (localObject != null) {
        parama = k.b.aP((String)localObject, paramcc.field_reserved);
      }
      com.tencent.mm.plugin.finder.loader.s locals;
      ImageView localImageView;
      com.tencent.mm.plugin.finder.loader.p localp;
      if (parama != null)
      {
        parama = (e)parama.aK(e.class);
        if (parama != null)
        {
          localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
          locals = new com.tencent.mm.plugin.finder.loader.s(parama.avatar, v.FKZ);
          localImageView = paramString.lKK;
          localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((d)localObject).a(locals, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExP));
          paramString.lBD.setText(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), parama.nickname));
          int i = parama.HbY;
          if (i <= 0) {
            break label442;
          }
          paramString.FSM.setVisibility(0);
          switch (i)
          {
          default: 
            if ((i == 1) && (!Util.isNullOrNil(parama.HbX)))
            {
              paramString.FSN.setVisibility(0);
              paramString.FSN.setText(parama.HbX);
            }
            break;
          }
        }
      }
      for (;;)
      {
        paramString.clickArea.setOnClickListener(d(parama1));
        paramString.clickArea.setOnLongClickListener(c(parama1));
        paramString.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
        parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
        paramString.clickArea.setTag(parama);
        AppMethodBeat.o(163354);
        return;
        if (!parama.authIconUrl.isEmpty())
        {
          localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject = com.tencent.mm.plugin.finder.loader.p.eCl();
          locals = new com.tencent.mm.plugin.finder.loader.s(parama.authIconUrl, v.FKY);
          localImageView = paramString.FSM;
          localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((d)localObject).a(locals, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
          break;
        }
        paramString.FSM.setImageDrawable(bb.m(parama1.aezO.getContext(), R.k.icons_filled_star_identify, parama1.aezO.getMMResources().getColor(R.e.Orange)));
        break;
        paramString.FSM.setImageResource(R.k.icons_filled_star_identify_enterprise);
        break;
        paramString.FSM.setVisibility(8);
        break;
        label442:
        paramString.FSM.setVisibility(8);
        break;
        paramString.FSN.setVisibility(8);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
    {
      AppMethodBeat.i(163355);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163355);
        return false;
      }
      t.d(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(163355);
      return true;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255203);
      params.a(0, 111, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      AppMethodBeat.o(255203);
      return true;
    }
    
    public final boolean c(View paramView, a parama, cc paramcc)
    {
      AppMethodBeat.i(163356);
      t.h(parama, paramcc);
      AppMethodBeat.o(163356);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 771751985);
    }
    
    public final boolean fXn()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements v.n
  {
    private a aeiK;
    
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
        localObject = new ap(paramLayoutInflater, R.i.ggI);
        ((View)localObject).setTag(new t.a().W((View)localObject, true));
      }
      AppMethodBeat.o(163357);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(163358);
      this.aeiK = parama1;
      paramString = (t.a)parama;
      Object localObject = paramcc.field_content;
      parama = null;
      if (localObject != null) {
        parama = k.b.aP((String)localObject, paramcc.field_reserved);
      }
      com.tencent.mm.plugin.finder.loader.s locals;
      ImageView localImageView;
      com.tencent.mm.plugin.finder.loader.p localp;
      int i;
      if (parama != null)
      {
        parama = (e)parama.aK(e.class);
        if (parama != null)
        {
          localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
          locals = new com.tencent.mm.plugin.finder.loader.s(parama.avatar, v.FKZ);
          localImageView = paramString.lKK;
          localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((d)localObject).a(locals, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExP));
          paramString.lBD.setText(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), parama.nickname));
          i = parama.HbY;
          if (i <= 0) {
            break label520;
          }
          paramString.FSM.setVisibility(0);
        }
      }
      switch (i)
      {
      default: 
        if ((i == 1) && (!Util.isNullOrNil(parama.HbX)))
        {
          paramString.FSN.setVisibility(0);
          paramString.FSN.setText(parama.HbX);
          label229:
          paramString.clickArea.setOnClickListener(d(parama1));
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
          paramString.clickArea.setTag(parama);
          if (!jxj()) {
            break label567;
          }
          b(paramString, false);
          if ((paramcc.field_status != 2) || (!b((m)parama1.cm(m.class), paramcc.field_msgId))) {
            break label546;
          }
          if (paramString.tickIV != null) {
            paramString.tickIV.setVisibility(0);
          }
        }
        break;
      }
      for (;;)
      {
        a(paramInt, paramString, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
        AppMethodBeat.o(163358);
        return;
        if (!parama.authIconUrl.isEmpty())
        {
          localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject = com.tencent.mm.plugin.finder.loader.p.eCl();
          locals = new com.tencent.mm.plugin.finder.loader.s(parama.authIconUrl, v.FKY);
          localImageView = paramString.FSM;
          localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((d)localObject).a(locals, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
          break;
        }
        paramString.FSM.setImageDrawable(bb.m(parama1.aezO.getContext(), R.k.icons_filled_star_identify, parama1.aezO.getMMResources().getColor(R.e.Orange)));
        break;
        paramString.FSM.setImageResource(R.k.icons_filled_star_identify_enterprise);
        break;
        paramString.FSM.setVisibility(8);
        break;
        label520:
        paramString.FSM.setVisibility(8);
        break;
        paramString.FSN.setVisibility(8);
        break label229;
        label546:
        if (paramString.tickIV != null) {
          paramString.tickIV.setVisibility(8);
        }
      }
      label567:
      if (paramString.tickIV != null) {
        paramString.tickIV.setVisibility(8);
      }
      if (paramcc.field_status < 2) {}
      for (boolean bool = true;; bool = false)
      {
        b(paramString, bool);
        break;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
    {
      AppMethodBeat.i(163361);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163361);
        return false;
      }
      t.d(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(163361);
      return true;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255214);
      int i = ((bz)paramView.getTag()).position;
      if (paramcc != null)
      {
        if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!au.Hh(this.aeiK.getTalkerUserName()))) {
          params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
        }
        params.a(i, 111, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      AppMethodBeat.o(255214);
      return true;
    }
    
    public final void b(View paramView, a parama, cc paramcc)
    {
      AppMethodBeat.i(255210);
      if (paramcc.fxR())
      {
        n.bx(paramcc);
        br.iu(paramcc.field_msgId);
        parama.jpK();
      }
      AppMethodBeat.o(255210);
    }
    
    public final boolean c(View paramView, a parama, cc paramcc)
    {
      AppMethodBeat.i(163362);
      t.h(parama, paramcc);
      AppMethodBeat.o(163362);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 771751985);
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t
 * JD-Core Version:    0.7.0.1
 */