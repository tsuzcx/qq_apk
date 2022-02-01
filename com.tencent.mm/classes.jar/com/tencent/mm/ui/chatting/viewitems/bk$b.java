package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.ol;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.component.api.be;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.d.a;

public final class bk$b
  extends c
{
  private bk.c aeWj;
  private a aeiK;
  
  private bk.c dI(cc paramcc)
  {
    AppMethodBeat.i(255357);
    if (this.aeWj == null) {
      this.aeWj = new bk.c(this.aeiK);
    }
    bk.c.a(this.aeWj, 0);
    if (bt.H(paramcc)) {
      bk.c.a(this.aeWj, 2);
    }
    paramcc = this.aeWj;
    AppMethodBeat.o(255357);
    return paramcc;
  }
  
  private static boolean l(z paramz)
  {
    AppMethodBeat.i(255360);
    if (paramz == null)
    {
      AppMethodBeat.o(255360);
      return false;
    }
    if ((ab.bOG()) && ((paramz.status == 104) || (paramz.status == 105)))
    {
      AppMethodBeat.o(255360);
      return true;
    }
    AppMethodBeat.o(255360);
    return false;
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
      localObject = new ap(paramLayoutInflater, R.i.ghf);
      ((View)localObject).setTag(new bk.d().P((View)localObject, false));
    }
    AppMethodBeat.o(37443);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37444);
    this.aeiK = parama1;
    parama = (bk.d)parama;
    bk.d.a(parama, paramcc, false, paramInt, parama1, R.g.chat_img_template, dI(paramcc), c(parama1));
    if (jxj())
    {
      paramString = ab.Qo(paramcc.field_imgPath);
      if ((paramString != null) && (paramString.status == 199) && (b((m)parama1.cm(m.class), paramcc.field_msgId)))
      {
        if (parama.aeNG != null)
        {
          parama.aeNG.setVisibility(0);
          AppMethodBeat.o(37444);
        }
      }
      else if (parama.aeNG != null) {
        parama.aeNG.setVisibility(8);
      }
    }
    AppMethodBeat.o(37444);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
  {
    AppMethodBeat.i(37446);
    ((be)parama.cm(be.class)).a(paramMenuItem, paramcc);
    AppMethodBeat.o(37446);
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255384);
    bh.bCz();
    int i;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (paramView == null)
      {
        AppMethodBeat.o(255384);
        return false;
      }
      i = ((bz)paramView.getTag()).position;
      paramContextMenuInfo = v.bOh().PR(paramcc.field_imgPath);
      Object localObject = params.a(i, 130, paramView.getContext().getString(R.l.chatting_long_click_menu_mute_play), R.k.icons_filled_volume_off);
      int j = paramView.getWidth();
      int k = paramView.getHeight();
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
      ((MenuItem)localObject).setIntent(localIntent);
      if (paramContextMenuInfo == null) {
        break label587;
      }
      j = paramContextMenuInfo.status;
      if ((104 != j) && (103 != j) && (105 != j) && (106 != j) && (!bt.N(paramcc)) && (!bt.Q(paramcc))) {
        params.a(i, 107, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if ((paramContextMenuInfo == null) || ((paramContextMenuInfo.status != 199) && (paramContextMenuInfo.status != 199) && (!l(paramContextMenuInfo)))) {
        break label636;
      }
      if (com.tencent.mm.br.c.blq("favorite")) {
        params.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      localObject = new ex();
      ((ex)localObject).hFc.msgId = paramcc.field_msgId;
      ((ex)localObject).publish();
      if (((ex)localObject).hFd.hEn) {
        params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
      }
      if ((!paramcc.iYe()) && ((paramcc.dSH()) || (paramcc.dSJ())) && (c(paramcc, this.aeiK)) && ((paramContextMenuInfo.status == 199) || (l(paramContextMenuInfo)) || (paramContextMenuInfo.status == 199) || (paramcc.kLk == 1)) && (bBs(paramcc.field_talker))) {
        params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
      }
      if ((g.bGJ()) && (!this.aeiK.juH())) {
        params.add(i, 114, 0, paramView.getContext().getString(R.l.gyk));
      }
    }
    for (;;)
    {
      if (!this.aeiK.juH()) {
        params.a(i, 100, paramView.getContext().getString(R.l.gyp), R.k.icons_filled_delete);
      }
      if (bt.H(paramcc))
      {
        params = new ol();
        params.inO = paramcc.field_msgSvrId;
        params.iUM = paramcc.getType();
        params.jjm = bt.G(paramcc);
        params.ikE = 3L;
        params.bMH();
      }
      AppMethodBeat.o(255384);
      return true;
      label587:
      if ((!paramcc.dSI()) || (bt.Q(paramcc)) || (bt.N(paramcc))) {
        break;
      }
      params.a(i, 107, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      break;
      label636:
      if ((paramcc.dSI()) && (com.tencent.mm.br.c.blq("favorite"))) {
        params.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
    }
  }
  
  public final boolean c(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(37447);
    dI(paramcc).onClick(paramView);
    AppMethodBeat.o(37447);
    return true;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bk.b
 * JD-Core Version:    0.7.0.1
 */