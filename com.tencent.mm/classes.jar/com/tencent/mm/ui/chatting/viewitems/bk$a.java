package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
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
import com.tencent.mm.modelvideo.ae;
import com.tencent.mm.modelvideo.ae.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.component.api.be;
import com.tencent.mm.ui.chatting.d.a;

public final class bk$a
  extends c
{
  private bk.c aeWj;
  private a aeiK;
  
  private bk.c dI(cc paramcc)
  {
    AppMethodBeat.i(255392);
    if (this.aeWj == null) {
      this.aeWj = new bk.c(this.aeiK);
    }
    bk.c.a(this.aeWj, 0);
    if (bt.H(paramcc)) {
      bk.c.a(this.aeWj, 2);
    }
    paramcc = this.aeWj;
    AppMethodBeat.o(255392);
    return paramcc;
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
      localObject = new ap(paramLayoutInflater, R.i.ggh);
      ((View)localObject).setTag(new bk.d().P((View)localObject, true));
    }
    AppMethodBeat.o(37437);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37438);
    this.aeiK = parama1;
    bk.d.a((bk.d)parama, paramcc, true, paramInt, parama1, R.g.chat_img_template, dI(paramcc), c(parama1));
    AppMethodBeat.o(37438);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
  {
    AppMethodBeat.i(37440);
    ((be)parama.cm(be.class)).a(paramMenuItem, paramcc);
    AppMethodBeat.o(37440);
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255415);
    bh.bCz();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      int i = ((bz)paramView.getTag()).position;
      z localz = v.bOh().PR(paramcc.field_imgPath);
      params.a(i, 130, paramView.getContext().getString(R.l.chatting_long_click_menu_mute_play), R.k.icons_filled_volume_off);
      if ((!bt.Q(paramcc)) && (!bt.N(paramcc))) {
        params.a(i, 107, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (com.tencent.mm.br.c.blq("favorite")) {
        params.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      paramContextMenuInfo = new ex();
      paramContextMenuInfo.hFc.msgId = paramcc.field_msgId;
      paramContextMenuInfo.publish();
      if (paramContextMenuInfo.hFd.hEn) {
        params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
      }
      if ((localz != null) && ((localz.status == 199) || (localz.status == 199)) && (g.bGJ()) && (!this.aeiK.juH())) {
        params.add(i, 114, 0, paramView.getContext().getString(R.l.gyk));
      }
      if ((bt.F(paramcc)) || (bt.I(paramcc)))
      {
        params.clear();
        params.a(i, 130, paramView.getContext().getString(R.l.chatting_long_click_menu_mute_play), R.k.icons_filled_volume_off);
      }
      Object localObject = null;
      paramContextMenuInfo = localObject;
      if (ab.bOG())
      {
        paramContextMenuInfo = localObject;
        if (localz != null)
        {
          paramContextMenuInfo = ae.pbN;
          paramContextMenuInfo = ae.a.Qv(localz.bOu());
        }
      }
      if ((paramContextMenuInfo != null) && (paramContextMenuInfo.pbO)) {
        params.clear();
      }
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
    }
    AppMethodBeat.o(255415);
    return true;
  }
  
  public final boolean c(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(37441);
    dI(paramcc).onClick(paramView);
    AppMethodBeat.o(37441);
    return true;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bk.a
 * JD-Core Version:    0.7.0.1
 */