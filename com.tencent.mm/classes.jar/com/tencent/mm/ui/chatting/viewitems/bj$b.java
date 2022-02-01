package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class bj$b
  extends c
{
  private a WBq;
  private bj.c Xlt;
  
  private bj.c di(ca paramca)
  {
    AppMethodBeat.i(285527);
    if (this.Xlt == null) {
      this.Xlt = new bj.c(this.WBq);
    }
    bj.c.a(this.Xlt, 0);
    if (bs.F(paramca)) {
      bj.c.a(this.Xlt, 2);
    }
    paramca = this.Xlt;
    AppMethodBeat.o(285527);
    return paramca;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37443);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.eep);
      ((View)localObject).setTag(new bj.d().J((View)localObject, false));
    }
    AppMethodBeat.o(37443);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37444);
    this.WBq = parama1;
    parama = (bj.d)parama;
    bj.d.a(parama, paramca, false, paramInt, parama1, R.g.chat_img_template, di(paramca), c(parama1));
    if (hTG())
    {
      paramString = y.Yk(paramca.field_imgPath);
      if ((paramString != null) && (paramString.status == 199) && (b((k)parama1.bC(k.class), paramca.field_msgId)))
      {
        if (parama.XdI != null)
        {
          parama.XdI.setVisibility(0);
          AppMethodBeat.o(37444);
        }
      }
      else if (parama.XdI != null) {
        parama.XdI.setVisibility(8);
      }
    }
    AppMethodBeat.o(37444);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37446);
    ((aw)parama.bC(aw.class)).a(paramMenuItem, paramca);
    AppMethodBeat.o(37446);
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(285528);
    bh.beI();
    int i;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (paramView == null)
      {
        AppMethodBeat.o(285528);
        return false;
      }
      i = ((by)paramView.getTag()).position;
      w localw = s.bqB().XN(paramca.field_imgPath);
      Object localObject = paramo.a(i, 130, paramView.getContext().getString(R.l.chatting_long_click_menu_mute_play), R.k.icons_filled_volume_off);
      int j = paramView.getWidth();
      int k = paramView.getHeight();
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
      ((MenuItem)localObject).setIntent(localIntent);
      if (localw == null) {
        break label556;
      }
      j = localw.status;
      if ((104 != j) && (103 != j) && (105 != j) && (106 != j)) {
        paramo.a(i, 107, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if ((localw == null) || ((localw.status != 199) && (localw.status != 199))) {
        break label595;
      }
      if (com.tencent.mm.by.c.blP("favorite")) {
        paramo.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      localObject = new em();
      ((em)localObject).fAp.msgId = paramca.field_msgId;
      EventCenter.instance.publish((IEvent)localObject);
      if (((em)localObject).fAq.fzO) {
        paramo.a(i, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
      }
      if ((!paramca.hwA()) && ((paramca.dlR()) || (paramca.dlT())) && (b(paramca, this.WBq)) && ((localw.status == 199) || (localw.status == 199) || (paramca.ill == 1)) && (bzE(paramca.field_talker))) {
        paramo.a(i, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
      }
      if ((g.biZ()) && (!this.WBq.hRj())) {
        paramo.add(i, 114, 0, paramView.getContext().getString(R.l.evJ));
      }
    }
    for (;;)
    {
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
      AppMethodBeat.o(285528);
      return true;
      label556:
      if ((!paramca.dlS()) || (bs.O(paramca))) {
        break;
      }
      paramo.a(i, 107, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      break;
      label595:
      if ((paramca.dlS()) && (com.tencent.mm.by.c.blP("favorite"))) {
        paramo.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
    }
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(37447);
    di(paramca).onClick(paramView);
    AppMethodBeat.o(37447);
    return true;
  }
  
  public final boolean hTD()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.b
 * JD-Core Version:    0.7.0.1
 */