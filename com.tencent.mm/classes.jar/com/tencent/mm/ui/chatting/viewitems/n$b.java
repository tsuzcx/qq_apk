package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.i.a.b;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import java.util.List;

public final class n$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(163339);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493437);
      ((View)localObject).setTag(new n.a().C((View)localObject, false));
    }
    AppMethodBeat.o(163339);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(163340);
    this.HNS = parama1;
    paramString = (n.a)parama;
    parama = parambo.field_content;
    if (parama != null) {}
    for (parama = k.b.az(parama, parambo.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (b)parama.ao(b.class);
        if (parama != null)
        {
          Object localObject = h.rtK;
          localObject = h.cwo();
          com.tencent.mm.plugin.finder.loader.k localk = new com.tencent.mm.plugin.finder.loader.k(parama.hTI.ruB, m.rDR);
          ImageView localImageView = paramString.Ilm;
          h localh = h.rtK;
          ((com.tencent.mm.loader.d)localObject).a(localk, localImageView, h.a(h.a.rtP));
          paramString.Iln.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.HZF.getContext(), parama.hTI.nickname));
          localObject = parama.hTI.mediaList;
          if (!((List)localObject).isEmpty()) {
            ((l)g.ad(l.class)).loadImage(((anw)((List)localObject).get(0)).thumbUrl, paramString.Ilo);
          }
          if (parama.hTI.EGJ != 1) {
            break label334;
          }
          paramString.Ilp.setVisibility(8);
          paramString.Ilo.setVisibility(8);
          paramString.Ilq.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.HZF.getContext(), parama.hTI.desc));
          paramString.Ilq.setVisibility(0);
        }
      }
      for (;;)
      {
        paramString.nDl.setOnClickListener(d(parama1));
        paramString.nDl.setOnLongClickListener(c(parama1));
        paramString.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
        parama = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
        paramString.nDl.setTag(parama);
        AppMethodBeat.o(163340);
        return;
        label334:
        if (!bs.isNullOrNil(parama.hTI.desc))
        {
          paramString.Ilp.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.HZF.getContext(), parama.hTI.desc));
          paramString.Ilp.setVisibility(0);
        }
        for (;;)
        {
          paramString.Ilo.setVisibility(0);
          paramString.Ilq.setVisibility(8);
          if ((parama.hTI.EGJ != 4) && (parama.hTI.EGJ != 6)) {
            break label449;
          }
          paramString.Ils.setVisibility(8);
          break;
          paramString.Ilp.setVisibility(8);
        }
        label449:
        if (parama.hTI.EGJ == 2)
        {
          paramString.Ils.setImageDrawable(am.k(paramString.Ilq.getContext(), 2131690348, com.tencent.mm.cc.a.n(paramString.Ilq.getContext(), 2131099828)));
          paramString.Ils.setVisibility(0);
        }
        else
        {
          paramString.Ils.setVisibility(8);
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(163341);
    int j = ((bj)paramView.getTag()).position;
    if (!((l)g.ad(l.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((parambo != null) && (com.tencent.mm.br.d.aCT("favorite")) && (i == 0))
      {
        paramContextMenu.add(j, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
        paramContextMenu.add(j, 116, 0, this.HNS.HZF.getMMResources().getString(2131761941));
      }
      AppMethodBeat.o(163341);
      return true;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163342);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163342);
      return false;
    }
    n.b(parama.HZF.getContext(), parambo);
    AppMethodBeat.o(163342);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163343);
    Object localObject = parambo.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.az((String)localObject, parambo.field_reserved);
    }
    if (paramView != null)
    {
      localObject = (b)paramView.ao(b.class);
      if (localObject != null)
      {
        paramView = new Intent();
        paramView.putExtra("feed_object_id", com.tencent.mm.ac.c.ur(((b)localObject).hTI.objectId));
        paramView.putExtra("feed_object_nonceId", ((b)localObject).hTI.objectNonceId);
        if (!w.sQ(parambo.field_talker)) {
          break label196;
        }
        paramView.putExtra("report_scene", 2);
      }
    }
    for (;;)
    {
      paramView.putExtra("from_user", parambo.field_talker);
      localObject = com.tencent.mm.plugin.finder.utils.n.rPN;
      paramView.putExtra("key_from_user_name", com.tencent.mm.plugin.finder.utils.n.aj(parambo));
      localObject = com.tencent.mm.plugin.finder.utils.n.rPN;
      paramView.putExtra("key_to_user_name", com.tencent.mm.plugin.finder.utils.n.ak(parambo));
      paramView.putExtra("tab_type", 6);
      ((l)g.ad(l.class)).enterFinderShareFeedUI(parama.HZF.getContext(), paramView);
      AppMethodBeat.o(163343);
      return false;
      label196:
      paramView.putExtra("report_scene", 1);
    }
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 754974769);
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.b
 * JD-Core Version:    0.7.0.1
 */