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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.n;

public final class q$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(194360);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131496440);
      ((View)localObject).setTag(new q.a().F((View)localObject, true));
    }
    AppMethodBeat.o(194360);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(194362);
    if (parambu.cTc())
    {
      m.aG(parambu);
      bj.rJ(parambu.field_msgId);
      parama.xR(true);
    }
    AppMethodBeat.o(194362);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(194361);
    this.JBI = parama1;
    paramString = (q.a)parama;
    parama = parambu.field_content;
    if (parama != null) {}
    for (parama = k.b.aA(parama, parambu.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (com.tencent.mm.plugin.game.luggage.e.a)parama.ao(com.tencent.mm.plugin.game.luggage.e.a.class);
        if (parama != null)
        {
          q.B(paramString.fRd, parama.iconUrl);
          paramString.opA.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama.bVF));
          if (bt.isNullOrNil(parama.desc))
          {
            paramString.gUs.setVisibility(8);
            if (!bt.isNullOrNil(parama.tUK)) {
              break label336;
            }
            paramString.KbU.setText(parama1.JOR.getMMResources().getString(2131767062));
          }
        }
        else
        {
          label141:
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
          break label382;
        }
        b(paramString, false);
        if ((parambu.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu.field_msgId))) {
          break label361;
        }
        if (paramString.KbJ != null) {
          paramString.KbJ.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, paramString, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
        AppMethodBeat.o(194361);
        return;
        paramString.gUs.setVisibility(0);
        paramString.gUs.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama.desc));
        break;
        label336:
        paramString.KbU.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama.tUK));
        break label141;
        label361:
        if (paramString.KbJ != null)
        {
          paramString.KbJ.setVisibility(8);
          continue;
          label382:
          if (paramString.KbJ != null) {
            paramString.KbJ.setVisibility(8);
          }
          if (parambu.field_status < 2) {
            bool = true;
          }
          b(paramString, bool);
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(194364);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(194364);
      return false;
    }
    e.b.a(parama, parambu, b(parama, parambu));
    AppMethodBeat.o(194364);
    return true;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194363);
    int i = ((bk)paramView.getTag()).position;
    if (parambu != null)
    {
      if (((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker)) && (!am.yt(this.JBI.getTalkerUserName()))) {
        paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      paraml.a(i, 111, paramView.getContext().getString(2131762559), 2131690478);
    }
    AppMethodBeat.o(194363);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(194365);
    String str = parambu.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aA(str, parambu.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (com.tencent.mm.plugin.game.luggage.e.a)paramView.ao(com.tencent.mm.plugin.game.luggage.e.a.class);
      if ((paramView != null) && (!bt.isNullOrNil(paramView.jumpUrl)))
      {
        parambu = new Intent();
        parambu.putExtra("rawUrl", paramView.jumpUrl);
        d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", parambu);
      }
    }
    AppMethodBeat.o(194365);
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 939524145);
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.c
 * JD-Core Version:    0.7.0.1
 */