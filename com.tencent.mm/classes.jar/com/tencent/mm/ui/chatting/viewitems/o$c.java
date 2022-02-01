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
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.s.n;

public final class o$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
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
      localObject = new ag(paramLayoutInflater, 2131493482);
      ((View)localObject).setTag(new o.a().D((View)localObject, true));
    }
    AppMethodBeat.o(163357);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163359);
    if (parambo.cKN())
    {
      com.tencent.mm.pluginsdk.model.app.m.aD(parambo);
      bi.pK(parambo.field_msgId);
      parama.xg(true);
    }
    AppMethodBeat.o(163359);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(163358);
    this.HNS = parama1;
    paramString = (o.a)parama;
    Object localObject = parambo.field_content;
    parama = null;
    if (localObject != null) {
      parama = k.b.az((String)localObject, parambo.field_reserved);
    }
    int i;
    if (parama != null)
    {
      parama = (com.tencent.mm.plugin.i.a.a)parama.ao(com.tencent.mm.plugin.i.a.a.class);
      if (parama != null)
      {
        localObject = h.rtK;
        localObject = h.cwo();
        com.tencent.mm.plugin.finder.loader.k localk = new com.tencent.mm.plugin.finder.loader.k(parama.ruB, com.tencent.mm.plugin.finder.storage.m.rDR);
        ImageView localImageView = paramString.fxQ;
        h localh = h.rtK;
        ((d)localObject).a(localk, localImageView, h.a(h.a.rtP));
        paramString.fuZ.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.HZF.getContext(), parama.nickname));
        i = parama.sji;
        if (i <= 0) {
          break label477;
        }
        paramString.rqZ.setVisibility(0);
      }
    }
    switch (i)
    {
    default: 
      if ((i == 1) && (!bs.isNullOrNil(parama.sjh)))
      {
        paramString.rFt.setVisibility(0);
        paramString.rFt.setText(parama.sjh);
        label229:
        paramString.nDl.setOnClickListener(d(parama1));
        paramString.nDl.setOnLongClickListener(c(parama1));
        paramString.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
        parama = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
        paramString.nDl.setTag(parama);
        if (!fqw()) {
          break label524;
        }
        b(paramString, false);
        if ((parambo.field_status != 2) || (!a((i)parama1.bf(i.class), parambo.field_msgId))) {
          break label503;
        }
        if (paramString.Ill != null) {
          paramString.Ill.setVisibility(0);
        }
      }
      break;
    }
    for (;;)
    {
      a(paramInt, paramString, parambo, parama1.foM(), parama1.foQ(), parama1, this);
      AppMethodBeat.o(163358);
      return;
      paramString.rqZ.setImageDrawable(am.k(parama1.HZF.getContext(), 2131690481, parama1.HZF.getMMResources().getColor(2131099777)));
      break;
      paramString.rqZ.setImageDrawable(am.k(parama1.HZF.getContext(), 2131690481, parama1.HZF.getMMResources().getColor(2131099689)));
      break;
      paramString.rqZ.setVisibility(8);
      break;
      label477:
      paramString.rqZ.setVisibility(8);
      break;
      paramString.rFt.setVisibility(8);
      break label229;
      label503:
      if (paramString.Ill != null) {
        paramString.Ill.setVisibility(8);
      }
    }
    label524:
    if (paramString.Ill != null) {
      paramString.Ill.setVisibility(8);
    }
    if (parambo.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(paramString, bool);
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(163360);
    int i = ((bj)paramView.getTag()).position;
    if (parambo != null)
    {
      if (((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker)) && (!ai.vC(this.HNS.getTalkerUserName()))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
      }
      paramContextMenu.add(i, 111, 0, paramView.getContext().getString(2131762559));
    }
    AppMethodBeat.o(163360);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163361);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163361);
      return false;
    }
    o.b(parama.HZF.getContext(), parambo);
    AppMethodBeat.o(163361);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163362);
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
      AppMethodBeat.o(163362);
      return false;
      label164:
      ((Intent)localObject).putExtra("key_from_profile_share_scene", 1);
    }
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 771751985);
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.c
 * JD-Core Version:    0.7.0.1
 */