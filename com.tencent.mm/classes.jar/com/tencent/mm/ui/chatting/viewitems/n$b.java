package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a;
import com.tencent.mm.plugin.finder.view.adapter.b;
import com.tencent.mm.plugin.finder.view.adapter.b.c;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import java.util.LinkedList;
import java.util.List;

public final class n$b
  extends c
{
  private a PhN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(233648);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493531);
      ((View)localObject).setTag(new n.a().J((View)localObject, false));
    }
    AppMethodBeat.o(233648);
    return localObject;
  }
  
  public final void a(final c.a parama, int paramInt, a parama1, final ca paramca, String paramString)
  {
    AppMethodBeat.i(233649);
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
              AppMethodBeat.i(233647);
              n.a(paramAnonymousView.getContext(), paramca, parama);
              AppMethodBeat.o(233647);
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
      AppMethodBeat.o(233649);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(233651);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(233651);
      return false;
    }
    n.b(parama.Pwc.getContext(), paramca);
    AppMethodBeat.o(233651);
    return true;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233650);
    int j = ((bq)paramView.getTag()).position;
    if (!((aj)g.ah(aj.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((paramca != null) && (com.tencent.mm.br.c.aZU("favorite")) && (i == 0)) {
        paramm.a(j, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
      }
      AppMethodBeat.o(233650);
      return true;
    }
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 956301361);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(233652);
    String str = paramca.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aD(str, paramca.field_reserved);
    }
    paramView = n.q(paramView);
    if (paramView != null) {
      n.a(parama.Pwc.getContext(), paramca, paramView);
    }
    AppMethodBeat.o(233652);
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.b
 * JD-Core Version:    0.7.0.1
 */