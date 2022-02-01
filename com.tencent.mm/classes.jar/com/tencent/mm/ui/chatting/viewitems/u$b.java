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
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class u$b
  extends c
{
  private a WBq;
  
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
      localObject = new aq(paramLayoutInflater, R.i.ecU);
      ((View)localObject).setTag(new u.a().Q((View)localObject, false));
    }
    AppMethodBeat.o(163353);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(163354);
    this.WBq = parama1;
    paramString = (u.a)parama;
    Object localObject = paramca.field_content;
    parama = null;
    if (localObject != null) {
      parama = k.b.aG((String)localObject, paramca.field_reserved);
    }
    x localx;
    ImageView localImageView;
    t localt;
    if (parama != null)
    {
      parama = (e)parama.ar(e.class);
      if (parama != null)
      {
        localObject = t.ztT;
        localObject = t.dJh();
        localx = new x(parama.avatar, com.tencent.mm.plugin.finder.storage.u.Alz);
        localImageView = paramString.jiu;
        localt = t.ztT;
        ((d)localObject).a(localx, localImageView, t.a(t.a.zua));
        paramString.iZH.setText(l.c(parama1.WQv.getContext(), parama.nickname));
        int i = parama.Bve;
        if (i <= 0) {
          break label442;
        }
        paramString.Atw.setVisibility(0);
        switch (i)
        {
        default: 
          if ((i == 1) && (!Util.isNullOrNil(parama.Bvd)))
          {
            paramString.Atx.setVisibility(0);
            paramString.Atx.setText(parama.Bvd);
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramString.clickArea.setOnClickListener(d(parama1));
      paramString.clickArea.setOnLongClickListener(c(parama1));
      paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
      parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
      paramString.clickArea.setTag(parama);
      AppMethodBeat.o(163354);
      return;
      if (!parama.authIconUrl.isEmpty())
      {
        localObject = t.ztT;
        localObject = t.dJe();
        localx = new x(parama.authIconUrl, com.tencent.mm.plugin.finder.storage.u.Aly);
        localImageView = paramString.Atw;
        localt = t.ztT;
        ((d)localObject).a(localx, localImageView, t.a(t.a.ztU));
        break;
      }
      paramString.Atw.setImageDrawable(au.o(parama1.WQv.getContext(), R.k.icons_filled_star_identify, parama1.WQv.getMMResources().getColor(R.e.Orange)));
      break;
      paramString.Atw.setImageResource(R.k.icons_filled_star_identify_enterprise);
      break;
      paramString.Atw.setVisibility(8);
      break;
      label442:
      paramString.Atw.setVisibility(8);
      break;
      paramString.Atx.setVisibility(8);
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
    u.d(parama.WQv.getContext(), paramca);
    AppMethodBeat.o(163355);
    return true;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(292013);
    paramo.a(0, 111, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
    AppMethodBeat.o(292013);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
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
      paramView = k.b.aG((String)localObject, paramca.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (e)paramView.ar(e.class);
      if ((paramView != null) && (!Util.isNullOrNil(paramView.username)))
      {
        localObject = new Intent();
        if (!ab.Lj(paramca.field_talker)) {
          break label252;
        }
        ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 2);
        ((Intent)localObject).putExtra("key_from_profile_share_scene", 2);
      }
    }
    for (;;)
    {
      ak localak = (ak)h.ag(ak.class);
      if (ab.Lj(paramca.field_talker)) {
        i = 3;
      }
      localak.fillContextIdToIntent(i, 3, 32, (Intent)localObject);
      ((Intent)localObject).putExtra("key_enter_profile_type", 4);
      ((Intent)localObject).putExtra("key_comment_scene", 11);
      ((Intent)localObject).putExtra("from_user", paramca.field_talker);
      ((Intent)localObject).putExtra("finder_username", paramView.username);
      ((Intent)localObject).putExtra("key_finder_teen_mode_check", true);
      ((Intent)localObject).putExtra("key_finder_teen_mode_user_name", paramView.nickname);
      ((Intent)localObject).putExtra("key_finder_teen_mode_user_id", paramView.username);
      ((ak)h.ag(ak.class)).enterFinderProfileUI(parama.WQv.getContext(), (Intent)localObject);
      AppMethodBeat.o(163356);
      return false;
      label252:
      ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 1);
      ((Intent)localObject).putExtra("key_from_profile_share_scene", 1);
    }
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.b
 * JD-Core Version:    0.7.0.1
 */