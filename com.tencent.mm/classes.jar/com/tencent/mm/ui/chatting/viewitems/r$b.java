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
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class r$b
  extends c
{
  private a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493536);
      ((View)localObject).setTag(new r.a().M((View)localObject, false));
    }
    AppMethodBeat.o(163353);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(163354);
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
        int i = parama.wDY;
        if (i <= 0) {
          break label439;
        }
        paramString.vMF.setVisibility(0);
        switch (i)
        {
        default: 
          if ((i == 1) && (!Util.isNullOrNil(parama.wDX)))
          {
            paramString.vMG.setVisibility(0);
            paramString.vMG.setText(parama.wDX);
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramString.clickArea.setOnClickListener(d(parama1));
      paramString.clickArea.setOnLongClickListener(c(parama1));
      paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
      parama = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
      paramString.clickArea.setTag(parama);
      AppMethodBeat.o(163354);
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
      label439:
      paramString.vMF.setVisibility(8);
      break;
      paramString.vMG.setVisibility(8);
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(163355);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163355);
      return false;
    }
    r.d(parama.Pwc.getContext(), paramca);
    AppMethodBeat.o(163355);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233682);
    paramm.a(0, 111, paramView.getContext().getString(2131764628), 2131690674);
    AppMethodBeat.o(233682);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 771751985);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    int i = 2;
    AppMethodBeat.i(163356);
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
      AppMethodBeat.o(163356);
      return false;
      label252:
      ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 1);
      ((Intent)localObject).putExtra("key_from_profile_share_scene", 1);
    }
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.b
 * JD-Core Version:    0.7.0.1
 */