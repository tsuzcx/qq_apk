package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.s.n;

public final class m$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(163333);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493480);
      ((View)localObject).setTag(new m.a().B((View)localObject, true));
    }
    AppMethodBeat.o(163333);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163336);
    if (parambo.cKN())
    {
      m.aD(parambo);
      bi.pK(parambo.field_msgId);
      parama.xg(true);
    }
    AppMethodBeat.o(163336);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(163334);
    this.HNS = parama1;
    paramString = (m.a)parama;
    String str = parambo.field_content;
    parama = null;
    if (str != null) {
      parama = k.b.az(str, parambo.field_reserved);
    }
    if (parama != null)
    {
      parama = (com.tencent.mm.plugin.finder.api.c)parama.ao(com.tencent.mm.plugin.finder.api.c.class);
      if (parama != null)
      {
        paramString.Ili.setImageDrawable(am.k(parama1.HZF.getContext(), 2131690196, parama1.HZF.getContext().getResources().getColor(2131099778)));
        paramString.Ilj.setText(2131759195);
        if (bs.isNullOrNil(parama.desc))
        {
          paramString.Ilk.setVisibility(8);
          paramString.fuZ.setText(k.c(parama1.HZF.getContext(), parama.title));
        }
      }
      else
      {
        paramString.nDl.setOnClickListener(d(parama1));
        paramString.nDl.setOnLongClickListener(c(parama1));
        paramString.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
        parama = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
        paramString.nDl.setTag(parama);
      }
    }
    else
    {
      if (!fqw()) {
        break label362;
      }
      b(paramString, false);
      if ((parambo.field_status != 2) || (!a((i)parama1.bf(i.class), parambo.field_msgId))) {
        break label341;
      }
      if (paramString.Ill != null) {
        paramString.Ill.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, paramString, parambo, parama1.foM(), parama1.foQ(), parama1, this);
      AppMethodBeat.o(163334);
      return;
      paramString.Ilk.setVisibility(0);
      paramString.Ilk.setText(k.c(parama1.HZF.getContext(), parama.desc));
      break;
      label341:
      if (paramString.Ill != null) {
        paramString.Ill.setVisibility(8);
      }
    }
    label362:
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
    AppMethodBeat.i(163335);
    int i = ((bj)paramView.getTag()).position;
    if ((parambo != null) && ((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker)) && (!ai.vC(this.HNS.getTalkerUserName()))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
    }
    AppMethodBeat.o(163335);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163337);
    parama = parambo.field_content;
    paramView = null;
    if (parama != null) {
      paramView = k.b.az(parama, parambo.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (com.tencent.mm.plugin.finder.api.c)paramView.ao(com.tencent.mm.plugin.finder.api.c.class);
      if (paramView != null)
      {
        parama = new ut();
        parama.dxt.userName = "gh_4ee148a6ecaa@app";
        parama.dxt.appId = "wxdfda2588e999a42d";
        parama.dxt.dxv = paramView.qWv;
        com.tencent.mm.sdk.b.a.GpY.l(parama);
      }
    }
    AppMethodBeat.o(163337);
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 788529201);
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.c
 * JD-Core Version:    0.7.0.1
 */