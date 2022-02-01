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
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.n;

public final class o$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
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
      ((View)localObject).setTag(new o.a().D((View)localObject, true));
    }
    AppMethodBeat.o(163357);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(163359);
    if (parambu.cTc())
    {
      m.aG(parambu);
      bj.rJ(parambu.field_msgId);
      parama.xR(true);
    }
    AppMethodBeat.o(163359);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(163358);
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
    int i;
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
        i = parama.tfK;
        if (i <= 0) {
          break label520;
        }
        paramString.sgf.setVisibility(0);
      }
    }
    switch (i)
    {
    default: 
      if ((i == 1) && (!bt.isNullOrNil(parama.tfJ)))
      {
        paramString.sEx.setVisibility(0);
        paramString.sEx.setText(parama.tfJ);
        label229:
        paramString.ofK.setOnClickListener(d(parama1));
        paramString.ofK.setOnLongClickListener(c(parama1));
        paramString.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
        parama = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
        paramString.ofK.setTag(parama);
        if (!fHj()) {
          break label567;
        }
        b(paramString, false);
        if ((parambu.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu.field_msgId))) {
          break label546;
        }
        if (paramString.KbJ != null) {
          paramString.KbJ.setVisibility(0);
        }
      }
      break;
    }
    for (;;)
    {
      a(paramInt, paramString, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
      AppMethodBeat.o(163358);
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
      label520:
      paramString.sgf.setVisibility(8);
      break;
      paramString.sEx.setVisibility(8);
      break label229;
      label546:
      if (paramString.KbJ != null) {
        paramString.KbJ.setVisibility(8);
      }
    }
    label567:
    if (paramString.KbJ != null) {
      paramString.KbJ.setVisibility(8);
    }
    if (parambu.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(paramString, bool);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(163361);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163361);
      return false;
    }
    o.c(parama.JOR.getContext(), parambu);
    AppMethodBeat.o(163361);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194351);
    int i = ((bk)paramView.getTag()).position;
    if (parambu != null)
    {
      if (((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker)) && (!am.yt(this.JBI.getTalkerUserName()))) {
        paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      paraml.a(i, 111, paramView.getContext().getString(2131762559), 2131690478);
    }
    AppMethodBeat.o(194351);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    int i = 2;
    AppMethodBeat.i(163362);
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
      AppMethodBeat.o(163362);
      return false;
      label206:
      ((Intent)localObject).putExtra("key_from_profile_share_scene", 1);
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 771751985);
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.c
 * JD-Core Version:    0.7.0.1
 */