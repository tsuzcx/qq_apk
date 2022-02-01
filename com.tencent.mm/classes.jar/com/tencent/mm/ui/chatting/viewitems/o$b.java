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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

public final class o$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493438);
      ((View)localObject).setTag(new o.a().D((View)localObject, false));
    }
    AppMethodBeat.o(163353);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(163354);
    this.Gob = parama1;
    paramString = (o.a)parama;
    Object localObject = parambl.field_content;
    parama = null;
    if (localObject != null) {
      parama = k.b.ar((String)localObject, parambl.field_reserved);
    }
    if (parama != null)
    {
      parama = (com.tencent.mm.plugin.i.a.a)parama.ao(com.tencent.mm.plugin.i.a.a.class);
      if (parama != null)
      {
        localObject = com.tencent.mm.plugin.finder.loader.h.qCF;
        localObject = com.tencent.mm.plugin.finder.loader.h.cmV();
        com.tencent.mm.plugin.finder.loader.k localk = new com.tencent.mm.plugin.finder.loader.k(parama.qDs, com.tencent.mm.plugin.finder.storage.h.qJZ);
        ImageView localImageView = paramString.fuj;
        com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
        ((com.tencent.mm.loader.d)localObject).a(localk, localImageView, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCK));
        paramString.frs.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.GzJ.getContext(), parama.nickname));
        int i = parama.raQ;
        if (i <= 0) {
          break label395;
        }
        paramString.qAi.setVisibility(0);
        switch (i)
        {
        default: 
          if ((i == 1) && (!bt.isNullOrNil(parama.raP)))
          {
            paramString.qKL.setVisibility(0);
            paramString.qKL.setText(parama.raP);
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramString.naN.setOnClickListener(d(parama1));
      paramString.naN.setOnLongClickListener(c(parama1));
      paramString.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
      parama = new bi(parambl, this.Gob.eZb(), paramInt, null, '\000');
      paramString.naN.setTag(parama);
      AppMethodBeat.o(163354);
      return;
      paramString.qAi.setImageDrawable(am.i(parama1.GzJ.getContext(), 2131690481, parama1.GzJ.getMMResources().getColor(2131099777)));
      break;
      paramString.qAi.setImageDrawable(am.i(parama1.GzJ.getContext(), 2131690481, parama1.GzJ.getMMResources().getColor(2131099689)));
      break;
      paramString.qAi.setVisibility(8);
      break;
      label395:
      paramString.qAi.setVisibility(8);
      break;
      paramString.qKL.setVisibility(8);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(179994);
    paramContextMenu.add(0, 111, 0, paramView.getContext().getString(2131762559));
    AppMethodBeat.o(179994);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(163355);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163355);
      return false;
    }
    o.b(parama.GzJ.getContext(), parambl);
    AppMethodBeat.o(163355);
    return true;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 771751985);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(163356);
    if (!((j)g.ad(j.class)).showFinderEntry())
    {
      com.tencent.mm.bs.d.O(parama.GzJ.getContext(), "finder", ".ui.FinderUnOpenUI");
      AppMethodBeat.o(163356);
      return false;
    }
    Object localObject = parambl.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.ar((String)localObject, parambl.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (com.tencent.mm.plugin.i.a.a)paramView.ao(com.tencent.mm.plugin.i.a.a.class);
      if ((paramView != null) && (!bt.isNullOrNil(paramView.username)))
      {
        localObject = new Intent();
        if (!w.pF(parambl.field_talker)) {
          break label205;
        }
        ((Intent)localObject).putExtra("key_from_profile_share_scene", 2);
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_enter_profile_type", 4);
      ((Intent)localObject).putExtra("key_comment_scene", 11);
      ((Intent)localObject).putExtra("from_user", parambl.field_talker);
      ((Intent)localObject).putExtra("finder_username", paramView.username);
      ((j)g.ad(j.class)).enterFinderProfileUI(parama.GzJ.getContext(), (Intent)localObject);
      AppMethodBeat.o(163356);
      return false;
      label205:
      ((Intent)localObject).putExtra("key_from_profile_share_scene", 1);
    }
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.b
 * JD-Core Version:    0.7.0.1
 */