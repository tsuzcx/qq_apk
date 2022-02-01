package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.b.a.ll;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bs;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.e.a;

public final class bj$a
  extends c
{
  private a WBq;
  private bj.c Xlt;
  
  private bj.c di(ca paramca)
  {
    AppMethodBeat.i(287363);
    if (this.Xlt == null) {
      this.Xlt = new bj.c(this.WBq);
    }
    bj.c.a(this.Xlt, 0);
    if (bs.F(paramca)) {
      bj.c.a(this.Xlt, 2);
    }
    paramca = this.Xlt;
    AppMethodBeat.o(287363);
    return paramca;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37437);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.edr);
      ((View)localObject).setTag(new bj.d().J((View)localObject, true));
    }
    AppMethodBeat.o(37437);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37438);
    this.WBq = parama1;
    bj.d.a((bj.d)parama, paramca, true, paramInt, parama1, R.g.chat_img_template, di(paramca), c(parama1));
    AppMethodBeat.o(37438);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37440);
    ((aw)parama.bC(aw.class)).a(paramMenuItem, paramca);
    AppMethodBeat.o(37440);
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(287364);
    bh.beI();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      int i = ((by)paramView.getTag()).position;
      w localw = s.bqB().XN(paramca.field_imgPath);
      paramo.a(i, 130, paramView.getContext().getString(R.l.chatting_long_click_menu_mute_play), R.k.icons_filled_volume_off);
      if (!bs.O(paramca)) {
        paramo.a(i, 107, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (com.tencent.mm.by.c.blP("favorite")) {
        paramo.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      em localem = new em();
      localem.fAp.msgId = paramca.field_msgId;
      EventCenter.instance.publish(localem);
      if (localem.fAq.fzO) {
        paramo.a(i, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
      }
      if ((localw != null) && ((localw.status == 199) || (localw.status == 199)) && (g.biZ()) && (!this.WBq.hRj())) {
        paramo.add(i, 114, 0, paramView.getContext().getString(R.l.evJ));
      }
      if ((bs.D(paramca)) || (bs.G(paramca)))
      {
        paramo.clear();
        paramo.a(i, 130, paramView.getContext().getString(R.l.chatting_long_click_menu_mute_play), R.k.icons_filled_volume_off);
      }
      if (!this.WBq.hRj()) {
        paramo.a(i, 100, paramView.getContext().getString(R.l.evP), R.k.icons_filled_delete);
      }
      if (bs.F(paramca))
      {
        paramo = new ll();
        paramo.ghT = paramca.field_msgSvrId;
        paramo.gKR = paramca.getType();
        paramo.gQQ = bs.E(paramca);
        paramo.gef = 3L;
        paramo.bpa();
      }
    }
    AppMethodBeat.o(287364);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(37441);
    di(paramca).onClick(paramView);
    AppMethodBeat.o(37441);
    return true;
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.a
 * JD-Core Version:    0.7.0.1
 */