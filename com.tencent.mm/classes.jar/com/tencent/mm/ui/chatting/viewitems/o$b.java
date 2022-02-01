package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

public final class o$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
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
      localObject = new ag(paramLayoutInflater, 2131493438);
      ((View)localObject).setTag(new o.a().D((View)localObject, false));
    }
    AppMethodBeat.o(163353);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(163354);
    this.HNS = parama1;
    paramString = (o.a)parama;
    Object localObject = parambo.field_content;
    parama = null;
    if (localObject != null) {
      parama = k.b.az((String)localObject, parambo.field_reserved);
    }
    if (parama != null)
    {
      parama = (com.tencent.mm.plugin.i.a.a)parama.ao(com.tencent.mm.plugin.i.a.a.class);
      if (parama != null)
      {
        localObject = h.rtK;
        localObject = h.cwo();
        com.tencent.mm.plugin.finder.loader.k localk = new com.tencent.mm.plugin.finder.loader.k(parama.ruB, m.rDR);
        ImageView localImageView = paramString.fxQ;
        h localh = h.rtK;
        ((d)localObject).a(localk, localImageView, h.a(h.a.rtP));
        paramString.fuZ.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.HZF.getContext(), parama.nickname));
        int i = parama.sji;
        if (i <= 0) {
          break label395;
        }
        paramString.rqZ.setVisibility(0);
        switch (i)
        {
        default: 
          if ((i == 1) && (!bs.isNullOrNil(parama.sjh)))
          {
            paramString.rFt.setVisibility(0);
            paramString.rFt.setText(parama.sjh);
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramString.nDl.setOnClickListener(d(parama1));
      paramString.nDl.setOnLongClickListener(c(parama1));
      paramString.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
      parama = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
      paramString.nDl.setTag(parama);
      AppMethodBeat.o(163354);
      return;
      paramString.rqZ.setImageDrawable(am.k(parama1.HZF.getContext(), 2131690481, parama1.HZF.getMMResources().getColor(2131099777)));
      break;
      paramString.rqZ.setImageDrawable(am.k(parama1.HZF.getContext(), 2131690481, parama1.HZF.getMMResources().getColor(2131099689)));
      break;
      paramString.rqZ.setVisibility(8);
      break;
      label395:
      paramString.rqZ.setVisibility(8);
      break;
      paramString.rFt.setVisibility(8);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(179994);
    paramContextMenu.add(0, 111, 0, paramView.getContext().getString(2131762559));
    AppMethodBeat.o(179994);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163355);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163355);
      return false;
    }
    o.b(parama.HZF.getContext(), parambo);
    AppMethodBeat.o(163355);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163356);
    Object localObject = parambo.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.az((String)localObject, parambo.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (com.tencent.mm.plugin.i.a.a)paramView.ao(com.tencent.mm.plugin.i.a.a.class);
      if ((paramView != null) && (!bs.isNullOrNil(paramView.username)))
      {
        localObject = new Intent();
        if (!w.sQ(parambo.field_talker)) {
          break label164;
        }
        ((Intent)localObject).putExtra("key_from_profile_share_scene", 2);
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_enter_profile_type", 4);
      ((Intent)localObject).putExtra("key_comment_scene", 11);
      ((Intent)localObject).putExtra("from_user", parambo.field_talker);
      ((Intent)localObject).putExtra("finder_username", paramView.username);
      ((l)g.ad(l.class)).enterFinderProfileUI(parama.HZF.getContext(), (Intent)localObject);
      AppMethodBeat.o(163356);
      return false;
      label164:
      ((Intent)localObject).putExtra("key_from_profile_share_scene", 1);
    }
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 771751985);
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.b
 * JD-Core Version:    0.7.0.1
 */