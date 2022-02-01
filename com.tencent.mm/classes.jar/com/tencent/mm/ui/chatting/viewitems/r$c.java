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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.n;

public final class r$c
  extends c
  implements t.n
{
  private a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493587);
      ((View)localObject).setTag(new r.a().M((View)localObject, true));
    }
    AppMethodBeat.o(163357);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(163358);
    this.PhN = parama1;
    paramString = (r.a)parama;
    Object localObject = paramca.field_content;
    parama = null;
    if (localObject != null) {
      parama = k.b.aD((String)localObject, paramca.field_reserved);
    }
    p localp;
    ImageView localImageView;
    com.tencent.mm.plugin.finder.loader.m localm;
    int i;
    if (parama != null)
    {
      parama = (e)parama.as(e.class);
      if (parama != null)
      {
        localObject = com.tencent.mm.plugin.finder.loader.m.uJa;
        localObject = com.tencent.mm.plugin.finder.loader.m.dka();
        localp = new p(parama.uNR, x.vEo);
        localImageView = paramString.gyr;
        localm = com.tencent.mm.plugin.finder.loader.m.uJa;
        ((d)localObject).a(localp, localImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJh));
        paramString.gvw.setText(l.c(parama1.Pwc.getContext(), parama.nickname));
        i = parama.wDY;
        if (i <= 0) {
          break label520;
        }
        paramString.vMF.setVisibility(0);
      }
    }
    switch (i)
    {
    default: 
      if ((i == 1) && (!Util.isNullOrNil(parama.wDX)))
      {
        paramString.vMG.setVisibility(0);
        paramString.vMG.setText(parama.wDX);
        label229:
        paramString.clickArea.setOnClickListener(d(parama1));
        paramString.clickArea.setOnLongClickListener(c(parama1));
        paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
        parama = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
        paramString.clickArea.setTag(parama);
        if (!gTW()) {
          break label567;
        }
        b(paramString, false);
        if ((paramca.field_status != 2) || (!b((k)parama1.bh(k.class), paramca.field_msgId))) {
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
      a(paramInt, paramString, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
      AppMethodBeat.o(163358);
      return;
      if (!parama.authIconUrl.isEmpty())
      {
        localObject = com.tencent.mm.plugin.finder.loader.m.uJa;
        localObject = com.tencent.mm.plugin.finder.loader.m.djY();
        localp = new p(parama.authIconUrl, x.vEn);
        localImageView = paramString.vMF;
        localm = com.tencent.mm.plugin.finder.loader.m.uJa;
        ((d)localObject).a(localp, localImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
        break;
      }
      paramString.vMF.setImageDrawable(ar.m(parama1.Pwc.getContext(), 2131690678, parama1.Pwc.getMMResources().getColor(2131099792)));
      break;
      paramString.vMF.setImageResource(2131690679);
      break;
      paramString.vMF.setVisibility(8);
      break;
      label520:
      paramString.vMF.setVisibility(8);
      break;
      paramString.vMG.setVisibility(8);
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
    if (paramca.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(paramString, bool);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(163361);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163361);
      return false;
    }
    r.d(parama.Pwc.getContext(), paramca);
    AppMethodBeat.o(163361);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233684);
    int i = ((bq)paramView.getTag()).position;
    if (paramca != null)
    {
      if (((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
        paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
      }
      paramm.a(i, 111, paramView.getContext().getString(2131764628), 2131690674);
    }
    AppMethodBeat.o(233684);
    return true;
  }
  
  public final void b(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(233683);
    if (paramca.dOQ())
    {
      com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
      bp.Ad(paramca.field_msgId);
      parama.BN(true);
    }
    AppMethodBeat.o(233683);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 771751985);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    int i = 2;
    AppMethodBeat.i(163362);
    Object localObject = paramca.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.aD((String)localObject, paramca.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (e)paramView.as(e.class);
      if ((paramView != null) && (!Util.isNullOrNil(paramView.username)))
      {
        localObject = new Intent();
        if (!ab.Eq(paramca.field_talker)) {
          break label252;
        }
        ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 2);
        ((Intent)localObject).putExtra("key_from_profile_share_scene", 2);
      }
    }
    for (;;)
    {
      aj localaj = (aj)g.ah(aj.class);
      if (ab.Eq(paramca.field_talker)) {
        i = 3;
      }
      localaj.fillContextIdToIntent(i, 3, 32, (Intent)localObject);
      ((Intent)localObject).putExtra("key_enter_profile_type", 4);
      ((Intent)localObject).putExtra("key_comment_scene", 11);
      ((Intent)localObject).putExtra("from_user", paramca.field_talker);
      ((Intent)localObject).putExtra("finder_username", paramView.username);
      ((Intent)localObject).putExtra("key_finder_teen_mode_check", true);
      ((Intent)localObject).putExtra("key_finder_teen_mode_user_name", paramView.nickname);
      ((Intent)localObject).putExtra("key_finder_teen_mode_user_id", paramView.username);
      ((aj)g.ah(aj.class)).enterFinderProfileUI(parama.Pwc.getContext(), (Intent)localObject);
      AppMethodBeat.o(163362);
      return false;
      label252:
      ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 1);
      ((Intent)localObject).putExtra("key_from_profile_share_scene", 1);
    }
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.c
 * JD-Core Version:    0.7.0.1
 */