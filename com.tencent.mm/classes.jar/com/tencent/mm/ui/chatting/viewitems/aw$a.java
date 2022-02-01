package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.an;

public final class aw$a
  extends c
{
  private aw.c GPG;
  private com.tencent.mm.ui.chatting.d.a Gob;
  
  private aw.c faS()
  {
    AppMethodBeat.i(37436);
    if (this.GPG == null) {
      this.GPG = new aw.c(this.Gob);
    }
    aw.c localc = this.GPG;
    AppMethodBeat.o(37436);
    return localc;
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
      localObject = new af(paramLayoutInflater, 2131493460);
      ((View)localObject).setTag(new aw.d().z((View)localObject, true));
    }
    AppMethodBeat.o(37437);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37438);
    this.Gob = parama1;
    aw.d.a((aw.d)parama, parambl, true, paramInt, parama1, faS(), c(parama1));
    AppMethodBeat.o(37438);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37439);
    az.arV();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      int i = ((bi)paramView.getTag()).position;
      s locals = o.aCI().zO(parambl.field_imgPath);
      paramContextMenu.add(i, 130, 0, paramView.getContext().getString(2131757227));
      paramContextMenu.add(i, 107, 0, paramView.getContext().getString(2131762559));
      if (d.axB("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
      }
      dx localdx = new dx();
      localdx.dgp.msgId = parambl.field_msgId;
      com.tencent.mm.sdk.b.a.ESL.l(localdx);
      if (localdx.dgq.dfO) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((locals != null) && ((locals.status == 199) || (locals.status == 199)) && (f.avG()) && (!this.Gob.eZc())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
      if (bk.x(parambl))
      {
        paramContextMenu.clear();
        paramContextMenu.add(i, 130, 0, paramView.getContext().getString(2131757227));
      }
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757222));
      }
    }
    AppMethodBeat.o(37439);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37440);
    ((an)parama.be(an.class)).a(paramMenuItem, parambl);
    AppMethodBeat.o(37440);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37441);
    faS().onClick(paramView);
    AppMethodBeat.o(37441);
    return true;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.a
 * JD-Core Version:    0.7.0.1
 */