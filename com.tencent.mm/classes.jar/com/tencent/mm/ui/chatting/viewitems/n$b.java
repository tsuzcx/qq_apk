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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.i.a.b;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import java.util.List;

public final class n$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493437);
      ((View)localObject).setTag(new n.a().C((View)localObject, false));
    }
    AppMethodBeat.o(163339);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(163340);
    this.Gob = parama1;
    paramString = (n.a)parama;
    parama = parambl.field_content;
    if (parama != null) {}
    for (parama = k.b.ar(parama, parambl.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (b)parama.ao(b.class);
        if (parama != null)
        {
          Object localObject = com.tencent.mm.plugin.finder.loader.h.qCF;
          localObject = com.tencent.mm.plugin.finder.loader.h.cmV();
          com.tencent.mm.plugin.finder.loader.k localk = new com.tencent.mm.plugin.finder.loader.k(parama.htg.qDs, com.tencent.mm.plugin.finder.storage.h.qJZ);
          ImageView localImageView = paramString.GLp;
          com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
          ((com.tencent.mm.loader.d)localObject).a(localk, localImageView, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCK));
          paramString.GLq.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.GzJ.getContext(), parama.htg.nickname));
          localObject = parama.htg.mediaList;
          if (!((List)localObject).isEmpty()) {
            ((j)g.ad(j.class)).loadImage(((alc)((List)localObject).get(0)).thumbUrl, paramString.GLr);
          }
          if (parama.htg.Dmx != 1) {
            break label334;
          }
          paramString.GLs.setVisibility(8);
          paramString.GLr.setVisibility(8);
          paramString.GLt.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.GzJ.getContext(), parama.htg.desc));
          paramString.GLt.setVisibility(0);
        }
      }
      for (;;)
      {
        paramString.naN.setOnClickListener(d(parama1));
        paramString.naN.setOnLongClickListener(c(parama1));
        paramString.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
        parama = new bi(parambl, this.Gob.eZb(), paramInt, null, '\000');
        paramString.naN.setTag(parama);
        AppMethodBeat.o(163340);
        return;
        label334:
        if (!bt.isNullOrNil(parama.htg.desc))
        {
          paramString.GLs.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.GzJ.getContext(), parama.htg.desc));
          paramString.GLs.setVisibility(0);
        }
        for (;;)
        {
          paramString.GLr.setVisibility(0);
          paramString.GLt.setVisibility(8);
          if ((parama.htg.Dmx != 4) && (parama.htg.Dmx != 6)) {
            break label449;
          }
          paramString.GLv.setVisibility(8);
          break;
          paramString.GLs.setVisibility(8);
        }
        label449:
        if (parama.htg.Dmx == 2)
        {
          paramString.GLv.setImageDrawable(am.i(paramString.GLt.getContext(), 2131690348, com.tencent.mm.cd.a.n(paramString.GLt.getContext(), 2131099828)));
          paramString.GLv.setVisibility(0);
        }
        else
        {
          paramString.GLv.setVisibility(8);
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(163341);
    int j = ((bi)paramView.getTag()).position;
    if (!((j)g.ad(j.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((parambl != null) && (com.tencent.mm.bs.d.axB("favorite")) && (i == 0))
      {
        paramContextMenu.add(j, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
        paramContextMenu.add(j, 116, 0, this.Gob.GzJ.getMMResources().getString(2131761941));
      }
      AppMethodBeat.o(163341);
      return true;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(163342);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163342);
      return false;
    }
    n.b(parama.GzJ.getContext(), parambl);
    AppMethodBeat.o(163342);
    return true;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 754974769);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(163343);
    Object localObject = parambl.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.ar((String)localObject, parambl.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (b)paramView.ao(b.class);
      if (paramView != null)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("feed_object_id", com.tencent.mm.ad.c.rc(paramView.htg.objectId));
        ((Intent)localObject).putExtra("feed_object_nonceId", paramView.htg.objectNonceId);
        if (!w.pF(parambl.field_talker)) {
          break label165;
        }
        ((Intent)localObject).putExtra("report_scene", 2);
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("from_user", parambl.field_talker);
      ((Intent)localObject).putExtra("tab_type", 6);
      ((j)g.ad(j.class)).enterFinderShareFeedUI(parama.GzJ.getContext(), (Intent)localObject);
      AppMethodBeat.o(163343);
      return false;
      label165:
      ((Intent)localObject).putExtra("report_scene", 1);
    }
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.b
 * JD-Core Version:    0.7.0.1
 */