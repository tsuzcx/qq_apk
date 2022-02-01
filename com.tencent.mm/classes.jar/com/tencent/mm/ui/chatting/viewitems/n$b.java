package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.i.a.b;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;
import java.util.List;

public final class n$b
  extends c
{
  private a JBI;
  
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
      localObject = new ah(paramLayoutInflater, 2131493437);
      ((View)localObject).setTag(new n.a().C((View)localObject, false));
    }
    AppMethodBeat.o(163339);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(163340);
    this.JBI = parama1;
    paramString = (n.a)parama;
    paramString.KbR.animate().cancel();
    paramString.KbR.setTag(Long.valueOf(System.currentTimeMillis()));
    parama = parambu.field_content;
    if (parama != null) {}
    for (parama = k.b.aA(parama, parambu.field_reserved);; parama = null)
    {
      Object localObject;
      if (parama != null)
      {
        parama = (b)parama.ao(b.class);
        if (parama != null)
        {
          localObject = i.sja;
          localObject = i.cCC();
          com.tencent.mm.plugin.finder.loader.l locall = new com.tencent.mm.plugin.finder.loader.l(parama.inc.sjU, r.syE);
          ImageView localImageView = paramString.KbK;
          i locali = i.sja;
          ((com.tencent.mm.loader.d)localObject).a(locall, localImageView, i.a(i.a.sjf));
          paramString.KbL.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama.inc.nickname));
          al.a(paramString.KbL.getPaint(), 0.8F);
          localObject = parama.inc.mediaList;
          if (!((List)localObject).isEmpty())
          {
            ((t)g.ad(t.class)).loadImage(((ari)((List)localObject).get(0)).thumbUrl, paramString.KbM);
            n.a(paramString, (List)localObject);
          }
          if (parama.inc.Gpi != 1) {
            break label380;
          }
          paramString.KbN.setVisibility(8);
          paramString.KbM.setVisibility(8);
          paramString.KbO.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama.inc.desc));
          paramString.KbO.setVisibility(0);
        }
      }
      for (;;)
      {
        paramString.ofK.setOnClickListener(d(parama1));
        paramString.ofK.setOnLongClickListener(c(parama1));
        paramString.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
        parama = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
        paramString.ofK.setTag(parama);
        AppMethodBeat.o(163340);
        return;
        label380:
        if (!bt.isNullOrNil(parama.inc.desc))
        {
          paramString.KbN.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama.inc.desc));
          paramString.KbN.setVisibility(0);
        }
        for (;;)
        {
          paramString.KbM.setVisibility(0);
          paramString.KbO.setVisibility(8);
          if ((parama.inc.Gpi != 4) && (parama.inc.Gpi != 6)) {
            break label504;
          }
          paramString.KbQ.setVisibility(0);
          paramString.zQo.setVisibility(8);
          break;
          paramString.KbN.setVisibility(8);
        }
        label504:
        if (parama.inc.Gpi == 2)
        {
          paramString.KbQ.setVisibility(8);
          paramString.zQo.setVisibility(0);
          paramString.zQo.ABt = ((List)localObject).size();
        }
        else
        {
          paramString.KbQ.setVisibility(8);
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    AppMethodBeat.i(163342);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163342);
      return false;
    }
    n.b(parama.JOR.getContext(), parambu);
    AppMethodBeat.o(163342);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194344);
    int j = ((bk)paramView.getTag()).position;
    if (!((t)g.ad(t.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((parambu != null) && (com.tencent.mm.bs.d.aIu("favorite")) && (i == 0))
      {
        paraml.a(j, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
        paraml.a(j, 116, this.JBI.JOR.getMMResources().getString(2131761941), 2131690400);
      }
      AppMethodBeat.o(194344);
      return true;
    }
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    AppMethodBeat.i(163343);
    Object localObject2 = parambu.field_content;
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = k.b.aA((String)localObject2, parambu.field_reserved);
    }
    if (localObject1 != null)
    {
      localObject1 = (b)((k.b)localObject1).ao(b.class);
      if (localObject1 != null)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ad.c.xh(((b)localObject1).inc.objectId));
        ((Intent)localObject2).putExtra("feed_object_nonceId", ((b)localObject1).inc.objectNonceId);
        if (!w.vF(parambu.field_talker)) {
          break label204;
        }
        ((Intent)localObject2).putExtra("report_scene", 2);
      }
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("from_user", parambu.field_talker);
      p localp = p.sMo;
      ((Intent)localObject2).putExtra("key_from_user_name", p.am(parambu));
      localp = p.sMo;
      ((Intent)localObject2).putExtra("key_to_user_name", p.an(parambu));
      ((Intent)localObject2).putExtra("tab_type", 6);
      n.a(paramView, parama, (b)localObject1, (Intent)localObject2, false, w.vF(parambu.field_talker));
      AppMethodBeat.o(163343);
      return false;
      label204:
      ((Intent)localObject2).putExtra("report_scene", 1);
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 754974769);
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.b
 * JD-Core Version:    0.7.0.1
 */