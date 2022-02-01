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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.n;

public final class m$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
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
      ((View)localObject).setTag(new m.a().B((View)localObject, true));
    }
    AppMethodBeat.o(163333);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(163336);
    if (parambu.cTc())
    {
      m.aG(parambu);
      bj.rJ(parambu.field_msgId);
      parama.xR(true);
    }
    AppMethodBeat.o(163336);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(163334);
    this.JBI = parama1;
    paramString = (m.a)parama;
    String str = parambu.field_content;
    parama = null;
    if (str != null) {
      parama = k.b.aA(str, parambu.field_reserved);
    }
    if (parama != null)
    {
      parama = (d)parama.ao(d.class);
      if (parama != null)
      {
        paramString.KbG.setImageDrawable(ao.k(parama1.JOR.getContext(), 2131690196, parama1.JOR.getContext().getResources().getColor(2131099778)));
        paramString.KbH.setText(2131759195);
        if (bt.isNullOrNil(parama.desc))
        {
          paramString.KbI.setVisibility(8);
          paramString.fOg.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama.title));
        }
      }
      else
      {
        paramString.ofK.setOnClickListener(d(parama1));
        paramString.ofK.setOnLongClickListener(c(parama1));
        paramString.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
        parama = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
        paramString.ofK.setTag(parama);
      }
    }
    else
    {
      if (!fHj()) {
        break label362;
      }
      b(paramString, false);
      if ((parambu.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu.field_msgId))) {
        break label341;
      }
      if (paramString.KbJ != null) {
        paramString.KbJ.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, paramString, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
      AppMethodBeat.o(163334);
      return;
      paramString.KbI.setVisibility(0);
      paramString.KbI.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama.desc));
      break;
      label341:
      if (paramString.KbJ != null) {
        paramString.KbJ.setVisibility(8);
      }
    }
    label362:
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
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194343);
    int i = ((bk)paramView.getTag()).position;
    if ((parambu != null) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker)) && (!am.yt(this.JBI.getTalkerUserName()))) {
      paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
    }
    AppMethodBeat.o(194343);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(163337);
    parama = parambu.field_content;
    paramView = null;
    if (parama != null) {
      paramView = k.b.aA(parama, parambu.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (d)paramView.ao(d.class);
      if (paramView != null)
      {
        parama = new vm();
        parama.dJF.userName = "gh_4ee148a6ecaa@app";
        parama.dJF.appId = "wxdfda2588e999a42d";
        parama.dJF.dJH = paramView.rHp;
        com.tencent.mm.sdk.b.a.IbL.l(parama);
      }
    }
    AppMethodBeat.o(163337);
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 788529201);
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.c
 * JD-Core Version:    0.7.0.1
 */