package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
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
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a;
import com.tencent.mm.plugin.finder.view.adapter.b;
import com.tencent.mm.plugin.finder.view.adapter.b.c;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.n;
import java.util.LinkedList;
import java.util.List;

public final class n$c
  extends c
  implements t.n
{
  private a PhN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(233654);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493582);
      ((View)localObject).setTag(new n.a().J((View)localObject, true));
    }
    AppMethodBeat.o(233654);
    return localObject;
  }
  
  public final void a(final c.a parama, int paramInt, a parama1, final ca paramca, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(233655);
    this.PhN = parama1;
    paramString = (n.a)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = n.q(parama);
        if (parama != null)
        {
          paramString.PKo.setText(l.c(parama1.Pwc.getContext(), parama.title));
          Object localObject = new LinkedList();
          int i = 0;
          while ((i < parama.LLt.size()) && (i < 4))
          {
            cjl localcjl = new cjl();
            localcjl.url = ((String)parama.LLt.get(i));
            localcjl.url_token = ((String)parama.LLu.get(i));
            localcjl.thumb_url_token = localcjl.url_token;
            localcjl.thumbUrl = localcjl.url;
            ((List)localObject).add(localcjl);
            i += 1;
          }
          localObject = new b((List)localObject, false);
          paramString.PKp.setAdapter((FinderFeedAlbumView.a)localObject);
          ((b)localObject).wrh = new b.c()
          {
            public final void f(int paramAnonymousInt, View paramAnonymousView)
            {
              AppMethodBeat.i(233653);
              n.a(paramAnonymousView.getContext(), paramca, parama);
              AppMethodBeat.o(233653);
            }
          };
        }
        if (paramString.clickArea != null)
        {
          paramString.clickArea.setOnClickListener(d(parama1));
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
          parama = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
          paramString.clickArea.setTag(parama);
        }
      }
      if (gTW())
      {
        b(paramString, false);
        if ((paramca.field_status == 2) && (b((k)parama1.bh(k.class), paramca.field_msgId))) {
          if (paramString.tickIV != null) {
            paramString.tickIV.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        a(paramInt, paramString, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
        AppMethodBeat.o(233655);
        return;
        if (paramString.tickIV != null)
        {
          paramString.tickIV.setVisibility(8);
          continue;
          if (paramString.tickIV != null) {
            paramString.tickIV.setVisibility(8);
          }
          if (paramca.field_status < 2) {
            bool = true;
          }
          b(paramString, bool);
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(233658);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(233658);
      return false;
    }
    n.b(parama.Pwc.getContext(), paramca);
    AppMethodBeat.o(233658);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233657);
    int j = ((bq)paramView.getTag()).position;
    if (!((aj)g.ah(aj.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((paramca != null) && (i == 0))
      {
        paramm.a(j, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
        com.tencent.mm.br.c.aZU("favorite");
        if (((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
          paramm.a(j, 123, paramView.getContext().getString(2131757446), 2131690650);
        }
      }
      AppMethodBeat.o(233657);
      return true;
    }
  }
  
  public final void b(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(233656);
    if (paramca.dOQ())
    {
      com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
      bp.Ad(paramca.field_msgId);
      parama.BN(true);
    }
    AppMethodBeat.o(233656);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 956301361);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(233659);
    String str = paramca.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aD(str, paramca.field_reserved);
    }
    paramView = n.q(paramView);
    if (paramView != null) {
      n.a(parama.Pwc.getContext(), paramca, paramView);
    }
    AppMethodBeat.o(233659);
    return false;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.c
 * JD-Core Version:    0.7.0.1
 */