package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.n;

public final class m$c
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
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
      localObject = new ah(paramLayoutInflater, 2131493480);
      ((View)localObject).setTag(new m.a().G((View)localObject, true));
    }
    AppMethodBeat.o(163333);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(163336);
    if (parambv.cVH())
    {
      m.aF(parambv);
      bl.rW(parambv.field_msgId);
      parama.xY(true);
    }
    AppMethodBeat.o(163336);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(163334);
    this.JWz = parama1;
    paramString = (m.a)parama;
    String str = parambv.field_content;
    parama = null;
    if (str != null) {
      parama = k.b.aB(str, parambv.field_reserved);
    }
    if (parama != null)
    {
      parama = (d)parama.ao(d.class);
      if (parama != null)
      {
        paramString.KxY.setImageDrawable(ao.k(parama1.Kkd.getContext(), 2131690196, parama1.Kkd.getContext().getResources().getColor(2131099778)));
        paramString.KxZ.setText(2131759195);
        if (bu.isNullOrNil(parama.desc))
        {
          paramString.Kya.setVisibility(8);
          paramString.fQm.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.title));
        }
      }
      else
      {
        paramString.olI.setOnClickListener(d(parama1));
        paramString.olI.setOnLongClickListener(c(parama1));
        paramString.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
        parama = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
        paramString.olI.setTag(parama);
      }
    }
    else
    {
      if (!fLB()) {
        break label362;
      }
      b(paramString, false);
      if ((parambv.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv.field_msgId))) {
        break label341;
      }
      if (paramString.Kyb != null) {
        paramString.Kyb.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, paramString, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
      AppMethodBeat.o(163334);
      return;
      paramString.Kya.setVisibility(0);
      paramString.Kya.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.desc));
      break;
      label341:
      if (paramString.Kyb != null) {
        paramString.Kyb.setVisibility(8);
      }
    }
    label362:
    if (paramString.Kyb != null) {
      paramString.Kyb.setVisibility(8);
    }
    if (parambv.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(paramString, bool);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187738);
    int i = ((bk)paramView.getTag()).position;
    if ((parambv != null) && ((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker)) && (!an.zd(this.JWz.getTalkerUserName()))) {
      paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
    }
    AppMethodBeat.o(187738);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(163337);
    parama = parambv.field_content;
    paramView = null;
    if (parama != null) {
      paramView = k.b.aB(parama, parambv.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (d)paramView.ao(d.class);
      if (paramView != null)
      {
        parama = new vq();
        parama.dKT.userName = "gh_4ee148a6ecaa@app";
        parama.dKT.appId = "wxdfda2588e999a42d";
        parama.dKT.dKV = paramView.rPA;
        com.tencent.mm.sdk.b.a.IvT.l(parama);
      }
    }
    AppMethodBeat.o(163337);
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 788529201);
  }
  
  public final boolean fLz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.c
 * JD-Core Version:    0.7.0.1
 */