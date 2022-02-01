package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.du;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.s.n;

public final class m$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493480);
      ((View)localObject).setTag(new m.a().B((View)localObject, true));
    }
    AppMethodBeat.o(163333);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(163336);
    if (parambl.cxB())
    {
      m.aB(parambl);
      com.tencent.mm.model.bi.lW(parambl.field_msgId);
      parama.wc(true);
    }
    AppMethodBeat.o(163336);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(163334);
    this.Gob = parama1;
    paramString = (m.a)parama;
    String str = parambl.field_content;
    parama = null;
    if (str != null) {
      parama = k.b.ar(str, parambl.field_reserved);
    }
    if (parama != null)
    {
      parama = (com.tencent.mm.plugin.finder.api.c)parama.ao(com.tencent.mm.plugin.finder.api.c.class);
      if (parama != null)
      {
        paramString.GLl.setImageDrawable(am.i(parama1.GzJ.getContext(), 2131690196, parama1.GzJ.getContext().getResources().getColor(2131099778)));
        paramString.GLm.setText(2131759195);
        if (bt.isNullOrNil(parama.desc))
        {
          paramString.GLn.setVisibility(8);
          paramString.frs.setText(k.c(parama1.GzJ.getContext(), parama.title));
        }
      }
      else
      {
        paramString.naN.setOnClickListener(d(parama1));
        paramString.naN.setOnLongClickListener(c(parama1));
        paramString.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
        parama = new bi(parambl, this.Gob.eZb(), paramInt, null, '\000');
        paramString.naN.setTag(parama);
      }
    }
    else
    {
      if (!faG()) {
        break label365;
      }
      paramString.uPp.setVisibility(8);
      if ((parambl.field_status != 2) || (!a((i)parama1.be(i.class), parambl.field_msgId))) {
        break label344;
      }
      if (paramString.GLo != null) {
        paramString.GLo.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, paramString, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
      AppMethodBeat.o(163334);
      return;
      paramString.GLn.setVisibility(0);
      paramString.GLn.setText(k.c(parama1.GzJ.getContext(), parama.desc));
      break;
      label344:
      if (paramString.GLo != null)
      {
        paramString.GLo.setVisibility(8);
        continue;
        label365:
        if (paramString.GLo != null) {
          paramString.GLo.setVisibility(8);
        }
        if (paramString.uPp != null)
        {
          paramString.uPp.setVisibility(0);
          if (parambl.field_status >= 2) {
            paramString.uPp.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(163335);
    int i = ((bi)paramView.getTag()).position;
    if ((parambl != null) && ((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker)) && (!com.tencent.mm.storage.af.rz(this.Gob.getTalkerUserName()))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
    }
    AppMethodBeat.o(163335);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 788529201);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(163337);
    parama = parambl.field_content;
    paramView = null;
    if (parama != null) {
      paramView = k.b.ar(parama, parambl.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (com.tencent.mm.plugin.finder.api.c)paramView.ao(com.tencent.mm.plugin.finder.api.c.class);
      if (paramView != null)
      {
        parama = new uj();
        parama.dzH.userName = "gh_4ee148a6ecaa@app";
        parama.dzH.appId = "wxdfda2588e999a42d";
        parama.dzH.dzJ = paramView.qoa;
        com.tencent.mm.sdk.b.a.ESL.l(parama);
      }
    }
    AppMethodBeat.o(163337);
    return false;
  }
  
  public final boolean faE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.c
 * JD-Core Version:    0.7.0.1
 */