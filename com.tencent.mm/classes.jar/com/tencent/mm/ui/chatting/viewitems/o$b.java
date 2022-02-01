package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class o$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
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
      ((View)localObject).setTag(new o.a().D((View)localObject, false));
    }
    AppMethodBeat.o(163353);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(163354);
    this.JBI = parama1;
    paramString = (o.a)parama;
    Object localObject = parambu.field_content;
    parama = null;
    if (localObject != null) {
      parama = k.b.aA((String)localObject, parambu.field_reserved);
    }
    com.tencent.mm.plugin.finder.loader.l locall;
    ImageView localImageView;
    i locali;
    if (parama != null)
    {
      parama = (com.tencent.mm.plugin.i.a.a)parama.ao(com.tencent.mm.plugin.i.a.a.class);
      if (parama != null)
      {
        localObject = i.sja;
        localObject = i.cCC();
        locall = new com.tencent.mm.plugin.finder.loader.l(parama.sjU, r.syE);
        localImageView = paramString.fRd;
        locali = i.sja;
        ((d)localObject).a(locall, localImageView, i.a(i.a.sjf));
        paramString.fOg.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama.nickname));
        int i = parama.tfK;
        if (i <= 0) {
          break label439;
        }
        paramString.sgf.setVisibility(0);
        switch (i)
        {
        default: 
          if ((i == 1) && (!bt.isNullOrNil(parama.tfJ)))
          {
            paramString.sEx.setVisibility(0);
            paramString.sEx.setText(parama.tfJ);
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramString.ofK.setOnClickListener(d(parama1));
      paramString.ofK.setOnLongClickListener(c(parama1));
      paramString.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
      parama = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
      paramString.ofK.setTag(parama);
      AppMethodBeat.o(163354);
      return;
      if (!parama.authIconUrl.isEmpty())
      {
        localObject = i.sja;
        localObject = i.cCB();
        locall = new com.tencent.mm.plugin.finder.loader.l(parama.authIconUrl, r.syD);
        localImageView = paramString.sgf;
        locali = i.sja;
        ((d)localObject).a(locall, localImageView, i.a(i.a.sjb));
        break;
      }
      paramString.sgf.setImageDrawable(ao.k(parama1.JOR.getContext(), 2131690481, parama1.JOR.getMMResources().getColor(2131099777)));
      break;
      paramString.sgf.setImageResource(2131691604);
      break;
      paramString.sgf.setVisibility(8);
      break;
      label439:
      paramString.sgf.setVisibility(8);
      break;
      paramString.sEx.setVisibility(8);
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(163355);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163355);
      return false;
    }
    o.c(parama.JOR.getContext(), parambu);
    AppMethodBeat.o(163355);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194350);
    paraml.a(0, 111, paramView.getContext().getString(2131762559), 2131690478);
    AppMethodBeat.o(194350);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    int i = 2;
    AppMethodBeat.i(163356);
    Object localObject = parambu.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.aA((String)localObject, parambu.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (com.tencent.mm.plugin.i.a.a)paramView.ao(com.tencent.mm.plugin.i.a.a.class);
      if ((paramView != null) && (!bt.isNullOrNil(paramView.username)))
      {
        localObject = new Intent();
        if (!w.vF(parambu.field_talker)) {
          break label206;
        }
        ((Intent)localObject).putExtra("key_from_profile_share_scene", 2);
      }
    }
    for (;;)
    {
      t localt = (t)g.ad(t.class);
      if (w.vF(parambu.field_talker)) {
        i = 3;
      }
      localt.fillContextIdToIntent(i, 3, 32, (Intent)localObject);
      ((Intent)localObject).putExtra("key_enter_profile_type", 4);
      ((Intent)localObject).putExtra("key_comment_scene", 11);
      ((Intent)localObject).putExtra("from_user", parambu.field_talker);
      ((Intent)localObject).putExtra("finder_username", paramView.username);
      ((t)g.ad(t.class)).enterFinderProfileUI(parama.JOR.getContext(), (Intent)localObject);
      AppMethodBeat.o(163356);
      return false;
      label206:
      ((Intent)localObject).putExtra("key_from_profile_share_scene", 1);
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 771751985);
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.b
 * JD-Core Version:    0.7.0.1
 */